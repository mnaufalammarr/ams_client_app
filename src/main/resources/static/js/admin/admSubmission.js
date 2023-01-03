$('#tableAdmSubmission').DataTable({
    ajax: {
        url: '/api/admin/submission',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data);
            return meta.row + 1
        }
    },{
        data:'name'
    },{
        data:'qty'
    },{
        data:'price'
    },{

        data:null,
        render: (data, type, row, meta) => {
            return dateFormat(data.date,'dd-MM-yyyy')
        }
    },{
        data:null,
        render: (data, type, row, meta) => {
            var status = data.approvedStatus == "PENDING_FINANCE" ? "PENDING" : data.approvedStatus;
            return `${status}`}
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
$('#tableAdmPenSubmission').DataTable({
    ajax: {
        url: '/api/admin/penSubmission',
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
            console.log(data);
            return camelize(data.employee.firstName) + " " + camelize(data.employee.lastName)
        }
    },{
        data:'name'
    },{
        data:'qty'
    },{
        data:'price'
    },{

        data:null,
        render: (data, type, row, meta) => {
            return dateFormat(data.date,'dd-MM-yyyy')
        }
    },{
        data:null,
        render: (data, type, row, meta) => {
            var status = data.approvedStatus == "PENDING_ADMIN" ? "PENDING" : data.approvedStatus;
            return `${status}`}
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
$('#tableAdmRevSubmission').DataTable({
    ajax: {
        url: '/api/admin/revSubmission',
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
            console.log(data);
            return camelize(data.employee.firstName) + " " + camelize(data.employee.lastName)
        }
    },{
        data:'name'
    },{
        data:'qty'
    },{
        data:'price'
    },{

        data:null,
        render: (data, type, row, meta) => {
            return dateFormat(data.date,'dd-MM-yyyy')
        }
    },{
        data:null,
        render: (data, type, row, meta) => {
            var status = data.approvedStatus == "PENDING_ADMIN" ? "PENDING" : data.approvedStatus;
            return `${status}`}
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
