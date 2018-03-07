package com.facebook.search.fragment;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Assisted;
import com.facebook.search.suggestions.SuggestionsFragment;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.RegularImmutableBiMap;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TimeToCoverPhotoMinipreview */
public class GraphSearchChildFragmentNavigator implements AnalyticsFragmentWithExtraData {
    private final FragmentManager f21876a;
    private final GatekeeperStoreImpl f21877b;
    public String f21878c;
    public NavigationLogger f21879d;
    public Handler f21880e;
    private WeakReference<Fragment> f21881f;
    public boolean f21882g = true;

    @Inject
    public GraphSearchChildFragmentNavigator(@Assisted FragmentManager fragmentManager, GatekeeperStoreImpl gatekeeperStoreImpl, NavigationLogger navigationLogger, Handler handler) {
        this.f21876a = fragmentManager;
        this.f21877b = gatekeeperStoreImpl;
        this.f21879d = navigationLogger;
        this.f21880e = handler;
        this.f21881f = null;
    }

    public final boolean m25377a(Fragment fragment) {
        return fragment == m25376a() && this.f21881f != null && fragment == this.f21881f.get();
    }

    public final void m25378b(final Fragment fragment) {
        Fragment a = m25376a();
        if (!m25377a(fragment)) {
            FragmentTransaction c = this.f21876a.a().c(fragment);
            if (!(a == null || a == fragment)) {
                if (GraphSearchFragmentType.SUGGESTIONS.getTag().equals(a.J) || this.f21877b.a(427, false)) {
                    c.b(a);
                } else {
                    c.a(a);
                }
            }
            c.c();
            this.f21881f = new WeakReference(fragment);
            this.f21878c = fragment.J;
            if (this.f21878c.equals(GraphSearchFragmentType.SUGGESTIONS.getTag())) {
                SuggestionsFragment suggestionsFragment = (SuggestionsFragment) fragment;
                suggestionsFragment.aQ.m10664a(suggestionsFragment.aZ);
            }
            if (this.f21882g) {
                this.f21882g = false;
            } else {
                HandlerDetour.a(this.f21880e, new Runnable(this) {
                    final /* synthetic */ GraphSearchChildFragmentNavigator f21875b;

                    public void run() {
                        this.f21875b.f21879d.a(fragment, fragment.getContext());
                    }
                }, 96716636);
            }
        }
    }

    @Nullable
    public final Fragment m25376a() {
        if (this.f21878c == null) {
            return null;
        }
        return this.f21876a.a(this.f21878c);
    }

    public final Map<String, Object> m25379c() {
        Fragment a = m25376a();
        if (a instanceof AnalyticsFragmentWithExtraData) {
            return ((AnalyticsFragmentWithExtraData) a).c();
        }
        return RegularImmutableBiMap.a;
    }

    public final String am_() {
        Fragment a = m25376a();
        if (a instanceof AnalyticsFragment) {
            return ((AnalyticsFragment) a).am_();
        }
        return "unknown";
    }
}
