package grazioso;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
public class FileHandler {
	private String filename;

	public FileHandler(String filename) {
		this.filename = filename;
	}

	//adds the animals to the files
	public void addAnimal(RescueAnimal animal) {
		try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
			out.println(animal.toString());
		} catch (IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}
	}

	//prints the animals
	public void printAnimals() {
		try {
			List<String> animals = Files.lines(Paths.get(filename))
					.map(line -> line.replace(",", ""))
					.collect(Collectors.toList());

			// Bubble sort algorithm
			for (int i = 0; i < animals.size() - 1; i++) {
				for (int j = 0; j < animals.size() - i - 1; j++) {
					if (animals.get(j).compareTo(animals.get(j + 1)) > 0) {
						// Swap animals.get(j) and animals.get(j + 1)
						String temp = animals.get(j);
						animals.set(j, animals.get(j + 1));
						animals.set(j + 1, temp);
					}
				}
			}

			animals.forEach(System.out::println);
		} catch (IOException e) {
			System.err.println("Error reading from file: " + e.getMessage());
		}
	}
}