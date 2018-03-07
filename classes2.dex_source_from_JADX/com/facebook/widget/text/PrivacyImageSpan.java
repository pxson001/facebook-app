package com.facebook.widget.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.google.common.base.Preconditions;

/* compiled from: graphql_response_cache */
public class PrivacyImageSpan extends ReplacementSpan {
    public final Drawable f21923a;

    public PrivacyImageSpan(Drawable drawable) {
        boolean z;
        boolean z2 = true;
        this.f21923a = drawable;
        if (this.f21923a.getIntrinsicWidth() > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (this.f21923a.getIntrinsicHeight() <= 0) {
            z2 = false;
        }
        Preconditions.checkState(z2);
        this.f21923a.setBounds(0, 0, this.f21923a.getIntrinsicWidth(), this.f21923a.getIntrinsicHeight());
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (this.f21923a != null) {
            int i6 = (int) f;
            int abs = Math.abs((i4 - ((paint.getFontMetricsInt().ascent * -1) / 2)) - (this.f21923a.getIntrinsicHeight() / 2));
            this.f21923a.setBounds(i6, abs, this.f21923a.getIntrinsicWidth() + i6, this.f21923a.getIntrinsicHeight() + abs);
            this.f21923a.draw(canvas);
        }
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        return this.f21923a.getIntrinsicWidth();
    }
}
