package com.facebook.productionprompts.common.v3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: request_photos */
public class OverlappingImageView extends View {
    private static final DrawFilter f4514a = new PaintFlagsDrawFilter(0, 7);
    private final MultiDraweeHolder<GenericDraweeHierarchy> f4515b;
    private ImageHolder f4516c;
    private ImageHolder f4517d;
    private int f4518e;
    private double f4519f;
    private double f4520g;
    private Paint f4521h;

    public OverlappingImageView(Context context) {
        this(context, null);
    }

    public OverlappingImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlappingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4515b = new MultiDraweeHolder();
    }

    public final void m4376a(int i, int i2) {
        this.f4521h = new Paint(3);
        this.f4521h.setStyle(Style.STROKE);
        this.f4521h.setColor(i);
        this.f4521h.setStrokeWidth((float) i2);
    }

    public void setRotateDegree(int i) {
        this.f4518e = i;
        double toRadians = Math.toRadians((double) this.f4518e);
        this.f4519f = Math.cos(toRadians);
        this.f4520g = Math.sin(toRadians);
        invalidate();
    }

    public final void m4377a(ImageHolder imageHolder, ImageHolder imageHolder2) {
        this.f4516c = imageHolder;
        this.f4517d = imageHolder2;
        this.f4515b.c();
        m4374a(imageHolder);
        m4374a(imageHolder2);
        invalidate();
    }

    private void m4374a(ImageHolder imageHolder) {
        if (imageHolder != null) {
            ImmutableList a = imageHolder.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                DraweeHolder draweeHolder = (DraweeHolder) a.get(i);
                this.f4515b.a(draweeHolder);
                draweeHolder.h().setCallback(this);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        setMeasuredDimension((int) ((((double) measuredWidth) * this.f4519f) + (((double) measuredHeight) * this.f4520g)), (int) ((((double) measuredHeight) * this.f4519f) + (((double) measuredWidth) * this.f4520g)));
    }

    protected void onDraw(Canvas canvas) {
        int i = getLayoutParams().width;
        int i2 = getLayoutParams().height;
        canvas.setDrawFilter(f4514a);
        m4375a(this.f4516c, canvas, this.f4518e, (float) (((double) i2) * this.f4520g), 0.0f, i, i2);
        m4375a(this.f4517d, canvas, -this.f4518e, 0.0f, (float) (((double) i) * this.f4520g), i, i2);
    }

    private void m4375a(@Nullable ImageHolder imageHolder, Canvas canvas, int i, float f, float f2, int i2, int i3) {
        canvas.save();
        canvas.rotate((float) i);
        canvas.translate(f, f2);
        if (imageHolder != null) {
            imageHolder.a(canvas, getLayoutParams().width, getLayoutParams().height);
        }
        if (this.f4521h != null) {
            canvas.drawRect(0.0f, 0.0f, (float) i2, (float) i3, this.f4521h);
        }
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -764183321);
        boolean z = this.f4515b.a(motionEvent) || super.onTouchEvent(motionEvent);
        LogUtils.a(-913289390, a);
        return z;
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2077531045);
        super.onDetachedFromWindow();
        this.f4515b.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -11996254, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f4515b.b();
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 259355484);
        super.onAttachedToWindow();
        this.f4515b.a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1172861166, a);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f4515b.a();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return this.f4515b.a(drawable) || super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }
}
