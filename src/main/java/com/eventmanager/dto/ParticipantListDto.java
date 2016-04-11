package com.eventmanager.dto;

/**
 * Created by nathan on 4/8/2016.
 */
public class ParticipantListDto {
    private Long id;
    private String userId;

    public ParticipantListDto() {
    }

    public ParticipantListDto(Long id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
