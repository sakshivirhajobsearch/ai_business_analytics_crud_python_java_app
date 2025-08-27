package ai.business.analytics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ai.business.analytics.model.Report;
import ai.business.analytics.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private ReportService reportService;

	@PostMapping
	public Report createReport(@RequestBody Report report) {
		return reportService.createReport(report);
	}

	@GetMapping
	public List<Report> getAllReports() {
		return reportService.getAllReports();
	}

	@PutMapping("/{id}")
	public Report updateReport(@PathVariable Long id, @RequestBody Report report) {
		return reportService.updateReport(id, report);
	}

	@DeleteMapping("/{id}")
	public String deleteReport(@PathVariable Long id) {
		reportService.deleteReport(id);
		return "Deleted report with id: " + id;
	}
}