package org.scoula.exception;

import lombok.extern.slf4j.Slf4j;
import org.scoula.member.exception.PasswordMissmatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class ApiExceptionAdvice {
//    @ExceptionHandler(PasswordMissmatchException.class)
//    public ResponseEntity<?> HandlePasswordError(Exception ex) {
//        return ResponseEntity.status(400)
//                .header(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8")
//                .body(ex.getMessage());
//    }
//
//    @ExceptionHandler(PasswordMissmatchException.class)
//    public ResponseEntity<?> HandleError(Exception ex) {
//        log.error(ex.getMessage());
//        return ResponseEntity.status(500)
//                .header(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8")
//                .body(ex.getMessage());
//    }

    // 404 에러
    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<String> handleIllegalArgumentException(NoSuchElementException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("Content-Type", "text/plain;charset=UTF-8")
                .body("해당 ID의 요소가 없습니다.");
    }
    // 500 에러
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("Content-Type", "text/plain;charset=UTF-8")
                .body(e.getMessage());
    }
}
