package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import layer.Embding;
import layer.Layer;

public class ModelService {
	static private final String CONFIG_FILE = "config.txt";

	public static Model createModel() {

		String line;
		Model.Builder builder = new Model.Builder();

		try (BufferedReader br = new BufferedReader(new FileReader(CONFIG_FILE))) {

			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty()) {
					continue; // 空白行をスキップ
				}

				if (line.equals("Embding")) {
					String element;
					Embding.Builder embBuilder = new Embding.Builder();
					String[] map;
					while ((element = br.readLine()) != null && !element.trim().isEmpty()) {
						map = element.split(":");
						if (map[0].equals("value")) {
							embBuilder.setValue(Integer.parseInt(map[1]));
							continue;
						}

						if (map[0].equals("embDim")) {
							embBuilder.setEmbDim(Integer.parseInt(map[1]));
							continue;
						}

						if (map[0].equals("fileName")) {
							embBuilder.setEmbFile(map[1]);
							continue;
						}

					}
					builder.setEmbding(embBuilder.build());
				}

				if (line.equals("Layer")) {
					String element;
					Layer.Builder tmpBuilder = new Layer.Builder();
					String[] map;
					while ((element = br.readLine()) != null && !element.trim().isEmpty()) {
						map = element.split(":");

						if (map[0].equals("inputDim")) {
							tmpBuilder.setInputDim(Integer.parseInt(map[1]));
							continue;
						}

						if (map[0].equals("outputDim")) {
							tmpBuilder.setOutputDim(Integer.parseInt(map[1]));
							continue;
						}

						if (map[0].equals("fileName")) {
							tmpBuilder.setFilterFile(map[1]);
							continue;
						}
					}
					builder.setLayer(tmpBuilder.build());
				}

			}
		} catch (IOException e) {

		}
		return builder.build();
	}
}
