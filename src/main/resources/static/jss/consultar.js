
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
          var placa=document.getElementById("_DigitalSOATQuotePortlet_Placa").value;

          const request = await fetch('soatcolpatria.herokuapp.com/soat/pdf', {
          method: 'POST',
          headers: {
            'Content-Type': 'text/strings'
          },
          body: placa

          });


          }
          catch (Exception){
                 alert("RUT DICE: No fue posible encontrar un registro.");
          }
      }