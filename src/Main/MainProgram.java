package Main;

import javax.swing.*;
import java.util.List;

public class MainProgram {
    MainProgram() {

        List<Member> members = MyReader.getMembersFromFile("src/Main/gym_medlemmar.txt");

        while (true) {
            String input = JOptionPane.showInputDialog("Please enter a name or personal number:");
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                break;
            } else if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a full name or personal number.");
                continue;
            }
            Member foundMember = findMember(input, members);
            if (foundMember == null) {
                JOptionPane.showMessageDialog(null, input + " is not an member.");
            } else if (foundMember.checkValidMembership()) {
                JOptionPane.showMessageDialog(null, "Membership level: " + foundMember.getMembershipType() + "\n" +
                        "The membership is valid.");
                MyWriter.writeToFile(foundMember, "src/Main/PTchecklist.txt");
            } else {
                JOptionPane.showMessageDialog(null, "The membership has expired.");
            }
        }
    }

    private Member findMember(String input, List<Member> members) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(input) || member.getPersonalNumber().equals(input)) {
                return member;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new MainProgram();

    }
}
