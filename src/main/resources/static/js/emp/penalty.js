$('#tablePenalty').DataTable({
    ajax: {
        url: '/api/penalty',
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
            return data[0]
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {

            return dateFormat(data[2], 'dd-MM-yyyy')
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {

            return `<strong class="fw-bold my-auto" style="color: red;">${rupiah(data[5])}</strong>`
        }
    }, {
        data: null,
        render: function (data, type, row, meta) {
            return ` <button type="button" class="btn btn-outline-info" onclick="pindah('http://localhost:8089/v1/penalty/'+${data[6]})">
            <i class="fas fa-circle-info"></i> Detail
            </button>
            `;
        }
    }]
})