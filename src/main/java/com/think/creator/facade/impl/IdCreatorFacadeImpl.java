/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年10月14日	| lipengfeia 	| 	create the file                       
 */

package com.think.creator.facade.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.think.creator.facade.IdCreatorFacade;
import com.think.creator.service.GenerateService;
import com.think.creator.service.impl.GenerateServiceImpl;

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
public class IdCreatorFacadeImpl implements IdCreatorFacade {
	@Resource
	private GenerateService generateService;

	private Log logger = LogFactory.getLog(GenerateServiceImpl.class);

	@Override
	public String generateRandID() {

		String randID = null;
		try {
			generateService.createRandId();

		} catch (Throwable t) {
			logger.error("generateRandID", t);
		}

		return randID;
	}

	@Override
	public String generateOrderlyID() {

		String orderlyID = null;
		try {
			orderlyID = generateService.createOrderlyId();
		} catch (Throwable t) {
			logger.error("generateOrderlyID", t);
		}

		return orderlyID;
	}

}
