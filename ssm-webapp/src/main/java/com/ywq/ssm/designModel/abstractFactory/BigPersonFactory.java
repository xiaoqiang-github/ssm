package com.ywq.ssm.designModel.abstractFactory;

import com.ywq.ssm.designModel.abstractFactory.model.BigBoy;
import com.ywq.ssm.designModel.abstractFactory.model.BigGirl;
import com.ywq.ssm.designModel.abstractFactory.model.Boy;
import com.ywq.ssm.designModel.abstractFactory.model.Girl;

/**
 * 生产大孩子(大男孩 、大女孩儿)
 * @author yangWeiQiang
 *
 */
public class BigPersonFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		return new BigBoy();
	}

	@Override
	public Girl getGirl() {
		return  new BigGirl();
	}

}
