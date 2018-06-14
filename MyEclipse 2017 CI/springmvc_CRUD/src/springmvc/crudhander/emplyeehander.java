package springmvc.crudhander;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.tags.form.PasswordInputTag;

import springmvc.cruddao.DepartmentDao;
import springmvc.cruddao.EmployeeDao;
import springmvc.crudentity.Department;
import springmvc.crudentity.Employee;

@Controller
public class emplyeehander {
	
	@Autowired
	EmployeeDao employeeDao = new EmployeeDao();
	
	@Autowired
	DepartmentDao departmentDao = new DepartmentDao();
	
	@RequestMapping("/emp")
	public String listemplyee(Map<String, Object> map){
       map.put("employees",employeeDao.getAll() );		
		return "lists";
	}
	
	@RequestMapping(value = "/empss" , method = RequestMethod.PUT)
	public String Put(Employee employee){
		employeeDao.save(employee);
		return "redirect:/emp";
	}
	
	@ModelAttribute
	public void getemployee(@RequestParam(value = "id",required=false ) Integer id,Map<String, Object> map){
	    System.out.println(id);
		if(id != null){
			System.out.println(id+" is " +employeeDao.get(id));
			map.put("employee", employeeDao.get(id));
		}
		
		
	}
	
	
	@ResponseBody
	@RequestMapping("/testhttpmessageconver")
	public String testhttpmessage(@RequestBody String body){
		System.out.println(body);
		return "hello"+new Date()+body;
	}
	
	
	@RequestMapping(value="/emps" ,method = RequestMethod.GET)
	public String emps(Map<String, Object> map){
		map.put("deparment", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
	
	@RequestMapping(value = "emp/{id}",method = RequestMethod.GET)
	public String em(@PathVariable("id") Integer id,Map<String, Object> map){
		
		map.put("employee", employeeDao.get(id));
		map.put("deparment", departmentDao.getDepartments());
		return "input";
	}
	
	
	@RequestMapping(value="/empss" ,method = RequestMethod.POST)
	public String empss(Employee employee ,Map<String, Object> map){
		map.put("employees",employeeDao.getAll() );
		employeeDao.save(employee);
		System.out.println(employee);
		return "lists";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect:/emp";
	}
	
	@RequestMapping(value="/testconsever" ,method = RequestMethod.POST)
	public String  testconver(@RequestParam("employee") Employee employee){
		employeeDao.save(employee);
		return "redirect:/emp";
	}
	
	@ResponseBody
	@RequestMapping("/testjson")
	public Collection<Employee> testjson(){
		return employeeDao.getAll();
	}
	
	@RequestMapping("/i18n")
	public String testi18n(){
		return "i18n";
	}
	
	@RequestMapping("/testexceptionHandler")
	public String testexceptionHandler(@RequestParam("i") Integer i){
		String[] s = new String[10];
		System.out.println("testexceptionHandler"+s[i]);
		System.out.println("testexceptionHandler:"+10/i);	
		return "success";
	}
	

	
	
}
