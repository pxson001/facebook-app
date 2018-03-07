package com.facebook.privacy;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PrivacyScopeEditInputData;
import com.facebook.graphql.calls.PrivacyScopeEditInputData.Privacy;
import com.facebook.graphql.calls.PrivacyScopeEditInputData.Privacy.BaseState;
import com.facebook.graphql.calls.PrivacyScopeEditInputData.Privacy.TagExpansionState;
import com.facebook.graphql.enums.GraphQLPrivacyBaseState;
import com.facebook.graphql.enums.GraphQLPrivacyTagExpansionState;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentConnection;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.offlinemode.executor.OfflineObliviousOperationsExecutor;
import com.facebook.privacy.model.ContentPrivacyOptionsResult;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.model.PrivacyOptionsResultFactory;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.model.SelectablePrivacyData.Builder;
import com.facebook.privacy.model.SelectablePrivacyDataForEditStory;
import com.facebook.privacy.protocol.BulkEditAlbumPhotoPrivacyParams;
import com.facebook.privacy.protocol.BulkEditAlbumPhotoPrivacyParams.BulkEditAlbumType;
import com.facebook.privacy.protocol.BulkEditAlbumPhotoPrivacyParams.BulkEditCaller;
import com.facebook.privacy.protocol.EditFeedStoryPrivacyParams;
import com.facebook.privacy.protocol.EditObjectsPrivacyParams;
import com.facebook.privacy.protocol.EditObjectsPrivacyParams.ObjectPrivacyEdit;
import com.facebook.privacy.protocol.EditReviewPrivacyParams;
import com.facebook.privacy.protocol.FetchComposerPrivacyOptions$StoryPrivacyOptionsQueryString;
import com.facebook.privacy.protocol.FetchComposerPrivacyOptionsModels.AlbumPrivacyOptionsModel;
import com.facebook.privacy.protocol.PrivacyMutations.SetStoryPrivacyCoreMutationString;
import com.facebook.privacy.protocol.ReportAAAOnlyMeActionParams;
import com.facebook.privacy.protocol.ReportAAAOnlyMeActionParams.AudienceAlignmentOnlyMeEvent;
import com.facebook.privacy.protocol.ReportAAATuxActionParams;
import com.facebook.privacy.protocol.ReportAAATuxActionParams.AudienceAlignmentTuxEvent;
import com.facebook.privacy.protocol.ReportInlinePrivacySurveyActionParams;
import com.facebook.privacy.protocol.ReportInlinePrivacySurveyActionParams.InlinePrivacySurveyEvent;
import com.facebook.privacy.protocol.ReportNASActionParams;
import com.facebook.privacy.protocol.ReportNASActionParams.NewcomerAudienceSelectorEvent;
import com.facebook.privacy.protocol.ReportPrivacyCheckupActionsParams;
import com.facebook.privacy.protocol.ReportPrivacyCheckupActionsParams.PrivacyCheckupItem;
import com.facebook.privacy.protocol.ReportStickyGuardrailActionParams;
import com.facebook.privacy.protocol.ReportStickyGuardrailActionParams.StickyGuardrailEvent;
import com.facebook.privacy.protocol.ReportStickyUpsellActionParams;
import com.facebook.privacy.protocol.ReportStickyUpsellActionParams.StickyUpsellEvent;
import com.facebook.privacy.protocol.ReportStickyUpsellActionParams.StickyUpsellSurface;
import com.facebook.privacy.protocol.SetComposerStickyPrivacyParams;
import com.facebook.privacy.protocol.SetPrivacyEducationStateParams;
import com.facebook.privacy.protocol.SetPrivacyEducationStateParams.EducationStateOperation;
import com.facebook.privacy.service.cache.PrivacyOptionsCache;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetch_group_members_params */
public class PrivacyOperationsClient {
    private static final CallerContext f14960a = CallerContext.a(PrivacyOperationsClient.class);
    private static final Set<String> f14961b = Sets.a(new String[]{"set_privacy_education_state", "set_composer_sticky_privacy", "report_aaa_tux_action", "report_aaa_only_me_action", "report_nas_action", "report_sticky_guardrail_action", "report_inline_privacy_survey_action", "report_privacy_checkup_action", "edit_objects_privacy_operation_type", "bulk_edit_album_privacy_operation_type"});
    private static volatile PrivacyOperationsClient f14962k;
    private final DefaultBlueServiceOperationFactory f14963c;
    public final PrivacyOptionsCache f14964d;
    private final ExecutorService f14965e;
    private final Lazy<OfflineObliviousOperationsExecutor> f14966f;
    private final Lazy<FbErrorReporter> f14967g;
    public final Lazy<GraphQLQueryExecutor> f14968h;
    public final Lazy<PrivacyOptionsResultFactory> f14969i;
    private final Provider<TriState> f14970j;

