package com.facebook.neko.util;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdsManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: topError */
public class MainActivityFragment extends Fragment {
    private static final String f900a = MainActivityFragment.class.getName();
    private final OnPageChangeListener f901b = new C01151(this);
    private final OnClickListener f902c = new C01162(this);
    private NativeAdsManager f903d;
    public AppCardPager f904e;
    public AppPagerAdapter f905f;
    public OnAppLogListener f906g;

    /* compiled from: topError */
    public interface OnAppLogListener {
        void mo7a();

        void mo8a(Map<String, String> map);

        void mo9b();
    }

    /* compiled from: topError */
    class C01151 extends SimpleOnPageChangeListener {
        final /* synthetic */ MainActivityFragment f897a;
        private int f898b = 0;

        C01151(MainActivityFragment mainActivityFragment) {
            this.f897a = mainActivityFragment;
        }

        public final void m1164b(int i) {
            if (i == 0) {
                NativeAd nativeAd;
                Map hashMap = new HashMap();
                int i2 = this.f897a.f904e.k;
                AppPagerAdapter appPagerAdapter = this.f897a.f905f;
                if (i2 < 0 || i2 >= appPagerAdapter.f834e.size()) {
                    nativeAd = null;
                } else {
                    nativeAd = (NativeAd) appPagerAdapter.f834e.get(i2);
                }
                NativeAd nativeAd2 = nativeAd;
                int i3 = i2 - this.f898b;
                this.f898b = i2;
                hashMap.put("position", Integer.toString(i2));
                hashMap.put("direction", Integer.toString(i3));
                if (nativeAd2 != null) {
                    hashMap.put("adID", nativeAd2.g());
                }
                this.f897a.f906g.mo8a(hashMap);
            }
        }
    }

    /* compiled from: topError */
    class C01162 implements OnClickListener {
        final /* synthetic */ MainActivityFragment f899a;

        C01162(MainActivityFragment mainActivityFragment) {
            this.f899a = mainActivityFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -462130928);
            this.f899a.f905f.m1130d();
            this.f899a.f905f;
            Logger.a(2, EntryType.UI_INPUT_END, -1333358252, a);
        }
    }

    public final View m1172a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1555969100);
        View inflate = layoutInflater.inflate(2130904422, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -693335684, a);
        return inflate;
    }

    public final void m1175a(View view, Bundle bundle) {
        super.a(view, bundle);
        m1169c();
        this.f905f;
    }

    public final void m1174a(Activity activity) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -736187442);
        super.a(activity);
        if (activity instanceof OnAppLogListener) {
            this.f906g = (OnAppLogListener) activity;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 908750800, a);
    }

    public static void m1167b(MainActivityFragment mainActivityFragment) {
        mainActivityFragment.f903d = new NativeAdsManager(mainActivityFragment.o(), "184069175262368_184069815262304", 10);
        mainActivityFragment.f903d.g = mainActivityFragment;
        mainActivityFragment.f903d.a();
        Log.i(f900a, String.format("Attempting load of %d ads in placement %s", new Object[]{Integer.valueOf(10), "184069175262368_184069815262304"}));
    }

    private void m1169c() {
        this.f905f = new AppPagerAdapter(s());
        this.f905f.m1130d();
        this.f905f.f837h = this.f902c;
        this.f904e = (AppCardPager) this.T.findViewById(2131562158);
        this.f904e.setOnPageChangeListener(this.f901b);
        this.f904e.setAdapter(this.f905f);
        this.f904e.setPageMargin((int) jW_().getDimension(2131434371));
        this.f904e.setOffscreenPageLimit(3);
        this.f904e.f827c = AppUnitState.Loading;
    }

    public final void m1173a() {
        if (this.f903d.b() != 0) {
            Log.i(f900a, String.format("Loaded %d ads", new Object[]{Integer.valueOf(this.f903d.b())}));
            AppPagerAdapter appPagerAdapter = this.f905f;
            NativeAdsManager nativeAdsManager = this.f903d;
            appPagerAdapter.f831b = AppUnitState.Apps;
            appPagerAdapter.f834e.clear();
            appPagerAdapter.f835f = nativeAdsManager.b();
            for (int i = 0; i < appPagerAdapter.f835f; i++) {
                NativeAd nativeAd;
                List list = appPagerAdapter.f834e;
                if (nativeAdsManager.e.size() == 0) {
                    nativeAd = null;
                } else {
                    int i2 = nativeAdsManager.f;
                    nativeAdsManager.f = i2 + 1;
                    nativeAd = (NativeAd) nativeAdsManager.e.get(i2 % nativeAdsManager.e.size());
                    if (i2 >= nativeAdsManager.e.size()) {
                        nativeAd = new NativeAd(nativeAd);
                    }
                }
                list.add(nativeAd);
            }
            appPagerAdapter.kR_();
            this.f904e.f827c = AppUnitState.Apps;
            return;
        }
        Log.w(f900a, "Successful ad request with 0 fill");
        if (this.f906g != null) {
            this.f906g.mo9b();
        }
        this.f905f.m1127a(true);
        this.f904e.f827c = AppUnitState.Error;
    }

    public final void m1176a(AdError adError) {
        Log.w(f900a, "Encountered ad loading error '" + adError.h + "'");
        if (this.f906g != null) {
            this.f906g.mo7a();
        }
        this.f904e.f827c = AppUnitState.Error;
        if (adError.g == 1005) {
            this.f905f.m1127a(false);
        } else {
            this.f905f.m1127a(true);
        }
    }

    public final void m1171I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -88637126);
        if (this.f903d != null) {
            this.f903d.g = null;
        }
        this.f903d = null;
        this.f904e = null;
        this.f905f = null;
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 769111756, a);
    }
}
