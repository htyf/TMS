package com.tms.model;


import java.util.Date;

public class Classes {
    private String classid;

    private String classname;

    private String classopentime;

    private Integer classstunum;

    private String classmanagerid;

    private String classcategoryid;

    private String classdesc;

    private String classquality;

    private String jobdireteacid;

    private String classmonitorid;

    private String classteacid;

    private String classtaeclevelid;

    private Integer isface;

    private String stuName; //学生姓名
    
    private String tname;  //教师姓名
    
    private String tid; //教师编号
    
    private String teachmethods; // 是否面授。
    
    private String jobteaname; //就业指导老师姓名。
    
    private String classmanagername; //班主任姓名。
    
    private String coursecontent; //授课进度内容。
    
    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getClassopentime() {
        return classopentime;
    }

    public void setClassopentime(String classopentime) {
        this.classopentime = classopentime;
    }

    public Integer getClassstunum() {
        return classstunum;
    }

    public void setClassstunum(Integer classstunum) {
        this.classstunum = classstunum;
    }

    public String getClassmanagerid() {
        return classmanagerid;
    }

    public void setClassmanagerid(String classmanagerid) {
        this.classmanagerid = classmanagerid == null ? null : classmanagerid.trim();
    }

    public String getClasscategoryid() {
        return classcategoryid;
    }

    public void setClasscategoryid(String classcategoryid) {
        this.classcategoryid = classcategoryid == null ? null : classcategoryid.trim();
    }

    public String getClassdesc() {
        return classdesc;
    }

    public void setClassdesc(String classdesc) {
        this.classdesc = classdesc == null ? null : classdesc.trim();
    }

    public String getClassquality() {
        return classquality;
    }

    public void setClassquality(String classquality) {
        this.classquality = classquality == null ? null : classquality.trim();
    }

    public String getJobdireteacid() {
        return jobdireteacid;
    }

    public void setJobdireteacid(String jobdireteacid) {
        this.jobdireteacid = jobdireteacid == null ? null : jobdireteacid.trim();
    }

    public String getClassmonitorid() {
        return classmonitorid;
    }

    public void setClassmonitorid(String classmonitorid) {
        this.classmonitorid = classmonitorid == null ? null : classmonitorid.trim();
    }

    public String getClassteacid() {
        return classteacid;
    }

    public void setClassteacid(String classteacid) {
        this.classteacid = classteacid == null ? null : classteacid.trim();
    }

    public String getClasstaeclevelid() {
        return classtaeclevelid;
    }

    public void setClasstaeclevelid(String classtaeclevelid) {
        this.classtaeclevelid = classtaeclevelid == null ? null : classtaeclevelid.trim();
    }

    public Integer getIsface() {
        return isface;
    }

    public void setIsface(Integer isface) {
        this.isface = isface;
    }

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTeachmethods() {
		return teachmethods;
	}

	public void setTeachmethods(String teachmethods) {
		this.teachmethods = teachmethods;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getJobteaname() {
		return jobteaname;
	}

	public void setJobteaname(String jobteaname) {
		this.jobteaname = jobteaname;
	}

	public String getClassmanagername() {
		return classmanagername;
	}

	public void setClassmanagername(String classmanagername) {
		this.classmanagername = classmanagername;
	}

	public String getCoursecontent() {
		return coursecontent;
	}

	public void setCoursecontent(String coursecontent) {
		this.coursecontent = coursecontent;
	}
	
    
    
}