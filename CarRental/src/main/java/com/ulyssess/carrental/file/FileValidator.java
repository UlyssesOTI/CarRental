package com.ulyssess.carrental.file;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class FileValidator implements Validator {
	public boolean supports(Class<?> paramClass) {
		return FileClass.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		FileClass file = (FileClass) obj;
		  if (file.getFile().getSize() == 0) {
		   errors.rejectValue("file", "valid.file");
		  }
	}
}