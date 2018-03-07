package com.facebook.timeline.aboutpage.collection;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.base.fragment.IRefreshableFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.feed.ui.GenericNotificationBanner;
import com.facebook.feed.ui.GenericNotificationBanner.NotificationBannerType;
import com.facebook.feed.util.FeedNetworkConnectivityReceiver;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.connection.ConnectionTailLoaderManager;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.Callbacks;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.ConnectionTailLoaderManagerProvider;
import com.facebook.graphql.connection.configuration.SequentialBatchConfiguration;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManager;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManagerProvider;
import com.facebook.graphql.cursor.ModelCursor;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.CollectionsCurationController;
import com.facebook.timeline.aboutpage.CollectionsPerformanceLogger;
import com.facebook.timeline.aboutpage.CollectionsPerformanceLogger.CollectionsFragmentType;
import com.facebook.timeline.aboutpage.CollectionsQeHelper;
import com.facebook.timeline.aboutpage.CollectionsQueryExecutor;
import com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder;
import com.facebook.timeline.aboutpage.StandardCollectionSizes;
import com.facebook.timeline.aboutpage.events.CollectionsEventBus;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLModels.CollectionWithItemsAndSuggestionsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel.CollectionsModel.Builder;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;

/* compiled from: More parameters are required */
public class CollectionsCollectionFragment extends FbFragment implements OnScrollListener, AnalyticsFragmentWithExtraData, IRefreshableFragment {
    private static final CollectionsFragmentType aF = CollectionsFragmentType.COLLECTION;
    @Inject
    @LoggedInUserId
    String f13108a;
    private String aA;
    public FeedNetworkConnectivityReceiver aB;
    public boolean aC = false;
    public boolean aD = false;
    private int aE = 0;
    private ProfileViewerContext aG;
    public String aH;
    public String aI;
    public ConnectionTailLoaderManager aJ;
    private LocalModelCursorLoaderManager aK;
    @Inject
    StandardCollectionSizes al;
    @Inject
    CollectionsQueryExecutor am;
    @Inject
    TasksManager an;
    @Inject
    CollectionsCollectionAdapterProvider ao;
    @Inject
    CollectionsCollectionCursorAdaptorProvider ap;
    @Inject
    CollectionInitialConnectionConfigurationProvider aq;
    @Inject
    CollectionTailConnectionConfigurationProvider ar;
    @Inject
    ConnectionTailLoaderManagerProvider as;
    @Inject
    LocalModelCursorLoaderManagerProvider at;
    private BetterListView au;
    public CollectionsCollectionAdapter av;
    public CollectionsCollectionCursorAdaptor aw;
    public RefreshableViewContainerLike ax;
    private FbEventSubscriberListManager ay;
    public GenericNotificationBanner az;
    @Inject
    CollectionsCollectionAnalyticsLogger f13109b;
    @Inject
    CollectionsPerformanceLogger f13110c;
    @Inject
    CollectionsCurationController f13111d;
    @Inject
    CollectionsEventBus f13112e;
    public FetchTimelineSingleCollectionViewQueryModel f13113f;
    @Inject
    CollectionsQeHelper f13114g;
    @Inject
    FbNetworkManager f13115h;
    @Inject
    AbstractFbErrorReporter f13116i;

    /* compiled from: More parameters are required */
    class C15571 implements Callbacks {
        final /* synthetic */ CollectionsCollectionFragment f13098a;

        C15571(CollectionsCollectionFragment collectionsCollectionFragment) {
            this.f13098a = collectionsCollectionFragment;
        }

        public final void m13858a(ModelCursor modelCursor) {
            if (this.f13098a.aw != null) {
                if (modelCursor != null) {
                    this.f13098a.f13110c.m13758a(false);
                    CollectionsCollectionFragment.aq(this.f13098a);
                }
                this.f13098a.aw.a(modelCursor);
            }
            if (this.f13098a.ax != null && modelCursor != null && modelCursor.getCount() > 0 && !this.f13098a.aJ.c()) {
                this.f13098a.ax.f();
            }
        }

        public final void m13859a(Throwable th) {
            this.f13098a.m13883a(th);
        }

        public final void m13860a(boolean z) {
        }
    }

    /* compiled from: More parameters are required */
    class C15593 extends AbstractDisposableFutureCallback<FetchTimelineSingleCollectionViewQueryModel> {
        final /* synthetic */ CollectionsCollectionFragment f13102a;

