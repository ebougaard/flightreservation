package com.bharath.flightreservation.controllers;

import com.bharath.flightreservation.entities.Supplements;;
import com.bharath.flightreservation.services.SupplementsService;
import com.bharath.flightreservation.util.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class SupplementController {



	@Autowired
	SupplementsService supplementsService;


	@Autowired
	ReportUtil reportUtil;



	@Autowired
	ServletContext sc;

	@RequestMapping("admin/showCreateSupplement")
	public String showCreateSupplement() {

		return "createSupplement";
	}

	@RequestMapping("/admin/displayAllSupplementData")
	public String displayAllSupplementData() {

		return "redirect:/admin/displaySupplements";
	}

	@RequestMapping("/admin/saveSupplements")
	public String saveSupplements(@ModelAttribute("supplement") Supplements supplements, ModelMap modelMap) {
		Supplements supplement = supplementsService.saveSupplement(supplements);
		String msg = "Supplement saved with id: " + supplements.getSupplierId();
		modelMap.addAttribute("msg", msg);
		return "createSupplement";
	}

	@RequestMapping("/admin/displaySupplements")
	public String displaySupplements(ModelMap modelMap) {
		List<Supplements> supplements = supplementsService.getAllSupplements();
		modelMap.addAttribute("supplements", supplements);
		return "supplementsAll";
	}

	@RequestMapping("/admin/deleteSupplements")
	public String deleteSupplements(@RequestParam("id") String id, ModelMap modelMap) {
		Supplements supplements = new Supplements();
		supplements.setSupplierId(id);
		supplementsService.deleteSupplements(supplements);
		List<Supplements> supplementsList = supplementsService.getAllSupplements();
		modelMap.addAttribute("supplementsList", supplementsList);
		return "redirect:/admin/displaySupplements";
	}

	@RequestMapping("/admin/showSupplements")
	public String showSupplements(@RequestParam("id") int id, ModelMap modelMap) {
		Supplements supplements = supplementsService.getSupplementById(id);
		modelMap.addAttribute("supplements", supplements);
		return "updateSupplement";
	}

	@RequestMapping("/admin/updateSupplements")
	public String updateSupplements(@ModelAttribute("supplierIfno") Supplements supplements, ModelMap modelMap) {
		supplementsService.updateSupplements(supplements);
		List<Supplements> supplementsList = supplementsService.getAllSupplements();
		modelMap.addAttribute("supplementsList", supplementsList);
		return "redirect:/admin/displaySupplements";
	}



}
