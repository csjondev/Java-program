package test;

import static org.junit.Assert.*;
import org.junit.Test;
import main.Contact;

public class ContactTest {

    @Test
    public void testContactCreation() {
        // Test creating a contact with valid values
        Contact contact = new Contact("ID12345678", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("ID12345678", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactId() {
        // Test creating a contact with an invalid contact ID
        new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstName() {
        // Test creating a contact with an invalid first name
        new Contact("ID12345678", null, "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLastName() {
        // Test creating a contact with an invalid last name
        new Contact("ID12345678", "John", null, "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhone() {
        // Test creating a contact with an invalid phone number
        new Contact("ID12345678", "John", "Doe", null, "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddress() {
        // Test creating a contact with an invalid address
        new Contact("ID12345678", "John", "Doe", "1234567890", null);
    }
}
