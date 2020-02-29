package com.bharath.flightreservation.controllers;
import com.bharath.flightreservation.entities.AppointmentInfo;
import com.bharath.flightreservation.services.AppointmentInfoService;
import com.bharath.flightreservation.services.SupplementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Controller
public class GraphController {
    @Autowired
    private SupplementsService supplementsService;
    @Autowired
    AppointmentInfoService appointmentInfoService;


    //@GetMapping("")
    @GetMapping("admin/displayNumberOfAppointments")
    public ModelAndView barGraph() {
        Date fromDate = getReportStartDate();
        Date toDate = getReportEndDate();
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Long> graphMap = new LinkedHashMap<>();
        List<AppointmentInfo> appointmentDates = appointmentInfoService.getAppointmentDatesByDateRange(fromDate,toDate);
        for (int i = 1; i < 13; i++){
            LocalDate newDate = LocalDate.parse(fromDate.toString()).plusMonths(i);
            long monthlyAppointments = appointmentDates
                    .stream()
                    .filter(date ->
                            date.getAppointmentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonth() == newDate.getMonth()
                                    && date.getAppointmentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear() == newDate.getYear()
                    )
                    .count();
            graphMap.put(newDate.format(DateTimeFormatter.ofPattern("YYYY-MM")),monthlyAppointments);
        }
        modelAndView.addObject("surveyMap", graphMap);

        modelAndView.setViewName("barGraph");
        return modelAndView;
    }

    public static Date getReportStartDate() {
        return java.sql.Date.valueOf(LocalDate.now().plusMonths(-12));
    }
    //Get report end date
    public static Date getReportEndDate() {
        return java.sql.Date.valueOf(LocalDate.now());
    }
}