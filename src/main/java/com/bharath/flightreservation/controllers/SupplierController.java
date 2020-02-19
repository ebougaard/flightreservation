package com.bharath.flightreservation.controllers;

import com.bharath.flightreservation.entities.SupplierInfo;
import com.bharath.flightreservation.services.SupplierService;
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
public class SupplierController {



	@Autowired
	SupplierService supplierService;


	@Autowired
	ReportUtil reportUtil;



	@Autowired
	ServletContext sc;

	@RequestMapping("admin/showCreateSupplier")
	public String showCreateSupplier() {

		return "createSupplier";
	}

	@RequestMapping("/admin/displayAllData")
	public String displayAllData() {

		return "redirect:/admin/displayLocation";
	}

	@RequestMapping("/admin/saveSupplier")
	public String saveSupplier(@ModelAttribute("supplierInfo") SupplierInfo supplierIfno, ModelMap modelMap) {
		SupplierInfo supplierIfno1 = supplierService.saveSupplier(supplierIfno);
		String msg = "Location saved with id: " + supplierIfno1.getFax();
		modelMap.addAttribute("msg", msg);

		return "createSupplier";
	}

	@RequestMapping("/admin/displayLocation")
	public String displayLocation(ModelMap modelMap) {
		List<SupplierInfo> supplierIfno = supplierService.getAllSuppliers();
		modelMap.addAttribute("supplierIfno", supplierIfno);
		return "suppliersAll";
	}

	@RequestMapping("/admin/deleteSupplie")
	public String deleteSupplie(@RequestParam("id") String id, ModelMap modelMap) {
		SupplierInfo supplierIfno = new SupplierInfo();
		supplierIfno.setSupplierId(id);
		supplierService.deleteSupplier(supplierIfno);
		List<SupplierInfo> supplierIfnoList = supplierService.getAllSuppliers();
		modelMap.addAttribute("supplierIfnoList", supplierIfnoList);
		return "redirect:/admin/displayLocation";
	}

	@RequestMapping("/admin/showSupplie")
	public String showSupplie(@RequestParam("id") int id, ModelMap modelMap) {
		SupplierInfo supplierIfno = supplierService.getSupplierById(id);
		modelMap.addAttribute("supplierIfno", supplierIfno);
		return "updateSupplier";
	}

	@RequestMapping("/admin/updateSupplie")
	public String updateSupplie(@ModelAttribute("supplierIfno") SupplierInfo supplierIfno, ModelMap modelMap) {
		supplierService.updateSupplier(supplierIfno);
		List<SupplierInfo> supplierIfnoList = supplierService.getAllSuppliers();
		modelMap.addAttribute("supplierIfnoList", supplierIfnoList);
		return "redirect:/admin/displayLocation";
	}



}
