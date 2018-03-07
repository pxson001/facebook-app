package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.view.DraweeHolder;
import javax.annotation.Nullable;

/* compiled from: messaging/ */
public class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {
    @VisibleForTesting
    @Nullable
    public Drawable f14274a = null;
    @Nullable
    private DraweeHolder f14275c;

    public RootDrawable(Drawable drawable) {
        super(drawable);
    }

    public int getIntrinsicWidth() {
        return -1;
    }

    public int getIntrinsicHeight() {
        return -1;
    }

    public final void mo2749a(@Nullable DraweeHolder draweeHolder) {
        this.f14275c = draweeHolder;
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.f14275c != null) {
            this.f14275c.m20520a(z);
        }
        return super.setVisible(z, z2);
    }

    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.f14275c != null) {
                this.f14275c.m20517a();
            }
            super.draw(canvas);
            if (this.f14274a != null) {
                this.f14274a.setBounds(getBounds());
                this.f14274a.draw(canvas);
            }
        }
    }
}
