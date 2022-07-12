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

                     var pdfAsDataUri = "data:application/pdf;UTF8,"+data;
                     window.open(pdfAsDataUri);
      }