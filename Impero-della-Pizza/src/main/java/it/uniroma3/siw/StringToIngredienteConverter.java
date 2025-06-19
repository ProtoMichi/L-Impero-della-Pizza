package it.uniroma3.siw;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.service.IngredienteService;

@Component
public class StringToIngredienteConverter implements Converter<String, Ingrediente> {

    private final IngredienteService ingredienteService;

    public StringToIngredienteConverter(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @Override
    public Ingrediente convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        try {
            Long id = Long.valueOf(source);
            return ingredienteService.getIngredienteById(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
