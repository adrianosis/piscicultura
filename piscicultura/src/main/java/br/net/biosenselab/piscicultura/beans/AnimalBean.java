package br.net.biosenselab.piscicultura.beans;

import br.net.biosenselab.piscicultura.models.Animal;
import br.net.biosenselab.piscicultura.models.Cruzamento;
import br.net.biosenselab.piscicultura.services.AnimalService;
import br.net.biosenselab.piscicultura.services.CruzamentoService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Francisco Adriano da Silva
 */
@ManagedBean
@ViewScoped
public class AnimalBean extends BasicBean {

    @EJB
    private AnimalService animalService;
    @EJB
    private CruzamentoService cruzamentoService;

    private Animal animal;
    private final List<Animal> listAnimais = new ArrayList<>();
    private List<Cruzamento> listCruzamento;

    // Construtor
    public AnimalBean() {
        animal = new Animal();
    }

    @PostConstruct
    public void postConstruct() {
        listCruzamento = cruzamentoService.find();
    }

    // Metodos
    public void find() {
        try {
            listAnimais.clear();
            listAnimais.addAll(animalService.find());
        } catch (Exception e) {
            showException(e);
        }
    }

    public void newAnimal() {
        try {
            animal = new Animal();
            animal.setCruzamento(new Cruzamento());
        } catch (Exception e) {
            showException(e);
        }
    }

    public void save() {
        try {
            animalService.adicionar(animal, "admin");
        } catch (Exception e) {
            showException(e);
        }
    }

    // Eventos 
    public List<Cruzamento> completeCruzamanto(String query) {
        List<Cruzamento> listCruzamentoF = new ArrayList<>();
        listCruzamentoF.addAll(listCruzamento.stream().filter(p -> String.valueOf(p.getId()).equalsIgnoreCase(query)).collect(Collectors.toList()));
        return listCruzamentoF;
    }

    // Gets and sets
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<Animal> getListAnimais() {
        return listAnimais;
    }

    public List<Cruzamento> getListCruzamento() {
        return listCruzamento;
    }

}
