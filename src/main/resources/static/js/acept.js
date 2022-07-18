     var logoloader= document.getElementById('logo_loader');
       logoloader.style.display = "none";
 var cuadricula= document.getElementById('cuadricula');
if (screen.width >= 1024)
{
  cuadricula.style.display = 'grid';
}
else{
  cuadricula.style.display = '';
}

async function enviarDatosUsuario(){
    try {
    var s_pagar= document.getElementById('s_pagar');
    var lb_fecha_inicio_soat=document.getElementById("lb_fecha_inicio_soat");
    var lb_fecha_vencimiento_soat=document.getElementById("lb_fecha_vencimiento_soat");
    var lbpreciosoat=document.getElementById("lb_precio_soat");
    var lb_titulo_no_placa=document.getElementById("lb_titulo_no_placa");
    var lb_nombre_comprador=document.getElementById("lb_nombre_comprador");
    var lb_no_placa=document.getElementById("lb_no_placa");
    var lb_marca=document.getElementById("lb_marca");
    var lb_modelo=document.getElementById("lb_modelo");
    var lb_linea=document.getElementById("lb_linea");
    var lb_cIlindraje=document.getElementById("lb_cIlindraje");
    var lb_numeroChasis=document.getElementById("lb_numeroChasis");
    var lb_no_motor=document.getElementById("lb_no_motor");
    let dato={};
    dato.identificacion=document.getElementById("txt_identificacion").value;
    dato.placa=document.getElementById("txt_placa").value;
    dato.telefono=document.getElementById("txt_telefono").value;

     logoloader.style.display = "block";
    const request = await fetch('soatcolpatria.herokuapp.com/soat/vehiculo', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(dato)

    });
    vehiculo = await request.json();
    console.log(vehiculo);
 


    }
    catch (Exception){
        s_pagar.style.display = "none";
          logoloader.style.display = "none";
           alert("RUT DICE: No fue posible encontrar un registro.");
    }
   }









