$(document).ready(function () {
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
});