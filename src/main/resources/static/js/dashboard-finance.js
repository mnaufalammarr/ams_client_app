$(document).ready(function () {
    $.ajax({
            method: "GET",
            url: "/api/dashboard/pending_assets_finance",
            dataType: "JSON",
            success: result => {
                let sum = 0;
                $.each(result, function( index, value ) {
                    sum+=value.price
                    $("#total-price").text(rupiah(sum));
                });

            }
        });
});

const rupiah = (number)=>{
    return new Intl.NumberFormat("id-ID", {
      style: "currency",
      currency: "IDR"
    }).format(number);
  }
