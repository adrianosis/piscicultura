package br.net.biosenselab.piscicultura.beans;

import br.net.biosenselab.piscicultura.models.Animal;
import br.net.biosenselab.piscicultura.models.Medicao;
import br.net.biosenselab.piscicultura.services.AnimalService;
import br.net.biosenselab.piscicultura.services.MedicaoService;
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
public class MedicaoBean extends BasicBean {

    @EJB
    private AnimalService animalService;
    @EJB
    private MedicaoService medicaoService;

    private Animal animal;
    private Medicao medicao;
    private final List<Medicao> listMedicao = new ArrayList<>();
    private List<Animal> listAnimal;

    public MedicaoBean() {
        medicao = new Medicao();
    }

    @PostConstruct
    public void postConstruct() {
        listAnimal = animalService.find();
    }

    // Metodos
    public void find() {
        try {
            listMedicao.clear();
            listMedicao.addAll(medicaoService.findMedicao(animal.getId()));
        } catch (Exception e) {
            showException(e);
        }
    }

    
    public void newAnimal() {
        try {
            medicao = new Medicao();
        } catch (Exception e) {
            showException(e);
        }
    }
    
    public void save() {
        try {
            medicaoService.adicionar(animal.getId(), medicao, "admin");
        } catch (Exception e) {
            showException(e);
        }
    }

    // Eventos 
    public List<Animal> completeAnimal(String query) {
        List<Animal> listAnimalF = new ArrayList<>();
        listAnimalF.addAll(listAnimal.stream().filter(p -> String.valueOf(p.getNumeroMicroship()).equalsIgnoreCase(query)).collect(Collectors.toList()));
        return listAnimalF;
    }
    
    // Gets and sets
    public Animal getAnimal() {
        return animal;
    }
    
    public void setAnimal(Animal animal) {    
        this.animal = animal;
    }

    public Medicao getMedicao() {
        return medicao;
    }

    public void setMedicao(Medicao medicao) {
        this.medicao = medicao;
    }

    public List<Medicao> getListMedicao() {
        return listMedicao;
    }

    public List<Animal> getListAnimal() {
        return listAnimal;
    }

}
