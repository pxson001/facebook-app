package com.facebook.negativefeedback.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/* compiled from: non_status */
public class NegativeFeedbackGuidedActionAdapter extends ArrayAdapter<NegativeFeedbackGuidedActionItem> {
    public NegativeFeedbackGuidedActionAdapter(Context context, int i) {
        super(context, i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        NegativeFeedbackGuidedActionItemView negativeFeedbackGuidedActionItemView = new NegativeFeedbackGuidedActionItemView(viewGroup.getContext());
        negativeFeedbackGuidedActionItemView.m9759a((NegativeFeedbackGuidedActionItem) getItem(i));
        return negativeFeedbackGuidedActionItemView;
    }
}
