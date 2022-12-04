package com.concerto.springbootmvc.complaintmanagementsystem.excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Complaints;

public class ComplaintExcel {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private List<Complaints> listComplaints;

	public ComplaintExcel(List<Complaints> listComplaint) {
		this.listComplaints = listComplaint;

		workbook = new XSSFWorkbook();

	}

	// creation of cell

	private void create(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Long) {
			cell.setCellValue((Long) value);
		} else if (value instanceof Integer) {
			cell.setCellValue((Integer) value);

		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	// Heading portion

	private void writeHeaderLine() {
		sheet = workbook.createSheet("Complaints");

		// create for row
		Row row = sheet.createRow(0);

		// create heading portion or title type
		CellStyle style = workbook.createCellStyle();
		// create font
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(20);
		style.setFont(font);
		// alignment
		style.setAlignment(HorizontalAlignment.CENTER);
		create(row, 0, "Complaint_History", style);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
		font.setFontHeight((short) (20));

		row = sheet.createRow(1);
		font.setFontHeight(20);
		style.setFont(font);
		create(row, 1, "id", style);
		create(row, 2, "Description", style);
		create(row, 3, "Status", style);
		create(row, 4, "Comments", style);
		create(row, 5, "Customer id", style);
	}

	// write data excel in line
	private void writeDataLine() {
		int rowcount = 2;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();

		font.setFontHeight(14);
		style.setFont(font);

		for (Complaints complaint1 : listComplaints) {
			Row row = sheet.createRow(rowcount++);
			int columnCount = 1;
			create(row, columnCount++, complaint1.getComplaintId(), style);
			create(row, columnCount++, complaint1.getComplaintDescription(), style);
			create(row, columnCount++, complaint1.getSupport().getStatus(), style);
			create(row, columnCount++, complaint1.getSupport().getComments(), style);
			create(row, columnCount, complaint1.getCustomer().getCustomerId(), style);

		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLine();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}
}
