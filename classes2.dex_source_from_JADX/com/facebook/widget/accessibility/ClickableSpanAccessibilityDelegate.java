package com.facebook.widget.accessibility;

import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: is_canceled */
public class ClickableSpanAccessibilityDelegate<V extends View & ClickableSpanAccessibilityDelegator> extends ExploreByTouchHelper {
    public final List<AccessibleText> f19229b = Lists.m1296a();
    public final V f19230c;
    private Spanned f19231d;

    public ClickableSpanAccessibilityDelegate(V v) {
        super(v);
        this.f19230c = v;
    }

    public final AccessibleText mo3103b(int i) {
        if (i < 0 || i >= this.f19229b.size()) {
            return null;
        }
        return (AccessibleText) this.f19229b.get(i);
    }

    @VisibleForTesting
    public final ImmutableList<AccessibleText> m26937c() {
        m26930d();
        return ImmutableList.copyOf(this.f19229b);
    }

    private void m26930d() {
        if (((ClickableSpanAccessibilityDelegator) this.f19230c).getText() != this.f19231d && (((ClickableSpanAccessibilityDelegator) this.f19230c).getText() instanceof Spanned)) {
            this.f19231d = (Spanned) ((ClickableSpanAccessibilityDelegator) this.f19230c).getText();
            this.f19229b.clear();
            AccessibleText accessibleText = new AccessibleText();
            accessibleText.a = this.f19231d.toString();
            accessibleText.b = 0;
            accessibleText.c = this.f19231d.length();
            accessibleText.d = true;
            this.f19229b.add(accessibleText);
            ClickableSpan[] c = mo3098c(0, this.f19231d.length());
            if (c != null) {
                for (Object obj : c) {
                    int spanStart = this.f19231d.getSpanStart(obj);
                    int spanEnd = this.f19231d.getSpanEnd(obj);
                    AccessibleText accessibleText2 = new AccessibleText();
                    if (!(obj instanceof AccessibleClickableSpan) || ((AccessibleClickableSpan) obj).a == null) {
                        accessibleText2.a = this.f19231d.subSequence(spanStart, spanEnd).toString();
                    } else {
                        accessibleText2.a = ((AccessibleClickableSpan) obj).a;
                    }
                    accessibleText2.b = spanStart;
                    accessibleText2.c = spanEnd;
                    accessibleText2.d = false;
                    this.f19229b.add(accessibleText2);
                }
            }
        }
    }

