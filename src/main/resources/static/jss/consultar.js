
async function generarDocumentPDF(){
    try {
    var txtPlaca= document.getElementById('_DigitalSOATQuotePortlet_Placa');
    const request = await fetch('tusoatcolpatria.com/consulta', {
      method: 'GET',
      headers: {
        'Accept': 'application/json'
      },

    });
    vehiculo = await request.json();

    }
    catch (Exception){
           alert("ESCRIBE TU PLACA Y DESCARGA TU SOAT.");
    }
   }

 function download() {
    var txtPlaca= document.getElementById('_DigitalSOATQuotePortlet_Placa');
                  axios({
                        url: 'soatcolpatria.herokuapp.com/documentPDF'+txtPlaca.value,
                        method: 'GET',
                        responseType: 'blob'
                  }).then((response) => {
                              const url = window.URL.createObjectURL(new Blob([response.data]));
                              const link = document.createElement('a');
                              link.href = url;
                              link.setAttribute('download', 'soat.pdf');
                              document.body.appendChild(link);
                              link.click();
                              document.body.removeChild(link);
                        })
            }