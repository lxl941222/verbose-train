package cn.itcast.core.service.brand;

import java.util.List;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.entity.Result;
import cn.itcast.core.pojo.good.Brand;

public interface BrandService {
	public List<Brand> findAll();
	
	//分页查询
	public PageResult findPage(Integer pageNum,Integer pageSize);
	//条件查询
	public PageResult search(Integer pageNum,Integer pageSize,Brand brand);
	//保存
	public void add(Brand brand);
	//根据id查找
	public Brand findById(Long id);
	//修改操作
	public void update(Brand brand);
	//删除操作
	public void del(Long[] ids);
}
