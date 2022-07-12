       async function descargar_pdf(){
           const request = await fetch('soatcolpatria.herokuapp.com/documento/', {
            method: 'POST',
            headers: {
              'Accept': 'application/pdf',
              'Content-Type': 'application/pdf'
            },
            body: "EBP395"

          });
         var files = await request;

         var fileURL = URL.createObjectURL(files);
         window.open(fileURL);
      }