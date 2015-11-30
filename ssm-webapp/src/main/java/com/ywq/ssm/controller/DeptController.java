package com.ywq.ssm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ywq.ssm.model.Dept;
import com.ywq.ssm.service.DeptService;
import com.ywq.ssm.utils.UUIDGenerator;

@Controller
@RequestMapping(value="dept")
public class DeptController extends BaseController{

	@Resource(name="deptService")
	private DeptService deptService;
	
	@RequestMapping(value="loadDeptTree")
	public void loadDeptTree(HttpServletResponse response){
		List<Dept> deptList = deptService.selectDept();
		JSONArray jsonObject = JSONArray.fromObject(deptList);
		this.send(jsonObject.toString(), response);
	}
	
	@RequestMapping(value="insertDept")
	public ModelAndView insertDept(){;
		Dept root = new Dept();
		root.setDeptId("0");
		root.setDeptName("公司");
		
		Dept dept1 = new Dept();
		dept1.setDeptId(UUIDGenerator.generateUUID());
		dept1.setDeptName("事业部");
		dept1.setParentDept(root);
		
		Dept dev1 = new Dept();
		dev1.setDeptId(UUIDGenerator.generateUUID());
		dev1.setDeptName("产品开发部");
		dev1.setParentDept(dept1);
		
		Dept test1 = new Dept();
		test1.setDeptId(UUIDGenerator.generateUUID());
		test1.setDeptName("产品测试部");
		test1.setParentDept(dept1);
		
		Dept dept2 = new Dept();
		dept2.setDeptId(UUIDGenerator.generateUUID());
		dept2.setDeptName("实施部");
		dept2.setParentDept(root);
		
		Dept shis = new Dept();
		shis.setDeptId(UUIDGenerator.generateUUID());
		shis.setDeptName("产品实施部");
		shis.setParentDept(dept2);
		
		Dept shis2 = new Dept();
		shis2.setDeptId(UUIDGenerator.generateUUID());
		shis2.setDeptName("项目实施部");
		shis2.setParentDept(dept2);
		
		Dept dept3 = new Dept();
		dept3.setDeptId(UUIDGenerator.generateUUID());
		dept3.setDeptName("销售部");
		dept3.setParentDept(root);
		
		Dept dept4 = new Dept();
		dept4.setDeptId(UUIDGenerator.generateUUID());
		dept4.setDeptName("财务部");
		dept4.setParentDept(root);
		
		deptService.insertDept(root);
		deptService.insertDept(dept1);
		deptService.insertDept(dev1);
		deptService.insertDept(test1);
		deptService.insertDept(dept2);
		deptService.insertDept(shis);
		deptService.insertDept(shis2);
		deptService.insertDept(dept3);
		deptService.insertDept(dept4);
		
		return null;
	}
}
