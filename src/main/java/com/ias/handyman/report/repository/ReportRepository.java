package com.ias.handyman.report.repository;
import java.util.List;

import com.ias.handyman.report.entity.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "report", path = "report")
@CrossOrigin
public interface ReportRepository extends MongoRepository<Report, String> {
    List<Report> findByEmployeeDocumentNumber(@Param("employeeDocumentNumber") String employeeDocumentNumber);
}
