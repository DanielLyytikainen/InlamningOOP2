package Main;

import java.time.LocalDate;

public class Member {

    private final String name;
    private final String address;
    private final String email;
    private final String personalNumber;
    private final LocalDate startMembership;
    private final LocalDate lastPayment;
    private final String membershipType;

    public Member(String name, String address, String email, String personalNumber, String startMembership, String lastPayment, String membershipType) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.personalNumber = personalNumber;
        this.startMembership = LocalDate.parse(startMembership);
        this.lastPayment = LocalDate.parse(lastPayment);
        this.membershipType = membershipType;
    }

    public boolean checkValidMembership() {
        LocalDate oneYearAfterLastPayment = lastPayment.plusYears(1);
        return LocalDate.now().isBefore(oneYearAfterLastPayment);
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getName() {
        return name;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public String outputString() {
        return name + ";" + personalNumber + ";" + LocalDate.now() + "\n";
    }
}
