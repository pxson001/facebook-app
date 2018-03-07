package com.facebook.messaging.xma.hscroll;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.RoundedCornerOverlayDrawable;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: notification.ACTION_UPDATE */
public class HScrollAttachmentAdapter$ViewHolder extends CustomFrameLayout implements RecyclableView {
    private final int f6880a;
    public boolean f6881b;
    @Nullable
    private RoundedCornerOverlayDrawable f6882c;
    private float[] f6883d;
    private final Path f6884e = new Path();
    private final RectF f6885f = new RectF();

    public HScrollAttachmentAdapter$ViewHolder(Context context) {
        super(context);
        this.f6880a = context.getResources().getDimensionPixelOffset(2131428581);
        this.f6883d = new float[]{(float) this.f6880a, (float) this.f6880a, (float) this.f6880a, (float) this.f6880a, (float) this.f6880a, (float) this.f6880a, (float) this.f6880a, (float) this.f6880a};
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1125148218);
        super.onAttachedToWindow();
        this.f6881b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 523177927, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -680440185);
        super.onDetachedFromWindow();
        this.f6881b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1153806815, a);
    }

    public final boolean mo569a() {
        return this.f6881b;
    }

    protected void dispatchDraw(Canvas canvas) {
        this.f6884e.reset();
        this.f6885f.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        this.f6884e.addRoundRect(this.f6885f, this.f6883d, Direction.CCW);
        int save = canvas.save();
        canvas.clipPath(this.f6884e);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public final void m7214a(int i, int i2, int[] iArr) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.f6882c == null) {
            Resources resources = getContext().getResources();
            this.f6882c = new RoundedCornerOverlayDrawable();
            this.f6882c.c(resources.getDimensionPixelSize(2131428585));
            this.f6882c.b(resources.getColor(2131362331));
            this.f6882c.a(0);
            setForeground(this.f6882c);
        }
        Preconditions.checkNotNull(iArr);
        Preconditions.checkState(iArr.length == 4);
        if (i == 0) {
            i3 = iArr[0];
            i4 = this.f6880a;
            i5 = this.f6880a;
            i6 = iArr[3];
        } else if (i == i2 - 1) {
            i3 = this.f6880a;
            i4 = iArr[1];
            i5 = iArr[2];
            i6 = this.f6880a;
        } else {
            i3 = this.f6880a;
            i4 = this.f6880a;
            i5 = this.f6880a;
            i6 = this.f6880a;
        }
        this.f6882c.a((float) i3, (float) i4, (float) i5, (float) i6);
        this.f6883d = new float[]{(float) i3, (float) i3, (float) i4, (float) i4, (float) i5, (float) i5, (float) i6, (float) i6};
    }
}
