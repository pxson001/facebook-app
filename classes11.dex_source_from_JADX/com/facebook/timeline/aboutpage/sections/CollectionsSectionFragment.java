package com.facebook.timeline.aboutpage.sections;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.BatchConfiguration;
import com.facebook.graphql.connection.configuration.SingleBatchConfiguration;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.CollectionsCurationController;
import com.facebook.timeline.aboutpage.CollectionsPerformanceLogger.CollectionsFragmentType;
import com.facebook.timeline.aboutpage.CollectionsQeHelper;
import com.facebook.timeline.aboutpage.CollectionsQueryExecutor;
import com.facebook.timeline.aboutpage.CollectionsViewFramer;
import com.facebook.timeline.aboutpage.MultiCollectionFragment;
import com.facebook.timeline.aboutpage.MultiCollectionFragment.Adapter;
import com.facebook.timeline.aboutpage.StandardCollectionSizes;
import com.facebook.timeline.aboutpage.events.CollectionsEventBus;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLModels.CollectionWithItemsAndSuggestionsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineCollectionsSectionViewQueryModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineCollectionsSectionViewQueryModel.Builder;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineCollectionsSectionViewQueryModel.CollectionsModel;
import com.facebook.timeline.aboutpage.sections.CollectionsSectionController.C15671;
import com.facebook.timeline.aboutpage.util.TimelineAppSectionUrlBuilder;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.aboutpage.views.ListCollectionItemDataFactory;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: MIDDLE */
public class CollectionsSectionFragment extends MultiCollectionFragment<FetchTimelineCollectionsSectionViewQueryModel> implements AnalyticsFragmentWithExtraData {
    @Inject
    CollectionSectionCursorAdaptorProvider aA;
    @Inject
    SectionsConnectionConfigurationProvider aB;
    private String aC;
    private String aD;
    public CollectionsSectionController aE;
    public FbEventSubscriberListManager aF;
    private CollectionSectionCursorAdaptor aG;
    private SectionsConnectionConfiguration aH;
    @Inject
    StandardCollectionSizes at;
    @Inject
    AnalyticsTagger au;
    @Inject
    CollectionsSectionAnalyticsLogger av;
    @Inject
    CollectionsSectionControllerProvider aw;
    @Inject
    CollectionsEventBus ax;
    @Inject
    CollectionsSectionAdapterProvider ay;
    @Inject
    QeAccessor az;

