package xyz.casualcookie.ponyslayer.util;

import java.util.LinkedList;
import java.util.List;

import org.springframework.validation.Errors;

/**
 * Outputs the errors of forms as json.
 * Internaly converted, public properties hierarchy are output as json.
 */
public class JsonErrors {
	public List<ErrorNode> errors;
	
	public JsonErrors(Errors errors){
		this.errors=new LinkedList<>();
		errors.getFieldErrors().forEach((err->this.errors.add(
				new ErrorNode(err.getField(),err.getDefaultMessage()))));
	}
	
	public class ErrorNode{
		public String message;
		public String field;
		
		public ErrorNode(String objectName, String defaultMessage) {
			this.field=objectName;
			this.message=defaultMessage;
		}
	}

}
