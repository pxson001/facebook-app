package com.facebook.rtc.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.R;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.rtc.views.RtcVideoChatHeadView.Location;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: app_links */
public abstract class RtcFloatingView extends FbRelativeLayout {
    private static final Class<?> f20106b = RtcFloatingView.class;
    public Point f20107a;
    public Location f20108c;
    private int f20109d;
    @Inject
    public WindowManager f20110e;
    protected float f20111f;
    protected boolean f20112g;

    public static void m19751a(Object obj, Context context) {
        ((RtcFloatingView) obj).f20110e = WindowManagerMethodAutoProvider.b(FbInjector.get(context));
    }

    abstract void mo830a(LayoutParams layoutParams);

    abstract void mo831d();

    abstract void mo832e();

    abstract ImmutableList<View> getOtherViews();

    abstract View getVideoView();

    public RtcFloatingView(Context context) {
        this(context, null);
    }

    public RtcFloatingView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20112g = false;
        Class cls = RtcFloatingView.class;
        m19751a(this, getContext());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RTCVideoSurface);
        this.f20112g = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        mo831d();
    }

    protected final void m19753a(Point point, Location location, float f) {
        m19750a(point, location, 0, f);
    }

    private void m19750a(Point point, Location location, int i, float f) {
        Integer.valueOf(point.x);
        Integer.valueOf(point.y);
        Integer.valueOf(i);
        Float.valueOf(f);
        this.f20107a = point;
        this.f20108c = location;
        this.f20109d = i;
        this.f20111f = f;
        m19758f();
        mo829a();
    }

    protected final void m19758f() {
        LayoutParams layoutParams = (LayoutParams) getVideoView().getLayoutParams();
        mo830a(layoutParams);
        setPosition(layoutParams);
        getVideoView().setLayoutParams(layoutParams);
        mo832e();
    }

    private void mo829a() {
        LayoutParams layoutParams = (LayoutParams) getVideoView().getLayoutParams();
        ImmutableList otherViews = getOtherViews();
        int size = otherViews.size();
        for (int i = 0; i < size; i++) {
            View view = (View) otherViews.get(i);
            if (this.f20112g) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                Point point = this.f20107a;
                if (this.f20112g) {
                    int min = Math.min(point.x, point.y);
                    layoutParams2.height = min;
                    layoutParams2.width = min;
                } else {
                    layoutParams2.bottomMargin = 0;
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.width = point.x;
                    layoutParams2.height = point.y;
                }
                setPosition(layoutParams2);
                view.setLayoutParams(layoutParams2);
            } else {
                view.setLayoutParams(layoutParams);
            }
        }
    }

    private int getMarginToParent() {
        if (this.f20112g) {
            return 0;
        }
        return m19752a(6);
    }

    private void setPosition(LayoutParams layoutParams) {
        switch (this.f20108c) {
            case CENTER:
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.addRule(13, 1);
                layoutParams.addRule(12, 0);
                layoutParams.addRule(11, 0);
                layoutParams.addRule(10, 0);
                layoutParams.addRule(9, 0);
                return;
            case BOTTOM_RIGHT:
                layoutParams.leftMargin = layoutParams.leftMargin + getMarginToParent();
                layoutParams.topMargin = layoutParams.topMargin + getMarginToParent();
                layoutParams.rightMargin = layoutParams.rightMargin + getMarginToParent();
                layoutParams.bottomMargin = layoutParams.bottomMargin + getMarginToParent();
                layoutParams.addRule(13, 0);
                layoutParams.addRule(12, 1);
                layoutParams.addRule(11, 1);
                layoutParams.addRule(10, 0);
                layoutParams.addRule(9, 0);
                return;
            case TOP_RIGHT:
                layoutParams.leftMargin = layoutParams.leftMargin + getMarginToParent();
                layoutParams.rightMargin = layoutParams.rightMargin + getMarginToParent();
                layoutParams.topMargin = layoutParams.topMargin + getMarginToParent();
                layoutParams.bottomMargin = layoutParams.bottomMargin + getMarginToParent();
                layoutParams.addRule(13, 0);
                layoutParams.addRule(12, 0);
                layoutParams.addRule(11, 1);
                layoutParams.addRule(10, 1);
                layoutParams.addRule(9, 0);
                return;
            default:
                return;
        }
    }

    protected final int m19752a(int i) {
        return ((int) getResources().getDisplayMetrics().scaledDensity) * i;
    }

    protected final <T extends View> T m19755b(int i) {
        return FindViewUtil.b(this, i);
    }
}
