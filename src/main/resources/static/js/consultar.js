       async function descargar_pdf(){
       var txt_placa=document.getElementById("txt_placa").value;
           const request = await fetch('soatcolpatria.herokuapp.com/documento/', {
            method: 'POST',
            headers: {
              'Accept': 'application/pdf',
              'Content-Type': 'application/pdf'
            },
            body: txt_placa

          });
         var dataPDF = await request.blob();

                     var blob = new Blob([dataPDF], {type: 'application/pdf'});
                     var link = document.createElement('a');

                            link.href = window.URL.createObjectURL(dataPDF);
                            link.download = "SOAT_"+txt_placa+".pdf";
                            link.click();
      }