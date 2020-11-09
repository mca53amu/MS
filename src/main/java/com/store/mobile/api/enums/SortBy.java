package com.store.mobile.api.enums;

public enum SortBy {
	ID("id"), BRAND("brand"), ANNOUNCEDATE("release.announceDate"), PRICE_EUR("release.priceEur");

	public final String property;

	SortBy(String string) {
		this.property = string;
	}

	public String value() {
		return property;
	}

}
