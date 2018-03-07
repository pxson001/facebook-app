package com.facebook.video.watchandshop;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: shouldVerifyMobileEligibility */
public class WatchAndShopHeaderView extends CustomFrameLayout {
    public static final CallerContext f3444a = CallerContext.a(WatchAndShopProductItemView.class);
    public FbDraweeView f3445b;

    public WatchAndShopHeaderView(Context context) {
        this(context, null);
    }

    private WatchAndShopHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private WatchAndShopHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907765);
        this.f3445b = (FbDraweeView) c(2131568512);
    }
}
