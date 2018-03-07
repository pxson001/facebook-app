package com.facebook.redspace.pagerindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: PageNuxExposures */
public class BadgableDraweeView extends CustomFrameLayout {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ArgbEvaluatorCompat> f12120a;
    private FbDraweeView f12121b;
    private CallerContext f12122c;
    private GradientDrawable f12123d;
    private int f12124e;
    @ColorInt
    private int f12125f;
    @ColorInt
    private int f12126g;
    private Uri f12127h;
    private Paint f12128i;
    private Rect f12129j;

    private static <T extends View> void m12572a(Class<T> cls, T t) {
        m12573a((Object) t, t.getContext());
    }

    private static void m12573a(Object obj, Context context) {
        ((BadgableDraweeView) obj).f12120a = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 10204);
    }

    public BadgableDraweeView(Context context) {
        this(context, null);
    }

    public BadgableDraweeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12120a = UltralightRuntime.b;
        m12570a();
    }

    private void m12570a() {
        m12572a(BadgableDraweeView.class, (View) this);
        setContentView(2130907736);
        this.f12122c = CallerContext.a(getContext());
        this.f12121b = (FbDraweeView) c(2131568439);
        this.f12123d = (GradientDrawable) getResources().getDrawable(2130837771);
        this.f12125f = getResources().getColor(2131363113);
        this.f12126g = getResources().getColor(2131363114);
        this.f12129j = new Rect();
        this.f12128i = new Paint();
        this.f12128i.setAntiAlias(true);
        this.f12128i.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
        this.f12128i.setColor(this.f12125f);
    }

    public void setImageURI(Uri uri) {
        this.f12127h = uri;
        this.f12121b.a(uri, this.f12122c);
    }

    public Uri getImageURI() {
        return this.f12127h;
    }

    public int getBadgeCount() {
        return this.f12124e;
    }

    public void setBadgeCount(int i) {
        this.f12124e = i;
        invalidate();
    }

    public void setDimValue(float f) {
        int intValue = ((Integer) ((ArgbEvaluatorCompat) this.f12120a.get()).evaluate(f, Integer.valueOf(this.f12126g), Integer.valueOf(this.f12125f))).intValue();
        if (VERSION.SDK_INT <= 16) {
            this.f12121b.setColorFilter(intValue, Mode.SRC_ATOP);
        } else {
            this.f12128i.setColor(intValue);
        }
        invalidate();
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (VERSION.SDK_INT > 16) {
            this.f12121b.getHitRect(this.f12129j);
            canvas.drawCircle((float) this.f12129j.centerX(), (float) this.f12129j.centerY(), ((float) this.f12129j.width()) / 2.0f, this.f12128i);
        }
        if (this.f12124e > 0) {
            this.f12123d.setBounds(this.f12121b.getRight() - this.f12123d.getIntrinsicWidth(), 0, this.f12121b.getRight(), this.f12123d.getIntrinsicHeight());
            this.f12123d.draw(canvas);
        }
    }

    private void m12571a(com.facebook.inject.Lazy<ArgbEvaluatorCompat> lazy) {
        this.f12120a = lazy;
    }
}
