package com.ywq.ssm.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ywq.ssm.model.User;
import com.ywq.ssm.service.UserService;

@Controller
public class ExportUserControler {

	private static final String OUT_PATH = "F:/";
	
	@Resource(name="userService")
	private UserService userService;
	
	//export user data to excel.
	@RequestMapping(value="/exportUser")
	private void exportUserToExcel() {
		// build testing data
		List<String> header = bulidHeader();
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("user");
		Row headerRow = sheet.createRow(0);
		
		int cnum = 0;
		for(String key:header){
			Cell cell = headerRow.createCell(cnum++);
			cell.setCellValue(key);
		}
		
		List<User> userList = buildData();
		int rownum = 1;
		for(User user:userList){
			Row row = sheet.createRow(rownum++);
			
			int cellnum = 0;
			row.createCell(cellnum++).setCellValue(user.getUserName());;
			row.createCell(cellnum++).setCellValue(user.getNickName());;
			row.createCell(cellnum++).setCellValue(user.getPassWord());;
			row.createCell(cellnum++).setCellValue(user.getAddress());;
			
		}
		
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(OUT_PATH+"export_student.xls");
			workbook.write(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(out!=null){
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private List<String> bulidHeader(){
		List<String> header = new ArrayList<String>();
		header.add("名字");
		header.add("昵称");
		header.add("密码");
		header.add("地址");
		return header;
	}
	
	private List<User> buildData(){
		return userService.selectUserByParam(null);
	}
	
	public static void main(String[] args) {
		new ExportUserControler().exportUserToExcel();
	}
}
