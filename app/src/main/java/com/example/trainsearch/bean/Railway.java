package com.example.trainsearch.bean;

public class Railway {
    private String type = "";  //类型
    private String RNum = ""; //火车号
    private String start = ""; //起始站
    private String end = ""; //终点战
    private String startTime = ""; //发车时间
    private String endTime = ""; //到站时间
    private String FPrice = "无票"; //1等座价格
    private String SPrice = "无票"; //2等座价格
    private String BPrice = "无票"; //商务座价格
    private String HSPrice = "无票"; //硬座价格
    private String SSlPrice = "无票"; //软卧价格
    private String HSlPrice = "无票"; //硬卧价格
    private String OHours = ""; //运行时间

    public Railway(){

    }
    public Railway(String type, String RNum, String start, String end, String startTime, String endTime, String FPrice, String SPrice, String BPrice, String HSPrice, String SSlPrice, String HSlPrice, String OHours) {
        this.type = type;
        this.RNum = RNum;
        this.start = start;
        this.end = end;
        this.startTime = startTime;
        this.endTime = endTime;
        this.FPrice = FPrice;
        this.SPrice = SPrice;
        this.BPrice = BPrice;
        this.HSPrice = HSPrice;
        this.SSlPrice = SSlPrice;
        this.HSlPrice = HSlPrice;
        this.OHours = OHours;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRNum() {
        return RNum;
    }

    public void setRNum(String RNum) {
        this.RNum = RNum;
    }

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFPrice() {
        return FPrice;
    }

    public void setFPrice(String FPrice) {
        this.FPrice = FPrice;
    }

    public String getSPrice() {
        return SPrice;
    }

    public void setSPrice(String SPrice) {
        this.SPrice = SPrice;
    }

    public String getBPrice() {
        return BPrice;
    }

    public void setBPrice(String BPrice) {
        this.BPrice = BPrice;
    }

    public String getHSPrice() {
        return HSPrice;
    }

    public void setHSPrice(String HSPrice) {
        this.HSPrice = HSPrice;
    }

    public String getSSlPrice() {
        return SSlPrice;
    }

    public void setSSlPrice(String SSlPrice) {
        this.SSlPrice = SSlPrice;
    }

    public String getHSlPrice() {
        return HSlPrice;
    }

    public void setHSlPrice(String HSlPrice) {
        this.HSlPrice = HSlPrice;
    }

    public String getOHours() {
        return OHours;
    }

    public void setOHours(String OHours) {
        this.OHours = OHours;
    }
}