        C15593(CollectionsCollectionFragment collectionsCollectionFragment) {
            this.f13102a = collectionsCollectionFragment;
        }

        protected final void m13861a(Object obj) {
            CollectionsCollectionFragment.m13870a(this.f13102a, (FetchTimelineSingleCollectionViewQueryModel) obj);
        }

        protected final void m13862a(Throwable th) {
            this.f13102a.m13883a(th);
        }
    }

    /* compiled from: More parameters are required */
    class C15615 extends AbstractDisposableFutureCallback<CollectionWithItemsAndSuggestionsModel> {
        final /* synthetic */ CollectionsCollectionFragment f13105a;

        C15615(CollectionsCollectionFragment collectionsCollectionFragment) {
            this.f13105a = collectionsCollectionFragment;
        }

        public final void m13863a(Object obj) {
            CollectionsCollectionFragment.m13869a(this.f13105a, (CollectionWithItemsAndSuggestionsModel) obj);
        }

        public final void m13864a(Throwable th) {
            this.f13105a.m13883a(th);
        }
    }

    /* compiled from: More parameters are required */
    class C15626 extends OnRefreshListener {
        final /* synthetic */ CollectionsCollectionFragment f13106a;

        C15626(CollectionsCollectionFragment collectionsCollectionFragment) {
            this.f13106a = collectionsCollectionFragment;
        }

        public final void m13865b(boolean z) {
            if (z) {
                this.f13106a.m13886e();
            }
        }
    }

