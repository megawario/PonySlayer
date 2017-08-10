package xyz.casualcookie.ponyslayer.configuration;

public enum Pages {
	INDEX("ps");
	
	String index;
	
	Pages(String pageIndexName){
		index=pageIndexName;
	}
	
	public String getIndexName(){
		return index;
	}

}
