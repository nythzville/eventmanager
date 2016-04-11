package com.eventmanager.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nathan on 4/8/2016.
 */
public class EventParticipantsDto {

    private Long id;
    private String eventName;

    private List<ParticipantListDto> participants = new ArrayList<>();

    public List<ParticipantListDto> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantListDto> participants) {
        this.participants = participants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
