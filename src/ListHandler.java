import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListHandler {
    public void handleList(String[] args) {
        if (args.length == 0) {
            System.out.println("Type command");
        } else if (args[0].equals("-l")) {
            getToDoList();
        } else if (args[0].equals("-a")) {
            try {
                addNewTask(args[1]);
            } catch (Exception e) {
                System.out.println("Unable to add: no task provided");
            }
        } else if(args[0].equals("-r")){
            removeTask(args[1]);
        }
    }

    public void getToDoList() {
        Path instructionPath = Paths.get("secondToDoList");
        List<String> content = new ArrayList<>();
        try {
            content = Files.readAllLines(instructionPath);
        } catch (IOException exception) {
            System.out.println("oops");
        }
        StringBuilder sb = new StringBuilder();
        for (String line : content) {
            sb.append(line);
            sb.append("\n");
        }
        if (content.equals(Collections.emptyList())) {
            System.out.println("No todos for today! :)");
        } else {
            for (int i = 0; i < content.size(); i++) {
                System.out.println((i + 1) + " - " + content.get(i));
            }
        }
    }

    public void addNewTask(String toDo) {
        List<String> toDoList = new ArrayList<>();

        try {
            Path newFilePath = Paths.get("emptylist");
            Files.write(newFilePath,Collections.singleton(toDo), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.out.println("Unable to add new task");
        }
    }

    public void removeTask(String index){
        List<String> toDoList = new ArrayList<>();
        Path newFilePath = Paths.get("secondToDoList");
        try {
            toDoList = Files.readAllLines(newFilePath);
        } catch (IOException exception) {
            System.out.println("oops");
        }
        toDoList.remove(Integer.parseInt(index)-1);
        Files.write(newFilePath,toDoList);


    }

}
