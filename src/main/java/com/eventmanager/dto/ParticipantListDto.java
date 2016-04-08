package com.eventmanager.dto;

/**
 * Created by nathan on 4/8/2016.
 */
public class ParticipantListDto {
    private Long id;
    private String eventId;
    private String userId;

    public ParticipantListDto() {
    }

    public ParticipantListDto(Long id, String eventId, String userId) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public void setEventId(String eventId) { this.eventId = eventId; }

    public String getEventId() { return eventId; }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
