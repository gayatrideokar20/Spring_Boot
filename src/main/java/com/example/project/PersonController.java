package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@RestController
@GraphQLApi
public class PersonController {

    @Autowired
    private PersonRepository repository;

    // @Value("classpath:person.graphqls")
    // private Resource schemaResource;

    // private GraphQL graphQL;

    /*
     * @PostConstruct public void loadSchema() throws IOException { File schemaFile
     * = schemaResource.getFile(); TypeDefinitionRegistry registry = new
     * SchemaParser().parse(schemaFile); RuntimeWiring wiring = buildWiring();
     * GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry,
     * wiring); graphQL = GraphQL.newGraphQL(schema).build(); }
     * 
     * private RuntimeWiring buildWiring() { DataFetcher<List<Person>> fetcher1 =
     * data -> { return (List<Person>) repository.findAll(); };
     * 
     * return RuntimeWiring.newRuntimeWiring() .type("Query", typeWriting ->
     * typeWriting.dataFetcher("getPersons", fetcher1)).build(); }
     * 
     * 
     * 
     * @PostMapping("/getAll") public ResponseEntity<Object> getAll(@RequestBody
     * String query) { ExecutionResult result = graphQL.execute(query); return new
     * ResponseEntity<Object>(result, HttpStatus.OK); }
     */

    @PostMapping("/addPerson")
    public String addPerson(@RequestBody List<Person> persons) {
        repository.saveAll(persons);
        return "record inserted " + persons.size();
    }

    @GraphQLQuery
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

}
