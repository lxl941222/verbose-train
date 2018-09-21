package cn.itcast.core.vo;

import java.io.Serializable;
import java.util.List;

import cn.itcast.core.pojo.specification.Specification;
import cn.itcast.core.pojo.specification.SpecificationOption;


public class SpecificationVo implements Serializable{
		private Specification specification;
		private List<SpecificationOption> specificationOptionList;
		public Specification getSpecification() {
			return specification;
		}
		public void setSpecification(Specification specification) {
			this.specification = specification;
		}
		public List<SpecificationOption> getSpecificationOptionList() {
			return specificationOptionList;
		}
		public void setSpecificationOptionList(List<SpecificationOption> specificationOptionList) {
			this.specificationOptionList = specificationOptionList;
		}
		public SpecificationVo(Specification specification, List<SpecificationOption> specificationOptionList) {
			super();
			this.specification = specification;
			this.specificationOptionList = specificationOptionList;
		}
		public SpecificationVo() {
			super();
		}
		
		
}
