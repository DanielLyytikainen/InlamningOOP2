package Tests;
import Main.Member;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class MemberTests {

    @Test
    void verifyValidMembershipTest() {
        Member bo = new Member("Test", "AddressTest", "test@test.se", "123456-1234",
                "2019-02-13", "2024-01-25", "Guld");
        Member ko = new Member("Test", "AddressTest", "test@test.se", "123456-1234",
                "2019-02-13", LocalDate.now().minusMonths(3).toString(), "Guld");
        assertFalse(bo.checkValidMembership());
        assertTrue(ko.checkValidMembership());

    }

    @Test
    void outputStringTest() {
        Member bo = new Member("Test", "AddressTest", "test@test.se", "123456-1234",
                "2019-02-13", "2024-01-25", "Guld");
        String expected = "Test;123456-1234;" + LocalDate.now() + "\n";
        assertEquals(expected, bo.outputString());
    }
}
