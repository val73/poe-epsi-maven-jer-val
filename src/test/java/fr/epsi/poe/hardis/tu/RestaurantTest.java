package fr.epsi.poe.hardis.tu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jerome on 28/02/17.
 */
public class RestaurantTest {
    public static final String VALID_PHONE_NUMBER = "+33999999999";
    public static final String INVALID_PHONE_NUMBER = "0102030405";
    private Restaurant restaurant;

    public RestaurantTest() {
    }

    @Before
    public void setupRestaurant() {
        restaurant = new Restaurant();
        restaurant.setTelephone(VALID_PHONE_NUMBER);
    }

    @Test
    public void testThatRestaurantIsOpenByDefault() {
        // Arrange
        Restaurant resto;
        //Act
        resto = new Restaurant();
        // Assert
        assertTrue( "Le restaurant n'est pas ouvert par défaut.",resto.isOuvert());
    }

    @Test
    public void testThatInvalidPhoneNumberIsNotSavedInModel() {
        // Arrange : créer le contexte d'exécution
        String tel = INVALID_PHONE_NUMBER; // <-- Mauvais format de numéro de téléphone
        // Act : action sur l'objet
        restaurant.setTelephone(tel);
        // Assert
        assertNotEquals("Un mauvais format de téléphone à été enregistré.",tel, restaurant.getTelephone() );
    }

    @Test
    public void testThatValidPhoneNumberIsSavedInModel() {
        // Arrange
        String tel = VALID_PHONE_NUMBER;
        //Act
        restaurant.setTelephone(tel);
        // Assert
        assertEquals("Un numéro de téléphone au bon format n'a pas été sauvegardé.",tel, restaurant.getTelephone());
    }

    @Test
    public void testThatAddressContainsFrance() {
        // Arrange
        //Act
        restaurant.setAdresse("12, rue du Moulin Saint-Bernard");
        //Assert
        assertTrue(restaurant.getAdresse().contains("FRANCE"));
    }

    @Test
    public void testThatDptmtIs2DigitsLong(){
        // Arrange
        restaurant.setCodePostal("75000");
        // Act
        //Assert
        assertEquals("Le département ne fait pas 2 caractères", 2,
                restaurant.getDepartement().length() );
    }

    @Test
    public void testThatVilleIsNotNull(){
        // Arrange
        // Act
        // Assert
        assertTrue("La ville n'existe pas", restaurant.getVille() != null);
    }

    @Test
    public void testThatRestaurantIsCreatedWithParameters(){
        // Arrange
        Restaurant restPar = new Restaurant("Le nom", "15 Rue cccc","69003", "Lyon", "06.20.32.32.32");
        // Act
        // Assert
        assertTrue("Le constructeur n'initialise pas correctement", (restPar.getNom() == "Le nom") && (restPar.getCodePostal() == "69003"));
    }

    @Test
    public void testThatNameIsInLowerCase(){
        // Arrange
        String sTest = "NNNNNNNN";
        // Act
        restaurant.setNom(sTest);
        // Assert
        assertEquals("Le nom n'est pas en minuscule",sTest.toLowerCase(),restaurant.getNom());

    }

    @Test
    public void testThatCodePostalIs5DigitsLong(){
        // Arrange
        restaurant.setCodePostal("75000");
        // Act
        //Assert
        assertEquals("Le code postal ne fait pas 5 caractères", 5,
                restaurant.getCodePostal().length() );
    }

}
