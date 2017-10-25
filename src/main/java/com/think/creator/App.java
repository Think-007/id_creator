/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2017年10月14日	| lipengfeia 	| 	create the file                       
 */

package com.think.creator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

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
@SpringBootApplication
@ImportResource({ "classpath:hessian/hessian-server.xml" })
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);

	}

}
