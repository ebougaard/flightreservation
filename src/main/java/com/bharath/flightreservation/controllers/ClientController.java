package com.bharath.flightreservation.controllers;

import com.bharath.flightreservation.entities.ClientData;
import com.bharath.flightreservation.entities.Location;
import com.bharath.flightreservation.repos.LocationRepository;
import com.bharath.flightreservation.services.ClientService;
import com.bharath.flightreservation.services.LocationService;
import com.bharath.flightreservation.util.EmailUtils;
import com.bharath.flightreservation.util.ReportUtil;
import org.hibernate.SessionFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        ArrayList<ClientData> clientDataList = new ArrayList<>();

		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));

		Calendar c=Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
		c.set(Calendar.HOUR_OF_DAY,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);


		System.out.println(df.format(c.getTime()));      // This past Sunday [ May include today ]

		Date thisWeek = new Date(df.format(c.getTime()));
		System.out.println(thisWeek);

		c.add(Calendar.DATE,7);

		System.out.println(df.format(c.getTime()));      // Next Sunday

		Date NextWeek = new Date(df.format(c.getTime()));

		System.out.println(NextWeek);


		c.add(Calendar.DATE,7);
		System.out.println(df.format(c.getTime()));


		System.out.println(thisWeek);
		System.out.println(NextWeek);

		/*String Min = thisWeek.getMonth()+"-" + thisWeek.getDay();
		String Max = NextWeek.getMonth()+"-"+ NextWeek.getDay();*/




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

            String ClientDOB = "2020"+"/"+firstTwoChars+"/"+firstFourChars;
            System.out.println(ClientDOB);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

			try {


				Date date = formatter.parse(ClientDOB);
			/*	System.out.println(date);
				System.out.println(formatter.format(date));*/

                Date dateThisWeek = new Date (formatter.format(thisWeek));
                Date dateNextWeek = new Date (formatter.format(NextWeek));
				Date date1 = new Date (formatter.format(date));

				System.out.println(dateThisWeek);
				System.out.println(dateNextWeek);
				System.out.println(date1);


				/*if (dateThisWeek.equals(date1) || dateNextWeek.equals(date1)) {
					System.out.println(date1);
					clientDataList.add(clientData1);*/

				if (date1.equals(dateThisWeek)) {
					System.out.println("problem" + date1);
					clientDataList.add(clientData1);
				}else if(dateNextWeek.equals(date1)) {
						System.out.println(date1);
						clientDataList.add(clientData1);

				}else if (dateThisWeek.before(date1) && dateNextWeek.after(date1)) {


						System.out.println(date1);
						clientDataList.add(clientData1);


					}


			} catch (ParseException e) {
			//	e.printStackTrace();
			}

		}



		modelMap.addAttribute("clientData", clientData);
		modelMap.addAttribute("clientDataList", clientDataList);

		return "birthdayReport";
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
