$(document).ready(function () {
    $("#end-event").click(function () {
        var password = prompt("请输入创建者密码");
        if (hashCode(password) == $("#end-event").val()) {
            $("#end-form").submit();
        }
        else {
            alert("密码不正确！");
        }
    });
});

function hashCode(str) {
    var h = 0;
    var len = str.length;
    var t = 2147483648;
    for (var i = 0; i < len; i++) {
        h = 31 * h + str.charCodeAt(i);
        if(h > 2147483647) h %= t;
    }
    return h;
}