package com.ywq.ssm.utils;

import java.util.Iterator;
import java.util.Map;

/**
 * Map工具类
 * @author YangWeiQiang
 *
 */
public class MapUtil {

	public void print(Map map){
		Iterator iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Object obj = iterator.next();
			System.out.println(obj);
		}
	}
}
