import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Flat implements Serializable
{
    public void setNumber(int number) {
        this.number = number;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    private int number;
    private double area;
    private List<Person> person;
    public Flat(int number, double area, List<Person> person)
    {
        if(number <0 || area<0)
        {
            throw new IllegalArgumentException("Введен отрицательный номер или площадь");
        }
        if(person == null)
        {
            throw new IllegalArgumentException("Был подан пустой список людей");
        }
        this.number = number;
        this.area = area;
        this.person = person;
    }
    public Flat() {
        number = 0;
        area = 0;
        person = null;
    }


    public double getArea() {
        return area;
    }

    public int getNumber() {
        return number;
    }

    public List<Person> getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "number=" + number +
                ", area=" + area +
                ", person=" + person +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.number && Double.compare(flat.area, area) == 0 && Objects.equals(person, flat.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, area, person);
    }
}