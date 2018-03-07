package com.facebook.feed.ui;

import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.dispose.Disposable;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.feed.logging.FeedUnitHeightTracker;
import com.facebook.feed.logging.FeedUnitHeightTrackerProvider;
import com.facebook.feed.logging.RowHeightMeasurerProvider;
import com.facebook.feed.logging.RowHeightMeasuringJobProvider;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.adapter.api.HasMarkers.Marker;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.RowIdentifier;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.AdapterCompatibleWithListView;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.RecyclerViewMultiAdapter;
import com.facebook.widget.recyclerview.BaseHasNotifyOnceAdapterObservers;
import com.facebook.widget.recyclerview.DelegatingAdapter;
import com.facebook.widget.recyclerview.DelegatingAdapter.DelegatingViewHolder;
import com.facebook.widget.recyclerview.NotifyOnceAdapterObserver;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.recyclerview.SimpleAdapterDataObserver;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: method/auth.login */
public class NewsFeedRecyclerViewAdapterWrapper extends RecyclerViewMultiAdapter implements HasMultiRow, MultiRowRecyclerViewAdapter, BasicAdapter {
    public final MultiRowRecyclerViewAdapter f13607a;
    private final RowIdentifier f13608b = m20012g();
    public final List<DataSetObserver> f13609c;
    private final BaseHasNotifyOnceAdapterObservers f13610d = new BaseHasNotifyOnceAdapterObservers();
    public FeedUnitHeightTracker f13611e;
    public int f13612f = -1;

    /* compiled from: method/auth.login */
    class LegacyAdapter extends DelegatingAdapter implements Disposable, AdapterCompatibleWithListView<DelegatingViewHolder> {
        private final FbListAdapter f13616c;
        private boolean f13617d;

        public LegacyAdapter(FbListAdapter fbListAdapter, RecyclerView recyclerView) {
            super(fbListAdapter, recyclerView);
            this.f13616c = fbListAdapter;
        }

        public final int iy_() {
            return this.f13616c.getViewTypeCount();
        }

        public Object getItem(int i) {
            return this.f13616c.getItem(i);
        }

        public final void jc_() {
            if (!this.f13617d) {
                if (this.f13616c instanceof Disposable) {
                    ((Disposable) this.f13616c).jc_();
                }
                this.f13617d = true;
            }
        }

        public final boolean ba_() {
            return this.f13617d;
        }
    }

    /* compiled from: method/auth.login */
    class C05565 implements RowIdentifier {
        final /* synthetic */ NewsFeedRecyclerViewAdapterWrapper f13650a;

        C05565(NewsFeedRecyclerViewAdapterWrapper newsFeedRecyclerViewAdapterWrapper) {
            this.f13650a = newsFeedRecyclerViewAdapterWrapper;
        }

        public final RowKey mo2531a(int i) {
            if (this.f13650a.m20031e(i) != this.f13650a.f13607a) {
                return null;
            }
            return this.f13650a.f13607a.mo2513f().mo2531a(i - this.f13650a.m20017b());
        }

        public final int mo2530a() {
            return this.f13650a.m20017b() + this.f13650a.f13607a.mo2513f().mo2530a();
        }
    }

    /* compiled from: method/auth.login */
    class C05571 extends SimpleAdapterDataObserver {
        final /* synthetic */ NewsFeedRecyclerViewAdapterWrapper f13672a;

        C05571(NewsFeedRecyclerViewAdapterWrapper newsFeedRecyclerViewAdapterWrapper) {
            this.f13672a = newsFeedRecyclerViewAdapterWrapper;
        }

        public final void mo2216b() {
            this.f13672a.f13612f = -1;
        }
    }

    /* compiled from: method/auth.login */
    class C05582 implements NotifyOnceAdapterObserver {
        final /* synthetic */ NewsFeedRecyclerViewAdapterWrapper f13673a;

        C05582(NewsFeedRecyclerViewAdapterWrapper newsFeedRecyclerViewAdapterWrapper) {
            this.f13673a = newsFeedRecyclerViewAdapterWrapper;
        }

        public final void mo2132a() {
            this.f13673a.f13611e.m20067a();
        }
    }

    /* compiled from: method/auth.login */
    class Observer extends AdapterDataObserver {
        final /* synthetic */ NewsFeedRecyclerViewAdapterWrapper f13674a;

        public Observer(NewsFeedRecyclerViewAdapterWrapper newsFeedRecyclerViewAdapterWrapper) {
            this.f13674a = newsFeedRecyclerViewAdapterWrapper;
        }

        public final void bb_() {
            for (int size = this.f13674a.f13609c.size() - 1; size >= 0; size--) {
                ((DataSetObserver) this.f13674a.f13609c.get(size)).onChanged();
            }
        }

        public final void mo2217a(int i, int i2) {
            bb_();
        }

        public final void mo2210b(int i, int i2) {
            bb_();
        }

        public final void mo2212c(int i, int i2) {
            bb_();
        }

        public final void mo2218a(int i, int i2, int i3) {
            bb_();
        }
    }

    public final void mo1888a(DumpsysContext dumpsysContext) {
        dumpsysContext.f.a(this.f13607a, dumpsysContext);
    }

