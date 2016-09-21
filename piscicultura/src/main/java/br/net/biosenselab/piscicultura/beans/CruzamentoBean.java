package br.net.biosenselab.piscicultura.beans;

import br.net.biosenselab.piscicultura.models.Cruzamento;
import br.net.biosenselab.piscicultura.services.CruzamentoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Francisco Adriano da Silva
 */
@ManagedBean
@ViewScoped
public class CruzamentoBean extends BasicBean {

    @EJB
    private CruzamentoService cruzamentoService;

    private Cruzamento cruzamento;
    private final List<Cruzamento> listCruzamento = new ArrayList<>();

    public CruzamentoBean() {
        cruzamento = new Cruzamento();
    }

    //Metodos
    public void find() {
        try {
            listCruzamento.clear();
            listCruzamento.addAll(cruzamentoService.find());
        } catch (Exception e) {
            showException(e);
        }
    }

    public void newCruzamento() {
        try {
            cruzamento = new Cruzamento();
        } catch (Exception e) {
            showException(e);
        }
    }

    public void save() {
        try {
            cruzamentoService.adicionar(cruzamento, "admin");
            find();
        } catch (Exception e) {
            showException(e);
        }
    }

    //Gets and sets
    public Cruzamento getCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(Cruzamento cruzamento) {
        this.cruzamento = cruzamento;
    }

    public List<Cruzamento> getListCruzamento() {
        return listCruzamento;
    }

}
