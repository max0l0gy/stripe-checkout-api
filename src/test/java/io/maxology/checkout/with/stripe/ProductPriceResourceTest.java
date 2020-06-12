package io.maxology.checkout.with.stripe;

import io.maxology.checkout.with.stripe.domain.ProductPrice;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ProductPriceResourceTest {

    @InjectMock
    CheckoutService checkoutService;

    @Test
    public void testOverrideAdd() {
        String jsonReq = TestUtil.getBody("request/create-product-price.json");
        String jsonResp = TestUtil.getBody("response/create-product-price.200.json");
        ProductPrice pp = ProductPrice.fromJsonString(jsonReq);
        ProductPrice.Id id = ProductPrice.Id.fromJsonString(jsonResp);
        Mockito.when(checkoutService.add(pp)).thenReturn(id);
        assertEquals(id.getPriceId(), checkoutService.add(pp).getPriceId());
    }

    @Test
    public void testAddProductPrice() {
        String jsonReq = TestUtil.getBody("request/create-product-price.json");
        String jsonResp = TestUtil.getBody("response/create-product-price.200.json");
        Mockito.when(checkoutService.add(ProductPrice.fromJsonString(jsonReq))).thenReturn(ProductPrice.Id.fromJsonString(jsonResp));
        given()
                .contentType(ContentType.JSON)
                .body(jsonReq)
                .when().post("/product-price")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(is(jsonResp));
    }

}