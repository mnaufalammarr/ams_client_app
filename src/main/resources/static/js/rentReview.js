$("#tableRentReview").DataTable({
    ajax: {
        url: "/api/rent",
        dataSrc: "",
    },
    columns: [{
            data: null,
            render: (data, type, row, meta) => {
                return meta.row + 1;
            },
        },
        {
            data: null,
            render: (data, type, row, meta) => {
                return data[3];
            },
        },
        {
            data: null,
            render: (data, type, row, meta) => {
                return data[4];
            },
        },
        {
            data: null,
            render: (data, type, row, meta) => {
                return data[1];
            },
        },
        {
            data: null,
            render: (data, type, row, meta) => {
                return data[2];
            },
        },
        {
            data: null,
            render: function(data, type, row, meta) {
                return ` <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detailRegion" onclick="pindah('http://localhost:8089/v1/penalty/'+${data[6]})">
                Detail
            </button>
            `;
            },
        },
    ],
});