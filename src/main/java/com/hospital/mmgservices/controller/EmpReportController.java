package com.hospital.mmgservices.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.mmgservices.services.ReportService;

import net.sf.jasperreports.engine.JRException;

@SpringBootApplication
@RestController
public class EmpReportController {

	@Autowired
	private ReportService reportService;

	
	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return reportService.exportReport(format);
	}
}
