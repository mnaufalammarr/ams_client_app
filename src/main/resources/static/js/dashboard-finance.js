$(document).ready(function () {
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
