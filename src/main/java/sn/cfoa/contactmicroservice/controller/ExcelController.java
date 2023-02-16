package sn.cfoa.contactmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import sn.cfoa.contactmicroservice.helper.ExcelHelper;
import sn.cfoa.contactmicroservice.message.ResponseMessage;
import sn.cfoa.contactmicroservice.service.impl.ExcelService;

@CrossOrigin("http://localhost:3001")
@RestController
@RequestMapping(path = "/api/contacts/excel", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
public class ExcelController {

	@Autowired
	private ExcelService excelService;
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file){
		String message = "";
		
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				excelService.save(file);
				message = "Uploaded the file seccessfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " +file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}
		
		message = "Please upload an excel file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}
	
	@GetMapping("/download")
	public ResponseEntity<Resource> getFile() {
		String filename = "contacts.xlsx";
		InputStreamResource file = new InputStreamResource(excelService.load());
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=" +filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
	}
	
}
