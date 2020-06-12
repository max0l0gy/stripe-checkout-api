package io.maxology.checkout.with.stripe;

import io.maxology.checkout.with.stripe.domain.ProductPrice;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CheckoutService {
    public ProductPrice.Id add(ProductPrice productPrice){
        return new ProductPrice.Id("IMPLEMENT");
    }
}
