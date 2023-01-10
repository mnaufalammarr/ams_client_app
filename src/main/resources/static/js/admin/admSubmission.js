$('#tableAdmSubmission').DataTable({
    ajax: {
        url: '/api/admin/submission',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            return meta.row + 1
        }
    }, {
        data: 'name'
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return `<p style="line-height: 1.5em;
            height: 3em;       
            overflow: hidden; text-overflow: ellipsis">${data.description}</p>`
        }
    }, {
        data: 'qty'
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return `<strong>${rupiah(data.price)}</strong>`
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return dateFormat(data.date, 'dd-MM-yyyy')
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return `<span class="badge bg-info text-white">${data.category.name}</span>`
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            let status = data.approvedStatus == "PENDING_FINANCE" ? "PENDING" : data.approvedStatus;
            if (status === "APPROVED") {
                return `<span class="badge bg-success text-white">${status}</span>`
            } else {
                return `<span class="badge bg-warning text-white">${status}</span>`
            }
        }
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
            return meta.row + 1
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return camelize(data.employee.firstName) + " " + camelize(data.employee.lastName)
        }
    }, {
        data: 'name'
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return `<p style="line-height: 1.5em;
            height: 3em;       
            overflow: hidden; text-overflow: ellipsis">${data.description}</p>`
        }
    }, {
        data: 'qty'
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return `<strong>${rupiah(data.price)}</strong>`
        }
    }, {

        data: null,
        render: (data, type, row, meta) => {
            return dateFormat(data.date, 'dd-MM-yyyy')
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            let status = data.approvedStatus == "PENDING_ADMIN" ? "PENDING" : data.approvedStatus;
            if (status === "APPROVED") {
                return `<span class="badge bg-success text-white">${status}</span>`
            } else {
                return `<span class="badge bg-warning text-white">${status}</span>`
            }
        }
    }, {
        data: null,
        render: function (data, type, row, meta) {
            return ` <button type="button" class="btn btn-outline-primary" onclick="reviewReqAsset(${data.id},'PENDING_FINANCE')">
            <i class="fas fa-check"></i> Approve
            </button>
            <button type="button" class="btn btn-outline-warning" onclick="reviewReqAsset(${data.id},'DENIED')">
            <i class="fas fa-xmark"></i> Deny
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
            return meta.row + 1
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return camelize(data.employee.firstName) + " " + camelize(data.employee.lastName)
        }
    }, {
        data: 'name'
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return `<p style="line-height: 1.5em;
            height: 3em;       
            overflow: hidden; text-overflow: ellipsis">${data.description}</p>`
        }
    }, {
        data: 'qty'
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return `<strong>${rupiah(data.price)}</strong>`
        }
    }, {

        data: null,
        render: (data, type, row, meta) => {
            return dateFormat(data.date, 'dd-MM-yyyy')
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            let status = "";
            switch (data.approvedStatus) {
                case "PENDING_ADMIN":
                    status = "PENDING"
                    break;
                case "PENDING_FINANCE":
                    status = "APPROVED"
                    break;
                    default :
                    status = data.approvedStatus
            }
            // let status = data.approvedStatus == "PENDING_ADMIN" ? "PENDING" : (data.approvedStatus == "PENDING_FINANCE" ? "APPROVED" : data.approvedStatus);
            if (status === "APPROVED") {
                return `<span class="badge bg-success text-white">${status}</span>`
            } else {
                return `<span class="badge bg-warning text-white">${status}</span>`
            }
        }
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
                method: "PUT",
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