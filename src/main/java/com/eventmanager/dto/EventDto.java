package com.eventmanager.dto;

/**
 * Created by nathan on 3/31/2016.
 */
public class EventDto {
    private Long Id;
    private String startDate;
    private String endDate;

    public EventDto(){

    }
    public EventDto(Long id, String startDate, String endDate) {
        Id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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
