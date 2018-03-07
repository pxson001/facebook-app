package com.facebook.commerce.core.ui;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: prefilled_tag_skipped */
public class ProductItemAtGlanceView extends CustomLinearLayout {
    private static final CallerContext f7520a = CallerContext.a(ProductItemAtGlanceView.class);
    public FbDraweeView f7521b = ((FbDraweeView) a(2131566324));
    public BetterTextView f7522c = ((BetterTextView) a(2131566326));
    public BetterTextView f7523d = ((BetterTextView) a(2131566327));

    public ProductItemAtGlanceView(Context context) {
        super(context);
        setOrientation(1);
        setContentView(2130906417);
    }

    public final void m10653a(ProductItemAtGlanceViewModel productItemAtGlanceViewModel) {
        this.f7521b.a(productItemAtGlanceViewModel.f7524a, f7520a);
        this.f7522c.setText(productItemAtGlanceViewModel.f7525b);
        this.f7523d.setText(productItemAtGlanceViewModel.f7526c);
    }
}
