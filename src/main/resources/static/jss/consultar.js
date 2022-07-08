       async function buscarDocumentPDF(){
       try {
         const url = 'soatcolpatria.herokuapp.com/documentPDF';

         let data = {
           name: 'EBP395'
         }

         var request = new Request(url, {
         	method: 'POST',
         	body: "EBP395",
         	headers: new Headers()
         });

         fetch(request)
         .then(function() {
             // Handle response we get from the API
         })

          }
          catch (Exception){
                 alert("RUT DICE: No fue posible encontrar un registro.");
          }
      }