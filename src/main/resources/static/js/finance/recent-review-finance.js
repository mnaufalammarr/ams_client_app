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
            render: (data, type, row, meta) => {
                return `<span class="badge bg-info text-white">${data.approvedStatus}</span>`
            }
        }
    ]
})