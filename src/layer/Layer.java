package layer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Layer{
	private int inputDim;
	private int outputDim;
	private String fileName;
	private double[][] filter;
	
	public static class Builder{
		private int inputDim;
		private int outputDim;
		private String fileName;
		private double[][] filter;
		
		public Builder setInputDim(int inputDim) {
			this.inputDim = inputDim;
			return this;
		}
		
		public Builder setOutputDim(int outputDim) {
			this.outputDim = outputDim;
			return this;
		}
		
		public Builder setFilterFile(String fileName) {
			this.fileName = fileName;
			
			try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
				filter = new double[inputDim][outputDim];
				String[] line;
				for(int i = 0; i < inputDim; i++) {
					line = br.readLine().split(",");
					for(int j = 0; j < inputDim; j++) {
						filter[i][j] = Double.parseDouble(line[j]);
					}
				}
			}catch(IOException e) {
				System.out.println("レイヤーのファイル関連のエラーです");				
			}catch(RuntimeException e) {
				System.out.println("レイヤーの次元が未定義です");
			}
			return this;
		}
		
		public Layer build() {
			return new Layer(this);
		}
		
	}
	
	private Layer(Builder builder) {
		this.inputDim = builder.inputDim;
		this.outputDim = builder.outputDim;
		this.fileName = builder.fileName;
		this.filter = builder.filter;
	}

	public int getInputDim() {
		return inputDim;
	}

	public void setInputDim(int inputDim) {
		this.inputDim = inputDim;
	}

	public int getOutputDim() {
		return outputDim;
	}

	public void setOutputDim(int outputDim) {
		this.outputDim = outputDim;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public double[][] getFilter() {
		return filter;
	}

	public void setFilter(double[][] filter) {
		this.filter = filter;
	}
}

