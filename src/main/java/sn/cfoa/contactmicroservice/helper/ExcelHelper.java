package sn.cfoa.contactmicroservice.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import sn.cfoa.contactmicroservice.model.Contact;

public class ExcelHelper {

	public static String Type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = {"nom", "prenom", "genre", "adresse", "telephone", "email", "type"};
	static String SHEET = "Contacts";
	static String SHEET1 = "Contacts";
	
	@SuppressWarnings("unlikely-arg-type")
	public static boolean hasExcelFormat(MultipartFile file) {
		if(!TYPE.FILE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}
	
	public static List<Contact> excelToContacts(InputStream is){
		try {
			Workbook workbook = new XSSFWorkbook(is);
			
			Sheet sheet = workbook.getSheet(SHEET1);
			Iterator<Row> rows = sheet.iterator();
			
			List<Contact> contacts = new ArrayList<Contact>();
			
			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				
				// skip header
				if(rowNumber == 0) {
					rowNumber++;
					continue;
				}
				
				Iterator<Cell> cellsInRow = currentRow.iterator();
				
				Contact contact = new Contact();
				
				int cellIdx = 0;
				while(cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					
					switch (cellIdx) {
					case 0:
						contact.setNom(currentCell.getStringCellValue());
						break;
					case 1:
						contact.setPrenom(currentCell.getStringCellValue());
						break;
					case 2:
						contact.setGenre(currentCell.getStringCellValue());
						break;
					case 3:
						contact.setAdresse(currentCell.getStringCellValue());
						break;
					case 4:
						contact.setTelephone(currentCell.getStringCellValue());
						break;
					case 5:
						contact.setEmail(currentCell.getStringCellValue());
						break;
					case 6:
						contact.setType(currentCell.getStringCellValue());
						break;
					default:
						break;
					}
					
					cellIdx++;
				}
				contacts.add(contact);
			}
			workbook.close();
			
			return contacts;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file:" + e.getMessage());
		}
	}

	public static ByteArrayInputStream contactsToExcel(List<Contact> contacts) {
		try(Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);
			
			// Header
			Row headerRow = sheet.createRow(0);
			
			for (int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
			}
			
			int rowIdx = 1;
			for(Contact contact : contacts) {
				Row row = sheet.createRow(rowIdx++);
				
				row.createCell(0).setCellValue(contact.getNom());
				row.createCell(1).setCellValue(contact.getPrenom());
				row.createCell(2).setCellValue(contact.getGenre());
				row.createCell(3).setCellValue(contact.getAdresse());
				row.createCell(4).setCellValue(contact.getTelephone());
				row.createCell(5).setCellValue(contact.getEmail());
				row.createCell(6).setCellValue(contact.getType());
			}
			
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " +e.getMessage());
		}
	}
}
