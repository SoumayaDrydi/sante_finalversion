package com.iset.sante.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.iset.sante.model.ImcRequest;
@Controller
public class ImcFormcontroller {


	


	    @GetMapping("/imcform")
	    public String showBmiForm(Model model) {
	        model.addAttribute("imcRequest", new ImcRequest());
	        return "imcform";
	    }
	}


