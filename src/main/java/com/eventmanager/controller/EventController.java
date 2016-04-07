package com.eventmanager.controller;

import com.eventmanager.dto.EventDto;
import com.eventmanager.model.Event;
import com.eventmanager.repo.EventRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by nathan on 3/31/2016.
 */
@RestController
public class EventController {

    @Resource(name = "eventRepo")
    private EventRepo eventRepo;

    @RequestMapping(value = "/event/{id}", method = GET)
    public EventDto get(@PathVariable Long id) throws InterruptedException {
        Event event = eventRepo.findOne(id);
        EventDto dto = new EventDto();
        BeanUtils.copyProperties(event, dto);
        return dto;
    }

    @RequestMapping(value = "/event", method = GET)
    public List<EventDto> list() throws InterruptedException {
        //Thread.sleep(5000);
        List<EventDto> dtos = new ArrayList<>();
        List<Event> events = eventRepo.findAll();
        for (Event event : events) {
            EventDto dto = new EventDto();
            BeanUtils.copyProperties(event, dto);
            dtos.add(dto);
        }
        return dtos;
    }
    @RequestMapping(value = "/event", method = POST)
    public EventDto save(@RequestBody EventDto dto) {
        Event event = dto.getId() == null ? new Event() : eventRepo.findOne(dto.getId());

        BeanUtils.copyProperties(dto, event, "password", "excludeMeToo");
        Event saved = eventRepo.save(event);

        BeanUtils.copyProperties(saved, dto);
        return dto;
    }

    @RequestMapping(value = "/event/{id}", method = DELETE)
    public void delete(@PathVariable Long id) {
        eventRepo.delete(id);
    }

}
