       async function buscarDocumentPDF(){
       try {

            const request = await fetch('soatcolpatria.herokuapp.com/soat/vehiculo', {
              method: 'POST',
              headers: {
                'Accept': 'application/json',
                'Content-Type': 'text/strings'
              },
              body: "EBP395"

            });
          catch (Exception){
                 alert("RUT DICE: No fue posible encontrar un registro.");
          }
      }