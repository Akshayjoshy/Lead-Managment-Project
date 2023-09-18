package com.akshay.LeadManagmentProject.Controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.akshay.LeadManagmentProject.Model.LeadModel;
import com.akshay.LeadManagmentProject.Repository.LeadRepository;

@Controller
@RequestMapping("/export")
public class ExcelExportController {

	@Autowired
	private LeadRepository leadRepository;
	
	
	// Example method in your controller
	@GetMapping("/excel")
	public void exportLeadsToExcel(HttpServletResponse response) throws IOException {
	    List<LeadModel> leadData = leadRepository.findAll();

	    // Create an Excel workbook and populate it with data
	    Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("Lead Data");

	    int rowNum = 0;
	    for (LeadModel lead : leadData) {
	        Row row = sheet.createRow(rowNum++);
	        // Populate cells with lead data, e.g., row.createCell(0).setCellValue(lead.getId());
	       
            row.createCell(0).setCellValue(lead.getId());
            row.createCell(1).setCellValue(lead.getNumberOfEmployee());
            row.createCell(2).setCellValue(lead.getDate());
            row.createCell(3).setCellValue(lead.getLastContactedDateAndTime());
            row.createCell(4).setCellValue(lead.getLeadSolutionSuggested());
            row.createCell(5).setCellValue(lead.getLeadGenerated());
            row.createCell(6).setCellValue(lead.getLeadStatus());
            row.createCell(7).setCellValue(lead.getLeadSource());
            row.createCell(8).setCellValue(lead.getLifeCycleStages());
            row.createCell(9).setCellValue(lead.getCompanyName());
            row.createCell(10).setCellValue(lead.getWebsite());
            row.createCell(11).setCellValue(lead.getCompanyLinkedIn());
            row.createCell(12).setCellValue(lead.getContactNumber());
            row.createCell(13).setCellValue(lead.getIndustry());
            row.createCell(14).setCellValue(lead.getStateAndCountry());
            row.createCell(15).setCellValue(lead.getAnnualRevenue());
            row.createCell(16).setCellValue(lead.getPartners());
            row.createCell(17).setCellValue(lead.getUse());
            row.createCell(18).setCellValue(lead.getFirstName());
            row.createCell(19).setCellValue(lead.getLastName());
            row.createCell(20).setCellValue(lead.getEmail());
            row.createCell(21).setCellValue(lead.getDesignation());
            row.createCell(22).setCellValue(lead.getMailingCountry());
            row.createCell(23).setCellValue(lead.getPersonLinkedInn());
            row.createCell(24).setCellValue(lead.getPhoneNumber());
            row.createCell(25).setCellValue(lead.getAdditionalDetails());
            row.createCell(26).setCellValue(lead.getLatestComment());
            row.createCell(27).setCellValue(lead.getPersonSolutionSuggested());
            row.createCell(28).setCellValue(lead.getLeadManager());
	    }

	    // Set response headers and write the Excel file to the response output stream
	    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	    response.setHeader("Content-Disposition", "attachment; filename=leads.xlsx");

	    OutputStream outputStream = response.getOutputStream();
	    workbook.write(outputStream);
	    outputStream.close();
	}

}
