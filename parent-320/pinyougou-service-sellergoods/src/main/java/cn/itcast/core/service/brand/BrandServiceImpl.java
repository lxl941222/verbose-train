package cn.itcast.core.service.brand;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.itcast.core.dao.good.BrandDao;
import cn.itcast.core.entity.PageResult;
import cn.itcast.core.entity.Result;
import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.pojo.good.BrandQuery;
import cn.itcast.core.pojo.good.BrandQuery.Criteria;
import cn.itcast.core.service.brand.BrandService;
@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandDao brandDao;
	@Override
	public List<Brand> findAll() {
		List<Brand> list = brandDao.selectByExample(null);
		return list;
	}
	
	
	@Override
	public PageResult findPage(Integer pageNum, Integer pageSize) {
		//分页助手设置分页条件
		PageHelper.startPage(pageNum, pageSize);
		//查询结果集
		Page <Brand> page = (Page<Brand>) brandDao.selectByExample(null);
		return new PageResult(page.getTotal(),page.getResult());
	}

		//条件查询
	@Override
	public PageResult search(Integer pageNum, Integer pageSize, Brand brand) {
		//分页助手设置分页条件
		Page<Brand> page = PageHelper.startPage(pageNum, pageSize);
		//封装查询条件
		BrandQuery brandQuery = new BrandQuery();
		Criteria createCriteria = brandQuery.createCriteria();//criteria相当于一个list
		if(brand.getName()!=null && !"".equals(brand.getName().trim())){
				createCriteria.andNameLike("%"+brand.getName().trim()+"%");
		}
		if(brand.getFirstChar()!=null && !"".equals(brand.getFirstChar().trim())){
				createCriteria.andFirstCharEqualTo(brand.getFirstChar().trim());
		}
		//查询结果集
		brandQuery.setOrderByClause("id desc" );
		page = (Page<Brand>) brandDao.selectByExample(brandQuery);
		
		return new PageResult(page.getTotal(),page.getResult());
	}

	@Transactional
	@Override
	public void add(Brand brand) {
		String upperCase = brand.getFirstChar().toUpperCase();
		brand.setFirstChar(upperCase);
		brandDao.insertSelective(brand);
	}


	@Override
	public Brand findById(Long id) {
		
		return brandDao.selectByPrimaryKey(id);
	}

	@Transactional
	@Override
	public void update(Brand brand) {
		brandDao.updateByPrimaryKeySelective(brand);
	}

	@Transactional
	@Override
	public void del(Long[] ids) {
		if(ids!=null&&ids.length>0){
		brandDao.deleteByPrimaryKeys(ids);
		}
	}
}
