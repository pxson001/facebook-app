package com.facebook.attachments.angora;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.dialtone.common.IsDialtonePhotoFeatureEnabled;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: display_inversion */
public class CoverPhotoWithPlayIconView extends FbDraweeView {
    @Inject
    @IsDialtonePhotoFeatureEnabled
    public Provider<Boolean> f13752c;
    public boolean f13753d;
    private final Drawable f13754e;
    private final Rect f13755f;
    private final Rect f13756g;

    private static <T extends View> void m14483a(Class<T> cls, T t) {
        m14484a((Object) t, t.getContext());
    }

    private static void m14484a(Object obj, Context context) {
        ((CoverPhotoWithPlayIconView) obj).f13752c = IdBasedProvider.a(FbInjector.get(context), 3959);
    }

    private void m14485a(Provider<Boolean> provider) {
        this.f13752c = provider;
    }

    public CoverPhotoWithPlayIconView(Context context) {
        this(context, null);
    }

    public CoverPhotoWithPlayIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPhotoWithPlayIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14483a(CoverPhotoWithPlayIconView.class, (View) this);
        this.f13754e = getResources().getDrawable(2130842698);
        this.f13755f = new Rect();
        this.f13756g = new Rect();
        Resources resources = context.getResources();
        Drawable colorDrawable = new ColorDrawable(resources.getColor(2131362786));
        AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(resources.getDrawable(2130844043), 1000);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = colorDrawable;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = genericDraweeHierarchyBuilder;
        genericDraweeHierarchyBuilder2.l = autoRotateDrawable;
        setHierarchy(genericDraweeHierarchyBuilder2.u());
        setAspectRatio(1.9318181f);
    }

    protected final void m14487a(Context context, AttributeSet attributeSet) {
    }

    public void setAspectRatio(float f) {
        if (((Boolean) this.f13752c.get()).booleanValue()) {
            super.setAspectRatio(1.9318181f);
        } else {
            super.setAspectRatio(f);
        }
    }

    public void setIsPlayIconVisible(boolean z) {
        this.f13753d = z;
    }

    private boolean m14486c() {
        return this.f13753d;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f13755f.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        GravityCompat.m4736a(17, this.f13754e.getIntrinsicWidth(), this.f13754e.getIntrinsicHeight(), this.f13755f, this.f13756g, ViewCompat.h(this));
        this.f13754e.setBounds(this.f13756g);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f13753d) {
            this.f13754e.draw(canvas);
        }
    }
}
