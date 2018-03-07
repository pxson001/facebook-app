package com.facebook.feed.rows.adapter;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.api.feed.data.collections.ObservableListItemCollection;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.idleexecutor.IdleExecutor_ForUiThreadMethodAutoProvider;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.analytics.MultiRowPerfLoggerMethodAutoProvider;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.adapter.api.ListItemCollectionEndProvider;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.adapter.freshfeed.FreshFeedFeedUnitAdapterFactoryHolder;
import com.facebook.feed.rows.core.AdaptersCollection;
import com.facebook.feed.rows.core.BasicFeedUnitAdapterFactoryFactory;
import com.facebook.feed.rows.core.CachingFeedUnitAdapterFactory;
import com.facebook.feed.rows.core.DefaultAdaptersCollectionProvider;
import com.facebook.feed.rows.core.FeedEdgeListItemComparator;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.FeedUnitAdapterFactory;
import com.facebook.feed.rows.core.ListItemComparator;
import com.facebook.feed.rows.core.ObservableAdaptersCollection;
import com.facebook.feed.rows.core.ObservableAdaptersCollectionProvider;
import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.feed.rows.core.preparer.AdapterPreparer;
import com.facebook.feed.rows.core.preparer.RangeAdapterPreparer;
import com.facebook.feed.rows.core.preparer.RangeAdapterPreparerProvider;
import com.facebook.feed.rows.core.preparer.RangeAdapterPreparerScrollListener;
import com.facebook.feed.rows.core.preparer.RangeAdapterPreparerScrollListenerProvider;
import com.facebook.feed.rows.core.preparer.TopDownAdapterPreparer;
import com.facebook.feed.rows.core.preparer.TopDownAdapterPreparerProvider;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.qe.RangePreparerExperimentHelper;
import com.facebook.feed.workingrange.rows.FeedRangesController;
import com.facebook.feed.workingrange.rows.FeedRangesExperiments;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.Environments;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.WorkingRangeScrollableImpl;
import com.facebook.widget.viewadapterpreallocator.ViewAdapterPreallocatorProvider;
import com.facebook.widget.viewdiagnostics.DiagnosticsRunner;
import com.facebook.widget.viewdiagnostics.ViewDiagnostics;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: phone_confirmed */
public class MultiRowAdapterBuilder {
    public final TopDownAdapterPreparerProvider f10186a;
    public final RangeAdapterPreparerProvider f10187b;
    private final RangeAdapterPreparerScrollListenerProvider f10188c;
    public final RangePreparerExperimentHelper f10189d;
    public final DefaultAdaptersCollectionProvider f10190e;
    public final ObservableAdaptersCollectionProvider f10191f;
    public final QeAccessor f10192g;
    public final BasicFeedUnitAdapterFactoryFactory f10193h;
    public final Lazy<FreshFeedFeedUnitAdapterFactoryHolder> f10194i;
    public final FeedEdgeListItemComparator f10195j;
    public final BasicMultiRowAdapterProvider f10196k;
    public final PreallocatingMultiRowAdapterProvider f10197l;
    public final DiagnosticsReportingMultiRowAdapterProvider f10198m;
    public final FrameRateBlameMultiRowAdapterProvider f10199n;
    public final PerformanceLoggingMultiRowAdapterProvider f10200o;
    public final FbSharedPreferences f10201p;
    public final MultiRowPerfLogger f10202q;
    public final Lazy<FeedRangesController> f10203r;

    /* compiled from: phone_confirmed */
    public class Builder<E extends AnyEnvironment> {
        public final /* synthetic */ MultiRowAdapterBuilder f12874a;
        private final Lazy<? extends MultiRowGroupPartDefinition<?, ?, ? super E>> f12875b;
        public ListItemCollection f12876c;
        public ListItemCollectionWithFeedEnd f12877d;
        public ListItemComparator f12878e;
        public AnyEnvironment f12879f = Environments.f12890a;
        private boolean f12880g;
        public ScrollingViewProxy f12881h;
        public boolean f12882i;
        public boolean f12883j;
        private boolean f12884k;
        public boolean f12885l;
        public boolean f12886m;
        private boolean f12887n;
        private String f12888o;
        public FeedRangesController f12889p;

        public Builder(MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<? extends MultiRowGroupPartDefinition<?, ?, ? super E>> lazy, ListItemCollection listItemCollection) {
            this.f12874a = multiRowAdapterBuilder;
            this.f12875b = lazy;
            this.f12876c = listItemCollection;
        }

        public final Builder<E> m18951a(ListItemCollectionEndProvider listItemCollectionEndProvider) {
            this.f12877d = new ListItemCollectionWithFeedEnd(this.f12876c, listItemCollectionEndProvider, false);
            return this;
        }

