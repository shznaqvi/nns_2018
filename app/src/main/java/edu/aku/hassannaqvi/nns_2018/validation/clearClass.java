package edu.aku.hassannaqvi.nns_2018.validation;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

/**
 * Created by ali.azaz on 03/19/18.
 */

public class clearClass {

    public static void ClearRadioButton(RadioGroup rdGrp, Boolean b) {
        if (rdGrp.getCheckedRadioButtonId() == -1) {

            if (!b) {
                rdGrp.clearCheck();
            }

            for (int i = 0; i < rdGrp.getChildCount(); i++) {
                rdGrp.getChildAt(i).setEnabled(b);
            }
        }
    }

    public static void ClearRadioButton(RadioGroup rdGrp, EditText othertxt, Boolean b) {
        if (rdGrp.getCheckedRadioButtonId() == -1) {

            if (!b) {
                rdGrp.clearCheck();
                othertxt.setText(null);
            }

            for (int i = 0; i < rdGrp.getChildCount(); i++) {
                rdGrp.getChildAt(i).setEnabled(b);
            }
        }
    }

    public static void ClearCheckBoxes(LinearLayout container, Boolean b) {
        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
                v.setEnabled(b);
            }
        }
    }

    public static void ClearCheckBoxes(LinearLayout container, EditText othertxt, Boolean b) {

        othertxt.setText(null);

        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
                v.setEnabled(b);
            }
        }
    }

}
