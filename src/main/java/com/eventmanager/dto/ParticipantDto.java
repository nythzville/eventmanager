package com.eventmanager.dto;

/**
 * Created by nathan on 4/8/2016.
 */
public class ParticipantDto {

    private Long id;
    private String userId;
    private Long eventId;

    public ParticipantDto() {
    }

    public ParticipantDto(Long id, String userId) {
        this.id = id;
        this.userId = userId;

    }
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
