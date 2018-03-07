package com.facebook.controller.mutation.util;

import android.content.Context;
import android.os.Bundle;
import com.facebook.api.ufiservices.common.AddCommentParams;
import com.facebook.api.ufiservices.common.DeleteCommentParams;
import com.facebook.api.ufiservices.common.EditCommentParams;
import com.facebook.api.ufiservices.common.SetNotifyMeParams;
import com.facebook.api.ufiservices.common.ToggleLikeParams;
import com.facebook.api.ufiservices.common.TogglePageLikeParams;
import com.facebook.api.ufiservices.common.TogglePostLikeParams;
import com.facebook.api.ufiservices.qe.ExperimentsForUfiServiceQeModule;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.controller.mutation.util.FeedStoryCacheAdapter.1;
import com.facebook.controller.mutation.util.FeedStoryCacheAdapter.10;
import com.facebook.controller.mutation.util.FeedStoryCacheAdapter.11;
import com.facebook.controller.mutation.util.FeedStoryCacheAdapter.12;
import com.facebook.controller.mutation.util.FeedStoryCacheAdapter.2;
import com.facebook.controller.mutation.util.FeedStoryCacheAdapter.3;
import com.facebook.controller.mutation.util.FeedStoryCacheAdapter.7;
import com.facebook.controller.mutation.util.FeedStoryCacheAdapter.8;
import com.facebook.controller.mutation.util.FeedStoryCacheAdapter.9;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory$Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.data.followup.cache.FollowUpStateCache;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryExecutor.DataSource;
import com.facebook.graphql.executor.GraphQLQueryScheduler;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLWriteLock;
import com.facebook.graphql.executor.cache.ConsistencyCacheFactoryImpl;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.ConsistencyCacheFactory;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnit;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.offlinemode.common.PendingRequest;
import com.facebook.offlinemode.db.PendingGraphQlMutationRequest;
import com.facebook.offlinemode.db.PendingGraphQlMutationRequest.Builder;
import com.facebook.offlinemode.executor.OfflineObliviousOperationsExecutor;
import com.facebook.offlinemode.executor.OfflineObliviousOperationsExecutor.OfflineExceptionTreatment;
import com.facebook.offlinemode.executor.OperationAttemptWhileOfflineException;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.UpdateTimelineAppCollectionParams.Action;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: platform_webdialogs_load_manifest */
public class FeedbackGraphQLGenerator implements FeedbackGraphQLGeneratorInterface {
    private static FeedbackGraphQLGenerator f9560m;
    private static final Object f9561n = new Object();
    public final GraphQLQueryScheduler f9562a;
    public final GraphQLQueryExecutor f9563b;
    public final FeedbackMutator f9564c;
    private final ExecutorService f9565d;
    public final DefaultBlueServiceOperationFactory f9566e;
    private final Lazy<OfflineObliviousOperationsExecutor> f9567f;
    private final AbstractFbErrorReporter f9568g;
    public final Lazy<ConsistencyCacheFactory> f9569h;
    public final QeAccessor f9570i;
    private final FollowUpStateCache f9571j;
    private final FeedStoryCacheAdapter f9572k;
    public Boolean f9573l = null;

