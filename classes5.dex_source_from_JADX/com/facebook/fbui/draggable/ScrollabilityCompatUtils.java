package com.facebook.fbui.draggable;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Gallery;
import android.widget.HorizontalScrollView;

/* compiled from: requires_reauth */
public class ScrollabilityCompatUtils {
    public static boolean m4262a(ViewGroup viewGroup, Direction direction, int i, int i2) {
        return m4261a(viewGroup, false, direction, i, i2);
    }

    private static boolean m4260a(View view, Direction direction, int i, int i2) {
        int i3 = 1;
        if (view instanceof HorizontalScrollInterceptingView) {
            return true;
        }
        if (view instanceof HorizontalScrollAwareView) {
            return ((HorizontalScrollAwareView) view).a(direction, i, i2);
        }
        boolean z;
        if (view instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) view;
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter == null) {
                z = false;
            } else {
                z = m4259a(viewPager.k, adapter.b(), direction);
            }
            return z;
        } else if (view instanceof Gallery) {
            Gallery gallery = (Gallery) view;
            return m4259a(gallery.getSelectedItemPosition(), gallery.getCount(), direction);
        } else if (view instanceof HorizontalScrollView) {
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) view;
            z = false;
            if (horizontalScrollView.getChildCount() > 0) {
                int width = (horizontalScrollView.getWidth() - horizontalScrollView.getPaddingLeft()) - horizontalScrollView.getPaddingRight();
                int width2 = horizontalScrollView.getChildAt(0).getWidth();
                if (width2 > width) {
                    width = width2 - width;
                    width2 = horizontalScrollView.getScrollX();
                    if (direction == Direction.RIGHT) {
                        if (width2 > 0) {
                            z = true;
                        }
                    } else if (width2 < width) {
                        z = true;
                    }
                }
            }
            return z;
        } else if (view instanceof WebView) {
            return true;
        } else {
            if (direction == Direction.RIGHT) {
                i3 = -1;
            }
            return ViewCompat.a(view, i3);
        }
    }

    public static boolean m4259a(int i, int i2, Direction direction) {
        if (direction == Direction.RIGHT) {
            if (i > 0) {
                return true;
            }
            return false;
        } else if (i >= i2 - 1) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean m4261a(View view, boolean z, Direction direction, int i, int i2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i + scrollX >= childAt.getLeft() && i + scrollX < childAt.getRight() && i2 + scrollY >= childAt.getTop() && i2 + scrollY < childAt.getBottom() && m4261a(childAt, true, direction, (i + scrollX) - childAt.getLeft(), (i2 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && m4260a(view, direction, i, i2);
    }
}
