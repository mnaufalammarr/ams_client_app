$('#tableAdmSubmission').DataTable({
    ajax: {
        url: '/api/admin/submission',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data);
            return meta.row + 1
        }
    },{
        data:'name'
    },{
        data:'description'
    },{
        data:'qty'
    },{
        data:null,
        render: (data, type, row, meta) => {
            console.log(data)
            return rupiah(data.price)
        }
    },{
        data:null,
        render: (data, type, row, meta) => {
            return dateFormat(data.date,'dd-MM-yyyy')
        }
    },{
        data:'category.name'
    },{
        data:null,
        render: (data, type, row, meta) => {
            var status = data.approvedStatus == "PENDING_FINANCE" ? "PENDING" : data.approvedStatus;
            return `${status}`}
    }]
})
$('#tableAdmPenSubmission').DataTable({
    ajax: {
        url: '/api/admin/penSubmission',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            console.log(data);
            return meta.row + 1
        }
    },{
        data: null,
        render: (data, type, row, meta) => {
            console.log(data);
            return camelize(data.employee.firstName) + " " + camelize(data.employee.lastName)
        }
    },{
        data:'name'
    },{
        data:'description'
    },{
        data:'qty'
    },{
        data:null,
        render: (data, type, row, meta) => {
            return rupiah(data.price)
        }
    },{

        data:null,
        render: (data, type, row, meta) => {
            return dateFormat(data.date,'dd-MM-yyyy')
        }
    },{
        data:null,
        render: (data, type, row, meta) => {
            var status = data.approvedStatus == "PENDING_ADMIN" ? "PENDING" : data.approvedStatus;
            return `${status}`}
    },{
        data: null,
        render: function (data, type, row, meta) {
            return ` <button type="button" class="btn btn-labeled btn-outline-primary me-2" onclick="reviewReqAsset(${data.id},'PENDING_FINANCE')">
                Approve
            </button>
            <button type="button" class="btn btn-labeled btn-outline-warning me-2" onclick="reviewReqAsset(${data.id},'DENIED')">
                           Deny
                        </button>
            `;
        }
    }]
})
$('#tableAdmRevSubmission').DataTable({
    ajax: {
        url: '/api/admin/revSubmission',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            console.log(data);
            return meta.row + 1
        }
    },{
        data: null,
        render: (data, type, row, meta) => {
            console.log(data);
            return camelize(data.employee.firstName) + " " + camelize(data.employee.lastName)
        }
    },{
        data:'name'
    },{
        data:'description'
    },{
        data:'qty'
    },{
        data:'price'
    },{

        data:null,
        render: (data, type, row, meta) => {
            return dateFormat(data.date,'dd-MM-yyyy')
        }
    },{
        data:null,
        render: (data, type, row, meta) => {
            var status = data.approvedStatus == "PENDING_ADMIN" ? "PENDING" : (data.approvedStatus == "PENDING_FINANCE" ? "APPROVED" : data.approvedStatus);
            return `${status}`}
    }]
})

function reviewReqAsset(id, value) {
    var status = value == "PENDING_FINANCE" ? "APPROVED" : "DENIED";
    Swal.fire({
        title: 'Are you sure want to ' + status + ' this asset request?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "POST",
                url: "/api/review_asset/" + id,
                dataType: "JSON",
                beforeSend: addCsrfToken(),
                data: JSON.stringify({
                    assetStatus: value,
                }),
                contentType: "application/json",
                success: result => {
                    $('#tableAdmPenSubmission').DataTable().ajax.reload()
                    Swal.fire({
                        icon: 'success',
                        title: 'Review has been ' + status,
                        width: 600,
                        padding: '3em',
                        color: '#716add',
                        background: '#fff',
                        showConfirmButton: false,
                        timer: 1500,
                    })
                }
            })
        }
    })
}