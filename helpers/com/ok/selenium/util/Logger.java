package com.ok.selenium.util;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class Logger 
{
	static File logReport;
	static BufferedWriter logWriter;
	
	@BeforeClass
	public static void setUp() throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		DateFormat dateFormatFileName = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		
		System.out.println(dateFormatFileName.format(date));
		String junitReportFile = System.getProperty("user.dir") + "\\testreports\\" 
					+ dateFormatFileName.format(date) + " - WorldBankData - TC1 - Report.html";
		logReport = new File(junitReportFile);
		logWriter = new BufferedWriter(new FileWriter(logReport, true));
		logWriter.write("<html><body>");
		logWriter.write("<h1>Test Execution Summary - " + dateFormat.format(date) + "</h1>");
	}
	
	@AfterClass
	public static void tearDown() throws IOException {
		logWriter.write("</body></html>");
		logWriter.close();
		Desktop.getDesktop().browse(logReport.toURI());
	}
	
	public static void logMESSAGE(String description) {
		try {
			logWriter.write("<div style='color:000000'> ");
			logWriter.write(description);
			logWriter.write("</div>");
			logWriter.write("<br/>");
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
	
	public static void logSUCCESS(String description) {
		try {
			logWriter.write("<div style='color:00CB00'> ");
			logWriter.write(description);
			logWriter.write("</div>");
			logWriter.write("<br/>");
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
				
	public static void logFAIL(String description) {
			try {
				logWriter.write("<div style='color:FB0006'> ");
				logWriter.write(description);
				logWriter.write("</div>");
				logWriter.write("<br/>");
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
}