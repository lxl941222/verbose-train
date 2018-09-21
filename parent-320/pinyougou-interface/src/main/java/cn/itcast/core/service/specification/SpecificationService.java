package cn.itcast.core.service.specification;

import java.util.List;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.specification.Specification;
import cn.itcast.core.vo.SpecificationVo;

public interface SpecificationService {
	//条件查询
	public PageResult search(Integer pageNum,Integer pageSize,Specification specification);
	//增加规格
	public void add(SpecificationVo specificationVo);
	//删除操作
	public void delete(Long [] ids);
}
