package com.akshay.LeadManagmentProject.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.akshay.LeadManagmentProject.Model.LeadModel;
import com.akshay.LeadManagmentProject.Repository.LeadRepository;






@Controller
public class LeadController {

	@Autowired
	private LeadRepository leadRepository;
	
	
	
	@GetMapping("/")
    public String uploadForm(Model model) {
        model.addAttribute("message", "");
        return "upload";
    }
	
	@PostMapping("/upload")
    public String uploadExcel(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload.");
            return "upload";
        }
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<LeadModel> leadModelList = new ArrayList<>();
            
            boolean hasDuplicates = checkForDuplicates(leadModelList);
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            
            while (rows.hasNext()) {
                Row row = rows.next();
                
                if (row.getRowNum() == 0) continue;
              
                LeadModel leadModel= new LeadModel();
                
                Cell idCell = row.getCell(0);
              //leadModel.setId(row.getCell(0).getRowIndex());
                if (idCell != null) {
                    if (idCell.getCellType() == CellType.NUMERIC) {
                        // Handle numeric id (e.g., as an integer)
                    	leadModel.setId((int) idCell.getNumericCellValue());
                    } else if (idCell.getCellType() == CellType.STRING) {
                        // Handle string id
                    	leadModel.setId(Integer.parseInt(idCell.getStringCellValue()));
                    }
                }
                
                
                
                
                Cell numberOfEmployeeCell = row.getCell(1);
                //leadModel.setNumberOfEmployee(row.getCell(1).getNumericCellValue());
                if (numberOfEmployeeCell != null) {
                    if (numberOfEmployeeCell.getCellType() == CellType.NUMERIC) {
                    	leadModel.setNumberOfEmployee((int) numberOfEmployeeCell.getNumericCellValue());
                    }else if(numberOfEmployeeCell.getCellType() == CellType.STRING) {
                    	leadModel.setNumberOfEmployee(Integer.parseInt(numberOfEmployeeCell.getStringCellValue()));
                    }
                } 	
                
                //leadModel.setDate(row.getCell(2).getDateCellValue());
                Cell dateCell = row.getCell(2); // Adjust the cell index as per your Excel data
                if (dateCell != null) {
                    if (dateCell.getCellType() == CellType.NUMERIC) {
                        Date dateValue = dateCell.getDateCellValue();
                        leadModel.setDate(dateValue);
                    } else if (dateCell.getCellType() == CellType.STRING) {
                        try {
                            Date dateValue = dateFormat.parse(dateCell.getStringCellValue());
                            leadModel.setDate(dateValue);
                        } catch (ParseException e) {
                            // Handle date parsing error
                        }
                    }
                }
                
      
                leadModel.setLeadSolutionSuggested(row.getCell(3).getStringCellValue());
                leadModel.setLeadGenerated(row.getCell(4).getStringCellValue());
                leadModel.setLeadStatus(row.getCell(5).getStringCellValue());
                leadModel.setLeadSource(row.getCell(6).getStringCellValue());
                leadModel.setLifeCycleStages(row.getCell(7).getStringCellValue());
                leadModel.setCompanyName(row.getCell(8).getStringCellValue());
                leadModel.setWebsite(row.getCell(9).getStringCellValue());
                leadModel.setCompanyLinkedIn(row.getCell(10).getStringCellValue());
                
                Cell contactCell = row.getCell(11);
                //leadModel.setContactNumber(row.getCell(11).getStringCellValue());
                if (contactCell != null) {
                if (contactCell.getCellType() == CellType.NUMERIC) {
                    // Handle numeric phone number
                   leadModel.setContactNumber(String.valueOf(contactCell.getNumericCellValue()));
                } else if (contactCell.getCellType() == CellType.STRING) {
                    // Handle string phone number
                     leadModel.setContactNumber(contactCell.getStringCellValue());
                }
                }
                
                leadModel.setIndustry(row.getCell(12).getStringCellValue());
                leadModel.setStateAndCountry(row.getCell(13).getStringCellValue());
                leadModel.setAnnualRevenue(row.getCell(14).getStringCellValue());
                
                leadModel.setPartners(row.getCell(15).getStringCellValue());
                leadModel.setUse(row.getCell(16).getStringCellValue());
                leadModel.setFirstName(row.getCell(17).getStringCellValue());
                leadModel.setLastName(row.getCell(18).getStringCellValue());
                leadModel.setEmail(row.getCell(19).getStringCellValue());
                leadModel.setDesignation(row.getCell(20).getStringCellValue());
                leadModel.setMailingCountry(row.getCell(21).getStringCellValue());
                leadModel.setPersonLinkedInn(row.getCell(22).getStringCellValue());
                
                Cell phoneCell = row.getCell(23);
                //leadModel.setPhoneNumber(row.getCell(23).getStringCellValue());
                if (phoneCell != null) {
                    if (phoneCell.getCellType() == CellType.NUMERIC) {
                        // Handle numeric phone number
                       leadModel.setPhoneNumber(String.valueOf(phoneCell.getNumericCellValue()));
                    } else if (phoneCell.getCellType() == CellType.STRING) {
                        // Handle string phone number
                      leadModel.setPhoneNumber(phoneCell.getStringCellValue());
                    }
                }
                
                leadModel.setAdditionalDetails(row.getCell(24).getStringCellValue());
                //leadModel.setLastContactedDateAndTime(row.getCell(24).getDateCellValue());
                leadModel.setLatestComment(row.getCell(25).getStringCellValue());
                leadModel.setPersonSolutionSuggested(row.getCell(26).getStringCellValue());
                leadModel.setLeadManager(row.getCell(27).getStringCellValue());
                
                leadModelList.add(leadModel);
            }
                
             
            
            if (hasDuplicates) {
                model.addAttribute("message", "Duplicates found!");
            } else {
            	List<LeadModel> existingData = leadRepository.findAll();
                leadModelList.addAll(existingData);
            	leadRepository.saveAll(leadModelList); 
            model.addAttribute("message", "Excel file uploaded and data saved successfully.");
           
              //  model.addAttribute("message", "File processed successfully.");
            }
        } catch (IOException e) {
            model.addAttribute("message", "Error uploading Excel file: " + e.getMessage());
            e.printStackTrace();
        }

        return "upload";
    }

	private boolean checkForDuplicates(List<LeadModel> leadModelList) {
		for (LeadModel leadModel : leadModelList) {
            // Assuming 'email' is a unique identifier for leads, adjust this as needed
            String email = leadModel.getEmail();

            // Query the database to check if a lead with the same email exists
            LeadModel existingLead = leadRepository.findByEmail(email);

            if (existingLead != null) {
                // A lead with the same email already exists
                return true;
            }
        }

        // No duplicates found
        return false;
    }
    
	
	
}
