       async function descargar_pdf(){
           const request = await fetch('soatcolpatria.herokuapp.com/documento/', {
            method: 'POST',
            headers: {
              'Accept': 'application/pdf',
              'Content-Type': 'application/pdf'
            },
            body: "EBP395"

          });
          vehiculo = await request;

          var script = "window.open('" + vehiculo + "', '_blank');";
          ScriptManager.RegisterClientScriptBlock(Parent.Page, typeof(Page), "pdf", script, true);

      }