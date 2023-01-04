$('#table-recent-review').DataTable({
    ajax: {
        url: '/api/finance/recent_review',
        dataSrc: ''
    },
    columns: [{
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
            data: null,
            render: function (data, type, row, meta) {
                return rupiah(data.price);
            }
        },
        {
            data: 'qty',
        },
        {
            data: 'approvedStatus',
        }
    ]
})

const rupiah = (number) => {
    return new Intl.NumberFormat("id-ID", {
        style: "currency",
        currency: "IDR"
    }).format(number);
}