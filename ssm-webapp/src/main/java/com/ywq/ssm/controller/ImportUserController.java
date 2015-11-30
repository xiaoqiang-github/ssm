package com.ywq.ssm.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
@RequestMapping(value="/user")
public class ImportUserController {

	@Resource(name="userService")
	public UserService userService;
	
	private static final String USER_FILE = "F:/user.xls";
	@RequestMapping(value="/importUser")
	public void importUserFromExcel(){
		FileInputStream in = null;
		List<User> userList = new ArrayList<User>();
		try {
			in = new FileInputStream(USER_FILE);
			Workbook workbook = new HSSFWorkbook(in);
			Sheet userSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = userSheet.iterator();
			
			//looping over each row
			while(rowIterator.hasNext()){
				User user = new User();
				Row row = rowIterator.next();
				
				// filter the header row.
				if(row.getRowNum()==0){
					continue;
				}
				
				Iterator<Cell> cellIterator = row.cellIterator();
				
				//looping over each cell of the give row
				while(cellIterator.hasNext()){
					Cell cell = cellIterator.next();
					if(cell.getColumnIndex()==0){
						user.setUserName(String.valueOf(cell.getStringCellValue()));
					}
					if(cell.getColumnIndex()==1){
						user.setNickName(String.valueOf(cell.getStringCellValue()));
					}
					if(cell.getColumnIndex()==2){
						user.setPassWord(String.valueOf(cell.getStringCellValue()));
					}
					if(cell.getColumnIndex()==3){
						user.setAddress(String.valueOf(cell.getStringCellValue()));
					}
				}
				
				userList.add(user);
			}
			
			for(User user : userList){
				System.out.println(user.toString());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(in!=null){
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
