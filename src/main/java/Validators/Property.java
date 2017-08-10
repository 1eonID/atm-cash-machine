package Validators;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Property {
  Properties properties = new Properties();
    try {
    InputStreamReader in = new InputStreamReader(new FileInputStream("prop.properties"));
    properties.load(in));
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  }

}

