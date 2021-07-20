package com.example.project;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

import io.leangen.graphql.annotations.types.GraphQLType;

@Entity
@Table
@GraphQLType
public class Person {

    @Id
    @Column
    private Integer id;
    @Column
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(Integer id, String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [ name=" + name + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}