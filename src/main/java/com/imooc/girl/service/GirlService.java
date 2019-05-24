package com.imooc.girl.service;


import com.imooc.girl.domain.Girl;
import com.imooc.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
     Girl girlA=new Girl();

     girlA.setAge(18);
     girlA.setCupsize("c");
     girlRepository.save(girlA);

     Girl girlB=new Girl();
     girlB.setAge(19);
     girlB.setCupsize("d");
     girlRepository.save(girlB);
    }


    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age<10){
            throw new Exception("你可能在上小学");
        }else if (age>10&&age<16){
            throw new Exception("你可能在上初中");
        }
    }
}
