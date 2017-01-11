package com.sut.util.meta;

public enum EnableEnum {
	
	ENABLE("1", "enable"), DISABLE("2", "disable");
	
	String key;
	String value;
	EnableEnum(String key, String value){
		this.key = key;
		this.value = value;
	}
}
