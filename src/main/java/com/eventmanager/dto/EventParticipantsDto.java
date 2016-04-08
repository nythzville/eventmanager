package com.eventmanager.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nathan on 4/8/2016.
 */
public class EventParticipantsDto {

    private Long id;

    private List<ParticipantListDto> participants = new ArrayList<>();

    public List<ParticipantListDto> getParticipant() {
        return participants;
    }

    public void setParticipant(List<ParticipantListDto> participants) {
        this.participants = participants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

}
