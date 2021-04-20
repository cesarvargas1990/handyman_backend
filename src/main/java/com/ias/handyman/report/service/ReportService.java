package com.ias.handyman.report.service;

import com.ias.handyman.report.entity.Report;
import com.ias.handyman.report.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.CastUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportService {
    @Autowired
    ReportRepository reportRepository;

    public List<Report> consultarTodos() {
        return reportRepository.findAll();
    }

    public Map <String, java.lang.Integer> searchByWeekAndIdentify(Report report) {

        Integer normalHoursTotal = 0;
        Integer nightHoursTotal = 0;
        Integer sundayHoursTotal = 0;
        Integer normalHoursTotalExtra = 0;
        Integer nightHoursTotalExtra = 0;
        Integer sundayHoursTotalExtra = 0;

        List<Report> reports;
        Map<String,Integer> output = new HashMap<>();

        reports = reportRepository.findByEmployeeDocumentNumber(report.employeeDocumentNumber);

        for (int i = 0; i < reports.size(); i++) {

            Long serviceStartDate = reports.get(i).serviceDateStart.getValue();
            Long serviceEndDate = reports.get(i).serviceDateEnd.getValue();

            Date startDate = new Date(serviceStartDate);
            Date endDate = new Date(serviceEndDate);

            Long diff = ((endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60);

            Calendar cl = Calendar.getInstance();
            cl.setTime(startDate);

            Integer weekNumber = cl.WEEK_OF_YEAR;
            System.out.println("--"+weekNumber);
            output.put("weekNumber",weekNumber);

            if (weekNumber == report.weekendNumber) {

                for (int x = 0; x<diff; x++) {

                    Date dti = new Date(startDate.getYear(), startDate.getMonth(), startDate.getDate(), startDate.getHours() + x, 0);
                    Date dtf = new Date(startDate.getYear(), startDate.getMonth(), startDate.getDate(), dti.getHours(), 59);

                    if (dti.getHours() >= 7 && dti.getMinutes() >= 0 && dtf.getHours() <= 19 && dtf.getMinutes() <= 59 && dti.getDay() >= 1 && dti.getDay() <= 6) {

                        normalHoursTotal = normalHoursTotal + 1;
                    }

                    if ((dti.getHours() >= 20 && dti.getMinutes() >= 0) && (dtf.getDay() >= 1 && dtf.getDay() <= 6)) {

                        nightHoursTotal = nightHoursTotal + 1;
                    }

                    if (dti.getDay() > dtf.getDay() && dtf.getHours() <= 6 && dtf.getMinutes() <= 59) {

                        nightHoursTotal = nightHoursTotal + 1;
                    }

                    if (dti.getDay() == 0) {

                        sundayHoursTotal = sundayHoursTotal + 1;
                    }

                    if (normalHoursTotal >= 48) {
                        normalHoursTotalExtra = normalHoursTotal - 48;
                        normalHoursTotal = normalHoursTotal - normalHoursTotalExtra;
                    }

                    if (nightHoursTotal >= 48) {
                        nightHoursTotalExtra = nightHoursTotal - 48;
                        nightHoursTotal = nightHoursTotal - nightHoursTotalExtra;
                    }

                    if (sundayHoursTotal >= 48) {
                        sundayHoursTotalExtra = sundayHoursTotal - 48;
                        sundayHoursTotal = sundayHoursTotal - sundayHoursTotalExtra;
                    }

                }

            }
            System.out.println(weekNumber);
        }



        System.out.println(normalHoursTotal+" -- "+nightHoursTotal+"--"+sundayHoursTotal);
        System.out.println(normalHoursTotalExtra+" -- "+nightHoursTotalExtra+"--"+sundayHoursTotalExtra);


        output.put("normalHoursTotal", normalHoursTotal);
        output.put("nightHoursTotal",nightHoursTotal);
        output.put("sundayHoursTotal",sundayHoursTotal);
        output.put("normalHoursTotalExtra",normalHoursTotalExtra);
        output.put("nightHoursTotalExtra",nightHoursTotalExtra);
        output.put("sundayHoursTotalExtra",sundayHoursTotalExtra);


        return output;


        //return reportRepository.findByEmployeeDocumentNumber(report.employeeDocumentNumber);
    }

}