    /* compiled from: fetch_group_members_params */
    class C09921 implements Function<OperationResult, PrivacyOptionsResult> {
        final /* synthetic */ PrivacyOperationsClient f14945a;

        C09921(PrivacyOperationsClient privacyOperationsClient) {
            this.f14945a = privacyOperationsClient;
        }

        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult == null) {
                return null;
            }
            return (PrivacyOptionsResult) operationResult.k();
        }
    }

    /* compiled from: fetch_group_members_params */
    public class C09932 implements Function<List<Object>, SelectablePrivacyDataForEditStory> {
        final /* synthetic */ PrivacyOperationsClient f14946a;

        public C09932(PrivacyOperationsClient privacyOperationsClient) {
            this.f14946a = privacyOperationsClient;
        }

        public Object apply(Object obj) {
            List list = (List) obj;
            if (list == null || list.size() < 2) {
                return null;
            }
            PrivacyOptionsResult privacyOptionsResult = (PrivacyOptionsResult) list.get(0);
            ContentPrivacyOptionsResult contentPrivacyOptionsResult = (ContentPrivacyOptionsResult) list.get(1);
            if (privacyOptionsResult == null || contentPrivacyOptionsResult == null) {
                return null;
            }
            Builder builder = new Builder();
            builder.f15102a = privacyOptionsResult;
            return new SelectablePrivacyDataForEditStory(PrivacyOperationsClient.m22545a(builder.m22697b(), contentPrivacyOptionsResult.f15073c), contentPrivacyOptionsResult.f15074d);
        }
    }

    /* compiled from: fetch_group_members_params */
    public class C09954 implements Function<GraphQLResult<AlbumPrivacyOptionsModel>, ContentPrivacyOptionsResult> {
        final /* synthetic */ PrivacyOperationsClient f14949a;

        public C09954(PrivacyOperationsClient privacyOperationsClient) {
            this.f14949a = privacyOperationsClient;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((AlbumPrivacyOptionsModel) graphQLResult.e).m6068a() == null || ((AlbumPrivacyOptionsModel) graphQLResult.e).m6068a().m6064a() == null) {
                return null;
            }
            return ((PrivacyOptionsResultFactory) this.f14949a.f14969i.get()).a(((AlbumPrivacyOptionsModel) graphQLResult.e).m6068a().m6064a().m6060a(), false);
        }
    }

    /* compiled from: fetch_group_members_params */
    class C09965 implements Function<GraphQLResult<GraphQLStory>, ContentPrivacyOptionsResult> {
        final /* synthetic */ PrivacyOperationsClient f14950a;

        C09965(PrivacyOperationsClient privacyOperationsClient) {
            this.f14950a = privacyOperationsClient;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((GraphQLStory) graphQLResult.e).ao() == null || ((GraphQLStory) graphQLResult.e).ao().p() == null) {
                return null;
            }
            PrivacyOptionsResultFactory privacyOptionsResultFactory = (PrivacyOptionsResultFactory) this.f14950a.f14969i.get();
            GraphQLPrivacyScope ao = ((GraphQLStory) graphQLResult.e).ao();
            GraphQLPrivacyOptionsContentConnection p = ao.p();
            return privacyOptionsResultFactory.a(p.a(), ao.r());
        }
    }

    /* compiled from: fetch_group_members_params */
    public /* synthetic */ class C09998 {
        public static final /* synthetic */ int[] f14958a = new int[GraphQLPrivacyBaseState.values().length];
        public static final /* synthetic */ int[] f14959b = new int[GraphQLPrivacyTagExpansionState.values().length];

        static {
            try {
                f14959b[GraphQLPrivacyTagExpansionState.TAGGEES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14959b[GraphQLPrivacyTagExpansionState.UNSPECIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14958a[GraphQLPrivacyBaseState.EVERYONE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14958a[GraphQLPrivacyBaseState.FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f14958a[GraphQLPrivacyBaseState.FRIENDS_OF_FRIENDS.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f14958a[GraphQLPrivacyBaseState.SELF.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static com.facebook.privacy.PrivacyOperationsClient m22544a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f14962k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.privacy.PrivacyOperationsClient.class;
        monitor-enter(r1);
        r0 = f14962k;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m22548b(r0);	 Catch:{ all -> 0x0035 }
        f14962k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14962k;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.PrivacyOperationsClient.a(com.facebook.inject.InjectorLike):com.facebook.privacy.PrivacyOperationsClient");
    }

    private static PrivacyOperationsClient m22548b(InjectorLike injectorLike) {
        return new PrivacyOperationsClient(DefaultBlueServiceOperationFactory.b(injectorLike), PrivacyOptionsCache.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2855), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 2164), IdBasedLazy.a(injectorLike, 3108), IdBasedProvider.a(injectorLike, 741));
    }

    public final ListenableFuture<ContentPrivacyOptionsResult> m22567c(String str) {
        GraphQlQueryString fetchComposerPrivacyOptions$StoryPrivacyOptionsQueryString = new FetchComposerPrivacyOptions$StoryPrivacyOptionsQueryString();
        fetchComposerPrivacyOptions$StoryPrivacyOptionsQueryString.a("story_id", str);
        return Futures.a(((GraphQLQueryExecutor) this.f14968h.get()).a(GraphQLRequest.a(fetchComposerPrivacyOptions$StoryPrivacyOptionsQueryString)), new C09965(this), MoreExecutors.a());
    }

    @Inject
    public PrivacyOperationsClient(BlueServiceOperationFactory blueServiceOperationFactory, PrivacyOptionsCache privacyOptionsCache, ExecutorService executorService, Lazy<OfflineObliviousOperationsExecutor> lazy, Lazy<FbErrorReporter> lazy2, Lazy<GraphQLQueryExecutor> lazy3, Lazy<PrivacyOptionsResultFactory> lazy4, Provider<TriState> provider) {
        this.f14963c = blueServiceOperationFactory;
        this.f14964d = privacyOptionsCache;
        this.f14965e = executorService;
        this.f14966f = lazy;
        this.f14967g = lazy2;
        this.f14968h = lazy3;
        this.f14969i = lazy4;
        this.f14970j = provider;
    }

    private ListenableFuture<OperationResult> m22547a(Operation operation, boolean z) {
        if (z && f14961b.contains(operation.e())) {
            return ((OfflineObliviousOperationsExecutor) this.f14966f.get()).a(operation);
        }
        return operation.a();
    }

    private ListenableFuture<OperationResult> m22546a(Operation operation) {
        return m22547a(operation, true);
    }

    public final ListenableFuture<PrivacyOptionsResult> m22551a(DataFreshnessParam dataFreshnessParam) {
        if (dataFreshnessParam == DataFreshnessParam.STALE_DATA_OKAY || dataFreshnessParam == DataFreshnessParam.DO_NOT_CHECK_SERVER) {
            PrivacyOptionsResult a = this.f14964d.a(true);
            if (!(a == null || a.selectedPrivacyOption == null || a.selectedPrivacyOption.c() == null)) {
                return Futures.a(a);
            }
        }
        if (dataFreshnessParam == DataFreshnessParam.DO_NOT_CHECK_SERVER) {
            return Futures.a(null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("privacy.data_freshness", dataFreshnessParam.name());
        return Futures.a(m22546a(BlueServiceOperationFactoryDetour.a(this.f14963c, "fetch_privacy_options", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, 1819695955)), new C09921(this), MoreExecutors.a());
    }

    public static SelectablePrivacyData m22545a(SelectablePrivacyData selectablePrivacyData, GraphQLPrivacyOption graphQLPrivacyOption) {
        GraphQLPrivacyOption graphQLPrivacyOption2;
        PrivacyOptionsResult privacyOptionsResult;
        PrivacyOptionsResult privacyOptionsResult2 = selectablePrivacyData.f15106a;
        int i = 0;
        ImmutableList immutableList = privacyOptionsResult2.basicPrivacyOptions;
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            graphQLPrivacyOption2 = (GraphQLPrivacyOption) immutableList.get(i2);
            if (PrivacyOptionHelper.a(graphQLPrivacyOption2, graphQLPrivacyOption)) {
                break;
            }
        }
        ImmutableList immutableList2 = privacyOptionsResult2.friendListPrivacyOptions;
        int size2 = immutableList2.size();
        while (i < size2) {
            graphQLPrivacyOption2 = (GraphQLPrivacyOption) immutableList2.get(i);
            if (PrivacyOptionHelper.a(graphQLPrivacyOption2, graphQLPrivacyOption)) {
                break;
            }
            i++;
        }
        graphQLPrivacyOption2 = null;
        GraphQLPrivacyOption graphQLPrivacyOption3 = graphQLPrivacyOption2;
        if (graphQLPrivacyOption3 == null) {
            privacyOptionsResult = new PrivacyOptionsResult(ImmutableList.builder().b(privacyOptionsResult2.basicPrivacyOptions).c(graphQLPrivacyOption).b(), privacyOptionsResult2.friendListPrivacyOptions, privacyOptionsResult2.selectedPrivacyOption, privacyOptionsResult2.recentPrivacyOption, true, false);
            graphQLPrivacyOption3 = graphQLPrivacyOption;
        } else {
            privacyOptionsResult = privacyOptionsResult2;
        }
        Builder builder = new Builder();
        builder.f15102a = privacyOptionsResult;
        Builder a = builder.m22696a(graphQLPrivacyOption3);
        a.f15104c = PrivacyOptionHelper.d(graphQLPrivacyOption);
        a = a;
        a.f15105d = selectablePrivacyData.f15108c;
        return a.m22697b();
    }

    public final void m22564a(final GraphQLPrivacyOption graphQLPrivacyOption) {
        if (graphQLPrivacyOption != null && !((TriState) this.f14970j.get()).asBoolean(false)) {
            String b = PrivacyOptionsResultFactory.b(graphQLPrivacyOption);
            Preconditions.checkArgument(b == null, "Cannot set local sticky privacy because: " + b);
            ExecutorDetour.a(this.f14965e, new NamedRunnable(this, "PrivacyOperationsClient", "UpdateStickPrivacySettings") {
                final /* synthetic */ PrivacyOperationsClient f14948d;

                public void run() {
                    this.f14948d.f14964d.a(graphQLPrivacyOption);
                }
            }, 1882937191);
        }
    }

    public final ListenableFuture<? extends GraphQLVisitableModel> m22563a(String str, String str2, String str3, GraphQLPrivacyOption graphQLPrivacyOption) {
        BaseState baseState;
        TagExpansionState tagExpansionState;
        Privacy privacy = new Privacy();
        privacy.a("allow", graphQLPrivacyOption.n().a());
        GraphQlCallInput graphQlCallInput = privacy;
        graphQlCallInput.a("deny", graphQLPrivacyOption.n().k());
        graphQlCallInput = graphQlCallInput;
        switch (C09998.f14958a[graphQLPrivacyOption.n().j().ordinal()]) {
            case 1:
                baseState = BaseState.EVERYONE;
                break;
            case 2:
                baseState = BaseState.FRIENDS;
                break;
            case 3:
                baseState = BaseState.FRIENDS_OF_FRIENDS;
                break;
            case 4:
                baseState = BaseState.SELF;
                break;
            default:
                baseState = null;
                break;
        }
        graphQlCallInput.a("base_state", baseState);
        graphQlCallInput = graphQlCallInput;
        switch (C09998.f14959b[graphQLPrivacyOption.n().l().ordinal()]) {
            case 1:
                tagExpansionState = TagExpansionState.TAGGEES;
                break;
            case 2:
                tagExpansionState = TagExpansionState.UNSPECIFIED;
                break;
            default:
                tagExpansionState = null;
                break;
        }
        Enum enumR = tagExpansionState;
        if (enumR != null) {
            graphQlCallInput.a("tag_expansion_state", enumR);
            graphQlCallInput = graphQlCallInput;
        }
        PrivacyScopeEditInputData privacyScopeEditInputData = new PrivacyScopeEditInputData();
        privacyScopeEditInputData.a("node_id", str);
        GraphQlCallInput graphQlCallInput2 = privacyScopeEditInputData;
        graphQlCallInput2.a("privacy", graphQlCallInput);
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final GraphQLPrivacyOption graphQLPrivacyOption2 = graphQLPrivacyOption;
        return Futures.a(GraphQLQueryExecutor.a(((GraphQLQueryExecutor) this.f14968h.get()).a(GraphQLRequest.a((SetStoryPrivacyCoreMutationString) new SetStoryPrivacyCoreMutationString().a("input", graphQlCallInput2)))), new Function<GraphQLVisitableModel, GraphQLVisitableModel>(this) {
            final /* synthetic */ PrivacyOperationsClient f14955e;

            @Nullable
            public Object apply(@Nullable Object obj) {
                GraphQLVisitableModel graphQLVisitableModel = (GraphQLVisitableModel) obj;
                PrivacyOperationsClient.m22549b(this.f14955e, str4, str5, str6, graphQLPrivacyOption2);
                return graphQLVisitableModel;
            }
        });
    }

    public static ListenableFuture m22549b(PrivacyOperationsClient privacyOperationsClient, String str, String str2, String str3, GraphQLPrivacyOption graphQLPrivacyOption) {
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(graphQLPrivacyOption);
        Preconditions.checkNotNull(graphQLPrivacyOption.c());
        Preconditions.checkNotNull(graphQLPrivacyOption.l());
        Preconditions.checkNotNull(graphQLPrivacyOption.l().d());
        Bundle bundle = new Bundle();
        bundle.putParcelable("editPrivacyFeedStoryParams", new EditFeedStoryPrivacyParams(str, str2, str3, graphQLPrivacyOption));
        return privacyOperationsClient.m22546a(BlueServiceOperationFactoryDetour.a(privacyOperationsClient.f14963c, "feed_edit_privacy", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, -374176036));
    }

    public final ListenableFuture<OperationResult> m22552a(EditReviewPrivacyParams editReviewPrivacyParams) {
        Preconditions.checkNotNull(editReviewPrivacyParams);
        Bundle bundle = new Bundle();
        bundle.putParcelable("editReviewPrivacyParams", editReviewPrivacyParams);
        return BlueServiceOperationFactoryDetour.a(this.f14963c, "feed_edit_review_privacy", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, -9323430).a();
    }

    public final ListenableFuture<OperationResult> m22561a(String str, EducationStateOperation educationStateOperation, Long l) {
        Preconditions.checkNotNull(educationStateOperation);
        Preconditions.checkNotNull(str);
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", new SetPrivacyEducationStateParams(str, educationStateOperation, l));
        return m22546a(BlueServiceOperationFactoryDetour.a(this.f14963c, "set_privacy_education_state", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, -1070361667));
    }

    public final ListenableFuture<OperationResult> m22554a(AudienceAlignmentTuxEvent audienceAlignmentTuxEvent, long j, String str) {
        Preconditions.checkNotNull(audienceAlignmentTuxEvent);
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", new ReportAAATuxActionParams(audienceAlignmentTuxEvent, j, str));
        return m22546a(BlueServiceOperationFactoryDetour.a(this.f14963c, "report_aaa_tux_action", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, 2052607866));
    }

    public final ListenableFuture<OperationResult> m22553a(AudienceAlignmentOnlyMeEvent audienceAlignmentOnlyMeEvent, long j, String str) {
        Preconditions.checkNotNull(audienceAlignmentOnlyMeEvent);
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", new ReportAAAOnlyMeActionParams(audienceAlignmentOnlyMeEvent, j, str));
        return m22546a(BlueServiceOperationFactoryDetour.a(this.f14963c, "report_aaa_only_me_action", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, 409053085));
    }

    public final ListenableFuture<OperationResult> m22556a(NewcomerAudienceSelectorEvent newcomerAudienceSelectorEvent, long j, boolean z, String str, String str2) {
        Preconditions.checkNotNull(newcomerAudienceSelectorEvent);
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", new ReportNASActionParams(newcomerAudienceSelectorEvent, j, z, str, str2));
        return m22546a(BlueServiceOperationFactoryDetour.a(this.f14963c, "report_nas_action", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, -340602460));
    }

    public final ListenableFuture<OperationResult> m22566b(GraphQLPrivacyOption graphQLPrivacyOption) {
        Preconditions.checkNotNull(graphQLPrivacyOption);
        if (StringUtil.a(graphQLPrivacyOption.c())) {
            ((AbstractFbErrorReporter) this.f14967g.get()).a("privacy_options_client_sticky_no_privacy_json", "No GraphAPI representation for option: " + graphQLPrivacyOption.toString());
            Throwable illegalArgumentException = new IllegalArgumentException("Cannot find privacy option for option: " + graphQLPrivacyOption.toString());
            OperationFuture operationFuture = new OperationFuture();
            operationFuture.a(illegalArgumentException);
            return operationFuture;
        }
        m22564a(graphQLPrivacyOption);
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", new SetComposerStickyPrivacyParams(graphQLPrivacyOption.c()));
        return m22546a(BlueServiceOperationFactoryDetour.a(this.f14963c, "set_composer_sticky_privacy", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, -1921612353));
    }

    public final void m22568c(final GraphQLPrivacyOption graphQLPrivacyOption) {
        Preconditions.checkNotNull(graphQLPrivacyOption);
        if (StringUtil.a(graphQLPrivacyOption.c())) {
            ((AbstractFbErrorReporter) this.f14967g.get()).a("privacy_options_client_cached_no_privacy_json", "No GraphAPI representation for option: " + graphQLPrivacyOption.toString());
            throw new IllegalArgumentException("Cannot find privacy option for option: " + graphQLPrivacyOption.toString());
        }
        String b = PrivacyOptionsResultFactory.b(graphQLPrivacyOption);
        Preconditions.checkArgument(b == null, "Cannot set cached privacy option because: " + b);
        ExecutorDetour.a(this.f14965e, new NamedRunnable(this, "PrivacyOperationsClient", "UpdateSelectedPrivacySettings") {
            final /* synthetic */ PrivacyOperationsClient f14957d;

            public void run() {
                this.f14957d.f14964d.a(graphQLPrivacyOption);
            }
        }, -1836854141);
    }

    public final ListenableFuture<OperationResult> m22550a() {
        return m22546a(BlueServiceOperationFactoryDetour.a(this.f14963c, "fetch_sticky_guardrail", new Bundle(), ErrorPropagation.BY_ERROR_CODE, f14960a, -2012610396));
    }

    public final ListenableFuture<OperationResult> m22557a(StickyGuardrailEvent stickyGuardrailEvent, Long l, Long l2, String str, String str2) {
        Preconditions.checkNotNull(stickyGuardrailEvent);
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", new ReportStickyGuardrailActionParams(stickyGuardrailEvent, l, l2, str, str2));
        return m22546a(BlueServiceOperationFactoryDetour.a(this.f14963c, "report_sticky_guardrail_action", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, 527504881));
    }

    public final ListenableFuture<OperationResult> m22558a(StickyUpsellEvent stickyUpsellEvent, Long l, String str, StickyUpsellSurface stickyUpsellSurface) {
        Preconditions.checkNotNull(stickyUpsellEvent);
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", new ReportStickyUpsellActionParams(stickyUpsellEvent, l, null, str, stickyUpsellSurface));
        return m22546a(BlueServiceOperationFactoryDetour.a(this.f14963c, "report_sticky_upsell_action", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, 312665687));
    }

    public final ListenableFuture<OperationResult> m22565b() {
        return m22546a(BlueServiceOperationFactoryDetour.a(this.f14963c, "fetch_audience_info", new Bundle(), ErrorPropagation.BY_ERROR_CODE, f14960a, -1952772090));
    }

    public final ListenableFuture<OperationResult> m22555a(InlinePrivacySurveyEvent inlinePrivacySurveyEvent, Long l, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", new ReportInlinePrivacySurveyActionParams(inlinePrivacySurveyEvent, l.longValue(), str, str2, str3));
        return m22546a(BlueServiceOperationFactoryDetour.a(this.f14963c, "report_inline_privacy_survey_action", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, -1806482862));
    }

    public final ListenableFuture<OperationResult> m22559a(ImmutableList<PrivacyCheckupItem> immutableList, String str, long j) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", new ReportPrivacyCheckupActionsParams(immutableList, str, j));
        return m22546a(BlueServiceOperationFactoryDetour.a(this.f14963c, "report_privacy_checkup_action", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, -191800472));
    }

    public final ListenableFuture<OperationResult> m22562a(String str, ImmutableList<ObjectPrivacyEdit> immutableList, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", new EditObjectsPrivacyParams(str, immutableList));
        return m22547a(BlueServiceOperationFactoryDetour.a(this.f14963c, "edit_objects_privacy_operation_type", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, -1750123422), z);
    }

    public final ListenableFuture<OperationResult> m22560a(@Nullable String str, BulkEditCaller bulkEditCaller, BulkEditAlbumType bulkEditAlbumType, long j, String str2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", new BulkEditAlbumPhotoPrivacyParams(str, bulkEditCaller, bulkEditAlbumType, j, str2));
        return m22546a(BlueServiceOperationFactoryDetour.a(this.f14963c, "bulk_edit_album_privacy_operation_type", bundle, ErrorPropagation.BY_ERROR_CODE, f14960a, -1822763535));
    }
}
