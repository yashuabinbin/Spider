///**
// * 项目的根路径
// * @type {string}
// */
//var basePath = getRoot() + "/";
//function getRoot() {
//    var curWwwPath = window.location.href;
//    var pathName = window.location.pathname;
//    var pos = curWwwPath.indexOf(pathName);
//    var localhostPath = curWwwPath.substring(0, pos);
//    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
//    return (localhostPath + projectName);
//}


/**
 * 拦截全局的ajax请求，如果返回的状态码是701，则跳转至登录页面
 */
$.ajaxSetup({
    type: 'POST',
    complete: function (xhr) {
        if (xhr.status == 701) {
            window.location.href = basePath + "login.action";
        }
    }
});