package com.facebook.rtc.views;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.titlebar.TintableTitleBarButton;

/* compiled from: app_indexing_referrer */
public class RtcPulsingCircleVideoButton extends CustomFrameLayout implements TintableTitleBarButton {
    private RtcPulsingCircleView f20156a;
    private GlyphView f20157b;

    public RtcPulsingCircleVideoButton(Context context) {
        super(context);
        m19800a();
    }

    public RtcPulsingCircleVideoButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19800a();
    }

    public RtcPulsingCircleVideoButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19800a();
    }

    private void m19800a() {
        setContentView(2130906923);
        this.f20156a = (RtcPulsingCircleView) c(2131567173);
        this.f20157b = (GlyphView) c(2131567172);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i2, i2);
    }

    public void setButtonTintColor(int i) {
        this.f20157b.setGlyphColor(i);
        this.f20156a.f20170j = i;
    }
}
