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
import com.facebook.search.results.filters.definition.FilterPersistentState;
import com.facebook.search.results.filters.definition.SearchResultPageDistanceFilterDefinition;
import com.facebook.search.results.filters.definition.SearchResultPageDistanceFilterDefinition.3;

/* compiled from: timeskew_db */
public class FbSeekBar extends FrameLayout implements DragDecider, DragListener, TapListener {
    private AdvancedDragDetector f1672a;
    private Paint f1673b;
    private Paint f1674c;
    private Paint f1675d;
    private Paint f1676e;
    private Paint f1677f;
    public int f1678g;
    private int f1679h;
    private int f1680i;
    public float f1681j;
    private float f1682k;
    private float f1683l;
    private 3 f1684m;

    public FbSeekBar(Context context) {
        this(context, null);
    }

    public FbSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FbSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1695c();
    }

    private void m1695c() {
        this.f1672a = new AdvancedDragDetector(getContext());
        this.f1672a.a(new Direction[]{Direction.LEFT, Direction.RIGHT});
        this.f1672a.q = this;
        this.f1672a.r = this;
        this.f1672a.s = this;
        Resources resources = getResources();
        this.f1674c = new Paint();
        this.f1674c.setColor(resources.getColor(2131361917));
        this.f1674c.setAntiAlias(true);
        this.f1674c.setStrokeWidth((float) resources.getDimensionPixelSize(2131433126));
        this.f1673b = new Paint();
        this.f1673b.setColor(resources.getColor(2131361980));
        this.f1673b.setStrokeWidth((float) resources.getDimensionPixelSize(2131433126));
        this.f1675d = new Paint();
        this.f1675d.setColor(resources.getColor(2131361917));
        this.f1675d.setAlpha(127);
        this.f1675d.setAntiAlias(true);
        this.f1676e = new Paint();
        this.f1676e.setColor(resources.getColor(2131361920));
        this.f1676e.setAntiAlias(true);
        this.f1677f = new Paint();
        this.f1677f.setColor(resources.getColor(2131361917));
        this.f1677f.setAntiAlias(true);
        this.f1678g = resources.getDimensionPixelSize(2131433129);
        this.f1679h = resources.getDimensionPixelSize(2131433128);
        this.f1680i = resources.getDimensionPixelSize(2131433127);
        this.f1681j = Float.NaN;
    }

    public final void m1708e(float f, float f2) {
        if (f < f2) {
            this.f1682k = f;
            this.f1683l = f2;
            if (Float.isNaN(this.f1681j)) {
                this.f1681j = f;
            }
            invalidate();
            m1697e();
        }
    }

    public void setCurrentSelectedValue(float f) {
        if (f >= this.f1682k && f <= this.f1683l) {
            this.f1681j = f;
            invalidate();
            m1697e();
        }
    }

    public float getCurrentSelectedValue() {
        return this.f1681j;
    }

    public void setOnSeekBarChangeListener(3 3) {
        this.f1684m = 3;
        m1697e();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1594900897);
        boolean b = this.f1672a.b(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -594559955, a);
        return b;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1672a.a(motionEvent);
    }

    public final boolean m1701a(float f, float f2) {
        return m1694a(f2);
    }

    public final boolean m1705b(float f, float f2) {
        return true;
    }

    public final boolean m1702a(float f, float f2, Direction direction) {
        return true;
    }

    public final void m1704b(float f, float f2, Direction direction) {
        setCurrentPosition(getThumbX() + f);
    }

    public final void m1699a() {
        m1696d();
    }

    public final void m1700a(Direction direction, int i) {
        m1696d();
    }

    public final void m1703b() {
    }

    public final boolean m1706c(float f, float f2) {
        return m1698f(f, f2);
    }

    public final void m1707d(float f, float f2) {
        m1698f(f, f2);
    }

    protected void dispatchDraw(Canvas canvas) {
        float centerY = (float) getCenterY();
        float thumbX = getThumbX();
        canvas.save();
        canvas.drawLine((float) this.f1678g, centerY, (float) getRightBound(), centerY, this.f1673b);
        canvas.drawCircle(thumbX, centerY, (float) this.f1678g, this.f1675d);
        canvas.drawLine((float) this.f1678g, centerY, thumbX, centerY, this.f1674c);
        canvas.drawCircle(thumbX, centerY, (float) this.f1679h, this.f1676e);
        canvas.drawCircle(thumbX, centerY, (float) this.f1680i, this.f1677f);
        canvas.restore();
    }

    private boolean m1698f(float f, float f2) {
        if (!m1694a(f2)) {
            return false;
        }
        setCurrentPosition(f);
        m1696d();
        return true;
    }

    private int getLeftBound() {
        return this.f1678g;
    }

    private void setCurrentPosition(float f) {
        this.f1681j = MathUtil.b(MathUtil.a(f, (float) this.f1678g, (float) getRightBound(), this.f1682k, this.f1683l), this.f1682k, this.f1683l);
        invalidate();
        m1697e();
    }

    private int getRightBound() {
        return getWidth() - this.f1678g;
    }

    private int getCenterY() {
        return getMeasuredHeight() / 2;
    }

    private float getThumbX() {
        return MathUtil.a(this.f1681j, this.f1682k, this.f1683l, (float) this.f1678g, (float) getRightBound());
    }

    private void m1696d() {
        if (this.f1684m != null) {
            3 3 = this.f1684m;
            3.b.a(new FilterPersistentState(3.c.a, null, SearchResultPageDistanceFilterDefinition.d((float) SearchResultPageDistanceFilterDefinition.c(this.f1681j))));
        }
    }

    private void m1697e() {
        if (this.f1684m != null) {
            this.f1684m.a.c(SearchResultPageDistanceFilterDefinition.c(this.f1681j));
        }
    }

    private boolean m1694a(float f) {
        return Math.abs(f - ((float) getCenterY())) <= ((float) (this.f1678g * 2));
    }

    private float getCurrentPosition() {
        return getThumbX();
    }
}
