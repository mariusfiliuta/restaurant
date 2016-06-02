$(document).ready(function() {
    $("#myselect").change(function() {
        var currentAction = $("#form").attr("action");
        var res = currentAction.split("/");
        var actionToBeConstructed = "/requestIngredients/" + res[2] + "/" + $(this).find(":selected").val();
        $("#form").attr("action", actionToBeConstructed);
    });
});