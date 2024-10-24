package edu.iuhs.crm.exception;

import edu.iuhs.crm.modle.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    ResponseEntity<ErrorResponse> handleIllegalStateException(CustomNotFoundException ex){
        ErrorResponse build = ErrorResponse.builder()
                .errorMessage(ex.getMessage()).status("See Other").build();

        return  ResponseEntity.ok().body(build);
    }
    @ExceptionHandler(CustomNotDeleteStudentIdExeption.class)
    ResponseEntity<ErrorResponse> handleIllegalStateException(CustomNotDeleteStudentIdExeption ex){
        ErrorResponse build = ErrorResponse.builder()
                .errorMessage(ex.getMessage()).status("No Content").build();

        return  ResponseEntity.ok().body(build);
    }

    @ExceptionHandler(CustomNotFoundStudentsExceptionHandler.class)
        ResponseEntity<ErrorResponse> handleIllegalStateException(CustomNotFoundStudentsExceptionHandler ex){
            ErrorResponse build = ErrorResponse.builder()
                    .errorMessage(ex.getMessage()).status("Permanent Redirect").build();

            return  ResponseEntity.ok().body(build);
    }

}
