

       async function descargar_pdf(){
            var txtPlaca=document.getElementById("_DigitalSOATQuotePortlet_Placa");
           const request = await fetch('soatcolpatria.herokuapp.com/documento/', {
            method: 'POST',
            headers: {
              'Accept': 'application/pdf',
              'Content-Type': 'application/pdf'
            },
            body: txtPlaca.value;

          });
         var dataPDF = await request.blob();

                     var blob = new Blob([dataPDF], {type: 'application/pdf'});
                     var link = document.createElement('a');

                            link.href = window.URL.createObjectURL(dataPDF);
                            link.download = "SOAT.pdf";
                            link.click();
      }