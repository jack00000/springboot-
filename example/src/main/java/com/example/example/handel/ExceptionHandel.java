package com.example.example.handel;

import com.example.example.entry.Result;
import com.example.example.exception.GrilException;
import com.example.example.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;



@ControllerAdvice
public class ExceptionHandel {
    private final static Logger logger=LoggerFactory.getLogger(ExceptionHandler.class);
    //获取具体Controller类抛出的异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handel(Exception e){
        if(e instanceof GrilException){
            GrilException grilException=(GrilException)e;
            return ResultUtil.err(grilException.getCode(),grilException.getMessage());
        }else {
            logger.error("【系统异常】{}");
            return ResultUtil.err(-1,"未知错误");
        }

    }

}
