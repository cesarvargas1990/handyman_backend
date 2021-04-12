package com.ias.handyman.servicereport;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


import org.bson.BsonTimestamp;

public class Test {

    @Setter
    @Getter
    @Id
    public String id;
    public String employeeDocumentNumber;
    public String serviceId;
    public BsonTimestamp serviceDateStart;
    public BsonTimestamp serviceDateEnd;


}
