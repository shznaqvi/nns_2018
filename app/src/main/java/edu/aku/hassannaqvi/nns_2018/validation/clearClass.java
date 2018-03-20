package edu.aku.hassannaqvi.nns_2018.validation;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by ali.azaz on 03/19/18.
 */

public class clearClass {

    public static void ClearRadioButton(LinearLayout container, RadioGroup rdGrp) {
        if (rdGrp.getCheckedRadioButtonId() == -1) {

            rdGrp.clearCheck();

            for (int i = 0; i < container.getChildCount(); i++) {
                View v = container.getChildAt(i);
                if (v instanceof RadioButton) {
                    v.setEnabled(false);
                }
            }
        }
    }

    public static void ClearRadioButton(LinearLayout container, RadioGroup rdGrp, EditText othertxt) {
        if (rdGrp.getCheckedRadioButtonId() == -1) {

            rdGrp.clearCheck();
            othertxt.setText(null);

            for (int i = 0; i < container.getChildCount(); i++) {
                View v = container.getChildAt(i);
                if (v instanceof RadioButton) {
                    v.setEnabled(false);
                }
            }
        }
    }

    public static void ClearCheckBoxes(LinearLayout container) {
        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
                v.setEnabled(false);
            }
        }
    }

    public static void ClearCheckBoxes(LinearLayout container, EditText othertxt) {

        othertxt.setText(null);

        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
                v.setEnabled(false);
            }
        }
    }

    public static void ClearAllFields(LinearLayout container, Boolean flag) {
        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
                v.setEnabled(flag);
            } else if (v instanceof RadioButton) {
                ((RadioButton) v).setChecked(false);
                v.setEnabled(flag);
            } else if (v instanceof EditText) {
                ((EditText) v).setText(null);
                v.setEnabled(flag);
            }
        }
    }

}
