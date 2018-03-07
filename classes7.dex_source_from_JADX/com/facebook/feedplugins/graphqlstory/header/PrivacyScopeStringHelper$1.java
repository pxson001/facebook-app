package com.facebook.feedplugins.graphqlstory.header;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.feedplugins.graphqlstory.header.PrivacyScopeStringHelper.PrivacyString;

/* compiled from: renderToHardwareTextureAndroid */
class PrivacyScopeStringHelper$1 extends ClickableSpan {
    final /* synthetic */ PrivacyString f5268a;
    final /* synthetic */ TextPaint f5269b;
    final /* synthetic */ String f5270c;
    final /* synthetic */ PrivacyScopeStringHelper f5271d;

    PrivacyScopeStringHelper$1(PrivacyScopeStringHelper privacyScopeStringHelper, PrivacyString privacyString, TextPaint textPaint, String str) {
        this.f5271d = privacyScopeStringHelper;
        this.f5268a = privacyString;
        this.f5269b = textPaint;
        this.f5270c = str;
    }

    public void onClick(View view) {
        PrivacyScopeStringHelper.a(this.f5271d, view, PrivacyScopeStringHelper.b(view.getWidth(), view.getX(), this.f5268a.a, this.f5269b), this.f5270c).d();
    }
}
