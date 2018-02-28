package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.json.JSONException;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB6NewBinding;

public class SectionB6NewActivity extends AppCompatActivity {

    ActivitySectionB6NewBinding bi;
    DatabaseHelper db;
    @BindViews({R.id.nw601j1, R.id.nw601j2, R.id.nw601j3, R.id.nw601j4, R.id.nw601j5, R.id.nw601j6})
    List<CheckBox> greenLeafy;
    public CheckBox.OnCheckedChangeListener greenLeafyCheck = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isGreenLeafy()) {
                bi.txtGrLeaf.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_checked_checkbox, 0);
            } else {
                bi.txtGrLeaf.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_unchecked, 0);
            }
        }
    };
    @BindViews({R.id.nw601m1, R.id.nw601m2, R.id.nw601m3, R.id.nw601j7, R.id.nw601m4, R.id.nw601m5, R.id.nw601m6, R.id.nw601m7})
    List<CheckBox> green;
    public CheckBox.OnCheckedChangeListener greenCheck = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isGreen()) {
                bi.txtGreen.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_checked_checkbox, 0);
            } else {
                bi.txtGreen.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_unchecked, 0);
            }
        }
    };
    @BindViews({R.id.nw601k1, R.id.nw601k2, R.id.nw601k3, R.id.nw601k4, R.id.nw601m8, R.id.nw601m9})
    List<CheckBox> redVegi;
    public CheckBox.OnCheckedChangeListener redVegiCheck = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isRed()) {
                bi.txtRedVegi.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_checked_checkbox, 0);
            } else {
                bi.txtRedVegi.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_unchecked, 0);
            }
        }
    };
    @BindViews({R.id.nw601m10, R.id.nw601m11, R.id.nw601m12, R.id.nw601b1, R.id.nw601m13, R.id.nw601m14, R.id.nw601m15,
            R.id.nw601b2, R.id.nw601b3, R.id.nw601m16, R.id.nw601b4})
    List<CheckBox> otherVegi;
    public CheckBox.OnCheckedChangeListener othVegiCheck = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isOtherVegi()) {
                bi.txtOthVeg.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_checked_checkbox, 0);
            } else {
                bi.txtOthVeg.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_unchecked, 0);
            }
        }
    };
    @BindViews({R.id.nw601l1, R.id.nw601n1, R.id.nw601n2, R.id.nw601n3, R.id.nw601l2, R.id.nw601n4, R.id.nw601n5,
            R.id.nw601n6})
    List<CheckBox> singSeed;
    public CheckBox.OnCheckedChangeListener sinSeedCheck = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isSingleSeed()) {
                bi.txtSinSeed.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_checked_checkbox, 0);
            } else {
                bi.txtSinSeed.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_unchecked, 0);
            }
        }
    };
    @BindViews({R.id.nw601n7, R.id.nw601n8, R.id.nw601l3, R.id.nw601n9, R.id.nw601n10, R.id.nw601n11, R.id.nw601n12,
            R.id.nw601l4, R.id.nw601n13, R.id.nw601n14, R.id.nw601n15, R.id.nw601n16})
    List<CheckBox> mulSeed;
    public CheckBox.OnCheckedChangeListener mulSeedCheck = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isMulSeed()) {
                bi.txtMulSeed.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_checked_checkbox, 0);
            } else {
                bi.txtMulSeed.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_unchecked, 0);
            }
        }
    };
    @BindViews({R.id.nw601n17, R.id.nw601n18, R.id.nw601n19, R.id.nw601n20, R.id.nw601n21, R.id.nw601n15})
    List<CheckBox> othFru;
    public CheckBox.OnCheckedChangeListener othFruCheck = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isOthFru()) {
                bi.txtothFru.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_checked_checkbox, 0);
            } else {
                bi.txtothFru.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shortcut_unchecked, 0);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b6);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b6_new);
        ButterKnife.bind(this);
        db = new DatabaseHelper(this);
        bi.setCallback(this);

        setUpViews();
    }

    public void setUpViews(){

        bi.vegi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    bi.fldGrpVegi.setVisibility(View.VISIBLE);
                }else{
                    bi.fldGrpVegi.setVisibility(View.GONE);
                    for (CheckBox ck : greenLeafy) {
                        ck.setChecked(false);
                    }

                    for (CheckBox ck : green) {
                        ck.setChecked(false);
                    }

                    for (CheckBox ck : redVegi) {
                        ck.setChecked(false);
                    }

                    for (CheckBox ck : otherVegi) {
                        ck.setChecked(false);
                    }

                }
            }
        });

        bi.fruit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    bi.fldGrpFruit.setVisibility(View.VISIBLE);
                }else{
                    bi.fldGrpFruit.setVisibility(View.GONE);
                    for (CheckBox ck : singSeed) {
                        ck.setChecked(false);
                    }
                    for (CheckBox ck : mulSeed) {
                        ck.setChecked(false);
                    }

                    for (CheckBox ck : othFru) {
                        ck.setChecked(false);
                    }

                }
            }
        });


        bi.cardGrLeafy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bi.fldGrpgrLeafy.getVisibility() == View.GONE)
                {
                    bi.fldGrpgrLeafy.setVisibility(View.VISIBLE);
                }else{
                    bi.fldGrpgrLeafy.setVisibility(View.GONE);

                }
            }
        });

        bi.cardGrVegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bi.fldGrpgrVegi.getVisibility() == View.GONE)
                {
                    bi.fldGrpgrVegi.setVisibility(View.VISIBLE);
                }else{
                    bi.fldGrpgrVegi.setVisibility(View.GONE);
                }
            }
        });

        bi.cardRedVegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bi.fldGrpregVegi.getVisibility() == View.GONE)
                {
                    bi.fldGrpregVegi.setVisibility(View.VISIBLE);
                }else{
                    bi.fldGrpregVegi.setVisibility(View.GONE);
                }
            }
        });

        bi.cardOthVegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bi.fldGrpothVegi.getVisibility() == View.GONE) {
                    bi.fldGrpothVegi.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpothVegi.setVisibility(View.GONE);
                }
            }
        });

        bi.cardSingSeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bi.fldGrpsingSeed.getVisibility() == View.GONE) {
                    bi.fldGrpsingSeed.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpsingSeed.setVisibility(View.GONE);
                }
            }
        });

        bi.cardMulSeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bi.fldGrpmulSeed.getVisibility() == View.GONE) {
                    bi.fldGrpmulSeed.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpmulSeed.setVisibility(View.GONE);
                }
            }
        });

        bi.cardOtherFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bi.fldGrpothFruits.getVisibility() == View.GONE) {
                    bi.fldGrpothFruits.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpothFruits.setVisibility(View.GONE);
                }
            }
        });

        for (CheckBox ck : greenLeafy) {
            ck.setOnCheckedChangeListener(greenLeafyCheck);
        }


        for (CheckBox ck : green) {
            ck.setOnCheckedChangeListener(greenCheck);
        }

        for (CheckBox ck : redVegi) {
            ck.setOnCheckedChangeListener(redVegiCheck);
        }

        for (CheckBox ck : otherVegi) {
            ck.setOnCheckedChangeListener(othVegiCheck);
        }

        for (CheckBox ck : singSeed) {
            ck.setOnCheckedChangeListener(sinSeedCheck);
        }

        for (CheckBox ck : mulSeed) {
            ck.setOnCheckedChangeListener(mulSeedCheck);
        }

        for (CheckBox ck : othFru) {
            ck.setOnCheckedChangeListener(othFruCheck);
        }






    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionC1Activity.class));

    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }

    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