    private static FeedbackGraphQLGenerator m14570b(InjectorLike injectorLike) {
        return new FeedbackGraphQLGenerator(GraphQLQueryScheduler.m10388a(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), FeedbackMutator.m10618a(injectorLike), C0055x2995691a.m1881a(injectorLike), DefaultBlueServiceOperationFactory.m3782b(injectorLike), FeedStoryCacheAdapter.m14594b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2855), FbErrorReporterImpl.m2317a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedLazy.m1808a(injectorLike, 2175), FollowUpStateCache.m14602a(injectorLike));
    }

    public final ListenableFuture<OperationResult> m14576a(SetNotifyMeParams setNotifyMeParams) {
        String[] strArr = new String[]{r0};
        return m14568a(this.f9562a.m10395a(new 1(this, strArr, setNotifyMeParams.b, setNotifyMeParams.e)), new 11(this, setNotifyMeParams));
    }

    public final ListenableFuture<OperationResult> m14575a(EditCommentParams editCommentParams) {
        String str = editCommentParams.a;
        String str2 = editCommentParams.b;
        String[] strArr = new String[]{str2, str};
        return m14568a(this.f9562a.m10395a(new 4(this, strArr, str, editCommentParams.e)), new 8(this, editCommentParams));
    }

    public static FeedbackGraphQLGenerator m14563a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedbackGraphQLGenerator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f9561n) {
                FeedbackGraphQLGenerator feedbackGraphQLGenerator;
                if (a2 != null) {
                    feedbackGraphQLGenerator = (FeedbackGraphQLGenerator) a2.mo818a(f9561n);
                } else {
                    feedbackGraphQLGenerator = f9560m;
                }
                if (feedbackGraphQLGenerator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m14570b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f9561n, b3);
                        } else {
                            f9560m = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedbackGraphQLGenerator;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FeedbackGraphQLGenerator(GraphQLQueryScheduler graphQLQueryScheduler, GraphQLQueryExecutor graphQLQueryExecutor, FeedbackMutator feedbackMutator, ExecutorService executorService, BlueServiceOperationFactory blueServiceOperationFactory, FeedStoryCacheAdapter feedStoryCacheAdapter, Lazy<OfflineObliviousOperationsExecutor> lazy, FbErrorReporter fbErrorReporter, QeAccessor qeAccessor, Lazy<ConsistencyCacheFactory> lazy2, FollowUpStateCache followUpStateCache) {
        this.f9562a = graphQLQueryScheduler;
        this.f9563b = graphQLQueryExecutor;
        this.f9564c = feedbackMutator;
        this.f9565d = executorService;
        this.f9566e = blueServiceOperationFactory;
        this.f9567f = lazy;
        this.f9572k = feedStoryCacheAdapter;
        this.f9568g = fbErrorReporter;
        this.f9569h = lazy2;
        this.f9570i = qeAccessor;
        this.f9571j = followUpStateCache;
    }

    private CacheVisitor m14565a(@Nullable ConsistencyMemoryCache consistencyMemoryCache, String str, GraphQLActor graphQLActor, boolean z) {
        return new 2(this, consistencyMemoryCache, new String[]{str}, str, z, graphQLActor);
    }

    @Deprecated
    @VisibleForTesting
    private GraphQLWriteLock m14571b(@Nullable ConsistencyMemoryCache consistencyMemoryCache, String str, GraphQLActor graphQLActor, boolean z) {
        return this.f9562a.m10395a(m14565a(consistencyMemoryCache, str, graphQLActor, z));
    }

    @Deprecated
    public final ListenableFuture<OperationResult> mo1940a(TogglePostLikeParams togglePostLikeParams) {
        ModernFeedbackGraphQLGenerator.m30106b(togglePostLikeParams);
        return m14566a(togglePostLikeParams.b());
    }

    @Deprecated
    public final ListenableFuture<OperationResult> m14591b(TogglePostLikeParams togglePostLikeParams) {
        Preconditions.checkNotNull(togglePostLikeParams.a);
        Preconditions.checkState(togglePostLikeParams.e == null);
        return m14566a(togglePostLikeParams.b());
    }

    @Deprecated
    public final ListenableFuture<OperationResult> m14577a(TogglePageLikeParams togglePageLikeParams, @Nullable FeedProps<GraphQLStory> feedProps) {
        CacheVisitor 10;
        CacheVisitor 5;
        CacheVisitor a = m14565a(null, togglePageLikeParams.a, togglePageLikeParams.c, togglePageLikeParams.b);
        if (feedProps != null) {
            String g;
            if (((GraphQLStory) feedProps.f13444a).mo2507g() != null) {
                g = ((GraphQLStory) feedProps.f13444a).mo2507g();
            } else {
                g = ((GraphQLStory) feedProps.f13444a).ai();
            }
            10 = new 10(this.f9572k, g, togglePageLikeParams.b);
        } else {
            10 = togglePageLikeParams.a != null ? new 11(this.f9572k, togglePageLikeParams.a, togglePageLikeParams.b) : null;
        }
        if (10 != null) {
            5 = new 5(this, a, 10, ImmutableSet.builder().m4809b(10.a()).m4809b(a.a()).m4812b());
        } else {
            5 = a;
        }
        return m14568a(this.f9562a.m10395a(5), new 6(this, togglePageLikeParams));
    }

    private ListenableFuture<OperationResult> m14566a(ToggleLikeParams toggleLikeParams) {
        if (toggleLikeParams.c == null) {
            this.f9568g.m2350b("FeedbackGraphQLGenerator.togglePageLike", "null likerProfile");
        }
        ConsistencyMemoryCache a = ((ConsistencyCacheFactoryImpl) this.f9569h.get()).m10245a();
        a.a(ModernFeedbackGraphQLGenerator.m30103a(toggleLikeParams));
        ConsistencyMemoryCache consistencyMemoryCache = a;
        return m14567a(m14571b(consistencyMemoryCache, toggleLikeParams.a, toggleLikeParams.c, toggleLikeParams.b), consistencyMemoryCache, new 7(this, toggleLikeParams));
    }

    public static OperationResult m14564a(FeedbackGraphQLGenerator feedbackGraphQLGenerator, ToggleLikeParams toggleLikeParams, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("toggleLikeParams", toggleLikeParams);
        try {
            OfflineObliviousOperationsExecutor offlineObliviousOperationsExecutor = (OfflineObliviousOperationsExecutor) feedbackGraphQLGenerator.f9567f.get();
            BlueServiceOperationFactory$Operation a = BlueServiceOperationFactoryDetour.a(feedbackGraphQLGenerator.f9566e, str, bundle, -713703895);
            long toMillis = TimeUnit.DAYS.toMillis(1);
            feedbackGraphQLGenerator.f9567f.get();
            return (OperationResult) FutureDetour.a(offlineObliviousOperationsExecutor.m18495a(a, toMillis, OfflineObliviousOperationsExecutor.m18484a(), OfflineExceptionTreatment.THROW_CUSTOM_EXCEPTION), 60, TimeUnit.SECONDS, 1319634478);
        } catch (ExecutionException e) {
            if (e.getCause() instanceof OperationAttemptWhileOfflineException) {
                return OperationResult.m30116a(Boolean.toString(toggleLikeParams.b));
            }
            throw e;
        }
    }

    public final ListenableFuture<OperationResult> m14574a(DeleteCommentParams deleteCommentParams) {
        String[] strArr = new String[]{deleteCommentParams.b, deleteCommentParams.a};
        return m14568a(this.f9562a.m10395a(new 3(this, strArr, deleteCommentParams.b, deleteCommentParams.a)), new 9(this, deleteCommentParams));
    }

    public final ListenableFuture<GraphQLComment> m14573a(AddCommentParams addCommentParams, boolean z) {
        ListenableFuture a;
        if (this.f9573l == null) {
            this.f9573l = Boolean.valueOf(this.f9570i.mo596a(ExperimentsForUfiServiceQeModule.f6627l, false));
        }
        MutationRequest a2 = CommentsServiceHelper.a(addCommentParams, this.f9573l.booleanValue());
        if (addCommentParams.l != null) {
            a2.e = addCommentParams.l;
        }
        if (z) {
            GraphQLQueryExecutor graphQLQueryExecutor = this.f9563b;
            Builder a3 = new Builder().a(a2);
            a3.d = TimeUnit.DAYS.toMillis(1);
            PendingRequest.Builder builder = a3;
            builder.f = 100;
            a = graphQLQueryExecutor.m10450a((PendingGraphQlMutationRequest) builder.a(), OfflineQueryBehavior.c);
        } else {
            a = this.f9563b.m10457b(a2);
        }
        ListenableFuture f = SettableFuture.m1547f();
        Futures.m2457a(a, new 10(this, f));
        return f;
    }

    private ListenableFuture<OperationResult> m14568a(GraphQLWriteLock graphQLWriteLock, Callable<OperationResult> callable) {
        return m14567a(graphQLWriteLock, null, (Callable) callable);
    }

    private ListenableFuture<OperationResult> m14567a(GraphQLWriteLock graphQLWriteLock, @Nullable ConsistencyMemoryCache consistencyMemoryCache, Callable<OperationResult> callable) {
        ListenableFuture f = SettableFuture.m1547f();
        ExecutorDetour.a(this.f9565d, new 12(this, graphQLWriteLock, callable, f, consistencyMemoryCache), -1608972638);
        return f;
    }

    private void m14569a(CacheVisitor cacheVisitor) {
        GraphQLWriteLock a = this.f9562a.m10395a(cacheVisitor);
        try {
            a.mo3496a(DataSource.NETWORK);
            a.m32020a(true);
            this.f9563b.m10454a(a);
        } catch (Throwable e) {
            BLog.a(FeedbackGraphQLGenerator.class, "Failed to update caches", e);
        } finally {
            a.m20458e();
        }
    }

    public final void m14580a(String str, StoryVisibility storyVisibility, int i) {
        m14569a((CacheVisitor) new 1(this.f9572k, str, storyVisibility, i));
    }

    public final void m14582a(String str, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        FeedStoryCacheAdapter feedStoryCacheAdapter = this.f9572k;
        GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType = null;
        if (str != null) {
            if (graphQLNegativeFeedbackAction != null) {
                graphQLNegativeFeedbackActionType = graphQLNegativeFeedbackAction.m27654b();
            }
            graphQLNegativeFeedbackActionType = new 2(feedStoryCacheAdapter, str, graphQLNegativeFeedbackActionType);
        }
        m14569a((CacheVisitor) graphQLNegativeFeedbackActionType);
    }

    public final void m14586a(String str, GraphQLPrivacyScope graphQLPrivacyScope) {
        m14569a((CacheVisitor) new 3(this.f9572k, str, graphQLPrivacyScope));
    }

    public final void m14579a(String str, GraphQLSavedState graphQLSavedState) {
        if (!StringUtil.m3589a((CharSequence) str)) {
            m14572c(str, graphQLSavedState);
        }
    }

    public final void m14592b(@Nullable String str, GraphQLSavedState graphQLSavedState) {
        if (!StringUtil.m3589a((CharSequence) str)) {
            m14569a((CacheVisitor) new 7(this.f9572k, str, graphQLSavedState));
        }
    }

    public final void m14589a(String str, String str2, String str3, Action action) {
        Preconditions.checkNotNull(str);
        m14569a((CacheVisitor) new 12(this.f9572k, str, str2, str3, action));
    }

    private void m14572c(String str, GraphQLSavedState graphQLSavedState) {
        Preconditions.checkNotNull(str);
        m14569a((CacheVisitor) new 8(this.f9572k, str, graphQLSavedState));
    }

    public final synchronized void m14587a(String str, GraphQLStory graphQLStory) {
        m14569a(this.f9572k.m14595a(str, graphQLStory));
    }

    public final synchronized void m14588a(String str, ProductItemAttachment productItemAttachment) {
        m14569a(this.f9572k.m14596a(str, productItemAttachment));
    }

    public final synchronized void m14590a(String str, boolean z) {
        m14569a(this.f9572k.m14597a(str, z));
    }

    public final synchronized void m14584a(String str, @Nullable GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit) {
        m14569a(this.f9572k.m14599a(str, graphQLPeopleYouMayInviteFeedUnit));
    }

    public final synchronized void m14585a(String str, @Nullable GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit) {
        m14569a(this.f9572k.m14600a(str, graphQLPeopleYouShouldFollowFeedUnit));
    }

    public final synchronized void m14583a(String str, @Nullable GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit) {
        m14569a(this.f9572k.m14598a(str, graphQLPaginatedPeopleYouMayKnowFeedUnit));
    }

    public final void m14581a(String str, @Nullable FeedUnit feedUnit) {
        Preconditions.checkNotNull(str);
        m14569a((CacheVisitor) new 9(this.f9572k, str, feedUnit));
        this.f9571j.m14605a(str, feedUnit != null);
    }
}
