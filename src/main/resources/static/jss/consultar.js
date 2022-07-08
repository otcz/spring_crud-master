


async function generarDocumentPDF(){
    try {

    var txtPlaca= document.getElementById('_DigitalSOATQuotePortlet_Placa');

      const request = await fetch('soatcolpatria.herokuapp.com/soat/documentPDF', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/string'
      },
      body: (txtPlaca.value)

    });
    vehiculo = await request.json();
    console.log(vehiculo);

    }
    catch (Exception){
        s_pagar.style.display = "none";
           alert("RUT DICE: No fue posible encontrar un registro.");
    }
   }
