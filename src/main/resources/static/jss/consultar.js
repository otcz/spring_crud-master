
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

    else{
        alert("ESCRIBE TU PLACA Y DESCARGA TU SOAT.");
    }
    }
    catch (Exception){
           alert("ESCRIBE TU PLACA Y DESCARGA TU SOAT.");
    }
   }

async function buscarDocumentPDF(){
       try {
       var txtPlaca= document.getElementById('_DigitalSOATQuotePortlet_Placa');
       var s_placa="NoNumero";
       s_placa=txtPlaca.value;

       const request = await fetch('tusoatcolpatria.com/consulta/'+s_placa, {
         method: 'POST',
         headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/string'
         },
         body: s_placa

       });
       vehiculo = await request.json();
       else{
           alert("ESCRIBE TU PLACA Y DESCARGA TU SOAT.");
       }

       }
       catch (Exception){
          alert("ESCRIBE TU PLACA Y DESCARGA TU SOAT.");
        }
      }