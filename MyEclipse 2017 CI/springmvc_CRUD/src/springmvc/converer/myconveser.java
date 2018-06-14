package springmvc.converer;
//jasgdajksgdksajgdjkasgd
//远程修改
//modif remote jshdfkjs+aaa+ddd
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import springmvc.crudentity.Department;
import springmvc.crudentity.Employee;

@Component
public class myconveser  implements Converter<String, Employee>{
	
	@Override
	public Employee convert(String sources) {
		if(sources !=null  ){
			String[] s = sources.split("-");
			if(s.length==4){
				String lastName = s[0];
				String email = s[1];
				Integer gender = Integer.parseInt(s[2]);
				Department department = new Department();
				department.setId(Integer.parseInt(s[3]));
				
				Employee employee = new Employee(null, lastName, email, gender, department);
				System.out.println(employee);
				return employee;
			}
		}
		return null;
	}
	

}
