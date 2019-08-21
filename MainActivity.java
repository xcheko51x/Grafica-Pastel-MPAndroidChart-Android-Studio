package com.xcheko51x.graficapastel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PieChart pieChart;

    ArrayList<String> valoresX = new ArrayList<>();
    ArrayList<Entry> valoresY = new ArrayList<>();
    ArrayList<Integer> colores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart = findViewById(R.id.pcGrafica);

        // DEFINIMOS ALGUNOS ATRIBUTOS
        pieChart.setHoleRadius(40f);
        pieChart.setDrawXValues(true);
        pieChart.setDrawYValues(true);
        pieChart.setRotationEnabled(true);
        pieChart.animateXY(1500, 1500);

        // CREAMOS UNA LISTA PARA LOS VALORES X
        valoresX.add("Compras");
        valoresX.add("Ventas");
        valoresX.add("Almacen");

        // CREAMOS UNA LISTA PARA LOS VALORES DE Y
        valoresY.add(new Entry(40, 0));
        valoresY.add(new Entry(10, 1));
        valoresY.add(new Entry(50, 2));

        // CREAMOS UNA LISTA DE LOS COLORES
        colores.add(getResources().getColor(R.color.red_flat));
        colores.add(getResources().getColor(R.color.blue_flat));
        colores.add(getResources().getColor(R.color.green_flat));

        // SETEAMOS LOS VALORES DE Y y LOS COLORES
        PieDataSet set = new PieDataSet(valoresY, "Resultados");
        set.setSliceSpace(5f);
        set.setColors(colores);

        // SETEAMOS LOS VALORES DE X
        PieData data = new PieData(valoresX, set);
        pieChart.setData(data);
        pieChart.highlightValues(null);
        pieChart.invalidate();

        // OCULTAR DESCRIPCION
        pieChart.setDescription("Registro de compras y ventas");

        // OCULTAR LEYENDA
        pieChart.setDrawLegend(true);

    }
}
