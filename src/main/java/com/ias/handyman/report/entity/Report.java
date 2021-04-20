package com.ias.handyman.report.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.BsonTimestamp;
import org.springframework.data.annotation.Id;

public class Report {
    @Setter
    @Getter
    @Id
    public String id;
    public String employeeDocumentNumber;
    public String serviceId;
    public Integer weekendNumber;
    public BsonTimestamp serviceDateStart;
    public BsonTimestamp serviceDateEnd;
}
