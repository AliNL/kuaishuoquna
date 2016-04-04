/**
 * Created by yzhou on 4/4/16.
 */

$(document).ready(function(){
    var isLoggedIn = localStorage.getItem("UserName");

    if(!isNaN(isLoggedIn)){
        $("#isLoggedIn").show();
    }

    $("#logOut").click(function(){
        localStorage.removeItem("UserName");
        $("#isLoggedIn").hide();
    });
});
