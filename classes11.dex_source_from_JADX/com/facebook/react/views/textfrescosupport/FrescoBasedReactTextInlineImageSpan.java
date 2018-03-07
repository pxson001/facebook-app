package com.facebook.react.views.textfrescosupport;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.TextView;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.views.text.TextInlineImageSpan;
import javax.annotation.Nullable;

/* compiled from: REQUESTED */
public class FrescoBasedReactTextInlineImageSpan extends TextInlineImageSpan {
    @Nullable
    private Drawable f11562a;
    private final AbstractDraweeControllerBuilder f11563b;
    private final DraweeHolder<GenericDraweeHierarchy> f11564c;
    @Nullable
    private final Object f11565d;
    private int f11566e;
    private Uri f11567f;
    private int f11568g;
    @Nullable
    private TextView f11569h;

    public FrescoBasedReactTextInlineImageSpan(Resources resources, int i, int i2, @Nullable Uri uri, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, @Nullable Object obj) {
        this.f11564c = new DraweeHolder(GenericDraweeHierarchyBuilder.a(resources).u());
        this.f11563b = abstractDraweeControllerBuilder;
        this.f11565d = obj;
        this.f11566e = i;
        this.f11568g = i2;
        if (uri == null) {
            uri = Uri.EMPTY;
        }
        this.f11567f = uri;
    }

    public final void mo319b() {
        this.f11564c.d();
    }

    public final void mo320c() {
        this.f11564c.d();
    }

    public final void mo321d() {
        this.f11564c.b();
    }

    public final void mo322e() {
        this.f11564c.b();
    }

    @Nullable
    public final Drawable mo317a() {
        return this.f11562a;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = -this.f11566e;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return this.f11568g;
    }

    public final void mo318a(TextView textView) {
        this.f11569h = textView;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (this.f11562a == null) {
            this.f11564c.a(this.f11563b.b().b(this.f11564c.f).b(this.f11565d).c(ImageRequestBuilder.a(this.f11567f).m()).i());
            this.f11562a = this.f11564c.h();
            this.f11562a.setBounds(0, 0, this.f11568g, this.f11566e);
            this.f11562a.setCallback(this.f11569h);
        }
        canvas.save();
        canvas.translate(f, (float) ((i5 - this.f11562a.getBounds().bottom) - paint.getFontMetricsInt().descent));
        this.f11562a.draw(canvas);
        canvas.restore();
    }
}
