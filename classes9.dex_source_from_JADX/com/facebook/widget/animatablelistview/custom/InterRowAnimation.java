package com.facebook.widget.animatablelistview.custom;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.widget.ViewTransform;
import com.facebook.widget.listview.BetterListView;
import javax.annotation.Nullable;

/* compiled from: android.intent.category.DEFAULT */
public class InterRowAnimation {
    private final Context f20505a;
    public final BetterListView f20506b;
    public final FrameLayout f20507c;
    public final ViewTransform f20508d;
    public final int f20509e;
    public final int f20510f;
    private final int f20511g;
    public final long f20512h;
    public final FrameLayout f20513i;
    public final OnScrollListener f20514j;
    public View f20515k;
    public View f20516l;
    public int f20517m;
    public int f20518n;
    public int f20519o = 0;
    public boolean f20520p;
    public boolean f20521q;

    /* compiled from: android.intent.category.DEFAULT */
    class MyOnScrollListener implements OnScrollListener {
        final /* synthetic */ InterRowAnimation f20504a;

        public MyOnScrollListener(InterRowAnimation interRowAnimation) {
            this.f20504a = interRowAnimation;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            this.f20504a.f20519o = i;
            if (i != 0) {
                this.f20504a.f20520p = true;
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    InterRowAnimation(Context context, BetterListView betterListView, FrameLayout frameLayout, View view, int i, int i2, int i3, long j) {
        this.f20505a = context;
        this.f20506b = betterListView;
        this.f20507c = frameLayout;
        this.f20508d = new ViewTransform(view);
        this.f20509e = i;
        this.f20510f = i2;
        this.f20511g = i3;
        this.f20512h = j;
        this.f20513i = new FrameLayout(this.f20505a);
        this.f20513i.setLayoutParams(new LayoutParams(-1, -1));
        this.f20507c.addView(this.f20513i);
        this.f20513i.addView(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.setLayoutParams(new LayoutParams(layoutParams.width, layoutParams.height));
        view.setVisibility(4);
        this.f20514j = new MyOnScrollListener(this);
        this.f20506b.a(this.f20514j);
    }

    public final View m20067b() {
        if (this.f20521q) {
            return null;
        }
        View a = m20065a(this.f20509e, this.f20511g);
        if (this.f20515k == null || a == this.f20515k) {
            if (this.f20515k == null && a != null) {
                this.f20518n = a.getVisibility();
            }
            this.f20515k = a;
            return this.f20515k;
        }
        this.f20520p = true;
        return null;
    }

    public final View m20069c() {
        if (this.f20521q) {
            return null;
        }
        View a = m20065a(this.f20510f, this.f20511g);
        if (this.f20516l == null || a == this.f20516l) {
            if (this.f20516l == null && a != null) {
                this.f20517m = a.getVisibility();
            }
            this.f20516l = a;
            return this.f20516l;
        }
        this.f20520p = true;
        return null;
    }

    final Point m20066a(@Nullable View view) {
        Point point;
        View view2 = this.f20507c;
        if (view == null || view2 == null) {
            point = null;
        } else {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr);
            view2.getLocationInWindow(iArr2);
            point = new Point(iArr[0] - iArr2[0], iArr[1] - iArr2[1]);
        }
        return point;
    }

    private View m20065a(int i, int i2) {
        int firstVisiblePosition = i - (this.f20506b.getFirstVisiblePosition() - this.f20506b.getHeaderViewsCount());
        if (firstVisiblePosition < 0) {
            return null;
        }
        View childAt = this.f20506b.getChildAt(firstVisiblePosition);
        if (childAt != null) {
            return childAt.findViewById(i2);
        }
        return null;
    }

    final void m20068b(float f) {
        this.f20508d.setTranslationY(f);
    }
}
