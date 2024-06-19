package com.conversor.temperatura.ConversorController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConversorController {
    @GetMapping("/")
    public ModelAndView showConversorForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("conversor");
        return modelAndView;
    }
    @PostMapping("calculate")
    public String calculate (@RequestParam("temp") double temp,
                             @RequestParam("select") String select,
                            Model model) {
     double result = 0;
     switch (select){
         case "Fahrenheit":
             result = (temp * (9.0/5.0) + 32.0);
             break;
         case "Kelvin":
             result = (temp + 273.15);
             break;
     }
     model.addAttribute("result", result);
     return "conversor";
    }
}
