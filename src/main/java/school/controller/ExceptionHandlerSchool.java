package school.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice(basePackages = "school")
public class ExceptionHandlerSchool {

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseErrorModel handler(HttpServletRequest servletRequest, Exception e) {
        log.error(
                "Исключение при вызове url - " + servletRequest.getRequestURI()
                        + ". " + e.getMessage(),
                e);
        return ResponseErrorModel.builder()
                    .code(-1)
                    .message(e.getMessage())
                    .uri(servletRequest.getRequestURI())
                .build();
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ResponseErrorModel handlerBaseException(
            HttpServletRequest servletRequest,
            RuntimeException e) {
        log.error(
                "Исключение при вызове url - " + servletRequest.getRequestURI() +
                        ". " + e.getMessage(),
                e);
        return ResponseErrorModel.builder()
                    .code(-100)
                    .message(e.getMessage())
                    .uri(servletRequest.getRequestURI())
                .build();
    }
}