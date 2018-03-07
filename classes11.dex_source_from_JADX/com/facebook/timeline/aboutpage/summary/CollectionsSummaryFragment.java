package com.facebook.timeline.aboutpage.summary;

import android.content.Context;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.BatchConfiguration;
import com.facebook.graphql.connection.configuration.SequentialBatchConfiguration;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.profile.inforequest.event.InfoRequestEventBus;
import com.facebook.profile.inforequest.event.InfoRequestEvents.InfoRequestSentNavigationEventSubscriber;
import com.facebook.profile.inforequest.event.InfoRequestEvents.SendInfoRequestEvent;
import com.facebook.profile.inforequest.event.InfoRequestEvents.SendInfoRequestEventSubscriber;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.aboutpage.Boolean_IsTheWhoEnabledMethodAutoProvider;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.CollectionsCurationController;
import com.facebook.timeline.aboutpage.CollectionsPerformanceLogger.CollectionsFragmentType;
import com.facebook.timeline.aboutpage.CollectionsQueryExecutor;
import com.facebook.timeline.aboutpage.CollectionsQueryExecutor.C15401;
import com.facebook.timeline.aboutpage.DeleteExperienceController;
import com.facebook.timeline.aboutpage.DeleteExperienceController.DeleteExperienceListener;
import com.facebook.timeline.aboutpage.MultiCollectionFragment;
import com.facebook.timeline.aboutpage.MultiCollectionFragment.Adapter;
import com.facebook.timeline.aboutpage.MutualFriendsInfo;
import com.facebook.timeline.aboutpage.RedirectToUriController;
import com.facebook.timeline.aboutpage.annotations.IsTheWhoEnabled;
import com.facebook.timeline.aboutpage.events.CollectionsEventBus;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.AboutSectionInfoModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldSectionInfoModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileInfoSectionsModel.ProfileFieldSectionsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLInterfaces.AboutPageUserFields;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.AppSectionInfoModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineAppSectionsStructuredNameModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineAppSectionsStructuredNameModel.PartsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineCollectionAppSectionsFieldsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineCollectionAppSectionsFieldsModel.PageInfoModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineCollectionAppSectionsModel;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UriMatchPatterns(fragment = ContentFragmentType.COLLECTIONS_SUMMARY_FRAGMENT)
/* compiled from: Login attempt failed. */
public class CollectionsSummaryFragment extends MultiCollectionFragment<AboutPageUserFields> implements AnalyticsFragmentWithExtraData, DeleteExperienceListener {
    @Inject
    CollectionItemsLoggingViewportListenerProvider aA;
    @Inject
    QeAccessor aB;
    @Inject
    AnalyticsTagger aC;
    @Inject
    CollectionsSummaryCursorAdaptorProvider aD;
    @Inject
    SummaryInitialConnectionConfigurationProvider aE;
    @Inject
    SummaryTailConnectionConfigurationProvider aF;
    @Inject
    @IsTheWhoEnabled
    Boolean aG;
    private FbEventSubscriberListManager aH;
    private FbEventSubscriberListManager aI;
    private CollectionsSummaryController aJ;
    private CollectionItemsLoggingViewportListener aK;
    public boolean aL;
    public String aM;
    public ParcelUuid aN;
    public PageInfoModel aO = null;
    private CollectionsSummaryCursorAdaptor aP;
    @Inject
    InfoRequestEventBus at;
    @Inject
    CollectionsEventBus au;
    @Inject
    Provider<FbUriIntentHandler> av;
    @Inject
    CollectionsSummaryAnalyticsLogger aw;
    @Inject
    CollectionsSummaryControllerProvider ax;
    @Inject
    CollectionsSummaryAdapterProvider ay;
    @Inject
    ViewportMonitor az;

    /* compiled from: Login attempt failed. */
    class C15742 extends AbstractDisposableFutureCallback<TimelineCollectionAppSectionsModel> {
        final /* synthetic */ CollectionsSummaryFragment f13628a;

        C15742(CollectionsSummaryFragment collectionsSummaryFragment) {
            this.f13628a = collectionsSummaryFragment;
        }

