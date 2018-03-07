package com.facebook.widget.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.facebook.orca.threadview.MessageItemView.6;
import javax.annotation.Nullable;

/* compiled from: com.facebook.groups.treehouse.constants.GroupsStartActivity */
public class SpanLinkHook implements BetterTextViewHook {
    private final TextView f5882a;
    private final Paint f5883b;
    private ClickableSpan f5884c;
    private Path f5885d;
    private 6 f5886e;

    public SpanLinkHook(TextView textView) {
        this(textView, -3355444);
    }

    private SpanLinkHook(TextView textView, int i) {
        this.f5885d = new Path();
        this.f5886e = null;
        this.f5882a = textView;
        this.f5883b = new Paint();
        this.f5883b.setColor(i);
        this.f5883b.setStyle(Style.FILL_AND_STROKE);
    }

    public final boolean mo633a(MotionEvent motionEvent) {
        if (!(this.f5882a.getText() instanceof Spanned)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5884c = m10613b(motionEvent);
            this.f5882a.invalidate();
        } else if (action == 1) {
            if (this.f5884c != null) {
                if (this.f5884c == m10613b(motionEvent)) {
                    ClickableSpan clickableSpan = this.f5884c;
                    this.f5884c = null;
                    this.f5882a.invalidate();
                    if (this.f5886e == null || !this.f5886e.a(clickableSpan)) {
                        clickableSpan.onClick(this.f5882a);
                    }
                } else {
                    this.f5884c = null;
                    this.f5882a.invalidate();
                }
            }
        } else if (action == 3 && this.f5884c != null) {
            this.f5884c = null;
            this.f5882a.invalidate();
        }
        if (this.f5884c != null) {
            return true;
        }
        return false;
    }

    public final void mo632a(Canvas canvas) {
        if (this.f5884c != null) {
            canvas.save();
            Rect a = m10612a();
            canvas.translate((float) a.left, (float) a.top);
            Spanned spanned = (Spanned) this.f5882a.getText();
            this.f5882a.getLayout().getSelectionPath(spanned.getSpanStart(this.f5884c), spanned.getSpanEnd(this.f5884c), this.f5885d);
            canvas.drawPath(this.f5885d, this.f5883b);
            canvas.restore();
        }
    }

    @Nullable
    private ClickableSpan m10613b(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Layout layout = this.f5882a.getLayout();
        if (layout == null) {
            return null;
        }
        if (m10612a().contains(x, y)) {
            y = layout.getOffsetForHorizontal(layout.getLineForVertical(y - this.f5882a.getTotalPaddingTop()), (float) (x - this.f5882a.getTotalPaddingLeft()));
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) this.f5882a.getText()).getSpans(y, y, ClickableSpan.class);
            if (clickableSpanArr.length > 0) {
                return clickableSpanArr[0];
            }
        }
        return null;
    }

    public final void m10615a(6 6) {
        this.f5886e = 6;
    }

    private Rect m10612a() {
        Rect rect = new Rect(0, 0, this.f5882a.getWidth(), this.f5882a.getHeight());
        rect.left += this.f5882a.getTotalPaddingLeft();
        rect.top += this.f5882a.getTotalPaddingTop();
        rect.bottom -= this.f5882a.getTotalPaddingBottom();
        rect.right -= this.f5882a.getTotalPaddingRight();
        return rect;
    }
}
