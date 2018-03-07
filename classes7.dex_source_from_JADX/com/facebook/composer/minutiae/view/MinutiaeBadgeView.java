package com.facebook.composer.minutiae.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.soundwave.ControlledSoundWaveView;
import java.text.NumberFormat;
import java.util.Locale;

/* compiled from: text_cleared */
public class MinutiaeBadgeView extends CustomFrameLayout {
    private ControlledSoundWaveView f1858a;
    private FbTextView f1859b;
    private NumberFormat f1860c = NumberFormat.getInstance(Locale.getDefault());

    public MinutiaeBadgeView(Context context) {
        super(context);
        m1833a();
    }

    public MinutiaeBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1833a();
    }

    public MinutiaeBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1833a();
    }

    private void m1833a() {
        setContentView(2130905287);
        this.f1859b = (FbTextView) c(2131563895);
        this.f1858a = (ControlledSoundWaveView) c(2131563894);
    }

    public void setData(int i) {
        if (i == -1) {
            this.f1858a.b();
        } else if (i == 0) {
            this.f1859b.setVisibility(8);
            this.f1858a.setVisibility(0);
            this.f1858a.a();
        } else {
            this.f1859b.setText(this.f1860c.format((long) i));
            this.f1859b.setVisibility(0);
            this.f1858a.setVisibility(8);
            this.f1858a.b();
        }
    }

    public void setVisibility(int i) {
        if (i == 8) {
            this.f1858a.b();
        }
        super.setVisibility(i);
    }
}