/*        if (!validatorClass.EmptyRadioButton(this, bi.nb60101, bi.nb60101a, getString(R.string.nb601a))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60102, bi.nb60102a, getString(R.string.nb601b))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60103, bi.nb60103a, getString(R.string.nb601c))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60104, bi.nb60104a, getString(R.string.nb601d))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60105, bi.nb60105a, getString(R.string.nb601e))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60106, bi.nb60106a, getString(R.string.nb601f))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60107, bi.nb60107a, getString(R.string.nb601g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60108, bi.nb60108a, getString(R.string.nb601h))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60108, bi.nb60108a, bi.nb60108x, getString(R.string.nb601h) + " - " + getString(R.string.other))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60109, bi.nb60109a, getString(R.string.nb601i))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60109, bi.nb60109a, bi.nb60109x, getString(R.string.nb601j) + " - " + getString(R.string.other))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60196, bi.nb60196a, getString(R.string.nb601j))) {
            return false;
        }

        return validatorClass.EmptyRadioButton(this, bi.nb60196, bi.nb60196a, bi.nb60196x, getString(R.string.nb601j) + " - " + getString(R.string.other));*/

        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

/*
        JSONObject sB6 = new JSONObject();
        //       nb601
//        60101
        sB6.put("nb60101", bi.nb60101a.isChecked() ? "1"
                : bi.nb60101b.isChecked() ? "2"
                : "0");
//        60102
        sB6.put("nb60102", bi.nb60102a.isChecked() ? "1"
                : bi.nb60102b.isChecked() ? "2"
                : "0");
//        60103
        sB6.put("nb60103", bi.nb60103a.isChecked() ? "1"
                : bi.nb60103b.isChecked() ? "2"
                : "0");
//        60104
        sB6.put("nb60104", bi.nb60104a.isChecked() ? "1"
                : bi.nb60104b.isChecked() ? "2"
                : "0");
//        60105
        sB6.put("nb60105", bi.nb60105a.isChecked() ? "1"
                : bi.nb60105b.isChecked() ? "2"
                : "0");
//        60106
        sB6.put("nb60106", bi.nb60106a.isChecked() ? "1"
                : bi.nb60106b.isChecked() ? "2"
                : "0");
//        60107
        sB6.put("nb60107", bi.nb60107a.isChecked() ? "1"
                : bi.nb60107b.isChecked() ? "2"
                : "0");
//        60108
        sB6.put("nb60108", bi.nb60108a.isChecked() ? "1"
                : bi.nb60108b.isChecked() ? "2"
                : "0");
//        60109
        sB6.put("nb60109", bi.nb60109a.isChecked() ? "1"
                : bi.nb60109b.isChecked() ? "2"
                : "0");

//        60196
        sB6.put("nb60196", bi.nb60196a.isChecked() ? "1"
                : bi.nb60196b.isChecked() ? "2"
                : "0");



        sB6.put("nc101", bi.nb60108x.getText().toString());
        sB6.put("nc101", bi.nb60109x.getText().toString());
        sB6.put("nc101", bi.nb60196x.getText().toString());

        MainApp.mc.setsB6(String.valueOf(sB6));
*/


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        /*DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB6();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
*/
        return true;

    }

    public boolean isGreenLeafy() {

        for (CheckBox ck : greenLeafy) {
            if (ck.isChecked())
                return true;
        }

        // Show answer here
        // return i == rg;
        return false;
    }

    public boolean isGreen() {

        int i = 0;
        for (CheckBox ck : green) {
            if (ck.isChecked())
                return true;
        }

        // Show answer here
        // return i == rg;
        return false;
    }

    public boolean isRed() {

        int i = 0;
        for (CheckBox ck : redVegi) {
            if (ck.isChecked())
                return true;
        }

        // Show answer here
        // return i == rg;
        return false;
    }


    public boolean isOtherVegi() {

        int i = 0;
        for (CheckBox ck : otherVegi) {
            if (ck.isChecked())
                return true;
        }

        // Show answer here
        // return i == rg;
        return false;
    }

    public boolean isSingleSeed() {

        int i = 0;
        for (CheckBox ck : singSeed) {
            if (ck.isChecked())
                return true;
        }

        // Show answer here
        // return i == rg;
        return false;
    }

    public boolean isMulSeed() {

        int i = 0;
        for (CheckBox ck : mulSeed) {
            if (ck.isChecked())
                return true;
        }

        // Show answer here
        // return i == rg;
        return false;
    }

    public boolean isOthFru() {

        int i = 0;
        for (CheckBox ck : othFru) {
            if (ck.isChecked())
                return true;
        }

        // Show answer here
        // return i == rg;
        return false;
    }

}


