package com.lanou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.bean.Student;

@Controller
public class MainController {

	// 处理请求
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String frontPage() {

		// 方法要返回jsp的文件名
		/// WEB-INF/pages/index.jsp

		return "index";
	}

	@RequestMapping(value = "/stu", method = RequestMethod.GET)
	@ResponseBody
	public Student jsonData() {

		Student student = new Student();

		student.setName("小明");

		student.setNum(35);

		student.setHobby("上网");

		return student;
	}

	// 咋么获取请求的参数
	// 1.在请求地址上添加{}字段，{}里面代表参数的代号
	// 2.在方法的参数位置，按如下结构写：
	// @PathVariable(参数代号)实际参数的类型 实际要使用的参数名
	// 在debug模式下，参数位置可以写成：
	// @pathVariable 实际参数类型 参数代号
	@RequestMapping(value = "/studata/{stuname}/{stunum}")
	@ResponseBody
	public Student varStu(@PathVariable("stuname") String name, @PathVariable("stunum") Integer num)

	{

		Student student = new Student();

		student.setName(name);

		student.setNum(num);
		return student;

	}

	// http://.../stuparm?name=xx&age=222
	@RequestMapping(value = "/stuparm")
	@ResponseBody
	public Student parmaStu(@RequestParam("name") String stuname) {
		Student student = new Student();

		student.setName(stuname);

		return student;
	}

	@RequestMapping(value = "/stuinfo")
	@ResponseBody
	public Student stuInfo(Student student) {

		System.out.println(student);

		return student;

	}
	
	//redirect重定向
	//返回字符串：redirect:要重定向的地址
	@RequestMapping(value="/redi")
	public String redi(){
		
		
		return "redirect:stu";
	}
	
	//forward 转发
}
// 从地址的参数列表中取得值得办法：
// 利用@requestparm

// 这种方法针对的请求地址的形状：
// http：//..stuparm?参数1=值1&参数2=值2
// 在controller代码中，在方法的参数位置可以选择两种写法：
// 1.@RequestParam(参数1)类型 实际使用的参数名
// 2.@RequestParam Map<参数类型，值类型> map参数名
