package mk.ukim.finki.wpaud2.service;

import mk.ukim.finki.wpaud2.model.Product;
import mk.ukim.finki.wpaud2.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<Product> listAllProductsInShoppingCart(Long cartId);
    ShoppingCart getActiveShoppingCart(String username);
    ShoppingCart addProductToShoppingCart(String username,Long productId);
}
