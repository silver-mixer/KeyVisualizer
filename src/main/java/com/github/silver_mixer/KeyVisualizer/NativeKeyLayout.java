package com.github.silver_mixer.KeyVisualizer;

public class NativeKeyLayout{
	private KeyContainer keyContainer;
	private int keyLocation;
	
	public NativeKeyLayout(KeyContainer keyContainer, int keyLocation) {
		this.keyContainer = keyContainer;
		this.keyLocation = keyLocation;
	}

	@Override
	public String toString(){
		return "NativeKeyLayout [keyContainer=" + keyContainer.toString() + ", keyLocation=" + keyLocation + "]";
	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyContainer == null) ? 0 : keyContainer.hashCode());
		result = prime * result + keyLocation;
		return result;
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj)return true;
		if(obj == null)return false;
		if(getClass() != obj.getClass())return false;
		NativeKeyLayout other = (NativeKeyLayout)obj;
		if(keyContainer == null){
			if(other.keyContainer != null)return false;
		}else if(!keyContainer.equals(other.keyContainer)) {
			return false;
		}
		if(keyLocation != other.keyLocation)return false;
		return true;
	}
}
