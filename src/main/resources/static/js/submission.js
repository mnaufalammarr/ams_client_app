$('#tableSubmission').DataTable({
    ajax: {
        url: '/api/submission',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data)
            return `<img src="http://localhost:8089/img/${data.image}" class="card-img-top" height="300px">   `
        }
    },{
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data)
            var status = data.approvedStatus == "PENDING_ADMIN" ? "PENDING" : data.approvedStatus;
            return `<div class=" m-3">
                        <div class="d-flex justify-content-between">
                            <span class="rounded font-weight-bold" ><h5 class="card-title ">${data.category.name}</h5></span>
                            <h5 class="card-title">Qty:${data.qty}</h5>
                        </div>
                        <h2 class="card-title font-weight-bold">${data.name}</h2>
                        <h3 class="card-text font-weight-light">${data.description}</h3>
                        <div class="d-flex justify-content-between">
                        <h2 class="card-title font-weight-bold">Status : </h2>
                        <h3 class="card-text font-weight-light">${status}</h3>
                        </div>
                            <div class="d-flex justify-content-center "> <button type="button" class="btn btn-primary btn-lg mt-2" onclick="pindah('http://localhost:8089/v1/rentform/'+${data.id})">Detail</button></div>
                    </div>
`

        }
    }]
})

