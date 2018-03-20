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
            } else if (v instanceof RadioGroup) {
                if (!flag) {
                    ((RadioGroup) v).clearCheck();
                }
                for (int j = 0; j < ((RadioGroup) v).getChildCount(); j++) {
                    ((RadioGroup) v).getChildAt(j).setEnabled(flag);
                }
            } else if (v instanceof EditText) {
                ((EditText) v).setText(null);
                v.setEnabled(flag);
            } else if (v instanceof LinearLayout) {
                for (int k = 0; k < ((LinearLayout) v).getChildCount(); k++) {
                    View v1 = ((LinearLayout) v).getChildAt(k);
                    if (v1 instanceof CheckBox) {
                        ((CheckBox) v1).setChecked(false);
                        v1.setEnabled(flag);
                    } else if (v1 instanceof RadioGroup) {
                        if (!flag) {
                            ((RadioGroup) v1).clearCheck();
                        }
                        for (int j = 0; j < ((RadioGroup) v1).getChildCount(); j++) {
                            ((RadioGroup) v1).getChildAt(j).setEnabled(flag);
                        }
                    } else if (v1 instanceof EditText) {
                        ((EditText) v1).setText(null);
                        v1.setEnabled(flag);
                    }
                }
            }
        }
    }


}
