package projava;

import one.cafebabe.bc4j.BusinessCalendar;
import one.cafebabe.bc4j.UnitedStates;

import static one.cafebabe.bc4j.BusinessCalendar.JAPAN;
import static one.cafebabe.bc4j.BusinessCalendar.UNITED_STATES;

import java.time.LocalDate;

public class JapaneseHolidays2022 {
    public static void main(String[] args) {
        BusinessCalendar.newBuilder().holiday(UNITED_STATES.PUBLIC_HOLIDAYS).build()
                .getHolidaysBetween(LocalDate.of(2022, 1, 1),
                        LocalDate.of(2022, 12, 31))
                .forEach(System.out::println);
    }
}