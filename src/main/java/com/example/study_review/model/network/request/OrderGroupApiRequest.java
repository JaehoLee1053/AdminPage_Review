package com.example.study_review.model.network.request;

import com.example.study_review.model.enumclass.OrderGroupOrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderGroupApiRequest {

    private Long id;

    private String status;

    @Enumerated(EnumType.STRING)
    private OrderGroupOrderType orderType;

    private String revAddress;

    private String revName;

    private String paymentType;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalAt;

    private Long userId;

}
