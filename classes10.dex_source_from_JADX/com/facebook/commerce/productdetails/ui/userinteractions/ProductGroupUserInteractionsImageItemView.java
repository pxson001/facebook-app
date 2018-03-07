package com.facebook.commerce.productdetails.ui.userinteractions;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import javax.inject.Inject;

/* compiled from: dbl_settings_passcode_remove */
public class ProductGroupUserInteractionsImageItemView extends CustomRelativeLayout {
    public static final CallerContext f15315b = CallerContext.a(ProductGroupUserInteractionsImageItemView.class);
    @Inject
    public ScreenUtil f15316a;
    public FbDraweeView f15317c = ((FbDraweeView) a(2131566288));
    public GlyphView f15318d = ((GlyphView) a(2131566289));

    public static void m15930a(Object obj, Context context) {
        ((ProductGroupUserInteractionsImageItemView) obj).f15316a = ScreenUtil.a(FbInjector.get(context));
    }

    public ProductGroupUserInteractionsImageItemView(Context context) {
        super(context);
        Class cls = ProductGroupUserInteractionsImageItemView.class;
        m15930a(this, getContext());
        setContentView(2130906409);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f15317c.getLayoutParams());
        layoutParams.width = (Math.min(this.f15316a.c(), this.f15316a.d()) * ProductGroupUserInteractionsView.f15344a) / 100;
        layoutParams.height = (Math.min(this.f15316a.c(), this.f15316a.d()) * ProductGroupUserInteractionsView.f15344a) / 100;
        this.f15317c.setLayoutParams(layoutParams);
    }
}
