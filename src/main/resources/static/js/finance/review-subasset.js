$('#table-pending-asset').DataTable({
    ajax: {
        url: '/api/dashboard/pending_assets_finance',
        dataSrc: ''
    },
    columns: [
    {
        data: null,
        render: function (data, type, row, meta) {
                    console.log(data)
                   return meta.row + 1
        }
    },
    {
                                        data: 'employee.firstName',
                                    },
    {
            data: 'name',
        },
        {
                    data: 'description',
                },

                                {
                                                    data: 'price',
                                                },
                                                {
                                                                    data: 'qty',
                                                                },
    {
        data: null,
        render: function (data, type, row, meta) {
            return ` <button type="button" class="btn btn-labeled btn-outline-primary me-2" onclick="reviewReqAsset(${data.id},'APPROVED')">
                Approve
            </button>
            <button type="button" class="btn btn-labeled btn-outline-warning me-2" onclick="reviewReqAsset(${data.id},'DENIED')">
                           Deny
                        </button>
            `;
        }
    }]
})

function reviewReqAsset(id, value) {
    Swal.fire({
        title: 'Are you sure want to' + value + 'this asset request?',
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
                    $('#table-pending-asset').DataTable().ajax.reload()
                    Swal.fire({
                        icon: 'success',
                        title: 'Review has been ' + value,
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

