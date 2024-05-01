package com.sst.firstweek.services;

import com.sst.firstweek.models.product;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface productservice {
    product getproductbyid(Long id);
    List<product> getallproducts();
}
