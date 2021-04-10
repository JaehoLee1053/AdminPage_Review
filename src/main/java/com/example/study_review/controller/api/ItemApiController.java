package com.example.study_review.controller.api;

import com.example.study_review.controller.CrudController;
import com.example.study_review.ifs.CrudInterface;
import com.example.study_review.model.network.Header;
import com.example.study_review.model.network.request.ItemApiRequest;
import com.example.study_review.model.network.response.ItemApiResponse;
import com.example.study_review.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @PostConstruct
    public void init() {
        this.baseService = itemApiLogicService;
    }

}
