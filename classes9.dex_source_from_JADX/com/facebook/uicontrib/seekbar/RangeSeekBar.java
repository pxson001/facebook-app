package com.facebook.uicontrib.seekbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.facebook.common.util.MathUtil;
import com.facebook.fbui.draggable.AdvancedDragDetector;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragDecider;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragListener;
import com.facebook.fbui.draggable.AdvancedDragDetector.TapListener;
import com.facebook.fbui.draggable.Direction;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: timeline_logging */
public class RangeSeekBar extends FrameLayout implements DragDecider, DragListener, TapListener {
    private AdvancedDragDetector f1685a;
    private Paint f1686b;
    private Paint f1687c;
    private Paint f1688d;
    private Paint f1689e;
    private Paint f1690f;
    public int f1691g;
    private int f1692h;
    private int f1693i;
    private Thumb f1694j;
    public float f1695k;
    public float f1696l;
    private float f1697m;
    private float f1698n;
    private OnRangeSeekBarChangeListener f1699o;

    /* compiled from: timeline_logging */
    enum Thumb {
        START,
        END
    }

    public RangeSeekBar(Context context) {
        super(context);
    }

    public RangeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1710c();
    }

    public RangeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1710c();
    }

    private void m1710c() {
        this.f1685a = new AdvancedDragDetector(getContext());
        this.f1685a.a(new Direction[]{Direction.LEFT, Direction.RIGHT});
        this.f1685a.q = this;
        this.f1685a.r = this;
        this.f1685a.s = this;
        Resources resources = getContext().getResources();
        this.f1687c = new Paint();
        this.f1687c.setColor(resources.getColor(2131361917));
        this.f1687c.setAntiAlias(true);
        this.f1687c.setStrokeWidth((float) resources.getDimensionPixelSize(2131433126));
        this.f1686b = new Paint();
        this.f1686b.setColor(resources.getColor(2131361980));
        this.f1686b.setStrokeWidth((float) resources.getDimensionPixelSize(2131433126));
        this.f1688d = new Paint();
        this.f1688d.setColor(resources.getColor(2131361917));
        this.f1688d.setAlpha(127);
        this.f1688d.setAntiAlias(true);
        this.f1689e = new Paint();
        this.f1689e.setColor(resources.getColor(2131361920));
        this.f1689e.setAntiAlias(true);
        this.f1690f = new Paint();
        this.f1690f.setColor(resources.getColor(2131361917));
        this.f1690f.setAntiAlias(true);
        this.f1691g = resources.getDimensionPixelSize(2131433129);
        this.f1692h = resources.getDimensionPixelSize(2131433128);
        this.f1693i = resources.getDimensionPixelSize(2131433127);
        this.f1695k = Float.NaN;
        this.f1696l = Float.NaN;
    }

    public final void m1723e(float f, float f2) {
        Object obj = 1;
        if (f < f2) {
            this.f1697m = f;
            this.f1698n = f2;
            if (Float.isNaN(this.f1695k) && Float.isNaN(this.f1696l)) {
                this.f1695k = this.f1697m;
                this.f1696l = this.f1698n;
                m1712e();
            }
            Object obj2 = null;
            if (this.f1695k < this.f1697m) {
                this.f1695k = this.f1697m;
                obj2 = 1;
            }
            if (this.f1696l > this.f1698n) {
                this.f1696l = this.f1698n;
            } else {
                obj = obj2;
            }
            if (obj != null) {
                invalidate();
                m1712e();
            }
        }
    }

    public final void m1724f(float f, float f2) {
        if (f >= this.f1697m && f2 <= this.f1698n && f <= f2) {
            this.f1695k = f;
            this.f1696l = f2;
            invalidate();
            m1712e();
        }
    }

    public float getRangeStartValue() {
        return this.f1695k;
    }

    public float getRangeEndValue() {
        return this.f1696l;
    }

    public void setRangeSeekBarChangeListener(OnRangeSeekBarChangeListener onRangeSeekBarChangeListener) {
        this.f1699o = onRangeSeekBarChangeListener;
        m1712e();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -217762428);
        boolean b = this.f1685a.b(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -1351830492, a);
        return b;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1685a.a(motionEvent);
    }

    public final boolean m1716a(float f, float f2) {
        return m1709a(f2);
    }

    public final boolean m1720b(float f, float f2) {
        return true;
    }

    public final boolean m1717a(float f, float f2, Direction direction) {
        setCurrentThumb(f);
        return true;
    }

    private void setCurrentThumb(float f) {
        float abs = Math.abs(getEndThumbX() - f);
        float abs2 = Math.abs(getStartThumbX() - f);
        if (abs == abs2) {
            this.f1694j = getStartThumbX() < f ? Thumb.END : Thumb.START;
        } else {
            this.f1694j = abs < abs2 ? Thumb.END : Thumb.START;
        }
    }

    public final void m1719b(float f, float f2, Direction direction) {
        setCurrentPosition(getCurrentPosition() + f);
    }

    public final void m1714a() {
        this.f1694j = null;
        m1711d();
    }

    public final void m1715a(Direction direction, int i) {
        this.f1694j = null;
        m1711d();
    }

    public final void m1718b() {
    }

    public final boolean m1721c(float f, float f2) {
        return m1713g(f, f2);
    }

    public final void m1722d(float f, float f2) {
        m1713g(f, f2);
    }

    protected void dispatchDraw(Canvas canvas) {
        float centerY = (float) getCenterY();
        float startThumbX = getStartThumbX();
        float endThumbX = getEndThumbX();
        canvas.save();
        canvas.drawLine((float) this.f1691g, centerY, (float) getRightBound(), centerY, this.f1686b);
        canvas.drawCircle(startThumbX, centerY, (float) this.f1691g, this.f1688d);
        canvas.drawCircle(endThumbX, centerY, (float) this.f1691g, this.f1688d);
        canvas.drawLine(startThumbX, centerY, endThumbX, centerY, this.f1687c);
        canvas.drawCircle(startThumbX, centerY, (float) this.f1692h, this.f1689e);
        canvas.drawCircle(endThumbX, centerY, (float) this.f1692h, this.f1689e);
        canvas.drawCircle(startThumbX, centerY, (float) this.f1693i, this.f1690f);
        canvas.drawCircle(endThumbX, centerY, (float) this.f1693i, this.f1690f);
        canvas.restore();
    }

    private boolean m1713g(float f, float f2) {
        if (!m1709a(f2)) {
            return false;
        }
        setCurrentThumb(f);
        setCurrentPosition(f);
        this.f1694j = null;
        m1711d();
        return true;
    }

    private int getLeftBound() {
        return this.f1691g;
    }

    private int getRightBound() {
        return getWidth() - this.f1691g;
    }

    private int getCenterY() {
        return getMeasuredHeight() / 2;
    }

    private float getStartThumbX() {
        return MathUtil.a(this.f1695k, this.f1697m, this.f1698n, (float) this.f1691g, (float) getRightBound());
    }

    private float getEndThumbX() {
        return MathUtil.a(this.f1696l, this.f1697m, this.f1698n, (float) this.f1691g, (float) getRightBound());
    }

    private void setCurrentPosition(float f) {
        if (this.f1694j != null) {
            float a = MathUtil.a(f, (float) this.f1691g, (float) getRightBound(), this.f1697m, this.f1698n);
            if (this.f1694j == Thumb.START) {
                this.f1695k = MathUtil.b(a, this.f1697m, this.f1696l);
            } else {
                this.f1696l = MathUtil.b(a, this.f1695k, this.f1698n);
            }
            invalidate();
            m1712e();
        }
    }

    private void m1711d() {
        if (this.f1699o != null) {
            this.f1699o.b(this.f1695k, this.f1696l);
        }
    }

    private void m1712e() {
        if (this.f1699o != null) {
            this.f1699o.a(this.f1695k, this.f1696l);
        }
    }

    private boolean m1709a(float f) {
        return Math.abs(f - ((float) getCenterY())) <= ((float) (this.f1691g * 2));
    }

    private float getCurrentPosition() {
        return this.f1694j == Thumb.START ? getStartThumbX() : getEndThumbX();
    }
}
