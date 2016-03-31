package com.eventmanager.repo;

import com.eventmanager.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nathan on 3/31/2016.
 */
@Repository("eventRepo")
public interface EventRepo extends JpaRepository<Event, Long> {

    //Event findByStartDate(String startdate);

}