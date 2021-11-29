package home.epam.hw7.site.components.util;

import com.google.gson.annotations.SerializedName;

public enum Vegetable {

    @SerializedName("Cucumber")
    CUCUMBER(0),
    @SerializedName("Tomato")
    TOMATO(1),
    @SerializedName("Vegetables")
    VEGETABLES(2),
    @SerializedName("Onion")
    ONION(3);

    private final int index;

    Vegetable(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }
}
