package home.epam.hw7.site.components.util;

import com.google.gson.annotations.SerializedName;

public enum Element {

    @SerializedName("Water")
    WATER(1),
    @SerializedName("Earth")
    EARTH(2),
    @SerializedName("Wind")
    WIND(3),
    @SerializedName("Fire")
    FIRE(4);

    private final int index;

    Element(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }

}
