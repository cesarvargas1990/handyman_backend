package com.ias.handyman.report.service;

import com.ias.handyman.report.entity.Report;
import com.ias.handyman.report.repository.ReportRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;

class ReportServiceTest {
    @Mock
    ReportRepository reportRepository;
    @InjectMocks
    ReportService reportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testSubtactNumberDays() {
        Integer result = reportService.subtactNumberDays(Integer.valueOf(200));
        Assertions.assertEquals(Integer.valueOf(152), result);
    }

    @Test
    void testSubtractTwoHoursTotal() {
        Integer result = reportService.subtractTwoHoursTotal(Integer.valueOf(0), Integer.valueOf(0));
        Assertions.assertEquals(Integer.valueOf(0), result);
    }

    @Test
    void testDiffBetweenHours() {
        Long result = reportService.diffBetweenHours(new Date(2021, 4, 21, 11, 39), new Date(2021, 4,21,12,39));
        Assertions.assertEquals(Long.valueOf(1), result);
    }

    @Test
    void testIncrementHours() {
        Integer result = reportService.incrementHours(Integer.valueOf(0), Integer.valueOf(0));
        Assertions.assertEquals(Integer.valueOf(0), result);
    }
}