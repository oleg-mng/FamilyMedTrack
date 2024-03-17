package com.olegmng.dto;

import com.olegmng.entity.Calendar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CalendarDTO {
    private Calendar calendar;
}
