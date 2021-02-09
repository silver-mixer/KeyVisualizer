package com.github.silver_mixer.KeyVisualizer;

public class NativeKeyLayout{
	private int keyCode;
	private int keyLocation;
	
	public NativeKeyLayout(int keyCode , int keyLocation) {
		this.keyCode = keyCode;
		this.keyLocation = keyLocation;
	}

	@Override
	public String toString(){
		return "NativeKeyLayout [keyCode=0x" + Integer.toHexString(keyCode) + ", keyLocation=" + keyLocation + "]";
	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + keyCode;
		result = prime * result + keyLocation;
		return result;
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj)return true;
		if(obj == null)return false;
		if(getClass() != obj.getClass())return false;
		NativeKeyLayout other = (NativeKeyLayout)obj;
		if(keyCode != other.keyCode)return false;
		if(keyLocation != other.keyLocation)return false;
		return true;
	}
}
