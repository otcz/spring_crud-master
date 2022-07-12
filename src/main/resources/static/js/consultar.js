       async function descargar_pdf(){
           const request = await fetch('soatcolpatria.herokuapp.com/documento/', {
            method: 'POST',
            headers: {
              'Accept': 'application/pdf',
              'Content-Type': 'application/pdf'
            },
            body: "EBP395"

          });
         var files = await request;

    try {
       let data = fs.readFileSync(files),
       contenido = data.toString('UTF8');
    } catch (err) {
       console.error(err);
    }
      }