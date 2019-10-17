package com.stackroute.Muzix.seeder;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    TrackRepository repository;
    @Override
    public void run(String... args) throws Exception {
        // save a couple of customers
        Track track = new Track();
        track.setTrackName("Rainberry");
        track.setComments("by zyan malik");
        track.setTrackId(2);
        repository.save(track);

    }
}
