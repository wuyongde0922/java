package com.htbb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.htbb.base.PropertiesConfig;
import com.htbb.base.ReturnBean;


@RestController
@RequestMapping("/test")
public class TestController {

	/** 日志实例 */
	private static final Logger logger = Logger.getLogger(TestController.class);
	
	@Value("${csdn_username}")
    private String username;

    @Value("${csdn_password}")
    private String password;
	
    @GetMapping("/hello")
    public String helloworld() {
        return "helloworld";
    }
    
	@RequestMapping(value = "/a", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<ReturnBean> testA(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", required = false) String page) {
		logger.info("======testA接口==========");
		return new ResponseEntity<ReturnBean>(new ReturnBean("testA接口"), HttpStatus.OK);
	}
	
	/**
	 * 通过value注入
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/valueProperties", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<ReturnBean> valueProperties(HttpServletRequest request, HttpServletResponse response){
		logger.info("======valueProperties接口==========");
		return new ResponseEntity<ReturnBean>(new ReturnBean("username="+username+",password="+password), HttpStatus.OK);
	}
	
	/**
	 * 通过属性文件读取
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/readProperties", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<ReturnBean> readProperties(HttpServletRequest request, HttpServletResponse response){
		logger.info("======readProperties接口==========");
		return new ResponseEntity<ReturnBean>(new ReturnBean("WX_APPID="+PropertiesConfig.WX_APPID+",WX_APPSECRET="+PropertiesConfig.WX_APPSECRET), HttpStatus.OK);
	}
	
	
    
}






