package com.everis.bootcamp.patronesClient;

public class Coche {
	
	private String status;

	public Coche(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Coche(CocheBuilder a) {
		this.status = a.status;
	}
	
	//Builder
	
		public static class CocheBuilder{
			
			private String status;
			
			public CocheBuilder(String status) {
				this.status = status;
			}
			
			public Coche build() {
				return new Coche(this);
			}
		}

	

}
