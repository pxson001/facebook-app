package com.facebook.common.i18n;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

/* compiled from: spec_element */
class RTLUtil$1 extends BitmapDrawable {
    final /* synthetic */ Bitmap f2620a;
    final /* synthetic */ RTLUtil f2621b;

    RTLUtil$1(RTLUtil rTLUtil, Resources resources, Bitmap bitmap, Bitmap bitmap2) {
        this.f2621b = rTLUtil;
        this.f2620a = bitmap2;
        super(resources, bitmap);
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.scale(-1.0f, 1.0f, (float) (this.f2620a.getWidth() / 2), (float) (this.f2620a.getHeight() / 2));
        super.draw(canvas);
        canvas.restore();
    }
}
