package com.ias.handyman.report.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class ReportServiceTest {
    @Mock
    com.ias.handyman.report.repository.ReportRepository reportRepository;
    @InjectMocks
    com.ias.handyman.report.service.ReportService reportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testConsultarTodos(){
        java.util.List<com.ias.handyman.report.entity.Report> result = reportService.consultarTodos();
        Assertions.assertEquals(java.util.Arrays.<com.ias.handyman.report.entity.Report>asList(new com.ias.handyman.report.entity.Report()), result);
    }

    @Test
    void testSearchByWeekAndIdentify(){
        when(reportRepository.findByEmployeeDocumentNumber(anyString())).thenReturn(java.util.Arrays.<com.ias.handyman.report.entity.Report>asList(new com.ias.handyman.report.entity.Report()));

        java.util.Map<java.lang.String,java.lang.Integer> result = reportService.searchByWeekAndIdentify(new com.ias.handyman.report.entity.Report());
        Assertions.assertEquals(new java.util.HashMap<java.lang.String,java.lang.Integer>(){{put("String",Integer.valueOf(0));}}, result);
    }

    @Test
    void testSubtactNumberDays(){
        java.lang.Integer result = reportService.subtactNumberDays(Integer.valueOf(0));
        Assertions.assertEquals(Integer.valueOf(0), result);
    }

    @Test
    void testSubtractTwoHoursTotal(){
        java.lang.Integer result = reportService.subtractTwoHoursTotal(Integer.valueOf(0), Integer.valueOf(0));
        Assertions.assertEquals(Integer.valueOf(0), result);
    }

    @Test
    void testDiffBetweenHours(){
        java.lang.Long result = reportService.diffBetweenHours(new java.util.GregorianCalendar(2021, java.util.Calendar.APRIL, 21, 11, 39).getTime(), new java.util.GregorianCalendar(2021, java.util.Calendar.APRIL, 21, 11, 39).getTime());
        Assertions.assertEquals(Long.valueOf(1), result);
    }

    @Test
    void testIncrementHours(){
        java.lang.Integer result = reportService.incrementHours(Integer.valueOf(0), Integer.valueOf(0));
        Assertions.assertEquals(Integer.valueOf(0), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme