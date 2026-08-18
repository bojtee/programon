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
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "jelentkezes",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_jelentkezes_felhasznalo_program",
                        columnNames = {"felhasznalo_id", "program_id"}
                )
        }
)
public class Jelentkezes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "felhasznalo_id", nullable = false)
    private Felhasznalo felhasznalo;

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @Column(name = "jelentkezes_datuma", nullable = false)
    private LocalDateTime jelentkezesDatuma;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private JelentkezesAllapot allapot;

    @Column(name = "lemondas_datuma")
    private LocalDateTime lemondasDatuma;

    public Jelentkezes() {
    }

    public Jelentkezes(
            Felhasznalo felhasznalo,
            Program program,
            LocalDateTime jelentkezesDatuma,
            JelentkezesAllapot allapot,
            LocalDateTime lemondasDatuma) {

        this.felhasznalo = felhasznalo;
        this.program = program;
        this.jelentkezesDatuma = jelentkezesDatuma;
        this.allapot = allapot;
        this.lemondasDatuma = lemondasDatuma;
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

    public LocalDateTime getJelentkezesDatuma() {
        return jelentkezesDatuma;
    }

    public void setJelentkezesDatuma(LocalDateTime jelentkezesDatuma) {
        this.jelentkezesDatuma = jelentkezesDatuma;
    }

    public JelentkezesAllapot getAllapot() {
        return allapot;
    }

    public void setAllapot(JelentkezesAllapot allapot) {
        this.allapot = allapot;
    }

    public LocalDateTime getLemondasDatuma() {
        return lemondasDatuma;
    }

    public void setLemondasDatuma(LocalDateTime lemondasDatuma) {
        this.lemondasDatuma = lemondasDatuma;
    }
}