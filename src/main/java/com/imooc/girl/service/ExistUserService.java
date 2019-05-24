package com.imooc.girl.service;


import com.imooc.girl.domain.Login;
import com.imooc.girl.repository.HmacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExistUserService {

    @Autowired
    private HmacRepository hmacRepository;

    public boolean UserExist(Login login)
    {
        if (hmacRepository.findBymacname(login.getMacname())==null)
        {
            return true;
        }
        return false;
    }
}
