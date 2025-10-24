package Tests;

import Main.Member;
import Main.MyReader;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MyReaderTest {
    @Test
    void memberReadingTest() {
        List<Member> members = MyReader.getMembersFromFile("src/Tests/TestData");
        assertEquals(4, members.size());
        assertEquals("Test User1", members.getFirst().getName());
        assertEquals("Platina", members.getLast().getMembershipType());
    }

    @Test
    void fileNotFoundTest() {
        IllegalArgumentException returnValue = assertThrows(IllegalArgumentException.class, () -> MyReader.getMembersFromFile("NoExistingPath"));
        assertTrue(returnValue.getMessage().contains("File not found"));
    }
}
