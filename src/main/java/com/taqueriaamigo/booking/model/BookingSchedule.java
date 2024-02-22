package com.taqueriaamigo.booking.model;

/**
 * Enum storing the schedules defined for booking.
 */
public enum BookingSchedule {

    FIRST_SCHEDULE("17:00"), SECOND_SCHEDULE("19:00"), THIRD_SCHEDULE("21:00"), FOURTH_SCHEDULE("23:00");

    private String schedule;

    private BookingSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSchedule() {
        return schedule;
    }

    /**
     * Get a BookingSchedule object from the schedule.
     *
     * @param schedule
     * @return a BookingSchedule object from the schedule.
     */
    public static BookingSchedule getBySchedule(String schedule) {
        for (BookingSchedule bookingSchedule : values()) {
            if (bookingSchedule.getSchedule().equalsIgnoreCase(schedule)) {
                return bookingSchedule;
            }
        }
        return null;
    }

}
