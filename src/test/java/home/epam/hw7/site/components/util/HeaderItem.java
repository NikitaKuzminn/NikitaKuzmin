package home.epam.hw7.site.components.util;

public enum HeaderItem {

    Home("Home"),
    MetalsAndColors("Metals & Colors");

    private String value;

    HeaderItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}