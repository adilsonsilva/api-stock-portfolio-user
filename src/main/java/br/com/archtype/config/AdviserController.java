package br.com.archtype.config;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.archtype.exception.InsertUserException;
import br.com.archtype.model.entity.APIError;

@ControllerAdvice
public class AdviserController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<APIError> handleNotFoundException(
    		EmptyResultDataAccessException ex, HttpServletRequest request) {

		APIError response = APIError.builder()
				.error(ex.getMessage())
				.path(request.getRequestURI())
				.message(HttpStatus.NOT_FOUND.name())
				.statusCode(HttpStatus.NOT_FOUND.value())
				.timestamp(LocalDateTime.now())
				.build();
		
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<APIError> handleNotFoundException(
    		Exception ex, HttpServletRequest request) {

		APIError response = APIError.builder()
				.error(ex.getMessage())
				.path(request.getRequestURI())
				.message(HttpStatus.INTERNAL_SERVER_ERROR.name())
				.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.timestamp(LocalDateTime.now())
				.build();
		
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

	
	@ExceptionHandler(InsertUserException.class)
    public ResponseEntity<APIError> handleInsertUserException(
    		Exception ex, HttpServletRequest request) {

		APIError response = APIError.builder()
				.error(ex.getMessage())
				.path(request.getRequestURI())
				.message(HttpStatus.INTERNAL_SERVER_ERROR.name())
				.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.timestamp(LocalDateTime.now())
				.build();
		
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
}
