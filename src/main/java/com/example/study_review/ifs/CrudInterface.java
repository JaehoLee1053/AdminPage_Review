package com.example.study_review.ifs;

import com.example.study_review.model.network.Header;

public interface CrudInterface {

    Header create();

    Header read(Long id);

    Header update();

    Header delete(Long id);

}
