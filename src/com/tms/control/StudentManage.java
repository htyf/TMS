package com.tms.control;




import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.tms.model.Student;
import com.tms.service.StudentManageService;


@Controller
@RequestMapping("/studentManage")
public class StudentManage {
	@Resource
	private StudentManageService studentManageService;

	@RequestMapping("/addOneStudent")
	public void addOneUser(HttpServletRequest request,
			HttpServletResponse response, Model model, Student u){
		Map<String,Object> m = model.asMap();
		Student student = (Student) m.get("student");
		String result = this.studentManageService.InsertSelective(student)>0?"0":"1";
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/showStudent")
	public String toIndex(HttpServletRequest request, Model model, Student u) {
		String studentId = request.getParameter("id");
		Student student = this.studentManageService.getUserById(studentId);
		model.addAttribute("student", student);
		return "showStudent";
	}

	
	/*
	 * page锛氶〉鐮侊紝璧峰鍊�1銆�
       rows锛氭瘡椤垫樉绀鸿銆�
       
       
       total:  select count(1) from 琛ㄥ悕锛�
	 * 
	 * 
	 */
	
	@RequestMapping("/showAllStudent")
	public void showAllData(HttpServletRequest request,
			HttpServletResponse response, Model model, Student u,int page,int rows) {
		List<Student> student = this.studentManageService.getAllUser((page-1)*rows,rows);
		int total = this.studentManageService.getAllCount();
		Map<String, Object> jsonMap = new HashMap<String, Object>();//瀹氫箟map  
        jsonMap.put("total", total);//total閿�瀛樻斁鎬昏褰曟暟锛屽繀椤荤殑  
        jsonMap.put("rows", student);//rows閿�瀛樻斁姣忛〉璁板綍 list  
		try {
			response.getWriter().print(JSON.toJSONString(jsonMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/UpdateForStudent")
	public void UpdateForUser(HttpServletRequest request,
			HttpServletResponse response, Model model, Student u) {
		String num = this.studentManageService.updateByPrimaryKeySelective(u)>0?"0":"1";
		try {
			response.getWriter().print(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@RequestMapping("/deleteForStudent")
	public void DeleteForUser(HttpServletRequest request,
			HttpServletResponse response, String id){
		
		String num = this.studentManageService.deleteByPrimaryKey(id)>0?"0":"1";
		try {
			response.getWriter().print(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}