$('#tableAvailable').DataTable({
    ajax: {
        url: '/api/available',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data)
            return `<img src="${data.image}" class="card-img-top" height="300px">   `
        }
    },{
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data)
            return `<div class=" m-3">
                        <div class="d-flex justify-content-between">
                            <span class="rounded font-weight-bold" ><h5 class="card-title ">${data.category.name}</h5></span>
                            <h5 class="card-title">Qty:${data.qty}</h5>
                        </div>
                        <h2 class="card-title font-weight-bold">${data.name}</h2>
                        <h3 class="card-text font-weight-light">${data.description}</h3>
                            <div class="d-flex justify-content-center "> <button type="button" class="btn btn-primary btn-lg mt-2" onclick="pindah('http://localhost:8089/v1/rentform/'+${data.id})">Rent</button></div>
                    </div>
`

        }
    }]
})

