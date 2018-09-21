package cn.itcast.core.controller.specification;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.entity.Result;
import cn.itcast.core.pojo.specification.Specification;
import cn.itcast.core.service.specification.SpecificationService;
import cn.itcast.core.vo.SpecificationVo;

@RestController//将返回的字符串转成json串
@RequestMapping("/specification")
public class SpecificationController {
	
	@Reference
	private SpecificationService specificationService;
	
	@RequestMapping("/search.do")
	public PageResult search(Integer pageNum,Integer pageSize, @RequestBody Specification specification){
		
		return specificationService.search(pageNum, pageSize, specification);
	}
	
	
	@RequestMapping("/add.do")
	public Result save(@RequestBody SpecificationVo specificationVo){
		try {
			specificationService.add(specificationVo);
			return new Result(true,"新增成功");
		} catch (Exception e) {
			return new Result(false,"新增失败");
		}
		
	}
	
	@RequestMapping("/delete.do")
	public Result del(Long[] ids){
		try {
			specificationService.delete(ids);
			return new Result(true,"删除成功");
		} catch (Exception e) {
			return new Result(false,"删除失败");
		}
	}
}
