package com.example.study_review.controller.api;

import com.example.study_review.controller.CrudController;
import com.example.study_review.ifs.CrudInterface;
import com.example.study_review.model.entity.OrderGroup;
import com.example.study_review.model.network.Header;
import com.example.study_review.model.network.request.OrderGroupApiRequest;
import com.example.study_review.model.network.response.OrderGroupApiResponse;
import com.example.study_review.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.OriginTrackedResource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

}
