package com.facebook.video.livemap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbMapViewDelegate;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.HasTitleBar;
import javax.annotation.Nullable;

@UriMatchPatterns(fragment = ContentFragmentType.LIVE_MAP_FRAGMENT)
/* compiled from: extra_end_time */
public class LiveMapFragment extends FbFragment {
    private FbMapViewDelegate f12933a;

    public final void m12914c(@Nullable Bundle bundle) {
        Class cls = LiveMapFragment.class;
        FbInjector.get(getContext());
        super.c(bundle);
    }

    public final View m12913a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -445971683);
        this.f12933a = (FbMapViewDelegate) layoutInflater.inflate(2130905085, viewGroup, false);
        this.f12933a.a(bundle);
        FbMapViewDelegate fbMapViewDelegate = this.f12933a;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -753250446, a);
        return fbMapViewDelegate;
    }

    public final void m12915e(Bundle bundle) {
        super.e(bundle);
        this.f12933a.b(bundle);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1299895309);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar == null) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 309155607, a);
            return;
        }
        hasTitleBar.y_(2131241410);
        LogUtils.f(39430645, a);
    }

    public final void m12910G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -165601495);
        super.G();
        this.f12933a.d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1898438463, a);
    }

    public final void m12911H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1113129957);
        super.H();
        this.f12933a.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -73267659, a);
    }

    public final void m12912I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2072255646);
        super.I();
        this.f12933a.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1688200491, a);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f12933a.b();
    }
}
