package com.tphedi.tp.Controller;

import com.tphedi.tp.model.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressController {
    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/adresses")
    public String showAddresses(@RequestParam(name = "searchedBy", required = false) String searchedBy,  Model model) {
        model.addAttribute("searchedBy", searchedBy);
        model.addAttribute("allAddresses", addressRepository.findAll());
        return "addresses";
    }

}
