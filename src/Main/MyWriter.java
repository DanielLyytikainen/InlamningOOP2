package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MyWriter {

    public static void writeToFile(Member member,String filepath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true))) {
            bw.write(member.outputString());

        } catch (IOException e) {
            throw new RuntimeException("Could not write to file");
        }
    }
}