package br.com.ricardo.Filme.model;

public class FilmeVO {

    private Long id;
    private String titulo;
    private int nota;
    private String comentario;
    private Long usuario_id;

    public FilmeVO() {
    }

    public FilmeVO(Long id, String titulo, int nota, String comentario, Long usuario_id) {
        this.id = id;
        this.titulo = titulo;
        this.nota = nota;
        this.comentario = comentario;
        this.usuario_id = usuario_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }
}
