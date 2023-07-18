package db_test;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        EntityManager entityManager = null;

        try {
            entityManager = Persistence.createEntityManagerFactory("jpa-unit")
                    .createEntityManager();
            System.out.println("Die Verbindung zur Datenbank funktioniert.");
        } catch (Exception e) {
            System.out.println("Fehler beim Verbindungsaufbau zur Datenbank: " + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
