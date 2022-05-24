package com.muhammedbingol.ui.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OnePageController {



    //http://localhost:8080/index
    @GetMapping({"/", "/index"})
    public String getİndex(){
        return "index";
    }




}
