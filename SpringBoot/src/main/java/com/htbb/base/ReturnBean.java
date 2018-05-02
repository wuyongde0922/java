package com.htbb.base;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
* @author denghui   
* @date 2016年10月11日 下午2:00:19 
* @ClassName: ReturnBean 
* @Description: 提供接口，返回数据（返回数据，返回）
 */
@XmlRootElement(name = "returnData")
public class ReturnBean {
	
	private int errCode = 0;
	private String resultMsg = EnumResultCode.SUCCESS.getValue();
	private Object resultData;
	
	/**
	 * add by wangzhicheng
	 * @param errCode
	 */
	public ReturnBean(int errCode){
		if(errCode == 0){
			this.resultMsg=EnumResultCode.SUCCESS.getValue();
		}else{
			this.resultMsg=EnumResultCode.FAIL.getValue();
		}
		this.errCode = errCode;
	}
	
	public ReturnBean(int errCode,String resultMsg){
		if(errCode == 0){
			this.resultMsg=EnumResultCode.SUCCESS.getValue();
		}else{
			this.resultMsg=resultMsg;
		}
		this.errCode = errCode;
	}
	
	public ReturnBean(Object resultData){
		this.errCode = 0;
		this.resultData = resultData;
	}
	
	public ReturnBean(){}
	
	@XmlElement
	public Object getResultData() {
		return resultData;
	}
	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
	
	public void setErrCode(int errCode) {
		if(errCode == 0){
			this.resultMsg=EnumResultCode.SUCCESS.getValue();
		}else{
			this.resultMsg=EnumResultCode.FAIL.getValue();
		}
		this.errCode = errCode;
	}
	
	@XmlElement
	public int getErrCode() {
		return errCode;
	}

	@XmlElement
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	

	public void getInstace(ReturnBean returnBean){
		if(null!=returnBean)
		returnBean=new ReturnBean();
	}
	
	public void setDefault(){
		this.setErrCode(0);
		this.resultData = null;
	}

}
