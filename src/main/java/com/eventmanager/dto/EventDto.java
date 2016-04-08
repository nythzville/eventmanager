package com.eventmanager.dto;

/**
 * Created by nathan on 3/31/2016.
 */
public class EventDto {
    private Long id;
    private String eventName;
    private String startDate;
    private String endDate;

    public EventDto(){

    }
    public EventDto(Long id, String eventName, String startDate, String endDate) {
        this.id = id;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() { return eventName; }

    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
