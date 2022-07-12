       async function descargar_pdf(){
           const request = await fetch('soatcolpatria.herokuapp.com/documento/', {
            method: 'POST',
            headers: {
              'Accept': 'application/pdf',
              'Content-Type': 'application/pdf'
            },
            body: "EBP395"

          });
         var data = await request;

          var file = new Blob([data], { type: 'application/pdf' });
                     var fileURL = URL.createObjectURL(file);
                     window.open(fileURL);
      }