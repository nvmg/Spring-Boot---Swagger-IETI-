package org.adaschool.api.service.product;

import org.adaschool.api.repository.product.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductsServiceMap implements ProductsService {
    Map<String, Product> productMap = new HashMap<>();

    @Override
    public Product save(Product product) {
        if(findById(product.getId()).isEmpty()){
            productMap.put(product.getId(), product);
        }
        return productMap.get(product.getId());
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.ofNullable(productMap.get(id));
    }

    @Override
    public List<Product> all() {
        return new ArrayList<>(productMap.values()) ;
    }

    @Override
    public void deleteById(String id) {
        productMap.remove(id);
    }

    @Override
    public Product update(Product product, String id) {
        productMap.replace(id, product);
        return productMap.get(id);
    }}
