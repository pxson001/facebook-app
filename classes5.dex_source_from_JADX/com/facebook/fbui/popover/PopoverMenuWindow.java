package com.facebook.fbui.popover;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.menu.PopoverMenu.Callback;
import com.facebook.fbui.menu.PopoverMenu.MenuPresenter;
import com.facebook.fbui.menu.PopoverMenuInflater;
import com.facebook.fbui.popover.PopoverViewFlipper.TransitionType;

/* compiled from: You must call setSoftMaximumLatencyMs(long) or setHardMaximumLatencyMs(long) */
public class PopoverMenuWindow extends PopoverWindow implements Callback, MenuPresenter {
    public boolean f12170a;
    private PopoverMenu f12171l;
    public PopoverMenuInflater f12172m;
    public CharSequence f12173n;
    public View f12174o;
    public OnMenuItemClickListener f12175p;

    /* compiled from: You must call setSoftMaximumLatencyMs(long) or setHardMaximumLatencyMs(long) */
    public interface OnMenuItemClickListener {
        boolean m20193a(MenuItem menuItem);
    }

    public PopoverMenuWindow(Context context) {
        this(context, 0);
    }

    public PopoverMenuWindow(Context context, int i) {
        super(context, m20177a(context, i));
        if (this.f != null) {
            a(TransitionType.SLIDE_UP);
        }
        c(true);
        this.f12170a = false;
    }

    private static int m20177a(Context context, int i) {
        if (i == 1) {
            return 2131624491;
        }
        if (i == 2) {
            return 2131624493;
        }
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130772483, typedValue, true);
        return typedValue.resourceId;
    }

    public final PopoverMenu m20187c() {
        if (this.f12171l == null) {
            m20180a(new PopoverMenu(getContext()));
        }
        return this.f12171l;
    }

    public final void m20180a(PopoverMenu popoverMenu) {
        this.f12171l = popoverMenu;
        this.f12171l.m20167a((Callback) this);
        this.f12171l.m20168a((MenuPresenter) this);
    }

    public final void m20186b(int i) {
        if (this.f12172m == null) {
            this.f12172m = new PopoverMenuInflater(getContext());
        }
        this.f12172m.inflate(i, m20187c());
    }

    public final void m20182a(OnMenuItemClickListener onMenuItemClickListener) {
        this.f12175p = onMenuItemClickListener;
    }

    public final boolean mo1220a(MenuItem menuItem) {
        if (this.f12175p != null) {
            return this.f12175p.m20193a(menuItem);
        }
        return false;
    }

    protected PopoverListView mo1221b() {
        if (this.f12171l == null || !this.f12171l.hasVisibleItems()) {
            return null;
        }
        PopoverListView popoverListView = new PopoverListView(getContext());
        if (this.f12174o != null) {
            popoverListView.setCustomTitleView(this.f12174o);
        } else {
            popoverListView.setTitle(this.f12173n);
        }
        popoverListView.setAdapter(this.f12171l);
        popoverListView.setOnItemClickListener(this.f12171l);
        popoverListView.m20176a(this.f12170a);
        popoverListView.setShowFullWidth(this.e);
        popoverListView.setMaxWidth(this.c);
        View h = h();
        if (h == null || ViewCompat.r(popoverListView) != 0) {
            return popoverListView;
        }
        popoverListView.setMinimumWidth(h.getWidth());
        return popoverListView;
    }

    public void m20189d() {
        View b = mo1221b();
        if (b != null) {
            if (this.r) {
                e(b);
                e();
                return;
            }
            d(b);
            super.d();
        }
    }

    public void m20179a(View view) {
        View b = mo1221b();
        if (b != null) {
            if (this.r) {
                e(b);
                e();
                return;
            }
            d(b);
            super.a(view);
        }
    }

    public final void mo1219a(PopoverMenu popoverMenu, boolean z) {
        m20180a(popoverMenu);
        if (z) {
            d();
        } else {
            f();
        }
    }

    public final void mo1218a() {
        l();
    }

    public final void m20183a(boolean z) {
        if (this.f12170a != z) {
            this.f12170a = z;
        }
    }

    public final void m20190e() {
        a(TransitionType.SLIDE_UP);
        super.e();
    }

    public final void m20191f() {
        a(TransitionType.SLIDE_DOWN);
        super.f();
    }

    public final void m20188c(int i) {
        this.f12173n = getContext().getString(i);
    }
}
