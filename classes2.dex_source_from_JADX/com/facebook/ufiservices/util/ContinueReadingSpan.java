package com.facebook.ufiservices.util;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.Assisted;
import com.facebook.inject.ForAppContext;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: getSubscriberInfo */
public class ContinueReadingSpan extends ClickableSpan {
    private final Context f22506a;
    public int f22507b = 2131361858;
    private final OnClickListener f22508c;

    @Inject
    public ContinueReadingSpan(@ForAppContext Context context, @Nullable @Assisted OnClickListener onClickListener) {
        this.f22506a = context;
        this.f22508c = onClickListener;
    }

    public void onClick(View view) {
        this.f22508c.onClick(view);
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
        textPaint.setColor(this.f22506a.getResources().getColor(this.f22507b));
    }
}
