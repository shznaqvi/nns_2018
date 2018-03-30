package edu.aku.hassannaqvi.nns_2018.Adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.aku.hassannaqvi.nns_2018.R;
import edu.aku.hassannaqvi.nns_2018.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.nns_2018.databinding.AdolAdapterBinding;
import edu.aku.hassannaqvi.nns_2018.other.JSONModelClass;
import edu.aku.hassannaqvi.nns_2018.other.JSONUtilClass;

/**
 * Created by ramsha.ahmed on 3/30/2018.
 */

public class AdolescentsAdapter extends RecyclerView.Adapter<AdolescentsAdapter.AdolViewHolder> {

    AdolescentsAdapter.AdolViewHolder holder;
    JSONModelClass json;
    private List<FamilyMembersContract> childList;

    public AdolescentsAdapter(List<FamilyMembersContract> childList) {
        json = new JSONModelClass();
        this.childList = childList;
    }

    @Override
    public AdolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.child_adapter, parent, false);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        return new AdolViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdolViewHolder holder, int position) {
        this.holder = holder;
        this.holder.bindUser(this.childList.get(position));
    }

    @Override
    public int getItemCount() {
        return childList.size() > 0 ? childList.size() : 0;
    }

    private String MStatusChecking(String ms) {
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

    public class AdolViewHolder extends RecyclerView.ViewHolder {

        AdolAdapterBinding adolBinding;

        public AdolViewHolder(View itemView) {
            super(itemView);
            adolBinding = DataBindingUtil.bind(itemView);
        }


        public void bindUser(FamilyMembersContract adol) {
            json = JSONUtilClass.getModelFromJSON(adol.getsA2(), JSONModelClass.class);
            adolBinding.adolName.setText(json.getName().toUpperCase());
            adolBinding.adolAge.setText("Age: " + json.getAge());
            adolBinding.adolms.setText("Marital Status: " + MStatusChecking(json.getMaritalStatus()));
            //childBinding.childmName.setText(json.getMotherName().equals("") ? "..." : json.getMotherName());
        }
    }

}
