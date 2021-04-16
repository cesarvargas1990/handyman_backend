package com.ias.handyman.servicereport;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "test", path = "test")
@CrossOrigin
public interface TestRepository extends MongoRepository<Test, String> {
    List<Test> findByEmployeeDocumentNumber(@Param("employeeDocumentNumber") String name);
}
