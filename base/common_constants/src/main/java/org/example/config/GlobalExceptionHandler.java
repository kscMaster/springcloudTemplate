package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.example.enums.ErrorCode;
import org.example.enums.IErrorCode;
import org.example.exception.ServiceException;
import org.example.resp.Resp;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Resp<Boolean> serviceExceptionHandler(HttpServletRequest req, ServiceException e) {
        log.error("[ServiceException]", e);
        log.error("发生业务异常！原因是：{}", e.getMessage());
        IErrorCode code = e.getCode();
        return Resp.<Boolean>builder()
                .code(code.code())
                .msg(e.getMessage())
                .build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Resp<Boolean> httpMessageNotReadableExceptionHandler(HttpServletRequest req, Exception e) {
        log.error("[HttpMessageNotReadableException]", e);
        log.error("发生参数异常！原因是：{}", e.getMessage());
        return Resp.<Boolean>builder()
                .code(ErrorCode.E_10.code())
                .msg("数据格式输入有误")
                .data(false)
                .build();
    }

//    @ExceptionHandler(PropertyReferenceException.class)
//    public Resp<Boolean> propertyReferenceExceptionExceptionHandler(HttpServletRequest req, Exception e) {
//        log.error("[PropertyReferenceException]", e);
//        log.error("发生参数异常！原因是：{}", e.getMessage());
//        return Resp.<Boolean>builder()
//                .code(ErrorCode.E_10.code())
//                .msg("数据格式输入有误")
//                .data(false)
//                .build();
//    }
//
//    @ExceptionHandler(value = InvalidDataAccessApiUsageException.class)
//    public Resp<Boolean> invalidDataAccessApiUsageExceptionHandler(HttpServletRequest req, InvalidDataAccessApiUsageException e) {
//        log.error("[InvalidDataAccessApiUsageException]", e);
//        log.error("发生查询参数异常！原因是：{}", e.getMessage());
//        return Resp.<Boolean>builder()
//                .code(ErrorCode.ERROR.code())
//                .msg("无效的参数")
//                .build();
//    }
//
//    @ExceptionHandler(value = ConstraintViolationException.class)
//    public Resp<Boolean> constraintViolationExceptionHandler(HttpServletRequest req, ConstraintViolationException e) {
//        log.error("[constraintViolationExceptionHandler]", e);
//        return Resp.<Boolean>formConstraintViolationException(e);
//    }
//
//    @ExceptionHandler(value = BindException.class)
//    public Resp<Boolean> bindExceptionHandler(HttpServletRequest req, BindException e) {
//        log.error("[BindException]", e);
//        log.error("验证失败：{}", e.getAllErrors());
//        return Resp.<Boolean>formBindException(e);
//    }
//
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public Resp<Object> methodArgumentNotValidExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e) {
//        log.error("[MethodArgumentNotValidException]", e);
//        log.error("验证失败：{}", e);
//        return Resp.<Object>formMethodArgumentNotValidException(e);
//    }

    @ExceptionHandler(value = Exception.class)
    public Resp<Boolean> exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("[Exception]", e);
        log.error("发生未知异常！原因是：{}", e.getMessage());
        return Resp.<Boolean>builder()
                .code(ErrorCode.ERROR.code())
                .msg("未知异常")
                .build();
    }
}