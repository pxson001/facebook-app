package com.facebook.ui.drawers;

import android.content.Context;
import android.view.View;
import com.facebook.common.executors.DefaultAndroidThreadUtil;

/* compiled from: queue */
public abstract class BaseDrawerContentController {
    public boolean f8386a = false;
    public boolean f8387b = false;
    public Context f8388c = null;
    public DrawerController f8389d = null;
    public View f8390e = null;
    protected DefaultAndroidThreadUtil f8391f = null;

    public abstract int mo1731a(Context context, int i);

    public abstract View mo1739a(Context context);

    public abstract void lb_();

    public BaseDrawerContentController(DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f8391f = defaultAndroidThreadUtil;
    }

    public void mo1733a(DrawerController drawerController) {
        this.f8389d = drawerController;
        this.f8388c = this.f8389d.f8398e;
    }

    public void mo1736b(DrawerController drawerController) {
        this.f8389d = null;
        this.f8388c = null;
        this.f8390e = null;
    }

    public void mo1734a(boolean z) {
        this.f8386a = z;
    }

    public void mo1740b(boolean z) {
        this.f8387b = z;
    }

    public boolean ld_() {
        return false;
    }

    public final boolean m12922e() {
        return this.f8389d != null;
    }

    public final boolean m12923f() {
        return (this.f8388c == null || this.f8390e == null) ? false : true;
    }
}