        protected final void m14818a(Object obj) {
            TimelineCollectionAppSectionsModel timelineCollectionAppSectionsModel = (TimelineCollectionAppSectionsModel) obj;
            if (this.f13628a.an != null && timelineCollectionAppSectionsModel != null) {
                TimelineCollectionAppSectionsFieldsModel a = timelineCollectionAppSectionsModel.m14621a();
                if (a != null) {
                    ImmutableList a2 = a.m14614a();
                    int size = a2.size();
                    for (int i = 0; i < size; i++) {
                        ((CollectionsSummaryAdapter) this.f13628a.an).m14797b((CollectionsAppSectionWithItemsOrRequestablesModel) a2.get(i));
                    }
                    this.f13628a.aO = timelineCollectionAppSectionsModel.m14621a().m14616j();
                    this.f13628a.an.notifyDataSetChanged();
                    CollectionsSummaryFragment.aK(this.f13628a);
                }
            }
        }

        protected final void m14819a(Throwable th) {
            if (this.f13628a.an != null) {
                ((CollectionsSummaryAdapter) this.f13628a.an).f13593o = false;
                this.f13628a.m13816a(th);
            }
        }
    }

    public static void m14825a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CollectionsSummaryFragment) obj).m14822a(InfoRequestEventBus.a(fbInjector), CollectionsEventBus.m13930a(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 616), CollectionsSummaryAnalyticsLogger.m14799b(fbInjector), (CollectionsSummaryControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CollectionsSummaryControllerProvider.class), (CollectionsSummaryAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CollectionsSummaryAdapterProvider.class), ViewportMonitor.b(fbInjector), (CollectionItemsLoggingViewportListenerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CollectionItemsLoggingViewportListenerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), AnalyticsTagger.a(fbInjector), (CollectionsSummaryCursorAdaptorProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CollectionsSummaryCursorAdaptorProvider.class), (SummaryInitialConnectionConfigurationProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SummaryInitialConnectionConfigurationProvider.class), (SummaryTailConnectionConfigurationProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SummaryTailConnectionConfigurationProvider.class), Boolean_IsTheWhoEnabledMethodAutoProvider.m13738a(fbInjector));
    }

    protected final void mo410a(Object obj) {
        AboutPageUserFields aboutPageUserFields = (AboutPageUserFields) obj;
        if (aboutPageUserFields != null) {
            String str;
            if (!(aboutPageUserFields.mo383l() == null || this.f13047i == null)) {
                this.f13047i.f13048a = aboutPageUserFields.mo383l().m14634a();
                this.f13047i.f13049b = aboutPageUserFields.mo383l().m14638b();
            }
            TimelineAppSectionsStructuredNameModel k = aboutPageUserFields.mo382k();
            if (k == null || k.m14602b() == null) {
                str = null;
            } else {
                String b = k.m14602b();
                ImmutableList a = k.m14601a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    PartsModel partsModel = (PartsModel) a.get(i);
                    if (GraphQLStructuredNamePart.FIRST.equals(partsModel.m14597c())) {
                        i = b.offsetByCodePoints(0, partsModel.m14596b());
                        str = b.substring(i, b.offsetByCodePoints(i, partsModel.m14592a()));
                        break;
                    }
                }
                str = b;
            }
            this.aM = str;
            ((CollectionsSummaryAdapter) this.an).f13594p = aboutPageUserFields.mo381a();
            if (aboutPageUserFields instanceof AppSectionInfoModel) {
                m14824a(((AppSectionInfoModel) aboutPageUserFields).m14513j());
            }
            if (aboutPageUserFields instanceof AboutSectionInfoModel) {
                m14823a(((AboutSectionInfoModel) aboutPageUserFields).m13954j());
            }
        }
    }

    public final void mo419b(Object obj) {
        obj = (AboutPageUserFields) obj;
        super.mo419b(obj);
        if (obj != null) {
            this.ao.m13760c();
        }
    }

    protected final Object az() {
        return null;
    }

    public final void mo420c(Bundle bundle) {
        Class cls = CollectionsSummaryFragment.class;
        m14825a((Object) this, getContext());
        super.mo420c(bundle);
        if (bundle != null) {
            this.aL = bundle.getBoolean("refresh_next_resume", false);
            this.aN = (ParcelUuid) bundle.getParcelable("fragment_uuid");
        } else {
            this.aN = new ParcelUuid(SafeUUIDGenerator.a());
        }
        this.f13046h.e = this.aN;
        this.aI = new FbEventSubscriberListManager();
        this.aK = new CollectionItemsLoggingViewportListener(this.aw, this.f13046h);
        CollectionsSummaryControllerProvider collectionsSummaryControllerProvider = this.ax;
        Context context = getContext();
        ProfileViewerContext profileViewerContext = this.f13046h;
        this.aJ = new CollectionsSummaryController(context, profileViewerContext, this.aw, FbUriIntentHandler.a(collectionsSummaryControllerProvider), CollectionsCurationController.m13746a(collectionsSummaryControllerProvider), RedirectToUriController.m13825a(collectionsSummaryControllerProvider), DeleteExperienceController.m13797b(collectionsSummaryControllerProvider));
        this.aJ.m14802a(this.aI, this);
        aL();
        this.aH.a(this.at);
    }

    public final View mo408a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1090211414);
        View a2 = super.mo408a(layoutInflater, viewGroup, bundle);
        this.aC.a(this.f13040b, am_(), this);
        if (aB()) {
            this.f13043e.a(this.aP);
        } else {
            this.f13043e.a(this.an);
        }
        this.az.a(this.aK);
        LogUtils.f(-1727723522, a);
        return a2;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 940755230);
        super.mi_();
        this.f13043e.a(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 102221605, a);
    }

    public final void mo406G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2028686686);
        super.mo406G();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131234888);
        }
        this.aI.a(this.au);
        if (this.aL) {
            m13819e();
            CollectionsSummaryAdapter collectionsSummaryAdapter = (CollectionsSummaryAdapter) this.an;
            collectionsSummaryAdapter.f13580b.clear();
            collectionsSummaryAdapter.mo405a(true);
            this.aL = false;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -258495305, a);
    }

    protected final String at() {
        return StringFormatUtil.a("profile/%s/aboutpage?is_combined=%b&v=7", new Object[]{this.f13046h.a, Boolean.valueOf(aJ())});
    }

    protected final BatchConfiguration au() {
        String str;
        SummaryInitialConnectionConfiguration a = this.aE.m14854a(this.f13046h.a);
        if (a.f13655b.a(ExperimentsForTimelineAbTestModule.ax, false) || !a.f13660g.m13765d()) {
            str = null;
        } else {
            str = "collections_sections_end_cursor";
        }
        return new SequentialBatchConfiguration(a, str, this.aF.m14859a(this.f13046h.a), 86400);
    }

    protected final RowIterator av() {
        return null;
    }

    protected final CursorAdapter aw() {
        return this.aP;
    }

    public final Adapter ay() {
        if (aB()) {
            this.aP = this.aD.m14817a(getContext(), this.f13046h, this.aw);
        }
        InjectorLike injectorLike = this.ay;
        Context context = getContext();
        ProfileViewerContext profileViewerContext = this.f13046h;
        MutualFriendsInfo mutualFriendsInfo = this.f13047i;
        return new CollectionsSummaryAdapter(context, profileViewerContext, mutualFriendsInfo, CollectionsViewFactory.m14940a(injectorLike), this.aw, CollectionsSummaryItemsListFactory.m14840a(injectorLike), CollectionSummaryItemRenderer.m14785a(injectorLike));
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1005352204);
        super.mj_();
        if (this.f13043e != null) {
            this.f13043e.a(null);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1061973653, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1694808639);
        super.mY_();
        this.az.b(this.aK);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 62780970, a);
    }

    public final void mo421I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 104619974);
        super.mo421I();
        this.aH.b(this.at);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2038746033, a);
    }

    public final void mo407H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 607018576);
        super.mo407H();
        this.aI.b(this.au);
        this.az.c(this.f13043e);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1365595344, a);
    }

    public final void m14838e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("refresh_next_resume", this.aL);
        bundle.putParcelable("fragment_uuid", this.aN);
    }

    private boolean aJ() {
        return this.aB.a(ExperimentsForTimelineAbTestModule.ax, false);
    }

    protected final ListenableFuture<AboutPageUserFields> mo409a(boolean z) {
        if (aJ()) {
            CollectionsQueryExecutor collectionsQueryExecutor = this.al;
            GraphQLRequest a = GraphQLRequest.a(collectionsQueryExecutor.m13771a(String.valueOf(this.f13046h.a), null)).a(86400).a(CollectionsQueryExecutor.m13767a(z));
            if (1 != 0) {
                a.q = null;
            }
            return Futures.a(GraphQLQueryExecutor.a(collectionsQueryExecutor.f13013a.a(a)), new C15401(collectionsQueryExecutor), collectionsQueryExecutor.f13017e);
        }
        return this.al.m13776a(z, String.valueOf(this.f13046h.a), 4, this.aG.booleanValue(), null);
    }

    protected final CollectionsAnalyticsLogger aG() {
        return this.aw;
    }

    protected final CollectionsFragmentType aA() {
        return CollectionsFragmentType.SUMMARY;
    }

    public final void aH() {
        ax();
    }

    private void m14823a(ProfileFieldSectionsModel profileFieldSectionsModel) {
        Preconditions.checkState(!aB());
        if (profileFieldSectionsModel != null && profileFieldSectionsModel.m14112a() != null) {
            CollectionsSummaryAdapter collectionsSummaryAdapter = (CollectionsSummaryAdapter) this.an;
            collectionsSummaryAdapter.f13582d.clear();
            collectionsSummaryAdapter.f13583e.clear();
            collectionsSummaryAdapter.mo405a(true);
            ImmutableList a = profileFieldSectionsModel.m14112a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                collectionsSummaryAdapter.m14794a((ProfileFieldSectionInfoModel) a.get(i));
            }
            AdapterDetour.a(collectionsSummaryAdapter, 1069994308);
            if (!collectionsSummaryAdapter.f13593o) {
                collectionsSummaryAdapter.m14798e();
                AdapterDetour.a(collectionsSummaryAdapter, 618772239);
                collectionsSummaryAdapter.f13593o = true;
                m14826a(null);
            }
        }
    }

    private void m14824a(TimelineCollectionAppSectionsFieldsModel timelineCollectionAppSectionsFieldsModel) {
        Preconditions.checkState(!aB());
        if (timelineCollectionAppSectionsFieldsModel != null && timelineCollectionAppSectionsFieldsModel.m14614a() != null) {
            CollectionsSummaryAdapter collectionsSummaryAdapter = (CollectionsSummaryAdapter) this.an;
            collectionsSummaryAdapter.f13580b.clear();
            collectionsSummaryAdapter.f13581c.clear();
            collectionsSummaryAdapter.mo405a(true);
            ImmutableList a = timelineCollectionAppSectionsFieldsModel.m14614a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                collectionsSummaryAdapter.m14795a((CollectionsAppSectionWithItemsOrRequestablesModel) a.get(i));
            }
            AdapterDetour.a(collectionsSummaryAdapter, 298777974);
            this.aO = timelineCollectionAppSectionsFieldsModel.m14615b();
            if (!collectionsSummaryAdapter.f13593o) {
                collectionsSummaryAdapter.m14798e();
                AdapterDetour.a(collectionsSummaryAdapter, 48002109);
                collectionsSummaryAdapter.f13593o = true;
                aK(this);
            }
        }
    }

    public static void aK(CollectionsSummaryFragment collectionsSummaryFragment) {
        if (collectionsSummaryFragment.aO == null || !collectionsSummaryFragment.aO.m14610b() || Strings.isNullOrEmpty(collectionsSummaryFragment.aO.m14608a())) {
            ((CollectionsSummaryAdapter) collectionsSummaryFragment.an).f13593o = false;
            collectionsSummaryFragment.an.mo405a(false);
            collectionsSummaryFragment.ao.m13761c(collectionsSummaryFragment.aA());
            collectionsSummaryFragment.ao.m13759b(collectionsSummaryFragment.aA());
            if (collectionsSummaryFragment.f13042d != null) {
                collectionsSummaryFragment.f13042d.f();
                return;
            }
            return;
        }
        collectionsSummaryFragment.m14826a(collectionsSummaryFragment.aO.m14608a());
    }

    private void m14826a(@Nullable final String str) {
        Preconditions.checkState(!aB());
        if (this.al != null && this.am != null && !aB()) {
            this.am.a("sections page", new Callable<ListenableFuture<TimelineCollectionAppSectionsModel>>(this) {
                final /* synthetic */ CollectionsSummaryFragment f13627b;

                public Object call() {
                    CollectionsQueryExecutor collectionsQueryExecutor = this.f13627b.al;
                    GraphQLRequest a = GraphQLRequest.a(collectionsQueryExecutor.m13772a(String.valueOf(this.f13627b.f13046h.a), 4, this.f13627b.aG.booleanValue(), str)).a(GraphQLCachePolicy.c);
                    if (1 != 0) {
                        a.q = null;
                    }
                    return GraphQLQueryExecutor.a(collectionsQueryExecutor.f13013a.a(a));
                }
            }, new C15742(this));
        }
    }

    private void aL() {
        this.aH = new FbEventSubscriberListManager();
        this.aH.a(new SendInfoRequestEventSubscriber(this, this.aN) {
            final /* synthetic */ CollectionsSummaryFragment f13629b;

            public final void m14820b(FbEvent fbEvent) {
                SendInfoRequestEvent sendInfoRequestEvent = (SendInfoRequestEvent) fbEvent;
                if (sendInfoRequestEvent.b != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("profile_name", this.f13629b.aM);
                    bundle.putParcelable("fragment_id", this.f13629b.aN);
                    ((FbUriIntentHandler) this.f13629b.av.get()).a(this.f13629b.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.bg, this.f13629b.f13046h.a, sendInfoRequestEvent.b), bundle);
                }
            }
        });
        this.aH.a(new InfoRequestSentNavigationEventSubscriber(this, this.aN) {
            final /* synthetic */ CollectionsSummaryFragment f13630b;

            public final void m14821b(FbEvent fbEvent) {
                this.f13630b.aL = true;
            }
        });
    }

    private void m14822a(InfoRequestEventBus infoRequestEventBus, CollectionsEventBus collectionsEventBus, Provider<FbUriIntentHandler> provider, CollectionsSummaryAnalyticsLogger collectionsSummaryAnalyticsLogger, CollectionsSummaryControllerProvider collectionsSummaryControllerProvider, CollectionsSummaryAdapterProvider collectionsSummaryAdapterProvider, ViewportMonitor viewportMonitor, CollectionItemsLoggingViewportListenerProvider collectionItemsLoggingViewportListenerProvider, QeAccessor qeAccessor, AnalyticsTagger analyticsTagger, CollectionsSummaryCursorAdaptorProvider collectionsSummaryCursorAdaptorProvider, SummaryInitialConnectionConfigurationProvider summaryInitialConnectionConfigurationProvider, SummaryTailConnectionConfigurationProvider summaryTailConnectionConfigurationProvider, Boolean bool) {
        this.at = infoRequestEventBus;
        this.au = collectionsEventBus;
        this.av = provider;
        this.aw = collectionsSummaryAnalyticsLogger;
        this.ax = collectionsSummaryControllerProvider;
        this.ay = collectionsSummaryAdapterProvider;
        this.az = viewportMonitor;
        this.aA = collectionItemsLoggingViewportListenerProvider;
        this.aB = qeAccessor;
        this.aC = analyticsTagger;
        this.aD = collectionsSummaryCursorAdaptorProvider;
        this.aE = summaryInitialConnectionConfigurationProvider;
        this.aF = summaryTailConnectionConfigurationProvider;
        this.aG = bool;
    }

    public final String am_() {
        return "collections_overview";
    }

    public final Map<String, Object> m14836c() {
        Map<String, Object> c = Maps.c();
        c.put("profile_id", this.f13046h.a);
        return c;
    }

    public final void m14832a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (i == 0) {
            this.az.b(scrollingViewProxy);
        }
    }

    public final void m14833a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        this.az.a(scrollingViewProxy, i, i2, i3);
        ax();
    }
}
