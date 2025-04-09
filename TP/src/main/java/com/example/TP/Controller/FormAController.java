package com.example.TP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FormAController {
    //@Autowired
    //FormARepository formARepository;

    @GetMapping("/address")
    public String showAddressPage() {
        return "address";
    }
}
