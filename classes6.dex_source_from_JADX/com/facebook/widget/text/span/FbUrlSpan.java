package com.facebook.widget.text.span;

import android.text.TextPaint;
import android.text.style.URLSpan;

/* compiled from: com.google.android.gms.location.internal.IGoogleLocationManagerService */
public class FbUrlSpan extends URLSpan {
    public int f19892a = -16776961;
    public boolean f19893b = true;
    public boolean f19894c = true;

    public FbUrlSpan(String str) {
        super(str);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.f19892a);
        textPaint.setUnderlineText(this.f19893b);
        textPaint.setFakeBoldText(this.f19894c);
    }
}
