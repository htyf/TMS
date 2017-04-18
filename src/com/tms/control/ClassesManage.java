package com.tms.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.alibaba.fastjson.JSON;
import com.tms.model.Classes;
import com.tms.service.ClassesManageService;

@Controller
@RequestMapping("/classManage")
public class ClassesManage {
    @Resource
    private ClassesManageService classesManageService;
    
	@RequestMapping("/showAllClasses")
	public void showAllClasses(HttpServletRequest request,
			HttpServletResponse response,int page,int rows){
		List<Classes> classes = this.classesManageService.getAllClasses((page-1)*rows,rows);
		//截取从数据库获取时间的年月日。
		for(int i = 0;i<classes.size();i++){
			String time = classes.get(i).getClassopentime();
			classes.get(i).setClassopentime(time.substring(0, 10));
		}
		int total = this.classesManageService.getAllCount();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
	    jsonMap.put("rows", classes);
	    try {
			response.getWriter().print(JSON.toJSONString(jsonMap));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/addOneClass")
	public void addOneClass(HttpServletRequest request,
			HttpServletResponse response,Classes classes){
		Classes class_one = getTidAndStuId(classes);
		
		int result = this.classesManageService.addOneClass(class_one);
		if(result>0){
			try {
				response.getWriter().write("0");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("/UpdateForClass")
	public void updateForClass(HttpServletRequest request,
			HttpServletResponse response,Classes classes){
		Classes classes_one = getTidAndStuId(classes);
		this.classesManageService.updateForClass(classes_one);
		try {
			response.getWriter().write("0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/deleteForClass")
	public void deleteForClass(HttpServletRequest request,
			HttpServletResponse response,String id){
		int num = this.classesManageService.searchIsContainStu(id);
		if(num>0){
			try {
				response.getWriter().write("1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			int result = this.classesManageService.deleteForClass(id);
			if(result>0){
				try {
					response.getWriter().write("0");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 根据输入的班长与授课教师的姓名，获取他们对应的id
	 * @param classes
	 * @return
	 */
	public Classes getTidAndStuId(Classes classes){
		String tid="";
		//根据教师的姓名，获取对应的id，并保存在班级表中。
		if(classes.getTname()== ""){
			classes.setClassteacid("0");
		}else{
			String tname = classes.getTname();
			tid = classesManageService.searchTid(tname);
			classes.setClassteacid(tid);
		}
		//根据学生的姓名获取对应的id，并保存在班级表中
		if(classes.getStuName() == ""){
			classes.setClassmonitorid("0");
		}else{
			String stuName = classes.getStuName();
			String stuId = classesManageService.searchStuId(stuName);
			classes.setClassmonitorid(stuId);
		}
		//判断是否面授，如果是面授则将教师表的授课方式 存为面授，否则存为视频或其他。
		if("面授".equals(classes.getTeachmethods())){
			classes.setTid(tid);
			classesManageService.updateTeachMethods(classes); 
			classes.setIsface(1);
		}else{
			String teachMethods = classes.getTeachmethods();
			classes.setTid(tid);
	        classesManageService.updateTeachMethods(classes);   
			classes.setIsface(0);
		}
		//根据就业指导老师的姓名，获取就业指导老师的id，并将id存入班级表中。
		if(classes.getJobteaname() != ""){
			String jobTeaName = classes.getJobteaname();		
			String jobDireId =  classesManageService.searchJobDireId(jobTeaName);
			classes.setJobdireteacid(jobDireId);
		}else{
			classes.setJobdireteacid("0");
		}
		
		//根据班主任的姓名，获取班主任的id，并存入班级表中。
		if(classes.getClassmanagername() == null){
			classes.setClassmanagerid("0");		
		}else{
			String classManagerId = classesManageService.searchClassManagerId(classes.getClassmanagername());
		    classes.setClassmanagerid(classManagerId);
		}
		//根据课程进度，获取课程进度的id，并存入班级表。
		if(classes.getCoursecontent() == ""){
			classes.setClasstaeclevelid("0");
		}else{
			String classTaecLevelId = classesManageService.searchTeachScheduleId(classes.getCoursecontent());
		    classes.setClasstaeclevelid(classTaecLevelId);
		}
		
		return classes;
	}
	
}
