import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class SerializeHouseJackson {
    private static final ObjectMapper mapper = new ObjectMapper();
    public static String serialize(House house) throws IOException {
        if (house == null) {
            throw new IllegalArgumentException("House is null");
        }
        StringWriter writer = new StringWriter();

        mapper.writeValue(writer, house);

        return writer.toString();
    }

    public static House deserialize(String jsonString) throws IOException {

            StringReader reader = new StringReader(jsonString);
        return mapper.readValue(reader, House.class);

    }
}