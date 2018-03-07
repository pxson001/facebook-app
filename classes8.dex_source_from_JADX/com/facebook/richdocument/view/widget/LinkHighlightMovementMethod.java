package com.facebook.richdocument.view.widget;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.facebook.richdocument.model.block.entity.LinkEntity;

/* compiled from: onDeviceStatusChanged */
public class LinkHighlightMovementMethod extends LinkMovementMethod {
    public static LinkHighlightMovementMethod f7227a;
    public LinkEntity f7228b;

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        LinkEntity a;
        switch (motionEvent.getAction()) {
            case 0:
                a = m7489a(textView, spannable, motionEvent);
                if (a != null) {
                    a.f5665g = true;
                    Selection.setSelection(spannable, spannable.getSpanStart(a), spannable.getSpanEnd(a));
                    this.f7228b = a;
                    break;
                }
                break;
            case 1:
                if (this.f7228b != null) {
                    this.f7228b.onClick(textView);
                }
                m7490a(spannable);
                break;
            case 2:
                a = m7489a(textView, spannable, motionEvent);
                if (!(this.f7228b == null || a == this.f7228b)) {
                    m7490a(spannable);
                    break;
                }
            default:
                m7490a(spannable);
                return super.onTouchEvent(textView, spannable, motionEvent);
        }
        return true;
    }

    final void m7490a(Spannable spannable) {
        if (this.f7228b != null) {
            this.f7228b.f5665g = false;
            this.f7228b = null;
        }
        Selection.removeSelection(spannable);
    }

    static LinkEntity m7489a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
        Layout layout = textView.getLayout();
        x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
        LinkEntity[] linkEntityArr = (LinkEntity[]) spannable.getSpans(x, x, LinkEntity.class);
        return linkEntityArr.length > 0 ? linkEntityArr[0] : null;
    }
}
