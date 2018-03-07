package com.facebook.redspace.fragment.controllercallbacks.controller;

import android.support.v7.widget.RecyclerView;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.debug.log.BLog;
import com.facebook.feed.fragment.controllercallbacks.SwipeRefreshController.Callback;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNameFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNamePartFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNamePartFieldsModel.Builder;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.adapter.RedSpaceHomeComposerAdapter;
import com.facebook.redspace.adapter.RedSpaceHomeMultiAdapter;
import com.facebook.redspace.data.RedSpaceFriendsFetchResult;
import com.facebook.redspace.data.RedSpaceSelfProfileDataStore;
import com.facebook.redspace.fetcher.RedSpaceBatchFetcher;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests.5;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests.RedSpaceProfileWithVisitsResult;
import com.facebook.redspace.fetcher.RedSpaceRequests;
import com.facebook.redspace.fetcher.RedSpaceViewerProfileHelper;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel.CoverPhotoModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel.CoverPhotoModel.PhotoModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel.RedspaceModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel.RedspaceModel.StoriesModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceVisitFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceVisitsQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceVisitsQueryModel.RedspaceModel.VisitsModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.nio.ByteBuffer;

/* compiled from: PageServicesSectionMutation */
public class RedSpaceSelfProfileDataController extends BaseController implements FragmentCreateDestroyCallbacks, ResumePauseCallbacks, Callback {
    public static final String f12090a = RedSpaceSelfProfileDataController.class.getSimpleName();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceViewerProfileHelper> f12091b = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceRequests> f12092c = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceBatchRequests> f12093d = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceBatchFetcher> f12094e = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceSelfProfileDataStore> f12095f = UltralightRuntime.b;
    @Inject
    @Lazy
    @LoggedInUserId
    private com.facebook.inject.Lazy<String> f12096g = UltralightRuntime.b;
    @Inject
    public QeAccessor f12097h;
    public RedSpaceHomeComposerAdapter f12098i;
    public RecyclerView f12099j;
    public RedSpaceHomeMultiAdapter f12100k;
    private RedSpaceProfileWithVisitsResult f12101l;
    private final FutureCallback<RedSpaceProfileWithVisitsResult> f12102m = new C14441(this);

    /* compiled from: PageServicesSectionMutation */
    class C14441 extends AbstractDisposableFutureCallback<RedSpaceProfileWithVisitsResult> {
        final /* synthetic */ RedSpaceSelfProfileDataController f12089a;

        C14441(RedSpaceSelfProfileDataController redSpaceSelfProfileDataController) {
            this.f12089a = redSpaceSelfProfileDataController;
        }

        protected final void m12541a(Object obj) {
            this.f12089a.m12548a((RedSpaceProfileWithVisitsResult) obj);
        }

        protected final void m12542a(Throwable th) {
            BLog.b(RedSpaceSelfProfileDataController.f12090a, "Error fetching profile data", th);
        }
    }

