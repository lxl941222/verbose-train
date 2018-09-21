package cn.itcast.core.controller.brand;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.entity.Result;
import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.service.brand.BrandService;

@RestController//将返回的字符串转成json串
@RequestMapping("/brand")
public class BrandController {
	
	@Reference
	private BrandService brandService;
	
	@RequestMapping("findAll.do")
	public List<Brand> findAll(){
		
		return brandService.findAll();
	}
	
	
	@RequestMapping("findPage.do")
	public PageResult findPage(Integer pageNum, Integer pageSize){
		
		return brandService.findPage( pageNum, pageSize);
	}
	
	@RequestMapping("search.do")
	public PageResult search(Integer pageNum, Integer pageSize,@RequestBody Brand brand){
		
		return brandService.search( pageNum, pageSize,brand);
	}
	
	@RequestMapping("add.do")
	public Result add(@RequestBody Brand brand){
		try {
			brandService.add(brand);
			return new Result(true,"保存成功");
		} catch (Exception e) {
			return new Result(false,"保存失败");
		}
	}
	
	@RequestMapping("findOne.do")
	public Brand findById(Long id){
		
		return brandService.findById(id);
	}
	
	@RequestMapping("update.do")
	public Result update(@RequestBody Brand brand){
		try {
			brandService.update(brand);
			return new Result(true,"保存成功");
		} catch (Exception e) {
			return new Result(false,"保存失败");
		}
	}
	@RequestMapping("del.do")
	public Result del(Long[]ids){
		try {
			brandService.del(ids);
			return new Result(true,"删除成功");
		} catch (Exception e) {
			return new Result(false,"删除失败");
		}
	}
}
