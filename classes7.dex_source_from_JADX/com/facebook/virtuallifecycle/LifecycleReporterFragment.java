package com.facebook.virtuallifecycle;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;

/* compiled from: descriptor must not be null */
public class LifecycleReporterFragment extends FbFragment {
    private static final Class<?> f15830a = LifecycleReporterFragment.class;
    private AbstractFragmentLifecycleListener f15831b = null;

    public static LifecycleReporterFragment m19791a(FragmentManager fragmentManager, AbstractFragmentLifecycleListener abstractFragmentLifecycleListener, String str) {
        LifecycleReporterFragment lifecycleReporterFragment = (LifecycleReporterFragment) fragmentManager.a(str);
        if (lifecycleReporterFragment == null || lifecycleReporterFragment.f15831b == null) {
            LifecycleReporterFragment lifecycleReporterFragment2 = new LifecycleReporterFragment();
            lifecycleReporterFragment2.f15831b = abstractFragmentLifecycleListener;
            FragmentTransaction a = fragmentManager.a();
            if (lifecycleReporterFragment != null) {
                a.a(lifecycleReporterFragment);
                lifecycleReporterFragment2.g(lifecycleReporterFragment.s);
            } else {
                lifecycleReporterFragment2.g(new Bundle());
            }
            a.a(lifecycleReporterFragment2, str).b();
            return lifecycleReporterFragment2;
        } else if (lifecycleReporterFragment.f15831b == abstractFragmentLifecycleListener) {
            return lifecycleReporterFragment;
        } else {
            throw new IllegalArgumentException("LifecycleReporterFragment.ensureAttached was called twice with the same fragmentTag,but different FragmentLifecycleListeners.");
        }
    }

    public final void a_(Context context) {
        super.a_(context);
    }

    public final void m19796a(Fragment fragment) {
        super.a(fragment);
    }

    public final void m19800c(@Nullable Bundle bundle) {
        super.c(bundle);
        if (this.f15831b != null) {
            this.f15831b.mo1181a(this.s);
        }
    }

    public final void m19801d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1644233079);
        super.d(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1098289223, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 116114413);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1688984554, a);
    }

    public final void m19792G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 571954150);
        super.G();
        if (this.f15831b != null) {
            this.f15831b.mo1180a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -936742685, a);
    }

    public final void m19802e(Bundle bundle) {
        if (this.f15831b != null) {
            this.f15831b.mo1183b(this.s);
        }
        super.e(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f15831b != null) {
            this.f15831b.mo1182b();
        }
    }

    public final void m19793H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1519943674);
        if (this.f15831b != null) {
            this.f15831b.mo1184c();
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1168834744, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -128706987);
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2146471923, a);
    }

    public void onLowMemory() {
        super.onLowMemory();
    }

    public final void m19794I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 929448184);
        if (this.f15831b != null) {
            this.f15831b.mo1185d();
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1575212282, a);
    }

    public final void dE_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1211422338);
        super.dE_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 442110471, a);
    }

    public final void m19798a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
    }

    public final void m19797a(Menu menu) {
        super.a(menu);
    }

    public final void m19795K() {
    }

    public final boolean a_(MenuItem menuItem) {
        if (this.f15831b != null) {
            AbstractFragmentLifecycleListener abstractFragmentLifecycleListener = this.f15831b;
            if (null != null) {
                return true;
            }
        }
        return super.a_(menuItem);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public final boolean m19799b(MenuItem menuItem) {
        if (this.f15831b != null) {
            AbstractFragmentLifecycleListener abstractFragmentLifecycleListener = this.f15831b;
            if (null != null) {
                return true;
            }
        }
        return super.b(menuItem);
    }
}