    public ClickableSpan[] mo3098c(int i, int i2) {
        if (((ClickableSpanAccessibilityDelegator) this.f19230c).getText() instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) ((ClickableSpanAccessibilityDelegator) this.f19230c).getText()).getSpans(i, i2, ClickableSpan.class);
        }
        return null;
    }

    protected final int mo3099a(float f, float f2) {
        int i;
        int i2 = (int) f;
        int i3 = (int) f2;
        if (this.f19229b.isEmpty() || !(((ClickableSpanAccessibilityDelegator) this.f19230c).getText() instanceof Spanned)) {
            i = -1;
        } else {
            int totalPaddingLeft = (i2 - ((ClickableSpanAccessibilityDelegator) this.f19230c).getTotalPaddingLeft()) + this.f19230c.getScrollX();
            int scrollY = this.f19230c.getScrollY() + (i3 - ((ClickableSpanAccessibilityDelegator) this.f19230c).getTotalPaddingTop());
            Layout layout = ((ClickableSpanAccessibilityDelegator) this.f19230c).getLayout();
            if (layout == null) {
                i = 0;
            } else {
                i = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) totalPaddingLeft);
                ClickableSpan[] c = mo3098c(i, i);
                if (c == null || c.length == 0) {
                    i = 0;
                } else {
                    Spanned spanned = (Spanned) ((ClickableSpanAccessibilityDelegator) this.f19230c).getText();
                    scrollY = spanned.getSpanStart(c[0]);
                    int spanEnd = spanned.getSpanEnd(c[0]);
                    int size = this.f19229b.size();
                    for (totalPaddingLeft = 0; totalPaddingLeft < size; totalPaddingLeft++) {
                        AccessibleText accessibleText = (AccessibleText) this.f19229b.get(totalPaddingLeft);
                        if (accessibleText.b == scrollY && accessibleText.c == spanEnd) {
                            i = totalPaddingLeft;
                            break;
                        }
                    }
                    i = 0;
                }
            }
        }
        i2 = i;
        if (i2 == -1) {
            return Integer.MIN_VALUE;
        }
        return i2;
    }

    protected final void mo3102a(List<Integer> list) {
        m26930d();
        int size = this.f19229b.size();
        for (int i = 0; i < size; i++) {
            list.add(Integer.valueOf(i));
        }
    }

    protected final void mo3101a(int i, AccessibilityEvent accessibilityEvent) {
        AccessibleText b = mo3103b(i);
        if (b == null) {
            throw new IllegalArgumentException("Invalid virtual view id");
        }
        accessibilityEvent.setContentDescription(b.a);
    }

    protected final void mo3100a(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibleText b = mo3103b(i);
        if (b == null) {
            throw new IllegalArgumentException("Invalid virtual view id");
        }
        accessibilityNodeInfoCompat.c(b.a);
        accessibilityNodeInfoCompat.a(16);
        accessibilityNodeInfoCompat.b(m26929a(b));
    }

    protected final boolean mo3104b(int i, int i2) {
        switch (i2) {
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                boolean z = true;
                if (mo3103b(i) == null) {
                    z = false;
                } else {
                    m26952a(i);
                    m26956a(i, 1);
                }
                return z;
            default:
                return false;
        }
    }

    private Rect m26929a(AccessibleText accessibleText) {
        if (accessibleText.d) {
            return new Rect(0, 0, this.f19230c.getWidth(), this.f19230c.getHeight());
        }
        Layout layout = ((ClickableSpanAccessibilityDelegator) this.f19230c).getLayout();
        if (layout == null) {
            return new Rect(0, 0, this.f19230c.getWidth(), this.f19230c.getHeight());
        }
        Rect rect = new Rect();
        double d = (double) accessibleText.b;
        double d2 = (double) accessibleText.c;
        double primaryHorizontal = (double) layout.getPrimaryHorizontal((int) d);
        Paint paint = new Paint();
        paint.setTextSize(((ClickableSpanAccessibilityDelegator) this.f19230c).getTextSize());
        int ceil = (int) Math.ceil((double) paint.measureText(accessibleText.a));
        int lineForOffset = layout.getLineForOffset((int) d);
        int i = lineForOffset != layout.getLineForOffset((int) d2) ? 1 : 0;
        layout.getLineBounds(lineForOffset, rect);
        int[] iArr = new int[]{0, 0};
        this.f19230c.getLocationOnScreen(iArr);
        d = (double) (((ClickableSpanAccessibilityDelegator) this.f19230c).getTotalPaddingTop() + (iArr[1] - this.f19230c.getScrollY()));
        rect.top = (int) (((double) rect.top) + d);
        rect.bottom = (int) (d + ((double) rect.bottom));
        rect.left = (int) (((double) rect.left) + (((((double) iArr[0]) + primaryHorizontal) + ((double) ((ClickableSpanAccessibilityDelegator) this.f19230c).getTotalPaddingLeft())) - ((double) this.f19230c.getScrollX())));
        if (i != 0) {
            return new Rect(0, this.f19230c.getHeight() - ((rect.bottom - rect.top) * 2), this.f19230c.getWidth(), this.f19230c.getHeight());
        }
        return new Rect(rect.left, this.f19230c.getHeight() - (rect.bottom - rect.top), rect.left + ceil, this.f19230c.getHeight());
    }
}
