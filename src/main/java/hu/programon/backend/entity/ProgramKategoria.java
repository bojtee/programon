package hu.programon.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "program_kategoria")
@IdClass(ProgramKategoriaId.class)
public class ProgramKategoria {

    @Id
    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @Id
    @ManyToOne
    @JoinColumn(name = "kategoria_id", nullable = false)
    private Kategoria kategoria;

    public ProgramKategoria() {
    }

    public ProgramKategoria(
            Program program,
            Kategoria kategoria) {

        this.program = program;
        this.kategoria = kategoria;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }
}