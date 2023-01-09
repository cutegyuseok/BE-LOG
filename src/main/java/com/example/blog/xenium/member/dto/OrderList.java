package com.example.blog.xenium.member.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderList {
    private String orderID;
    private String status;
    private String indate;
    private List<Each> list;

}
