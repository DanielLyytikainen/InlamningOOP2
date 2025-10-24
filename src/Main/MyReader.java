package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyReader {

    public static List<Member> getMembersFromFile(String filepath) {
        List<Member> members = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            br.readLine(); // Skips first line (header)
            String readMember;
            while ((readMember = br.readLine()) != null) {
                String[] membersInfo = readMember.split(";");
                if (membersInfo.length != 7) {
                    throw new IllegalArgumentException("Invalid member data: " + readMember);
                }
                Member newMember = new Member(membersInfo[0].trim(), membersInfo[1].trim(), membersInfo[2].trim(), membersInfo[3].trim(), membersInfo[4].trim(), membersInfo[5].trim(), membersInfo[6].trim());
                members.add(newMember);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found");

        } catch (IOException e) {
            throw new RuntimeException("Error reading from file");
        }
        return members;
    }
}
