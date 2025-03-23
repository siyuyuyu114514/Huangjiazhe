import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class ReadGroceries {
    public static void main(String[] args) {
        String path = "C:\\Downloads\\Groceries.txt";
        BufferedReader reader = null;
        try {
            FileReader fileread = new FileReader(path);
            reader = new BufferedReader(fileread);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class WriteAFile {
    public static void main(String[] args) {
        String writtenFile = "WriteAFileExample.txt";
        BufferedWriter writer = null;
        try {
            FileWriter filewrite = new FileWriter(writtenFile);
            writer = new BufferedWriter(filewrite);
            writer.write("Hello, World!");
            writer.newLine();
            writer.write("This is a test.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class DiaryWriter {
    public static void main(String[] args) {
        String diaryFile = "Diary.txt";
        BufferedWriter writer = null;
        Scanner scanner = new Scanner(System.in);
        try {
            FileWriter filewrite = new FileWriter(diaryFile);
            writer = new BufferedWriter(filewrite);
            String input;
            while (!(input = scanner.nextLine()).equalsIgnoreCase("END")) {
                writer.write(input);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            scanner.close();
        }
    }
}

class FormatGroceries {
    public static void main(String[] args) {
        String sourceFile = "C:\\Downloads\\Groceries.txt";
        String targetFile = "FormattedGroceries.txt";
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            FileReader fileread = new FileReader(sourceFile);
            reader = new BufferedReader(fileread);
            FileWriter filewrite = new FileWriter(targetFile);
            writer = new BufferedWriter(filewrite);
            writer.write("| ID | Item | Quantity(KG) | Price(€) |");
            writer.newLine();
            writer.write("| --- | --- | --- | --- |");
            writer.newLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                writer.write("| " + parts[0] + " | " + parts[1] + " | " + parts[2] + " | " + parts[3] + " |");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}    