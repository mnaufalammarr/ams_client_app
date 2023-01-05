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
            return data[0]}
    },{
        data: null,
        render: (data, type, row, meta) => {

            return dateFormat(data[2],'dd-MM-yyyy')}
    },{
        data: null,
        render: (data, type, row, meta) => {

            return data[3]}
    },{
        data: null,
        render: (data, type, row, meta) => {

            return data[4]}
    },{
        data: null,
        render: (data, type, row, meta) => {

            return rupiah(data[5])}
    },{
        data: null,
        render: function (data, type, row, meta) {
            return ` <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detailRegion" onclick="pindah('http://localhost:8089/v1/penalty/'+${data[6]})">
                Detail
            </button>
            `;
        }
    }]
})
