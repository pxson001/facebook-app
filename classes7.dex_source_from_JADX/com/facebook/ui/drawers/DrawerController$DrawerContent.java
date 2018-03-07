package com.facebook.ui.drawers;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;

/* compiled from: ensureSync full refresh delayed because it was already performed recently. */
public class DrawerController$DrawerContent {
    public final /* synthetic */ DrawerController f15256a;
    public Drawer f15257b;
    public CustomFrameLayout f15258c = null;
    public BaseDrawerContentController f15259d = null;
    public int f15260e = -1;
    public int f15261f = -1;
    public View f15262g = null;
    public boolean f15263h;

    public DrawerController$DrawerContent(DrawerController drawerController, Drawer drawer, BaseDrawerContentController baseDrawerContentController) {
        this.f15256a = drawerController;
        this.f15257b = drawer;
        this.f15259d = baseDrawerContentController;
        this.f15263h = false;
    }

    public final boolean m19242a(BaseDrawerContentController baseDrawerContentController) {
        return this.f15259d == baseDrawerContentController;
    }

    public final void m19241a(boolean z) {
        boolean z2;
        if (this.f15258c == null || this.f15258c.getVisibility() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z != z2) {
            String str;
            if (this.f15258c == null) {
                m19243b();
            }
            Class cls = DrawerController.a;
            StringBuilder append = new StringBuilder().append(this.f15257b).append(" visibility changed: ");
            if (z) {
                str = "VISIBLE";
            } else {
                str = "INVISIBLE";
            }
            append.append(str);
            this.f15258c.setVisibility(z ? 0 : 4);
            this.f15259d.a(z);
        }
    }

    public final void m19244b(boolean z) {
        if (z != this.f15263h) {
            String str;
            Class cls = DrawerController.a;
            StringBuilder append = new StringBuilder().append(this.f15257b).append(" focus changed: ");
            if (z) {
                str = "FOCUSED";
            } else {
                str = "UNFOCUSED";
            }
            append.append(str);
            this.f15263h = z;
            this.f15259d.b(z);
        }
    }

    public final void m19243b() {
        View childAt;
        int i;
        if (this.f15256a.h == DrawerController$BackgroundStrategy.ENSURE_BACKGROUND) {
            childAt = this.f15256a.g.getChildAt(0);
            if (childAt.getBackground() == null) {
                DrawerController.a(this.f15256a, childAt, childAt, null);
            }
        }
        if (this.f15258c == null) {
            this.f15258c = new CustomFrameLayout(this.f15256a.e);
            this.f15258c.setId(this.f15257b == Drawer.LEFT ? 2131558748 : 2131558749);
            this.f15258c.setVisibility(4);
        }
        Object obj = null;
        Resources resources = this.f15256a.e.getResources();
        int i2 = resources.getDisplayMetrics().widthPixels;
        if (this.f15260e < 0 || i2 != this.f15261f) {
            this.f15261f = i2;
            i2 = this.f15259d.a(this.f15256a.e, i2 - resources.getDimensionPixelSize(2131431923));
            Preconditions.checkArgument(i2 >= 0, "Drawer width cannot be less than 0");
            if (i2 != this.f15260e) {
                this.f15260e = i2;
                LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f15260e, -1);
                layoutParams.gravity = this.f15257b == Drawer.LEFT ? 3 : 5;
                this.f15258c.setLayoutParams(layoutParams);
                int i3 = 1;
            }
        }
        Object obj2 = obj;
        if (this.f15258c.getChildCount() == 0) {
            BaseDrawerContentController baseDrawerContentController = this.f15259d;
            Context context = this.f15256a.e;
            CustomFrameLayout customFrameLayout = this.f15258c;
            Preconditions.checkArgument(baseDrawerContentController.e == null, "Root view has already been created.");
            baseDrawerContentController.e = baseDrawerContentController.a(context);
            childAt = baseDrawerContentController.e;
            Preconditions.checkNotNull(childAt, "You must return a view when implementing DrawerContentController.onCreateView");
            DrawerController.a(this.f15256a, this.f15258c, childAt, Integer.valueOf(2131363504));
            this.f15258c.addView(childAt);
        }
        if (this.f15258c.getParent() == null) {
            i = 1;
            this.f15256a.f.addView(this.f15258c, 0);
        } else {
            i = 0;
        }
        if (this.f15262g == null) {
            this.f15262g = new View(this.f15256a.e);
            this.f15262g.setBackgroundResource(this.f15257b == Drawer.LEFT ? 2130838457 : 2130838458);
        }
        if (this.f15262g.getParent() == null) {
            int dimensionPixelSize = this.f15256a.e.getResources().getDimensionPixelSize(2131431922);
            LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimensionPixelSize, -1);
            switch (DrawerController$1.f15254a[this.f15257b.ordinal()]) {
                case 1:
                    layoutParams2.gravity = 3;
                    layoutParams2.leftMargin = -dimensionPixelSize;
                    break;
                case 2:
                    layoutParams2.gravity = 5;
                    layoutParams2.rightMargin = -dimensionPixelSize;
                    break;
            }
            this.f15262g.setLayoutParams(layoutParams2);
            this.f15256a.g.addView(this.f15262g);
        }
        if (obj2 != null) {
            switch (DrawerController$1.f15254a[this.f15257b.ordinal()]) {
                case 1:
                    this.f15256a.g.setLeftDrawerWidth(this.f15260e);
                    break;
                case 2:
                    this.f15256a.g.setRightDrawerWidth(this.f15260e);
                    break;
            }
        }
        if (i != 0) {
            this.f15259d.lb_();
        }
    }

    @TargetApi(16)
    public static void m19240a(View view) {
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeAllViews();
            }
            if (VERSION.SDK_INT >= 16) {
                view.setBackground(null);
            } else {
                view.setBackgroundDrawable(null);
            }
        }
    }
}
