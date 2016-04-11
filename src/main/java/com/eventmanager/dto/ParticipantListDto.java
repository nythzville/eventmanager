package com.eventmanager.dto;

import com.eventmanager.model.User;

/**
 * Created by nathan on 4/8/2016.
 */
public class ParticipantListDto {
    private Long id;

    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public ParticipantListDto() {
    }

    public ParticipantListDto(Long id, Long userId) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

}
