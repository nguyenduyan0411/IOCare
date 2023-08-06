package com.fpoly.iocare.rest.controller.admin;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

import com.fpoly.iocare.model.HistoryStudent;
import com.fpoly.iocare.service.IHistoryStudentService;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ExportDataRestController {
	@Autowired
	IHistoryStudentService historyStudentService;
	
	    @GetMapping("/export-excel")
	    public ResponseEntity<?> exportToExcel(@RequestParam(required = false) String fileName) {
	    	if (StringUtils.isEmpty(fileName)) {
	            fileName = "students.xlsx"; // Tên mặc định nếu không có tên file được cung cấp
	        } else if (!fileName.endsWith(".xlsx")) {
	            fileName += ".xlsx"; // Thêm đuôi ".xlsx" nếu tên file không kết thúc bằng ".xlsx"
	        }
	    	
	        List<HistoryStudent> Hlist = historyStudentService.getAll();
	       
	        
	        try (Workbook workbook = new XSSFWorkbook()) {
	            Sheet sheet = workbook.createSheet("sheet1");
	
	            // Create header row
	            Row headerRow = sheet.createRow(0);
	            headerRow.createCell(0).setCellValue("Campaign");
	            headerRow.createCell(1).setCellValue("Student Id");
	            headerRow.createCell(2).setCellValue("Student Name");
	            headerRow.createCell(3).setCellValue("Reason");
	            headerRow.createCell(4).setCellValue("Employee Name");
	
	            // Create data rows
	            int rowNum = 1;
	            for (HistoryStudent hlist : Hlist) {
	                Row row = sheet.createRow(rowNum);
	                row.createCell(0).setCellValue(hlist.getCampaign().getCampaignName());
	                row.createCell(1).setCellValue(hlist.getStudent().getStudentId());
	                row.createCell(2).setCellValue(hlist.getStudent().getStudentName());
	                row.createCell(3).setCellValue(hlist.getStudent().getReason());
	                row.createCell(4).setCellValue(hlist.getEmployee().getEmployeeName());
	                rowNum++;
	            }
	            
	            
	            // Generate file name and set content type
	            //String fileName = "students.xlsx";
	            HttpHeaders headers = new HttpHeaders();
	            UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
	                    .path("/api/export-excel")
	                    .queryParam("fileName", fileName);
	            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + UriUtils.encode(fileName, "UTF-8"));
	
	            // Các đoạn mã xuất Excel giữ nguyên
	
	            // Write workbook to response
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            workbook.write(outputStream);
	            byte[] excelBytes = outputStream.toByteArray();
	
	            return ResponseEntity.ok()
	                    .headers(headers)
	                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                    .body(excelBytes);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error exporting data to Excel");
	        }
	    }
}
