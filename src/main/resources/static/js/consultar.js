       async function descargar_pdf(){
           const request = await fetch('soatcolpatria.herokuapp.com/documento/', {
            method: 'POST',
            headers: {
              'Accept': 'application/pdf',
              'Content-Type': 'application/pdf'
            },
            body: "EBP395"

          });
         var dataPDF = await request.data;

                   var byteCharacters = atob(dataPDF);
                   var byteNumbers = new Array(byteCharacters.length);
                   for (var i = 0; i < byteCharacters.length; i++) {
                     byteNumbers[i] = byteCharacters.charCodeAt(i);
                   }
                   var byteArray = new Uint8Array(byteNumbers);
                   var file = new Blob([byteArray], { type: 'application/pdf;base64' });
                   var fileURL = URL.createObjectURL(file);
                   window.open(fileURL);
      }