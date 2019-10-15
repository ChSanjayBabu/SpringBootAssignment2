package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.repository.TrackRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImpl implements TrackService{
    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track savedTrack =trackRepository.save(track);
       return savedTrack;
    }

    @Override
    public List<Track> getAllTrack() {
        return (List<Track>) trackRepository.findAll();
    }

    @Override
    public List<Track> updateComment(Track track) {
        trackRepository.save(track);
        return (List<Track>) trackRepository.findAll();
    }

    @Override
    public Boolean deleteTrack(int trackId) {
        trackRepository.deleteById(trackId);
        return null;
    }
}
