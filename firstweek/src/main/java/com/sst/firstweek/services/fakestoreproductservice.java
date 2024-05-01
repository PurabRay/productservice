package com.sst.firstweek.services;

import com.sst.firstweek.dtos.fakestoreproductdto;
import com.sst.firstweek.exceptions.ProductNotFoundException;
import com.sst.firstweek.models.Category;
import com.sst.firstweek.models.product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class fakestoreproductservice implements productservice{
    @Override
    public product getproductbyid(Long id) {
        //call the fakestore api to get the product with the given id
        RestTemplate restTemplate = new RestTemplate();

        fakestoreproductdto FakeStoreProductDto= restTemplate.getForObject("https://fakestoreapi.com/products/"+id, fakestoreproductdto.class);
//        return null;
        //converting it into product object

        if(FakeStoreProductDto == null){
            throw new ProductNotFoundException(id,"Please pass a valid product id");
        }
        return convertfakeproductdtotoproduct(FakeStoreProductDto);
    }
    public List<product> getallproducts(){
        RestTemplate resttemplate=new RestTemplate();
        fakestoreproductdto[] Fakestoreproductdtos =  resttemplate.getForObject("https://fakestoreapi.com/products",fakestoreproductdto[].class);
        List<product> products = new ArrayList<>();
            for(fakestoreproductdto Fakestoreproductdto: Fakestoreproductdtos){
                 products.add(convertfakeproductdtotoproduct(Fakestoreproductdto));
            }

            return products;

    }
    private product convertfakeproductdtotoproduct(fakestoreproductdto Fakestoreproductdto){
        product Product = new product();
        Product.setId(Fakestoreproductdto.getId());

        Product.setTitle(Fakestoreproductdto.getTitle());
        Product.setDescription(Fakestoreproductdto.getDescription());
        Product.setImage(Fakestoreproductdto.getImage());
        Category category=new Category();
            category.setTitle(Fakestoreproductdto.getCategory());
            category.setId(Fakestoreproductdto.getId());
        Product.setCategory(category);

        return Product;
    }
}
