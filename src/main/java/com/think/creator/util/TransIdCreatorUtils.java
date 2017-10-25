/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年1月3日	| lipengfeia 	| 	create the file                       
 */

package com.think.creator.util;

import java.text.DecimalFormat;

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

public class TransIdCreatorUtils {

	/**
	 * 补零
	 * 
	 * @param sequence
	 * @param count
	 * @return
	 */
	public static String makeupZero(double sequence, int count) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < count; i++) {
			buf.append("0");
		}
		DecimalFormat df = new DecimalFormat(buf.toString());
		return df.format(sequence);
	}

	// /**
	// *
	// *
	// * @param sdf
	// * 格式化系统时间最后两位
	// * @param sequence
	// * 序列的最大值
	// * @param timeLength
	// * 时间的位数
	// * @return
	// */
	// public static String nextSequence(JedisCluster jedisCluster,
	// TransIdInfo transIdInfo) {
	//
	// // String result = null;
	// // int appId = transIdInfo.getAppID();
	// // int timeLength = transIdInfo.getTimeLength();
	// // String nodeId = "" + (int) (Math.random() *
	// // transIdInfo.getNodeIdNum());
	// // // 获取该nodeID的上一次的transid值
	// // String id = jedisCluster.get(TransIdCreatorConst.PROJECT_FLAG + appId
	// // + nodeId);
	// // long sequenceId = 0;
	// //
	// // if (id == null) {
	// // sequenceId = 0;
	// // } else {
	// // String timeTail = id.substring(timeLength, timeLength + 2);
	// // sequenceId = Integer.parseInt(id.substring(timeLength + 2,
	// // timeLength + 2 + (sequence + "").length()));
	// // String systemTimeTail = sdf.format(new Date());
	// // if (timeTail == systemTimeTail && sequenceId == sequence) {
	// // try {
	// // // 停顿10毫秒进入下一秒防止id一秒内重复
	// // Thread.sleep(10);
	// // nextRandom(jedisCluster, transIdInfo, sdf, sequence);
	// // } catch (InterruptedException e) {
	// // e.printStackTrace();
	// // }
	// // }
	// // sequenceId = sequenceId % sequence + 1;
	// // }
	// //
	// // result = sequenceId + nodeId;
	// //
	// // return result;
	//
	// String result = null;
	// int appId = transIdInfo.getAppID();
	// int timeLength = transIdInfo.getTimeLength();
	// long maxSeqVal = transIdInfo.getMaxSequenceValue();
	// SimpleDateFormat sdf = transIdInfo.getSimpleDateFormat();
	// String nodeId = "" + (int) (Math.random() * transIdInfo.getNodeIdNum());
	// // 获取该nodeID的上一次的transid值
	// String lastId = jedisCluster.get(TransIdCreatorConst.PROJECT_FLAG
	// + appId + nodeId);
	// long sequence = 0;
	// if (lastId == null) {
	// sequence = 0;
	// } else {
	// String lastTimeTail = lastId.substring(timeLength, timeLength + 2);
	// sequence = Integer.parseInt(lastId.substring(timeLength + 2,
	// timeLength + 2 + (maxSeqVal + "").length()));
	// String systemTimeTail = sdf.format(new Date());
	// if (lastTimeTail == systemTimeTail && sequence == maxSeqVal) {
	// try {
	// // 停顿10毫秒进入下一秒防止id一秒内重复
	// Thread.sleep(10);
	// nextSequence(jedisCluster, transIdInfo);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	// sequence = sequence % maxSeqVal + 1;
	// }
	// result = sequence + nodeId;
	// return result;
	//
	// }
	//
	// /**
	// * 生成序列值
	// *
	// * @param transIdInfo
	// * @param node
	// * @return
	// */
	// public static Long[] nextSequenceNoRep(TransIdInfo transIdInfo) {
	//
	// Long[] result = new Long[2];
	// int appId = transIdInfo.getAppID();
	// long maxSeqVal = transIdInfo.getMaxSequenceValue();
	// SimpleDateFormat sdf = transIdInfo.getSimpleDateFormat();
	//
	// Calendar calendar = Calendar.getInstance();
	//
	// // 上次的id的时间
	// Long lastTimeTail = null;
	// // 系统当前时间
	// Long systemTimeTail = Long.parseLong(sdf.format(calendar.getTime()));
	//
	// // 获取上一次的transid的时间和序列值数组
	// Long[] lastTimeAndSequence = GenerateTransIdFacadeImpl.cacheMap
	// .get(TransIdCreatorConst.PROJECT_FLAG + appId);
	// long sequence = 0;
	// if (lastTimeAndSequence == null) {
	// sequence = 0;
	// } else {
	// lastTimeTail = lastTimeAndSequence[0];
	// sequence = lastTimeAndSequence[1];
	//
	// // if (lastTimeTail == systemTimeTail && sequence == maxSeqVal) {
	// // try {
	// // // 停顿10毫秒进入下一秒防止id一秒内重复
	// // Thread.sleep(10);
	// // nextSequenceNoRep(transIdInfo, node);
	// // } catch (InterruptedException e) {
	// // e.printStackTrace();
	// // }
	// //
	// // }
	//
	// if (lastTimeTail == systemTimeTail) {
	//
	// // 如果同一秒内出现了序列最大值就把时间加一秒
	// if (sequence == maxSeqVal) {
	// calendar.add(Calendar.SECOND, 1);
	// systemTimeTail = Long.parseLong(sdf.format(calendar
	// .getTime()));
	// }
	//
	// // 如果上一次时间大于系统当前时间，就用上一次的时间
	// } else if (lastTimeTail > systemTimeTail) {
	// systemTimeTail = lastTimeTail;
	// }
	// // 如果上一次的时间小于当前系统时间就用当前系统时间
	// // else {
	// //
	// // }
	//
	// sequence = (sequence + 1) % (maxSeqVal + 1);
	// }
	//
	// result[0] = systemTimeTail;
	// result[1] = sequence;
	// return result;
	// }
}
