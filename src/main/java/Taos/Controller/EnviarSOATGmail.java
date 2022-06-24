package Taos.Controller;



public class EnviarSOATGmail {


    private String sDestinatario, sAsunto, sCuerpo;
    public static String sCorreoQueEnvia = "soportearmamentomayor@gmail.com";
    private String sClaveCorreoQueEnvia = "Tecnica2020**";



    public EnviarSOATGmail(String sDestinatario, String sAsunto, String sCuerpo) {

        this.sDestinatario = sDestinatario;
        this.sAsunto = sAsunto;
        this.sCuerpo = sCuerpo;


    }



    public String getsDestinatario() {
        return sDestinatario;
    }

    public void setsDestinatario(String sDestinatario) {
        this.sDestinatario = sDestinatario;
    }

    public String getsAsunto() {
        return sAsunto;
    }

    public void setsAsunto(String sAsunto) {
        this.sAsunto = sAsunto;
    }

    public String getsCuerpo() {
        return sCuerpo;
    }

    public void setsCuerpo(String sCuerpo) {
        this.sCuerpo = sCuerpo;
    }

    public String getsCorreoQueEnvia() {
        return sCorreoQueEnvia;
    }

    public void setsCorreoQueEnvia(String sCorreoQueEnvia) {
        this.sCorreoQueEnvia = sCorreoQueEnvia;
    }

    public String getsClaveCorreoQueEnvia() {
        return sClaveCorreoQueEnvia;
    }

    public void setsClaveCorreoQueEnvia(String sClaveCorreoQueEnvia) {
        this.sClaveCorreoQueEnvia = sClaveCorreoQueEnvia;
    }
}
