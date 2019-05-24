package com.imooc.girl.repository;


import com.imooc.girl.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HmacRepository extends JpaRepository<Login,String> {
     public Login findBymacname(String macname);
}
