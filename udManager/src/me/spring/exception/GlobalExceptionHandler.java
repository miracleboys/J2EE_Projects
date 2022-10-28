package me.spring.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ModelAndView uploadException(MaxUploadSizeExceededException e, HttpServletResponse response)
			throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("code", -1);
		modelAndView.addObject("msg", "上传文件超出限制!");
		modelAndView.setViewName("exception/maxUploadSizeExceededException");
		return modelAndView;
	}
}