$("#list-user").DataTable({
    ajax: {
        url: "/api/admin/list-user",
        dataSrc: "",
    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            console.log(data);
            return meta.row + 1;
        },
    },
        {
            data: null,
            render: (data, type, row, meta) => {
                return `<p>${data.employee.firstName} ${data.employee.lastName}</p>`
            },
        },
        {
            data: "employee.phoneNumber",
        },
        {
            data: "username",
        },
        {
            data: "roles[0].name",
        },
        {
            data: null,
            render: (data, type, row, meta) => {
                if (!data.isEnabled) {
                    return `<button type="button" class="btn btn-outline-primary me-2" onclick="changeStatus(${data.id} , 'ENABLE')">
                    <i class="fas fa-check"></i> Enable
                </button>`
                } else {
                    return `<button type="button" class="btn btn-outline-danger me-2" onclick="changeStatus(${data.id} , 'DISABLE')">
                    <i class="fas fa-xmark"></i> Disable
                </button>`
                }
            },
        },
    ],
});

function changeStatus(id, value) {
    Swal.fire(
        {
            title: 'Are you sure want to ' + value + ' this User?',
            text: "You won't be able to revert this!",
            icon: 'question',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes'
        }
    ).then((result) => {
        $.ajax({
            method: "PUT",
            url: "/api/admin/change-status/" + id,
            dataType: "JSON",
            beforeSend: addCsrfToken(),
            data:null,
            contentType: "application/json",
            success: result => {
                $('#list-user').DataTable().ajax.reload()
                Swal.fire({
                    icon: 'success',
                    title: 'User has been ' + value,
                    width: 600,
                    padding: '3em',
                    color: '#716add',
                    background: '#fff',
                    showConfirmButton: false,
                    timer: 1500,
                })
            }
        })
    })
}