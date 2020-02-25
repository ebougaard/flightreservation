package com.bharath.flightreservation.controllers;

import com.bharath.flightreservation.entities.ClientData;
import com.bharath.flightreservation.entities.Location;
import com.bharath.flightreservation.repos.LocationRepository;
import com.bharath.flightreservation.services.ClientService;
import com.bharath.flightreservation.services.LocationService;
import com.bharath.flightreservation.util.EmailUtils;
import com.bharath.flightreservation.util.ReportUtil;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;


	@Autowired
	ReportUtil reportUtil;



	@Autowired
	ServletContext sc;

	@RequestMapping("/admin/showCreate")
	public String showCreate() {
		return "createClient";
	}

	@RequestMapping("/admin/displayAll")
	public String displayAllData() {
		return "redirect:/admin/displayLocations";
	}

	@RequestMapping("/admin/saveLoc")
	public String saveLocation(@ModelAttribute("clientData") ClientData clientData, ModelMap modelMap) {
		ClientData savedClient = clientService.saveClient(clientData);
		String msg = "Location saved with id: " + savedClient.getClientId();
		modelMap.addAttribute("msg", msg);

		return "createClient";
	}

	@RequestMapping("admin/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<ClientData> clientData = clientService.getAllClients();
		modelMap.addAttribute("clientData", clientData);
		return "manageAppointments";
	}
	@RequestMapping("admin/dayToDay1")
	public String displayDayToDay(ModelMap modelMap) {
		List<ClientData> clientData = clientService.getAllClients();








		for (ClientData clientData1: clientData) {
            String input = clientData1.getClientId();

            String firstTwoChars = "";     //substring containing first 4 characters
            String firstFourChars = "";


            if (input.length() > 4)
            {
                firstTwoChars = input.substring(2, 4);
                firstFourChars = input.substring(4, 6);
            }
            else
            {
                firstFourChars = input;
            }

            System.out.println(firstFourChars);


        }


		modelMap.addAttribute("clientData", clientData);
		return "dayToDay1";
	}


	@RequestMapping("/admin/deleteLocation")
	public String deleteLocation(@RequestParam("id") String id, ModelMap modelMap) {
		// Location location = service.getLocationById(id);
		ClientData clientData = new ClientData();
		clientData.setClientId(id);
		clientService.deleteClient(clientData);
		List<ClientData> clientDataList = clientService.getAllClients();
		modelMap.addAttribute("clientDataList", clientDataList);
		return "redirect:/admin/displayLocations";
	}

	@RequestMapping("/admin/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		ClientData clientData = clientService.getClientById(id);
		modelMap.addAttribute("clientData", clientData);
		return "updateClient";
	}

	@RequestMapping("/admin/updateLoc")
	public String updateLocation(@ModelAttribute("clientData") ClientData clientData, ModelMap modelMap) {
		clientService.updateClient(clientData);
		List<ClientData> clientDataList = clientService.getAllClients();
		modelMap.addAttribute("clientDataList", clientDataList);
		return "redirect:/admin/displayLocations";
	}



}
