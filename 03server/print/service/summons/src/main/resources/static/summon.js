/**
 * Created by zzl009 on 2017/4/28.
 */
function Print() {

    var tit = document.title;
    document.title = "传票页面";
    var but1 = document.getElementById("but");
     but1.style.display = "none";
    window.print();
    document.title = tit;
    but1.style.display = "";

}
