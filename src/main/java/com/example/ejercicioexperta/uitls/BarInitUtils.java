package com.example.ejercicioexperta.uitls;

import com.example.ejercicioexperta.entity.Bar;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class BarInitUtils {

    public static List<Bar> createBarsInit() {
        List<Bar> bars = new ArrayList<>();
        Bar bar = new Bar(
                "Calmate Carrie",
                "Cordoba 3000",
                4,
                "calmatecarrie@gmail.com",
                1526501960,
                2021123456,
                "Desde las 20 a 00",
                false);

        Bar bar2 = new Bar(
                "Temple bar",
                "Irlanda 1200",
                5,
                "Templebar@gmail.com",
                1526501968,
                272650196,
                "24 horas",
                true);

        Bar bar3 = new Bar(
                "SkyBar",
                "Puerto Madero",
                3,
                "Skybar@gmail.com",
                1526506968,
                275650196,
                "Desde las 21 a 00",
                true);

        bars.add(bar);
        bars.add(bar2);
        bars.add(bar3);
        return bars;
    }
}
