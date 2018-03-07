package com.facebook.catalyst.shadow.flat;

import android.graphics.Canvas;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.catalyst.shadow.flat.FlatViewGroup.InvalidateCallback;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import javax.annotation.Nullable;

/* compiled from: mLoadedApk */
public final class DrawImageWithDrawee extends AbstractDrawCommand implements AttachDetachListener, DrawCommand, ControllerListener {
    @Nullable
    public DraweeRequestHelper f5639c;
    @Nullable
    public PorterDuffColorFilter f5640d;
    public ScaleType f5641e = ScaleType.g;
    public float f5642f;
    public float f5643g;
    public int f5644h;
    public int f5645i;
    public int f5646j = 300;
    @Nullable
    private InvalidateCallback f5647k;

    DrawImageWithDrawee() {
    }

    public final boolean nV_() {
        return this.f5639c != null;
    }

    public final void mo155c(Canvas canvas) {
        this.f5639c.m6968c().draw(canvas);
    }

    public final void mo157a(InvalidateCallback invalidateCallback) {
        Object obj;
        this.f5647k = invalidateCallback;
        GenericDraweeHierarchy b = this.f5639c.m6967b();
        RoundingParams roundingParams = b.c;
        if (this.f5644h != 0 || this.f5643g >= 0.5f) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            if (roundingParams == null) {
                roundingParams = new RoundingParams();
            }
            roundingParams.a(this.f5644h, this.f5642f);
            roundingParams.a(this.f5643g);
            b.a(roundingParams);
        } else if (roundingParams != null) {
            b.a(null);
        }
        b.a(this.f5641e);
        b.a(this.f5640d);
        b.a(this.f5646j);
        b.a().setBounds(Math.round(this.f5611c), Math.round(this.f5612d), Math.round(this.f5613e), Math.round(this.f5614f));
        DraweeRequestHelper draweeRequestHelper = this.f5639c;
        draweeRequestHelper.f5655d++;
        if (draweeRequestHelper.f5655d == 1) {
            draweeRequestHelper.m6968c().setCallback((Callback) invalidateCallback.get());
            draweeRequestHelper.f5654c.e();
        }
    }

    public final void nX_() {
        DraweeRequestHelper draweeRequestHelper = this.f5639c;
        draweeRequestHelper.f5655d--;
        if (draweeRequestHelper.f5655d == 0) {
            draweeRequestHelper.f5654c.f();
        }
    }

    public final void m6955a(String str, Object obj) {
        if (this.f5647k != null && this.f5645i != 0) {
            this.f5647k.m7068a(this.f5645i, 4);
        }
    }

    public final void m6956a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        if (this.f5647k != null && this.f5645i != 0) {
            this.f5647k.m7068a(this.f5645i, 2);
            this.f5647k.m7068a(this.f5645i, 3);
        }
    }

    public final void m6958b(String str, @Nullable Object obj) {
    }

    public final void m6957a(String str, Throwable th) {
    }

    public final void m6959b(String str, Throwable th) {
        if (this.f5647k != null && this.f5645i != 0) {
            this.f5647k.m7068a(this.f5645i, 1);
            this.f5647k.m7068a(this.f5645i, 3);
        }
    }

    public final void m6954a(String str) {
    }
}
