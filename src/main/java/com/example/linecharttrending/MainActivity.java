package com.example.linecharttrending;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChart = findViewById(R.id.lineChart);

        LineDataSet lineDataSet1 = new LineDataSet(getEntries1(), "Data Set 1");
        LineDataSet lineDataSet2 = new LineDataSet(getEntries2(), "Data Set 2");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();

        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);

        LineData lineData = new LineData(dataSets);

        lineChart.getAxisRight().setEnabled(false);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        Legend legend = lineChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);

        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    private ArrayList<Entry> getEntries1() {
        ArrayList<Entry> lineEntries = new ArrayList<>() ;
        lineEntries.add(new Entry(2f, 0));
        lineEntries.add(new Entry(4f, 1));
        lineEntries.add(new Entry(6f, 1));
        lineEntries.add(new Entry(8f, 3));
        return lineEntries;
    }

    private ArrayList<Entry> getEntries2() {
        ArrayList<Entry> lineEntries = new ArrayList<>() ;
        lineEntries.add(new Entry(3f, 0));
        lineEntries.add(new Entry(5f, 1));
        lineEntries.add(new Entry(7f, 1));
        lineEntries.add(new Entry(9f, 3));
        return lineEntries;
    }
}
