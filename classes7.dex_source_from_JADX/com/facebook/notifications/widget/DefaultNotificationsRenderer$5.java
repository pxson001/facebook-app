package com.facebook.notifications.widget;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: methods */
class DefaultNotificationsRenderer$5 extends ClickableSpan {
    final /* synthetic */ DefaultNotificationsRenderer$3 f9013a;
    final /* synthetic */ Resources f9014b;
    final /* synthetic */ DefaultNotificationsRenderer f9015c;

    DefaultNotificationsRenderer$5(DefaultNotificationsRenderer defaultNotificationsRenderer, DefaultNotificationsRenderer$3 defaultNotificationsRenderer$3, Resources resources) {
        this.f9015c = defaultNotificationsRenderer;
        this.f9013a = defaultNotificationsRenderer$3;
        this.f9014b = resources;
    }

    public void onClick(View view) {
        this.f9013a.m10858a(view);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        textPaint.setFakeBoldText(true);
        textPaint.setColor(this.f9014b.getColor(2131361921));
    }
}
