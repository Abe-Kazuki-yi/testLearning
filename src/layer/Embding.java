package layer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Embding{
	private int value;
	private int embDim;
	private String fileName;
	private int[][] emb;
	
	public static class Builder{
		private int value;
		private int embDim;
		private String fileName;
		private int[][] emb;
		
		public Builder setValue(int value) {
			this.value = value;
			return this;
		}
		
		public Builder setEmbDim(int embDim) {
			this.embDim = embDim;
			return this;
		}
		
		public Builder setEmbFile(String fileName) {
			this.fileName = fileName;
			
			try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
				emb = new int[value][embDim];
				String[] line;
				for(int i = 0; i < value; i++) {
					line = br.readLine().split(",");
					for(int j = 0; j < embDim; j++) {
						emb[i][j] = Integer.parseInt(line[j]);
					}
				}
			}catch(IOException e) {
				System.out.println("エンブディングのファイル関連のエラーです");				
			}catch(RuntimeException e) {
				System.out.println("エンブディングのvalueか次元が未定義です");
			}
			return this;
		}
		
		public Embding build() {
			return new Embding(this);
		}
		
	}
	
	private Embding(Builder builder) {
		this.value = builder.value;
		this.embDim = builder.embDim;
		this.fileName = builder.fileName;
		this.emb = builder.emb;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getEmbDim() {
		return embDim;
	}

	public void setEmbDim(int embDim) {
		this.embDim = embDim;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int[][] getEmb() {
		return emb;
	}

	public void setEmb(int[][] emb) {
		this.emb = emb;
	}
}
