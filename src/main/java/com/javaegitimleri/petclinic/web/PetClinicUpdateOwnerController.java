package com.javaegitimleri.petclinic.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javaegitimleri.petclinic.model.Owner;
import com.javaegitimleri.petclinic.service.PetClinicService;

@Controller
public class PetClinicUpdateOwnerController {
	@Autowired
	private PetClinicService petClinicService;
	
	
// goUpdate
	
	@RequestMapping(value = "/owners/update" , method = RequestMethod.GET)
	public String updatePage() {
		return "goUpdate";			
	}
	@ModelAttribute
	public Owner initModelForGoUpdate() {
		return new Owner();
	}
	
	@RequestMapping(value = "/owners/update" , method = RequestMethod.POST)
	public String handleFormSubmitForUpdate(@ModelAttribute Owner owner) {
		return "redirect:/owners/update/" + owner.getId();
	}
	
	//updateOwner
	
	@RequestMapping(value = "/owners/update/{id}" , method = RequestMethod.GET)
	public String updateOwner(@PathVariable Long id, ModelMap modelMap) {
		Owner owner = petClinicService.findOwners(id);
		modelMap.put("owner", owner);	
		return "updateOwner";			
	}
	
	@ModelAttribute
	public Owner initModel() {
		return new Owner();
	}
		 
	
	@RequestMapping(value = "/owners/update/{id}" , method = RequestMethod.POST)
	public String handleFormSubmit(@ModelAttribute @Valid Owner owner , BindingResult bindingResult, RedirectAttributes	 redirectAttributes	) {
		if (bindingResult.hasErrors()) {
			return "newOwner";
			
		}
		petClinicService.update(owner);
		redirectAttributes.addFlashAttribute("message","Owner update with id : " + owner.getId());
		return "redirect:/owners";
	}

}
