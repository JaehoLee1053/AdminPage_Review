package com.example.study_review.controller.api;

import com.example.study_review.controller.CrudController;
import com.example.study_review.model.entity.Partner;
import com.example.study_review.model.network.request.PartnerApiRequest;
import com.example.study_review.model.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {

}
