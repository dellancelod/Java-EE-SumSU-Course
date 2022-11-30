package controller.serializing.json;


import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonSaver {
    public void write(String path, ArrayList<Map<String, Object>> map) {
        System.out.println("Path: " + path);
        try (FileWriter os = new FileWriter(path)) {
            JSONArray jsonArray = new JSONArray();
            jsonArray.addAll(List.of(map));
            os.write(jsonArray.toJSONString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
