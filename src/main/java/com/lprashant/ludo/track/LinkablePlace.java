package com.lprashant.ludo.track;

public class LinkablePlace {

	protected Place nextPlace;

	public LinkablePlace() {
		super();
	}

	public void setNext(Place nextPlace) {
		this.nextPlace = nextPlace;
	}

}