        public final Builder<E> m18953a(E e) {
            this.f12879f = e;
            return this;
        }

        public final Builder<E> m18954a(ScrollingViewProxy scrollingViewProxy) {
            this.f12880g = true;
            this.f12881h = scrollingViewProxy;
            return this;
        }

        public final Builder<E> m18956a(String str) {
            this.f12884k = true;
            this.f12888o = str;
            return this;
        }

        public final Builder<E> m18952a(ListItemComparator listItemComparator) {
            this.f12878e = listItemComparator;
            return this;
        }

        public final Builder<E> m18957b(ScrollingViewProxy scrollingViewProxy) {
            if (this.f12874a.f10189d.m10051a()) {
                this.f12881h = scrollingViewProxy;
                this.f12887n = true;
            }
            return this;
        }

        public final Builder<E> m18955a(ScrollingViewProxy scrollingViewProxy, @Nullable FeedRangesController feedRangesController) {
            if (feedRangesController == null) {
                return this;
            }
            this.f12889p = feedRangesController;
            Preconditions.checkState(!this.f12885l, "withWorkingRanges should only be called once.");
            if (FeedRangesExperiments.m19960a(this.f12874a.f10192g)) {
                if (this.f12889p == null) {
                    this.f12889p = (FeedRangesController) this.f12874a.f10203r.get();
                }
                this.f12881h = scrollingViewProxy;
                this.f12885l = true;
            }
            return this;
        }

