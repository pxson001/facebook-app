package com.facebook.events.permalink.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.events.permalink.tabbar.EventPermalinkTabBar;
import com.facebook.events.permalink.tabbar.StickyTabBarController;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.annotation.Nullable;

/* compiled from: button_element_start */
public class EventPermalinkTabFooterAdapter extends FbBaseAdapter {
    @Nullable
    public ScrollingViewProxy f18249a;
    @Nullable
    public StickyTabBarController f18250b;

    public int getCount() {
        return 1;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public final View m18616a(int i, ViewGroup viewGroup) {
        return new FrameLayout(viewGroup.getContext());
    }

    public final void m18617a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        int i3 = 0;
        if (this.f18249a == null) {
            m18615a(view, 0);
            return;
        }
        int i4;
        int height = viewGroup.getHeight();
        if (this.f18250b == null) {
            i4 = 0;
        } else {
            i4 = this.f18250b.m19193b();
        }
        height -= i4;
        i4 = 0;
        while (i4 < this.f18249a.p()) {
            View f = this.f18249a.f(i4);
            if (f == null || !(f instanceof EventPermalinkTabBar)) {
                i4++;
            } else {
                View f2 = this.f18249a.f(this.f18249a.p() - 1);
                if (f2 == null) {
                    i4 = 0;
                } else {
                    i4 = height - (f2.getBottom() - f.getTop());
                }
                if (i4 >= 0) {
                    i3 = i4;
                }
                m18615a(view, i3);
                return;
            }
        }
        m18615a(view, 0);
    }

    private static void m18615a(View view, int i) {
        view.setLayoutParams(new LayoutParams(-1, i));
    }

    public int getItemViewType(int i) {
        return 0;
    }
}
