package cn.itcast.core.service.specification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.itcast.core.dao.specification.SpecificationDao;
import cn.itcast.core.dao.specification.SpecificationOptionDao;
import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.specification.Specification;
import cn.itcast.core.pojo.specification.SpecificationOption;
import cn.itcast.core.pojo.specification.SpecificationOptionQuery;
import cn.itcast.core.pojo.specification.SpecificationQuery;
import cn.itcast.core.vo.SpecificationVo;

@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private SpecificationDao specificationDao;
	@Autowired 
	private SpecificationOptionDao specificationOptionDao;
	
	@Override
	public PageResult search(Integer pageNum,Integer pageSize, Specification specification) {
		PageHelper.startPage(pageNum, pageSize);
		SpecificationQuery specificationQuery = new SpecificationQuery();
		if(specification.getSpecName()!=null&&!"".equals(specification.getSpecName().trim())){
			specificationQuery.createCriteria().andSpecNameLike("%"+specification.getSpecName().trim()+"%");
		}
		Page<Specification> page = (Page<Specification>) specificationDao.selectByExample(specificationQuery);
		specificationQuery.setOrderByClause("id desc");
		
		return new PageResult(page.getTotal(),page.getResult());
	}

	@Override
	public void add(SpecificationVo specificationVo) {
		//获取规格信息 (名字,id)
		Specification sepcification = specificationVo.getSpecification();
		specificationDao.insertSelective(sepcification);
		//获取规格具体信息(详细)
		List<SpecificationOption> specificationOption = specificationVo.getSpecificationOptionList();
		if(specificationOption!=null&&specificationOption.size()>0){
			//将规格信息的id赋值给具体信息的specid中 
			for (SpecificationOption specificationOption2 : specificationOption) {
				specificationOption2.setSpecId(sepcification.getId());
			}
			
			specificationOptionDao.insertSelectives(specificationOption);
		}
		
	
	}

	@Override
	public void delete(Long[] ids) {
		if(ids!=null&&ids.length>0){
			for (Long id : ids) {
				specificationDao.deleteByPrimaryKey(id);
				SpecificationOptionQuery specificationOptionQuery = new SpecificationOptionQuery();
				specificationOptionQuery.createCriteria().andIdEqualTo(id);
				specificationOptionDao.deleteByExample(specificationOptionQuery);
				
			}
		}
	}

}
