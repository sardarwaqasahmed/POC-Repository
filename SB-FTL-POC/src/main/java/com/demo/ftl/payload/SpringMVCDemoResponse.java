package com.demo.ftl.payload;
/*
@ Author	: Sardar Waqas Ahmed
@ Date 		: 8 Dec 2018
@ Version	: 1.0
@ Company	: NONE
@
*/
public class SpringMVCDemoResponse {

	private Data data;
	private Attributes attributesTitle;
	
	public SpringMVCDemoResponse(Data data, Attributes attributesTitle) {
		super();
		this.data = data;
		this.attributesTitle = attributesTitle;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public Attributes getAttributesTitle() {
		return attributesTitle;
	}
	public void setAttributesTitle(Attributes attributesTitle) {
		this.attributesTitle = attributesTitle;
	}
	@Override
	public String toString() {
		return "DemoResponse [data=" + data + ", attributesTitle=" + attributesTitle + "]";
	}	
	
}
