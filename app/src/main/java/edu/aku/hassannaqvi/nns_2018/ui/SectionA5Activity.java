package edu.aku.hassannaqvi.nns_2018.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA5Binding;

public class SectionA5Activity extends AppCompatActivity {

    ActivitySectionA5Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_info);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);
    }
}
