/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年10月14日	| lipengfeia 	| 	create the file                       
 */

package com.think.creator.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.think.creator.service.GenerateService;

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
@RestController
@RequestMapping("/id")
public class GenerateIdController {

	private Log logger = LogFactory.getLog(GenerateIdController.class);

	@Resource
	private GenerateService generateService;

	@RequestMapping(value = ("/rand"), method = RequestMethod.GET)
	public String generateRandId() {
		logger.debug("enter rand...");

		String transID = generateService.createRandId();

		logger.debug("finish rand...");
		return transID;

	}

	@RequestMapping(value = ("/orderly"), method = RequestMethod.GET)
	public String generateOrderlyId() {
		logger.debug("enter orderly..");

		String transID = generateService.createOrderlyId();

		logger.debug("finish orderly...");
		return transID;

	}

}
