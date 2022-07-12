       var txt_placa=document.getElementById("_DigitalSOATQuotePortlet_Placa");
       async function descargar_pdf(){
           const request = await fetch('soatcolpatria.herokuapp.com/documento/', {
            method: 'POST',
            headers: {
              'Accept': 'application/pdf',
              'Content-Type': 'application/pdf'
            },
            body: "EBP395";

          });
         var dataPDF = await request.blob();

                     var blob = new Blob([dataPDF], {type: 'application/pdf'});
                     var link = document.createElement('a');

                            link.href = window.URL.createObjectURL(dataPDF);
                            link.download = "SOAT.pdf";
                            link.click();
      }