package mk.ukim.finki.wpaud2.service.Impl;

import mk.ukim.finki.wpaud2.model.Product;
import mk.ukim.finki.wpaud2.model.ShoppingCart;
import mk.ukim.finki.wpaud2.model.User;
import mk.ukim.finki.wpaud2.model.enums.ShoppingCartStatus;
import mk.ukim.finki.wpaud2.model.exceptions.ProductAlreadyInShoppingCartException;
import mk.ukim.finki.wpaud2.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.wpaud2.model.exceptions.ShoppingCartNotFound;
import mk.ukim.finki.wpaud2.model.exceptions.UserNotFoundException;
import mk.ukim.finki.wpaud2.repository.InMemoryShoppingCartRepository;
import mk.ukim.finki.wpaud2.repository.InMemoryUserRepository;
import mk.ukim.finki.wpaud2.service.ProductService;
import mk.ukim.finki.wpaud2.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final InMemoryShoppingCartRepository inMemoryShoppingCartRepository;
    private final InMemoryUserRepository inMemoryUserRepository;
    private final ProductService productService;

    public ShoppingCartServiceImpl(InMemoryShoppingCartRepository inMemoryShoppingCartRepository, InMemoryUserRepository inMemoryUserRepository, ProductService productService) {
        this.inMemoryShoppingCartRepository = inMemoryShoppingCartRepository;
        this.inMemoryUserRepository = inMemoryUserRepository;
        this.productService = productService;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Long cartId) {
        if(!this.inMemoryShoppingCartRepository.findById(cartId).isPresent())
        {
            throw new ShoppingCartNotFound(cartId);
        }
        return inMemoryShoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        return this.inMemoryShoppingCartRepository.findByUsernameAndStatus(username, ShoppingCartStatus.CREATED)
                .orElseGet(()->{
                        User user=this.inMemoryUserRepository.findByUsername(username)
                                .orElseThrow(()->new UserNotFoundException(username));
                        ShoppingCart shoppingCart  = new ShoppingCart(user);
                        return inMemoryShoppingCartRepository.save(shoppingCart);
                });
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Product product = this.productService.findById(productId)
                .orElseThrow(()->new ProductNotFoundException(productId));
    if(shoppingCart.getProducts().stream().filter(i->i.getId().equals(productId))
            .collect(Collectors.toList()).size()>0)
        {
            throw new ProductAlreadyInShoppingCartException(productId,username);
        }
    shoppingCart.getProducts().add(product);
    return this.inMemoryShoppingCartRepository.save(shoppingCart);
    }
}
