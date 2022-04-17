package com.changfeng.movieweb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movieDB")
public interface MovieRepository extends MongoRepository<MovieDB, String>{

    @Query("{id:?0}")
    MovieDB findOneById(String id);

}
