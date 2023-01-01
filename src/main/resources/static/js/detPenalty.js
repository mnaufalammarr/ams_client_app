$(document).ready(function() {
   var id = document.getElementById("idPenalty").value;
    $.ajax({
        method: "GET",
        url: "/api/penalty/"+id,
        dataType: "JSON",
        success: result => {
            console.log(result);
            console.log(dateFormat(`${result[0][4]}`, 'dd-MM-yyyy'))
            $("#namaAsset").text(`${result[0][0]}`)
            $("#pic").attr("src",`${result[0][1]}`)
            $("#description").text(`${result[0][2]}`)
            $("#start").val(`${dateFormat(`${result[0][3]}`, 'dd-MM-yyyy')}`)
            $("#end").val(`${dateFormat(`${result[0][4]}`, 'dd-MM-yyyy')}`)
            $("#accident").val(`${dateFormat(`${result[0][5]}`, 'dd-MM-yyyy')}`)
            $("#penaltyReason").val(`${result[0][6]}`+" ,"+` ${result[0][7]}`)
            $("#totPenalty").val(`${result[0][8]}`)
        }
    });
});


// console.log('Converted date: '+ dateFormat('2021-12-10', 'MM-dd-yyyy'));