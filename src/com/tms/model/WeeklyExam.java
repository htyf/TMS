package com.tms.model;


public class WeeklyExam {
    private String weekliexamid;

    private Double weeklyexamscore;

    private String stuid;

    private String weeklytimeid;

    public String getWeekliexamid() {
        return weekliexamid;
    }

    public void setWeekliexamid(String weekliexamid) {
        this.weekliexamid = weekliexamid == null ? null : weekliexamid.trim();
    }

    public Double getWeeklyexamscore() {
        return weeklyexamscore;
    }

    public void setWeeklyexamscore(Double weeklyexamscore) {
        this.weeklyexamscore = weeklyexamscore;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
    }

    public String getWeeklytimeid() {
        return weeklytimeid;
    }

    public void setWeeklytimeid(String weeklytimeid) {
        this.weeklytimeid = weeklytimeid == null ? null : weeklytimeid.trim();
    }
}