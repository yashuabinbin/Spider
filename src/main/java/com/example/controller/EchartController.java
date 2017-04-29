package com.example.controller;

import com.example.dto.CommonResult;
import com.example.enums.CommonEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lbb on 2017/4/25.
 */
@Controller
@RequestMapping(value = "/echart")
public class EchartController {


    @GetMapping(value = {"", "/"})
    public String index() {
        return "echart";
    }


    /**
     * 获取echarts需要展现的数据
     *
     * @return
     */
    @PostMapping(value = "/getData")
    @ResponseBody
    public CommonResult getData() throws InterruptedException {
        Random rand = new Random();
        List<String> nameList = new ArrayList<String>() {{
            for (int i = 0; i < 20; i++) {
                add(i + "");
            }
        }};

        List<Integer> dataList = new ArrayList<Integer>() {{
            for (int i = 0; i < 20; i++) {
                add(rand.nextInt(1000));
            }
        }};

        CommonResult result = new CommonResult(CommonEnum.Common_Success);
        result.putData("names", nameList)
                .putData("data", dataList);
        return result;
    }
}