        public final MultiRowRecyclerViewAdapter m18958d() {
            boolean a;
            FeedUnitAdapterFactory a2;
            AdaptersCollection a3;
            AdapterPreparer a4;
            MultiRowRecyclerViewAdapter a5;
            MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter;
            boolean z = true;
            ListItemCollection listItemCollection = this.f12877d != null ? this.f12877d : this.f12876c;
            if (this.f12879f instanceof HasFeedListType) {
                FeedListType c = ((HasFeedListType) this.f12879f).mo2446c();
                if (c != null && c.mo2419a() == FeedListName.FEED) {
                    a = this.f12874a.f10192g.mo596a(ExperimentsForNewsFeedAbTestModule.f5083J, false);
                    if (a) {
                        a2 = this.f12874a.f10193h.m10039a(this.f12875b, this.f12874a.f10202q, this.f12886m);
                    } else {
                        FreshFeedFeedUnitAdapterFactoryHolder freshFeedFeedUnitAdapterFactoryHolder = (FreshFeedFeedUnitAdapterFactoryHolder) this.f12874a.f10194i.get();
                        freshFeedFeedUnitAdapterFactoryHolder.f5877b = new CachingFeedUnitAdapterFactory(freshFeedFeedUnitAdapterFactoryHolder.f5876a.m10039a(this.f12875b, this.f12874a.f10202q, false), this.f12879f);
                        a2 = freshFeedFeedUnitAdapterFactoryHolder.f5877b;
                    }
                    a3 = m18949a(listItemCollection, a2);
                    a4 = m18950a(a3);
                    a3.mo2528e();
                    a4.mo2533a();
                    a5 = this.f12874a.f10196k.m15286a(a3, a4, ViewDiagnostics.m19819a(this.f12874a.f10201p));
                    if (this.f12880g) {
                        multiRowRecyclerViewAdapter = a5;
                    } else {
                        Preconditions.checkState(this.f12881h == null);
                        multiRowRecyclerViewAdapter = new PreallocatingMultiRowAdapter(a5, this.f12881h, (ViewAdapterPreallocatorProvider) this.f12874a.f10197l.getOnDemandAssistedProviderForStaticDi(ViewAdapterPreallocatorProvider.class));
                    }
                    if (this.f12882i) {
                        multiRowRecyclerViewAdapter = new DiagnosticsReportingMultiRowAdapter(multiRowRecyclerViewAdapter, DiagnosticsRunner.m10045a(this.f12874a.f10198m));
                    }
                    if (this.f12883j) {
                        multiRowRecyclerViewAdapter = new FrameRateBlameMultiRowAdapter(multiRowRecyclerViewAdapter, FrameRateBlameMarkers.m16545a(this.f12874a.f10199n));
                    }
                    if (this.f12884k) {
                        if (this.f12888o == null) {
                            z = false;
                        }
                        Preconditions.checkState(z);
                        multiRowRecyclerViewAdapter = new PerformanceLoggingMultiRowAdapter(multiRowRecyclerViewAdapter, this.f12888o, QuickPerformanceLoggerMethodAutoProvider.m2859a(this.f12874a.f10200o));
                    }
                    if (this.f12885l) {
                        boolean z2 = a3 instanceof ObservableAdaptersCollection;
                        ScrollingViewProxy scrollingViewProxy = this.f12881h;
                        WorkingRangeScrollableImpl workingRangeScrollableImpl = new WorkingRangeScrollableImpl(scrollingViewProxy);
                        scrollingViewProxy.mo2369b(workingRangeScrollableImpl.c);
                        this.f12889p.m16453a(workingRangeScrollableImpl, multiRowRecyclerViewAdapter, z2);
                    }
                    return multiRowRecyclerViewAdapter;
                }
            }
            a = false;
            if (a) {
                a2 = this.f12874a.f10193h.m10039a(this.f12875b, this.f12874a.f10202q, this.f12886m);
            } else {
                FreshFeedFeedUnitAdapterFactoryHolder freshFeedFeedUnitAdapterFactoryHolder2 = (FreshFeedFeedUnitAdapterFactoryHolder) this.f12874a.f10194i.get();
                freshFeedFeedUnitAdapterFactoryHolder2.f5877b = new CachingFeedUnitAdapterFactory(freshFeedFeedUnitAdapterFactoryHolder2.f5876a.m10039a(this.f12875b, this.f12874a.f10202q, false), this.f12879f);
                a2 = freshFeedFeedUnitAdapterFactoryHolder2.f5877b;
            }
            a3 = m18949a(listItemCollection, a2);
            a4 = m18950a(a3);
            a3.mo2528e();
            a4.mo2533a();
            a5 = this.f12874a.f10196k.m15286a(a3, a4, ViewDiagnostics.m19819a(this.f12874a.f10201p));
            if (this.f12880g) {
                multiRowRecyclerViewAdapter = a5;
            } else {
                if (this.f12881h == null) {
                }
                Preconditions.checkState(this.f12881h == null);
                multiRowRecyclerViewAdapter = new PreallocatingMultiRowAdapter(a5, this.f12881h, (ViewAdapterPreallocatorProvider) this.f12874a.f10197l.getOnDemandAssistedProviderForStaticDi(ViewAdapterPreallocatorProvider.class));
            }
            if (this.f12882i) {
                multiRowRecyclerViewAdapter = new DiagnosticsReportingMultiRowAdapter(multiRowRecyclerViewAdapter, DiagnosticsRunner.m10045a(this.f12874a.f10198m));
            }
            if (this.f12883j) {
                multiRowRecyclerViewAdapter = new FrameRateBlameMultiRowAdapter(multiRowRecyclerViewAdapter, FrameRateBlameMarkers.m16545a(this.f12874a.f10199n));
            }
            if (this.f12884k) {
                if (this.f12888o == null) {
                    z = false;
                }
                Preconditions.checkState(z);
                multiRowRecyclerViewAdapter = new PerformanceLoggingMultiRowAdapter(multiRowRecyclerViewAdapter, this.f12888o, QuickPerformanceLoggerMethodAutoProvider.m2859a(this.f12874a.f10200o));
            }
            if (this.f12885l) {
                boolean z22 = a3 instanceof ObservableAdaptersCollection;
                ScrollingViewProxy scrollingViewProxy2 = this.f12881h;
                WorkingRangeScrollableImpl workingRangeScrollableImpl2 = new WorkingRangeScrollableImpl(scrollingViewProxy2);
                scrollingViewProxy2.mo2369b(workingRangeScrollableImpl2.c);
                this.f12889p.m16453a(workingRangeScrollableImpl2, multiRowRecyclerViewAdapter, z22);
            }
            return multiRowRecyclerViewAdapter;
        }

        public final MultiRowAdapter m18959e() {
            return new MultiRowListViewAdapterWrapper(m18958d());
        }

        private AdapterPreparer m18950a(AdaptersCollection adaptersCollection) {
            if (!this.f12887n) {
                return new TopDownAdapterPreparer(adaptersCollection, IdleExecutor_ForUiThreadMethodAutoProvider.m10033b(this.f12874a.f10186a));
            }
            InjectorLike injectorLike = this.f12874a.f10187b;
            RangeAdapterPreparer rangeAdapterPreparer = new RangeAdapterPreparer(adaptersCollection, this.f12881h, IdleExecutor_ForUiThreadMethodAutoProvider.m10033b(injectorLike), RangePreparerExperimentHelper.m10049a(injectorLike));
            this.f12881h.mo2369b(new RangeAdapterPreparerScrollListener(rangeAdapterPreparer));
            return rangeAdapterPreparer;
        }

        private AdaptersCollection m18949a(ListItemCollection listItemCollection, FeedUnitAdapterFactory<?, E> feedUnitAdapterFactory) {
            if (listItemCollection instanceof ObservableListItemCollection) {
                InjectorLike injectorLike = this.f12874a.f10191f;
                return new ObservableAdaptersCollection(feedUnitAdapterFactory, this.f12879f, (ObservableListItemCollection) listItemCollection, FbErrorReporterImpl.m2317a(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike));
            }
            return this.f12874a.f10190e.m15278a(feedUnitAdapterFactory, listItemCollection, this.f12879f, this.f12878e != null ? this.f12878e : this.f12874a.f10195j);
        }
    }

