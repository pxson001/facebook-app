package com.facebook.video.creativeediting.ui.fresco;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.creativeediting.trimmer.VideoStripController.VideoStripAdapter;
import java.util.LinkedList;

/* compiled from: doodle_undo_count */
public class DraweeStripView extends View {
    public VideoStripAdapter f15631a;
    public int f15632b;
    public int f15633c;
    private MultiDraweeHolder f15634d;
    public SparseArray<DraweeHolder> f15635e;
    public LinkedList<DraweeHolder<GenericDraweeHierarchy>> f15636f;
    public Rect f15637g;
    public Rect f15638h;
    public RoundingParams f15639i;
    public RoundingParams f15640j;

    public DraweeStripView(Context context) {
        super(context);
        m19590a(context);
    }

    public DraweeStripView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19590a(context);
    }

    public DraweeStripView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19590a(context);
    }

    private void m19590a(Context context) {
        this.f15634d = new MultiDraweeHolder();
        this.f15636f = new LinkedList();
        this.f15635e = new SparseArray();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131429606);
        this.f15639i = RoundingParams.b((float) dimensionPixelSize, 0.0f, 0.0f, (float) dimensionPixelSize);
        this.f15640j = RoundingParams.b(0.0f, (float) dimensionPixelSize, (float) dimensionPixelSize, 0.0f);
        for (dimensionPixelSize = 0; dimensionPixelSize < 20; dimensionPixelSize++) {
            DraweeHolder a = DraweeHolder.a(new GenericDraweeHierarchyBuilder(getResources()).u(), context);
            a.h().setCallback(this);
            this.f15636f.add(a);
            this.f15634d.a(a);
        }
        this.f15637g = new Rect();
        this.f15638h = new Rect();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = null;
        int i = 0;
        while (i < this.f15633c) {
            Drawable h = ((DraweeHolder) this.f15635e.valueAt(i)).h();
            this.f15631a.m19576a(this.f15635e.keyAt(i), this.f15638h);
            mo1203a(this.f15638h);
            if (drawable != null) {
                drawable.setBounds(this.f15638h.left, this.f15638h.top, this.f15638h.right, this.f15638h.bottom);
                drawable.draw(canvas);
            }
            h.setBounds(this.f15638h.left, this.f15638h.top, this.f15638h.right, this.f15638h.bottom);
            h.setAlpha(getAnimatedAlpha$134621());
            h.draw(canvas);
            i++;
            drawable = h;
        }
    }

    public void setScrollX(int i) {
        int i2;
        super.setScrollX(i);
        getDrawingRect(this.f15637g);
        for (i2 = this.f15633c - 1; i2 >= 0; i2--) {
            this.f15631a.m19576a(this.f15635e.keyAt(i2), this.f15638h);
            if (!Rect.intersects(this.f15637g, this.f15638h)) {
                DraweeHolder draweeHolder = (DraweeHolder) this.f15635e.valueAt(i2);
                draweeHolder.a(null);
                this.f15635e.removeAt(i2);
                this.f15636f.add(draweeHolder);
            }
        }
        for (i2 = 0; i2 < this.f15632b; i2++) {
            Object obj;
            if (this.f15635e.get(i2) != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                this.f15631a.m19576a(i2, this.f15638h);
                if (Rect.intersects(this.f15637g, this.f15638h)) {
                    draweeHolder = (DraweeHolder) this.f15636f.poll();
                    if (draweeHolder != null) {
                        draweeHolder.a(this.f15631a.m19575a(i2));
                        this.f15635e.put(i2, draweeHolder);
                        if (i2 == 0) {
                            ((GenericDraweeHierarchy) draweeHolder.f()).a(this.f15639i);
                        } else if (i2 == this.f15632b - 1) {
                            ((GenericDraweeHierarchy) draweeHolder.f()).a(this.f15640j);
                        } else {
                            ((GenericDraweeHierarchy) draweeHolder.f()).a(null);
                        }
                    }
                }
            }
        }
        this.f15633c = this.f15635e.size();
    }

    public final void m19592a(VideoStripAdapter videoStripAdapter, int i) {
        if (this.f15631a != videoStripAdapter) {
            for (int i2 = 0; i2 < this.f15633c; i2++) {
                DraweeHolder draweeHolder = (DraweeHolder) this.f15635e.valueAt(i2);
                draweeHolder.a(null);
                this.f15636f.add(draweeHolder);
            }
            this.f15635e.clear();
            this.f15633c = 0;
            this.f15631a = videoStripAdapter;
            this.f15632b = videoStripAdapter.f15604a.size();
            setScrollX(i);
        }
    }

    protected void mo1203a(Rect rect) {
    }

    protected int getAnimatedAlpha$134621() {
        return 255;
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1464716736);
        super.onDetachedFromWindow();
        this.f15634d.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1344055838, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f15634d.b();
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -92997889);
        super.onAttachedToWindow();
        this.f15634d.a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 584253715, a);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f15634d.a();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        super.verifyDrawable(drawable);
        return this.f15634d.a(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }
}
