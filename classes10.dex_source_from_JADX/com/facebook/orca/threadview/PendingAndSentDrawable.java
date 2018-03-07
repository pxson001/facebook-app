package com.facebook.orca.threadview;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.MathUtil;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: messages_sync_initial_fetch_error */
public class PendingAndSentDrawable extends LayerDrawable {
    private final Drawable f7344a;
    private final Drawable f7345b;
    private AbstractFbErrorReporter f7346c;

    @Inject
    public PendingAndSentDrawable(@Assisted Drawable drawable, @Assisted Drawable drawable2, AbstractFbErrorReporter abstractFbErrorReporter) {
        super(new Drawable[]{drawable, drawable2});
        this.f7344a = drawable;
        this.f7345b = drawable2;
        this.f7346c = abstractFbErrorReporter;
    }

    public final void m6980a(float f) {
        int i;
        if (f < 0.0f || f > 1.0f) {
            this.f7346c.a("PendingAndSentDrawable", StringFormatUtil.formatStrLocaleSafe("Progress percentage was not between 0 and 1. Actual value was: %f", Float.valueOf(f)));
        }
        Drawable mutate = this.f7344a.mutate();
        if (f < 1.0f) {
            i = 255;
        } else {
            i = 0;
        }
        mutate.setAlpha(i);
        this.f7345b.mutate().setAlpha(MathUtil.a(((int) f) * 255, 0, 255));
    }
}
