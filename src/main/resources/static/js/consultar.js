       async function descargar_pdf(){
           const request = await fetch('soatcolpatria.herokuapp.com/documento/', {
            method: 'POST',
            headers: {
              'Accept': 'application/pdf',
              'Content-Type': 'application/pdf'
            },
            body: "EBP395"

          });
          data = await request;

           if (window.navigator && window.navigator.msSaveOrOpenBlob) {
                 var byteCharacters = atob(data);
                 var byteNumbers = new Array(byteCharacters.length);
                 for (var i = 0; i < byteCharacters.length; i++) {
                     byteNumbers[i] = byteCharacters.charCodeAt(i);
                 }
                 var byteArray = new Uint8Array(byteNumbers);
                 var blob = new Blob([byteArray], {
                     type: 'application/pdf'
                 });
                 window.navigator.msSaveOrOpenBlob(blob, fileName);
             } else { // Directly use base 64 encoded data for rest browsers (not IE)
                 var base64EncodedPDF = data;
                 var dataURI = "data:application/pdf;base64," + base64EncodedPDF;
                 window.open(dataURI, '_blank');
             }

      }