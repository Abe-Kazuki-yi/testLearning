package model;

import java.util.ArrayList;

import layer.Embding;
import layer.Layer;

public class Model {
	private Embding embding;
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	
	public static class Builder{
		private Embding embding;
		private ArrayList<Layer> layers = new ArrayList<Layer>();
		
		public Builder setEmbding(Embding embding) {
			this.embding = embding;
			return this;
		}
		
		public Builder setLayer(Layer layer) {
			this.layers.add(layer);
			return this;
		}
		
		public Model build() {
			return new Model(this);
		}
	}
	
	private Model(Builder modelBuilder) {
		this.embding = modelBuilder.embding;
		this.layers = modelBuilder.layers;
	}
	
	public Embding getEmbding() {
		return embding;
	}
	
	public ArrayList<Layer> getLayers() {
		return layers;
	}
	
	public void readFiles() {
		
	}
	
}