    public static void m14764a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CollectionsSectionFragment) obj).m14763a(StandardCollectionSizes.m13827a(fbInjector), AnalyticsTagger.a(fbInjector), new CollectionsSectionAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(fbInjector)), (CollectionsSectionControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CollectionsSectionControllerProvider.class), CollectionsEventBus.m13930a(fbInjector), (CollectionsSectionAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CollectionsSectionAdapterProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), (CollectionSectionCursorAdaptorProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CollectionSectionCursorAdaptorProvider.class), (SectionsConnectionConfigurationProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SectionsConnectionConfigurationProvider.class));
    }

    protected final void mo410a(Object obj) {
        ((CollectionsSectionAdapter) this.an).m14757a((FetchTimelineCollectionsSectionViewQueryModel) obj);
    }

    protected final /* synthetic */ Object az() {
        return aJ();
    }

    public final void mo419b(Object obj) {
        obj = (FetchTimelineCollectionsSectionViewQueryModel) obj;
        super.mo419b(obj);
        if (this.an != null) {
            if (obj != null) {
                this.ao.m13761c(aA());
            }
            this.an.mo405a(false);
            this.an.notifyDataSetChanged();
        }
        if (this.f13042d != null) {
            this.f13042d.f();
        }
        this.ao.m13759b(aA());
    }

    public final void mo420c(Bundle bundle) {
        Class cls = CollectionsSectionFragment.class;
        m14764a(this, getContext());
        super.mo420c(bundle);
        CollectionsSectionControllerProvider collectionsSectionControllerProvider = this.aw;
        this.aE = new CollectionsSectionController(getContext(), this.f13046h, FbUriIntentHandler.a(collectionsSectionControllerProvider), CollectionsCurationController.m13746a(collectionsSectionControllerProvider));
        this.aF = new FbEventSubscriberListManager();
        CollectionsSectionController collectionsSectionController = this.aE;
        FbEventSubscriberListManager fbEventSubscriberListManager = this.aF;
        fbEventSubscriberListManager.a(new C15671(collectionsSectionController));
        collectionsSectionController.f13549b.m13748a(collectionsSectionController.f13550c, collectionsSectionController.f13551d, fbEventSubscriberListManager);
    }

    public final View mo408a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1169127029);
        View a2 = super.mo408a(layoutInflater, viewGroup, bundle);
        this.au.a(this.f13040b, am_(), this);
        if (aB()) {
            this.f13043e.a(this.aG);
        } else {
            this.f13043e.a(this.an);
        }
        LogUtils.f(672456766, a);
        return a2;
    }

    protected final String at() {
        return TimelineAppSectionUrlBuilder.m14869a(this.f13046h.a, this.aC);
    }

    private SectionsConnectionConfiguration aI() {
        if (this.aH == null) {
            InjectorLike injectorLike = this.aB;
            this.aH = new SectionsConnectionConfiguration((String) Preconditions.checkNotNull(this.aC), CollectionsQueryExecutor.m13769a(injectorLike), StandardCollectionSizes.m13827a(injectorLike), CollectionStyleMapper.m14915a(injectorLike), CollectionsQeHelper.m13763b(injectorLike));
        }
        return this.aH;
    }

    protected final BatchConfiguration au() {
        return new SingleBatchConfiguration(aI(), 86400);
    }

    protected final RowIterator av() {
        FetchTimelineCollectionsSectionViewQueryModel aJ = aJ();
        if (aJ == null) {
            return null;
        }
        return aI().m14774a(TailFetchLocation.a(0), aJ);
    }

    protected final CursorAdapter aw() {
        return this.aG;
    }

    public final void mo406G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 311225494);
        super.mo406G();
        this.aF.a(this.ax);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1776285885, a);
    }

    public final void mo407H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -153407036);
        super.mo407H();
        this.aF.b(this.ax);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 129856150, a);
    }

    public final Adapter ay() {
        this.aC = this.f13041c.getString("section_id");
        this.aD = this.f13041c.getString("section_tracking");
        if (this.aC == null) {
            ao().finish();
        }
        if (aB()) {
            InjectorLike injectorLike = this.aA;
            Context context = getContext();
            ProfileViewerContext profileViewerContext = this.f13046h;
            LayoutInflater from = LayoutInflater.from(getContext());
            this.aG = new CollectionSectionCursorAdaptor(context, profileViewerContext, from, this.av, CollectionsViewFramer.m13790a(injectorLike), CollectionsViewFactory.m14940a(injectorLike), CollectionStyleMapper.m14915a(injectorLike), ListCollectionItemDataFactory.m14997a(injectorLike));
        }
        return this.ay.m14759a(getContext(), this.f13046h, this.av, LayoutInflater.from(getContext()));
    }

    private FetchTimelineCollectionsSectionViewQueryModel aJ() {
        Preconditions.checkNotNull(this.f13044f);
        Preconditions.checkNotNull(this.f13041c);
        CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions = (CollectionWithItemsAndSuggestions) FlatBufferModelHelper.a(this.f13041c, "collection");
        Builder builder = new Builder();
        if (collectionWithItemsAndSuggestions != null) {
            CollectionWithItemsAndSuggestionsModel a = CollectionWithItemsAndSuggestionsModel.m14673a(collectionWithItemsAndSuggestions);
            CollectionsModel.Builder builder2 = new CollectionsModel.Builder();
            builder2.f13475b = ImmutableList.of(a);
            CollectionsModel.Builder builder3 = builder2;
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a2 = ModelHelper.a(flatBufferBuilder, builder3.f13475b);
            int a3 = ModelHelper.a(flatBufferBuilder, builder3.f13476c);
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, builder3.f13474a, 0);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            builder.f13464a = new CollectionsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }
        String string = this.f13041c.getString("view_name");
        if (string != null) {
            builder.f13467d = string;
        } else if (collectionWithItemsAndSuggestions != null) {
            this.f13044f.a("collections_section_prelim", "Provided COLLECTION but no VIEW_NAME");
        }
        builder.f13465b = (DefaultImageFieldsModel) ((DefaultImageFields) FlatBufferModelHelper.a(this.f13041c, "collections_icon"));
        if (this.aC != null) {
            builder.f13466c = this.aC;
        }
        if (this.aD != null) {
            builder.f13472i = this.aD;
        }
        return builder.m14695a();
    }

    protected final CollectionsAnalyticsLogger aG() {
        return this.av;
    }

    protected final ListenableFuture<FetchTimelineCollectionsSectionViewQueryModel> mo409a(boolean z) {
        CollectionsQueryExecutor collectionsQueryExecutor = this.al;
        GraphQLRequest a = GraphQLRequest.a(collectionsQueryExecutor.m13774a(this.aC, this.at.m13829h(), 4, null)).a(86400).a(CollectionsQueryExecutor.m13767a(z));
        if (1 != 0) {
            a.q = null;
        }
        return GraphQLQueryExecutor.a(collectionsQueryExecutor.f13013a.a(a));
    }

    protected final CollectionsFragmentType aA() {
        return CollectionsFragmentType.SECTION;
    }

    public static CollectionsSectionFragment m14762a(String str, String str2, String str3, String str4, DefaultImageFields defaultImageFields, CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, String str5, String str6) {
        CollectionsSectionFragment collectionsSectionFragment = new CollectionsSectionFragment();
        Bundle bundle = new Bundle();
        bundle.putString("profile_id", str);
        bundle.putString("section_id", str2);
        bundle.putString("section_tracking", str3);
        bundle.putString("view_name", str4);
        FlatBufferModelHelper.a(bundle, "collections_icon", defaultImageFields);
        FlatBufferModelHelper.a(bundle, "collection", collectionWithItemsAndSuggestions);
        bundle.putString("friendship_status", str5);
        bundle.putString("subscribe_status", str6);
        collectionsSectionFragment.g(bundle);
        return collectionsSectionFragment;
    }

    public final String am_() {
        return "collections_section";
    }

    public final Map<String, Object> m14771c() {
        Map<String, Object> c = Maps.c();
        c.put("profile_id", this.f13046h.a);
        return c;
    }

    private void m14763a(StandardCollectionSizes standardCollectionSizes, AnalyticsTagger analyticsTagger, CollectionsSectionAnalyticsLogger collectionsSectionAnalyticsLogger, CollectionsSectionControllerProvider collectionsSectionControllerProvider, CollectionsEventBus collectionsEventBus, CollectionsSectionAdapterProvider collectionsSectionAdapterProvider, QeAccessor qeAccessor, CollectionSectionCursorAdaptorProvider collectionSectionCursorAdaptorProvider, SectionsConnectionConfigurationProvider sectionsConnectionConfigurationProvider) {
        this.at = standardCollectionSizes;
        this.au = analyticsTagger;
        this.av = collectionsSectionAnalyticsLogger;
        this.aw = collectionsSectionControllerProvider;
        this.ax = collectionsEventBus;
        this.ay = collectionsSectionAdapterProvider;
        this.az = qeAccessor;
        this.aA = collectionSectionCursorAdaptorProvider;
        this.aB = sectionsConnectionConfigurationProvider;
    }
}
