package com.facebook.nearby.v2.resultlist.views.itemview.actionbar.buttons;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;

/* compiled from: d5498645fc0b702aab67315fabe5daab */
public class NearbyPlacesActionBarOpenNowButtonView extends NearbyPlacesActionBarButtonView {
    private static final Class<?> f16014f = NearbyPlacesActionBarOpenNowButtonView.class;
    private int f16015g;
    private int f16016h;

    public NearbyPlacesActionBarOpenNowButtonView(Context context) {
        this(context, null);
    }

    public NearbyPlacesActionBarOpenNowButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearbyPlacesActionBarOpenNowButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = CallerContext.a(f16014f);
        this.f16007b.setVisibility(8);
        Resources resources = this.f16006a.getResources();
        this.f16015g = resources.getColor(2131361919);
        this.f16016h = resources.getColor(2131361918);
    }

    public final void m18810a(boolean z) {
        int i;
        CharSequence string;
        Resources resources = this.f16006a.getResources();
        if (z) {
            i = this.f16015g;
            string = resources.getString(2131236703);
        } else {
            i = this.f16016h;
            string = resources.getString(2131236704);
        }
        this.f16008c.setTextColor(i);
        this.f16008c.setText(string);
    }
}
