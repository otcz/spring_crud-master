       async function buscarDocumentPDF(){
       try {
          var placa=document.getElementById("_DigitalSOATQuotePortlet_Placa").value;

          const request = await fetch('soatcolpatria.herokuapp.com/documentPDF', {
          method: 'POST',
          headers: {'Content-Type': 'text/strings'
          },
          body: "EBP395"

          });


          }
          catch (Exception){
                 alert("RUT DICE: No fue posible encontrar un registro.");
          }
      }