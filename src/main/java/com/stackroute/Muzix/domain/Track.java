package com.stackroute.Muzix.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@Data
public class Track {
    @Id
    int trackId;
    String trackName;
    String comments;
}
