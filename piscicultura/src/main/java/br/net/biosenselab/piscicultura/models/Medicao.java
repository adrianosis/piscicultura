package br.net.biosenselab.piscicultura.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francisco Adriano da Silva
 */
@Entity
@Table(name = "medicao")
public class Medicao implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_medicao")
    private Date dataMedicao;
    @Column(name = "peso")
    private double peso;
    @Column(name = "comprimento_padrao")
    private double comprimentoPadrao;
    @Column(name = "compriemnto_cabeca")
    private double compriemntoCabeca;
    @Column(name = "altura_padrao")
    private double alturaPadrao;
    @Column(name = "altura_cabeca")
    private double alturaCabeca;
    @Column(name = "largura_corporal")
    private double larguraCorporal;
    @Column(name = "area_olho_lombo")
    private double areaOlhoLombo;
    @Column(name = "espaco_entre_costelas")
    private double espacoEntreCostelas;
    @Column(name = "ausencia_espinha")
    private boolean ausenciaEspinha;
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataMedicao() {
        return dataMedicao;
    }

    public void setDataMedicao(Date dataMedicao) {
        this.dataMedicao = dataMedicao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getComprimentoPadrao() {
        return comprimentoPadrao;
    }

    public void setComprimentoPadrao(double comprimentoPadrao) {
        this.comprimentoPadrao = comprimentoPadrao;
    }

    public double getCompriemntoCabeca() {
        return compriemntoCabeca;
    }

    public void setCompriemntoCabeca(double compriemntoCabeca) {
        this.compriemntoCabeca = compriemntoCabeca;
    }

    public double getAlturaPadrao() {
        return alturaPadrao;
    }

    public void setAlturaPadrao(double alturaPadrao) {
        this.alturaPadrao = alturaPadrao;
    }

    public double getAlturaCabeca() {
        return alturaCabeca;
    }

    public void setAlturaCabeca(double alturaCabeca) {
        this.alturaCabeca = alturaCabeca;
    }

    public double getLarguraCorporal() {
        return larguraCorporal;
    }

    public void setLarguraCorporal(double larguraCorporal) {
        this.larguraCorporal = larguraCorporal;
    }

    public double getAreaOlhoLombo() {
        return areaOlhoLombo;
    }

    public void setAreaOlhoLombo(double areaOlhoLombo) {
        this.areaOlhoLombo = areaOlhoLombo;
    }

    public double getEspacoEntreCostelas() {
        return espacoEntreCostelas;
    }

    public void setEspacoEntreCostelas(double espacoEntreCostelas) {
        this.espacoEntreCostelas = espacoEntreCostelas;
    }

    public boolean isAusenciaEspinha() {
        return ausenciaEspinha;
    }

    public void setAusenciaEspinha(boolean ausenciaEspinha) {
        this.ausenciaEspinha = ausenciaEspinha;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
