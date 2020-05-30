package com.javaegitimleri.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javaegitimleri.petclinic.model.Owner;
import com.javaegitimleri.petclinic.service.PetClinicService;

@Controller
public class PetClinicDeleteOwnerController {

	@Autowired
	private PetClinicService petClinicService;
	
	// goDelete
	@RequestMapping(value ="/owners/delete" , method = RequestMethod.GET)
	public String goDelete() {
		return "goDelete";
	}
	@ModelAttribute
	public Owner initModelForGoDelete() {
		return new Owner();
	}
	
	@RequestMapping(value = "/owners/delete" , method = RequestMethod.POST)
	public String handleFormSubmitGoDelete(@ModelAttribute Owner owner) {
		return "redirect:/owners/delete/" + owner.getId();
	}
	
	//deleteOwner
	
	@RequestMapping(value ="/owners/delete/{id}" , method = RequestMethod.GET)
	public String deleteOwner(@PathVariable Long id, ModelMap modelMap) {
		Owner owner = petClinicService.findOwners(id);
		modelMap.put("owner", owner);	
		return "deleteOwner";
		
	}
	@ModelAttribute
	public Owner initModelForDeleteOwner() {
		return new Owner();
	}
	
	@RequestMapping(value = "/owners/delete/{id}" , method = RequestMethod.POST)
	public String handleFormSubmitForDelete(@PathVariable Long id , @ModelAttribute Owner owner, RedirectAttributes redirectAttributes) {
		petClinicService.deleteOwner(id);
		redirectAttributes.addFlashAttribute("message","Owner delete with id : " + owner.getId());
		return "redirect:/owners";
	}
	
	
}
