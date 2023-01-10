package com.example.blog.xenium.member.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class EachProduct {

    private int id;
    private int orderID;
    private String name;
    private int amount;
    private int price;
}
