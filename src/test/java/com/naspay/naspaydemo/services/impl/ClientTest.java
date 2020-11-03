package com.naspay.naspaydemo.services.impl;

import com.naspay.naspaydemo.services.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {

    private static final String authorized = "dbb46d0c4cfc4cdd9f923aa229106287";
    private static final String declined = "5ce5fbd950294c4cbf3f3276e645668a";
    private static final String timeout = "8a0885e6526c4257ba213292a0d956b0";
    private static final String completed = "1261481f9625430887e155817e45ec33";
    private static final String notFound = "f33ae3006b074e649c1095ff8fb35e93";

    @Autowired
    private Client client;

    @Test
    public void isEqualsAuthorizedTest() {
        assertEquals("AUTHORIZED", client.getTransactionStatus(authorized));
    }

    @Test
    public void isEqualsDeclineddTest() {
        assertEquals("DECLINED", client.getTransactionStatus(declined));
    }

    @Test
    public void isEqualsTimeoutTest() {
        assertEquals("TIMEOUT", client.getTransactionStatus(timeout));
    }

    @Test
    public void isEqualsCompletedTest() {
        assertEquals("COMPLETED", client.getTransactionStatus(completed));
    }

    @Test
    public void isEqualsNotFoundTest() {
        assertEquals("Transaction not found", client.getTransactionStatus(notFound));
    }
}
