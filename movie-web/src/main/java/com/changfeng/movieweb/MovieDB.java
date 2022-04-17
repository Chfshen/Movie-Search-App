package com.changfeng.movieweb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("movies")
public class MovieDB {

    @Id private String id;
    private int like;
    private int dislike;

}
