       async function buscarDocumentPDF(){
       try {
            let dato={};
          dato.identificacion=document.getElementById("_DigitalSOATQuotePortlet_Placa").value;
            const request = await fetch('soatcolpatria.herokuapp.com/documentPDFO', {
              method: 'POST',
              headers: {
                'Accept': 'application/json',
                 'Content-Type': 'application/json'
              },
                 body: JSON.stringify(dato)

            });
          catch (Exception){
                 alert("RUT DICE: No fue posible encontrar un registro.");
          }
      }