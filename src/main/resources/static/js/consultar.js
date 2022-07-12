       async function descargar_pdf(){
           const request = await fetch('soatcolpatria.herokuapp.com/documento', {
            method: 'POST',
            headers: {
              'Accept': 'application/pdf',
              'Content-Type': 'text/plain'
            },
            body: "EBP395"

          });
          vehiculo = await request;
          console.log(vehiculo.pdf);
          window.open(vehiculo.pdf);

      }