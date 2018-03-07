package com.facebook.nearby.v2.resultlist.views.itemview.actionbar.buttons;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import java.text.NumberFormat;
import java.util.Locale;

/* compiled from: d0ba6ef374de09965156ef7fe403c75a */
public class NearbyPlacesActionBarReviewRatingButtonView extends NearbyPlacesActionBarButtonView {
    private static final Class<?> f16020f = NearbyPlacesActionBarReviewRatingButtonView.class;
    private int f16021g;

    public NearbyPlacesActionBarReviewRatingButtonView(Context context) {
        this(context, null);
    }

    public NearbyPlacesActionBarReviewRatingButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearbyPlacesActionBarReviewRatingButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = CallerContext.a(f16020f);
        this.f16021g = this.f16006a.getResources().getColor(2131361917);
        this.f16007b.setGlyphColor(this.f16021g);
    }

    public final void m18812a(double d) {
        double max = Math.max(Math.min(5.0d, d), 0.0d);
        this.f16008c.setTextColor(this.f16021g);
        this.f16008c.setText(NumberFormat.getInstance(Locale.getDefault()).format(max));
    }

    protected int getImageResourceId() {
        return 2130840114;
    }
}
