package com.eventmanager.repo;

import com.eventmanager.model.Event;
import com.eventmanager.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nathan on 4/8/2016.
 */


@Repository("participantRepo")
public interface ParticipantRepo extends JpaRepository<Participant, Long> {

    //Event findByStartDate(String startdate);

}