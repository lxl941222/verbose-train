package cn.itcast.core.service.TypeTemplate;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.template.TypeTemplate;

public interface TypeTemplateService {
		public PageResult search(Integer page,Integer rows,TypeTemplate typeTemplate);
}
