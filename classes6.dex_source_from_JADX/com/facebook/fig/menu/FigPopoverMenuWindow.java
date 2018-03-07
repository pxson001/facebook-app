package com.facebook.fig.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.fbui.popover.PopoverListView;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.inject.FbInjector;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.facebook.ui.animations.AnimationUtil;

/* compiled from: mechanism_unknown */
public class FigPopoverMenuWindow extends PopoverMenuWindow {
    private static final SpringConfig f10516l = SpringConfig.a(15.0d, 7.0d);
    public static final SpringConfig f10517m = SpringConfig.a(80.0d, 7.0d);
    public AnimationUtil f10518n;
    public SpringSystem f10519o;
    public Drawable f10520p;

    /* compiled from: mechanism_unknown */
    public class ListSpringListener extends SimpleSpringListener {
        final /* synthetic */ FigPopoverMenuWindow f10508a;
        private PopoverListView f10509b;
        private boolean f10510c;
        private float f10511d;
        private float f10512e;

        public ListSpringListener(FigPopoverMenuWindow figPopoverMenuWindow) {
            this.f10508a = figPopoverMenuWindow;
        }

        public final void m16676c(Spring spring) {
            boolean z = true;
            this.f10509b = (PopoverListView) this.f10508a.f.getChildAt(0);
            this.f10510c = (((LayoutParams) this.f10508a.f.getLayoutParams()).gravity & 112) != 80;
            if (spring.i == 0.0d) {
                if (this.f10510c) {
                    z = false;
                }
                this.f10510c = z;
            }
            this.f10511d = -1.0f;
            AnimationUtil animationUtil = this.f10508a.f10518n;
            if (AnimationUtil.a()) {
                this.f10508a.f10518n.a(this.f10509b);
            }
        }

        public final void m16674a(Spring spring) {
            float d = (float) spring.d();
            int firstVisiblePosition = this.f10509b.getFirstVisiblePosition();
            int lastVisiblePosition = this.f10509b.getLastVisiblePosition();
            int i = (lastVisiblePosition - firstVisiblePosition) + 1;
            if (i != 0) {
                int i2;
                if (((double) d) < 0.5d) {
                    for (i2 = firstVisiblePosition; i2 <= lastVisiblePosition; i2++) {
                        this.f10509b.getChildAt(i2 - firstVisiblePosition).setAlpha(0.0f);
                    }
                    return;
                }
                if (this.f10511d < 0.0f) {
                    this.f10511d = d;
                    this.f10512e = ((float) (spring.f() - ((double) this.f10511d))) / ((float) i);
                }
                d -= this.f10511d;
                int i3 = (int) (d / this.f10512e);
                float a = (float) SpringUtil.a((double) d, (double) (((float) i3) * this.f10512e), (double) (((float) (i3 + 1)) * this.f10512e), 0.0d, 1.0d);
                if (this.f10510c) {
                    for (i2 = firstVisiblePosition; i2 < i3; i2++) {
                        View childAt = this.f10509b.getChildAt(i2 - firstVisiblePosition);
                        if (childAt != null) {
                            childAt.setAlpha(1.0f);
                        }
                    }
                    i2 = i3;
                } else {
                    i2 = lastVisiblePosition - i3;
                    for (i = lastVisiblePosition; i > i2; i--) {
                        View childAt2 = this.f10509b.getChildAt(i - firstVisiblePosition);
                        if (childAt2 != null) {
                            childAt2.setAlpha(1.0f);
                        }
                    }
                }
                View childAt3 = this.f10509b.getChildAt(i2);
                if (childAt3 != null) {
                    childAt3.setAlpha(a);
                }
            }
        }

