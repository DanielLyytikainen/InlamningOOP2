package Tests;

import Main.Member;
import Main.MyWriter;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyWriterTest {
    @Test
    void writerOutputTest() throws IOException {
        Path testpath = Path.of("src/Tests/outputTest.txt");
        Files.deleteIfExists(testpath);

        Member bo = new Member ("Test","AddressTest","test@test.se","123456-1234",
                "2019-02-13","2024-01-25","Guld");
        MyWriter.writeToFile(bo,testpath.toString());
        List<String> result = Files.readAllLines(testpath);
        assertEquals(1,result.size());
        String expectedString = "Test;123456-1234;" + LocalDate.now();
        assertEquals(expectedString,result.getFirst());
    }


}
