package org.code.lucky.exceptionhandle;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ErrorResult
{
	private List<String>	errorMessage=new ArrayList<String>();

	private String			errorCode;

	private String			result;
}
