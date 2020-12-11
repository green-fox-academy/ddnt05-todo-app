package printusage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDo {
    public void handleList(String[] args) {
        if (args.length == 0) {
            System.out.println(getToDoList());
        }

    }

    private String getToDoList(){
        Path instructionPath = Paths.get("printusage/ToDoList");
        List<String> content = new ArrayList<>();
        try {
            content = Files.readAllLines(instructionPath);
        } catch (IOException exception) {
            System.out.println("oops");
        }
        StringBuilder sb = new StringBuilder();
        for (String line: content){
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }
}
