package com.redhat.training.expenses;

import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import com.redhat.training.expenses.Expense.PaymentMethod;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class ExpenseCreationTest {

    @Test
    public void testCreateExpense() {
        given()
            .body(Expense.of("Test Expense", PaymentMethod.CASH, "123"))
            .contentType(ContentType.JSON)
            .post("/expenses");
            
        when()
            .get("/expenses")
        .then()
            .statusCode(200)
            .assertThat().body("size()",is(1))
            .body(
                containsString("\"name\":\"Test Expense\""),
                containsString("\"paymentMethod\":\""+PaymentMethod.CASH+"\""),
                containsString("\"amount\":123.0")
            );

    }

}