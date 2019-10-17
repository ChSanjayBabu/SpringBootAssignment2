package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackDummyServiceImpl implements TrackService{
    TrackRepository trackRepository;

    @Autowired
    public TrackDummyServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void serviceUsed() {
        System.out.println("dummy");
    }

    @Override
    public Track saveTrack(Track track){
        if(trackRepository.existsById(track.getTrackId()))
            return null;
        Track savedTrack =trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTrack() {
        return (List<Track>) trackRepository.findAll();
    }

    @Override
    public Track updateTrack(Track track) {
        Track updatedtrack =trackRepository.save(track);
        return updatedtrack;
    }

    @Override
    public void deleteTrack(int trackId) {
        trackRepository.deleteById(trackId);
    }
    @Override
    public List<Track> trackByName(String trackName) {
        List<Track> tracks = trackRepository.getTrackByName(trackName);
        if(tracks.size()==0)
            return null;
        else
            return tracks;
    }

}
