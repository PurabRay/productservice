package com.sst.firstweek.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
//@RestController
//@RequestMapping("/product")
public class fakestoreproductdto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String category;
    private String image;



}
