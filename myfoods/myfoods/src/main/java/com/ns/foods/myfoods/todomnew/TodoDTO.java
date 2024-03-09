package com.ns.foods.myfoods.todomnew;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "todos")
public class TodoDTO {


    @Id
    private String id;
    private String todo;
    private String description;
    private Boolean completed;
    private Date createdAt;
    private Date updatedAt;

}
