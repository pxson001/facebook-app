package com.facebook.katana.activity.photos;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.List;
import java.util.Locale;

/* compiled from: zoomEnabled */
public class PhotosTabFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private final Context f52a;
    private final List<TabInfo> f53b;

    /* compiled from: zoomEnabled */
    public class TabInfo {
        public final String f48a;
        public final int f49b;
        public final Class<? extends Fragment> f50c;
        public final Bundle f51d;

        public TabInfo(String str, int i, Class<? extends Fragment> cls, Bundle bundle) {
            this.f48a = str;
            this.f49b = i;
            this.f50c = cls;
            this.f51d = bundle;
        }
    }

    public PhotosTabFragmentPagerAdapter(FragmentManager fragmentManager, Context context, List<TabInfo> list) {
        super(fragmentManager);
        this.f52a = context;
        this.f53b = list;
    }

    public final CharSequence J_(int i) {
        return this.f52a.getResources().getString(((TabInfo) this.f53b.get(i)).f49b).toUpperCase(Locale.getDefault());
    }

    public final Fragment m61a(int i) {
        TabInfo tabInfo = (TabInfo) this.f53b.get(i);
        return Fragment.a(this.f52a, tabInfo.f50c.getName(), tabInfo.f51d);
    }

    public final int m62b() {
        return this.f53b.size();
    }
}
