package com.tns.onlineshopping.services;
import java.util.ArrayList;
import java.util.List;

import com.tns.onlineshopping.entities.Product;



public class ProductService {

	    private List<Product> productList = new ArrayList<>();

	    public void addProduct(Product product) {
	        productList.add(product); // Correctly add the product to the list
	    }

	    public void removeProduct(int productId) {
	        productList.removeIf(product -> product.getProductId() == productId); // Correctly remove the product from the list
	    }

	    public List<Product> getProducts() {
	        return new ArrayList<>(productList); // Return a new list to avoid exposing internal representation
	    }

	    public Product getProductById(int productId) {
	        return productList.stream()
	                .filter(product -> product.getProductId() == productId)
	                .findFirst()
	                .orElse(null);
	    }
	}

