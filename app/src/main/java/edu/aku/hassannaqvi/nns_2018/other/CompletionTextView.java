package edu.aku.hassannaqvi.nns_2018.other;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tokenautocomplete.TokenCompleteTextView;

import edu.aku.hassannaqvi.nns_2018.R;

/**
 * Created by gul.sanober on 3/1/2018.
 */

public class CompletionTextView extends TokenCompleteTextView<String> {
    public CompletionTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected View getViewForObject(String object) {
        LayoutInflater l = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        TextView view = (TextView) l.inflate(R.layout.completetion_textview, (ViewGroup) getParent(), false);
        view.setText(object);
        return view;
    }

    @Override
    protected String defaultObject(String completionText) {
        return completionText;
    }
}
