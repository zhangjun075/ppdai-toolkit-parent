package com.ppdai.exception.deal.handler.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExceptionHandlerRepository<T> extends MongoRepository<T, String> {
  //
}