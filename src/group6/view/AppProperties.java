package group6.view;
import java.util.*;
import java.io.*;

/**
 * @author      Mojtaba Jafari
 * @version     1.0                 
 * UI Class  
 * It is used to have a reference to the UI and it instantiate an object for the view.
 * Through this class, when application is launched it gets access to the XML file location.
 */

public class AppProperties {
    private static AppProperties self = null;
    private Properties properties;
    
    public static AppProperties getInstance() {
        if (self == null ) { self = new AppProperties(); } return self;}
    private AppProperties() {properties = new Properties();
    try {properties.load(new FileInputStream("Properties.prop"));}
    catch (IOException e) {throw new RuntimeException("Could not read property file");}}
    public Properties getProperties() {return properties;
    }}
