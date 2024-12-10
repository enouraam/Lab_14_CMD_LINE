import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScan {
    public static void main(String[] args) {
        int lineLength = 0;
        int lineCount = 0;
        int lineWordCount = 0;
        String fileName;
        if (args.length > 0) {
            fileName = args[0];
        } else {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                fileName = selectedFile.getAbsolutePath();
            } else {
                System.out.println("No file selected.");
                return;
            }
        }
        // Add your file scanning logic here using fileName
        try (Scanner scanner = new Scanner(new File(fileName))) {
            // Read file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String words[] = line.split(" ");
                lineWordCount = 0; //reset the count after each line
                for (String word : words) {
                    lineWordCount++;
                }
                lineCount++;
                lineLength = line.length();
                System.out.printf("Line count: %d Line Length: %d Line word count: %d \n", lineCount, lineLength, lineWordCount);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
