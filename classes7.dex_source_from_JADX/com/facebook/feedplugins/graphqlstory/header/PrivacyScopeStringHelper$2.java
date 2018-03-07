package com.facebook.feedplugins.graphqlstory.header;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.feedplugins.graphqlstory.header.PrivacyScopeStringHelper.PrivacyString;

/* compiled from: renderToHardwareTextureAndroid */
class PrivacyScopeStringHelper$2 extends ClickableSpan {
    final /* synthetic */ PrivacyString f5272a;
    final /* synthetic */ TextPaint f5273b;
    final /* synthetic */ SpannableStringBuilder f5274c;
    final /* synthetic */ String f5275d;
    final /* synthetic */ PrivacyScopeStringHelper f5276e;

    PrivacyScopeStringHelper$2(PrivacyScopeStringHelper privacyScopeStringHelper, PrivacyString privacyString, TextPaint textPaint, SpannableStringBuilder spannableStringBuilder, String str) {
        this.f5276e = privacyScopeStringHelper;
        this.f5272a = privacyString;
        this.f5273b = textPaint;
        this.f5274c = spannableStringBuilder;
        this.f5275d = str;
    }

    public void onClick(View view) {
        int width = view.getWidth();
        float x = view.getX();
        String str = this.f5272a.a;
        TextPaint textPaint = this.f5273b;
        CharSequence charSequence = this.f5274c;
        PrivacyScopeStringHelper.a(this.f5276e, view, (int) (((float) PrivacyScopeStringHelper.b(width, x, str, textPaint)) + (Layout.getDesiredWidth(charSequence, textPaint) - Layout.getDesiredWidth(str, textPaint))), this.f5275d).d();
    }
}
