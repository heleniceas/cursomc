package com.helenice.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

		private static final long serialVersionUID = 1L;
		
		private List<FieldMessage> erros = new ArrayList<>();

		public List<FieldMessage> getList() {
			return erros;
		}

		public void addError(String fieldName, String message) {
			erros.add( new FieldMessage( fieldName,  message) );
		}

		public ValidationError(Integer status, String msg, Long timeStampp) {
			super(status, msg, timeStampp);
		}

		public List<FieldMessage> getErros() {
			return erros;
		}

		public void setErros(List<FieldMessage> erros) {
			this.erros = erros;
		}
		
		
		

}
