package com.ywq.ssm.designModel.abstractFactory;

import com.ywq.ssm.designModel.abstractFactory.model.Boy;
import com.ywq.ssm.designModel.abstractFactory.model.Girl;
import com.ywq.ssm.designModel.abstractFactory.model.SmallBoy;
import com.ywq.ssm.designModel.abstractFactory.model.SmallGirl;
/**
 * 生产大小孩子(小男孩 、小女孩儿)
 * @author yangWeiQiang
 *
 */
public class SmallPersonFactory implements PersonFactory{

	@Override
	public Boy getBoy() {
		return new SmallBoy();
	}

	@Override
	public Girl getGirl() {
		return new SmallGirl();
	}

}
