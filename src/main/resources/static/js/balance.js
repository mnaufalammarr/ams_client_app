$.ajax({
        method: "GET",
        url: "/api/finance/departments",
        dataType: "JSON",
        success: result => {
                console.log(result)
                $("#marketing-balance").text(rupiah(result[0].balance));
                $("#hr-balance").text(rupiah(result[1].balance));
                $("#it-balance").text(rupiah(result[2].balance));
        }
    });

    const rupiah = (number)=>{
        return new Intl.NumberFormat("id-ID", {
          style: "currency",
          currency: "IDR"
        }).format(number);
      }

