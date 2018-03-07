package com.facebook.base.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment.C03941;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: profile/video/pick_thumbnail */
public class FbFragmentListenerDispatcher {
    private final Fragment f8882a;
    private final C03941 f8883b;
    @GuardedBy("this")
    private final Set<FbFragmentListener> f8884c = Sets.m1327c();
    @GuardedBy("this")
    private final Set<FbFragmentOverrider> f8885d = Sets.m1327c();

    public FbFragmentListenerDispatcher(Fragment fragment, C03941 c03941) {
        this.f8882a = fragment;
        this.f8883b = c03941;
    }

    public final synchronized void m13780a(FbFragmentListener fbFragmentListener) {
        this.f8884c.add(fbFragmentListener);
        if (fbFragmentListener instanceof AbstractFbFragmentOverrider) {
            AbstractFbFragmentOverrider abstractFbFragmentOverrider = (AbstractFbFragmentOverrider) fbFragmentListener;
            abstractFbFragmentOverrider.m16671f(this.f8882a);
            this.f8885d.add(abstractFbFragmentOverrider);
        }
    }

    public final synchronized void m13785b(FbFragmentListener fbFragmentListener) {
        this.f8884c.remove(fbFragmentListener);
        this.f8885d.remove(fbFragmentListener);
    }

    public final synchronized void m13775a() {
        for (FbFragmentListener a : this.f8884c) {
            a.mo2146a(this.f8882a);
        }
    }

    public final synchronized Optional<View> m13783b() {
        Optional<View> d;
        for (AbstractFbFragmentOverrider d2 : this.f8885d) {
            d = d2.m16669d();
            if (d != null) {
                break;
            }
        }
        d = null;
        return d;
    }

    public final synchronized boolean m13782a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        for (AbstractFbFragmentOverrider a : this.f8885d) {
            if (a.m16668a(this.f8882a, menu)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public final synchronized Optional<Boolean> m13774a(MenuItem menuItem) {
        Optional<Boolean> a;
        for (AbstractFbFragmentOverrider a2 : this.f8885d) {
            a = a2.m16666a(this.f8882a, menuItem);
            if (a.isPresent()) {
                break;
            }
        }
        a = Absent.withType();
        return a;
    }

    public final synchronized MenuInflater m13787c() {
        MenuInflater e;
        for (AbstractFbFragmentOverrider e2 : this.f8885d) {
            e = e2.m16670e();
            if (e != null) {
                break;
            }
        }
        e = null;
        return e;
    }

    public final synchronized Optional<View> m13773a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Optional<View> a;
        for (AbstractFbFragmentOverrider a2 : this.f8885d) {
            a = a2.m16667a(layoutInflater, viewGroup, bundle);
            if (a.isPresent()) {
                break;
            }
        }
        a = Absent.withType();
        return a;
    }

    public final synchronized void m13778a(@Nullable Bundle bundle) {
        for (FbFragmentListener a : this.f8884c) {
            a.mo2145a(bundle);
        }
    }

    public final synchronized void m13784b(@Nullable Bundle bundle) {
        for (FbFragmentListener a : this.f8884c) {
            a.mo2144a();
        }
    }

    public final synchronized void m13779a(View view, @Nullable Bundle bundle) {
        for (FbFragmentListener a : this.f8884c) {
            a.mo2135a(this.f8882a, view, bundle);
        }
    }

    public final synchronized void m13781a(boolean z) {
        Iterator it = this.f8884c.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final synchronized void m13789d() {
        for (FbFragmentListener d : this.f8884c) {
            d.mo2142d(this.f8882a);
        }
    }

    public final synchronized void m13790e() {
        for (FbFragmentListener c : this.f8884c) {
            c.mo2141c(this.f8882a);
        }
    }

    public final synchronized void m13791f() {
        for (FbFragmentListener b : this.f8884c) {
            b.mo2139b(this.f8882a);
        }
    }

    public final synchronized void m13792g() {
        for (FbFragmentListener e : this.f8884c) {
            e.mo2143e(this.f8882a);
        }
    }

    public final synchronized void m13793h() {
        for (FbFragmentListener c : this.f8884c) {
            c.mo2140c();
        }
    }

    public final synchronized void m13794i() {
        for (FbFragmentListener b : this.f8884c) {
            b.mo2137b();
        }
    }

    public final synchronized void m13776a(int i, int i2, Intent intent) {
        for (FbFragmentListener a : this.f8884c) {
            a.mo2133a(i, i2, intent);
        }
    }

    public final synchronized void m13777a(Configuration configuration) {
        for (FbFragmentListener a : this.f8884c) {
            a.mo2134a(configuration);
        }
    }

    public final synchronized void m13786b(boolean z) {
        for (FbFragmentListener a : this.f8884c) {
            a.mo2136a(z);
        }
    }

    public final synchronized void m13788c(Bundle bundle) {
        for (FbFragmentListener b : this.f8884c) {
            b.mo2138b(bundle);
        }
    }
}
