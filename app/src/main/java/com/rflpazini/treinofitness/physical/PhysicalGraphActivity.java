package com.rflpazini.treinofitness.physical;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.db.chart.Tools;
import com.db.chart.model.BarSet;
import com.db.chart.view.BarChartView;
import com.db.chart.view.XController;
import com.db.chart.view.YController;
import com.db.chart.view.animation.Animation;
import com.rflpazini.treinofitness.R;

public class PhysicalGraphActivity extends AppCompatActivity {

    private BarChartView mChart;

    private final String[] mLabels= {"Peso", "Braço", "Ombro", "Cintura", "Costas", "Peito"};
    private final float [][] mValues = {{6.5f, 8.5f, 2.5f, 7f, 4f, 5f}, {7.5f, 3.5f, 5.5f, 4f, 3f, 6f}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_graph);

        mChart = (BarChartView) findViewById(R.id.barchart);

        // Data
        BarSet barSet = new BarSet(mLabels, mValues[0]);
        barSet.setColor(Color.parseColor("#fc2a53"));
        mChart.addData(barSet);

        mChart.setBarSpacing(Tools.fromDpToPx(40));
        mChart.setRoundCorners(Tools.fromDpToPx(2));
        mChart.setBarBackgroundColor(Color.parseColor("#592932"));

        // Chart
        mChart.setXAxis(false)
                .setYAxis(false)
                .setXLabels(XController.LabelPosition.OUTSIDE)
                .setYLabels(YController.LabelPosition.NONE)
                .setLabelsColor(Color.parseColor("#86705c"))
                .setAxisColor(Color.parseColor("#86705c"));

        int[] order = {1, 0, 2, 4, 3, 5};

        mChart.show(new Animation()
                .setOverlap(.9f, order));
    }

}
