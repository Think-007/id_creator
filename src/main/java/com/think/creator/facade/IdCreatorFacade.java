/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年10月14日	| lipengfeia 	| 	create the file                       
 */

package com.think.creator.facade;

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

public interface IdCreatorFacade {

	/**
	 * 对外公布的申请随机序列的hessian接口
	 * 
	 * @return
	 */
	public String generateRandID();

	/**
	 * 对外公布的申请顺序序列的hessian接口
	 * 
	 * @return
	 */
	public String generateOrderlyID();

}
