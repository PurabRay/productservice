package com.sst.firstweek.exceptionhandler;

import com.sst.firstweek.dtos.exceptiondto;
import com.sst.firstweek.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)

    public ResponseEntity<exceptiondto> handleArithmeticException(){
         exceptiondto dto=new exceptiondto();
         dto.setMessage("Something went wrong");
         dto.setResolution("Arithmetic exception");
         ResponseEntity<exceptiondto> response=new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
         return response;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<exceptiondto> handleArrayIndexOutOfBoundsException(){
        exceptiondto dto=new exceptiondto();
        dto.setMessage("Something went wrong");
        dto.setResolution("ArrayIndexOutOfBounds exception");
        ResponseEntity<exceptiondto> response=new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<exceptiondto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        exceptiondto dto=new exceptiondto();
        dto.setMessage("Invalid product id: "+productNotFoundException.getId()+" passed");
        dto.setResolution("Product Not Found exception");
        ResponseEntity<exceptiondto> response=new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
}