    public static MultiRowAdapterBuilder m15276b(InjectorLike injectorLike) {
        return new MultiRowAdapterBuilder((ObservableAdaptersCollectionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ObservableAdaptersCollectionProvider.class), (DefaultAdaptersCollectionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultAdaptersCollectionProvider.class), QeInternalImplMethodAutoProvider.m3744a(injectorLike), (TopDownAdapterPreparerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TopDownAdapterPreparerProvider.class), (RangeAdapterPreparerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RangeAdapterPreparerProvider.class), (RangeAdapterPreparerScrollListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RangeAdapterPreparerScrollListenerProvider.class), RangePreparerExperimentHelper.m10049a(injectorLike), FeedEdgeListItemComparator.m15279a(injectorLike), BasicFeedUnitAdapterFactoryFactory.m10037a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1482), (BasicMultiRowAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BasicMultiRowAdapterProvider.class), (PreallocatingMultiRowAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PreallocatingMultiRowAdapterProvider.class), (DiagnosticsReportingMultiRowAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DiagnosticsReportingMultiRowAdapterProvider.class), (FrameRateBlameMultiRowAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateBlameMultiRowAdapterProvider.class), (PerformanceLoggingMultiRowAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PerformanceLoggingMultiRowAdapterProvider.class), FbSharedPreferencesImpl.m1826a(injectorLike), MultiRowPerfLoggerMethodAutoProvider.m15287a(injectorLike), IdBasedLazy.m1808a(injectorLike, 1763));
    }

    public static MultiRowAdapterBuilder m15275a(InjectorLike injectorLike) {
        return m15276b(injectorLike);
    }

    @Inject
    private MultiRowAdapterBuilder(ObservableAdaptersCollectionProvider observableAdaptersCollectionProvider, DefaultAdaptersCollectionProvider defaultAdaptersCollectionProvider, QeAccessor qeAccessor, TopDownAdapterPreparerProvider topDownAdapterPreparerProvider, RangeAdapterPreparerProvider rangeAdapterPreparerProvider, RangeAdapterPreparerScrollListenerProvider rangeAdapterPreparerScrollListenerProvider, RangePreparerExperimentHelper rangePreparerExperimentHelper, FeedEdgeListItemComparator feedEdgeListItemComparator, BasicFeedUnitAdapterFactoryFactory basicFeedUnitAdapterFactoryFactory, Lazy<FreshFeedFeedUnitAdapterFactoryHolder> lazy, BasicMultiRowAdapterProvider basicMultiRowAdapterProvider, PreallocatingMultiRowAdapterProvider preallocatingMultiRowAdapterProvider, DiagnosticsReportingMultiRowAdapterProvider diagnosticsReportingMultiRowAdapterProvider, FrameRateBlameMultiRowAdapterProvider frameRateBlameMultiRowAdapterProvider, PerformanceLoggingMultiRowAdapterProvider performanceLoggingMultiRowAdapterProvider, FbSharedPreferences fbSharedPreferences, MultiRowPerfLogger multiRowPerfLogger, Lazy<FeedRangesController> lazy2) {
        this.f10190e = defaultAdaptersCollectionProvider;
        this.f10191f = observableAdaptersCollectionProvider;
        this.f10192g = qeAccessor;
        this.f10186a = topDownAdapterPreparerProvider;
        this.f10187b = rangeAdapterPreparerProvider;
        this.f10188c = rangeAdapterPreparerScrollListenerProvider;
        this.f10189d = rangePreparerExperimentHelper;
        this.f10195j = feedEdgeListItemComparator;
        this.f10193h = basicFeedUnitAdapterFactoryFactory;
        this.f10194i = lazy;
        this.f10196k = basicMultiRowAdapterProvider;
        this.f10197l = preallocatingMultiRowAdapterProvider;
        this.f10198m = diagnosticsReportingMultiRowAdapterProvider;
        this.f10199n = frameRateBlameMultiRowAdapterProvider;
        this.f10200o = performanceLoggingMultiRowAdapterProvider;
        this.f10201p = fbSharedPreferences;
        this.f10202q = multiRowPerfLogger;
        this.f10203r = lazy2;
    }

    public final <E extends AnyEnvironment> Builder<E> m15277a(Lazy<? extends MultiRowGroupPartDefinition<?, ?, ? super E>> lazy, ListItemCollection listItemCollection) {
        return new Builder(this, lazy, listItemCollection);
    }
}
