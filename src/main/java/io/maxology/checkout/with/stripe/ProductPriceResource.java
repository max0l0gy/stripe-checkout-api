package io.maxology.checkout.with.stripe;

import io.maxology.checkout.with.stripe.domain.ProductPrice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/product-price")
public class ProductPriceResource {

    final CheckoutService checkoutService;

    public ProductPriceResource(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductPrice.Id add(ProductPrice productPrice) {
        return checkoutService.add(productPrice);
    }
}