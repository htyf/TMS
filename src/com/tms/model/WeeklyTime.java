package com.tms.model;


import java.util.Date;

public class WeeklyTime {
    private String weeklytimeid;

    private String weeklyyear;   //年

    private String weeklymonth;    //月

    private String weeklyday;     //第几周

    private Date weeklytime;   //具体的考试时间

    private String stuid;
    
    private int page;
    
    private int rows;

    private String classId;   //班级编号
    
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId ;
    }
    
    public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

    
   
    
    public String getWeeklytimeid() {
        return weeklytimeid;
    }

    public void setWeeklytimeid(String weeklytimeid) {
        this.weeklytimeid = weeklytimeid ;
    }

    public String getWeeklyyear() {
        return weeklyyear;
    }

    public void setWeeklyyear(String weeklyyear) {
        this.weeklyyear = weeklyyear ;
    }

    public String getWeeklymonth() {
        return weeklymonth;
    }

    public void setWeeklymonth(String weeklymonth) {
        this.weeklymonth = weeklymonth ;
    }

    public String getWeeklyday() {
        return weeklyday;
    }

    public void setWeeklyday(String weeklyday) {
        this.weeklyday = weeklyday ;
    }

    public Date getWeeklytime() {
        return weeklytime;
    }

    public void setWeeklytime(Date weeklytime) {
        this.weeklytime = weeklytime;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }
}