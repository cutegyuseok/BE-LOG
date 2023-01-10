package com.example.blog.xenium.member.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class OrderList {
    private int id;
    private String status;
    private String inDate;
    private int total;
    private List<EachProduct> eachProducts;
}
