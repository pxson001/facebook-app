package com.facebook.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

@Deprecated
/* compiled from: com.google.android.gms.clearcut.internal.IClearcutLoggerService */
public class RoundedFrameLayout extends CustomFrameLayout {
    public RoundedViewHelper f5760a;
    private final C05261 f5761b = new C05261(this);

    /* compiled from: com.google.android.gms.clearcut.internal.IClearcutLoggerService */
    public class C05261 {
        final /* synthetic */ RoundedFrameLayout f5759a;

        C05261(RoundedFrameLayout roundedFrameLayout) {
            this.f5759a = roundedFrameLayout;
        }

        public final void m10529a(Canvas canvas) {
            super.dispatchDraw(canvas);
        }
    }

    public RoundedFrameLayout(Context context) {
        super(context);
        m10530a(context, null, 0);
    }

    public RoundedFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10530a(context, attributeSet, 0);
    }

    public RoundedFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10530a(context, attributeSet, i);
    }

    private void m10530a(Context context, AttributeSet attributeSet, int i) {
        this.f5760a = new RoundedViewHelper(this, RoundedDrawParams.m10528a(context, attributeSet, i));
    }

    public void setColorFilter(ColorFilter colorFilter) {
        RoundedViewHelper roundedViewHelper = this.f5760a;
        if (colorFilter != roundedViewHelper.f5766e) {
            roundedViewHelper.f5766e = colorFilter;
            if (roundedViewHelper.f5765d != null) {
                roundedViewHelper.f5765d.m10523a(colorFilter);
                roundedViewHelper.f5762a.invalidate();
            }
        }
    }

    public void setOverlayColor(int i) {
        RoundedViewHelper roundedViewHelper = this.f5760a;
        if (i != roundedViewHelper.f5767f) {
            roundedViewHelper.f5767f = i;
            if (roundedViewHelper.f5765d != null) {
                roundedViewHelper.f5765d.m10520a(i);
                roundedViewHelper.f5762a.invalidate();
            }
        }
    }

    public void setOverlayAlpha(int i) {
        RoundedViewHelper roundedViewHelper = this.f5760a;
        if (i != roundedViewHelper.f5768g) {
            roundedViewHelper.f5768g = i;
            if (roundedViewHelper.f5765d != null) {
                roundedViewHelper.f5765d.m10524b(i);
                roundedViewHelper.f5762a.invalidate();
            }
        }
    }

    public void setRoundBorderColor(int i) {
        RoundedViewHelper roundedViewHelper = this.f5760a;
        if (i != roundedViewHelper.f5763b.f5751i) {
            roundedViewHelper.f5769h = i;
            if (roundedViewHelper.f5765d != null) {
                roundedViewHelper.f5765d.m10525c(i);
                roundedViewHelper.f5762a.invalidate();
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1689047082);
        super.onSizeChanged(i, i2, i3, i4);
        this.f5760a.m10532a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1031138360, a);
    }

    protected void dispatchDraw(Canvas canvas) {
        RoundedViewHelper roundedViewHelper = this.f5760a;
        roundedViewHelper.f5765d.m10522a(canvas, this.f5761b);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2070404617);
        super.onDetachedFromWindow();
        this.f5760a.m10533b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 211781750, a);
    }
}
