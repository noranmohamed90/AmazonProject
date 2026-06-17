package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils {

    private static JsonNode data;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readTree(
                    new File("src/main/resources/test-data/searchData.json")
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValue(String key) {
        return data.get(key).asText();
    }
}