        public final void m16675b(Spring spring) {
            AnimationUtil animationUtil = this.f10508a.f10518n;
            if (AnimationUtil.a()) {
                this.f10508a.f10518n.b(this.f10509b);
            }
            int firstVisiblePosition = this.f10509b.getFirstVisiblePosition();
            int lastVisiblePosition = this.f10509b.getLastVisiblePosition();
            if ((lastVisiblePosition - firstVisiblePosition) + 1 != 0) {
                for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                    View childAt = this.f10509b.getChildAt(i - firstVisiblePosition);
                    if (childAt != null) {
                        childAt.setAlpha(1.0f);
                    }
                }
            }
        }
    }

    /* compiled from: mechanism_unknown */
    public class ViewFlipperSpringListener extends SimpleSpringListener {
        public final /* synthetic */ FigPopoverMenuWindow f10513a;
        public View f10514b;
        public int f10515c;

        public ViewFlipperSpringListener(FigPopoverMenuWindow figPopoverMenuWindow) {
            this.f10513a = figPopoverMenuWindow;
        }

        public final void m16679c(Spring spring) {
            this.f10515c = this.f10513a.f.getMeasuredHeight();
            this.f10514b = new View(this.f10513a.getContext());
            if (VERSION.SDK_INT >= 16) {
                this.f10514b.setBackground(this.f10513a.f10520p);
            } else {
                this.f10514b.setBackgroundDrawable(this.f10513a.f10520p);
            }
            this.f10514b.setPadding(this.f10513a.f.getPaddingLeft(), this.f10513a.f.getPaddingTop(), this.f10513a.f.getPaddingRight(), this.f10513a.f.getPaddingBottom());
            this.f10514b.setPivotX(this.f10513a.f.getPivotX());
            this.f10514b.setPivotY(this.f10513a.f.getPivotY());
            LayoutParams layoutParams = (LayoutParams) this.f10513a.f.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(this.f10513a.f.getMeasuredWidth(), this.f10515c);
            layoutParams2.gravity = layoutParams.gravity;
            layoutParams2.leftMargin = layoutParams.leftMargin;
            layoutParams2.rightMargin = layoutParams.rightMargin;
            this.f10513a.g.addView(this.f10514b, 0, layoutParams2);
            this.f10513a.f.setBackgroundDrawable(null);
        }

        public final void m16677a(Spring spring) {
            float d = (float) spring.d();
            if (d > 0.0f || spring.f() != 0.0d) {
                if (((double) d) < 0.5d) {
                    float a = (float) SpringUtil.a((double) d, 0.0d, 0.5d, 0.0d, 1.0d);
                    this.f10514b.setAlpha((float) SpringUtil.a((double) a, 0.0d, 1.0d));
                    this.f10514b.setScaleX((float) SpringUtil.a((double) a, 0.0d, 1.0d, 0.6d, 1.0d));
                    this.f10514b.getLayoutParams().height = Math.round(((float) SpringUtil.a((double) a, 0.0d, 1.0d, 0.2d, 0.65d)) * ((float) this.f10515c));
                } else {
                    this.f10514b.setAlpha(1.0f);
                    this.f10514b.setScaleX(1.0f);
                    d = (float) SpringUtil.a((double) d, 0.5d, 1.0d, 0.65d, 1.0d);
                    this.f10514b.getLayoutParams().height = Math.round(d * ((float) this.f10515c));
                }
                this.f10514b.requestLayout();
                return;
            }
            spring.l();
        }

        public final void m16678b(Spring spring) {
            if (VERSION.SDK_INT >= 16) {
                this.f10513a.f.setBackground(this.f10513a.f10520p);
            } else {
                this.f10513a.f.setBackgroundDrawable(this.f10513a.f10520p);
            }
            this.f10513a.g.removeView(this.f10514b);
        }
    }

    public FigPopoverMenuWindow(Context context) {
        this(context, 0);
    }

    public FigPopoverMenuWindow(Context context, int i) {
        super(context);
        FbInjector fbInjector = FbInjector.get(getContext());
        d(2131624492);
        this.f10518n = AnimationUtil.a(fbInjector);
        this.f10519o = SpringSystem.b(fbInjector);
        this.f10520p = this.f.getBackground();
    }

    public final void m16681a(View view) {
        m16680s();
        super.a(view);
    }

    public final void m16682d() {
        m16680s();
        super.d();
    }

    public final void m16683l() {
        Spring a = this.f10519o.a().a(f10517m);
        a.c = false;
        a = a.a(1.0d).b(1.0d).l();
        a.a(new ViewFlipperSpringListener(this));
        a.a(new ListSpringListener(this));
        this.f.h = a;
        super.l();
    }

    private void m16680s() {
        Spring a = this.f10519o.a().a(f10516l);
        a.c = false;
        a = a.a(0.0d).b(0.0d).l();
        a.a(new ViewFlipperSpringListener(this));
        a.a(new ListSpringListener(this));
        a(a);
    }
}
