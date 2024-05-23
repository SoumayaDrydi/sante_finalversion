package com.iset.sante.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iset.sante.entities.Regime;
import com.iset.sante.entities.TypeRegime;
import com.iset.sante.service.RegimeService;

@Controller
public class ImcController {

    @Autowired
    RegimeService regimeService;

    @GetMapping("/showCreate1")
    public String showCreate(ModelMap model) {
        Regime regime = new Regime();
        regime.setDescriptions(Arrays.asList("", ""));
        
        model.addAttribute("regime", regime);
        model.addAttribute("typesRegime", Arrays.asList(TypeRegime.values())); 
        return "regime/createRegime";
    }

    @PostMapping("/saveRegime")
    public String saveRegime(@ModelAttribute("regime") Regime regime,
                             @RequestParam("typeregime") TypeRegime typeRegime,
                             @RequestParam("descriptions[0]") String description1,
                             @RequestParam("descriptions[1]") String description2,
                             ModelMap modelMap) throws ParseException {
        System.out.println("Type Regime: " + typeRegime);
        System.out.println("Description 1: " + description1);
        System.out.println("Description 2: " + description2);

        regime.setTyperegime(typeRegime);
        
        List<String> descriptions = new ArrayList<>();
        descriptions.add(description1);
        descriptions.add(description2);
        regime.setDescriptions(descriptions);

        Regime savedRegime = regimeService.saveRegime(regime);
        
        String msg = "Regime enregistré avec Id " + savedRegime.getIdregime();
        modelMap.addAttribute("msg", msg);

        return "regime/createRegime";
    }

    @GetMapping("/ListeRegimes")
    public String listeRegimes(ModelMap modelMap) {
        List<Regime> reg = regimeService.getAllRegimes();
        modelMap.addAttribute("regimes", reg);
        
        modelMap.addAttribute("regimesDinner", regimeService.getRegimesByType(TypeRegime.DINNER));
        modelMap.addAttribute("regimesPetitDejeuner", regimeService.getRegimesByType(TypeRegime.PETIT_DEJEUNER));
        
        return "regime/listeRegimes";
    }
    @GetMapping("/ListeRegimes1")
    public String listeRegimes1(ModelMap modelMap) {
        List<Regime> reg = regimeService.getAllRegimes();
        modelMap.addAttribute("regimes", reg);
        
        modelMap.addAttribute("regimesDinner", regimeService.getRegimesByType(TypeRegime.DINNER));
        modelMap.addAttribute("regimesPetitDejeuner", regimeService.getRegimesByType(TypeRegime.PETIT_DEJEUNER));
        
        return "regime/listePuser";
    }

    @GetMapping("/supprimerRegime")
    public String supprimerRegime(@RequestParam("id") int id, ModelMap modelMap) {
        regimeService.deleteRegimeById(id);
        List<Regime> reg = regimeService.getAllRegimes();
        modelMap.addAttribute("regimes", reg);
        return "regime/listeRegimes";
    }

    @GetMapping("/modifierRegime")
    public String editerRegime(@RequestParam("id") int id, ModelMap modelMap) {
        Regime r = regimeService.getRegime(id);
        modelMap.addAttribute("regime", r);
        modelMap.addAttribute("typesRegime", TypeRegime.values());
        return "regime/editerRegimes";
    }

    @PostMapping("/updateRegime")
    public String updateRegime(@ModelAttribute("regime") Regime regime,
                               @RequestParam("typeregime") TypeRegime typeRegime,
                               ModelMap modelMap) throws ParseException {

        regime.setTyperegime(typeRegime);

        regimeService.updateRegime(regime);
        List<Regime> reg = regimeService.getAllRegimes();
        modelMap.addAttribute("regimes", reg);
        return "regime/listeRegimes";
    }

    @GetMapping("regime/detailsRegime")
    public String detailsRegime(@RequestParam("id") int id, ModelMap modelMap) {
        Regime regime = regimeService.getRegime(id);
        modelMap.addAttribute("regime", regime);
        return "regime/detailsRegime";
    }
    @GetMapping("regime/detailsRegime1")
    public String detailsRegime1(@RequestParam("id") int id, ModelMap modelMap) {
        Regime regime = regimeService.getRegime(id);
        modelMap.addAttribute("regime", regime);
        return "regime/detailsRegime";
    }
}

