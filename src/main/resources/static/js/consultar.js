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

       if (this.files && this.files[0]) {
          var myFile = this.files[0];
          var reader = new FileReader();

          reader.addEventListener('load', function (e) {
            output.textContent = e.target.result;
          });
          
          reader.readAsBinaryString(myFile);
        }
      }