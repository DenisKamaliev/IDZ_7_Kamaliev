import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String firstName;
    private String secondName;
    private String fathersName;
    private int bDay;
    private int bMouth;
    private int bYear;

    public Person(String firstName, String secondName, String fathersName, int bDay, int bMouth, int bYear) {
        if (bDay < 0 || bMouth < 0 || bYear < 0) {
            throw new IllegalArgumentException("time Paradox");
        }
        this.bDay = bDay;
        this.bMouth = bMouth;
        this.bYear = bYear;
        this.firstName = firstName;
        this.secondName = secondName;
        this.fathersName = fathersName;
    }

    public Person() {
        firstName = null;
        secondName = null;
        fathersName = null;
        bYear = 0;
        bMouth = 0;
        bDay = 0;
    }

    public String getMiddleName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return fathersName;
    }

    public int getbDay() {
        return bDay;
    }

    public int getbMouth() {
        return bMouth;
    }

    public int getbYear() {
        return bYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return bDay == person.bDay && bMouth == person.bMouth && bYear == person.bYear && Objects.equals(firstName, person.firstName) && Objects.equals(secondName, person.secondName) && Objects.equals(fathersName, person.fathersName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, fathersName, bDay, bMouth, bYear);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + secondName + '\'' +
                ", lastName='" + fathersName + '\'' +
                ", bDay=" + bDay +
                ", bMouth=" + bMouth +
                ", bYear=" + bYear +
                '}';
    }
}
