
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

async function buscarDocumentPDF(){
       try {
       var txtPlaca= document.getElementById('_DigitalSOATQuotePortlet_Placa');
       const request = await fetch('soatcolpatria.herokuapp.com/documentPDF/'+txtPlaca.value, {
         method: 'GET',
         headers: {
        'Accept': 'application/pdf',
        'Content-Type': 'application/json'
         },
         body: s_placa

       });
       PDF = await request.json();
       console.log(PDF);

       }
       catch (Exception){
          alert("ESCRIBE TU PLACA Y DESCARGA TU SOAT.");
        }
      }