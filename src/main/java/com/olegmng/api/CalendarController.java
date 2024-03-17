package com.olegmng.api;

import com.olegmng.entity.Calendar;
import com.olegmng.entity.Report;
import com.olegmng.service.CalendarService;
import com.olegmng.service.PatientService;
import com.olegmng.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/calendar")
@Tag(name = "Calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;


    @GetMapping
    @Operation(summary = "Get all calendars", description = "Getting all available calendars in the system")
    public List<Calendar> getAllCalendar() {
        return calendarService.getAllCalendars();
    }

    @PostMapping
    @Operation(summary = "Add new calendar", description = "Adding new calendar in system")
    public List<Calendar> addCalendar(@RequestBody Calendar calendar) {
        return calendarService.saveCalendar(calendar);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get calendar by id", description = "Getting available calendar by id in the system")
    public Optional<Calendar> getCalendarById(@PathVariable Long id) {
        return calendarService.getCalendarById(id);
    }

    @DeleteMapping ("/delete/{id}")
    @Operation(summary = "Delete calendar by id", description = "Getting available calendar by id in the system")
    public List<Calendar> deleteCalendarById(@PathVariable Long id) {
        return calendarService.deleteCalendarById(id);
    }
}
