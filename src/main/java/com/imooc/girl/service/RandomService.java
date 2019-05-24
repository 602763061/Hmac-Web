package com.imooc.girl.service;

import org.springframework.stereotype.Service;

@Service
public class RandomService {

    public  Double GetRandomnumber()
    {
        return Math.random()*1000;
    }
}
