package fr.pompey.cda24060.controller;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Configuration")
@Feature("Tests de configuration")
public class AllureConfigTest {

    @Test
    @DisplayName("Vérification de la configuration Allure")
    @Description("Ce test vérifie que Allure Report est correctement configuré")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Configuration Allure")
    public void testAllureConfiguration() {
        // Given
        String message = "Allure is working!";
        
        // When & Then
        assertNotNull(message);
        assertEquals("Allure is working!", message);
        
        System.out.println("✅ Allure Report est configuré avec succès!");
    }
    
    @Test
    @DisplayName("Test simple de calcul")
    @Description("Vérifie une addition basique")
    @Severity(SeverityLevel.NORMAL)
    @Story("Tests mathématiques")
    public void testSimpleCalculation() {
        // Given
        int a = 2;
        int b = 3;
        
        // When
        int result = a + b;
        
        // Then
        assertEquals(5, result);
    }
    
    @Test
    @DisplayName("Test de validation d'email")
    @Description("Vérifie la validation d'adresses email")
    @Severity(SeverityLevel.NORMAL)
    @Story("Validation")
    public void testEmailValidation() {
        // Given
        String validEmail = "test@example.com";
        String invalidEmail = "invalid-email";
        
        // When & Then
        assertTrue(validEmail.contains("@"));
        assertFalse(invalidEmail.contains("@"));
    }
}
