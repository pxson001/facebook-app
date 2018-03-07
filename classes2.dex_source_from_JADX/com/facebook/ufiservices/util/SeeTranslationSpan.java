package com.facebook.ufiservices.util;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.inject.ForAppContext;
import javax.inject.Inject;

/* compiled from: getSurfaceTexture */
public class SeeTranslationSpan extends ClickableSpan {
    private final Context f22504a;
    private final int f22505b = 2131361858;

    @Inject
    public SeeTranslationSpan(@ForAppContext Context context) {
        this.f22504a = context;
    }

    public void onClick(View view) {
        view.performClick();
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
        textPaint.setColor(this.f22504a.getResources().getColor(this.f22505b));
    }
}
