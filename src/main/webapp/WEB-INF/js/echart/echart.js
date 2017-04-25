var ve = new Vue({
    el: '#chartDiv',
    created: function () {
        showChart1();
        setInterval(showChart1, 5000)
    },
    methods: {}
});


var chart1 = echarts.init($('#chart1')[0]);
chart1.setOption({
    title: {
        text: 'ECharts 入门示例'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['销量']
    },
    xAxis: {
        name: '种类',
        nameLocation: 'end',
        data: []
    },
    yAxis: {
        name: '数目',
        nameLocation: 'end',
        boundaryGap: ['0%', '100%']
    },
    series: [{
        name: '销量',
        type: 'line',
        data: []
    }],
    dataZoom: [
        {   // 这个dataZoom组件，默认控制x轴。
            type: 'slider', // 这个 dataZoom 组件是 slider 型 dataZoom 组件
            start: 10,      // 左边在 10% 的位置。
            end: 50         // 右边在 30% 的位置。
        },
        {   // 这个dataZoom组件，也控制x轴。
            type: 'inside', // 这个 dataZoom 组件是 inside 型 dataZoom 组件
            start: 10,      // 左边在 10% 的位置。
            end: 50         // 右边在 60% 的位置。
        }
    ],
});
chart1.showLoading();
chart1.on('click', function (params) {
    window.open('https://www.baidu.com/s?wd=' + encodeURIComponent(params.name));
});

var chart2 = echarts.init($('#chart2')[0]);
chart2.setOption({
    series: [
        {
            name: '访问来源',
            type: 'pie',
            radius: '55%',
            data: [
                {value: 235, name: '视频广告'},
                {value: 274, name: '联盟广告'},
                {value: 310, name: '邮件营销'},
                {value: 335, name: '直接访问'},
                {value: 400, name: '搜索引擎'}
            ]
        }
    ]
});

function showChart1() {
    $.post(basePath + "echart/getData", function (data) {
        chart1.hideLoading();
        chart1.setOption({
            xAxis: {
                data: data.returnData.names
            },
            series: [{
                // 根据名字对应到相应的系列
                name: '销量',
                data: data.returnData.data
            }]
        });
    });
}