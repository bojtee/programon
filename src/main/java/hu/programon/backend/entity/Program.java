package hu.programon.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "program")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nev;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String leiras;

    @ManyToOne
    @JoinColumn(name = "helyszin_id", nullable = false)
    private Helyszin helyszin;

    @Column(name = "maximalis_letszam", nullable = false)
    private Integer maximalisLetszam;

    @Column(nullable = false)
    private LocalDate datum;

    @Column(nullable = false)
    private LocalTime idopont;

    @Column(name = "kep_eleresi_ut", length = 500)
    private String kepEleresiUt;

    @ManyToOne
    @JoinColumn(name = "letrehozo_felhasznalo_id", nullable = false)
    private Felhasznalo letrehozoFelhasznalo;

    @Column(name = "letrehozas_datuma", nullable = false)
    private LocalDateTime letrehozasDatuma;

    @Column(name = "modositas_datuma", nullable = false)
    private LocalDateTime modositasDatuma;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private ProgramAllapot allapot;

    public Program() {
    }

    public Program(
            String nev,
            String leiras,
            Helyszin helyszin,
            Integer maximalisLetszam,
            LocalDate datum,
            LocalTime idopont,
            String kepEleresiUt,
            Felhasznalo letrehozoFelhasznalo,
            LocalDateTime letrehozasDatuma,
            LocalDateTime modositasDatuma,
            ProgramAllapot allapot) {

        this.nev = nev;
        this.leiras = leiras;
        this.helyszin = helyszin;
        this.maximalisLetszam = maximalisLetszam;
        this.datum = datum;
        this.idopont = idopont;
        this.kepEleresiUt = kepEleresiUt;
        this.letrehozoFelhasznalo = letrehozoFelhasznalo;
        this.letrehozasDatuma = letrehozasDatuma;
        this.modositasDatuma = modositasDatuma;
        this.allapot = allapot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public Helyszin getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(Helyszin helyszin) {
        this.helyszin = helyszin;
    }

    public Integer getMaximalisLetszam() {
        return maximalisLetszam;
    }

    public void setMaximalisLetszam(Integer maximalisLetszam) {
        this.maximalisLetszam = maximalisLetszam;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalTime getIdopont() {
        return idopont;
    }

    public void setIdopont(LocalTime idopont) {
        this.idopont = idopont;
    }

    public String getKepEleresiUt() {
        return kepEleresiUt;
    }

    public void setKepEleresiUt(String kepEleresiUt) {
        this.kepEleresiUt = kepEleresiUt;
    }

    public Felhasznalo getLetrehozoFelhasznalo() {
        return letrehozoFelhasznalo;
    }

    public void setLetrehozoFelhasznalo(Felhasznalo letrehozoFelhasznalo) {
        this.letrehozoFelhasznalo = letrehozoFelhasznalo;
    }

    public LocalDateTime getLetrehozasDatuma() {
        return letrehozasDatuma;
    }

    public void setLetrehozasDatuma(LocalDateTime letrehozasDatuma) {
        this.letrehozasDatuma = letrehozasDatuma;
    }

    public LocalDateTime getModositasDatuma() {
        return modositasDatuma;
    }

    public void setModositasDatuma(LocalDateTime modositasDatuma) {
        this.modositasDatuma = modositasDatuma;
    }

    public ProgramAllapot getAllapot() {
        return allapot;
    }

    public void setAllapot(ProgramAllapot allapot) {
        this.allapot = allapot;
    }
}