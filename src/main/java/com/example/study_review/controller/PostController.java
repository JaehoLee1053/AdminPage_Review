package com.example.study_review.controller;

import com.example.study_review.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // class에대한 mapping은 겹쳐도 상관 없음
public class PostController {

    // HTML <Form>
    // ajax 검색
    // http post body -> data
    // json, xml, multipart-form / text-plain

    @PostMapping("/postMethod")
    public String postMethod(@RequestBody SearchParam searchParam) {


        return "OK";
    }

    @PutMapping("/putMethod")
    public void put() {

    }

    @PatchMapping("/patchMethod")
    public void patch() {

    }

}
