package com.facebook.widget.tiles;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.tiles.ThreadTileDrawable.DrawableShape;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: com.facebook.stickers.store.StickerStoreActivity */
public class ThreadTileView extends View {
    @Inject
    public ThreadTileDrawableController f19971a;
    private int f19972b;
    private boolean f19973c;

    private static <T extends View> void m28679a(Class<T> cls, T t) {
        m28680a((Object) t, t.getContext());
    }

    private static void m28680a(Object obj, Context context) {
        ((ThreadTileView) obj).f19971a = ThreadTileDrawableController.m28665b(FbInjector.get(context));
    }

    public ThreadTileView(Context context) {
        super(context);
        m28677a(null, 0);
    }

    public ThreadTileView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28677a(attributeSet, 0);
    }

    public ThreadTileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28677a(attributeSet, i);
    }

    private void m28677a(AttributeSet attributeSet, int i) {
        m28679a(ThreadTileView.class, (View) this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ThreadTileView);
        this.f19972b = obtainStyledAttributes.getInt(0, -1);
        obtainStyledAttributes.recycle();
        this.f19971a.m28674a(getContext(), attributeSet, i);
        this.f19971a.f19958m.setCallback(this);
    }

    private void m28678a(ThreadTileDrawableController threadTileDrawableController) {
        this.f19971a = threadTileDrawableController;
    }

    public void setThreadTileViewData(ThreadTileViewData threadTileViewData) {
        this.f19971a.m28675a(threadTileViewData);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 535262951);
        super.onAttachedToWindow();
        ThreadTileDrawableController threadTileDrawableController = this.f19971a;
        if (threadTileDrawableController.f19965t) {
            threadTileDrawableController.f19965t = false;
            threadTileDrawableController.f19952g.b();
            ThreadTileDrawableController.m28669g(threadTileDrawableController);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 360067833, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 818005512);
        ThreadTileDrawableController threadTileDrawableController = this.f19971a;
        if (!threadTileDrawableController.f19965t) {
            threadTileDrawableController.f19965t = true;
            ThreadTileDrawableController.m28668f(threadTileDrawableController);
            threadTileDrawableController.f19952g.c();
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1335390307, a);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f19971a.f19958m || super.verifyDrawable(drawable);
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f19971a.f19958m.jumpToCurrentState();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f19971a.f19958m.setState(getDrawableState());
    }

    protected void onMeasure(int i, int i2) {
        int i3 = this.f19971a.f19963r;
        setMeasuredDimension(View.resolveSize(i3, i), View.resolveSize(i3, i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f19973c = true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f19973c) {
            m28676a();
            this.f19973c = false;
        }
        this.f19971a.f19958m.draw(canvas);
    }

    public void setUseInbox2AlternateBadges(boolean z) {
        this.f19971a.f19961p.g = z;
        invalidate();
    }

    private void m28676a() {
        int i;
        int i2;
        int i3;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int i4 = this.f19971a.f19963r;
        switch (this.f19972b & 7) {
            case 1:
                width = (width - i4) / 2;
                i = width;
                i2 = width;
                break;
            case 5:
                i = 0;
                i2 = width - i4;
                break;
            default:
                i = width - i4;
                i2 = 0;
                break;
        }
        switch (this.f19972b & 112) {
            case 16:
                int i5 = (height - i4) / 2;
                i3 = i5;
                i4 = i5;
                break;
            case 80:
                i3 = 0;
                i4 = height - i4;
                break;
            default:
                i3 = height - i4;
                i4 = 0;
                break;
        }
        this.f19971a.m28673a(getWidth(), getHeight(), i2 + getPaddingLeft(), i4 + getPaddingTop(), i + getPaddingRight(), i3 + getPaddingBottom());
    }

    public void setAsFilledRoundRect(float f) {
        ThreadTileDrawable threadTileDrawable = this.f19971a.f19959n;
        Preconditions.checkState(threadTileDrawable.f19929j == 0);
        threadTileDrawable.f19922c = DrawableShape.FILLED_ROUND_RECT;
        threadTileDrawable.f19925f = f;
    }

    public void setTileSizePx(int i) {
        this.f19971a.m28672a(i);
    }
}
