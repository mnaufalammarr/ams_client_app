package mii.mcc72.ams_client_app.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object errorMessage = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.UNAUTHORIZED.value()) {
                System.out.println("Error Message : " + errorMessage);
                return "error/error-401";
            }else if(statusCode == HttpStatus.NOT_FOUND.value()) {
                System.out.println("Error Message : " + errorMessage);
                return "error/error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                System.out.println("Error Message : " + errorMessage);
                return "error/error-500";
            }else if(statusCode == HttpStatus.FORBIDDEN.value()) {
                System.out.println("Error Message : " + errorMessage);
                return "error/error-403";
            }
        }
        return "error/error-page";
    }
}
