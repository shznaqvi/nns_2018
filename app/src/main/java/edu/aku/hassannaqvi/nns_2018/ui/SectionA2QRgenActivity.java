package edu.aku.hassannaqvi.nns_2018.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.image.ImageType;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Collection;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.core.MainApp;
import edu.aku.hassannaqvi.nns_2018.databinding.ActivitySectionA2QrgenBinding;

public class SectionA2QRgenActivity extends AppCompatActivity {

    ActivitySectionA2QrgenBinding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a2_qrgen);
        binding.setCallback(this);

//        Initialize db
        db = new DatabaseHelper(this);


        new CopyTask(this).execute();
    }


    public class CopyTask extends AsyncTask<Void, Void, JSONArray> {

        ProgressDialog Asycdialog;
        Context mContext;
        Bitmap bitmap;

        public CopyTask(Context mContext) {
            this.mContext = mContext;
            Asycdialog = new ProgressDialog(mContext);
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            Asycdialog.setTitle("GENERATING QR");
            Asycdialog.setMessage("Loading...");
            Asycdialog.setCancelable(false);
            Asycdialog.show();
        }

        @Override
        protected JSONArray doInBackground(Void... arg0) {

            JSONArray jsonSync = null;
            // do the task you want to do. This will be executed in background.
            try {

                Collection<FamilyMembersContract> fmem = db.getFamilyMembersACForm(MainApp.fc.getUID());
                if (fmem.size() > 0) {
                    jsonSync = new JSONArray();
                    for (FamilyMembersContract fc : fmem) {
                        jsonSync.put(fc.toJSONObject());
                    }

                    bitmap = QRCode.from(String.valueOf(jsonSync)).withCharset("UTF-8").to(ImageType.JPG).withSize(700, 700).bitmap();

                    if (fmem.size() < 100) {
                        Thread.sleep(3000);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return jsonSync;
        }

        @Override
        protected void onPostExecute(JSONArray result) {

            super.onPostExecute(result);
            binding.imgQRcode.setImageBitmap(bitmap);
            Asycdialog.dismiss();
            Toast.makeText(mContext, "Copying done!!", Toast.LENGTH_SHORT).show();
        }
    }
}
