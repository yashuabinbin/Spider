package com.example.dto;

import com.example.enums.CommonEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lbb on 2017/4/25.
 */
public class CommonResult {

    private int state;

    private String stateInfo;

    private Map<String, Object> returnData = new HashMap<>();

    public CommonResult() {

    }

    public CommonResult(int state, String stateInfo, Map<String, Object> returnData) {
        this.state = state;
        this.stateInfo = stateInfo;
        this.returnData = returnData;
    }

    public CommonResult(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public CommonResult(CommonEnum commonEnum) {
        this.state = commonEnum.getState();
        this.stateInfo = commonEnum.getStateInfo();
    }


    /**
     * 放入返回对象
     *
     * @param name
     * @param data
     */
    public CommonResult putData(String name, Object data) {
        this.returnData.put(name, data);
        return this;
    }

    /**
     * 获取返回对象
     *
     * @param name
     * @return
     */
    public Object getData(String name) {
        return this.returnData.get(name);
    }


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

    public Map<String, Object> getReturnData() {
        return returnData;
    }

    public void setReturnData(Map<String, Object> returnData) {
        this.returnData = returnData;
    }

    public boolean isSuccess() {
        return state == CommonEnum.Common_Success.getState();
    }
}
