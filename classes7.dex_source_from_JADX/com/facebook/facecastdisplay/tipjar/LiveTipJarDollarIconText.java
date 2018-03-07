package com.facebook.facecastdisplay.tipjar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.currency.DefaultCurrencyConfig;
import com.facebook.widget.text.BetterTextView;

/* compiled from: asset_id */
public class LiveTipJarDollarIconText extends BetterTextView {
    private int f19090a;
    private String f19091b;
    private final Paint f19092c;
    private final Paint f19093d;

    public LiveTipJarDollarIconText(Context context) {
        this(context, null);
    }

    public LiveTipJarDollarIconText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveTipJarDollarIconText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19092c = new Paint();
        this.f19093d = new Paint();
        m22649b();
    }

    private void m22649b() {
        setIncludeFontPadding(false);
        setGravity(getGravity() | 48);
        setWillNotDraw(false);
        setCompoundDrawablePadding((int) getResources().getDimension(2131428250));
        this.f19092c.setStyle(Style.FILL);
        this.f19093d.setColor(getResources().getColor(17170443));
        this.f19093d.setStyle(Style.FILL);
        this.f19093d.setTextAlign(Align.CENTER);
        m22650c();
    }

    public int getCompoundPaddingRight() {
        return getCompoundPaddingLeft();
    }

    public int getCompoundPaddingLeft() {
        return getCompoundDrawablePadding() + (((int) getTextSize()) / 3);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1769706693);
        this.f19090a = i2 - ((int) getTextSize());
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1077465836, a);
    }

    private void m22650c() {
        setColor(getResources().getColor(2131361958));
    }

    private void setColor(@ColorRes int i) {
        this.f19092c.setColor(i);
        setTextColor(i);
        invalidate();
    }

    public final void m22651a(String str, String str2) {
        this.f19091b = DefaultCurrencyConfig.a(str);
        setText(str2);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float textSize = getTextSize();
        float f = 0.17f * textSize;
        this.f19093d.setTextSize(textSize * 0.25f);
        canvas.drawCircle(f, ((float) this.f19090a) + f, f, this.f19092c);
        canvas.drawText(this.f19091b, f, ((float) this.f19090a) + (1.5f * f), this.f19093d);
    }
}
