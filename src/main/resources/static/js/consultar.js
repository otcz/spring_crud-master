       async function descargar_pdf(){
           const request = await fetch('soatcolpatria.herokuapp.com/documento', {
            method: 'POST',
            headers: {
              'Accept': 'application/pdf',
              'Content-Type': 'application/pdf'
            },
            body: "EBP395"

          });
         var vehiculo = await request;


      }