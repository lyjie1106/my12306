package com.example.trainsearch.bean;

public class ResultBean {
    private String status;
    private String msg;
    private StationBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public StationBean getResult() {
        return result;
    }

    public void setResult(StationBean result) {
        this.result = result;
    }
}
