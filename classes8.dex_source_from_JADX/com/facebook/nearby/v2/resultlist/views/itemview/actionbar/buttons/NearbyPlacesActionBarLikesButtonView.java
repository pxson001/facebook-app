package com.facebook.nearby.v2.resultlist.views.itemview.actionbar.buttons;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import java.text.NumberFormat;
import java.util.Locale;

/* compiled from: d5540bef985ad792ceaa0ddf7c137c1e */
public class NearbyPlacesActionBarLikesButtonView extends NearbyPlacesActionBarButtonView {
    private static final Class<?> f16013f = NearbyPlacesActionBarLikesButtonView.class;

    public NearbyPlacesActionBarLikesButtonView(Context context) {
        this(context, null);
    }

    public NearbyPlacesActionBarLikesButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearbyPlacesActionBarLikesButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = CallerContext.a(f16013f);
    }

    public final void m18809c(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f16008c.setText(NumberFormat.getInstance(Locale.getDefault()).format((long) i));
    }

    protected int getImageResourceId() {
        return 2130841051;
    }
}
