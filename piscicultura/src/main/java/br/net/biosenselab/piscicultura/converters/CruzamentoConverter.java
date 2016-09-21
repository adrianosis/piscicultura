package br.net.biosenselab.piscicultura.converters;

import br.net.biosenselab.piscicultura.beans.AnimalBean;
import br.net.biosenselab.piscicultura.beans.CruzamentoBean;
import br.net.biosenselab.piscicultura.models.Cruzamento;
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
@FacesConverter("cruzamentoConverter")
public class CruzamentoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                AnimalBean animalBean = context.getApplication().evaluateExpressionGet(context, "#{animalBean}", AnimalBean.class);
                int id = Integer.parseInt(value);
                if (id > 0) {
                    return animalBean.getListCruzamento().stream().filter(p -> p.getId() == id).findFirst().get();
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
            return String.valueOf(((Cruzamento) value).getId());
        } else {
            return null;
        }
    }

}
