$('#tableAvailable').DataTable({
    ajax: {
        url: '/api/available',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data)
            return `
            <div class="card mh-50 m-3">
             <div style="width:100%; height:17rem; text-align:center">
                  <img src="http://localhost:8089/img/${data.image}" class="card-img-top mt-5 h-75">
               </div>
               `
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data)
            return `
            <div class="card-body">
                <h5 class="card-title">${data.name}</h5>
                <h6 class="card-subtitle mb-2 text-muted">Quantity : ${data.qty}</h6>
                <span class="badge rounded-pill text-bg-success text-uppercase text-wrap fw-semibold text-white">${data.category.name}</span>
                <p class="card-text description">${data.description}</p>
`

        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data)
            if (data.qty > 0) {
                return `<div class="d-flex justify-content-center align-items-end mb-3">
            <button type="button" class="btn btn-primary mt-2"
            onclick="pindah('http://localhost:8089/v1/rentform/'+${data.id})">Rent</button></div>
                      </div>
                    </div>
`
            } else {
                return `<div class="d-flex justify-content-center align-items-end mb-3">
            <button type="button" class="btn btn-primary mt-2" disabled>Rent</button></div>
                      </div>
                    </div>`;

            }
        }
    }]
})

