package com.example.controller;

import com.example.Constants;
import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
public class ProductController {

    @Inject
    private ProductRepository productRepository;

    @RequestMapping(value = Constants.API_ROOT + "/loadProducts", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @RequestMapping(value = Constants.API_ROOT + "/createProduct", method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @RequestMapping(value = Constants.API_ROOT + "/deleteProduct/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(value = "id") Long productId) {
        productRepository.delete(productId);
    }

}
