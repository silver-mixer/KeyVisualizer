package com.github.silver_mixer.KeyVisualizer;

public class KeyContainer{
	private int keyCode;
	private boolean isRawCode;
	
	public KeyContainer(int keyCode, boolean isRawCode) {
		this.keyCode = keyCode;
		this.isRawCode = isRawCode;
	}

	@Override
	public String toString(){
		return "KeyContainer [keyCode=0x" + Integer.toHexString(keyCode) + ", isRawCode=" + isRawCode + "]";
	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + (isRawCode ? 1231 : 1237);
		result = prime * result + keyCode;
		return result;
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj)return true;
		if(obj == null)return false;
		if(getClass() != obj.getClass())return false;
		KeyContainer other = (KeyContainer)obj;
		if(isRawCode != other.isRawCode)return false;
		if(keyCode != other.keyCode)return false;
		return true;
	}
}
