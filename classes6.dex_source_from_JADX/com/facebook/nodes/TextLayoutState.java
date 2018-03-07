package com.facebook.nodes;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.nodes.canvas.CanvasOperation;

/* compiled from: thread_icon_emoji */
public class TextLayoutState implements TouchHandler, CanvasOperation {
    private final Paint f3144a;
    public Layout f3145b;
    public int f3146c;
    public int f3147d;
    public int f3148e;
    public int f3149f;
    public boolean f3150g = true;
    public Path f3151h;

    public TextLayoutState(Paint paint) {
        this.f3144a = paint;
    }

    final boolean m4195a() {
        CharSequence text = this.f3145b.getText();
        if (!(text instanceof Spanned)) {
            return false;
        }
        if (((ClickableSpan[]) ((Spanned) text).getSpans(0, text.length() - 1, ClickableSpan.class)).length > 0) {
            return true;
        }
        return false;
    }

    public final void mo188a(Canvas canvas) {
        Path path;
        canvas.translate((float) this.f3146c, (float) this.f3147d);
        Layout layout = this.f3145b;
        if (this.f3148e == this.f3149f) {
            path = null;
        } else {
            if (this.f3150g) {
                if (this.f3151h == null) {
                    this.f3151h = new Path();
                }
                this.f3145b.getSelectionPath(this.f3148e, this.f3149f, this.f3151h);
                this.f3150g = false;
            }
            path = this.f3151h;
        }
        layout.draw(canvas, path, this.f3144a, 0);
        canvas.translate((float) (-this.f3146c), (float) (-this.f3147d));
    }

    public final boolean mo175a(MotionEvent motionEvent, View view) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            ClickableSpan clickableSpan;
            ClickableSpan clickableSpan2;
            Spanned spanned;
            int y = ((int) motionEvent.getY()) - this.f3147d;
            if (y >= this.f3145b.getLineTop(0) && y < this.f3145b.getLineBottom(this.f3145b.getLineCount() - 1)) {
                int x = ((int) motionEvent.getX()) - this.f3146c;
                y = this.f3145b.getLineForVertical(y);
                if (this.f3145b.getLineLeft(y) <= ((float) x) && ((float) x) <= this.f3145b.getLineRight(y)) {
                    x = this.f3145b.getOffsetForHorizontal(y, (float) x);
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) this.f3145b.getText()).getSpans(x, x, ClickableSpan.class);
                    if (clickableSpanArr.length != 0) {
                        clickableSpan = clickableSpanArr[0];
                        clickableSpan2 = clickableSpan;
                        if (clickableSpan2 == null) {
                            if (action == 1) {
                                clickableSpan2.onClick(view);
                                m4193a(0, 0, view);
                            } else if (action == 0) {
                                spanned = (Spanned) this.f3145b.getText();
                                m4193a(spanned.getSpanStart(clickableSpan2), spanned.getSpanEnd(clickableSpan2), view);
                            }
                            return true;
                        }
                        m4193a(0, 0, view);
                    }
                }
            }
            clickableSpan = null;
            clickableSpan2 = clickableSpan;
            if (clickableSpan2 == null) {
                m4193a(0, 0, view);
            } else {
                if (action == 1) {
                    clickableSpan2.onClick(view);
                    m4193a(0, 0, view);
                } else if (action == 0) {
                    spanned = (Spanned) this.f3145b.getText();
                    m4193a(spanned.getSpanStart(clickableSpan2), spanned.getSpanEnd(clickableSpan2), view);
                }
                return true;
            }
        }
        if (action != 3) {
            return false;
        }
        m4193a(0, 0, view);
        return false;
    }

    public final boolean m4197b(int i, int i2) {
        if (this.f3148e == i && this.f3149f == i2) {
            return false;
        }
        this.f3148e = i;
        this.f3149f = i2;
        this.f3150g = true;
        return true;
    }

    private void m4193a(int i, int i2, View view) {
        if (m4197b(i, i2)) {
            view.invalidate();
        }
    }
}
