package home.epam.hw6.util.exceptions;

public class WebDriverLaunchTypeException extends IllegalArgumentException {
    public WebDriverLaunchTypeException() {
        super("Unsupported launch type. Only local and remote are available");
    }
}
