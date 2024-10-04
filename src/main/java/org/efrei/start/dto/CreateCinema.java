package org.efrei.start.dto;

public class CreateCinema {

    private String roomNumber;
    private String showTime;

    public CreateCinema() {
    }

    public CreateCinema(String roomNumber, String showTime) {
        this.roomNumber = roomNumber;
        this.showTime = showTime;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
