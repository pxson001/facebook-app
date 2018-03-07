package com.facebook.negativefeedback.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.facebook.fbui.widget.contentview.CheckedContentView;

/* compiled from: nodemodel_null_with_change_since_last_upload */
public class NegativeFeedbackResponseAdapter extends ArrayAdapter<NegativeFeedbackResponseItem> {
    private LayoutInflater f8098a;

    public NegativeFeedbackResponseAdapter(Context context, int i) {
        super(context, i);
        this.f8098a = LayoutInflater.from(context);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        CheckedContentView checkedContentView = (CheckedContentView) this.f8098a.inflate(2130905420, viewGroup, false);
        NegativeFeedbackResponseItem negativeFeedbackResponseItem = (NegativeFeedbackResponseItem) getItem(i);
        checkedContentView.setTitleText(negativeFeedbackResponseItem.f8099a);
        checkedContentView.setSubtitleText(negativeFeedbackResponseItem.f8100b);
        return checkedContentView;
    }
}
