package com.store.Advice;



import com.store.Exception.CompanyException;
import com.store.Exception.CustomerException;
import com.store.Exception.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@ControllerAdvice  //aop -> exception
public class StoreCustomException {
    @ExceptionHandler(value = {CompanyException.class})
    //what to return in response
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDetail handleException(Exception e){
        return new ErrorDetail("Company not found",e.getMessage());
    }


    @ExceptionHandler(value = {ProductException.class})
    //what to return in response
    @ResponseStatus(code = HttpStatus.ALREADY_REPORTED)
    public ErrorDetail handleUpdateException(Exception e){
        return new ErrorDetail("Products not found",e.getMessage());
    }


    @ExceptionHandler(value = {CustomerException.class})
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ErrorDetail handleUserException(Exception e){
        return new ErrorDetail("Customer not found",e.getMessage());
    }
}
