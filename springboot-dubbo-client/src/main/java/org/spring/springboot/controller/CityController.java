package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.dubbo.CityDubboService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;

@Controller
@RequestMapping("/city")
public class CityController {

    @Reference
    private CityDubboService cityDubboService;

    @ResponseBody
    @RequestMapping("/find")
    public City find(String cityName) {
        return cityDubboService.findCityByName(cityName);
    }
}
