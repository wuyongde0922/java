package com.htbb.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "config.properties")
public class PropertiesConfig {

    public String wx_appid;
    public String wx_appsecret;
    
    public static String WX_APPID;
    public static String WX_APPSECRET;
    
    @Value("${wx_appid}")
	public void setWx_appid(String wx_appid) {
		PropertiesConfig.WX_APPID = wx_appid;
	}
    
    @Value("${wx_appsecret}")
	public void setWx_appsecret(String wx_appsecret) {
		PropertiesConfig.WX_APPSECRET = wx_appsecret;
	}
    
    
    
}