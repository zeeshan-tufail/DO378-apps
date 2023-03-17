package com.redhat.training.expense;

import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ExpenseResourceTest {
    @Inject
    ExpenseResource expenseResource;

    @Test
    public void testUpdateExistingExpense(){
        UUID existingUuid = UUID.fromString("effbfe08-0d71-46e7-87af-1132b1b94d87");
        Expense expense = new Expense();
        expense.uuid = existingUuid;
        Assertions.assertDoesNotThrow( () -> expenseResource.update(expense));
    }

    @Test
    public void testUpdateNotFoundExpense(){
        UUID notFoundUuid = UUID.fromString("effbfe08-0d71-46e7-87af-1132b1b94d88");
        Expense expense = new Expense();
        expense.uuid = notFoundUuid;

        ExpenseService expenseServiceMock =  Mockito.mock(ExpenseService.class);

        Mockito.when(expenseServiceMock.exists(notFoundUuid))
                .thenReturn(false);

        ExpenseResource notExpenseResource = new ExpenseResource();
        notExpenseResource.expenseService = expenseServiceMock;

        //expenseResource.expenseService = expenseServiceMock;

        Assertions.assertThrows( WebApplicationException.class, () ->  notExpenseResource.update(expense));

    }
}
