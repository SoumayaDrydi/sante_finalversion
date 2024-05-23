package com.iset.sante.controllers;

import java.text.ParseException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iset.sante.dao.ProfilRepository;
import com.iset.sante.dao.RegimeRepository;
import com.iset.sante.entities.Profil;
import com.iset.sante.entities.Regime;
import com.iset.sante.service.ProfilService;

@Controller
public class ProfilController {
	@Autowired
	ProfilService profilService;
	ProfilRepository profilRepository;
	RegimeRepository regimeRepository;
	  @GetMapping("/home")
	    public String getHomePage() {
	        return "/home"; // Ceci correspond au nom du fichier HTML sans l'extension
	    }
	  @PostMapping("/{userProfileId}/regimes")
	    public String addUserRegime(@PathVariable int userProfileId, @RequestParam int regimeId, Model model) {
	        Profil profil = profilService.getProfil(userProfileId);
	        Regime regime = regimeRepository.findById(regimeId)
	                .orElseThrow(() -> new RuntimeException("Regime not found"));
	        profil.getRegimes().add(regime);
	        profilService.saveProfil(profil);
	        model.addAttribute("profil", profil);
	        return "NewProfil1"; // Return the Thymeleaf template to display the updated profile
	    }

	    @GetMapping("/NewProfil1")
	    public String displayNewProfilPage() {
	        return "NewProfil1"; // Return the view name corresponding to the Thymeleaf template
	    }
	  @GetMapping("/homeUser")
	    public String gethomeUserPage() {
	        return "/homeUser"; // Ceci correspond au nom du fichier HTML sans l'extension
	    }
	@GetMapping("/showCreate")
	public String showCreate(Model model) {
	    model.addAttribute("profil",new Profil());
	    return "profil/createProfil";
	}
	@PostMapping("/saveProfil")
	public String saveProduit(@ModelAttribute("profil") Profil profil,
	                          ModelMap modelMap) throws ParseException {
	    
	       
	    	Profil saveProfil = profilService.saveProfil(profil);
	        String msg = "Profil enregistré avec Id " + saveProfil.getIdprofil();
	        modelMap.addAttribute("msg", msg);
	    
	     

	    return "profil/createProfil";
	}
	@GetMapping("/ListeProfils")
	public String listeProfils(ModelMap modelMap)
	{
	List<Profil> prods =profilService.getAllProfils();
	modelMap.addAttribute("profils", prods);

	return "profil/listeProfils";
	}



	@GetMapping("/supprimerProfil")
	public String supprimerProfil(@RequestParam("id") int id, ModelMap modelMap)
	{
		profilService.deleteProfilById(id);
	List<Profil> prods = profilService.getAllProfils();
	modelMap.addAttribute("profils", prods);
	return "profil/listeProfils";
	}

	@GetMapping("/modifierProfil")
	public String editerOuModifierProfil(@RequestParam("id") int id, ModelMap modelMap) {
	    Profil p = profilService.getProfil(id);
	    modelMap.addAttribute("profil", p);
	    return "profil/editerProfils";
	}

	@PostMapping("/updateProfil")
	public String editerOuModifierProfil(@ModelAttribute("profil") Profil profil, ModelMap modelMap) throws ParseException {
	    profilService.updateProfil(profil);
	    List<Profil> profils = profilService.getAllProfils();
	    modelMap.addAttribute("profils", profils);
	    return "profil/listeProfils";
	}
	@GetMapping("/profil/{id}")
	    public String afficherProfil(@PathVariable("id") int id, Model model) {
	        Profil profil = profilService.findById(id); // Utilisation de profilService pour trouver le profil par ID
	        if (profil == null) {
	            throw new IllegalArgumentException("Profil non trouvé avec l'ID : " + id);
	        }
	        model.addAttribute("profil", profil);
	        return "profil/NewProfil";
	    }
	   @GetMapping("/saisirNom")
	   public String saisirNom() {
	       return "saisirNom"; // Retourne la page de saisie du nom
	   }

	   @GetMapping("/afficherProfil")
	   public String afficherProfil(@RequestParam("nom") String nom, Model model) {
	       // Rechercher le profil par nom (Vous devez implémenter cette méthode dans le service)
	       Profil profil = profilService.findByNom(nom); 
	       if (profil == null) {
	           throw new IllegalArgumentException("Profil non trouvé avec le nom : " + nom);
	       }
	       model.addAttribute("profil", profil);
	       return "profil/NewProfil"; // Afficher la page du profil
	   }
	   @GetMapping("/modifierProfil1")
		public String editerOuModifierProfil1(@RequestParam("id") int id, ModelMap modelMap) {
		    Profil p = profilService.getProfil(id);
		    modelMap.addAttribute("profil", p);
		    return "profil/editerProfils1";
		}

		@PostMapping("/updateProfil1")
		public String editerOuModifierProfil1(@ModelAttribute("profil") Profil profil, ModelMap modelMap) throws ParseException {
		    profilService.updateProfil(profil);
		    List<Profil> profils = profilService.getAllProfils();
		    modelMap.addAttribute("profils", profils);
		    return "profil/NewProfil";
		}
	   
	}
	

