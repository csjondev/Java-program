package main;

import java.util.Map;
import java.util.HashMap;

public class ContactService {
    // In-memory storage for contacts using a Map
    private Map<String, Contact> contacts;

    // Constructor to initialize the contacts Map
    public ContactService() {
        contacts = new HashMap<>();
    }

    // Method to add a new contact with a unique ID
    public void addContact(Contact newContact) {
        // Check if the contact ID is unique before adding
        if (!contacts.containsKey(newContact.getContactId())) {
            contacts.put(newContact.getContactId(), newContact);
        } else {
            throw new IllegalArgumentException("Oops! Contact ID must be unique.");
        }
    }

    // Method to delete a contact by contact ID
    public void deleteContact(String contactId) {
        // Check if the contact ID exists before deleting
        if (contacts.containsKey(contactId)) {
            contacts.remove(contactId);
        } else {
            throw new IllegalArgumentException("Uh-oh! Contact with specified ID not found for deletion.");
        }
    }

    // Method to update contact fields by contact ID
    public void updateContact(String contactId, String newFirstName, String newLastName, String newPhone, String newAddress) {
        // Check if the contact ID exists before updating
        if (contacts.containsKey(contactId)) {
            // Get the existing contact
            Contact existingContact = contacts.get(contactId);

            // Update the specified fields
            if (newFirstName != null && newFirstName.length() <= 10) {
                existingContact.setFirstName(newFirstName);
            }
            if (newLastName != null && newLastName.length() <= 10) {
                existingContact.setLastName(newLastName);
            }
            if (newPhone != null && newPhone.length() == 10) {
                existingContact.setPhone(newPhone);
            }
            if (newAddress != null && newAddress.length() <= 30) {
                existingContact.setAddress(newAddress);
            }
        } else {
            throw new IllegalArgumentException("Oopsie! Contact with specified ID not found for updating.");
        }
    }
    public Map<String, Contact> getContacts() {
        return contacts;
    }
}
