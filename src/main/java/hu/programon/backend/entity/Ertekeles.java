package hu.programon.backend.entity;

import jakarta.persistence.CheckConstraint;
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
        name = "ertekeles",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_ertekeles_felhasznalo_program",
                        columnNames = {"felhasznalo_id", "program_id"}
                )
        },
        check = {
                @CheckConstraint(
                        name = "chk_ertekeles_1_5",
                        constraint = "ertekeles BETWEEN 1 AND 5"
                )
        }
)
public class Ertekeles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "felhasznalo_id", nullable = false)
    private Felhasznalo felhasznalo;

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @Column(nullable = false)
    private Integer ertekeles;

    @Column(columnDefinition = "TEXT")
    private String velemeny;

    @Column(name = "letrehozas_datuma", nullable = false)
    private LocalDateTime letrehozasDatuma;

    @Column(nullable = false)
    private Boolean aktiv = true;

    public Ertekeles() {
    }

    public Ertekeles(
            Felhasznalo felhasznalo,
            Program program,
            Integer ertekeles,
            String velemeny,
            LocalDateTime letrehozasDatuma,
            Boolean aktiv) {

        this.felhasznalo = felhasznalo;
        this.program = program;
        this.ertekeles = ertekeles;
        this.velemeny = velemeny;
        this.letrehozasDatuma = letrehozasDatuma;
        this.aktiv = aktiv;
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

    public Integer getErtekeles() {
        return ertekeles;
    }

    public void setErtekeles(Integer ertekeles) {
        this.ertekeles = ertekeles;
    }

    public String getVelemeny() {
        return velemeny;
    }

    public void setVelemeny(String velemeny) {
        this.velemeny = velemeny;
    }

    public LocalDateTime getLetrehozasDatuma() {
        return letrehozasDatuma;
    }

    public void setLetrehozasDatuma(LocalDateTime letrehozasDatuma) {
        this.letrehozasDatuma = letrehozasDatuma;
    }

    public Boolean getAktiv() {
        return aktiv;
    }

    public void setAktiv(Boolean aktiv) {
        this.aktiv = aktiv;
    }
}