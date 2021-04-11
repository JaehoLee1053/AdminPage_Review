package com.example.study_review.controller.api;

import com.example.study_review.model.network.Header;
import com.example.study_review.model.network.response.UserOrderInfoApiResponse;
import com.example.study_review.service.UserApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//CREATE TABLE `settlement` {
//        `id` bigint(20) NOT NULL AUTO_INCREMENT,
//        `price` decimal(12,4) DEFAULT NULL,
//        PRIMARY KEY (`id`)
//        } ENGINE=InnoDB AUTO_INCREMENT=406 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

public class TotalUsedApiController {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @GetMapping("/{id}/orderInfo")
    public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id) {
        return userApiLogicService.orderInfo(id);
    }

}
