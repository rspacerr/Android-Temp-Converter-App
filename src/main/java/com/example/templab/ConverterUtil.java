package com.example.templab;

public class ConverterUtil {
    /* converts to Celsius */
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }

    /* converts to fahrenheit */
    public static double convertCelsiusToFahrenheit(double celsius) {
        return ((celsius * 9) / 5) + 32;
    }
}
