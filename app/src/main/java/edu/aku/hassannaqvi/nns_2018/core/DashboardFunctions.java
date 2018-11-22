package edu.aku.hassannaqvi.nns_2018.core;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import edu.aku.hassannaqvi.nns_2018.other.Summary;

public abstract class DashboardFunctions {

    static TextView headerTextView(Context mContext, String label) {

        TextView headerTextView = new TextView(mContext);
        headerTextView.setBackgroundColor(Color.BLACK);
        headerTextView.setTextColor(Color.GREEN);
        headerTextView.setText(label);
        headerTextView.setTextSize(20);
        headerTextView.setTypeface(Typeface.SANS_SERIF);
        headerTextView.setGravity(Gravity.CENTER);
        headerTextView.setPadding(10, 2, 10, 5);

        return headerTextView;
    }

    static TextView bodyTextView(Context mContext, String label) {

        TextView bodyTextView = new TextView(mContext);
        bodyTextView.setBackgroundColor(Color.BLACK);
        bodyTextView.setTextColor(Color.GREEN);
        bodyTextView.setText(label);
        bodyTextView.setTextSize(15);
        bodyTextView.setTypeface(Typeface.MONOSPACE);
        bodyTextView.setGravity(Gravity.CENTER);
        bodyTextView.setPadding(5, 5, 5, 5);

        return bodyTextView;
    }

    public static TableRow componentHTableRow(Context mContext, String[] headers) {

        TableRow componentBTableRow = new TableRow(mContext);

        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(1, 0, 0, 0);

        for (String label : headers) {
            TextView textView = headerTextView(mContext, label);
            textView.setLayoutParams(params);
            componentBTableRow.addView(textView);
        }

        return componentBTableRow;
    }


    public static TableRow componentBTableRow(Context mContext, ArrayList<Summary> body) {

        TableRow taleRowForTableD = new TableRow(mContext);

        for (int i = 0; i < body.size(); i++) {

            String[] getSum = Summary.GetBody(body.get(i));

            for (int j = 0; j < getSum.length; j++) {
                TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
                params.setMargins(1, 1, 0, 0);

                TextView textViewB = bodyTextView(mContext, getSum[j]);
                taleRowForTableD.addView(textViewB, params);
            }
        }

        return taleRowForTableD;

    }

}
