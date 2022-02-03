package DTO.dtoEspeciales;

public class IssueLessInfo {
    private long id;
    private String titulo;
    private String texto;
    private String fecha;
    private boolean terminado;

    public IssueLessInfo(long id, String titulo, String texto, String fecha, boolean terminado) {
            this.id=id;
            this.titulo=titulo;
            this.texto=texto;
            this.fecha= fecha;
            this.terminado=terminado;
    }
}
