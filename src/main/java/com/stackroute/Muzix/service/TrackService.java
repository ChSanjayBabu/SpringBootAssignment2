package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.domain.Track;
import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track);
    public List<Track> getAllTrack();
    public List<Track> updateComment(Track track);
    public Boolean deleteTrack(int trackId);
    public List<Track> trackByName(String trackName);

}
