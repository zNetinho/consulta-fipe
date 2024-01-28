package br.com.consultafipe.consultafipe.service;

import br.com.consultafipe.consultafipe.domain.MarcaVeiculo;
import com.fasterxml.jackson.core.JsonProcessingException;
import br.com.consultafipe.consultafipe.domain.IConverteDados;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConverteDados implements IConverteDados {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> List<MarcaVeiculo> obterDados(String json, Class<T> classe) {
        try {
            // Utilize TypeReference para indicar que está esperando uma lista de objetos
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, classe);
            return mapper.readValue(json, collectionType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter JSON para lista", e);
        }
    }
}