    public static void m13871a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CollectionsCollectionFragment) obj).m13873a(String_LoggedInUserIdMethodAutoProvider.a(injectorLike), CollectionsCollectionAnalyticsLogger.m13850a(injectorLike), CollectionsPerformanceLogger.m13751a(injectorLike), CollectionsCurationController.m13746a(injectorLike), CollectionsEventBus.m13930a(injectorLike), CollectionsQeHelper.m13762a(injectorLike), FbNetworkManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StandardCollectionSizes.m13827a(injectorLike), CollectionsQueryExecutor.m13769a(injectorLike), TasksManager.a(injectorLike), (CollectionsCollectionAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CollectionsCollectionAdapterProvider.class), (CollectionsCollectionCursorAdaptorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CollectionsCollectionCursorAdaptorProvider.class), (CollectionInitialConnectionConfigurationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CollectionInitialConnectionConfigurationProvider.class), (CollectionTailConnectionConfigurationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CollectionTailConnectionConfigurationProvider.class), (ConnectionTailLoaderManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ConnectionTailLoaderManagerProvider.class), (LocalModelCursorLoaderManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LocalModelCursorLoaderManagerProvider.class));
    }

    public static CollectionsCollectionFragment m13867a(String str, String str2, String str3, String str4, String str5, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType, String str6, DefaultImageFields defaultImageFields, CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions) {
        Bundle bundle = new Bundle();
        bundle.putString("profile_id", str);
        bundle.putString("section_id", str2);
        bundle.putString("collection_id", str3);
        bundle.putString("friendship_status", str4);
        bundle.putString("subscribe_status", str5);
        bundle.putSerializable("collections_section_type", graphQLTimelineAppSectionType);
        bundle.putString("view_name", str6);
        FlatBufferModelHelper.a(bundle, "collections_icon", defaultImageFields);
        FlatBufferModelHelper.a(bundle, "collection", collectionWithItemsAndSuggestions);
        CollectionsCollectionFragment collectionsCollectionFragment = new CollectionsCollectionFragment();
        collectionsCollectionFragment.g(bundle);
        return collectionsCollectionFragment;
    }

    public final void m13885c(Bundle bundle) {
        super.c(bundle);
        Class cls = CollectionsCollectionFragment.class;
        m13871a((Object) this, getContext());
        this.f13110c.m13756a(aF);
        if (bundle != null) {
            m13877n(bundle);
        } else {
            m13877n(this.s);
        }
        this.ay = new FbEventSubscriberListManager();
        this.f13111d.m13748a(getContext(), this.aG, this.ay);
    }

    private void m13877n(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        if (this.f13108a == null) {
            this.f13116i.a("timeline_invalid_meuser", "logged in user: " + this.f13108a);
        }
        Preconditions.checkNotNull(this.f13108a);
        m13868a(bundle, this.f13108a);
        if (au()) {
            this.aA = CollectionsUriIntentBuilder.m13784a(this.f13108a, this.aH, this.aI);
            this.aw = this.ap.m13857a(this.aG, getContext(), LayoutInflater.from(getContext()), this.f13109b);
            RowIterator rowIterator = null;
            if (this.f13113f != null) {
                rowIterator = CollectionInitialConnectionConfiguration.m13835a(TailFetchLocation.a(0), this.f13113f);
            }
            ConnectionTailLoaderManagerProvider connectionTailLoaderManagerProvider = this.as;
            String str = this.aA;
            CollectionInitialConnectionConfiguration a = this.aq.m13839a(this.aH, this.aI);
            InjectorLike injectorLike = this.ar;
            this.aJ = connectionTailLoaderManagerProvider.a(str, new SequentialBatchConfiguration(a, new CollectionTailConnectionConfiguration(this.aI, CollectionsQueryExecutor.m13769a(injectorLike), StandardCollectionSizes.m13827a(injectorLike), CollectionsQeHelper.m13763b(injectorLike)), 86400), new C15571(this), rowIterator);
            this.aK = this.at.a(this.aA, this.aJ);
            this.aK.a();
            this.f13110c.m13758a(true);
        }
        this.av = this.ao.m13849a(getContext(), this.aG, this.f13109b, LayoutInflater.from(getContext()));
        if (this.f13113f != null) {
            this.av.m13847a(this.f13113f);
        }
        this.f13110c.m13757a(aF, this.f13113f != null);
        if (!au()) {
            m13874a(false);
        }
    }

    private void m13868a(Bundle bundle, String str) {
        this.aI = (String) Preconditions.checkNotNull(bundle.getString("collection_id"));
        this.aG = new ProfileViewerContext((String) Preconditions.checkNotNull(bundle.getString("profile_id")), str, GraphQLFriendshipStatus.fromString(bundle.getString("friendship_status")), GraphQLSubscribeStatus.fromString(bundle.getString("subscribe_status")));
        this.aH = (String) Preconditions.checkNotNull(bundle.getString("section_id"));
        this.f13113f = m13878o(bundle);
    }

    private FetchTimelineSingleCollectionViewQueryModel m13878o(Bundle bundle) {
        CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions = (CollectionWithItemsAndSuggestions) FlatBufferModelHelper.a(bundle, "collection");
        if (collectionWithItemsAndSuggestions != null) {
            Object obj = (collectionWithItemsAndSuggestions.nU_() == null || collectionWithItemsAndSuggestions.nU_().m14346b() == null || collectionWithItemsAndSuggestions.nU_().m14346b().isEmpty()) ? null : 1;
            if (obj != null) {
                ImmutableList of = ImmutableList.of(CollectionWithItemsAndSuggestionsModel.m14673a(collectionWithItemsAndSuggestions));
                Builder builder = new Builder();
                builder.f13500a = of;
                Builder builder2 = builder;
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder2.f13500a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                CollectionsModel collectionsModel = new CollectionsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                FetchTimelineSingleCollectionViewQueryModel.Builder builder3 = new FetchTimelineSingleCollectionViewQueryModel.Builder();
                builder3.f13490a = collectionsModel;
                String string = bundle.getString("view_name");
                String string2 = bundle.getString("section_id");
                Serializable serializable = bundle.getSerializable("collections_section_type");
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) FlatBufferModelHelper.a(bundle, "collections_icon");
                if (string == null || string2 == null || serializable == null || defaultImageFieldsModel == null) {
                    String str;
                    String str2;
                    String str3 = "CollectionCollectionFragment was passed a preliminary collection but was missing: ";
                    if (string == null) {
                        str3 = str3 + "name, ";
                    }
                    if (string2 == null) {
                        str3 = str3 + "sectionId, ";
                    }
                    if (serializable == null) {
                        str = str3 + "sectionTypeArg, ";
                    } else {
                        str = str3;
                    }
                    if (defaultImageFieldsModel == null) {
                        str2 = str + "icon, ";
                    } else {
                        str2 = str;
                    }
                    this.f13116i.a("collections_collection_prelim", str2);
                    return null;
                }
                builder3.f13492c = string2;
                builder3.f13493d = string;
                builder3.f13491b = defaultImageFieldsModel;
                builder3.f13494e = (GraphQLTimelineAppSectionType) serializable;
                return builder3.m14717a();
            }
        }
        return null;
    }

    public final void m13887e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("profile_id", this.aG.a);
        bundle.putString("section_id", this.aH);
        bundle.putString("collection_id", this.aI);
        bundle.putString("friendship_status", this.aG.c.toString());
        bundle.putString("subscribe_status", this.aG.d.toString());
        if (this.f13113f != null && this.f13113f.m14735k() != null) {
            bundle.putString("view_name", this.f13113f.mo390d());
            FlatBufferModelHelper.a(bundle, "collections_icon", this.f13113f.m14736l());
            bundle.putSerializable("collections_section_type", this.f13113f.nP_());
            FlatBufferModelHelper.a(bundle, "collection", this.f13113f.m14735k().m14722a().get(0));
        }
    }

    private void m13874a(final boolean z) {
        Preconditions.checkState(!au());
        final int h = this.al.m13829h() * 3;
        this.an.a("initial fetch", new Callable<ListenableFuture<FetchTimelineSingleCollectionViewQueryModel>>(this) {
            final /* synthetic */ CollectionsCollectionFragment f13101c;

            public Object call() {
                CollectionsQueryExecutor collectionsQueryExecutor = this.f13101c.am;
                boolean z = z;
                String str = this.f13101c.aH;
                String str2 = this.f13101c.aI;
                int i = h;
                StandardCollectionSizes standardCollectionSizes = this.f13101c.al;
                return collectionsQueryExecutor.m13777a(z, str, str2, i, 4);
            }
        }, new C15593(this));
    }

    private void m13872a(final String str) {
        Preconditions.checkState(!au());
        this.an.a("items page", new Callable<ListenableFuture<CollectionWithItemsAndSuggestionsModel>>(this) {
            final /* synthetic */ CollectionsCollectionFragment f13104b;

            public Object call() {
                CollectionsQueryExecutor collectionsQueryExecutor = this.f13104b.am;
                GraphQLRequest a = GraphQLRequest.a(collectionsQueryExecutor.m13773a(this.f13104b.aI, str, this.f13104b.av.f13084r.mo371a())).a(GraphQLCachePolicy.c);
                if (1 != 0) {
                    a.q = null;
                }
                return GraphQLQueryExecutor.a(collectionsQueryExecutor.f13013a.a(a));
            }
        }, new C15615(this));
    }

    public final View m13882a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1883055906);
        View inflate = layoutInflater.inflate(2130903607, viewGroup, false);
        this.ax = (RefreshableViewContainerLike) inflate.findViewById(2131560406);
        this.ax.setOnRefreshListener(new C15626(this));
        this.au = (BetterListView) this.ax.c().findViewById(16908298);
        this.au.setEmptyView(inflate.findViewById(16908292));
        this.au.setOnScrollListener(this);
        View b = m13876b(getContext());
        View b2 = m13876b(getContext());
        this.au.addHeaderView(b, null, false);
        this.au.addFooterView(b2, null, false);
        if (au()) {
            this.au.setAdapter(this.aw);
        } else {
            this.au.setAdapter(this.av);
        }
        this.au.setDescendantFocusability(262144);
        this.av.m13848a(true);
        this.az = (GenericNotificationBanner) inflate.findViewById(2131560231);
        this.aB = new FeedNetworkConnectivityReceiver(this, getContext()) {
            final /* synthetic */ CollectionsCollectionFragment f13107a;

            public final void m13866a(Context context, Intent intent) {
                if (this == this.f13107a.aB && this.f13107a.av != null) {
                    boolean d = this.f13107a.f13115h.d();
                    if (this.f13107a.az != null) {
                        if (d) {
                            this.f13107a.az.a();
                        } else {
                            this.f13107a.az.a(NotificationBannerType.NO_CONNECTION);
                        }
                    }
                    if (d && !this.f13107a.aD && this.f13107a.aC && this.f13107a.av.getCount() < 20) {
                        this.f13107a.aD = true;
                        this.f13107a.aC = false;
                        this.f13107a.m13886e();
                    }
                }
            }
        };
        LogUtils.f(-1375184120, a);
        return inflate;
    }

    private void m13873a(String str, CollectionsCollectionAnalyticsLogger collectionsCollectionAnalyticsLogger, CollectionsPerformanceLogger collectionsPerformanceLogger, CollectionsCurationController collectionsCurationController, CollectionsEventBus collectionsEventBus, CollectionsQeHelper collectionsQeHelper, FbNetworkManager fbNetworkManager, AbstractFbErrorReporter abstractFbErrorReporter, StandardCollectionSizes standardCollectionSizes, CollectionsQueryExecutor collectionsQueryExecutor, TasksManager tasksManager, CollectionsCollectionAdapterProvider collectionsCollectionAdapterProvider, CollectionsCollectionCursorAdaptorProvider collectionsCollectionCursorAdaptorProvider, CollectionInitialConnectionConfigurationProvider collectionInitialConnectionConfigurationProvider, CollectionTailConnectionConfigurationProvider collectionTailConnectionConfigurationProvider, ConnectionTailLoaderManagerProvider connectionTailLoaderManagerProvider, LocalModelCursorLoaderManagerProvider localModelCursorLoaderManagerProvider) {
        this.f13108a = str;
        this.f13109b = collectionsCollectionAnalyticsLogger;
        this.f13110c = collectionsPerformanceLogger;
        this.f13111d = collectionsCurationController;
        this.f13112e = collectionsEventBus;
        this.f13114g = collectionsQeHelper;
        this.f13115h = fbNetworkManager;
        this.f13116i = abstractFbErrorReporter;
        this.al = standardCollectionSizes;
        this.am = collectionsQueryExecutor;
        this.an = tasksManager;
        this.ao = collectionsCollectionAdapterProvider;
        this.ap = collectionsCollectionCursorAdaptorProvider;
        this.aq = collectionInitialConnectionConfigurationProvider;
        this.ar = collectionTailConnectionConfigurationProvider;
        this.as = connectionTailLoaderManagerProvider;
        this.at = localModelCursorLoaderManagerProvider;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1138569260);
        super.mY_();
        if (this.ax != null) {
            this.ax.setOnRefreshListener(null);
        }
        if (this.au != null) {
            this.au.setAdapter(null);
        }
        this.ax = null;
        this.au = null;
        this.az = null;
        this.aB = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2110435186, a);
    }

    public final void m13881I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 376601877);
        if (this.an != null) {
            this.an.c();
            this.an = null;
        }
        if (this.aK != null) {
            this.aK.close();
            this.aK = null;
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 483023555, a);
    }

    public final void m13886e() {
        as();
        if (!au()) {
            this.am.m13778a(this.aI);
            m13874a(true);
        } else if (this.aJ != null) {
            this.aJ.a();
        }
        if (this.ax != null) {
            this.ax.d();
        }
    }

    public static void m13870a(CollectionsCollectionFragment collectionsCollectionFragment, FetchTimelineSingleCollectionViewQueryModel fetchTimelineSingleCollectionViewQueryModel) {
        if (collectionsCollectionFragment.av != null && collectionsCollectionFragment.f13110c != null) {
            collectionsCollectionFragment.av.m13845a();
            collectionsCollectionFragment.av.m13847a(fetchTimelineSingleCollectionViewQueryModel);
            collectionsCollectionFragment.f13110c.m13761c(aF);
            collectionsCollectionFragment.ar();
        }
    }

    public static void m13869a(CollectionsCollectionFragment collectionsCollectionFragment, CollectionWithItemsAndSuggestionsModel collectionWithItemsAndSuggestionsModel) {
        collectionsCollectionFragment.av.m13846a((CollectionWithItemsAndSuggestions) collectionWithItemsAndSuggestionsModel);
        CollectionsPerformanceLogger collectionsPerformanceLogger = collectionsCollectionFragment.f13110c;
        collectionsPerformanceLogger.f13007a.d(1703971);
        collectionsPerformanceLogger.f13007a.b(1703970, (short) 2);
        collectionsCollectionFragment.ar();
    }

    public static void aq(CollectionsCollectionFragment collectionsCollectionFragment) {
        if (!collectionsCollectionFragment.f13109b.f12998b) {
            collectionsCollectionFragment.f13109b.m13740a(collectionsCollectionFragment.aG.a, CollectionsAnalyticsLogger.m13739a(collectionsCollectionFragment.aG));
        }
    }

    private void ar() {
        aq(this);
        this.av.m13848a(false);
        if (this.ax != null) {
            this.ax.f();
        }
        if (this.az != null) {
            if (this.f13115h.d()) {
                this.aC = false;
                this.az.a();
            } else {
                this.az.a(NotificationBannerType.NO_CONNECTION);
            }
        }
        AdapterDetour.a(this.av, -421962482);
    }

    public final void m13883a(Throwable th) {
        if (this.av != null && this.f13110c != null) {
            this.av.m13848a(false);
            this.f13110c.m13759b(aF);
            if (au()) {
                this.f13110c.f13007a.b(1703992, (short) 3);
            }
            if (!(th instanceof CancellationException) && this.ax != null && this.az != null) {
                this.aC = true;
                this.ax.f();
                if (this.az != null) {
                    this.az.a(this.f13115h.d() ? NotificationBannerType.FETCH_TIMELINE_FAILED : NotificationBannerType.NO_CONNECTION);
                }
            }
        }
    }

    @VisibleForTesting
    private static boolean m13875a(int i, int i2, int i3) {
        if (i2 > 0 && (i3 - i) / i2 < 2) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScroll(android.widget.AbsListView r5, int r6, int r7, int r8) {
        /*
        r4 = this;
        r1 = 1;
        r2 = r4.au();
        r0 = m13875a(r6, r7, r8);
        if (r0 == 0) goto L_0x0046;
    L_0x000b:
        if (r2 != 0) goto L_0x002e;
    L_0x000d:
        r0 = r4.av;
        r3 = r0.f13080n;
        r0 = r3;
        if (r0 != 0) goto L_0x0046;
    L_0x0014:
        r0 = r4.av;
        r3 = r0.f13085s;
        if (r3 == 0) goto L_0x002a;
    L_0x001a:
        r3 = r0.f13085s;
        r3 = r3.b();
        if (r3 == 0) goto L_0x002a;
    L_0x0022:
        r3 = r0.f13085s;
        r3 = r3.a();
        if (r3 != 0) goto L_0x0059;
    L_0x002a:
        r3 = 0;
    L_0x002b:
        r0 = r3;
        if (r0 == 0) goto L_0x0046;
    L_0x002e:
        r0 = r1;
    L_0x002f:
        if (r0 == 0) goto L_0x003c;
    L_0x0031:
        if (r2 == 0) goto L_0x0048;
    L_0x0033:
        r0 = r4.aJ;
        if (r0 == 0) goto L_0x003c;
    L_0x0037:
        r0 = r4.aJ;
        r0.b();
    L_0x003c:
        r0 = r4.aE;
        if (r0 == r6) goto L_0x0043;
    L_0x0040:
        r4.as();
    L_0x0043:
        r4.aE = r6;
        return;
    L_0x0046:
        r0 = 0;
        goto L_0x002f;
    L_0x0048:
        r0 = r4.av;
        r0.m13848a(r1);
        r0 = r4.av;
        r3 = r0.f13085s;
        if (r3 != 0) goto L_0x005b;
    L_0x0053:
        r3 = 0;
    L_0x0054:
        r0 = r3;
        r4.m13872a(r0);
        goto L_0x003c;
    L_0x0059:
        r3 = 1;
        goto L_0x002b;
    L_0x005b:
        r3 = r0.f13085s;
        r3 = r3.a();
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.collection.CollectionsCollectionFragment.onScroll(android.widget.AbsListView, int, int, int):void");
    }

    private void as() {
        if (this.ax != null) {
            Preconditions.checkArgument(this.ax.c().isFocusable());
            Preconditions.checkArgument(this.ax.c().isFocusableInTouchMode());
            this.ax.c().requestFocus();
        }
        View view = this.T;
        if (view != null) {
            ((InputMethodManager) ao().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private boolean au() {
        return this.f13114g.m13764a();
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void m13879G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1561472424);
        if (this.aB != null) {
            this.aB.a();
        }
        if (this.ay != null) {
            this.ay.a(this.f13112e);
        }
        super.G();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 748441451, a);
    }

    public final void m13880H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1932766787);
        if (this.aB != null) {
            this.aB.b();
        }
        if (this.ay != null) {
            this.ay.b(this.f13112e);
        }
        this.f13110c.m13759b(aF);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -617135509, a);
    }

    private static View m13876b(Context context) {
        Resources resources = context.getResources();
        return CollectionsViewFactory.m14937a(context, resources.getDimensionPixelSize(2131434530) + resources.getDimensionPixelSize(2131434518));
    }

    public final String am_() {
        return "collections_collection";
    }

    public final Map<String, Object> m13884c() {
        Map<String, Object> c = Maps.c();
        c.put("profile_id", this.aG.a);
        return c;
    }
}
