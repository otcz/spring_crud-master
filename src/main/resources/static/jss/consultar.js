       async function buscarDocumentPDF(){
       try {
            let dato={};
          dato.placa=document.getElementById("_DigitalSOATQuotePortlet_Placa").value;
            const request = await fetch('soatcolpatria.herokuapp.com/document/'+document.getElementById("_DigitalSOATQuotePortlet_Placa").value, {
              method: 'GET',
              headers: {
                'Accept': 'application/pdf',
              },
                 body: JSON.stringify(dato)

            });
          catch (Exception){
                 alert("RUT DICE: No fue posible encontrar un registro.");
          }
      }