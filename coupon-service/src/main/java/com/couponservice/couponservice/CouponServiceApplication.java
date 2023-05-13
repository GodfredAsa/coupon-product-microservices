package com.couponservice.couponservice;

import com.couponservice.couponservice.Repository.CouponRepository;
import com.couponservice.couponservice.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CouponServiceApplication {
	@Autowired private CouponRepository couponRepository;

	public static void main(String[] args) {
		SpringApplication.run(CouponServiceApplication.class, args);
	}


	@RequestMapping(value = "/coupons",method = RequestMethod.POST)
	public Coupon createCoupon(@RequestBody Coupon coupon){
		return couponRepository.save(coupon);
	}
}
