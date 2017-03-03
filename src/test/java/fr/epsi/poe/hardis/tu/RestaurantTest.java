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
}