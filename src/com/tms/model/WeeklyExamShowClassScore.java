package com.tms.model;

public class WeeklyExamShowClassScore {
	private String className;  //班级名称
	private String stuName;  //学员姓名
	private double weeklyExamScore;  //学员周考成绩
	private String weeklyyear;   
	private String weeklymonth;
	private String weeklyday;
	private String weeklyExamDay;   //周考时间（xxxx年xx月xx日）
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	public double getWeeklyExamScore() {
		return weeklyExamScore;
	}
	public void setWeeklyExamScore(double weeklyExamScore) {
		this.weeklyExamScore = weeklyExamScore;
	}
	public String getWeeklyday() {
		return weeklyday;
	}
	public void setWeeklyday(String weeklyday) {
		this.weeklyday = weeklyday;
	}
	
	public String getWeeklymonth() {
		return weeklymonth;
	}
	public void setWeeklymonth(String weeklymonth) {
		this.weeklymonth = weeklymonth;
	}
	
	public String getWeeklyyear() {
		return weeklyyear;
	}
	public void setWeeklyyear(String weeklyyear) {
		this.weeklyyear = weeklyyear;
	}
	
	public String getWeeklyExamDay() {
		return weeklyExamDay;
	}
	public void setWeeklyExamDay(String weeklyExamDay) {
		this.weeklyExamDay = weeklyExamDay;
	}

	
}
