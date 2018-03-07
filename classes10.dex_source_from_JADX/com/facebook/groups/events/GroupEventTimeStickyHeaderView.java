package com.facebook.groups.events;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: UP_TO_DATE */
public class GroupEventTimeStickyHeaderView extends CustomLinearLayout {
    public BetterTextView f21786a = ((BetterTextView) a(2131562673));

    public GroupEventTimeStickyHeaderView(Context context) {
        super(context);
        setContentView(2130904655);
        setOrientation(1);
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131361864)));
    }

    public final void m22887a(String str) {
        this.f21786a.setText(str);
    }
}
