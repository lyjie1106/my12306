package com.example.trainsearch.bean;

import com.example.trainsearch.bean.RailwayBean;

import java.util.List;

public class StationBean {
    private String start;
    private String end;
    private String ishigh;
    private String date;
    private List<RailwayBean> list;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getIshigh() {
        return ishigh;
    }

    public void setIshigh(String ishigh) {
        this.ishigh = ishigh;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<RailwayBean> getList() {
        return list;
    }

    public void setList(List<RailwayBean> list) {
        this.list = list;
    }
}
