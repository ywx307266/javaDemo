package org.code.lucky.exceptionhandle;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestExcepHandler
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorResult BindExcepProcess(MethodArgumentNotValidException exp)
	{
		ErrorResult result = new ErrorResult();

		BindingResult bindingResult = exp.getBindingResult();
		if (bindingResult.hasErrors())
		{
			List<FieldError> list = bindingResult.getFieldErrors();
			list.forEach(p -> result.getErrorMessage().add(p.getDefaultMessage()));
		}
		result.setResult("failed");
		return result;
	}
}
