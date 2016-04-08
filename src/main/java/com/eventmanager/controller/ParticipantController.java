package com.eventmanager.controller;

import com.eventmanager.dto.EventDto;
import com.eventmanager.dto.ParticipantDto;
import com.eventmanager.model.Event;
import com.eventmanager.model.Participant;
import com.eventmanager.repo.EventRepo;
import com.eventmanager.repo.ParticipantRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by nathan on 4/8/2016.
 */
@RestController
public class ParticipantController {
    @Resource(name = "participantRepo")
    private ParticipantRepo participantRepo;

    @Resource(name = "eventRepo")
    private EventRepo eventRepo;

    @RequestMapping(value = "/participant/{id}", method = GET)
    public ParticipantDto get(@PathVariable Long id) throws InterruptedException {
        Participant participant = participantRepo.findOne(id);
        ParticipantDto dto = new ParticipantDto();
        BeanUtils.copyProperties(participant, dto);
        return dto;
    }

    @RequestMapping(value = "/participant", method = POST)
    public ParticipantDto save(@RequestBody ParticipantDto dto) {
        Participant participant = new Participant();
        //Participant participant = dto.getId() == null ? new Participant() : participantRepo.findOne(dto.getId());


        BeanUtils.copyProperties(dto, participant);
        //System.out.println("id: "+participant.getId());
        Event event = eventRepo.findOne(dto.getEventId());
        participant.setEvent(event);
       //System.out.println("user_id: " + event.getId());
        Participant saved = participantRepo.save(participant);

        BeanUtils.copyProperties(saved, dto);
        return dto;
    }

    @RequestMapping(value = "/participants", method = GET)
    public List<ParticipantDto> list() throws InterruptedException {

        List<ParticipantDto> dtos = new ArrayList<>();
        List<Participant> participants = participantRepo.findAll();
        for (Participant participant : participants) {
            ParticipantDto dto = new ParticipantDto();
            BeanUtils.copyProperties(participant, dto);
            dtos.add(dto);
        }
        return dtos;
    }
}
