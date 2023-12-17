package ru.batargin.weblab3.util;

import lombok.experimental.UtilityClass;

/**
 * Created by alex on 09/12/2022
 */
@UtilityClass // создает классы утилиты.
public class Checker {

    public boolean isOnPlot(double x, double y, double r) {
        return (x <= 0 && x >= -r/2 && y <= 0 && y >= -r / 2 &&  Math.abs(x) +  Math.abs(y) <= Math.abs(r/2)) || //triangle
                (x >= 0 && x <= r/2 && y <= 0 && y >= -r) || //rectangle
                (x >= 0 && y >= 0 && Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2)); //circle
    }
}
