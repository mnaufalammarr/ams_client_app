$(document).ready(function () {

    console.log("document ready");
    $.ajax({
        method: "GET",
        url: "/api/dashboard/available",
        dataType: "JSON",
        success: result => {
            $("#available").text(result.length);
        }
    });
    $.ajax({
        method: "GET",
        url: "/api/dashboard/penalty",
        dataType: "JSON",
        success: result => {
            let sum = 0;
            $.each(result, function( index, value ) {
                $("#penalty").text(sum+=value.penalty);
            });

        }
    });
    $.ajax({
        method: "GET",
        url: "/api/dashboard/penalty",
        dataType: "JSON",
        success: result => {
            let sum = 0;
            $.each(result, function( index, value ) {
                $("#penalty").text(sum+=value.penalty);
            });

        }
    });
    $.ajax({
        method: "GET",
        url: "/api/dashboard/submission",
        dataType: "JSON",
        success: result => {
            $("#submission").text(result.length);
            console.log(result)
        }
    });
    $.ajax({
        method: "GET",
        url: "/api/dashboard/rent",
        dataType: "JSON",
        success: result => {
            $("#rent").text(result.length);
            console.log(result)
        }
    });
});