package TDA;

public class Preguntas {
    
    String pregunta, respuesta, a, b, c, d, ruta;

    public Preguntas(String pregunta, String respuesta, String a, String b, String c, String d, String ruta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.ruta = ruta;
    }

    public Preguntas() {

    }
    
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
    
}
