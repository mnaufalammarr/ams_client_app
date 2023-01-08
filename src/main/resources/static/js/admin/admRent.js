$('#tableAdmPenRent').DataTable({
    ajax: {
        url: '/api/admin/penRent',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data);
            return meta.row + 1
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data);
            return camelize(data.employee.firstName) + " " + camelize(data.employee.lastName)
        }
    }, {
        data: 'asset.name'
    }, {
        data: 'note'
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return dateFormat(data.start, 'dd-MM-yyyy')
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return dateFormat(data.end, 'dd-MM-yyyy')
        }
    }, {
        data: null,
        render: function (data, type, row, meta) {
            return ` <button type="button" class="btn btn-labeled btn-outline-primary me-2" onclick="reviewReqRent(${data.id},'APPROVED')">
                Approve
            </button>
            <button type="button" class="btn btn-labeled btn-outline-warning me-2" onclick="reviewReqRent(${data.id},'DENIED')">
                           Deny
                        </button>
            `;
        }
    }]
})
$('#tableAdmRevRent').DataTable({
    ajax: {
        url: '/api/admin/revRent',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            console.log(data);
            return meta.row + 1
        }

    }, {
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data);
            return camelize(data.employee.firstName) + " " + camelize(data.employee.lastName)
        }
    }, {
        data: 'asset.name'
    }, {
        data: 'note'
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return dateFormat(data.start, 'dd-MM-yyyy')
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return dateFormat(data.end, 'dd-MM-yyyy')
        }
    }, {
        data: 'status'
    }, {
        data: null,
        render: function (data, type, row, meta) {
            if (data.status == "APPROVED") {
                return ` <button type="button" class="btn btn-labeled btn-outline-primary me-2" onclick="reviewReqRent(${data.id},'DONE')">
                Done
            </button>
            <button type="button" class="btn btn-labeled btn-outline-warning me-2" data-bs-toggle="modal" onclick="beforeCreate(${data.id})" >Report</button>`;

            } else {
                return `<button type="button" class="btn btn-labeled btn-outline-primary me-2" disabled>
                Done
            </button>
            <button type="button" class="btn btn-labeled btn-outline-warning me-2"  disabled>Report</button>`;
            }
        }
    }
    ]
})
$('#tableAdmRepRent').DataTable({
    ajax: {
        url: '/api/admin/repRent',
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
            return camelize(data[0])+" " + camelize(data[1]);
        }
    },{
        data: null,
        render: (data, type, row, meta) => {
            return data[2];
        }
    },{
        data: null,
        render: (data, type, row, meta) => {
            return data[3] + " karena " + data[4];
        }
    },{
        data: null,
        render: (data, type, row, meta) => {
            return rupiah(data[5]);
        }
    },{
        data: null,
        render: (data, type, row, meta) => {
            return dateFormat(data[6], 'dd-MM-yyyy');
        }
    },{
        data: null,
        render: (data, type, row, meta) => {
            return dateFormat(data[7], 'dd-MM-yyyy');
        }
    },{
        data: null,
        render: (data, type, row, meta) => {
            return dateFormat(data[8], 'dd-MM-yyyy');
        }
    }]
})
$('#tableAdmDoneRent').DataTable({
    ajax: {
        url: '/api/admin/doneRent',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data);
            return meta.row + 1
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data);
            return camelize(data.employee.firstName) + " " + camelize(data.employee.lastName)
        }
    }, {
        data: 'asset.name'
    }, {
        data: 'note'
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return dateFormat(data.start, 'dd-MM-yyyy')
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            return dateFormat(data.end, 'dd-MM-yyyy')
        }
    }]
})

function reviewReqRent(id, value) {
    Swal.fire({
        title: 'Are you sure want to ' + value + ' this asset request?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "GET",
                url: "/api/admin/getQty/" + id,
                dataType: "JSON",
                success: result => {
                    console.log(result);
                    if (value == "APPROVED") {
                        if (result.qty == 0) {
                            console.log(result);
                            Swal.fire(
                                'Failed!',
                                'Your Qty asset request is 0.',
                                'error'
                            )
                        } else {
                            $.ajax({
                                method: "PUT",
                                url: "/api/admin/reviewReqRent/" + id,
                                dataType: "JSON",
                                beforeSend: addCsrfToken(),
                                data: JSON.stringify({
                                    rentStatus: value,
                                }),
                                contentType: "application/json",
                                success: result => {
                                    $('#tableAdmPenRent').DataTable().ajax.reload()
                                    Swal.fire({
                                        icon: 'success',
                                        title: 'Request has been ' + value,
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
                            url: "/api/admin/reviewReqRent/" + id,
                            dataType: "JSON",
                            beforeSend: addCsrfToken(),
                            data: JSON.stringify({
                                rentStatus: value,
                            }),
                            contentType: "application/json",
                            success: result => {
                                $('#tableAdmPenRent').DataTable().ajax.reload()
                                $('#tableAdmRevRent').DataTable().ajax.reload()
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Request has been ' + value,
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
    })
}

function beforeCreate(id){
    $('#reportRentId').val(id);
    $('#reportRent').modal('show');
}

function createReport(){
    let id = $('#reportRentId').val();
    let date = $('#reportRentDate').val();
    let damage = $('#reportRentDamage').val();
    let incident = $('#reportRentIncident').val();
    let penalty = $('#reportRentPenalty').val();

    Swal.fire({
        title: 'Are you sure want to create report?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, update it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "PUT",
                url: "/api/admin/report/" + id,
                dataType: "JSON",
                beforeSend: addCsrfToken(),
                data: JSON.stringify({
                    dateAccident:date,
                    descDamage:damage,
                    descIncident:incident,
                    penalty:penalty,
                    adminId:1
                }),
                contentType: "application/json",
                success: result => {
                    console.log(id)
                    console.log(result);

                    $('#reportRent').modal('hide')
                    $('#tableAdmRevRent').DataTable().ajax.reload()
                   $('#reportRentId').val("")
                   $('#reportRentDate').val("")
                   $('#reportRentDamage').val("")
                   $('#reportRentIncident').val("")
                   $('#reportRentPenalty').val("")
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Report has been created!',
                        showConfirmButton: false,
                        timer: 1500
                    })
                }
            })
        }
    })
}