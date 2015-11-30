package com.ywq.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ywq.ssm.model.Fruit;

@Controller
@RequestMapping(value="fruit")
public class FruitController {

	@RequestMapping(value="{fruitName}",method=RequestMethod.GET)
	public String getFruit(@PathVariable(value="fruitName") String fruitName ,ModelMap model){
		Fruit fruit = new Fruit(fruitName+"__我是中文哦！！", 1000);
		model.addAttribute("model", fruit);
		return "fruit";
	}
	
	@RequestMapping(value="/query/{fruitName}",method=RequestMethod.GET)
	public ModelAndView queryFruit(@PathVariable(value="fruitName") String fruitName){
		Fruit fruit = new Fruit(fruitName, 2000);
		Map<String,Object> model = new HashMap<String, Object>();
		model.put("model", fruit);
		model.put("msg", "don't miss");
		Map<String,Object> model2 = new HashMap<String, Object>();
		model2.put("model2", fruit);
		model2.put("msg2", "2222222");
		return new ModelAndView("fruit", model2);
	}
	
	@RequestMapping(value="/queryJson/{quality}/{name}",method=RequestMethod.GET)
	@ResponseBody
	public String queryJsonFruit(@PathVariable String name,@PathVariable int quality){
		Fruit fruit = new Fruit(name,quality+100);
		
		return JSONObject.fromObject(fruit).toString();
	}
}
