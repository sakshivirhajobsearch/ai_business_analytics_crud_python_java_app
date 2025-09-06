package com.ai.business.analytics.service;

import java.util.List;

import com.ai.business.analytics.model.Report;

public interface ReportService {
	Report createReport(Report report);

	List<Report> getAllReports();

	Report updateReport(Long id, Report report);

	void deleteReport(Long id);
}