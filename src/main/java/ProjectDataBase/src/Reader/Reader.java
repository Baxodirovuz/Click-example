package Reader;

import DataBase.DataBase;
import DataBase.ReaderBuild;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import idea.Object.User;
import lombok.SneakyThrows;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Reader extends DataBase implements ReaderBuild {

    @SneakyThrows
    @Override
    public void reader(User user, ArrayList<User> users) {
        File file = new File("src/main/resources/Users.json");
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Type type = new TypeToken<ArrayList<User>>() {
        }.getType();
        users = gson.fromJson(reader, type);
        reader.close();
    }
}
