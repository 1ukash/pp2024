package ru.spbstu.pp2023.lecture3;

public class VeryLargeImportantClass {
	
	private int secretData;
	
	private int publicData;
	
	class AccessToPublicOnly {
		boolean readyFlag = true;
		
		int getPublicData() {
			return publicData;
		}
		
	}
	
	public AccessToPublicOnly giveOthersSomeData() {
		return new AccessToPublicOnly();
	}
	

	public void setSecretData(int secretData) {
		this.secretData = secretData;
	}

	public int getPublicData() {
		return publicData;
	}

	public void setPublicData(int publicData) {
		this.publicData = publicData;
	}
	
	
	

}
