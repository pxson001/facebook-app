package com.facebook.timeline.editfeaturedcontainers.ui.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.ui.search.SearchEditText;
import javax.inject.Inject;

/* compiled from: geofence_requested_failure */
public class FeaturedContainersSearchEditText extends SearchEditText {
    @Inject
    private RTLUtil f10943b;
    @Inject
    private GlyphColorizer f10944c;

    private static <T extends View> void m11077a(Class<T> cls, T t) {
        m11078a((Object) t, t.getContext());
    }

    private static void m11078a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FeaturedContainersSearchEditText) obj).m11076a(RTLUtil.a(fbInjector), GlyphColorizer.a(fbInjector));
    }

    public FeaturedContainersSearchEditText(Context context) {
        super(context);
        m11079d();
    }

    public FeaturedContainersSearchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11079d();
    }

    private void m11079d() {
        m11077a(FeaturedContainersSearchEditText.class, (View) this);
        Drawable a = this.f10944c.a(2130839976, ContextCompat.b(getContext(), 2131362126));
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131433931);
        if (this.f10943b.a()) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, a, null);
            setGravity(21);
            setPadding(0, 0, dimensionPixelSize, 0);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(a, null, null, null);
        setGravity(19);
        setPadding(dimensionPixelSize, 0, 0, 0);
    }

    private void m11076a(RTLUtil rTLUtil, GlyphColorizer glyphColorizer) {
        this.f10943b = rTLUtil;
        this.f10944c = glyphColorizer;
    }
}
