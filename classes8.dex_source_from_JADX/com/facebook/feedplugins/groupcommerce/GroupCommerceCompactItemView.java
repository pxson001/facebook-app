package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;

/* compiled from: getConstantState() should not return null during inflate */
public class GroupCommerceCompactItemView extends CustomViewGroup {
    public final BetterTextView f12692a;
    public final BetterTextView f12693b;
    public final BetterTextView f12694c;
    public final ImageBlockLayout f12695d;
    public final TextWithEntitiesView f12696e;
    public final ImageView f12697f;

    public GroupCommerceCompactItemView(Context context) {
        this(context, null);
    }

    private GroupCommerceCompactItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904641);
        this.f12695d = (ImageBlockLayout) getView(2131562627);
        this.f12693b = (BetterTextView) getView(2131562628);
        this.f12694c = (BetterTextView) getView(2131562629);
        this.f12692a = (BetterTextView) getView(2131562631);
        this.f12696e = (TextWithEntitiesView) getView(2131562632);
        this.f12697f = (ImageView) getView(2131562630);
        this.f12697f.setVisibility(8);
        this.f12695d.setThumbnailPlaceholderDrawable(getResources().getDrawable(2130840626));
    }

    public void setOnImageBlockClickListener(OnClickListener onClickListener) {
        this.f12695d.setOnClickListener(onClickListener);
    }
}
