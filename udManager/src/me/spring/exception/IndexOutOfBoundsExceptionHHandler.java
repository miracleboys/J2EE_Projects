package me.spring.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class IndexOutOfBoundsExceptionHHandler {
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ModelAndView uploadException(IndexOutOfBoundsException e, HttpServletResponse response) throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", "文件无法检索!");
		modelAndView.setViewName("exception/IndexOutOfBoundsException");
		return modelAndView;
	}
}
