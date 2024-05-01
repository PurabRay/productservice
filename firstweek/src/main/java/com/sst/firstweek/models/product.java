package com.sst.firstweek.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class product {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Category category;
    private String image;//because we are only storing the url of the image
}
