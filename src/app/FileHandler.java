package src.app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileHandler {

    // Метод для створення файлу
    public String createFile(String path) {
        Path newFile = Path.of(path);
        try {
            Files.createDirectories(newFile.getParent());  // Створюємо директорію, якщо її немає
            Files.createFile(newFile);  // Створюємо файл
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
        return "Created " + newFile;
    }

    // Метод для запису в файл
    public String writeToFile(Path path, String content) {
        try {
            Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
        return "Recorded in " + path;
    }

    // Метод для читання з файлу
    public String readFromFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
    }
}
