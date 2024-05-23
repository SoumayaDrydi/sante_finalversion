package com.iset.sante.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iset.sante.entities.Communication;
import com.iset.sante.service.CommunicationService;




@Controller
public class CommunicationController {



    @Autowired
    private  CommunicationService  communicationService;
   


    @GetMapping("com/communicationPage")
    public String communicationPage(ModelMap modelMap) {
        List<Communication> communications = communicationService.getAllCommunications();
        modelMap.addAttribute("communications", communications);
        modelMap.addAttribute("communication", new Communication());
        return "com/communicationPage";
    }

    @PostMapping("/saveCom")
    public String saveCommunication(@ModelAttribute("communication") Communication communication,
            ModelMap modelMap) throws ParseException {
        Communication savedCommunication = communicationService.saveCommunication(communication);
        List<Communication> communications = communicationService.getAllCommunications();
        modelMap.addAttribute("communications", communications);
        String msg = "Communication enregistrée avec l'ID " + savedCommunication.getIdcommunication();
        modelMap.addAttribute("msg", msg);
        return "com/communicationPage";
    }

    
    @GetMapping("/ComList")
	public String listecommunications(ModelMap modelMap)
	{
	List<Communication> prods =communicationService.getAllCommunications();
	modelMap.addAttribute("communications", prods);

	return "com/communicationPage";
	}
    @GetMapping("/supprimerCom")
	public String supprimerCom(@RequestParam("id") int id, ModelMap modelMap)
	{

    	 communicationService.deleteCommunicationById(id);
	List<Communication> prods = communicationService.getAllCommunications();
	modelMap.addAttribute("communications", prods);
	return "com/CommunicationLis";
	}


    @GetMapping("/modifierCommunication")
    public String editerCommunication(@RequestParam("id") int id, ModelMap modelMap) {
    	Communication communication = communicationService.getCommunication(id);
        modelMap.addAttribute("communication", communication);
        return "com/editerCommunications";
    }



	@PostMapping("/updateCommunication")
	public String updateCommunication(@ModelAttribute("activite") Communication activite,
	
	ModelMap modelMap) throws ParseException
	{
	
		communicationService.updateCommunication(activite);
		List<Communication> prods =communicationService.getAllCommunications();
		modelMap.addAttribute("communications", prods);
		return "com/CommunicationList";
	}
   

}
