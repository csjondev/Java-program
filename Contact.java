package main;

public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor to create a new contact
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Set the unique contact ID, making sure it's not too long and not null
        setContactId(contactId);
        // Set the first name, ensuring it's not too long and not null
        setFirstName(firstName);
        // Set the last name, checking it's not too long and not null
        setLastName(lastName);
        // Set the phone number, validating it's exactly 10 digits and not null
        setPhone(phone);
        // Set the address, making sure it's not too long and not null
        setAddress(address);
    }

    // Getter for contactId
    public String getContactId() {
        return contactId;
    }

    // Setter for contactId
    public void setContactId(String contactId) {
        // Validate the uniqueness of contact ID, ensuring it's not too long and not null
        if (contactId != null && contactId.length() <= 10) {
            this.contactId = contactId;
        } else {
            throw new IllegalArgumentException("Oops! Contact ID must not be null and cannot be longer than 10 characters.");
        }
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Setter for firstName
    public void setFirstName(String firstName) {
        // Ensure the first name is not too long and not null
        if (firstName != null && firstName.length() <= 10) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Uh-oh! First name must not be null and cannot be longer than 10 characters.");
        }
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    // Setter for lastName
    public void setLastName(String lastName) {
        // Check that the last name is not too long and not null
        if (lastName != null && lastName.length() <= 10) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Oopsie! Last name must not be null and cannot be longer than 10 characters.");
        }
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Setter for phone
    public void setPhone(String phone) {
        // Validate that the phone number is exactly 10 digits and not null
        if (phone != null && phone.length() == 10) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Yikes! Phone number must not be null and must be exactly 10 digits.");
        }
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        // Ensure the address is not too long and not null
        if (address != null && address.length() <= 30) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Oh no! Address must not be null and cannot be longer than 30 characters.");
        }
    }
}
