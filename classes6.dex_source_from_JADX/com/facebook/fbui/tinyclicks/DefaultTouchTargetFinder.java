package com.facebook.fbui.tinyclicks;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.common.util.SizeUtil;
import com.facebook.fbui.tinyclicks.widget.MasterTouchDelegateLayout;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: no included points */
public class DefaultTouchTargetFinder {
    private static final Class<?> f10003f = DefaultTouchTargetFinder.class;
    public int f10004a = -1;
    public int f10005b = -1;
    protected int[] f10006c = new int[2];
    public List<TouchTarget> f10007d = new ArrayList();
    protected ViewGroup f10008e = null;
    private int f10009g = -1;
    private int[] f10010h = new int[2];
    private Rect f10011i = new Rect();

    @Inject
    public DefaultTouchTargetFinder(Context context) {
        this.f10009g = SizeUtil.a(context, 48.0f);
    }

    public TouchTarget m15702a(ViewGroup viewGroup, int i, int i2) {
        TouchTarget touchTarget = null;
        if (viewGroup == null || this.f10009g <= 0) {
            return null;
        }
        m15698a();
        this.f10004a = i;
        this.f10005b = i2;
        viewGroup.getLocationInWindow(this.f10006c);
        if (m15704a(viewGroup, true)) {
            m15698a();
            return null;
        }
        TouchTarget touchTarget2;
        switch (this.f10007d.size()) {
            case 0:
                m15698a();
                return null;
            case 1:
                touchTarget2 = (TouchTarget) this.f10007d.get(0);
                touchTarget2.f10033b = this.f10008e;
                m15698a();
                return touchTarget2;
            default:
                int i3 = Integer.MAX_VALUE;
                for (TouchTarget touchTarget22 : this.f10007d) {
                    int i4;
                    int a = touchTarget22.m15720a(this.f10004a, this.f10005b);
                    if (a < i3) {
                        i4 = a;
                    } else {
                        touchTarget22 = touchTarget;
                        i4 = i3;
                    }
                    i3 = i4;
                    touchTarget = touchTarget22;
                }
                touchTarget.f10033b = this.f10008e;
                m15698a();
                return touchTarget;
        }
    }

    private void m15698a() {
        this.f10007d.clear();
        this.f10008e = null;
    }

    protected final boolean m15704a(ViewGroup viewGroup, boolean z) {
        if (viewGroup.getVisibility() != 0) {
            return false;
        }
        if (!z) {
            if ((viewGroup instanceof MasterTouchDelegateLayout) && m15701d(viewGroup)) {
                return true;
            }
            if ((viewGroup instanceof ListView) && viewGroup.isClickable() && m15701d(viewGroup)) {
                this.f10007d.clear();
                this.f10008e = viewGroup;
                return m15699a((ListView) viewGroup);
            } else if (m15700c(viewGroup)) {
                return true;
            }
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                if (m15704a((ViewGroup) childAt, false)) {
                    return true;
                }
            } else if (m15700c(childAt)) {
                return true;
            }
        }
        return false;
    }

    private boolean m15699a(ListView listView) {
        int i = 0;
        while (i < listView.getChildCount()) {
            View childAt = listView.getChildAt(i);
            if (!m15705b(childAt).contains(this.f10004a, this.f10005b)) {
                i++;
            } else if (childAt instanceof ViewGroup) {
                return m15704a((ViewGroup) childAt, false);
            } else {
                return m15700c(childAt);
            }
        }
        return false;
    }

    private boolean m15700c(View view) {
        if (view.getVisibility() != 0) {
            return false;
        }
        if (view instanceof TextView) {
            boolean a;
            view = (TextView) view;
            if (view.isClickable()) {
                a = m15703a(view);
            } else {
                CharSequence text = view.getText();
                if (text instanceof Spannable) {
                    Rect b = m15705b(view);
                    if (b.contains(this.f10004a, this.f10005b)) {
                        Spannable spannable = (Spannable) text;
                        int totalPaddingLeft = ((this.f10004a - b.left) - view.getTotalPaddingLeft()) + view.getScrollX();
                        int totalPaddingTop = ((this.f10005b - b.top) - view.getTotalPaddingTop()) + view.getScrollY();
                        Layout layout = view.getLayout();
                        if (layout == null) {
                            a = false;
                        } else {
                            totalPaddingTop = layout.getOffsetForHorizontal(layout.getLineForVertical(totalPaddingTop), (float) totalPaddingLeft);
                            a = ((ClickableSpan[]) spannable.getSpans(totalPaddingTop, totalPaddingTop, ClickableSpan.class)).length != 0;
                        }
                    } else {
                        a = false;
                    }
                } else {
                    a = false;
                }
            }
            return a;
        } else if (view.isClickable()) {
            return m15703a(view);
        } else {
            return false;
        }
    }

    public boolean m15703a(View view) {
        Rect b = m15705b(view);
        if (b.contains(this.f10004a, this.f10005b)) {
            return true;
        }
        int width = b.width();
        int height = b.height();
        if (width >= this.f10009g && height >= this.f10009g) {
            return false;
        }
        Rect rect = new Rect(b);
        if (width < this.f10009g) {
            width = (this.f10009g - width) / 2;
            rect.left -= width;
            rect.right = width + rect.right;
        }
        if (height < this.f10009g) {
            width = (this.f10009g - height) / 2;
            rect.top -= width;
            rect.bottom = width + rect.bottom;
        }
        if (!rect.contains(this.f10004a, this.f10005b)) {
            return false;
        }
        this.f10007d.add(new TouchTarget(view, new Rect(b), rect));
        return false;
    }

    public final Rect m15705b(View view) {
        Rect rect = this.f10011i;
        view.getLocationInWindow(this.f10010h);
        rect.left = this.f10010h[0] - this.f10006c[0];
        rect.top = this.f10010h[1] - this.f10006c[1];
        int bottom = view.getBottom() - view.getTop();
        rect.right = (view.getRight() - view.getLeft()) + rect.left;
        rect.bottom = rect.top + bottom;
        return rect;
    }

    private boolean m15701d(View view) {
        return m15705b(view).contains(this.f10004a, this.f10005b);
    }
}
