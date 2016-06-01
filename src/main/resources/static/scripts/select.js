$(document).ready(function() {
    $(".addButton").click(function() {
        var currentAction = $("#form").attr("action");
        var res = currentAction.split("/");
        var actionToBeConstructed = "/addProduct/" + res[2] + "/" +  $("#myselect").find(":selected").text();
        $("#form").attr("action", actionToBeConstructed);
    });

});
