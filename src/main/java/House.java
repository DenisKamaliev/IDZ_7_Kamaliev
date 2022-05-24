import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {
    private String cadastralNumber, address;
    private Person housemate;
    private List<Flat> apartments;

    House() {
        cadastralNumber = "";
        address = "";
        housemate = new Person();
        apartments = new ArrayList<>();
    }

    public House(String cadastralNumber, String address, Person housemate, List<Flat> apartments) {
        this.cadastralNumber = cadastralNumber;
        this.address = address;
        this.housemate = housemate;
        this.apartments = apartments;
    }

    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getHousewife() {
        return housemate;
    }

    public void setHousewife(Person housewife) {
        this.housemate = housewife;
    }

    public List<Flat> getApartments() {
        return apartments;
    }

    public void setApartments(List<Flat> apartments) {
        this.apartments = apartments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return cadastralNumber.equals(house.cadastralNumber) && address.equals(house.address) && housemate.equals(house.housemate) && apartments.equals(house.apartments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadastralNumber, address, housemate, apartments);
    }

    @Override
    public String toString() {
        return "House{" +
                "cadastralNumber='" + cadastralNumber + '\'' +
                ", address='" + address + '\'' +
                ", housewife=" + housemate +
                ", apartments=" + apartments +
                '}';
    }
}