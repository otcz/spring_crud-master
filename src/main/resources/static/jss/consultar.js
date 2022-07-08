
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
          let dato={};
          dato.identificacion=document.getElementById("_DigitalSOATQuotePortlet_Placa").value;

          const request = await fetch('soatcolpatria.herokuapp.com/soat/pdf', {
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(dato)

          });
          vehiculo = await request.json();
          console.log(vehiculo);


          }
          catch (Exception){
              s_pagar.style.display = "none";
                 alert("RUT DICE: No fue posible encontrar un registro.");
          }
      }