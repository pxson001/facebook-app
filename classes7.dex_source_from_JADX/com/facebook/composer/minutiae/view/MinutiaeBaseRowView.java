package com.facebook.composer.minutiae.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: textStyle */
public abstract class MinutiaeBaseRowView extends ImageBlockLayout {
    public TextView f1861h = ((TextView) getView(2131560564));
    public Optional<TextView> f1862i = getOptionalView(2131560577);
    public DraweeView f1863j = ((DraweeView) getView(2131560578));
    public Drawable f1864k;
    public Drawable f1865l;
    public Provider<FbDraweeControllerBuilder> f1866m;
    public int f1867n;
    public int f1868o;
    public int f1869p;
    public int f1870q;
    public Drawable f1871r;
    private Uri f1872s;

    public static void m1836a(Object obj, Context context) {
        ((MinutiaeBaseRowView) obj).f1866m = IdBasedProvider.a(FbInjector.get(context), 1117);
    }

    public abstract int getLayoutResourceId();

    public MinutiaeBaseRowView(Context context) {
        super(context);
        setContentView(getLayoutResourceId());
        Class cls = MinutiaeBaseRowView.class;
        m1836a((Object) this, getContext());
        Resources resources = getResources();
        this.f1867n = resources.getDimensionPixelSize(2131429623);
        this.f1868o = resources.getDimensionPixelSize(2131429624);
        this.f1869p = resources.getDimensionPixelSize(2131429625);
        this.f1870q = resources.getDimensionPixelSize(2131429626);
        this.f1871r = resources.getDrawable(2130841248);
        this.f1864k = resources.getDrawable(2130842624);
        this.f1865l = resources.getDrawable(2130842624);
        this.f1864k.setBounds(new Rect(0, 0, this.f1867n, this.f1867n));
        this.f1865l.setBounds(new Rect(0, 0, this.f1868o, this.f1868o));
        setGravity(16);
        setThumbnailSize(this.f1867n);
        setMinimumHeight(this.f1867n);
        m1839a();
    }

    public final void m1839a() {
        this.f1861h.setVisibility(8);
        if (this.f1862i.isPresent()) {
            ((TextView) this.f1862i.get()).setVisibility(8);
        }
        this.f1863j.setVisibility(8);
        m1838a(false);
        setBackgroundResource(2130838244);
        setOnClickListener(null);
    }

    public final MinutiaeBaseRowView m1837a(@Nullable Uri uri) {
        this.f1872s = uri;
        m1834a(uri, this.f1864k, this.f1867n);
        return this;
    }

    public final MinutiaeBaseRowView m1840b(@Nullable Uri uri) {
        m1834a(uri, this.f1865l, this.f1868o);
        return this;
    }

    public final MinutiaeBaseRowView m1841c(@Nullable Uri uri) {
        if (this.f1872s == null) {
            m1834a(uri, this.f1865l, this.f1868o);
        } else {
            Drawable drawable = this.f1865l;
            int i = this.f1868o;
            if (uri != null) {
                int i2 = (this.f1867n - i) / 2;
                this.f1863j.setPadding(i2, i2, i2, i2);
                GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
                genericDraweeHierarchyBuilder.f = drawable;
                this.f1863j.setHierarchy(genericDraweeHierarchyBuilder.u());
                this.f1863j.setController(((FbDraweeControllerBuilder) this.f1866m.get()).a(getCallerContext()).b(uri).s());
                this.f1863j.setVisibility(0);
            }
        }
        return this;
    }

    public final MinutiaeBaseRowView m1838a(boolean z) {
        this.f1861h.setCompoundDrawablesWithIntrinsicBounds(null, null, z ? getResources().getDrawable(2130843879) : null, null);
        return this;
    }

    public static void m1835a(TextView textView, @Nullable String str) {
        if (StringUtil.a(str)) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(str);
        textView.setVisibility(0);
    }

    private void m1834a(@Nullable Uri uri, Drawable drawable, int i) {
        if (uri != null) {
            int i2 = (this.f1867n - i) / 2;
            setPadding(i2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            setThumbnailPadding(Math.max(i2, this.f1870q));
            setThumbnailSize(i);
            setThumbnailUri(uri);
            setThumbnailGravity(16);
            setThumbnailPlaceholderDrawable(drawable);
        }
    }

    protected String getAnalyticsTag() {
        return "composer";
    }
}
