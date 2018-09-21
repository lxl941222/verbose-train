package cn.itcast.core.controller.typeTemplate;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.entity.Result;
import cn.itcast.core.pojo.template.TypeTemplate;
import cn.itcast.core.service.TypeTemplate.TypeTemplateService;

@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

	@Reference
	private TypeTemplateService typeTemplateService;
	@RequestMapping("/search.do")
	public PageResult search(Integer page,Integer rows,@RequestBody TypeTemplate typeTemplate){
		
		return typeTemplateService.search(page, rows, typeTemplate);
	}
}
