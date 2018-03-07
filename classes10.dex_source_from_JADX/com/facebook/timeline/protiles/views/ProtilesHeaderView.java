package com.facebook.timeline.protiles.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: favoriteGroup */
public class ProtilesHeaderView extends ImageBlockLayout {
    public static final CallerContext f12410h = CallerContext.a(ProtilesHeaderView.class, "timeline");
    @Inject
    public RTLUtil f12411i;
    public FbDraweeView f12412j = ((FbDraweeView) getView(2131566442));
    public TextView f12413k = ((TextView) getView(2131566443));
    public Drawable f12414l;

    public static void m12449a(Object obj, Context context) {
        ((ProtilesHeaderView) obj).f12411i = RTLUtil.a(FbInjector.get(context));
    }

    public ProtilesHeaderView(Context context) {
        super(context);
        Class cls = ProtilesHeaderView.class;
        m12449a((Object) this, getContext());
        setContentView(2130906505);
        setBackgroundResource(2130842806);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131433949);
        setPadding(dimensionPixelSize, getResources().getDimensionPixelSize(2131433957), dimensionPixelSize, getResources().getDimensionPixelSize(2131433958));
        setThumbnailPadding(getResources().getDimensionPixelSize(2131433959));
        Drawable a = this.f12411i.a(2130838069);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131433960);
        this.f12414l = new InsetDrawable(a, 0, dimensionPixelSize2, 0, -dimensionPixelSize2);
    }

    public void setDrawable(Drawable drawable) {
        ((GenericDraweeHierarchy) this.f12412j.getHierarchy()).b(drawable);
    }

    public static void m12448a(int i, Spannable spannable) {
        spannable.setSpan(new ForegroundColorSpan(i), 0, spannable.length(), 33);
    }
}
