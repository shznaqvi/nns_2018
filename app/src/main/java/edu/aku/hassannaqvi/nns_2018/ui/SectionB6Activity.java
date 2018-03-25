package edu.aku.hassannaqvi.nns_2018.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Timer;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.contracts.NutritionContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionB6Binding;
import edu.aku.hassannaqvi.nns_2018.validation.validatorClass;

public class SectionB6Activity extends AppCompatActivity {

    private final long DELAY = 1000;
    ActivitySectionB6Binding bi;
    DatabaseHelper db;
    private Timer timer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b6);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b6);
        db = new DatabaseHelper(this);
        bi.setCallback(this);

        settingTimeToEat();
        setListners();
    }

    private void setListners() {
        bi.nw501none.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501a.setChecked(false);
                    bi.nw501b.setChecked(false);
                    bi.nw501c.setChecked(false);
                    bi.nw501d.setChecked(false);
                    bi.nw501e.setChecked(false);
                    bi.nw501f.setChecked(false);
                    bi.nw501g.setChecked(false);
                    bi.nw501h.setChecked(false);
                    bi.nw501i.setChecked(false);
                    bi.nw501j.setChecked(false);

                    bi.nw501a.setEnabled(false);
                    bi.nw501b.setEnabled(false);
                    bi.nw501c.setEnabled(false);
                    bi.nw501d.setEnabled(false);
                    bi.nw501e.setEnabled(false);
                    bi.nw501f.setEnabled(false);
                    bi.nw501g.setEnabled(false);
                    bi.nw501h.setEnabled(false);
                    bi.nw501i.setEnabled(false);
                    bi.nw501j.setEnabled(false);
                } else {
                    bi.nw501a.setEnabled(true);
                    bi.nw501b.setEnabled(true);
                    bi.nw501c.setEnabled(true);
                    bi.nw501d.setEnabled(true);
                    bi.nw501e.setEnabled(true);
                    bi.nw501f.setEnabled(true);
                    bi.nw501g.setEnabled(true);
                    bi.nw501h.setEnabled(true);
                    bi.nw501i.setEnabled(true);
                    bi.nw501j.setEnabled(true);

                }

            }
        });


        bi.nw501a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

    }

    private void settingTimeToEat() {
        if (MainApp.nuCount == 1) {
            bi.nw501.setText(R.string._1);
        } else if (MainApp.nuCount == 2) {
            bi.nw501.setText(R.string._2);
        } else if (MainApp.nuCount == 3) {
            bi.nw501.setText(R.string._3);
        } else if (MainApp.nuCount == 4) {
            bi.nw501.setText(R.string._4);
        } else if (MainApp.nuCount == 5) {
            bi.nw501.setText(R.string._5);
        } else if (MainApp.nuCount == 6) {
            bi.nw501.setText(R.string._6);
        } else if (MainApp.nuCount == 7) {
            bi.nw501.setText(R.string._7);
        }
    }

    public void BtnContinue() {

        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                finish();

                MainApp.B6Flag = false;

                if (MainApp.nuCount == 7) {

                    int childcount = 0;
                    if (MainApp.childUnder5.size() > 0) {
                        for (FamilyMembersContract fmc : MainApp.childUnder5) {
                            if (fmc.getMotherId().equals(MainApp.mc.getB1SerialNo())) {
                                childcount++;
                            }
                        }
                        if (childcount < 1) {
                            startActivity(new Intent(this, MotherEndingActivity.class)
                                    .putExtra("checkingFlag", true)
                                    .putExtra("complete", true));

                        } else {
                            startActivity(new Intent(this, SectionC1Activity.class));
                        }

                    } else {
                        startActivity(new Intent(this, MotherEndingActivity.class)
                                .putExtra("checkingFlag", true)
                                .putExtra("complete", true));
                    }
                } else {
                    MainApp.nuCount++;
                    finish();
                    startActivity(new Intent(this, SectionB6Activity.class));

                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }


    }

    public void BtnEnd() {

        if (MainApp.nuCount == 1) {
            MainApp.B6Flag = true;
            MainApp.B2B6Flag = false;
        }

        MainApp.endActivityMother(this, this, false);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }

    private boolean ValidateForm() {

        return validatorClass.EmptyCheckBox(this, bi.fldGrpnw501check, bi.nw501a, getString(R.string.nw501a));

    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();


        MainApp.nc = new NutritionContract();

        MainApp.nc.setDevicetagID(MainApp.getTagName(this));
        MainApp.nc.setFormDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(System.currentTimeMillis()));
        MainApp.nc.setUser(MainApp.userName);
        MainApp.nc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.nc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.nc.set_UUID(MainApp.mc.get_UID());

        JSONObject sB6 = new JSONObject();
        //       nw501

        sB6.put("nw501a", bi.nw501a.isChecked() ? "1"
                : "2");
        sB6.put("nw501b", bi.nw501b.isChecked() ? "1"
                : "2");
        sB6.put("nw501c", bi.nw501c.isChecked() ? "1"
                : "2");
        sB6.put("nw501d", bi.nw501d.isChecked() ? "1"
                : "2");
        sB6.put("nw501e", bi.nw501e.isChecked() ? "1"
                : "2");
        sB6.put("nw501f", bi.nw501f.isChecked() ? "1"
                : "2");
        sB6.put("nw501g", bi.nw501g.isChecked() ? "1"
                : "2");
        sB6.put("nw501h", bi.nw501h.isChecked() ? "1"
                : "2");
        sB6.put("nw501i", bi.nw501i.isChecked() ? "1"
                : "2");
        sB6.put("nw501j", bi.nw501j.isChecked() ? "1"
                : "2");

        MainApp.mc.setsB6(String.valueOf(sB6));


        //Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addNutrition(MainApp.nc);
        MainApp.nc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.nc.set_UID(
                    (MainApp.nc.getDeviceId() + MainApp.nc.get_ID()));
            db.updateNutritionID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
