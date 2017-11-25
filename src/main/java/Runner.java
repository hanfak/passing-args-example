import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Runner {
    public static void main(String[] args) throws IOException {

        if ("".equals(args[0])) {
            System.out.println("default method");
        }

        else if ("file".equals(args[0].toLowerCase())) {
            List<String> fileContents = convertFileInstructionsToArray(args[1]);

            printBoardAndRemoveFromArray(fileContents);

            List<List<String>> instructions = splitMulitpleInstructions(fileContents);

            printInstructions(instructions);
        }
        else if ("commands".equals(args[0].toLowerCase())) {
            List<String> commandsInLine = convertInlineCommandsToArray(args[1]);

            printBoardAndRemoveFromArray(commandsInLine);

            List<List<String>> instructions = splitMulitpleInstructions(commandsInLine);

            printInstructions(instructions);
        }
    }

    private static ArrayList<String> convertInlineCommandsToArray(String arg) {
        return new ArrayList<>(Arrays.asList(arg.split("\\\\n")));
    }

    private static List<String> convertFileInstructionsToArray(String arg) throws IOException {
        List<String> fileContents = Files.lines(Paths.get(arg)).collect(Collectors.toList());
        fileContents.removeIf(String::isEmpty);
        return fileContents;
    }

    private static void printBoardAndRemoveFromArray(List<String> fileContents) {
        System.out.println("Board size is " + fileContents.get(0));
        fileContents.remove(0);
    }

    private static void printInstructions(List<List<String>> instructions) {
        System.out.println("Instructions");
        System.out.println();

        instructions.stream().forEach(System.out::println);
    }

    private static List<List<String>> splitMulitpleInstructions(List<String> commandsInLine) {
        return IntStream.range(0, commandsInLine.size() - 1)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> Arrays.asList(commandsInLine.get(i), commandsInLine.get(i + 1)))
                .collect(Collectors.toList());
    }
}
