package edu.aku.hassannaqvi.nns_2018.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.nns_2018.JSONModels.JSONModelClass;
import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.core.DatabaseHelper;
import edu.aku.hassannaqvi.nns_2018.databinding.WraAdapterBinding;
import edu.aku.hassannaqvi.nns_2018.other.JSONUtilClass;

/**
 * Created by ramsha.ahmed on 3/28/2018.
 */

public class WraAdapter extends RecyclerView.Adapter<WraAdapter.WraViewHolder> {
    JSONModelClass json;

    WraViewHolder holder;
    private List<FamilyMembersContract> wraList;
    public static ArrayList<Integer> wraExistList;
    DatabaseHelper db;
    Context mContext;

    public WraAdapter(Context mContext, List<FamilyMembersContract> wraList) {
        json = new JSONModelClass();
        this.wraList = wraList;

        this.mContext = mContext;

        wraExistList = new ArrayList<>();
        db = new DatabaseHelper(mContext);
    }

    @Override
    public WraViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wra_adapter, parent, false);

        return new WraViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WraViewHolder holder, int position) {
        this.holder = holder;
        this.holder.bindUser(wraList.get(position));

        if (db.getWRAExistanceByUid(wraList.get(position).get_UUID())) {
            wraExistList.add(position);
        }

    }

    @Override
    public int getItemCount() {
        return wraList.size() > 0 ? wraList.size() : 0;
    }

    public class WraViewHolder extends RecyclerView.ViewHolder {

        WraAdapterBinding wraBinding;

        public WraViewHolder(View itemView) {
            super(itemView);
            wraBinding = DataBindingUtil.bind(itemView);

        }

        public String MStatusChecking(String ms) {
            String result = "";
            switch (ms) {
                case "1":
                    result = "Married";
                    break;
                case "2":
                    result = "Widowed";
                    break;
                case "3":
                    result = "Divorced";
                    break;
                case "4":
                    result = "Seperated";
                    break;
                case "5":
                    result = "Never Married";
                    break;
            }
            return result;
        }

        public void bindUser(FamilyMembersContract women) {

            json = JSONUtilClass.getModelFromJSON(women.getsA2(), JSONModelClass.class);

            wraBinding.wraName.setText(json.getName().toUpperCase());
            wraBinding.ms.setText("Marital Status: " + MStatusChecking(json.getMaritalStatus()));
            wraBinding.Age.setText("Age: " + json.getAge());


        }
    }

}
