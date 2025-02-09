package mrp.aplication.exceptions.handler;


import mrp.aplication.exceptions.ExceptionResp;
import mrp.aplication.exceptions.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice// concentrar algum tratamento para todos controller (global)
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class) //tratamento de exceção generica
    public final ResponseEntity<ExceptionResp> handleAllExecptions(
            Exception ex,
            WebRequest request
    ) {
        ExceptionResp exceptionResp = new ExceptionResp(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResp, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class) //tratamento de exceção especifico
    public final ResponseEntity<ExceptionResp> handleBadRequestException(
            Exception ex,
            WebRequest request
    ) {
        ExceptionResp exceptionResp = new ExceptionResp(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResp, HttpStatus.BAD_REQUEST);
    }
}
