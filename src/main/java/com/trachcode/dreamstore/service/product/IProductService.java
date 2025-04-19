package com.trachcode.dreamstore.service.product;

import com.trachcode.dreamstore.model.Product;

import java.util.List;

public interface IProductService {
    Product addProduct(Product product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    void updateProductById(Product product , Long id);
    List<Product> getAllProduct();
    List<Product> getProductByName(String name);
    List<Product> getProductsByCategory(String categry);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByBrandAndName(String brand, String name);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    Long countProductsByBrandAndName(String brand, String name);

}
