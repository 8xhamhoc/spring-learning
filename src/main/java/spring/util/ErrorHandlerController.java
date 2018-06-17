package spring.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import spring.exception.BlogNotFoundException;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(BlogNotFoundException.class)
    public void handleBlogNotFoundController(HttpServletResponse httpServletResponse) {
        httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

}
