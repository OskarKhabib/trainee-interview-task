package khabibullin.interviewtask.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import khabibullin.interviewtask.exception.JsonException;
import khabibullin.interviewtask.response.Response;

@ControllerAdvice
public class JsonAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JsonException.class)
    public ResponseEntity<Response> handleException(JsonException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable
            (HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Response response = new Response("Json exception", ex.getMessage());
        return new ResponseEntity<>(response, status);
    }
}
