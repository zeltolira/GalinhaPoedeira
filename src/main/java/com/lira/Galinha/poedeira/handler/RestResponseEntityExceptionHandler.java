package com.lira.Galinha.poedeira.handler;


import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class RestResponseEntityExceptionHandler {
	@ExceptionHandler(APIException.class)
	public ResponseEntity<ErrorApiResponse> handlerGenericExcepetion(APIException  ex){
		return ex.buildErrorReponseEntity();
	}
		@ExceptionHandler(Exception.class)
		public ResponseEntity<ErrorApiResponse> handlerGenericExcepetion(Exception  ex){
		log.error("Exception: ", ex);
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ErrorApiResponse.builder()
						.description("INTERNAL_SERVER_ERROR")
						.message("POR FAVOR INFORME AO ADMINISTRADOR DO SISTEMA!")
						.build());	
	}
}
