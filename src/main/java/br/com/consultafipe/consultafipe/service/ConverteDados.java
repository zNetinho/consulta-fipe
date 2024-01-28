package br.com.consultafipe.consultafipe.service;

import br.com.consultafipe.consultafipe.domain.ModeloVeiculo;
import br.com.consultafipe.consultafipe.domain.VeiculoData;
import com.fasterxml.jackson.core.JsonProcessingException;
import br.com.consultafipe.consultafipe.domain.IConverteDados;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConverteDados implements IConverteDados {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> List<T> obterDados(String json, Class<T> classe) {
        System.out.println("JSON recebido para conversão" + json);
        try {
            // Utilize TypeReference para indicar que está esperando uma lista de objetos
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, classe);
            return mapper.readValue(json, collectionType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter JSON para lista", e);
        }
    }

    public <T> T obterVeiculo(String json, Class<T> classe) {
        System.out.println("JSON recebido para conversão" + json);
        // ao chamar o metodo passamos o objeto JSON, e a classe que vai ser criada, para inferir o tipo
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<VeiculoData> obterDadosModelos(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(json);

        List<ModeloVeiculo> modelos = extractList(root, "modelos");
        List<ModeloVeiculo> anos = extractList(root, "anos");

        // Print the lists
        System.out.println("Modelos: " + modelos);
        System.out.println("Anos: " + anos);

        VeiculoData listaDeModelosEAno = new VeiculoData(anos, modelos);

        return Collections.singletonList(listaDeModelosEAno);
    }

    private static List<ModeloVeiculo> extractList(JsonNode root, String key) {
        List<ModeloVeiculo> list = new ArrayList<>();
        JsonNode nodeList = root.path(key);

        Iterator<JsonNode> elements = nodeList.elements();
        while (elements.hasNext()) {
            JsonNode element = elements.next();
            String codigo = element.path("codigo").asText();
            String nome = element.path("nome").asText();
            list.add(new ModeloVeiculo(codigo, nome));
        }

        return list;
    }


}