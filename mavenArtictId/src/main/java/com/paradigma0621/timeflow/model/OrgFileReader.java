package com.paradigma0621.timeflow.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrgFileReader {

	public void readDataFromFile(FileDataBase fileContent, String fileName) {

		try {
			FileReader file = new FileReader(fileName);
			BufferedReader readFile = new BufferedReader(file);

			String linha = readFile.readLine(); // lê a primeira linha

			while (linha != null) {
					fileContent.addParagraph(linha);
					linha = readFile.readLine(); // lê da segunda até a última linha
			}

			file.close();
		} catch (IOException e) {
			System.err.printf("Error opening the file: %s.\n", e.getMessage());
		}
	}

}
