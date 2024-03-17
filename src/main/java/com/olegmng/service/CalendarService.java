package com.olegmng.service;

import com.olegmng.dto.CalendarDTO;
import com.olegmng.entity.Calendar;
import com.olegmng.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CalendarService  {

    @Autowired
    private CalendarRepository calendarRepository;

    public List<Calendar> getAllCalendars() {
        calendarRepository.save(new Calendar(LocalDate.of(2024,04,07), 1L, 4L));
        calendarRepository.save(new Calendar(LocalDate.of(2024,04,18), 1L, 3L));
        calendarRepository.save(new Calendar(LocalDate.of(2024,04,28), 1L, 4L));
        calendarRepository.save(new Calendar(LocalDate.of(2024,05,05), 2L, 2L));

        return calendarRepository.findAll();
    }
    public List<Calendar> saveCalendar(CalendarDTO calendar){
        calendarRepository.save(new Calendar(
                calendar.getCalendar().getDate(), calendar.getCalendar().getPatient_id(),
                calendar.getCalendar().getDoctor_id()));

        return calendarRepository.findAll();
    }
    public Optional<Calendar> getCalendarById(Long id){
        return calendarRepository.findById(id);
    }

    public List<Calendar> deleteCalendarById(Long id) {
        calendarRepository.deleteById(id);
        return calendarRepository.findAll();
    }
}
