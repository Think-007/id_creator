/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年10月14日	| lipengfeia 	| 	create the file                       
 */

package com.think.creator.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.think.creator.service.GenerateService;
import com.think.creator.util.IdCreatorConst;
import com.think.creator.util.TransIdCreatorUtils;

/**
 * 
 * 类简要描述
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author lipengfeia
 * 
 */
@Service
public class GenerateServiceImpl implements GenerateService {

	// 随机序列
	private static SimpleDateFormat rand_sdf = new SimpleDateFormat("yyyyMMdd");
	private static double randNumLength = 1000000000;
	// 缓存上一个num值，进行累加
	public static final Map<String, Double> rand_map = new HashMap<String, Double>();

	// 顺序序列
	private static SimpleDateFormat orderly_sdf = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	private static double orderlyNumLength = 10000000;
	// 缓存上一个num值，进行累加
	public static final Map<String, Double> orderly_map = new HashMap<String, Double>();

	private Log logger = LogFactory.getLog(GenerateServiceImpl.class);

	@Override
	public String createRandId() {

		// 日期+循环增长序列+随机数+服务节点号
		// 20171012 000000000 111333 5
		Date date = Calendar.getInstance().getTime();
		String dateStr = rand_sdf.format(date);
		logger.debug("dateStr : " + dateStr);

		// 生成自增9位序列
		String numStr = null;
		double curNum = 0;
		synchronized (this) {
			double lastNum = 0;

			if (orderly_map.get(IdCreatorConst.RAND_NUM) == null) {
				lastNum = -1;
			} else {
				lastNum = orderly_map.get(IdCreatorConst.RAND_NUM);
			}
			lastNum++;
			curNum = lastNum % randNumLength;
			orderly_map.put(IdCreatorConst.RAND_NUM, curNum);

		}
		numStr = TransIdCreatorUtils.makeupZero(curNum, 9);
		logger.debug("orderlynumStr : " + numStr);

		// 生成6位随机数
		int randNum = (int) (Math.random() * 1000000);
		String randNumStr = TransIdCreatorUtils.makeupZero(randNum, 6);
		logger.debug("randomStr : " + randNumStr);

		// 拼接最终字符串
		String finalStr = dateStr + numStr + randNumStr + 5;
		logger.debug("finalStr : " + finalStr);

		return finalStr;
	}

	@Override
	public String createOrderlyId() {

		// 日期+循环增长序列
		// 20171012121314 0000000
		Date date = Calendar.getInstance().getTime();
		String dateStr = orderly_sdf.format(date);
		logger.debug("dateStr : " + dateStr);

		// 生成6位自增序列
		String numStr = null;
		double curNum = 0;
		// 避免和上面的锁冲突,影响性能
		synchronized (this.getClass()) {
			double lastNum = 0;

			if (orderly_map.get(IdCreatorConst.ORDERLY_NUM) == null) {
				lastNum = -1;
			} else {
				lastNum = orderly_map.get(IdCreatorConst.ORDERLY_NUM);
			}
			lastNum++;
			curNum = lastNum % orderlyNumLength;
			orderly_map.put(IdCreatorConst.ORDERLY_NUM, curNum);

		}
		numStr = TransIdCreatorUtils.makeupZero(curNum, 6);
		logger.debug("orderlynumStr : " + numStr);

		// 拼接最终字符串
		String finalStr = dateStr + numStr;
		logger.debug("finalStr : " + finalStr);

		return finalStr;
	}

	public static void main(String[] args) {
		GenerateServiceImpl s = new GenerateServiceImpl();
		System.out.println(s.createRandId());
		System.out.println(s.createOrderlyId());

	}

}
