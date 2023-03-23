package med.voll.api.controller.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    private ResponseEntity<ResponseException> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        ResponseException resp = ResponseException
                .builder()
                .code(exception.getStatusCode()
                        .value()).message(exception.getDetailMessageArguments()[1]).build();
        return ResponseEntity.status(exception.getStatusCode().value()).body(resp);
    }
}
