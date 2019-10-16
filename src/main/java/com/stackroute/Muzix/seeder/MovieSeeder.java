package com.stackroute.Muzix.seeder;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MovieSeeder {
    TrackRepository trackRepository;

    @Autowired
    public MovieSeeder(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    @EventListener
    public void seed(ContextRefreshedEvent event)
    {
        seedTrackTable();
    }
    private void seedTrackTable()
    {
        Track track =new Track();
        track.setTrackId(1);
        track.setTrackName("Closer");
        track.setComments("Good song");
        trackRepository.save(track);
    }
}
