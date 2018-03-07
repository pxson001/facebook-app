package com.facebook.neko.util;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.NativeAd;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: topDrawerOpened */
public class AppCardFragment extends Fragment {
    public AbstractUnit f821a;
    public NativeAd f822b;
    public AbstractAppUnitFactory f823c;
    public int f824d = -1;

    /* compiled from: topDrawerOpened */
    public interface AbstractAppUnitFactory {
        AbstractUnit mo10a(Context context, int i);
    }

    public final View m1116a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1489179010);
        if (this.f823c == null || this.f824d < 0) {
            View appUnitLoading = new AppUnitLoading(getContext());
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1570359650, a);
            return appUnitLoading;
        }
        this.f821a = this.f823c.mo10a(getContext(), this.f824d);
        this.f821a.mo11a(this.f822b);
        appUnitLoading = this.f821a;
        LogUtils.f(-2057098001, a);
        return appUnitLoading;
    }
}
