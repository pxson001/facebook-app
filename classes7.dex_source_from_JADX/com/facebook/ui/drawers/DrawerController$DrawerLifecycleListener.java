package com.facebook.ui.drawers;

import android.os.Bundle;
import com.facebook.virtuallifecycle.AbstractFragmentLifecycleListener;
import java.util.Iterator;

/* compiled from: ensureSync full refresh delayed because it was already performed recently. */
public class DrawerController$DrawerLifecycleListener extends AbstractFragmentLifecycleListener {
    final /* synthetic */ DrawerController f15265a;

    /* compiled from: ensureSync full refresh delayed because it was already performed recently. */
    class C11441 implements Runnable {
        final /* synthetic */ DrawerController$DrawerLifecycleListener f15264a;

        C11441(DrawerController$DrawerLifecycleListener drawerController$DrawerLifecycleListener) {
            this.f15264a = drawerController$DrawerLifecycleListener;
        }

        public void run() {
            this.f15264a.f15265a.a(false);
        }
    }

    public DrawerController$DrawerLifecycleListener(DrawerController drawerController) {
        this.f15265a = drawerController;
    }

    public final void mo1181a(Bundle bundle) {
        DrawerController.q(this.f15265a);
        m19252c(bundle);
    }

    public final void mo1180a() {
        DrawerController.q(this.f15265a);
        m19252c(m19253g());
        if (this.f15265a.m != null) {
            Iterator it = this.f15265a.m.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void mo1182b() {
        DrawerState drawerState = this.f15265a.p;
        DrawerController.q(this.f15265a);
        this.f15265a.g.m19276a(drawerState, false);
    }

    public final void mo1183b(Bundle bundle) {
        bundle.putSerializable("drawer_state", this.f15265a.p);
    }

    public final void mo1184c() {
        if (this.f15265a.m != null) {
            Iterator it = this.f15265a.m.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (this.f15265a.r) {
            this.f15265a.r = false;
            this.f15265a.b.a(new C11441(this), 500);
        }
    }

    public final void mo1185d() {
        this.f15265a.e();
        super.mo1185d();
    }

    private Bundle m19253g() {
        return this.f15265a.l.s;
    }

    public static void m19251a(DrawerController$DrawerLifecycleListener drawerController$DrawerLifecycleListener, DrawerState drawerState) {
        drawerController$DrawerLifecycleListener.m19253g().putSerializable("drawer_state", drawerState);
    }

    private void m19252c(Bundle bundle) {
        if (bundle.containsKey("drawer_state")) {
            this.f15265a.g.m19276a((DrawerState) bundle.getSerializable("drawer_state"), false);
        }
    }
}
