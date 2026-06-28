import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreatedSuccessfully() {
        Contact contact = new Contact("1234567890", "Reynold", "Demesmin", "4075551234", "123 Main Street");

        assertEquals("1234567890", contact.getContactId());
        assertEquals("Reynold", contact.getFirstName());
        assertEquals("Demesmin", contact.getLastName());
        assertEquals("4075551234", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Reynold", "Demesmin", "4075551234", "123 Main Street");
        });
    }

    @Test
    public void testContactIdCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Reynold", "Demesmin", "4075551234", "123 Main Street");
        });
    }

    @Test
    public void testContactIdCannotBeUpdated() {
        assertThrows(NoSuchMethodException.class, () -> {
            Contact.class.getMethod("setContactId", String.class);
        });
    }

    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Demesmin", "4075551234", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "LongFirstname", "Demesmin", "4075551234", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameCanBeUpdatedWhenValid() {
        Contact contact = new Contact("12345", "Reynold", "Demesmin", "4075551234", "123 Main Street");
        contact.setFirstName("Trey");

        assertEquals("Trey", contact.getFirstName());
    }

    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Reynold", null, "4075551234", "123 Main Street");
        });
    }

    @Test
    public void testLastNameCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Reynold", "VeryLongLast", "4075551234", "123 Main Street");
        });
    }

    @Test
    public void testLastNameCanBeUpdatedWhenValid() {
        Contact contact = new Contact("12345", "Reynold", "Demesmin", "4075551234", "123 Main Street");
        contact.setLastName("Jones");

        assertEquals("Jones", contact.getLastName());
    }

    @Test
    public void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Reynold", "Demesmin", null, "123 Main Street");
        });
    }

    @Test
    public void testPhoneMustBeExactlyTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Reynold", "Demesmin", "407555123", "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Reynold", "Demesmin", "40755512345", "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Reynold", "Demesmin", "40755abc34", "123 Main Street");
        });
    }

    @Test
    public void testPhoneCanBeUpdatedWhenValid() {
        Contact contact = new Contact("12345", "Reynold", "Demesmin", "4075551234", "123 Main Street");
        contact.setPhone("3215559876");

        assertEquals("3215559876", contact.getPhone());
    }

    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Reynold", "Demesmin", "4075551234", null);
        });
    }

    @Test
    public void testAddressCannotBeLongerThanThirtyCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Reynold", "Demesmin", "4075551234", "123 Very Long Street Name Here!!");
        });
    }

    @Test
    public void testAddressCanBeUpdatedWhenValid() {
        Contact contact = new Contact("12345", "Reynold", "Demesmin", "4075551234", "123 Main Street");
        contact.setAddress("456 Oak Street");

        assertEquals("456 Oak Street", contact.getAddress());
    }
}
