package com.facebook.widget.listview;

import android.content.pm.ApplicationInfo;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.Adapter;

/* compiled from: events */
public class StickyHeader {
    public final BetterListView f12735a;
    private final Paint f12736b = new Paint();
    public StickyHeaderAdapter f12737c;
    public boolean f12738d;
    public View f12739e;
    private int f12740f = -1;

    /* compiled from: events */
    public interface StickyHeaderAdapter extends Adapter {
        View m13540b(int i, View view, ViewGroup viewGroup);

        int m13541d();

        int m13542e(int i);

        boolean m13543f(int i);

        int o_(int i);
    }

    public StickyHeader(BetterListView betterListView, StickyHeaderAdapter stickyHeaderAdapter) {
        this.f12735a = betterListView;
        this.f12737c = stickyHeaderAdapter;
    }

    protected final void m13553a(Canvas canvas) {
        if (this.f12737c != null) {
            int firstVisiblePosition = this.f12735a.getFirstVisiblePosition();
            if (firstVisiblePosition >= 0 && firstVisiblePosition < this.f12737c.getCount()) {
                int o_ = this.f12737c.o_(firstVisiblePosition);
                View view = null;
                if (this.f12740f == o_) {
                    view = this.f12739e;
                } else {
                    this.f12740f = o_;
                }
                this.f12739e = this.f12737c.m13540b(firstVisiblePosition, view, this.f12735a);
                if (this.f12739e != null) {
                    ApplicationInfo applicationInfo = this.f12735a.getContext().getApplicationInfo();
                    if (!(VERSION.SDK_INT < 17 || (applicationInfo.flags & 4194304) == 0 || this.f12739e.getLayoutDirection() == this.f12735a.getLayoutDirection())) {
                        this.f12739e.setLayoutDirection(this.f12735a.getLayoutDirection());
                    }
                    int save = canvas.save();
                    int width = (this.f12735a.getWidth() - this.f12735a.getPaddingLeft()) - this.f12735a.getPaddingRight();
                    o_ = this.f12737c.m13542e(firstVisiblePosition);
                    this.f12739e.measure(MeasureSpec.makeMeasureSpec(width, 1073741824), MeasureSpec.makeMeasureSpec(o_, 1073741824));
                    this.f12739e.layout(this.f12735a.getPaddingLeft(), this.f12735a.getPaddingTop(), width, o_);
                    if (this.f12735a.getChildCount() == 0) {
                        canvas.restoreToCount(save);
                        return;
                    }
                    int a = m13552a(firstVisiblePosition, o_);
                    if (a == -1 || a >= this.f12737c.getCount()) {
                        canvas.restoreToCount(save);
                        return;
                    }
                    float f;
                    width = 0;
                    if (a < 0 || !this.f12737c.m13543f(a)) {
                        f = 1.0f;
                    } else {
                        view = this.f12735a.getChildAt(a - firstVisiblePosition);
                        if (view == null) {
                            canvas.restoreToCount(save);
                            return;
                        }
                        firstVisiblePosition = (int) view.getY();
                        width = firstVisiblePosition - o_;
                        float f2 = ((float) firstVisiblePosition) / ((float) o_);
                        f = ((float) Math.round((f2 * f2) * 10.0f)) / 10.0f;
                    }
                    canvas.translate((float) this.f12735a.getPaddingLeft(), (float) width);
                    this.f12736b.reset();
                    this.f12736b.setColor(this.f12737c.m13541d());
                    this.f12736b.setStyle(Style.FILL);
                    canvas.drawRect(0.0f, 0.0f, (float) this.f12735a.getWidth(), (float) this.f12739e.getHeight(), this.f12736b);
                    if (f != 1.0f || VERSION.SDK_INT < 11) {
                        RectF rectF = new RectF();
                        rectF.set(0.0f, 0.0f, (float) this.f12739e.getWidth(), (float) this.f12739e.getHeight());
                        canvas.saveLayerAlpha(rectF, (int) (255.0f * f), 31);
                    }
                    this.f12739e.draw(canvas);
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    private int m13552a(int i, int i2) {
        int i3 = 0;
        View childAt = this.f12735a.getChildAt(0);
        if (childAt == null) {
            return -1;
        }
        int y = ((int) childAt.getY()) + this.f12735a.getPaddingTop();
        int childCount = this.f12735a.getChildCount();
        while (i3 < childCount) {
            y += this.f12735a.getChildAt(i3).getHeight();
            if (y >= i2) {
                return i + i3;
            }
            i3++;
        }
        return -1;
    }
}
