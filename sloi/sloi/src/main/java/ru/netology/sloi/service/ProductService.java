package ru.netology.sloi.service;
import ru.netology.sloi.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final OrderRepository repository;

    public ProductService(OrderRepository repository) {
        this.repository = repository;
    }

    public String getProductName(String name) {
        return repository.getProductName(name);
    }
}