package com.example.samplelistview;

public class Book {
	
	private String name;
	private int iconId;
	
	public Book (String name, int iconId) {
		this.name = name;
		this.iconId = iconId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIconId() {
		return iconId;
	}

	public void setIconId(int iconId) {
		this.iconId = iconId;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("name: ");
		str.append(name);
		return str.toString();
	}
	
	

}
