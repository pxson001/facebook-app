package com.facebook.photos.warning;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.common.fblinks.FBLinks;

/* compiled from: select_existing_place */
public class ObjectionableContentController$1 extends ClickableSpan {
    final /* synthetic */ Context f3512a;
    final /* synthetic */ ObjectionableContentController f3513b;

    public ObjectionableContentController$1(ObjectionableContentController objectionableContentController, Context context) {
        this.f3513b = objectionableContentController;
        this.f3512a = context;
    }

    public void onClick(View view) {
        this.f3513b.d.a(this.f3513b.f.a(this.f3512a, FBLinks.cr.concat("/feed/panel/advanced_prep/")), this.f3512a);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        textPaint.setColor(ContextCompat.b(this.f3512a, 2131361920));
        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
    }
}
