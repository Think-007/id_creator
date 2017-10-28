/*      						
 * Copyright 2012 LPF  All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年10月26日	| LPF 	| 	create the file                       
 */

package com.think.creator.domain;

import java.util.Map;

/**
 * 
 * 类简要描述
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author LPF
 * 
 */

public class ProcessResult {

	// 成功
	public static final int SUCCESS = 0;
	// 失败
	public static final int FAILED = 1;
	// 超时
	public static final int TIME_OUT = 2;

	// 调用结果状态 -1默认 0成功 1失败 2 超时
	private int retCode = -1;
	// 调用结果描述
	private String retMsg;
	// 返回对象信息
	private Object retObj;
	// 返回附加信息
	private Map retMap;

	// 失败后的返回失败码
	private int errorCode;
	// 失败描述
	private String errorDesc;
	public int getRetCode() {
		return retCode;
	}
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	public Object getRetObj() {
		return retObj;
	}
	public void setRetObj(Object retObj) {
		this.retObj = retObj;
	}
	public Map getRetMap() {
		return retMap;
	}
	public void setRetMap(Map retMap) {
		this.retMap = retMap;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	@Override
	public String toString() {
		return "ProcessResult [retCode=" + retCode + ", retMsg=" + retMsg + ", retObj=" + retObj + ", retMap=" + retMap
				+ ", errorCode=" + errorCode + ", errorDesc=" + errorDesc + "]";
	}

	

}