    public static RedSpaceSelfProfileDataController m12545b(InjectorLike injectorLike) {
        RedSpaceSelfProfileDataController redSpaceSelfProfileDataController = new RedSpaceSelfProfileDataController();
        redSpaceSelfProfileDataController.m12543a(IdBasedSingletonScopeProvider.b(injectorLike, 10189), IdBasedLazy.a(injectorLike, 10187), IdBasedLazy.a(injectorLike, 10185), IdBasedLazy.a(injectorLike, 10184), IdBasedLazy.a(injectorLike, 10174), IdBasedLazy.a(injectorLike, 4442), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
        return redSpaceSelfProfileDataController;
    }

    private void m12543a(com.facebook.inject.Lazy<RedSpaceViewerProfileHelper> lazy, com.facebook.inject.Lazy<RedSpaceRequests> lazy2, com.facebook.inject.Lazy<RedSpaceBatchRequests> lazy3, com.facebook.inject.Lazy<RedSpaceBatchFetcher> lazy4, com.facebook.inject.Lazy<RedSpaceSelfProfileDataStore> lazy5, com.facebook.inject.Lazy<String> lazy6, QeAccessor qeAccessor) {
        this.f12091b = lazy;
        this.f12092c = lazy2;
        this.f12093d = lazy3;
        this.f12094e = lazy4;
        this.f12095f = lazy5;
        this.f12096g = lazy6;
        this.f12097h = qeAccessor;
    }

    public final void m12552e() {
        int i;
        User c = ((LoggedInUserSessionManager) ((RedSpaceViewerProfileHelper) this.f12091b.get()).a.get()).c();
        String h = c.h();
        Builder builder = new Builder();
        builder.c = GraphQLStructuredNamePart.FIRST;
        Builder builder2 = builder;
        if (StringUtil.a(h)) {
            i = 0;
        } else {
            i = h.length();
        }
        builder2.a = i;
        builder = builder2;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = flatBufferBuilder.a(builder.c);
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, builder.a, 0);
        flatBufferBuilder.a(1, builder.b, 0);
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        DefaultNamePartFieldsModel defaultNamePartFieldsModel = new DefaultNamePartFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        DefaultNameFieldsModel.Builder builder3 = new DefaultNameFieldsModel.Builder();
        builder3.b = ImmutableList.of(defaultNamePartFieldsModel);
        DefaultNameFieldsModel.Builder builder4 = builder3;
        builder4.c = h;
        DefaultNameFieldsModel a2 = builder4.a();
        RedSpaceFeedProfileFragmentModel.Builder builder5 = new RedSpaceFeedProfileFragmentModel.Builder();
        builder5.b = c.a;
        builder5 = builder5;
        builder5.e = a2;
        RedSpaceFeedProfileFragmentModel.Builder builder6 = builder5;
        RedspaceModel.Builder builder7 = new RedspaceModel.Builder();
        builder7.e = new StoriesModel.Builder().a();
        builder7 = builder7;
        builder7.c = "no_context_token";
        builder6.d = builder7.a();
        builder6 = builder6;
        DefaultImageFieldsModel.Builder builder8 = new DefaultImageFieldsModel.Builder();
        builder8.b = c.x();
        builder6.c = builder8.a();
        builder6 = builder6;
        CoverPhotoModel.Builder builder9 = new CoverPhotoModel.Builder();
        PhotoModel.Builder builder10 = new PhotoModel.Builder();
        DefaultImageFieldsModel.Builder builder11 = new DefaultImageFieldsModel.Builder();
        builder11.b = c.j;
        builder10.a = builder11.a();
        builder9.a = builder10.a();
        builder6.a = builder9.a();
        m12544a(builder6.a());
        m12546f();
    }

    public final void m12549b() {
    }

    public final void m12550c() {
        m12546f();
    }

    public final void m12551d() {
    }

    public final void av() {
        m12547g();
    }

    private void m12546f() {
        if (!((RedSpaceBatchFetcher) this.f12094e.get()).b() && this.f12101l == null) {
            m12547g();
        }
    }

    private void m12547g() {
        GraphQLRequest a = ((RedSpaceRequests) this.f12092c.get()).a((String) this.f12096g.get());
        GraphQLRequest a2 = ((RedSpaceRequests) this.f12092c.get()).a(5, null);
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("redspace_home_self_content");
        ((RedSpaceBatchFetcher) this.f12094e.get()).a(graphQLBatchRequest, RequestObservable.a(graphQLBatchRequest.a(a), graphQLBatchRequest.a(a2), new 5((RedSpaceBatchRequests) this.f12093d.get())), this.f12102m);
    }

    final void m12548a(RedSpaceProfileWithVisitsResult redSpaceProfileWithVisitsResult) {
        this.f12101l = redSpaceProfileWithVisitsResult;
        m12544a((RedSpaceFeedProfileFragmentModel) redSpaceProfileWithVisitsResult.a().e);
        RedSpaceVisitsQueryModel redSpaceVisitsQueryModel = (RedSpaceVisitsQueryModel) redSpaceProfileWithVisitsResult.b().e;
        if (this.f12097h.a(ExperimentsForRedSpaceExperimentsModule.l, false) && redSpaceVisitsQueryModel.a() != null && redSpaceVisitsQueryModel.a().a() != null) {
            VisitsModel a = redSpaceVisitsQueryModel.a().a();
            ((RedSpaceSelfProfileDataStore) this.f12095f.get()).f11872b = a.a();
            RedSpaceHomeComposerAdapter redSpaceHomeComposerAdapter = this.f12098i;
            ImmutableList k = a.k();
            redSpaceHomeComposerAdapter.f11729c = 0;
            int size = k.size();
            for (int i = 0; i < size; i++) {
                if (!((RedSpaceVisitFragmentModel) k.get(i)).a()) {
                    redSpaceHomeComposerAdapter.f11729c++;
                }
            }
            redSpaceHomeComposerAdapter.f11728b = k;
            if (this.f12099j != null) {
                this.f12099j.o.j_(this.f12100k.a(this.f12098i));
            }
        }
    }

    private void m12544a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        RedSpaceSelfProfileDataStore redSpaceSelfProfileDataStore = (RedSpaceSelfProfileDataStore) this.f12095f.get();
        redSpaceSelfProfileDataStore.f11871a.m12214a(new RedSpaceFriendsFetchResult(ImmutableList.of(redSpaceFeedProfileFragmentModel), null, null, null));
    }
}
