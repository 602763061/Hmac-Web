package com.imooc.girl.service;


import com.imooc.girl.domain.HmacInput;
import com.imooc.girl.domain.HmacMessage;
import com.imooc.girl.domain.Login;
import com.imooc.girl.hmac.HMACSHA1;
import com.imooc.girl.properties.Hmacproperties;
import com.imooc.girl.repository.HmacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HmacService {

    private static  final String Key="HASH";

    private static  final  String Type="HmacSHA1";

    @Autowired
    private HmacRepository hmacRepository;

    @Autowired
    private HMACSHA1 hmacsha1;

    @Autowired
    private ExistUserService existUserService;

    public Hmacproperties hmac(HmacInput hmacInput)
    {
        String message = hmacsha1.HmacSHA1Encrypt(hmacInput.getHmacMassage(),hmacInput.getSecretKey(),hmacInput.getHmacType());

        Hmacproperties hmacproperties=new Hmacproperties();
        hmacproperties.setHmacMessage(message);

        System.out.println(hmacInput.getHmacType());
        return  hmacproperties;


    }

    public boolean judgeHmac(HmacMessage hmacMessage,Double randomnumber)
    {
        Login requestlogin=hmacRepository.findBymacname(hmacMessage.getMacname());
        if(requestlogin.getPassword().equals(hmacMessage.getMessage())&&
                getSecretKey(hmacMessage.getMacname(),randomnumber+Key).equals(hmacMessage.getPassname())) {
            return true;
        }
    return false;
    }

    public Login save(Login login)
    {
        if (existUserService.UserExist(login)) {
            String message = hmacsha1.HmacSHA1Encrypt(login.getPassword(), Key + login.getMacname(), Type);
            Login passLogin = new Login();
            passLogin.setPassword(message);
            passLogin.setMacname(login.getMacname());
            return hmacRepository.save(passLogin);
        }else {
            Login existLogin=new Login();
            existLogin.setMacname("用户名已经存在");
            existLogin.setPassword("不能设置密码");
            return existLogin;
        }

    }

    public String getSecretKey(String hmacMessage,String randomnumber)
    {
        return hmacsha1.HmacSHA1Encrypt(hmacMessage,randomnumber,Type);
    }
}
