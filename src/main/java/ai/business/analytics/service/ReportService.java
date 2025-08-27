package ai.business.analytics.service;

import ai.business.analytics.model.Report;
import java.util.List;

public interface ReportService {
	Report createReport(Report report);

	List<Report> getAllReports();

	Report updateReport(Long id, Report report);

	void deleteReport(Long id);
}