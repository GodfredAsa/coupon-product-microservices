package com.productservice.productservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
    private Long couponId;
    private String code;
    private BigDecimal discount;
    private String expiryDate;
}
