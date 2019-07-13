package org.code.lucky.enums;

public enum County
{
	China("0001"), American("0002"), Hongkong("0003");

	private String code;

	private County(String code) {
		this.code = code;
	}

	public String getCode()
	{
		return this.code;
	}
	
	
}
