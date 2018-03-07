package com.facebook.feed.inlinecomposer.work;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: android.intent.action.USER_PRESENT */
public class WorkHeaderView extends CustomLinearLayout {
    public View f19330a = a(2131563151);

    public WorkHeaderView(Context context) {
        super(context);
        View.inflate(context, 2130904904, this);
        setOrientation(0);
    }

    public void setActionButtonClickListener(OnClickListener onClickListener) {
        this.f19330a.setOnClickListener(onClickListener);
    }
}
