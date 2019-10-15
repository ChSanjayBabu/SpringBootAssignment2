package com.stackroute.Muzix.controller;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {
    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }
    @PostMapping("save")
    public ResponseEntity<?> saveTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.saveTrack(track);
            responseEntity= new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            responseEntity =new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("/display")
    public ResponseEntity<?> getAllTrack()
    {
        return new ResponseEntity<List<Track>>(trackService.getAllTrack(),HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.deleteTrack(track.getTrackId());
            responseEntity= new ResponseEntity<String>("successfully created", HttpStatus.OK);;
        }
        catch (Exception e)
        {
            responseEntity =new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.saveTrack(track);
            responseEntity= new ResponseEntity<String>("successfully update", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            responseEntity =new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
