package ai.business.analytics.service;

import ai.business.analytics.model.Report;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

	private final Map<Long, Report> reportStore = new HashMap<>();
	private Long currentId = 1L;

	@Override
	public Report createReport(Report report) {
		report.setId(currentId++);
		reportStore.put(report.getId(), report);
		return report;
	}

	@Override
	public List<Report> getAllReports() {
		return new ArrayList<>(reportStore.values());
	}

	@Override
	public Report updateReport(Long id, Report updatedReport) {
		Report existing = reportStore.get(id);
		if (existing != null) {
			updatedReport.setId(id);
			reportStore.put(id, updatedReport);
			return updatedReport;
		}
		return null;
	}

	@Override
	public void deleteReport(Long id) {
		reportStore.remove(id);
	}
}
