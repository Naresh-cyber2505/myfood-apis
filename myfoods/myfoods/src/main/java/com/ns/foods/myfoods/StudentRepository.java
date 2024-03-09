package com.ns.foods.myfoods;

import com.ns.foods.myfoods.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Integer> {



}
