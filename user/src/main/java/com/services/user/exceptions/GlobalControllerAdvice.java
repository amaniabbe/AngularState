package com.services.user.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler
{
    private static final Logger logger = LoggerFactory.getLogger(GlobalControllerAdvice.class);

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Problem> handleInternalError(final Throwable e)
    {
        String message = e.getMessage();
        UUID uuid = UUID.randomUUID();
		String logRef=uuid.toString();
		logger.error("logRef="+logRef, message, e);
		return new ResponseEntity <Problem> (new Problem(logRef, message), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handleNotFoundException(IllegalArgumentException ex)
    {
        
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }



}
