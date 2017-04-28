function preview() {
    console.log('preview()')
    localStorage["company"] = $("#courtName").val();
    localStorage["casenumName"] = $("#casenumName").val();
    localStorage["casenumWord"] = $("#casenumWord").val();
    localStorage["casenumCount"] = $("#casenumCount").val();
    localStorage["caseReason"] = $("#caseReason").val();
    localStorage["calledPerson"] = $("#calledPerson").val();
    localStorage["calledAddress"] = $("#calledAddress").val();
    localStorage["calledThing"] = $("#calledThing").val();
    localStorage["arrivalsYear"] = $("#arrivalsYear").val();
    localStorage["arrivalsMonth"] = $("#arrivalsMonth").val();
    localStorage["arrivalsDay"] = $("#arrivalsDay").val();
    localStorage["arrivalsHour"] = $("#arrivalsHour").val();
    localStorage["arrivalsMinute"] = $("#arrivalsMinute").val();
    localStorage["destination"] = $("#destination").val();
    localStorage["judge"] = $("#judge").val();
    localStorage["clerk"] = $("#clerk").val();
    localStorage["callYear"] = $("#callYear").val();
    localStorage["callMonth"] = $("#callMonth").val();
    localStorage["callDay"] = $("#callDay").val();
    window.location.href = "summons.html";

}