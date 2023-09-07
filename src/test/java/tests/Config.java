package tests;

public class Config {

    public static String browser = System.getProperty("browser", "chrome");
    public static String url = System.getProperty("url", "https://ui.vision/demo/webtest/frames/");
    //public static String hub = System.getProperty("hub","http://192.168.100.5:4444");
    public static String hub = System.getProperty("hub","http://192.168.100.56:4444");
}
