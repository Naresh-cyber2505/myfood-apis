package com.ns.foods.myfoods.todomnew.repo;

import com.ns.foods.myfoods.todomnew.TodoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<TodoDTO, String> {

    public default void getAllBy(){

    }

}
