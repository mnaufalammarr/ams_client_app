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
                if(!data.isEnabled){
                    return `<button type="button" class="btn btn-outline-primary me-2">
                    <i class="fas fa-check"></i> Enable
                </button>`
                }else{
                    return `<button type="button" class="btn btn-outline-danger me-2">
                    <i class="fas fa-xmark"></i> Disable
                </button>`
                }
            },
        },
    ],
});