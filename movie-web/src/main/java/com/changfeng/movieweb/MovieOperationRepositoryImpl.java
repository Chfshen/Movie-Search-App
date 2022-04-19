package com.changfeng.movieweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class MovieOperationRepositoryImpl implements MovieOperationRepository{
    @Autowired
    MongoOperations mongoOperations;

    public MovieDB findByIdAndLike(String id) {
        MovieDB movie;
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update().inc("like", 1);
        movie = mongoOperations.findAndModify(query, update,
                                    new FindAndModifyOptions().returnNew(true).upsert(true),
                                    MovieDB.class);
        return movie;
    }

    public MovieDB findByIdAndDislike(String id) {
        MovieDB movie;
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update().inc("dislike", 1);
        movie = mongoOperations.findAndModify(query, update,
                                    new FindAndModifyOptions().returnNew(true).upsert(true),
                                    MovieDB.class);
        return movie;
    }
}
