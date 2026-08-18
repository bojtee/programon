package hu.programon.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "kedvenc",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_kedvenc_felhasznalo_program",
                        columnNames = {"felhasznalo_id", "program_id"}
                )
        }
)
public class Kedvenc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "felhasznalo_id", nullable = false)
    private Felhasznalo felhasznalo;

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @Column(name = "letrehozas_datuma", nullable = false)
    private LocalDateTime letrehozasDatuma;

    public Kedvenc() {
    }

    public Kedvenc(
            Felhasznalo felhasznalo,
            Program program,
            LocalDateTime letrehozasDatuma) {

        this.felhasznalo = felhasznalo;
        this.program = program;
        this.letrehozasDatuma = letrehozasDatuma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Felhasznalo getFelhasznalo() {
        return felhasznalo;
    }

    public void setFelhasznalo(Felhasznalo felhasznalo) {
        this.felhasznalo = felhasznalo;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public LocalDateTime getLetrehozasDatuma() {
        return letrehozasDatuma;
    }

    public void setLetrehozasDatuma(LocalDateTime letrehozasDatuma) {
        this.letrehozasDatuma = letrehozasDatuma;
    }
}