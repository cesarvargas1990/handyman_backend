package com.ias.handyman.report.controller;

import com.ias.handyman.report.entity.Report;
import com.ias.handyman.report.repository.ReportRepository;
import com.ias.handyman.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/report/search")
public class ReportController {
    @Autowired
    ReportService reportService;

    @RequestMapping(value = "/searchByWeekendAndEmployedNumber", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    @CrossOrigin
    Map<String, Integer> searchByWeekAndIdentify(@RequestBody Report report) {
        return reportService.searchByWeekAndIdentify(report);
    }


}
