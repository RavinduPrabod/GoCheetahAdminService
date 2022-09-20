package com.icbtassignment.gct.entities;

public class StatusDto {
	
private int value;
	
	private String Text;
	
	public StatusDto(int value, String Text) {
		super();
		this.value = value;
		this.Text = Text;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}
	
	
}
