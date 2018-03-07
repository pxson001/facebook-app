package com.facebook.drawee.fbpipeline;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.callercontext.FbDraweeCallerContext;
import com.facebook.drawee.drawable.ForwardingDrawable;

/* compiled from: [- ] */
public class InstrumentedDrawable extends ForwardingDrawable {
    private final AnalyticsLogger f11973a;
    private final FbDraweeCallerContext f11974c;
    private boolean f11975d = false;

    public InstrumentedDrawable(Drawable drawable, AnalyticsLogger analyticsLogger, FbDraweeCallerContext fbDraweeCallerContext) {
        super((Drawable) Preconditions.a(drawable));
        this.f11973a = analyticsLogger;
        this.f11974c = fbDraweeCallerContext;
    }

    public void draw(Canvas canvas) {
        if (!this.f11975d) {
            this.f11975d = true;
            CallerContext callerContext = this.f11974c.b;
            RectF rectF = new RectF();
            a(rectF);
            int width = (int) rectF.width();
            int height = (int) rectF.height();
            b(rectF);
            int width2 = (int) rectF.width();
            int height2 = (int) rectF.height();
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            HoneyClientEventFast a = this.f11973a.a("android_instrumented_drawable", false);
            if (a.a()) {
                a.a("view_width", width);
                a.a("view_height", height);
                a.a("scaled_width", width2);
                a.a("scaled_height", height2);
                a.a("image_width", intrinsicWidth);
                a.a("image_height", intrinsicHeight);
                a.a("calling_class", callerContext.b);
                a.a("analytics_tag", callerContext.c());
                a.a("module_tag", callerContext.d());
                a.a("feature_tag", callerContext.b());
                a.b();
            }
        }
        super.draw(canvas);
    }
}
