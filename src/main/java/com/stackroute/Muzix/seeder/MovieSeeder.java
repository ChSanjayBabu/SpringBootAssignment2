package com.stackroute.Muzix.seeder;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MovieSeeder {

    @Value("${id}")
    String id;
    @Value("${trackName}")
    String trackName;
    @Value("${trackComment}")
    String trackComment;
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
        track.setTrackId(Integer.parseInt(id));
        track.setTrackName(trackName);
        track.setComments(trackComment);
        trackRepository.save(track);
    }
}
