package com.facebook.fbui.widget.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.common.lifecycle.AttachDetachListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;

/* compiled from: group_feed_type */
public class TextLayoutView extends View {
    public Layout f21718a;
    private LayoutCreator f21719b;
    private int f21720c;
    private int f21721d;
    private WidthErrorReporter f21722e;
    private Paint f21723f;
    private int f21724g;
    private int f21725h;
    private Path f21726i;
    private boolean f21727j;
    private boolean f21728k;
    private AttachDetachListener f21729l;
    private int f21730m;

    /* compiled from: group_feed_type */
    public interface WidthErrorReporter {
        void mo3208a(CharSequence charSequence, int i, int i2);
    }

    /* compiled from: group_feed_type */
    public interface LayoutCreator {
        Layout mo3209a(int i);
    }

    public TextLayoutView(Context context) {
        this(context, null);
    }

    public TextLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21727j = true;
        this.f21728k = false;
        this.f21730m = (int) context.getResources().getDisplayMetrics().density;
        setFocusableInTouchMode(true);
    }

    public void setTextLayout(Layout layout) {
        this.f21718a = layout;
        this.f21719b = null;
        if (layout != null) {
            setContentDescription(layout.getText());
        }
        requestLayout();
    }

    public final void m29429a(Layout layout, LayoutCreator layoutCreator, WidthErrorReporter widthErrorReporter) {
        this.f21718a = layout;
        this.f21719b = layoutCreator;
        this.f21720c = 0;
        this.f21721d = 0;
        this.f21722e = widthErrorReporter;
        if (layout != null) {
            setContentDescription(layout.getText());
        }
        requestLayout();
    }

    public CharSequence getText() {
        return this.f21718a != null ? this.f21718a.getText() : "";
    }

    public Layout getLayout() {
        return this.f21718a;
    }

    public void setLayout(Layout layout) {
        this.f21718a = layout;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f21718a != null) {
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            if (this.f21723f == null) {
                this.f21718a.draw(canvas);
            } else {
                this.f21718a.draw(canvas, getSelectionPath(), this.f21723f, 0);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -225346979);
        if (this.f21718a == null) {
            Logger.a(2, EntryType.UI_INPUT_END, 1431559861, a);
            return false;
        }
        int action = motionEvent.getAction();
        ClickableSpan a2;
        if (action == 1) {
            a2 = m29426a(motionEvent);
            if (a2 != null) {
                a2.onClick(this);
            } else {
                performClick();
            }
            m29428b(0, 0);
            LogUtils.a(2060582242, a);
            return true;
        } else if (action == 0) {
            a2 = m29426a(motionEvent);
            if (a2 != null) {
                Spanned spanned = (Spanned) this.f21718a.getText();
                m29428b(spanned.getSpanStart(a2), spanned.getSpanEnd(a2));
            } else {
                m29428b(0, 0);
            }
            LogUtils.a(-1057295002, a);
            return true;
        } else {
            if (action == 3) {
                m29428b(0, 0);
            }
            LogUtils.a(-1655955144, a);
            return false;
        }
    }

    protected void onMeasure(int i, int i2) {
        TracerDetour.a("TextLayoutView.onMeasure", -149940247);
        try {
            if (this.f21719b != null) {
                m29427a(i, i2);
            }
            if (this.f21718a == null) {
                super.onMeasure(i, i2);
                return;
            }
            setMeasuredDimension((getPaddingLeft() + getPaddingRight()) + this.f21718a.getWidth(), (getPaddingTop() + getPaddingBottom()) + LayoutMeasureUtil.m29744b(this.f21718a));
            TracerDetour.a(-1045488105);
        } finally {
            TracerDetour.a(1651385491);
        }
    }

    private void m29427a(int i, int i2) {
        if (this.f21718a != null) {
            int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
            int width = this.f21718a.getWidth();
            if (size <= this.f21730m + width && size >= width - this.f21730m) {
                return;
            }
            if (this.f21720c != i || this.f21721d != i2) {
                if (this.f21722e != null) {
                    this.f21722e.mo3208a(this.f21718a.getText(), width, size);
                }
                this.f21718a = this.f21719b.mo3209a(size);
                this.f21720c = i;
                this.f21721d = i2;
            }
        }
    }

    public void setHighlightColor(int i) {
        if (this.f21723f == null) {
            this.f21723f = new Paint(1);
            this.f21723f.setStyle(Style.FILL);
        }
        this.f21723f.setColor(i);
    }

    public int getHighlightColor() {
        if (this.f21723f == null) {
            return 0;
        }
        return this.f21723f.getColor();
    }

    private void m29428b(int i, int i2) {
        if (this.f21724g != i || this.f21725h != i2) {
            this.f21724g = i;
            this.f21725h = i2;
            this.f21727j = true;
            invalidate();
        }
    }

    private Path getSelectionPath() {
        if (this.f21724g == this.f21725h) {
            return null;
        }
        if (this.f21727j) {
            if (this.f21726i == null) {
                this.f21726i = new Path();
            }
            this.f21718a.getSelectionPath(this.f21724g, this.f21725h, this.f21726i);
            this.f21727j = false;
        }
        return this.f21726i;
    }

    private ClickableSpan m29426a(MotionEvent motionEvent) {
        int x = (((int) motionEvent.getX()) - getPaddingLeft()) + getScrollX();
        int lineForVertical = this.f21718a.getLineForVertical((((int) motionEvent.getY()) - getPaddingTop()) + getScrollY());
        if (this.f21718a.getLineLeft(lineForVertical) <= ((float) x) && ((float) x) <= this.f21718a.getLineRight(lineForVertical)) {
            lineForVertical = this.f21718a.getOffsetForHorizontal(lineForVertical, (float) x);
            CharSequence text = this.f21718a.getText();
            if (text instanceof Spanned) {
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(lineForVertical, lineForVertical, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    return clickableSpanArr[0];
                }
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2113715974);
        super.onAttachedToWindow();
        this.f21728k = true;
        if (this.f21729l != null) {
            this.f21729l.a(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1440739206, a);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f21728k = true;
        if (this.f21729l != null) {
            this.f21729l.a(this);
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1399989101);
        this.f21728k = false;
        if (this.f21729l != null) {
            this.f21729l.b(this);
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1282891575, a);
    }

    public void onStartTemporaryDetach() {
        this.f21728k = false;
        if (this.f21729l != null) {
            this.f21729l.b(this);
        }
        super.onStartTemporaryDetach();
    }

    public void setAttachDetachListener(AttachDetachListener attachDetachListener) {
        if (this.f21729l != null) {
            this.f21729l.b(this);
        }
        this.f21729l = attachDetachListener;
        if (this.f21729l != null && this.f21728k) {
            this.f21729l.a(this);
        }
    }
}
