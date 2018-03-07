package com.facebook.widget.hscrollrecyclerview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;

/* compiled from: direct_video */
public class HScrollLinearLayoutManager extends LinearLayoutManager {
    public String f13813a;
    protected int[] f13814b;
    protected final HScrollRecyclerViewChildMeasurer f13815c;
    protected final HScrollDimensionCache f13816d;
    private final Context f13817e;
    public int f13818f = 0;
    public float f13819g = 50.0f;
    private CenterSmoothScroller f13820h;

    /* compiled from: direct_video */
    class CenterSmoothScroller extends LinearSmoothScroller {
        final /* synthetic */ HScrollLinearLayoutManager f13826a;

        public CenterSmoothScroller(HScrollLinearLayoutManager hScrollLinearLayoutManager, Context context) {
            this.f13826a = hScrollLinearLayoutManager;
            super(context);
        }

        public final PointF mo994a(int i) {
            return this.f13826a.d(i);
        }

        protected final float mo992a(DisplayMetrics displayMetrics) {
            return this.f13826a.f13819g / ((float) displayMetrics.densityDpi);
        }

        protected final int mo995b() {
            return -1;
        }

        public final int mo993a(View view, int i) {
            LayoutManager layoutManager = this.f13835c;
            if (!layoutManager.g()) {
                return 0;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return LinearSmoothScroller.m14604a(layoutManager.h(view) - layoutParams.leftMargin, layoutParams.rightMargin + layoutManager.j(view), layoutManager.y(), layoutManager.w() - layoutManager.A(), i) + this.f13826a.f13818f;
        }
    }

    public static HScrollLinearLayoutManager m14579b(InjectorLike injectorLike) {
        return new HScrollLinearLayoutManager((Context) injectorLike.getInstance(Context.class), HScrollRecyclerViewChildMeasurer.m14589a(injectorLike), HScrollDimensionCache.m14595a(injectorLike));
    }

    @Inject
    public HScrollLinearLayoutManager(Context context, HScrollRecyclerViewChildMeasurer hScrollRecyclerViewChildMeasurer, HScrollDimensionCache hScrollDimensionCache) {
        super(context);
        this.f13817e = context;
        this.f13815c = hScrollRecyclerViewChildMeasurer;
        this.f13816d = hScrollDimensionCache;
        this.f13820h = new CenterSmoothScroller(this, this.f13817e);
    }

    public void m14581a(Recycler recycler, State state, int i, int i2) {
        try {
            TracerDetour.a("HScrollLinearLayoutManager.onMeasure", 1247093235);
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if ((mode == 1073741824 && i() == 1) || (mode2 == 1073741824 && i() == 0)) {
                super.a(recycler, state, i, i2);
                return;
            }
            int[] a;
            int size = MeasureSpec.getSize(i);
            int size2 = MeasureSpec.getSize(i2);
            if (this.f13816d.m14598b(this.f13813a)) {
                a = this.f13816d.m14597a(this.f13813a);
            } else {
                a = new int[]{0, 0};
                if (D() > 0) {
                    for (int i3 = 0; i3 <= 0; i3++) {
                        this.f13814b = this.f13815c.m14592a(recycler, 0, MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                        if (i() == 0) {
                            a[0] = a[0] + this.f13814b[0];
                            a[1] = (this.f13814b[1] + z()) + B();
                        } else {
                            a[1] = a[1] + this.f13814b[1];
                            a[0] = (this.f13814b[0] + y()) + A();
                        }
                    }
                    if (!StringUtil.a(this.f13813a)) {
                        this.f13816d.m14596a(this.f13813a, a);
                    }
                }
            }
            switch (mode) {
                case 1073741824:
                    a[0] = size;
                    break;
            }
            switch (mode2) {
                case 1073741824:
                    a[1] = size2;
                    break;
            }
            e(a[0], a[1]);
            TracerDetour.a(-745998379);
        } finally {
            TracerDetour.a(-1621166693);
        }
    }

    public final void m14586c(Recycler recycler, State state) {
        TracerDetour.a("HScrollLinearLayoutManager.onLayoutChildren", 1212073609);
        try {
            super.c(recycler, state);
        } finally {
            TracerDetour.a(-1409936913);
        }
    }

    public final void m14585b(View view, int i, int i2) {
        TracerDetour.a("HScrollLinearLayoutManager.measureChildWithMargins", 888679902);
        try {
            super.b(view, i, i2);
        } finally {
            TracerDetour.a(-1827836387);
        }
    }

    public final void m14583a(View view, int i, int i2, int i3, int i4) {
        TracerDetour.a("HScrollLinearLayoutManager.layoutDecorated", 349556159);
        try {
            super.a(view, i, i2, i3, i4);
        } finally {
            TracerDetour.a(-693130089);
        }
    }

    public final void m14584b(View view) {
        TracerDetour.a("HScrollLinearLayoutManager.addView", 1984016728);
        try {
            super.b(view);
        } finally {
            TracerDetour.a(308297469);
        }
    }

    public final void m14587e(int i) {
        super.d(i, this.f13818f);
    }

    public final void m14582a(RecyclerView recyclerView, State state, int i) {
        this.f13820h.f13833a = i;
        a(this.f13820h);
    }

    public final void m14580a(double d) {
        if (d <= 0.0d) {
            d = 1.0d;
        }
        this.f13819g = (float) (50.0d / d);
        this.f13820h = new CenterSmoothScroller(this, this.f13817e);
    }
}
