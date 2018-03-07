package com.facebook.search.results.fragment.marketplace;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.fbreact.search.ReactSearchEventBus;
import com.facebook.fbreact.search.ReactSearchEvents.LaunchReachSearchResultEvent;
import com.facebook.fbreact.search.ReactSearchEvents.LaunchReachSearchResultEventSubscriberImpl;
import com.facebook.fbreact.search.ReactSearchEvents.ReactNativeInfoHandler;
import com.facebook.fbreact.search.ReactSearchEvents.UpdateSearcyQueryEventSubscriberImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.marketplace.tab.fragment.MarketplaceHomeFragment;
import com.facebook.search.results.fragment.SearchResultsBaseFragment;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: SERIF */
public class MarketplaceSearchResultsFragment extends SearchResultsBaseFragment {
    public MarketplaceHomeFragment al;
    private UpdateSearcyQueryEventSubscriberImpl am;
    private LaunchReachSearchResultEventSubscriberImpl an;
    public FragmentManager ao;
    public int ap;
    @Inject
    public GraphSearchTitleSearchBoxSupplier f23061h;
    @Inject
    public ReactSearchEventBus f23062i;

    /* compiled from: SERIF */
    class C24731 implements ReactNativeInfoHandler {
        final /* synthetic */ MarketplaceSearchResultsFragment f23058a;

        C24731(MarketplaceSearchResultsFragment marketplaceSearchResultsFragment) {
            this.f23058a = marketplaceSearchResultsFragment;
        }

        public final int m26717a() {
            if (this.f23058a.al == null) {
                return 0;
            }
            return this.f23058a.al.av();
        }

        public final void m26718a(String str) {
            this.f23058a.f23061h.f25334a.setSearchText(str);
        }

        public final void m26719a(String str, String str2) {
        }
    }

    public static void m26723a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MarketplaceSearchResultsFragment marketplaceSearchResultsFragment = (MarketplaceSearchResultsFragment) obj;
        GraphSearchTitleSearchBoxSupplier a = GraphSearchTitleSearchBoxSupplier.m28576a(fbInjector);
        ReactSearchEventBus a2 = ReactSearchEventBus.a(fbInjector);
        marketplaceSearchResultsFragment.f23061h = a;
        marketplaceSearchResultsFragment.f23062i = a2;
    }

    public final void mo1290c(Bundle bundle) {
        super.mo1290c(bundle);
        Class cls = MarketplaceSearchResultsFragment.class;
        m26723a(this, getContext());
        this.am = new UpdateSearcyQueryEventSubscriberImpl(new C24731(this));
        this.an = new LaunchReachSearchResultEventSubscriberImpl(new ReactNativeInfoHandler(this) {
            final /* synthetic */ MarketplaceSearchResultsFragment f23060b;

            public final int m26720a() {
                if (this.f23060b.al == null) {
                    return 0;
                }
                return this.f23060b.al.av();
            }

            public final void m26721a(String str) {
            }

            public final void m26722a(String str, String str2) {
                this.f23060b.ao.a().a(this).b();
                this.f23060b.al = null;
                this.f23060b.ao.b();
                this.f23060b.f23062i.a(new LaunchReachSearchResultEvent(this.f23060b.ap, str, str2));
            }
        });
        this.f23062i.a(this.am);
        this.f23062i.a(this.an);
    }

    public final void m26724I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -932362191);
        super.I();
        if (this.f23062i != null) {
            this.f23062i.b(this.am);
            this.f23062i.b(this.an);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 322488257, a);
    }

    public final boolean mo1191a(boolean z) {
        boolean a = super.mo1191a(z);
        this.ao.a().a(this.al).b();
        this.al = null;
        this.ao.b();
        return a;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2014423599);
        super.mY_();
        if (this.al != null) {
            this.al.mY_();
            this.al.I();
            this.al = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 587238789, a);
    }

    public final View m26725a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 487429489);
        if (this.al == null) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1174386378, a);
            return null;
        }
        View view = this.al.T;
        LogUtils.f(-1666656378, a);
        return view;
    }

    public final String am_() {
        return "marketplace";
    }

    protected final Class<?> mo1294e() {
        return MarketplaceSearchResultsFragment.class;
    }

    protected final void aq() {
    }

    protected final boolean ar() {
        return false;
    }
}
