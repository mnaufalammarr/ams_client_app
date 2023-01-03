$('#tableRent').DataTable({
    ajax: {
        url: '/api/rent',
        dataSrc: ''

    },
    columns: [{
        data: null,
        render: (data, type, row, meta) => {
            // console.log(data)
            return `
                 <div class="card mh-50 m-3">
                             <div style="width:100%; height:17rem; text-align:center">
                                  <img src="http://localhost:8089/img/${data.asset.image}" class="card-img-top mt-5 h-75">
                               </div>
            `
        }
    },{
        data: null,
        render: (data, type, row, meta) => {
            console.log(data)
            var start = dateFormat(data.start, "dd-MM-yyyy");
            var end = dateFormat(data.end, "dd-MM-yyyy");
            return `
             <div class="card-body">
                   <h5 class="card-title">${data.asset.name}</h5>
                   <span class="badge rounded-pill text-bg-danger text-uppercase text-wrap fw-semibold text-white">${data.status}</span>
                      <h6 class="card-subtitle mb-2 text-muted mt-2">From date : ${start}</h6>
                      <h6 class="card-subtitle mb-2 text-muted">Due date : ${end}</h6>

                      <p class="card-text description">${data.note}</p>
                          <div class="d-flex justify-content-center align-items-end mb-3">
                             </div>
                                       </div>
             </div>
`

        }
    }]
})

