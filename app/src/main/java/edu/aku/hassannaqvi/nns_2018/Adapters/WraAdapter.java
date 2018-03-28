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
import edu.aku.hassannaqvi.nns_2018.databinding.WraAdapterBinding;

/**
 * Created by ramsha.ahmed on 3/28/2018.
 */

public class WraAdapter extends RecyclerView.Adapter<WraAdapter.WraViewHolder> {

    WraViewHolder holder;
    private List<FamilyMembersContract> wraList;

    public WraAdapter(List<FamilyMembersContract> wraList) {
        this.wraList = wraList;
    }

    @Override
    public WraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wra_adapter, parent, false);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//add on click event here
            }
        });
        return new WraViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WraViewHolder holder, int position) {
        this.holder = holder;
        this.holder.bindUser(this.wraList.get(position));
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
            wraBinding.wraName.setText(women.getName().toUpperCase());
            wraBinding.ms.setText("Marital Status: " + MStatusChecking(women.getMaritialStatus()));
            wraBinding.Age.setText("Age: " + women.getAge());

        }
    }

}
