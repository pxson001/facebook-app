package com.facebook.attachments.angora;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Inject;

/* compiled from: debug_pct */
public class InstantArticleIconView extends FbDraweeView {
    @Inject
    public FbZeroFeatureVisibilityHelper f14168c;
    private final Rect f14169d;
    private final Drawable f14170e;
    private final Rect f14171f;
    private Matrix f14172g;

    private static <T extends View> void m14978a(Class<T> cls, T t) {
        m14979a((Object) t, t.getContext());
    }

    private static void m14979a(Object obj, Context context) {
        ((InstantArticleIconView) obj).f14168c = FbZeroFeatureVisibilityHelper.a(FbInjector.get(context));
    }

    public InstantArticleIconView(Context context) {
        this(context, null);
    }

    public InstantArticleIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InstantArticleIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14978a(InstantArticleIconView.class, (View) this);
        this.f14169d = new Rect();
        if (this.f14168c.a(ZeroFeatureKey.EXTERNAL_URLS_INTERSTITIAL)) {
            setVisibility(8);
        }
        this.f14170e = getResources().getDrawable(2130840803);
        this.f14171f = new Rect();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f14169d.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        m14980c();
    }

    private void m14980c() {
        GravityCompat.m4735a(53, this.f14170e.getIntrinsicWidth(), this.f14170e.getIntrinsicHeight(), this.f14169d, 0, 0, this.f14171f, ViewCompat.h(this));
        this.f14170e.setBounds(this.f14171f);
        m14981d();
    }

    private void m14981d() {
        int width = this.f14169d.width();
        int height = this.f14169d.height();
        float intrinsicWidth = (((float) width) / ((float) this.f14170e.getIntrinsicWidth())) * 0.9f;
        float intrinsicHeight = (((float) height) / ((float) this.f14170e.getIntrinsicHeight())) * 0.9f;
        this.f14172g = new Matrix();
        this.f14172g.postScale(intrinsicWidth, intrinsicHeight);
        this.f14172g.postTranslate(((float) width) / 2.0f, 0.0f);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int saveCount = canvas.getSaveCount();
        if (this.f14172g != null) {
            canvas.concat(this.f14172g);
        }
        this.f14170e.draw(canvas);
        canvas.restoreToCount(saveCount);
    }
}
