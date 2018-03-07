package com.facebook.messaging.payment.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.currency.DefaultCurrencyConfig;
import com.facebook.resources.ui.FbEditText;

/* compiled from: fail to load greeting item */
public class DollarIconEditText extends FbEditText {
    private int f15116b;
    private String f15117c = DefaultCurrencyConfig.a("USD");
    private final Paint f15118d = new Paint();
    private final Paint f15119e = new Paint();

    public DollarIconEditText(Context context) {
        super(context);
        m15480c();
    }

    public DollarIconEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15480c();
    }

    public DollarIconEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15480c();
    }

    private void m15480c() {
        setIncludeFontPadding(false);
        setGravity(getGravity() | 48);
        setWillNotDraw(false);
        setCompoundDrawablePadding((int) getResources().getDimension(2131433410));
        this.f15118d.setStyle(Style.FILL);
        this.f15119e.setColor(getResources().getColor(17170443));
        this.f15119e.setStyle(Style.FILL);
        this.f15119e.setTextAlign(Align.CENTER);
        m15483b();
    }

    public int getCompoundPaddingRight() {
        return getCompoundPaddingLeft();
    }

    public int getCompoundPaddingLeft() {
        return getCompoundDrawablePadding() + (((int) getTextSize()) / 3);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 55898738);
        this.f15116b = i2 - ((int) getTextSize());
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -315679389, a);
    }

    public final void m15481a() {
        setColor(getResources().getColor(2131363752));
    }

    public final void m15483b() {
        setColor(getResources().getColor(2131363623));
    }

    public void setColor(@ColorRes int i) {
        this.f15118d.setColor(i);
        setTextColor(i);
        invalidate();
    }

    public final void m15482a(String str, String str2) {
        this.f15117c = DefaultCurrencyConfig.a(str);
        setText(str2);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float textSize = getTextSize();
        float f = 0.17f * textSize;
        this.f15119e.setTextSize(textSize * 0.25f);
        canvas.drawCircle(f, ((float) this.f15116b) + f, f, this.f15118d);
        canvas.drawText(this.f15117c, f, ((float) this.f15116b) + (1.5f * f), this.f15119e);
    }

    public void onSelectionChanged(int i, int i2) {
        setSelection(getText().length());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!isEnabled()) {
            accessibilityNodeInfo.setText(this.f15117c + getText());
        }
    }
}
