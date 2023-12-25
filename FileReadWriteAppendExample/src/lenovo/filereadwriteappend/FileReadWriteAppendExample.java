package lenovo.filereadwriteappend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteAppendExample {

	public static void main(String[] args) {
		String fileName = "demofile.txt";

		// Writing to a file
		writeToFile(fileName, "Hello, this is a sample text.");

		// Reading from a file
		String content = readFromFile(fileName);
		System.out.println("Content read from the file: " + content);

		// Appending to a file
		appendToFile(fileName, "\nThis text is appended to the file.");

		// Reading again to see the changes
		content = readFromFile(fileName);
		System.out.println("Updated content read from the file: " + content);
	}

	private static void writeToFile(String fileName, String content) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(content);
			System.out.println("Content successfully written to the file.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static String readFromFile(String fileName) {
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return content.toString();
	}

	private static void appendToFile(String fileName, String content) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			writer.write(content);
			System.out.println("Content successfully appended to the file.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
