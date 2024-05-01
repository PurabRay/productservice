package com.sst.firstweek.controllers;

import com.sst.firstweek.dtos.exceptiondto;
import com.sst.firstweek.exceptions.ProductNotFoundException;
import com.sst.firstweek.models.product;
import com.sst.firstweek.services.productservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//this makes the controller capable of hosting HTTP APIs
//All APIs directed to localhost:8080/product will reach to productcontroller

@RequestMapping("/products")//local host:8080 is the machine address
public class productcontroller {//waiter-> so we make the controller methods public because they interact with the user
   private productservice Productservice;
   productcontroller(productservice Productservice){
       this.Productservice= Productservice;
   }
   @GetMapping("/{id}")
    public  product getproductbyid(@PathVariable("id") Long id){
       ResponseEntity responseentity=null;
       product Product=null;

//       try{
//            Product= Productservice.getproductbyid(id);
//           if(Product == null){
//               throw new ProductNotFoundException("please pass a valid id");
//           }
//           responseentity=new ResponseEntity<>(Product, HttpStatus.OK);
//           System.out.println("Hello");
//           return responseentity;
//       }
//       catch(RuntimeException exception){
//           exceptiondto dto=new exceptiondto();
//           dto.setMessage("something went wrong");
//           dto.setResolution("Do nothing");
//           responseentity=new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
//           return responseentity;
//       }
      return Productservice.getproductbyid(id);


   }
   //we need the getallproducts's end point to be localhost:8080/products
   @GetMapping()
  public List<product> getallproducts(){
      return Productservice.getallproducts();
 }


}
