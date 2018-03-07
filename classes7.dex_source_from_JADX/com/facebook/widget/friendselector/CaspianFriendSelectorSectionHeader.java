package com.facebook.widget.friendselector;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.widget.CustomViewGroup;

/* compiled from: declare_crisis_location_out */
public class CaspianFriendSelectorSectionHeader extends CustomViewGroup {
    private final FrameLayout f16031a = ((FrameLayout) getView(2131562282));
    private final TextView f16032b = ((TextView) getView(2131560883));

    public CaspianFriendSelectorSectionHeader(Context context) {
        super(context);
        setContentView(2130904497);
    }

    public final void m20005a(String str) {
        this.f16032b.setText(str);
        setVisibility(str != null ? 0 : 8);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f16031a.setVisibility(i);
    }
}
