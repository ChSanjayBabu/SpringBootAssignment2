package com.stackroute.Muzix.controller;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@PropertySources({
        @PropertySource(value = "classpath:application-prod.properties"),
        @PropertySource(value = "classpath:application.properties")
})
@RestController
@RequestMapping(value="api/v1")
public class TrackController {

    TrackService trackService;

    @Autowired
    @Qualifier("trackDummyServiceImpl")
    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
        trackService.serviceUsed();
    }

    @PostMapping("save")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws Exception
    {
        ResponseEntity responseEntity;
            if(trackService.saveTrack(track)==null)
                throw new Exception("TrackAlreadyExists");
            responseEntity= new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
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
            responseEntity= new ResponseEntity<String>("successfully deleted", HttpStatus.OK);;
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
            trackService.updateTrack(track);
            responseEntity= new ResponseEntity<String>("successfully updated", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            responseEntity =new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("search/{name}")
    public ResponseEntity<?> searchTrack(@PathVariable String name) throws Exception
    {
        ResponseEntity responseEntity;
            if(trackService.trackByName(name) ==  null)
                throw new Exception("TrackNotFoundException");
            responseEntity =new ResponseEntity<String>("Search found",HttpStatus.CONFLICT);
        return responseEntity;
    }



}
