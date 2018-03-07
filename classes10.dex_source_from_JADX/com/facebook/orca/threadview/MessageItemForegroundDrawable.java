package com.facebook.orca.threadview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.messaging.giftwrap.GiftWrapDrawable;
import com.facebook.messaging.giftwrap.GiftWrapSettings;
import com.facebook.widget.RoundedCornerOverlayDrawable;
import javax.annotation.Nullable;

/* compiled from: messenger_version */
public class MessageItemForegroundDrawable extends Drawable implements Callback {
    public final Resources f7058a;
    public final RoundedCornerOverlayDrawable f7059b;
    @Nullable
    public GiftWrapDrawable f7060c;
    private boolean f7061d = true;

    public MessageItemForegroundDrawable(Context context) {
        this.f7058a = context.getResources();
        this.f7059b = new RoundedCornerOverlayDrawable();
        this.f7059b.c(this.f7058a.getDimensionPixelSize(2131428585));
        this.f7059b.mutate();
        this.f7059b.a(ContextUtils.c(context, 2130773063, -1));
        this.f7059b.setCallback(this);
    }

    public final void m6629a(boolean z) {
        if (this.f7061d != z) {
            this.f7061d = z;
            invalidateSelf();
        }
    }

    public final void m6627a(int i) {
        this.f7059b.b(i);
    }

    public final void m6631b(int i) {
        RoundedCornerOverlayDrawable roundedCornerOverlayDrawable = this.f7059b;
        if (i != roundedCornerOverlayDrawable.d.getColor()) {
            roundedCornerOverlayDrawable.d.setColor(i);
            roundedCornerOverlayDrawable.invalidateSelf();
        }
    }

    public final boolean m6632b() {
        return this.f7060c != null;
    }

    public final void m6628a(@Nullable GiftWrapSettings giftWrapSettings) {
        boolean z = giftWrapSettings != null;
        if (z != m6632b()) {
            if (z) {
                this.f7060c = new GiftWrapDrawable(this.f7058a);
                this.f7060c.setBounds(getBounds());
                this.f7060c.setCallback(this);
            } else {
                this.f7060c = null;
            }
        }
        if (giftWrapSettings != null) {
            this.f7060c.b.setColor(giftWrapSettings.a);
            GiftWrapDrawable giftWrapDrawable = this.f7060c;
            String str = giftWrapSettings.b;
            if (!StringUtil.a(str, giftWrapDrawable.h)) {
                Bitmap bitmap;
                Bitmap bitmap2;
                giftWrapDrawable.h = str;
                if ("hearts".equals(str)) {
                    Drawable drawable = giftWrapDrawable.a.getDrawable(2130841321);
                    if (drawable instanceof BitmapDrawable) {
                        bitmap = ((BitmapDrawable) drawable).getBitmap();
                        bitmap2 = bitmap;
                        if (bitmap2 != null) {
                            giftWrapDrawable.i = null;
                            giftWrapDrawable.j = null;
                        } else {
                            if (giftWrapDrawable.i == null) {
                                giftWrapDrawable.i = new Paint();
                                giftWrapDrawable.i.setColorFilter(new PorterDuffColorFilter(giftWrapDrawable.k, Mode.SRC_ATOP));
                                giftWrapDrawable.j = new Matrix();
                            }
                            giftWrapDrawable.m = new BitmapShader(bitmap2, TileMode.REPEAT, TileMode.REPEAT);
                            giftWrapDrawable.i.setShader(giftWrapDrawable.m);
                            giftWrapDrawable.m.setLocalMatrix(giftWrapDrawable.j);
                        }
                    }
                }
                bitmap = null;
                bitmap2 = bitmap;
                if (bitmap2 != null) {
                    if (giftWrapDrawable.i == null) {
                        giftWrapDrawable.i = new Paint();
                        giftWrapDrawable.i.setColorFilter(new PorterDuffColorFilter(giftWrapDrawable.k, Mode.SRC_ATOP));
                        giftWrapDrawable.j = new Matrix();
                    }
                    giftWrapDrawable.m = new BitmapShader(bitmap2, TileMode.REPEAT, TileMode.REPEAT);
                    giftWrapDrawable.i.setShader(giftWrapDrawable.m);
                    giftWrapDrawable.m.setLocalMatrix(giftWrapDrawable.j);
                } else {
                    giftWrapDrawable.i = null;
                    giftWrapDrawable.j = null;
                }
            }
            giftWrapDrawable = this.f7060c;
            int i = giftWrapSettings.c;
            if (giftWrapDrawable.k != i) {
                giftWrapDrawable.k = i;
                if (giftWrapDrawable.i != null) {
                    giftWrapDrawable.i.setColorFilter(new PorterDuffColorFilter(i, Mode.SRC_ATOP));
                }
            }
            this.f7060c.c.setColorFilter(new PorterDuffColorFilter(giftWrapSettings.d, Mode.MULTIPLY));
        }
    }

    public final float m6633c() {
        return this.f7060c != null ? this.f7060c.l : 1.0f;
    }

    public final void m6630b(float f) {
        if (this.f7060c != null) {
            this.f7060c.a(f);
        }
    }

    protected void onBoundsChange(Rect rect) {
        this.f7059b.setBounds(rect);
        if (this.f7060c != null) {
            this.f7060c.setBounds(rect);
        }
    }

    public void draw(Canvas canvas) {
        if (this.f7060c != null) {
            this.f7060c.draw(canvas);
        }
        if (this.f7061d || m6633c() < 1.0f) {
            this.f7059b.draw(canvas);
        }
    }

    public void setAlpha(int i) {
        this.f7059b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (m6626a(drawable)) {
            getCallback().invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (m6626a(drawable)) {
            getCallback().scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (m6626a(drawable)) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    private boolean m6626a(Drawable drawable) {
        return (getCallback() == null || drawable == null || (drawable != this.f7059b && drawable != this.f7060c)) ? false : true;
    }
}
