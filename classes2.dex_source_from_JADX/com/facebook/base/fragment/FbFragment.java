package com.facebook.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.queryinterface.ProvidesInterface;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: profile_id */
public class FbFragment extends Fragment implements FragmentManagerHost, ProvidesInterface, InjectableComponentWithContext {
    private FbFragmentListenerDispatcher f8871a;
    private LayoutInflater f8872b;

    /* compiled from: profile_id */
    public class C03941 {
        final /* synthetic */ FbFragment f8886a;

        public C03941(FbFragment fbFragment) {
            this.f8886a = fbFragment;
        }
    }

    public final void m13758a(FbFragmentListener fbFragmentListener) {
        this.f8871a.m13780a(fbFragmentListener);
    }

    public final void m13761b(FbFragmentListener fbFragmentListener) {
        this.f8871a.m13785b(fbFragmentListener);
    }

    public final void mo15a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1832933768);
        super.mo15a(bundle);
        this.f8871a = new FbFragmentListenerDispatcher(this, new C03941(this));
        mo1859c(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1217939623, a);
    }

    public void mo1859c(@Nullable Bundle bundle) {
    }

    @Deprecated
    public final FbInjector an() {
        return FbInjector.get(getContext());
    }

    protected final void mo1876j(@Nullable Bundle bundle) {
        TracerDetour.a("%s.onCreate", getClass().getSimpleName(), 890332932);
        try {
            super.mo1876j(bundle);
        } finally {
            TracerDetour.a(-910621983);
        }
    }

    public final LayoutInflater mo17b(@Nullable Bundle bundle) {
        if (this.f8872b == null) {
            LayoutInflater b = super.mo17b(bundle);
            Fragment fragment = this.f103G;
            if (fragment == null || fragment.getContext() == getContext()) {
                this.f8872b = b;
            } else {
                this.f8872b = b.cloneInContext(fragment.getContext());
            }
        }
        return this.f8872b;
    }

    protected View mo1873c(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        TracerDetour.a("%s.onCreateView", getClass().getSimpleName(), 1731305164);
        try {
            View view;
            Optional a = this.f8871a.m13773a(layoutInflater, viewGroup, bundle);
            if (a.isPresent()) {
                view = (View) a.get();
            } else {
                view = super.mo1873c(layoutInflater, viewGroup, bundle);
            }
            TracerDetour.a(-1688174016);
            return view;
        } catch (Throwable th) {
            TracerDetour.a(878642236);
        }
    }

    protected final void mo1878l(@Nullable Bundle bundle) {
        TracerDetour.a("%s.onActivityCreated", getClass().getSimpleName(), 61408314);
        try {
            this.f8871a.m13778a(bundle);
            super.mo1878l(bundle);
            this.f8871a.m13784b(bundle);
        } finally {
            TracerDetour.a(106969809);
        }
    }

    protected final void mo1862U() {
        TracerDetour.a("%s.onStart", getClass().getSimpleName(), 1062619519);
        try {
            super.mo1862U();
            this.f8871a.m13793h();
        } finally {
            TracerDetour.a(1962691170);
        }
    }

    protected final void mo1863W() {
        TracerDetour.a("%s.onResume", getClass().getSimpleName(), -1295259735);
        try {
            super.mo1863W();
            this.f8871a.m13789d();
        } finally {
            TracerDetour.a(1112824631);
        }
    }

    protected final void af() {
        TracerDetour.a("%s.onPause", getClass().getSimpleName(), 1373304287);
        try {
            super.af();
            this.f8871a.m13790e();
        } finally {
            TracerDetour.a(-764443267);
        }
    }

    protected final void ah() {
        TracerDetour.a("%s.onStop", getClass().getSimpleName(), -499581219);
        try {
            super.ah();
            this.f8871a.m13794i();
        } finally {
            TracerDetour.a(-2105651370);
        }
    }

    protected final void ak() {
        TracerDetour.a("%s.onDestroyView", getClass().getSimpleName(), 660815200);
        try {
            super.ak();
            this.f8871a.m13791f();
        } finally {
            TracerDetour.a(472916084);
        }
    }

    protected final void am() {
        TracerDetour.a("%s.onDestroy", getClass().getSimpleName(), -1835917242);
        try {
            super.am();
            this.f8871a.m13792g();
        } finally {
            TracerDetour.a(-1189961606);
        }
    }

    protected final void mo1864Z() {
        if (this.f8871a != null) {
            this.f8871a.m13775a();
        }
        super.mo1864Z();
    }

    public void mo1865a(View view, @Nullable Bundle bundle) {
        TracerDetour.a("%s: FbFragment.onViewCreated", getClass().getSimpleName(), -1211154469);
        try {
            super.mo1865a(view, bundle);
            this.f8871a.m13779a(view, bundle);
        } finally {
            TracerDetour.a(1625298970);
        }
    }

    public void mo1875c(boolean z) {
        super.mo1875c(z);
        if (this.f8871a != null) {
            this.f8871a.m13781a(z);
        }
    }

    public void mo1858a(int i, int i2, Intent intent) {
        super.mo1858a(i, i2, intent);
        if (this.f8871a != null) {
            this.f8871a.m13776a(i, i2, intent);
        }
    }

    protected final View ab() {
        Optional b = this.f8871a.m13783b();
        return b != null ? (View) b.orNull() : super.ab();
    }

    protected final void mo1874c(Menu menu, MenuInflater menuInflater) {
        if (!this.f8871a.m13782a(menu, menuInflater)) {
            super.mo1874c(menu, menuInflater);
        }
    }

    public boolean a_(MenuItem menuItem) {
        Optional a = this.f8871a.m13774a(menuItem);
        return a.isPresent() ? ((Boolean) a.get()).booleanValue() : super.a_(menuItem);
    }

    protected final MenuInflater ad() {
        MenuInflater c = this.f8871a.m13787c();
        return c != null ? c : super.ad();
    }

    public void mo1860g(boolean z) {
        super.mo1860g(z);
        if (this.f8871a != null) {
            this.f8871a.m13786b(z);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.f8871a != null) {
            this.f8871a.m13777a(configuration);
        }
    }

    public void mo20e(Bundle bundle) {
        super.mo20e(bundle);
        if (this.f8871a != null) {
            this.f8871a.m13788c(bundle);
        }
    }

    public final Activity ao() {
        return (Activity) ContextUtils.m2500a(getContext(), Activity.class);
    }

    public final boolean ap() {
        return ContextUtils.m2500a(getContext(), Activity.class) != null;
    }

    public final <T> T mo817a(Class<? extends T> cls) {
        T b = m13760b((Class) cls);
        if (b != null) {
            return b;
        }
        Fragment fragment = this.f103G;
        if (fragment instanceof ProvidesInterface) {
            return ((ProvidesInterface) fragment).mo817a(cls);
        }
        Context context = getContext();
        if (context instanceof ProvidesInterface) {
            return ((ProvidesInterface) context).mo817a(cls);
        }
        return null;
    }

    protected <T> T m13760b(Class<? extends T> cls) {
        return cls.isInstance(this) ? this : null;
    }

    public final void gE_() {
        m224C();
    }

    public final FragmentManager kO_() {
        return this.f100D;
    }

    public boolean hn_() {
        return !this.f136x && mx_() && !this.f108L && m282z();
    }

    public <T extends View> T m13766e(int i) {
        return FindViewUtil.m6202b(this.f116T, i);
    }

    public <T extends View> Optional<T> m13768f(int i) {
        return FindViewUtil.m6200a(this.f116T, i);
    }
}
