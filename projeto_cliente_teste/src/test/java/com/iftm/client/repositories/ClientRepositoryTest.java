package com.iftm.client.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository repository;

    // Cenário de Teste 1
    @Test
    public void testDeleteClientWithExistingId() {
        long id = 1;
        repository.deleteById(id);
        Assertions.assertFalse(repository.existsById(id));
    }

    // Cenário de Teste 2
    @Test
    public void testDeleteExceptionWithNotExistingId() {
        long id = 100000;
        Assertions.assertThrows(Exception.class, () -> repository.deleteById(id));
    }
}