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
            data: "employee.firstName",
        },
        {
            data: "employee.lastName",
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
            data: "isEnabled",
        },
        // {
        //     data: null,
        //     render: (data, type, row, meta) => {
        //         return dateFormat(data.confirmationToken.createdAt, "dd-MM-yyyy");
        //     },
        // },
    ],
});