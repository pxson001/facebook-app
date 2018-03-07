package com.facebook.widget.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.facebook.katana.IntentUriHandler */
public class ExpandedTouchLinkMovementMethod extends LinkMovementMethod {
    private static final Class f5855a = ExpandedTouchLinkMovementMethod.class;
    public static final ExpandedTouchLinkMovementMethod f5856b = new ExpandedTouchLinkMovementMethod();
    private int f5857c;

    private ExpandedTouchLinkMovementMethod() {
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int scrollX = textView.getScrollX() + (((int) motionEvent.getX()) - textView.getTotalPaddingLeft());
            int scrollY = textView.getScrollY() + (((int) motionEvent.getY()) - textView.getTotalPaddingTop());
            Layout layout = textView.getLayout();
            ClickableSpan[] clickableSpanArr;
            if (action == 1) {
                if (this.f5857c == 0) {
                    this.f5857c = (int) (textView.getResources().getDisplayMetrics().density * 30.0f);
                }
                action = 0;
                while (action < spannable.length()) {
                    int nextSpanTransition = spannable.nextSpanTransition(action, spannable.length(), ClickableSpan.class);
                    clickableSpanArr = (ClickableSpan[]) spannable.getSpans(nextSpanTransition, nextSpanTransition, ClickableSpan.class);
                    if (clickableSpanArr.length == 0) {
                        break;
                    }
                    ClickableSpan clickableSpan = clickableSpanArr[0];
                    action = layout.getLineForOffset(nextSpanTransition);
                    int spanEnd = spannable.getSpanEnd(clickableSpan);
                    int lineForOffset = layout.getLineForOffset(spanEnd);
                    int i = spanEnd + 1;
                    List<Rect> arrayList = new ArrayList();
                    if (lineForOffset == action) {
                        Rect rect = new Rect();
                        layout.getLineBounds(action, rect);
                        arrayList.add(m10607a(m10606a(rect.left, rect.right, layout, nextSpanTransition, action), rect.top, m10606a(rect.left, rect.right, layout, spanEnd, action), rect.bottom, this.f5857c));
                    } else {
                        Rect rect2 = new Rect();
                        layout.getLineBounds(action, rect2);
                        arrayList.add(m10607a(m10606a(rect2.left, rect2.right, layout, nextSpanTransition, action), rect2.top, rect2.right, rect2.bottom, this.f5857c));
                        layout.getLineBounds(lineForOffset, rect2);
                        arrayList.add(m10607a(rect2.left, rect2.top, m10606a(rect2.left, rect2.right, layout, spanEnd, lineForOffset), rect2.bottom, this.f5857c));
                        if (lineForOffset - action > 1) {
                            for (action++; action < lineForOffset; action++) {
                                layout.getLineBounds(action, rect2);
                                arrayList.add(m10607a(rect2.left, rect2.top, rect2.right, rect2.bottom, this.f5857c));
                            }
                        }
                    }
                    for (Rect contains : arrayList) {
                        if (contains.contains(scrollX, scrollY)) {
                            textView.setTag(2131558428, new Point((int) motionEvent.getX(), (int) motionEvent.getY()));
                            clickableSpan.onClick(textView);
                            textView.setTag(2131558428, null);
                            return true;
                        }
                    }
                    action = i;
                }
            } else {
                action = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
                clickableSpanArr = (ClickableSpan[]) spannable.getSpans(action, action, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                    return true;
                }
            }
            Selection.removeSelection(spannable);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    private static Rect m10607a(int i, int i2, int i3, int i4, int i5) {
        return new Rect(i - i5, i2 - i5, i3 + i5, i4 + i5);
    }

    private static int m10606a(int i, int i2, Layout layout, int i3, int i4) {
        while (i <= i2) {
            int i5 = (i + i2) / 2;
            int offsetForHorizontal = layout.getOffsetForHorizontal(i4, (float) i5);
            if (offsetForHorizontal == i3) {
                return i5;
            }
            if (offsetForHorizontal < i3) {
                i = i5 + 1;
            } else {
                i2 = i5 - 1;
            }
        }
        return -1;
    }
}
