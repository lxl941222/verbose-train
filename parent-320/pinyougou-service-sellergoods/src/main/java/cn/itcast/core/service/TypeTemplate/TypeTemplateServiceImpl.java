package cn.itcast.core.service.TypeTemplate;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.itcast.core.dao.template.TypeTemplateDao;
import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.template.TypeTemplate;
import cn.itcast.core.pojo.template.TypeTemplateQuery;

@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

	@Autowired
	private TypeTemplateDao typeTemplateDao;
	@Override
	public PageResult search(Integer page, Integer rows, TypeTemplate typeTemplate) {
		PageHelper.startPage(page, rows);
		TypeTemplateQuery typeTemplateQuery = new TypeTemplateQuery();
		if(typeTemplate.getName()!=null&&!"".equals(typeTemplate.getName())){
			typeTemplateQuery.createCriteria().andNameLike("%"+typeTemplate.getName()+"%");
		}
			typeTemplateQuery.setOrderByClause("id desc");
			Page<TypeTemplate> page1 = (Page<TypeTemplate>) typeTemplateDao.selectByExample(typeTemplateQuery);
			return new PageResult(page1.getTotal(),page1.getResult());
	}

}
