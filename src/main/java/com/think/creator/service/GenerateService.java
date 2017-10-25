/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年10月14日	| lipengfeia 	| 	create the file                       
 */

package com.think.creator.service;

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

public interface GenerateService {

	/**
	 * 生成随机序列
	 * 
	 * @return
	 */
	public String createRandId();

	/**
	 * 生成有序序列
	 * 
	 * @return
	 */
	public String createOrderlyId();

}
