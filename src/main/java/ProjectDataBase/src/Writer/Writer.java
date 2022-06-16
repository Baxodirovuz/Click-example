package Writer;

import DataBase.DataBase;
import DataBase.WriterBuild;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import idea.Object.User;
import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Writer extends DataBase implements WriterBuild {

    @SneakyThrows
    @Override
    public void writer(User user, ArrayList<User> users) {
        File file = new File("src/main/resources/Users.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(gson.toJson(users));
        writer.close();

    }
}
