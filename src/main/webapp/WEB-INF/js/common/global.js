//项目根路径名
var basePath = getRoot() + "/";

function getRoot() {
    var curWwwPath = window.location.href;
    var pathName = window.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    var localhostPath = curWwwPath.substring(0, pos);
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPath + projectName);
}