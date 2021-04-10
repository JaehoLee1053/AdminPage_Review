package com.example.study_review.controller.api;

import com.example.study_review.controller.CrudController;
import com.example.study_review.ifs.CrudInterface;
import com.example.study_review.model.entity.Item;
import com.example.study_review.model.network.Header;
import com.example.study_review.model.network.request.UserApiRequest;
import com.example.study_review.model.network.response.UserApiResponse;
import com.example.study_review.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, Item> {

}
