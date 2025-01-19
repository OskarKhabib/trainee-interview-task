package khabibullin.interviewtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import khabibullin.interviewtask.entity.Product;
import khabibullin.interviewtask.repository.ProductCollection;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductCollection productRepository;

    public ProductService(ProductCollection productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        if (!validateProduct(product)) {
            return null;
        }

        return productRepository.create(product);
    }

    public List<Product> readAll() {
        return productRepository.readAll();
    }

    public List<Product> readByName(String name) {
        return productRepository.readByName(name);
    }

    public Product update(Product product) {
        if (!validateProduct(product)) {
            return null;
        }

        return productRepository.update(product);
    }

    public void delete (Long id) {
        productRepository.delete(id);
    }

    private boolean validateProduct(Product product) {
        //Название товара ограничено 255 символами и оно обязательно при создании
        if (product.getName().length() > 255 ||
                product.getName().isEmpty()) {
            return false;
        }

        //Описание товара ограничено 4096 символами
        if (product.getDescription().length() > 4096) {
            return false;
        }

        //Цена товара не может быть меньше 0
        if (product.getPrice() != null && product.getPrice() < 0) {
            return false;
        }

        return true;
    }
}
