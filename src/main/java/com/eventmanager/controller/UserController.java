package com.eventmanager.controller;

import com.eventmanager.dto.EventDto;
import com.eventmanager.dto.UserDto;
import com.eventmanager.model.Event;
import com.eventmanager.model.User;
import com.eventmanager.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by kjsiosan on 4/1/2016.
 */

@RestController
public class UserController {

    @Resource(name = "userRepo")
    private UserRepo userRepo;

    @RequestMapping(value = "/user/{id}", method = GET)
    public UserDto get(@PathVariable Long id) throws InterruptedException {
        User user = userRepo.findOne(id);
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    @RequestMapping(value = "/user", method = GET)
    public List<UserDto> list() throws InterruptedException{
        List<UserDto> dtos = new ArrayList<>();
        List<User> users = userRepo.findAll();

        for (User user : users) {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(user, dto);
            dtos.add(dto);
        }

        return dtos;
    }

    @RequestMapping(value = "/user", method = POST)
    public UserDto save(@RequestBody UserDto dto) {
        User user = dto.getId() == null ? new User() : userRepo.findOne(dto.getId());

        BeanUtils.copyProperties(dto, user);

        //Envelope envelope = dto.getEnvelopeId() == null ? null : envelopeRepo.findOne(dto.getEnvelopeId());
        //greeting.setEnvelope(envelope);

        // Save our user
        User saved = userRepo.save(user);

        BeanUtils.copyProperties(saved, dto);
        return dto;
    }

    @RequestMapping(value = "/user/{id}", method = DELETE)
    public void delete(@PathVariable Long id) {
        userRepo.delete(id);
    }
}
