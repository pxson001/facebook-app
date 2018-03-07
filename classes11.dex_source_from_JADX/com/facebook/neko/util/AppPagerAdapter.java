package com.facebook.neko.util;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.ads.NativeAd;
import com.facebook.neko.util.AppCardFragment.AbstractAppUnitFactory;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: topContentSizeChange */
public class AppPagerAdapter extends FragmentStatePagerAdapter {
    private final HashMap<Integer, WeakReference<AppCardFragment>> f830a = new HashMap();
    public AppUnitState f831b = AppUnitState.Loading;
    private final AbstractAppUnitFactory f832c = new C01091(this);
    private final AbstractAppUnitFactory f833d = new C01102(this);
    public List<NativeAd> f834e = new LinkedList();
    public int f835f = 0;
    private boolean f836g = false;
    public OnClickListener f837h;

    /* compiled from: topContentSizeChange */
    class C01091 implements AbstractAppUnitFactory {
        final /* synthetic */ AppPagerAdapter f828a;

        C01091(AppPagerAdapter appPagerAdapter) {
            this.f828a = appPagerAdapter;
        }

        public final AbstractUnit mo10a(Context context, int i) {
            AbstractUnit appUnitLoading = new AppUnitLoading(context);
            AppPagerAdapter.m1120a(this.f828a, appUnitLoading, false, i);
            return appUnitLoading;
        }
    }

    /* compiled from: topContentSizeChange */
    class C01102 implements AbstractAppUnitFactory {
        final /* synthetic */ AppPagerAdapter f829a;

        C01102(AppPagerAdapter appPagerAdapter) {
            this.f829a = appPagerAdapter;
        }

        public final AbstractUnit mo10a(Context context, int i) {
            return new AppUnit(context);
        }
    }

    public AppPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public final void m1127a(boolean z) {
        AppUnitState appUnitState = this.f831b;
        this.f831b = AppUnitState.Error;
        this.f836g = z;
        if (appUnitState == AppUnitState.Loading) {
            m1121e();
            return;
        }
        this.f835f = 2;
        kR_();
    }

    public final void m1130d() {
        AppUnitState appUnitState = this.f831b;
        this.f831b = AppUnitState.Loading;
        if (appUnitState == AppUnitState.Error) {
            m1121e();
            return;
        }
        this.f835f = 2;
        kR_();
    }

    public final float m1129d(int i) {
        return 0.8f;
    }

    public final int m1128b() {
        return this.f835f;
    }

    public final Fragment m1123a(int i) {
        AppCardFragment appCardFragment = new AppCardFragment();
        appCardFragment.f824d = i;
        if (this.f831b != AppUnitState.Apps) {
            appCardFragment.f823c = this.f832c;
        } else {
            appCardFragment.f823c = this.f833d;
            appCardFragment.f822b = (NativeAd) this.f834e.get(i);
        }
        return appCardFragment;
    }

    public final Object m1124a(ViewGroup viewGroup, int i) {
        AppCardFragment appCardFragment = (AppCardFragment) super.a(viewGroup, i);
        this.f830a.put(Integer.valueOf(i), new WeakReference(appCardFragment));
        return appCardFragment;
    }

    public final void m1126a(ViewGroup viewGroup, int i, Object obj) {
        this.f830a.remove(Integer.valueOf(i));
        if (this.f831b == AppUnitState.Apps) {
            ((NativeAd) this.f834e.get(i)).l();
        }
        super.a(viewGroup, i, obj);
    }

    public final int m1122a(Object obj) {
        return -2;
    }

    private void m1121e() {
        for (Entry entry : this.f830a.entrySet()) {
            AppCardFragment appCardFragment = (AppCardFragment) ((WeakReference) entry.getValue()).get();
            if (appCardFragment != null && (appCardFragment.f821a instanceof AppUnitLoading)) {
                m1120a(this, (AppUnitLoading) appCardFragment.f821a, true, ((Integer) entry.getKey()).intValue());
            }
        }
    }

    public static void m1120a(AppPagerAdapter appPagerAdapter, AppUnitLoading appUnitLoading, boolean z, int i) {
        if (appPagerAdapter.f831b == AppUnitState.Loading) {
            appUnitLoading.mo12a(AppUnitState.Loading, z, appPagerAdapter.f836g);
        } else if (appPagerAdapter.f831b != AppUnitState.Error) {
        } else {
            if (i == 0) {
                appUnitLoading.mo12a(AppUnitState.Error, z, appPagerAdapter.f836g);
                appUnitLoading.f886e.setOnClickListener(appPagerAdapter.f837h);
                return;
            }
            appUnitLoading.mo12a(AppUnitState.Loading, z, appPagerAdapter.f836g);
            appUnitLoading.setShowLoading(false);
        }
    }

    public final void m1125a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public final Parcelable gG_() {
        return null;
    }
}
