package hu.programon.backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProgramKategoriaId implements Serializable {

    private Long program;
    private Long kategoria;

    public ProgramKategoriaId() {
    }

    public ProgramKategoriaId(Long program, Long kategoria) {
        this.program = program;
        this.kategoria = kategoria;
    }

    public Long getProgram() {
        return program;
    }

    public void setProgram(Long program) {
        this.program = program;
    }

    public Long getKategoria() {
        return kategoria;
    }

    public void setKategoria(Long kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ProgramKategoriaId)) {
            return false;
        }

        ProgramKategoriaId that = (ProgramKategoriaId) o;

        return Objects.equals(program, that.program)
                && Objects.equals(kategoria, that.kategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(program, kategoria);
    }
}