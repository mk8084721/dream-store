package com.trachcode.dreamstore.controller;

import com.trachcode.dreamstore.dto.ProductDto;
import com.trachcode.dreamstore.exeption.ProductNotFoundException;
import com.trachcode.dreamstore.exeption.ResourceNotFoundException;
import com.trachcode.dreamstore.model.Product;
import com.trachcode.dreamstore.request.AddProductRequest;
import com.trachcode.dreamstore.request.ProductUpdateRequest;
import com.trachcode.dreamstore.response.ApiResponse;
import com.trachcode.dreamstore.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product/id/{productId}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long productId){
        try {
            Product product = productService.getProductById(productId);
            ProductDto productDto = productService.convertToDto(product);
            return ResponseEntity.ok(new ApiResponse("Success!", productDto));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts(){
        try {
            List<Product> products = productService.getAllProduct();
            List<ProductDto> productDtos = productService.getConvertedProducts(products);
            if(products.isEmpty()) {
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Not Found!", null));
            }
            return ResponseEntity.ok(new ApiResponse("Success!", productDtos));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Error!", INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/product/name/{productName}")
    public ResponseEntity<ApiResponse> getProductByName(@PathVariable String productName){
        try {
            List<Product> products = productService.getProductByName(productName);
            List<ProductDto> productDtos = productService.getConvertedProducts(products);
            if(products.isEmpty()) {
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Not Found!", null));
            }
            return ResponseEntity.ok(new ApiResponse("Success!", productDtos));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/product/category/{categoryName}")
    public ResponseEntity<ApiResponse> getProductsByCategory(@PathVariable String categoryName){
        try {
            List<Product> products = productService.getProductsByCategory(categoryName);
            List<ProductDto> productDtos = productService.getConvertedProducts(products);
            if(products.isEmpty()) {
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Not Found!", null));
            }
            return ResponseEntity.ok(new ApiResponse("Success!", productDtos));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/product/brand")
    public ResponseEntity<ApiResponse> getProductsByBrand(@RequestParam String brandName){
        try {
            List<Product> products = productService.getProductsByBrand(brandName);
            List<ProductDto> productDtos = productService.getConvertedProducts(products);
            if(products.isEmpty()) {
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Not Found!", null));
            }
            return ResponseEntity.ok(new ApiResponse("Success!", productDtos));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/product/{name}/brand/{brandName}")
    public ResponseEntity<ApiResponse> getProductsByBrandAndName(@PathVariable String name ,@PathVariable String brandName){
        try {
            List<Product> products = productService.getProductsByBrandAndName(brandName , name);
            List<ProductDto> productDtos = productService.getConvertedProducts(products);
            if(products.isEmpty()) {
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Not Found!", null));
            }
            return ResponseEntity.ok(new ApiResponse("Success!", productDtos));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/product/category/{categoryName}/brand/{brandName}")
    public ResponseEntity<ApiResponse> getProductsByCategoryAndBrand(@PathVariable String categoryName ,@PathVariable String brandName){
        try {
            List<Product> products = productService.getProductsByCategoryAndBrand(categoryName, brandName);
            List<ProductDto> productDtos = productService.getConvertedProducts(products);
            if(products.isEmpty()) {
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Not Found!", null));
            }
            return ResponseEntity.ok(new ApiResponse("Success!", productDtos));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/product/{name}/brand/{brandName}/count")
    public ResponseEntity<ApiResponse> countProductsByBrandAndName(@PathVariable String name ,@PathVariable String brandName){
        try {
            Long productsCount = productService.countProductsByBrandAndName(brandName , name);
            return ResponseEntity.ok(new ApiResponse("Success!", productsCount));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Error!", INTERNAL_SERVER_ERROR));
        }
    }

    @PostMapping("/product/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody AddProductRequest addProductRequest){
        try {
            Product savedProduct = productService.addProduct(addProductRequest);
            ProductDto productDto = productService.convertToDto(savedProduct);
            return ResponseEntity.ok(new ApiResponse("Add product success!", productDto));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable Long productId ,@RequestBody ProductUpdateRequest productUpdateRequest){
        try {
            Product updatedProduct = productService.updateProductById(productUpdateRequest,productId);
            ProductDto productDto = productService.convertToDto(updatedProduct);
            return ResponseEntity.ok(new ApiResponse("Update product success!", productDto));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId){
        try {
            productService.deleteProductById(productId);
            return ResponseEntity.ok(new ApiResponse("Update product success!", null));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }



}
