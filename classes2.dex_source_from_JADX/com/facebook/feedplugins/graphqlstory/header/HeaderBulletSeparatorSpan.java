package com.facebook.feedplugins.graphqlstory.header;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;
import com.facebook.inject.Lazy;

/* compiled from: graphql_subscriptions_receive */
public class HeaderBulletSeparatorSpan extends ReplacementSpan {
    private final Lazy<Float> f21915a;

    public HeaderBulletSeparatorSpan(Lazy<Float> lazy) {
        this.f21915a = lazy;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(fontMetricsInt);
        return (int) Math.ceil((double) ((((Float) this.f21915a.get()).floatValue() * 2.0f) + paint.measureText("•")));
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.drawText("•", ((Float) this.f21915a.get()).floatValue() + f, (float) i4, paint);
    }
}
