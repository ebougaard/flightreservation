
package com.bharath.flightreservation.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import com.bharath.flightreservation.repos.ClientDataRepository;
import com.bharath.flightreservation.util.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bharath.flightreservation.entities.Location;
import com.bharath.flightreservation.repos.LocationRepository;
import com.bharath.flightreservation.services.LocationService;
import com.bharath.flightreservation.util.EmailUtil;
import com.bharath.flightreservation.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService service;

	@Autowired
	LocationRepository repository;

	@Autowired
	ClientDataRepository clientDataRepository;

	@Autowired
	EmailUtils emailUtil;

	@Autowired
	ReportUtil reportUtil;

	@Autowired
	ServletContext sc;

	/*@RequestMapping("admin/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("admin//saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = service.saveLocation(location);
		String msg = "Location saved with id: " + locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("springxyzabc@gmail.com", "Location Saved",
				"Location Saved Successfully and about to return a response");
		return "createLocation";
	}

	@RequestMapping("admin/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("admin/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		// Location location = service.getLocationById(id);
		Location location = new Location();
		location.setId(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("admin/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}

	@RequestMapping("admin/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.updateLocation(location);
	List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}*/

	@RequestMapping("admin/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("img/");
		List<Object[]> data = clientDataRepository.findTypeReferenceCount();
		reportUtil.generatePieChart(path, data);
		return "report";

	}

}

