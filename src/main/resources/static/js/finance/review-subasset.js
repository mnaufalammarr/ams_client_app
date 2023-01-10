$('#table-pending-asset').DataTable({
    ajax: {
        url: '/api/dashboard/pending_assets_finance',
        dataSrc: ''
    },
    columns: [{
            data: null,
            render: function (data, type, row, meta) {
                return meta.row + 1;
            }
        },
        {
            data: 'employee.firstName',
        },
        {
            data: 'employee.department.name',
        },
        {
            data: 'name',
        },
        {
            data: null,
            render: (data, type, row, meta) => {
                return `<p style="line-height: 1.5em;
            height: 3em;       
            overflow: hidden; text-overflow: ellipsis">${data.description}</p>`
            }
        },

        {
            data: null,
            render: (data, type, row, meta) => {
                return `<strong class="fw-bold my-auto">${rupiah(data.price)}</strong>`
            }
        },
        {
            data: 'qty',
        },
        {
            data: null,
            render: function (data, type, row, meta) {
                return ` <button type="button" class="btn btn-labeled btn-outline-primary me-2" onclick="reviewReqAsset(${data.id},${data.employee.department.balance},${data.price},'APPROVED')">
                <i class="fas fa-check"></i> Approve
            </button>
            <button type="button" class="btn btn-labeled btn-outline-warning me-2" onclick="reviewReqAsset(${data.id},${data.employee.department.balance},${data.price},'DENIED')">
            <i class="fas fa-xmark"></i> Deny
                        </button>
            `;
            }
        }
    ]
})

function reviewReqAsset(idAsset, departmentBalance, assetPrice, approvedStatusValue) {
    Swal.fire({
        title: 'Are you sure want to ' + approvedStatusValue + ' this asset request?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes',
    }).then((result) => {
        if (result.isConfirmed) {
            if (approvedStatusValue === 'APPROVED') {
                if (assetPrice > departmentBalance) {
                    Swal.fire({
                        icon: 'error',
                        title: 'Balance department not enough !',
                        width: 600,
                        padding: '3em',
                        color: '#716add',
                        background: '#fff',
                        showConfirmButton: false,
                        timer: 2000,
                    })
                } else {
                    $.ajax({
                        method: "PUT",
                        url: "/api/review_asset/" + idAsset,
                        dataType: "JSON",
                        beforeSend: addCsrfToken(),
                        data: JSON.stringify({
                            assetStatus: approvedStatusValue,
                        }),
                        contentType: "application/json",
                        success: result => {
                            $('#table-pending-asset').DataTable().ajax.reload()
                            Swal.fire({
                                icon: 'success',
                                title: 'Review has been ' + approvedStatusValue,
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
            } else {
                $.ajax({
                    method: "PUT",
                    url: "/api/review_asset/" + idAsset,
                    dataType: "JSON",
                    beforeSend: addCsrfToken(),
                    data: JSON.stringify({
                        assetStatus: approvedStatusValue,
                    }),
                    contentType: "application/json",
                    success: result => {
                        $('#table-pending-asset').DataTable().ajax.reload()
                        Swal.fire({
                            icon: 'success',
                            title: 'Review has been ' + approvedStatusValue,
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
        }
    })
}