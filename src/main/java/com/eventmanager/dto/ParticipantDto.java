package com.eventmanager.dto;

/**
 * Created by nathan on 4/8/2016.
 */
public class ParticipantDto {

    private Long id;
    private Long userId;
    private Long eventId;

    public ParticipantDto() {
    }

    public ParticipantDto(Long id, Long userId, Long eventId) {
        this.id = id;
        this.userId = userId;
        this.eventId = eventId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }



}
