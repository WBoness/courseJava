package model.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private Map <String,String> errors = new HashMap<>(); // primeiro string indica nome do campo e o segundo, mensagem de erro
	
	//forçar a instanciação da exceção com uma string
	public ValidationException(String msg) {// carregar as mensagens e erros do formulário, caso existam
		super(msg);
	}
	
	public  Map <String,String> getErrors(){
		return errors;
	}
	
	// adiciona erro na coleção
	public void addError(String fieldname, String errorMessage) {
		errors.put(fieldname, errorMessage);
	}
}
