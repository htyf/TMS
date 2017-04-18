package com.tms.model;

public class WeeklyExamShowOne {
	private String classname; // 班级名称
	private int classStuNum;// 班级人数
	private int examStuNum;// 考试人数
	private double rateScore; // 平均分
	private String tname; // 授课老师名字
	private double highRate;// 高分率
	private double lowRate;// 低分率
	private double mediumRate;// 中分率
	private String classDesc;// 班级描述
	private String weeklyyear;
	private String weeklymonth;
	private String weeklyday;
	private String weeklyExamDay;//周考时间（xxxx年xx月xx日）
	
	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
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

	public int getClassStuNum() {
		return classStuNum;
	}

	public void setClassStuNum(int classStuNum) {
		this.classStuNum = classStuNum;
	}

	public int getExamStuNum() {
		return examStuNum;
	}

	public void setExamStuNum(int examStuNum) {
		this.examStuNum = examStuNum;
	}

	public double getRateScore() {
		return rateScore;
	}

	public void setRateScore(double rateScore) {
		this.rateScore = rateScore;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	
	public double getHighRate() {
		return highRate;
	}

	public void setHighRate(double highRate) {
		this.highRate = highRate;
	}

	public double getLowRate() {
		return lowRate;
	}

	public void setLowRate(double lowRate) {
		this.lowRate = lowRate;
	}

	public double getMediumRate() {
		return mediumRate;
	}

	public void setMediumRate(double mediumRate) {
		this.mediumRate = mediumRate;
	}

	public String getClassDesc() {
		return classDesc;
	}

	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}

}
