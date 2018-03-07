package com.facebook.notifications.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: methods */
class DefaultNotificationsRenderer$1 extends ClickableSpan {
    final /* synthetic */ OnClickListener f8992a;
    final /* synthetic */ DefaultNotificationsRenderer f8993b;

    DefaultNotificationsRenderer$1(DefaultNotificationsRenderer defaultNotificationsRenderer, OnClickListener onClickListener) {
        this.f8993b = defaultNotificationsRenderer;
        this.f8992a = onClickListener;
    }

    public void onClick(View view) {
        this.f8992a.onClick(view);
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
    }
}
