package com.changfeng.movieweb;

public interface MovieOperationRepository {
    MovieDB findByIdAndLike(String id);

    MovieDB findByIdAndDislike(String id);
}
