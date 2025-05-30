package main;

import java.util.Arrays;

import model.Model;
import model.ModelService;

public class Main {
	public static void main(String[] args) {
		Model model = ModelService.createModel();
		
		System.out.println(Arrays.toString(model.getEmbding().getEmb()[0]));
		System.out.println(Arrays.toString(model.getLayers().get(0).getFilter()[0]));
	}
}

