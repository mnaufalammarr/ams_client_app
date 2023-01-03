$('#tableRent').DataTable({
    ajax: {
        url: '/api/rent',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data)
            return `<img src="http://localhost:8089/img/${data.asset.image}" class="card-img-top" height="300px">   `
        }
    },{
        data: null,
        render: (data, type, row, meta) => {
            console.log(data)
            var start = dateFormat(data.start, "dd-MM-yyyy");
            var end = dateFormat(data.end, "dd-MM-yyyy");
            return `<div class=" m-3">
                        <div class="d-flex justify-content-between">
                            <h3 class="card-title font-weight-bold">${data.asset.name}</h3>
                            <h5 class="card-title">Status:${data.status}</h5>
                        </div>
                        <h3 class="card-text font-weight-light">${data.note}</h3>
                        <div class="d-flex justify-content-between">
                            <h5 class="card-title">Start:${start}</h5>
                            <h5 class="card-title">End:${end}</h5>
                        </div>
<!--                            <div class="d-flex justify-content-center "> <button type="button" class="btn btn-primary btn-lg mt-2" onclick="pindah('http://localhost:8089/v1/rentform/'+${data.id})">detail</button></div>-->
                    </div>
`

        }
    }]
})

