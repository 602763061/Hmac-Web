package com.imooc.girl.contoller;


import com.imooc.girl.domain.*;
import com.imooc.girl.hmac.HMACSHA1;
import com.imooc.girl.properties.Hmacproperties;
import com.imooc.girl.repository.GirlRepository;
import com.imooc.girl.service.GirlService;
import com.imooc.girl.service.HmacService;
import com.imooc.girl.service.RandomService;
import com.imooc.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class HmacController {

    @Autowired
    private HmacService hmacService;

    @Autowired
    private  HMACSHA1 hmacsha1;

    @Autowired
    private RandomService randomService;

    private  double random;

/*
    //Hmac加密
    @CrossOrigin
    @GetMapping(value = "/hmac/{id}")
    public Hmacproperties hmac(@PathVariable("id") String id) {
        String message=hmacsha1.HmacSHA1Encrypt(id,MessageKey).
                toString();
        Hmacproperties hmacproperties=new Hmacproperties();
        hmacproperties.setHmacMessage(message);
        return hmacproperties;
    }
*/

    //Hmac 加密
    @PostMapping(value = "/hmac1")
    public  Hmacproperties hmac(@Valid HmacInput hmacInput)
    {
       return hmacService.hmac(hmacInput);
    }



    //增加一个用户
    @PostMapping(value = "/addhmac")
    public Result<Login>  SaveLogin(@Valid Login login, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(hmacService.save(login)) ;
    }


    //进行登录验证
    @CrossOrigin
    @PostMapping(value = "/hmac")
    @ResponseBody
    public int login(@Valid HmacMessage message) {
        System.out.println(message);
        //判断密码的消息验证码值是否相同 相同进入计算页面 否则给出提示密码错误
        if (hmacService.judgeHmac(message,random)) {
            return 0;
        }
        return 1;
    }

    //获取一个随机数返回给前端
    @GetMapping(value="/random")
    @ResponseBody
    public double getRandomnumber()
    {
         random=randomService.GetRandomnumber();
         System.out.println(random);
        return random;
    }
}