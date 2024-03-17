package com.olegmng.api;

import com.olegmng.repository.CalendarRepository;
import com.olegmng.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class ThymeController {

    @Autowired
    private PatientRepository patients;

    @Autowired
    private CalendarRepository calendars;

    @GetMapping("/patients")
    public String getPatients(Model model){
        model.addAttribute("patients", patients.findAll());
        return "patients";
    }

    @GetMapping("/calendars")
    public String getCalendars(Model model){
        model.addAttribute("calendars", calendars.findAll());
        return "calendars";
    }
}
