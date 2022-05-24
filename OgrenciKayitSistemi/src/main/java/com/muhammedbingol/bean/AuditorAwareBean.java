package com.muhammedbingol.bean;


import com.muhammedbingol.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

//AUDIT BEAN
@Configuration
public class AuditorAwareBean {


    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
}


