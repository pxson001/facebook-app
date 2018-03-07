package com.facebook.pages.common.services;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomViewGroup;

/* compiled from: round_trip_time */
public class PagesServiceCarouselItem extends CustomViewGroup {
    public static final CallerContext f2330a = CallerContext.a(PagesServiceCarousel.class);
    public CustomFrameLayout f2331b = ((CustomFrameLayout) getView(2131565727));
    public FbDraweeView f2332c = ((FbDraweeView) getView(2131565728));
    public FbTextView f2333d = ((FbTextView) getView(2131565730));
    public FbTextView f2334e = ((FbTextView) getView(2131565731));

    public PagesServiceCarouselItem(Context context) {
        super(context);
        setContentView(2130906120);
    }
}
