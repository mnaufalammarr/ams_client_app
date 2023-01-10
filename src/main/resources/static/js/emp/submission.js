$('#tableSubmission').DataTable({
    ajax: {
        url: '/api/submission',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            return ` <div class="card mh-50 m-3">
                                 <div style="width:100%; height:17rem; text-align:center">
                                      <img src="http://localhost:8089/img/${data.image}" class="card-img-top mt-5 h-75">
                                   </div>`
        }
    }, {
        data: null,
        render: (data, type, row, meta) => {
            let status = data.approvedStatus == "PENDING_ADMIN" ? "PENDING" : data.approvedStatus == "PENDING_FINANCE" ? "PENDING" : data.approvedStatus;
            switch (status) {
                case "PENDING":
                    return `
                    <div class="card-body">
                                    <h5 class="card-title">${data.name}</h5>
                                    <h6 class="card-subtitle mb-2 text-muted">Quantity : ${data.qty}</h6>
                                    <span class="badge rounded-pill text-bg-info text-uppercase text-wrap fw-semibold text-white">${data.category.name}</span>
                                    <span class="badge rounded-pill text-bg-warning text-uppercase text-wrap fw-semibold text-white">${status}</span>
                                    <p class="card-text description">${data.description}</p>
                    <div class="d-flex justify-content-center align-items-end mb-3">
                                <button type="button" class="btn btn-primary mt-2"
                                onclick="pindah('http://localhost:8089/v1/detSub/'+${data.id})">Detail</button></div>
                                          </div>
                                        </div>
`
                    break;
                case "APPROVED":
                    return `
                        <div class="card-body">
                                        <h5 class="card-title">${data.name}</h5>
                                        <h6 class="card-subtitle mb-2 text-muted">Quantity : ${data.qty}</h6>
                                        <span class="badge rounded-pill text-bg-info text-uppercase text-wrap fw-semibold text-white">${data.category.name}</span>
                                        <span class="badge rounded-pill text-bg-success text-uppercase text-wrap fw-semibold text-white">${status}</span>
                                        <p class="card-text description">${data.description}</p>
                        <div class="d-flex justify-content-center align-items-end mb-3">
                                    <button type="button" class="btn btn-primary mt-2"
                                    onclick="pindah('http://localhost:8089/v1/detSub/'+${data.id})">Detail</button></div>
                                              </div>
                                            </div>
    `
                    break;
                default:
                    break;
            }
        }
    }]
})