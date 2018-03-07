package com.facebook.messaging.location.sending;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.location.sending.NearbyPlacesLoader.LoadListener;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mIsWebCSCVerified */
public class NearbyPlacesSearchResultsFragment extends FbFragment {
    @Inject
    public NearbyPlacesLoader f11474a;
    private Handler f11475b;
    public NearbyPlacesView f11476c;
    @Nullable
    public NearbyPlaceClickListener f11477d;
    @Nullable
    public Runnable f11478e;

    /* compiled from: mIsWebCSCVerified */
    public class C12801 implements NearbyPlaceClickListener {
        final /* synthetic */ NearbyPlacesSearchResultsFragment f11470a;

        public C12801(NearbyPlacesSearchResultsFragment nearbyPlacesSearchResultsFragment) {
            this.f11470a = nearbyPlacesSearchResultsFragment;
        }

        public final void mo435a(NearbyPlace nearbyPlace) {
            if (this.f11470a.f11477d != null) {
                this.f11470a.f11477d.mo435a(nearbyPlace);
            }
        }
    }

    /* compiled from: mIsWebCSCVerified */
    public class C12812 implements LoadListener {
        final /* synthetic */ NearbyPlacesSearchResultsFragment f11471a;

        public C12812(NearbyPlacesSearchResultsFragment nearbyPlacesSearchResultsFragment) {
            this.f11471a = nearbyPlacesSearchResultsFragment;
        }

        public final void mo441a(ImmutableList<NearbyPlace> immutableList) {
            NearbyPlacesSearchResultsFragment nearbyPlacesSearchResultsFragment = this.f11471a;
            if (immutableList.isEmpty()) {
                nearbyPlacesSearchResultsFragment.f11476c.m12084a(nearbyPlacesSearchResultsFragment.b(2131241015));
            } else {
                nearbyPlacesSearchResultsFragment.f11476c.m12083a((ImmutableList) immutableList);
            }
        }

        public final void mo440a() {
            this.f11471a.f11476c.m12084a(this.f11471a.b(2131241015));
        }
    }

    public static void m12070a(Object obj, Context context) {
        ((NearbyPlacesSearchResultsFragment) obj).f11474a = NearbyPlacesLoader.m12062b(FbInjector.get(context));
    }

    public final void m12076c(Bundle bundle) {
        super.c(bundle);
        Class cls = NearbyPlacesSearchResultsFragment.class;
        m12070a((Object) this, getContext());
        this.f11475b = new Handler();
    }

    public final View m12073a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2074808731);
        View inflate = layoutInflater.inflate(2130905387, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1043390009, a);
        return inflate;
    }

    public final void m12074a(View view, Bundle bundle) {
        this.f11476c = (NearbyPlacesView) view;
        this.f11476c.f11480a = new C12801(this);
        this.f11474a.f11469f = new C12812(this);
        this.f11474a.m12066b();
    }

    public final void m12075a(String str) {
        this.f11474a.m12064a();
        this.f11476c.m12082a();
        m12071b(str);
    }

    private void m12071b(final String str) {
        aq();
        this.f11478e = new Runnable(this) {
            final /* synthetic */ NearbyPlacesSearchResultsFragment f11473b;

            public void run() {
                this.f11473b.f11478e = null;
                this.f11473b.f11474a.m12065a(str);
            }
        };
        HandlerDetour.b(this.f11475b, this.f11478e, 300, -1520120824);
    }

    private void aq() {
        if (this.f11478e != null) {
            HandlerDetour.a(this.f11475b, this.f11478e);
        }
    }

    public final void m12072I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 907838962);
        super.I();
        aq();
        this.f11474a.m12064a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1800764604, a);
    }
}
