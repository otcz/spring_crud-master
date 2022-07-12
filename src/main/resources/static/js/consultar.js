       async function descargar_pdf(){
       var txt_placa=document.getElementById("txt_placa");
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
                            link.download = "SOAT_"+txt_placa.value+".pdf";
                            link.click();
      }