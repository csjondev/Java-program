package test;

import static org.junit.Assert.*;
import org.junit.Test;
import main.Contact;
import main.ContactService;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("ID12345678", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertEquals(1, contactService.getContacts().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddContactDuplicateId() {
        ContactService contactService = new ContactService();
        Contact contact1 = new Contact("ID12345678", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("ID12345678", "Jane", "Smith", "9876543210", "456 Oak St");

        // Adding the first contact should not throw an exception
        contactService.addContact(contact1);

        // Adding the second contact with the same ID should throw an IllegalArgumentException
        contactService.addContact(contact2);
    }

    @Test
    public void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("ID12345678", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Deleting the contact should result in an empty contacts list
        contactService.deleteContact("ID12345678");
        assertEquals(0, contactService.getContacts().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonexistentContact() {
        ContactService contactService = new ContactService();

        // Deleting a nonexistent contact should throw an IllegalArgumentException
        contactService.deleteContact("NonExistentID");
    }

    @Test
    public void testUpdateContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("ID12345678", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Updating the contact's fields
        contactService.updateContact("ID12345678", "Jane", "Smith", "9876543210", "456 Oak St");

        // Getting the updated contact
        Contact updatedContact = contactService.getContacts().get("ID12345678");

        // Assertions to check if the fields are updated correctly
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("456 Oak St", updatedContact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonexistentContact() {
        ContactService contactService = new ContactService();

        // Updating a nonexistent contact should throw an IllegalArgumentException
        contactService.updateContact("NonExistentID", "Jane", "Smith", "9876543210", "456 Oak St");
    }
}
