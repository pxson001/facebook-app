package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.common.util.SizeUtil;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.goodwill.ui.PolaroidDrawable;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: graphsearch_ */
public class DualPhotoView extends View {
    public DualPhotoViewConfig f12205a;
    private PolaroidDrawable f12206b;
    private PolaroidDrawable f12207c;
    private MultiDraweeHolder f12208d;
    private int f12209e;
    private int f12210f;
    private int f12211g;
    private int f12212h;
    private int f12213i;
    private int f12214j;
    private int f12215k;

    public DualPhotoView(Context context) {
        super(context);
        m14193a(context);
    }

    public DualPhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14193a(context);
    }

    public DualPhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14193a(context);
    }

    private void m14193a(Context context) {
        this.f12205a = new DualPhotoViewConfig();
        Resources resources = context.getResources();
        int a = SizeUtil.a(context, (float) this.f12205a.f12218c);
        int a2 = SizeUtil.a(context, (float) this.f12205a.f12219d);
        int a3 = SizeUtil.a(context, (float) this.f12205a.f12221f);
        this.f12206b = new PolaroidDrawable(resources, a2, a3, a);
        this.f12207c = new PolaroidDrawable(resources, a2, a3, a);
        setDualPhotoViewConfig(this.f12205a);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = new ColorDrawable(resources.getColor(2131363698));
        genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder;
        genericDraweeHierarchyBuilder.h = resources.getDrawable(2130840253);
        GenericDraweeHierarchy u = genericDraweeHierarchyBuilder.u();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder2.f = new ColorDrawable(resources.getColor(2131363698));
        genericDraweeHierarchyBuilder2 = genericDraweeHierarchyBuilder2;
        genericDraweeHierarchyBuilder2.h = resources.getDrawable(2130840253);
        GenericDraweeHierarchy u2 = genericDraweeHierarchyBuilder2.u();
        this.f12208d = new MultiDraweeHolder();
        this.f12208d.a(new DraweeHolder(u));
        this.f12208d.a(new DraweeHolder(u2));
    }

    public void setDualPhotoViewConfig(DualPhotoViewConfig dualPhotoViewConfig) {
        this.f12205a = dualPhotoViewConfig;
        this.f12209e = SizeUtil.a(getContext(), (float) this.f12205a.f12224i);
        this.f12210f = SizeUtil.a(getContext(), (float) this.f12205a.f12222g);
        this.f12211g = SizeUtil.a(getContext(), (float) this.f12205a.f12223h);
        this.f12212h = SizeUtil.a(getContext(), (float) this.f12205a.f12218c);
        this.f12213i = SizeUtil.a(getContext(), (float) this.f12205a.f12221f);
        this.f12214j = SizeUtil.a(getContext(), (float) this.f12205a.f12220e);
        this.f12215k = SizeUtil.a(getContext(), (float) this.f12205a.f12219d);
        this.f12206b.m15465c(this.f12212h);
        this.f12207c.m15465c(this.f12212h);
        this.f12206b.m15464b(this.f12213i);
        this.f12207c.m15464b(this.f12213i);
        this.f12206b.m15461a(this.f12215k);
        this.f12207c.m15461a(this.f12215k);
        this.f12206b.m15460a(this.f12205a.f12216a);
        this.f12207c.m15460a(this.f12205a.f12217b);
        requestLayout();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.f12206b.draw(canvas);
        this.f12207c.draw(canvas);
    }

    public void setPolaroidLeft(DraweeController draweeController) {
        m14194a(this.f12206b, this.f12208d.b(0), draweeController);
    }

    public void setPolaroidRight(DraweeController draweeController) {
        m14194a(this.f12207c, this.f12208d.b(1), draweeController);
    }

    private void m14194a(PolaroidDrawable polaroidDrawable, DraweeHolder draweeHolder, DraweeController draweeController) {
        draweeHolder.a(draweeController);
        draweeHolder.h().setCallback(this);
        polaroidDrawable.m15463a(draweeHolder.h());
        postInvalidate();
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        this.f12206b.m15462a((((size / 2) - (this.f12209e / 2)) - this.f12212h) - (this.f12215k * 2), this.f12210f);
        this.f12207c.m15462a((size / 2) + (this.f12209e / 2), this.f12210f);
        setMeasuredDimension(getMeasuredWidth(), (((this.f12211g + this.f12210f) + this.f12212h) + this.f12213i) + this.f12214j);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -938929586);
        boolean z = this.f12208d.a(motionEvent) || super.onTouchEvent(motionEvent);
        LogUtils.a(1522554965, a);
        return z;
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1908433040);
        super.onDetachedFromWindow();
        this.f12208d.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1202800038, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f12208d.b();
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1768635046);
        super.onAttachedToWindow();
        this.f12208d.a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -878768922, a);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f12208d.a();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (this.f12208d.a(drawable) || drawable == this.f12206b || drawable == this.f12207c) {
            return true;
        }
        return false;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }
}
