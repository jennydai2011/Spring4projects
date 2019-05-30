package com.jdai.SpringThymeleafPagination.controllers;

import com.jdai.SpringThymeleafPagination.entities.Country;
import com.jdai.SpringThymeleafPagination.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/")
    public String showPage(Model model, @RequestParam(defaultValue="0") int page){
        model.addAttribute("data", countryRepository.findAll(PageRequest.of(page, 4)));
        model.addAttribute("currentPage", page);
        return "index";
    }

    @PostMapping("/save")
    public String save(Country c){
        countryRepository.save(c);

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteCountry(Integer id){
        countryRepository.deleteById(id);

        return "redirect:/";
    }

    @GetMapping("/find")
    @ResponseBody
    public Country findOne(@RequestParam Integer id){
        System.out.println(" hit the findOne method!!!!!");
        return countryRepository.findById(id).get();

    }
}
