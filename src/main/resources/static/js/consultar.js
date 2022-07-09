       async function descargar_pdf(){
       try {


     const request = await fetch('soatcolpatria.herokuapp.com/documento', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'text/plain'
      },
      body: "EBP395"


    });
    vehiculo = await request.json();
    console.log(vehiculo)
          catch (Exception){
                 alert("RUT DICE: No fue posible encontrar un registro.");
          }
      }