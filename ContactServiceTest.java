import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
        contact = new Contact("12345", "Reynold", "Demesmin", "4075551234", "123 Main Street");
    }

    @Test
    public void testAddContactWithUniqueId() {
        contactService.addContact(contact);

        assertEquals(contact, contactService.getContact("12345"));
        assertEquals(1, contactService.getContactCount());
    }

    @Test
    public void testCannotAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(null);
        });
    }

    @Test
    public void testCannotAddDuplicateContactId() {
        Contact duplicateContact = new Contact("12345", "John", "Smith", "3215559876", "456 Oak Street");

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(duplicateContact);
        });

        assertEquals(1, contactService.getContactCount());
    }

    @Test
    public void testDeleteContactById() {
        contactService.addContact(contact);
        contactService.deleteContact("12345");

        assertEquals(0, contactService.getContactCount());
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("12345");
        });
    }

    @Test
    public void testCannotDeleteContactThatDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("99999");
        });
    }

    @Test
    public void testCannotDeleteContactWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact(null);
        });
    }

    @Test
    public void testUpdateFirstNameByContactId() {
        contactService.addContact(contact);
        contactService.updateFirstName("12345", "Trey");

        assertEquals("Trey", contactService.getContact("12345").getFirstName());
    }

    @Test
    public void testUpdateLastNameByContactId() {
        contactService.addContact(contact);
        contactService.updateLastName("12345", "Jones");

        assertEquals("Jones", contactService.getContact("12345").getLastName());
    }

    @Test
    public void testUpdatePhoneByContactId() {
        contactService.addContact(contact);
        contactService.updatePhone("12345", "3215559876");

        assertEquals("3215559876", contactService.getContact("12345").getPhone());
    }

    @Test
    public void testUpdateAddressByContactId() {
        contactService.addContact(contact);
        contactService.updateAddress("12345", "456 Oak Street");

        assertEquals("456 Oak Street", contactService.getContact("12345").getAddress());
    }

    @Test
    public void testCannotUpdateContactThatDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("99999", "Trey");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("99999", "Jones");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("99999", "3215559876");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("99999", "456 Oak Street");
        });
    }

    @Test
    public void testUpdateStillUsesContactValidationRules() {
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("12345", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("12345", "VeryLongLast");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("12345", "123");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("12345", "123 Very Long Street Name Here!!");
        });
    }
}
