package com.example.dto;

import com.example.enums.CommonEnum;

/**
 * Created by lbb on 2017/4/25.
 */
public class ViewResult {

    private int state;

    private String stateInfo;

    private Object returnData;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Object getReturnData() {
        return returnData;
    }

    public void setReturnData(Object returnData) {
        this.returnData = returnData;
    }

    public ViewResult(int state, String stateInfo, Object returnData) {
        this.state = state;
        this.stateInfo = stateInfo;
        this.returnData = returnData;
    }

    public ViewResult(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public ViewResult(CommonEnum commonEnum) {
        this.state = commonEnum.getState();
        this.stateInfo = commonEnum.getStateInfo();
    }
}
