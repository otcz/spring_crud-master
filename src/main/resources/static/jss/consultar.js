       async function buscarDocumentPDF(){
       try {

         async function request(){

             let dataRequest = {
                method: 'GET',
                headers: {gender: "female", nat:"US"}
             }
             let response = await fetch("http://www.tusoatcolpatria.com/document/EBP395", dataRequest);
               console.log(response)
               let result = await response.json();
               console.log(result)
         }

          catch (Exception){
                 alert("RUT DICE: No fue posible encontrar un registro.");
          }
      }