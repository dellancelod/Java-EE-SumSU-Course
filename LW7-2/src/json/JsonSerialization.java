package json;

import org.json.simple.JSONArray;

import java.io.*;
import java.util.List;
import java.util.TreeMap;

public class JsonSerialization {

    public void write(String path, TreeMap<String, String>... objects) {
        try (FileWriter os = new FileWriter(path)) {
            JSONArray jsonArray = new JSONArray();
            jsonArray.addAll(List.of(objects));
            os.write(jsonArray.toJSONString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}