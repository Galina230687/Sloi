package ru.netology.sloi.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private final String scriptFileName = read("fetch_product.sql");
    private final NamedParameterJdbcTemplate template;
    private final ConcurrentHashMap<String, List<String>> products;

    public OrderRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
        products = new ConcurrentHashMap<String, List<String>>();
    }

    public String getProductName(String name) {
       System.out.println("PERSON NAME IS: " + name);
        List<String> listPersonGoods;
        if (products.containsKey(name))
        {
            System.out.println("ORDERS HAS KEY WITH NAME: " + name + ", HIS PORDUCTS IS: " + products.get(name).toString());
            listPersonGoods = products.get(name);
        } else {
            listPersonGoods = template.queryForList(scriptFileName, Map.of("name", name), String.class);
            System.out.println("ORDERS HAS KEY WITH NAME: " + name + ", HIS PORDUCTS IS: " + listPersonGoods.toString());
            products.put(name, listPersonGoods);
        }
        return listPersonGoods.toString();
       // return template.queryForList(scriptFileName, Map.of("name", name), String.class).toString();
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}