package com.couponservice.couponservice.restcontroller;

import com.couponservice.couponservice.Repository.CouponRepository;
import com.couponservice.couponservice.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/coupons")
public class CouponRestController {

    @Autowired private CouponRepository couponRepository;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public Coupon createCoupon(@RequestBody Coupon coupon){
        return couponRepository.save(coupon);
    }

    @RequestMapping(value = "/{code}",method = RequestMethod.GET)
    public Coupon getCouponByCode(@PathVariable("code") String code){
        return couponRepository.findByCode(code);
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Coupon> getAllCodes(){
        return couponRepository.findAll();
    }

}
