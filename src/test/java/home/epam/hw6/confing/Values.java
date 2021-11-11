package home.epam.hw6.confing;

import java.util.List;

public class Values {

    public static String HEAD_MENU_TEXT = "HOME\nCONTACT FORM\nSERVICE\nMETALS & COLORS";

    public static List<String> LEFT_MENU_TEXT = List.of("Home", "Contact form", "Service", "Metals & Colors",
        "Elements packs");

    public static List<String> IMG_TXT = List.of(ConfProperties.getProperty("txt1"), ConfProperties.getProperty("txt2"),
        ConfProperties.getProperty("txt3"), ConfProperties.getProperty("txt4"));

    public static final List<String> LOGS = List.of(ConfProperties.getProperty("log1"),
        ConfProperties.getProperty("log2"), ConfProperties.getProperty("log3"), ConfProperties.getProperty("log4"));
}
