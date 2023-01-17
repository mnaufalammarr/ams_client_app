$(document).ready(function () {

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
                sum+=value.penalty
                $("#penalty").text(rupiah(sum));
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
    // ADMIN
    $.ajax({
        method: "GET",
        url: "/api/dashboard/admSubmission",
        dataType: "JSON",
        success: result => {
            $("#ReqSubAsset").text(result.length);
            console.log(result)
        }
    });
    $.ajax({
        method: "GET",
        url: "/api/dashboard/admReqSubmission",
        dataType: "JSON",
        success: result => {
            $("#PenSubAsset").text(result.length);
            console.log(result)
        }
    });
    $.ajax({
        method: "GET",
        url: "/api/dashboard/admListSubmission",
        dataType: "JSON",
        success: result => {
            $("#SubAsset").text(result.length);
            console.log(result)
        }
    });
    $.ajax({
        method: "GET",
        url: "/api/admin/available",
        dataType: "JSON",
        success: result => {
            $("#admAvailableAsset").text(result.length);
        }
    });
    $.ajax({
        method: "GET",
        url: "/api/dashboard/admReqRent",
        dataType: "JSON",
        success: result => {
            $("#ReqRentAsset").text(result.length);
            console.log(result)
        }
    });
    $.ajax({
        method: "GET",
        url: "/api/dashboard/admRent",
        dataType: "JSON",
        success: result => {
            $("#RentAsset").text(result.length);
            console.log(result)
        }
    });
    $.ajax({
        method: "GET",
        url: "/api/dashboard/admReport",
        dataType: "JSON",
        success: result => {
            $("#RepAsset").text(result.length);
            console.log(result)
        }
    });
    $.ajax({
        method: "GET",
        url: "/api/dashboard/admReturn",
        dataType: "JSON",
        success: result => {
            $("#DoneAsset").text(result.length);
            console.log(result)
        }
    });
    $.ajax({
        method: "GET",
        url: "/api/dashboard/admUser",
        dataType: "JSON",
        success: result => {
            $("#user").text(result.length);
            console.log(result)
        }
    });
    $.ajax({
        method: "GET",
        url: "/api/dashboard/pending_assets_finance",
        dataType: "JSON",
        success: result => {
            let sum = 0;
            $.each(result, function( index, value ) {
                $("#total-price").text(sum+=value.price);
            });

        }
    });

    $.ajax({
        method: "GET",
        url: "/api/dashboard/pending_assets_finance",
        dataType: "JSON",
        success: result => {
            $("#total-price").text(result.length);
        }
    });
    $.ajax({
        method: "GET",
        url: "/api/finance/departments",
        dataType: "JSON",
        success: result => {
            let sum = 0;
            $.each(result, function( index, value ) {
                sum+=value.balance
                $("#total-balance").text(rupiah(sum));
            });

        }
    });
    $.ajax({
        method: "GET",
        url: "/api/finance/recent_review",
        dataType: "JSON",
        success: result => {
            $("#total-recent").text(result.length);
        }
    });
});

