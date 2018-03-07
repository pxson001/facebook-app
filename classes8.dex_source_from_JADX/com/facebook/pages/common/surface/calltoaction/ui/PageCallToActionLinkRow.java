package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.ResourceUtils;

/* compiled from: could not extract visibility from =  */
public class PageCallToActionLinkRow extends ImageBlockLayout {
    private FbTextView f16828h;

    public PageCallToActionLinkRow(Context context) {
        super(context);
        m20085a(context, null);
    }

    public PageCallToActionLinkRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20085a(context, attributeSet);
    }

    public PageCallToActionLinkRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20085a(context, attributeSet);
    }

    private void m20085a(Context context, AttributeSet attributeSet) {
        setContentView(2130905978);
        this.f16828h = (FbTextView) getView(2131565385);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PageCallToActionLinkRow);
            this.f16828h.setText(ResourceUtils.a(getContext(), obtainStyledAttributes, 1));
            this.f16828h.setTextColor(obtainStyledAttributes.getColor(0, -16777216));
            obtainStyledAttributes.recycle();
        }
    }
}
