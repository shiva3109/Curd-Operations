package spring_mvc.config;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring_mvc.dao.EmployeeDao;
import spring_mvc.dto.Employee;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao dao;
	
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView view = new ModelAndView();
		view.setViewName("register.jsp");
		
		view.addObject("employee", new Employee());
		
		return view;
		
	}
	
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute Employee employee) {
		ModelAndView view = new ModelAndView("login.jsp");
		Employee emp = dao.empSave(employee);
		view.addObject(emp);	
		return view;
	}
	
	@RequestMapping("/signin")
	public ModelAndView signin() {
		ModelAndView view = new ModelAndView("login.jsp");
		view.addObject("employee", new Employee());

		return view;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute Employee emp) {
		ModelAndView view = new ModelAndView();
		try {
			dao.loginEmp(emp);
			List<Employee> list = dao.empFetchAll();
			view.setViewName("display.jsp");
			view.addObject("list", list);
		} catch (Exception e) {
			view.addObject("employee", new Employee());
			view.setViewName("login.jsp");
		}
		return view;
		
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") int id) {
		ModelAndView view = new ModelAndView("display.jsp");
		Employee emp = dao.empDelete(id);
		List<Employee> list = dao.empFetchAll();
		view.addObject("list",list);
		return view;
			
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam("id") int id) {
		ModelAndView view = new ModelAndView("update.jsp");
		Employee emp = dao.fetch(id);
		view.addObject("emp", emp);
		
		return view;
			
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(@ModelAttribute Employee emp) {
		ModelAndView view = new ModelAndView("display.jsp");
		Employee emp1 = dao.empUpdate(emp);
		List<Employee> list = dao.empFetchAll();
		view.addObject("list",list);
		return view;
	}
	
	

	
		
}
