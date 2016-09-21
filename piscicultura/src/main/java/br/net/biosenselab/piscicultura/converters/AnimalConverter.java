/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.net.biosenselab.piscicultura.converters;

import br.net.biosenselab.piscicultura.beans.MedicaoBean;
import br.net.biosenselab.piscicultura.models.Animal;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Francisco Adriano da Silva
 */
@FacesConverter("animalConverter")
public class AnimalConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         if (value != null && value.trim().length() > 0) {
            try {
                MedicaoBean medicaoBean = context.getApplication().evaluateExpressionGet(context, "#{medicaoBean}", MedicaoBean.class);
                int id = Integer.parseInt(value);
                if (id > 0) {
                    return medicaoBean.getListAnimal().stream().filter(p -> p.getNumeroMicroship() == id).findFirst().get();
                }

                return null;
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return String.valueOf(((Animal) value).getNumeroMicroship());
        } else {
            return null;
        }
    }

}
