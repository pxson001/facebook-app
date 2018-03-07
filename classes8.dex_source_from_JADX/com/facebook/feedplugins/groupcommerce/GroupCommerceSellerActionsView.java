package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: friendversary_photo_collage */
public class GroupCommerceSellerActionsView extends CustomViewGroup {
    private final BetterTextView f12798a;
    public final BetterTextView f12799b;
    public final BetterTextView f12800c;
    public final SegmentedLinearLayout f12801d;

    public GroupCommerceSellerActionsView(Context context) {
        this(context, null);
    }

    private GroupCommerceSellerActionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904647);
        this.f12798a = (BetterTextView) getView(2131562648);
        this.f12799b = (BetterTextView) getView(2131562649);
        this.f12800c = (BetterTextView) getView(2131562646);
        this.f12801d = (SegmentedLinearLayout) getView(2131562647);
    }

    public void setOnEditPostClickListener(@Nullable OnClickListener onClickListener) {
        this.f12798a.setOnClickListener(onClickListener);
    }

    public void setOnMarkAsSoldClickListener(@Nullable OnClickListener onClickListener) {
        this.f12799b.setOnClickListener(onClickListener);
    }
}
