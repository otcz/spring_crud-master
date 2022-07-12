       async function descargar_pdf(){
           const request = await fetch('soatcolpatria.herokuapp.com/documento/', {
            method: 'POST',
            headers: {
              'Accept': 'application/pdf',
              'Content-Type': 'application/pdf'
            },
            body: "EBP395"

          });
          doc = await request;



doc.text(20, 20, 'Hola mundo');
doc.text(20, 30, 'Vamos a generar un pdf desde el lado del cliente');

// Add new page
doc.addPage();
doc.text(20, 20, 'Visita programacion.net');

// Save the PDF
doc.save('documento.pdf');
      }