    private NewsFeedRecyclerViewAdapterWrapper(List<AdapterCompatibleWithListView> list, MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter, List<AdapterCompatibleWithListView> list2, RecyclerViewProxy recyclerViewProxy, FeedUnitHeightTrackerProvider feedUnitHeightTrackerProvider) {
        super(ImmutableList.builder().m1065b((Iterable) list).m1069c(multiRowRecyclerViewAdapter).m1065b((Iterable) list2).m1068b(), false);
        this.f13611e = new FeedUnitHeightTracker(recyclerViewProxy, this, FeedLoggingViewportEventListener.m15105a((InjectorLike) feedUnitHeightTrackerProvider), ResourcesMethodAutoProvider.m6510a(feedUnitHeightTrackerProvider), (RowHeightMeasurerProvider) feedUnitHeightTrackerProvider.getOnDemandAssistedProviderForStaticDi(RowHeightMeasurerProvider.class), (RowHeightMeasuringJobProvider) feedUnitHeightTrackerProvider.getOnDemandAssistedProviderForStaticDi(RowHeightMeasuringJobProvider.class), IdBasedProvider.m1811a(feedUnitHeightTrackerProvider, 1428));
        mo2223a(new C05571(this));
        mo2640a(new C05582(this));
        this.f13609c = new ArrayList();
        this.f13607a = multiRowRecyclerViewAdapter;
        mo2223a(new Observer(this));
        mo2223a(this.f13610d);
    }

    public static NewsFeedRecyclerViewAdapterWrapper m20008a(ImmutableList<FbListAdapter> immutableList, MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter, ImmutableList<FbListAdapter> immutableList2, RecyclerViewProxy recyclerViewProxy, FeedUnitHeightTrackerProvider feedUnitHeightTrackerProvider) {
        return new NewsFeedRecyclerViewAdapterWrapper(m20009a((ImmutableList) immutableList, recyclerViewProxy), multiRowRecyclerViewAdapter, m20009a((ImmutableList) immutableList2, recyclerViewProxy), recyclerViewProxy, feedUnitHeightTrackerProvider);
    }

    private static List<AdapterCompatibleWithListView> m20009a(ImmutableList<FbListAdapter> immutableList, RecyclerViewProxy recyclerViewProxy) {
        List<AdapterCompatibleWithListView> arrayList = new ArrayList();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new LegacyAdapter((FbListAdapter) immutableList.get(i), recyclerViewProxy.f12219c));
        }
        return arrayList;
    }

    public final int mo2510c(int i) {
        return this.f13607a.mo2510c(i);
    }

    public final int mo2511d(int i) {
        m20013i(i);
        return this.f13607a.mo2511d(m20032f(i));
    }

    public final int s_(int i) {
        if (m20031e(i) != this.f13607a) {
            return Integer.MIN_VALUE;
        }
        return this.f13607a.s_(m20032f(i));
    }

    public final int t_(int i) {
        return this.f13607a.t_(i) + m20017b();
    }

    public final int mo2514g(int i) {
        return this.f13607a.mo2514g(i) + m20017b();
    }

    public final int mo2512e() {
        return this.f13607a.mo2512e();
    }

    public final int mo2515h(int i) {
        m20013i(i);
        return this.f13607a.mo2515h(m20032f(i));
    }

    public final RowIdentifier mo2513f() {
        return this.f13608b;
    }

    public final void mo2508a(Configuration configuration) {
        this.f13607a.mo2508a(configuration);
        this.f13611e.m20068a(configuration);
    }

    public final Marker mo2509b(final int i) {
        if (m20031e(i) == this.f13607a) {
            return new 3(this, this.f13607a.mo2509b(m20032f(i)));
        }
        return new Marker(this) {
            final /* synthetic */ NewsFeedRecyclerViewAdapterWrapper f17920b;

            public final int mo2993a() {
                return i;
            }
        };
    }

    public final int m20017b() {
        if (this.f13612f == -1) {
            this.f13613a.m20043a(this.f13607a);
            this.f13612f = this.f13613a.f13634f;
        }
        return this.f13612f;
    }

    public final int m20022d() {
        return (m20017b() + this.f13607a.aZ_()) - 1;
    }

    @Nullable
    public final FeedUnitHeightTracker m20021c() {
        return this.f13611e;
    }

    public final void jc_() {
        super.jc_();
        this.f13610d.jc_();
    }

    private void m20013i(int i) {
        if (m20031e(i) != this.f13607a) {
            throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Position %d does not belong to the NewsFeedAdapter (positions %d to %d)", Integer.valueOf(i), Integer.valueOf(m20017b()), Integer.valueOf((m20017b() + this.f13607a.aZ_()) - 1)));
        }
    }

    private RowIdentifier m20012g() {
        return new C05565(this);
    }

    public final void mo2640a(NotifyOnceAdapterObserver notifyOnceAdapterObserver) {
        this.f13610d.mo2640a(notifyOnceAdapterObserver);
    }

    public final void mo2641b(NotifyOnceAdapterObserver notifyOnceAdapterObserver) {
        this.f13610d.mo2641b(notifyOnceAdapterObserver);
    }
}
