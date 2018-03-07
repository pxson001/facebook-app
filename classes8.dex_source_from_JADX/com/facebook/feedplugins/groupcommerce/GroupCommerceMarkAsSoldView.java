package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: full_height */
public class GroupCommerceMarkAsSoldView extends CustomLinearLayout {
    public final BetterTextView f12753a;

    public GroupCommerceMarkAsSoldView(Context context) {
        this(context, null);
    }

    private GroupCommerceMarkAsSoldView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        setContentView(2130904644);
        this.f12753a = (BetterTextView) a(2131562643);
    }

    public void setButtonContainerVisibility(int i) {
        this.f12753a.setVisibility(i);
    }

    public void setOnChangeAvailabilityClickListener(@Nullable OnClickListener onClickListener) {
        this.f12753a.setOnClickListener(onClickListener);
    }
}
