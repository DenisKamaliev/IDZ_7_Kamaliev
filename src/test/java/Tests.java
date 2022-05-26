import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void TestBinaryFile() throws FileNotFoundException {
        File file = new File("src\\test\\TestBinary.txt");
        int[] expected = new int[5];
        for (int i = 0; i < 5; i++) {
            expected[i] = i + 1;
        }
        int[] arrTest = new int[5];
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(file))) {
            for (int temp : expected) {
                outputStream.writeInt(temp);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            for (int i = 0; i < expected.length; i++) {
                arrTest[i] = dataInputStream.readInt();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        assertArrayEquals(expected, arrTest);
    }

    @Test
    public void TestCharFile() throws IOException {
        File file = new File("src\\test\\TestChar.txt");
        assertTrue(file.exists());
        try (BufferedReader a = new BufferedReader(new FileReader(file))) {
            String b = a.readLine();
            char[] b1 = b.toCharArray();
            char[] expected = new char[]{'D', 'e', 'n', 'i', 's'};
            assertArrayEquals(expected, b1);
        }
    }

    @Test
    public void TestRandomAccess() throws IOException {
        File file = new File("src\\test\\TestRandomAccessFile.txt");
        assertTrue(file.exists());
        int[] arr = new int[5];
        int[] expected = new int[5];
        expected[0] = 6;
        expected[1] = 7;
        expected[2] = 8;
        expected[3] = 9;
        expected[4] = 0;
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            raf.seek(10);
            String text = raf.readLine();
            String[] textArr = text.split(" ");
            for (int i = 0; i < textArr.length; i++) {
                arr[i] = Integer.parseInt(textArr[i]);
            }
            assertArrayEquals(expected, arr);
        }
    }



    @Test
    public void TestSerializeAndDeserialize() throws IOException {
        final String fileName = "C:\\Users\\Denis\\IdeaProjects\\IDZ_7_Kamaliev\\src\\test\\TestSerialize.json";
        List<Person> persons = List.of(
                new Person("Kamaliev", "Denis", "Sergeevich", 04, 04, 2002),
                new Person("Kamalieva", "Alina", "Sergeevna", 18, 11, 2008),
                new Person("Kamalieva", "Oksana", "Sergeevna", 04, 04, 1980)
        );
        List<Flat> flats = List.of(new Flat(60, 70, persons));
        Person housemate = new Person("Kamaliev", "Denis", "Sergeevich", 04, 04, 2002);
        House house = new House("123", "2-ya Leningradskaya 22/1", housemate, flats);

        try (FileOutputStream file = new FileOutputStream(fileName)) {
            SerializeHumans ser = new SerializeHumans();
            ser.houseSerialize(house, file);
        }

        try (FileInputStream file = new FileInputStream(fileName)) {
            SerializeHumans ser = new SerializeHumans();
            House houseTest = ser.houseDeserialize(file);
            assertEquals(houseTest, house);
        }
    }

    @Test
    public void TestSerializeAndDeserializeJson() throws IOException {
        List<Person> persons = List.of(
                new Person("Kamaliev", "Denis", "Sergeevich", 04, 04, 2002),
                new Person("Kamalieva", "Alina", "Sergeevna", 18, 11, 2008),
                new Person("Kamalieva", "Oksana", "Sergeevna", 04, 04, 1980)
        );
        List<Flat> flats = List.of(new Flat(60, 70, persons));
        Person housemate = new Person("Kamaliev", "Denis", "Sergeevich", 04, 04, 2002);
        House house = new House("123", "2-ya Leningradskaya 22/1", housemate, flats);

        String jsonString = SerializeHouseJackson.serialize(house);
        String expected = "{\"cadastralNumber\":\"123\",\"address\":\"2-ya Leningradskaya 22/1\",\"housemate\":{\"firstName\":\"Kamaliev\",\"secondName\":\"Denis\",\"fathersName\":\"Sergeevich\",\"bDay\":4,\"bMouth\":4,\"bYear\":2002},\"apartments\":[{\"number\":60,\"area\":70.0,\"person\":[{\"firstName\":\"Kamaliev\",\"secondName\":\"Denis\",\"fathersName\":\"Sergeevich\",\"bDay\":4,\"bMouth\":4,\"bYear\":2002},{\"firstName\":\"Kamalieva\",\"secondName\":\"Alina\",\"fathersName\":\"Sergeevna\",\"bDay\":18,\"bMouth\":11,\"bYear\":2008},{\"firstName\":\"Kamalieva\",\"secondName\":\"Oksana\",\"fathersName\":\"Sergeevna\",\"bDay\":4,\"bMouth\":4,\"bYear\":1980}]}]}";

        House desHouse = SerializeHouseJackson.deserialize(jsonString);
        assertEquals(desHouse, house);
        assertEquals(expected, jsonString);


    }
}
