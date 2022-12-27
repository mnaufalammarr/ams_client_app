// Call the dataTables jQuery plugin
$(document).ready(function() {
    $('#dataTable').DataTable();
});

$(document).ready(function () {
    //Only needed for the filename of export files.
    //Normally set in the title tag of your page.
    document.title = "Card View DataTable";
    // DataTable initialisation
    $("#example").DataTable({
        dom: '<"dt-buttons"Bf><"clear">lirtp',
        paging: true,
        autoWidth: true,
        buttons: [
            "colvis",
            "copyHtml5",
            "csvHtml5",
            "excelHtml5",
            "pdfHtml5",
            "print"
        ],
        initComplete: function (settings, json) {
                    var labels = [];
                    $("#example thead th").each(function () {
                        labels.push($(this).text());
                    });
                    $("#example tbody tr").each(function () {
                        $(this)
                            .find("td")
                            .each(function (column) {
                                $("<span class='colHeader'>" + labels[column] + " </span>").prependTo(
                                    $(this)
                                );
                            });
                    });
                $("#example").toggleClass("card");
        }
    });
});
