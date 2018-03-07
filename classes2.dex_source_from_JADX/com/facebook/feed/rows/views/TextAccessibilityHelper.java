package com.facebook.feed.rows.views;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import com.facebook.accessibility.AccessibilityHelper;
import com.facebook.fbui.widget.text.TextLayoutView;

/* compiled from: friendly_name */
final class TextAccessibilityHelper extends AccessibilityHelper<TextLayoutView> {
    private static final int[] f23070b = new int[2];
    private static final Rect f23071c = new Rect();
    private static final RectF f23072d = new RectF();
    private static final Path f23073e = new Path();

    TextAccessibilityHelper(TextLayoutView textLayoutView) {
        super(textLayoutView);
    }

    protected final int mo3397a(float f, float f2) {
        ClickableSpan clickableSpan;
        int paddingLeft = ((int) f) - ((TextLayoutView) this.f23075a).getPaddingLeft();
        int paddingTop = ((int) f2) - ((TextLayoutView) this.f23075a).getPaddingTop();
        Layout layout = ((TextLayoutView) this.f23075a).getLayout();
        if (layout == null) {
            clickableSpan = null;
        } else {
            CharSequence text = layout.getText();
            if (!(text instanceof Spanned)) {
                clickableSpan = null;
            } else if (paddingTop < layout.getLineTop(0) || paddingTop >= layout.getLineBottom(layout.getLineCount() - 1)) {
                clickableSpan = null;
            } else {
                int lineForVertical = layout.getLineForVertical(paddingTop);
                if (((float) paddingLeft) < layout.getLineLeft(lineForVertical) || ((float) paddingLeft) > layout.getLineRight(lineForVertical)) {
                    clickableSpan = null;
                } else {
                    int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, (float) paddingLeft);
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                    clickableSpan = clickableSpanArr.length == 0 ? null : clickableSpanArr[0];
                }
            }
        }
        ClickableSpan clickableSpan2 = clickableSpan;
        if (clickableSpan2 == null) {
            return -1;
        }
        return ((Spanned) ((TextLayoutView) this.f23075a).getLayout().getText()).getSpanStart(clickableSpan2);
    }

    protected final void mo3399a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int i = 0;
        Layout layout = ((TextLayoutView) this.f23075a).getLayout();
        if (layout != null) {
            CharSequence text = layout.getText();
            if (text instanceof Spanned) {
                Spanned spanned = (Spanned) text;
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spanned.getSpans(0, text.length(), ClickableSpan.class);
                int length = clickableSpanArr.length;
                while (i < length) {
                    accessibilityNodeInfoCompat.c(this.f23075a, spanned.getSpanStart(clickableSpanArr[i]));
                    i++;
                }
            }
        }
    }

    protected final void mo3398a(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Layout layout = ((TextLayoutView) this.f23075a).getLayout();
        if (layout != null) {
            CharSequence text = layout.getText();
            if (text instanceof Spanned) {
                Spanned spanned = (Spanned) text;
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spanned.getSpans(i, i, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    Object obj = clickableSpanArr[0];
                    int spanStart = spanned.getSpanStart(obj);
                    int spanEnd = spanned.getSpanEnd(obj);
                    accessibilityNodeInfoCompat.d(this.f23075a);
                    accessibilityNodeInfoCompat.d(spanned.subSequence(spanStart, spanEnd));
                    accessibilityNodeInfoCompat.c(true);
                    layout.getSelectionPath(spanStart, spanEnd, f23073e);
                    f23073e.computeBounds(f23072d, true);
                    ((TextLayoutView) this.f23075a).getLocationOnScreen(f23070b);
                    spanEnd = f23070b[0] + ((TextLayoutView) this.f23075a).getPaddingLeft();
                    int paddingTop = ((TextLayoutView) this.f23075a).getPaddingTop() + f23070b[1];
                    f23071c.set(((int) f23072d.left) + spanEnd, ((int) f23072d.top) + paddingTop, spanEnd + ((int) f23072d.right), paddingTop + ((int) f23072d.bottom));
                    accessibilityNodeInfoCompat.d(f23071c);
                    accessibilityNodeInfoCompat.a(true);
                    accessibilityNodeInfoCompat.f(true);
                    accessibilityNodeInfoCompat.h(true);
                }
            }
        }
    }
}
