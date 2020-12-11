package org.mddarr.providerservice.controllers;



import org.mddarr.providerservice.dto.Provider;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProvidersController {

//    private final ProductService productService;
//
//    public ProvidersController(ProductService productService){
//        this.productService = productService;
//    }
//
//
//    @GetMapping("categories")
//    public List<Category> allCategories() {
//        return productService.fetchCategories();
//    }
//
//    @GetMapping("products")
//    public List<Provider> allProducts() {
//        return productService.fetchAllProducts();
//    }
//
//    @GetMapping("products/vendor/{brandID}")
//    public List<Provider> allVendorProducts(@PathVariable String brandID) {
//        return productService.fetchAllProductsByBrand(brandID);
//    }
//
//    @GetMapping("products/category/{category}")
//    public List<Provider> allCategoryProducts(@PathVariable String category) {
//        return productService.fetchAllProductsByCategory(category);
//    }
//
//    @GetMapping("products/{brand}/{productName}")
//    public ResponseEntity<Provider> getProduct(@PathVariable String brand, @PathVariable String productName,
//                                               @RequestParam(name="isCacheable") boolean isCacheable ){
//        return ResponseEntity.of(productService.getProduct(brand, productName, isCacheable));
//    }

//    @GetMapping
//    public List<Product> allBrandsProducts(){
//
//    }

}
