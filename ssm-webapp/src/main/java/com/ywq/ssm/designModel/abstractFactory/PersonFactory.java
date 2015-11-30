package com.ywq.ssm.designModel.abstractFactory;

import com.ywq.ssm.designModel.abstractFactory.model.Boy;
import com.ywq.ssm.designModel.abstractFactory.model.Girl;
/**
 * 提供生产男孩儿 和 女孩儿的接口
 * 让其他工厂各自实现自己的逻辑
 * @author yangWeiQiang
 *
 */
public interface PersonFactory {

	public Boy getBoy();
	
	public Girl getGirl();
}
