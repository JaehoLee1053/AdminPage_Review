package com.example.study_review.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 여러개의 parameter를 하나씩 getParameter 어노테이션을 안 쓰고 받아오도록
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchParam {
    private String account;
    private String email;
    private int page;

}
