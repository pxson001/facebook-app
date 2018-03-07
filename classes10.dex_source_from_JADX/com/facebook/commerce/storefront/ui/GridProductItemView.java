package com.facebook.commerce.storefront.ui;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: could not find a diff path */
public class GridProductItemView extends CustomRelativeLayout {
    public static final CallerContext f15788a = CallerContext.a(GridProductItemView.class);
    public FbDraweeView f15789b;
    public FbTextView f15790c;
    public FbTextView f15791d;
    private FbButton f15792e;

    public GridProductItemView(Context context, boolean z) {
        super(context);
        setContentView(z ? 2130903596 : 2130903597);
        this.f15789b = (FbDraweeView) a(2131560384);
        this.f15790c = (FbTextView) a(2131560387);
        this.f15791d = (FbTextView) a(2131560386);
        this.f15792e = (FbButton) a(2131560388);
        if (!z) {
            this.f15792e.setVisibility(8);
        }
        this.f15789b.setAspectRatio(1.0f);
    }
}
