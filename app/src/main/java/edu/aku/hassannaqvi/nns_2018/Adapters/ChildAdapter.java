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
import edu.aku.hassannaqvi.nns_2018.databinding.ChildAdapterBinding;
import edu.aku.hassannaqvi.nns_2018.other.JSONModelClass;
import edu.aku.hassannaqvi.nns_2018.other.JSONUtilClass;

/**
 * Created by ramsha.ahmed on 3/28/2018.
 */

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    ChildAdapter.ChildViewHolder holder;
    JSONModelClass json;
    private List<FamilyMembersContract> childList;
    public ChildAdapter(List<FamilyMembersContract> childList) {
        json = new JSONModelClass();
        this.childList = childList;
    }

    @Override
    public ChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.child_adapter, parent, false);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        return new ChildViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        this.holder = holder;
        this.holder.bindUser(this.childList.get(position));
    }

    @Override
    public int getItemCount() {
        return childList.size() > 0 ? childList.size() : 0;
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {

        ChildAdapterBinding childBinding;

        public ChildViewHolder(View itemView) {
            super(itemView);
            childBinding = DataBindingUtil.bind(itemView);
        }


        public void bindUser(FamilyMembersContract child) {
            json = JSONUtilClass.getModelFromJSON(child.getsA2(), JSONModelClass.class);
            childBinding.childName.setText(json.getName().toUpperCase());
            childBinding.Age.setText("Age: " + json.getAge());
            childBinding.na204.setText(json.getGender().equals("1") ? "Male" : "Female");
            //childBinding.childmName.setText(child.getMotherName().equals("") ? "..." : child.getMotherName());

           /* wraBinding.wraName.setText(mem.getName().toUpperCase());
            wraBinding.ms.setText("Marital Status: "+MStatusChecking(mem.getMaritialStatus()));
            wraBinding.Age.setText("Age: "+mem.getAge());*/

        }
    }

}