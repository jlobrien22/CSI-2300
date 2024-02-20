import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Assignment13 {

    public static void main(String[] args) {
        // path to input file
        // String inputFile = "Macintosh HD/Users/obrijl22/hello/src/CSI 2300/CSI-2300-1/Assignment13/src/input.txt";
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            Map<String, Integer> wordCountMap = countWords(inputFile);
            writeWordCountsToFile(wordCountMap, outputFile);
            System.out.println("Word count written to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static Map<String, Integer> countWords(String inputFile) throws IOException {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.toLowerCase();
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap;
    }

    public static void writeWordCountsToFile(Map<String, Integer> wordCountMap, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        }
    }
}
