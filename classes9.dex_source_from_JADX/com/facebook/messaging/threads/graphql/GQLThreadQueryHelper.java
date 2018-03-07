package com.facebook.messaging.threads.graphql;

import android.util.Pair;
import com.facebook.analytics.CounterLogger;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.MessagesInputThreadAndMessageId;
import com.facebook.graphql.calls.WithTagsInputTagNames;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQLRefParam.BatchQueryFanOutStyle;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.localstats.LocalStatsLogger;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import com.facebook.messaging.analytics.threads.FetchThreadLogger.FetchLocation;
import com.facebook.messaging.debugoverlay.MessagesDebugOverlaySettingsTags;
import com.facebook.messaging.graphql.fetch.GQLUserConverter;
import com.facebook.messaging.graphql.fetch.GQLUserRequestHelper;
import com.facebook.messaging.graphql.threads.ThreadQueries;
import com.facebook.messaging.graphql.threads.ThreadQueries.MontageThreadListQueryString;
import com.facebook.messaging.graphql.threads.ThreadQueries.PinnedThreadsQueryString;
import com.facebook.messaging.graphql.threads.ThreadQueries.ThreadQueryString;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MessageInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MontageThreadListQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MoreMessagesQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MoreThreadsQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.PinnedThreadsQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadListQueryModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.UserInfoModel;
import com.facebook.messaging.localfetch.FetchUserHandler;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.photos.size.MediaSizeUtil;
import com.facebook.messaging.requestrouting.RequestRoutingHelper;
import com.facebook.messaging.service.model.FetchMessageParams;
import com.facebook.messaging.service.model.FetchMessageResult;
import com.facebook.messaging.service.model.FetchMoreMessagesParams;
import com.facebook.messaging.service.model.FetchMoreMessagesResult;
import com.facebook.messaging.service.model.FetchMoreThreadsParams;
import com.facebook.messaging.service.model.FetchMoreThreadsResult;
import com.facebook.messaging.service.model.FetchPinnedThreadsParams;
import com.facebook.messaging.service.model.FetchPinnedThreadsResult;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicHeader;

/* compiled from: com.facebook.katana.activity.react.ImmersiveReactActivity */
public class GQLThreadQueryHelper {
    private final Clock f17805a;
    private final GatekeeperStoreImpl f17806b;
    private final GQLUserConverter f17807c;
    private final GQLThreadsConverter f17808d;
    private final GQLMessagesConverter f17809e;
    private final DebugOverlayController f17810f;
    private final GraphQLQueryExecutor f17811g;
    private final MediaSizeUtil f17812h;
    private final AbstractFbErrorReporter f17813i;
    private final FetchUserHandler f17814j;
    private final CounterLogger f17815k;
    private final LocalStatsLoggerImpl f17816l;
    private final GQLThreadsLogger f17817m;
    private final Provider<User> f17818n;
    private final ViewerContextManager f17819o;
    private final RequestRoutingHelper f17820p;
    private final GQLUserRequestHelper f17821q;
    private final Provider<Boolean> f17822r;
    private final Provider<Boolean> f17823s;
    private final Provider<Boolean> f17824t;
    private final Provider<Boolean> f17825u;
    private final UserCache f17826v;

    public static GQLThreadQueryHelper m17758b(InjectorLike injectorLike) {
        return new GQLThreadQueryHelper((Clock) SystemClockMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), GQLUserConverter.a(injectorLike), GQLThreadsConverter.m17782a(injectorLike), GQLMessagesConverter.m17734a(injectorLike), DebugOverlayController.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), MediaSizeUtil.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FetchUserHandler.m11956a(injectorLike), CounterLogger.a(injectorLike), LocalStatsLoggerMethodAutoProvider.a(injectorLike), GQLThreadsLogger.m17793a(injectorLike), IdBasedProvider.a(injectorLike, 3596), ViewerContextManagerProvider.a(injectorLike), RequestRoutingHelper.a(injectorLike), GQLUserRequestHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 4214), IdBasedProvider.a(injectorLike, 4216), IdBasedProvider.a(injectorLike, 4217), IdBasedProvider.a(injectorLike, 4204), UserCache.a(injectorLike));
    }

    private GraphQLRequest<ThreadListQueryModel> m17764f(FetchThreadListParams fetchThreadListParams, @Nullable CallerContext callerContext) {
        boolean z = fetchThreadListParams.f17120d;
        GraphQlQueryString a = ThreadQueries.a();
        a.a("include_thread_info", Boolean.TRUE.toString()).a("thread_count", Integer.valueOf(fetchThreadListParams.m17109f())).a("include_message_info", Boolean.FALSE.toString()).a("filter_to_groups", Boolean.toString(z)).a("fetch_users_separately", Boolean.TRUE.toString()).a("include_customer_data", (Boolean) this.f17825u.get()).a("exclude_email_addresses", Boolean.valueOf(m17755a()));
        this.f17821q.a(a);
        m17754a(a, fetchThreadListParams.f17118b);
        GraphQLRequest a2 = GraphQLRequest.a(a);
        a2.s = this.f17819o.b();
        a2.f = callerContext;
        m17752a(a2);
        return a2;
    }

    @Inject
    public GQLThreadQueryHelper(Clock clock, GatekeeperStore gatekeeperStore, GQLUserConverter gQLUserConverter, GQLThreadsConverter gQLThreadsConverter, GQLMessagesConverter gQLMessagesConverter, DebugOverlayController debugOverlayController, GraphQLQueryExecutor graphQLQueryExecutor, MediaSizeUtil mediaSizeUtil, FbErrorReporter fbErrorReporter, FetchUserHandler fetchUserHandler, CounterLogger counterLogger, LocalStatsLogger localStatsLogger, GQLThreadsLogger gQLThreadsLogger, Provider<User> provider, ViewerContextManager viewerContextManager, RequestRoutingHelper requestRoutingHelper, GQLUserRequestHelper gQLUserRequestHelper, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, UserCache userCache) {
        this.f17805a = clock;
        this.f17806b = gatekeeperStore;
        this.f17807c = gQLUserConverter;
        this.f17808d = gQLThreadsConverter;
        this.f17809e = gQLMessagesConverter;
        this.f17810f = debugOverlayController;
        this.f17811g = graphQLQueryExecutor;
        this.f17812h = mediaSizeUtil;
        this.f17813i = fbErrorReporter;
        this.f17814j = fetchUserHandler;
        this.f17815k = counterLogger;
        this.f17816l = localStatsLogger;
        this.f17817m = gQLThreadsLogger;
        this.f17818n = provider;
        this.f17819o = viewerContextManager;
        this.f17820p = requestRoutingHelper;
        this.f17821q = gQLUserRequestHelper;
        this.f17822r = provider2;
        this.f17823s = provider3;
        this.f17824t = provider4;
        this.f17825u = provider5;
        this.f17826v = userCache;
    }

    @Deprecated
    public final ThreadListQueryModel m17769a(FetchThreadListParams fetchThreadListParams, @Nullable CallerContext callerContext) {
        try {
            this.f17810f.a(MessagesDebugOverlaySettingsTags.f10824a, "fetchThreadList deprecated (GQL)");
            GraphQlQueryString a = ThreadQueries.a();
            a.a("include_thread_info", Boolean.TRUE.toString()).a("thread_count", Integer.valueOf(fetchThreadListParams.m17109f())).a("include_message_info", Boolean.FALSE.toString()).a("include_full_user_info", Boolean.TRUE.toString()).a("exclude_email_addresses", Boolean.valueOf(m17755a())).a("fetch_users_separately", Boolean.FALSE.toString());
            this.f17821q.a(a);
            m17754a(a, fetchThreadListParams.m17107b());
            GraphQLRequest a2 = GraphQLRequest.a(a);
            a2.a(this.f17819o.b());
            a2.a(callerContext);
            m17752a(a2);
            return (ThreadListQueryModel) ((GraphQLResult) FutureDetour.a(this.f17811g.a(a2), 1885976540)).d();
        } catch (Throwable e) {
            this.f17817m.m17809b(e);
            throw e;
        }
    }

    private Pair<ThreadListQueryModel, Collection<UserInfoModel>> m17761d(FetchThreadListParams fetchThreadListParams, @Nullable CallerContext callerContext) {
        try {
            Object e;
            this.f17810f.a(MessagesDebugOverlaySettingsTags.f10824a, "fetchThreadList (GQL)");
            GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("ThreadList");
            GraphQLRequest f = m17764f(fetchThreadListParams, callerContext);
            ListenableFuture b = graphQLBatchRequest.b(f);
            Future future = null;
            if (!((Boolean) this.f17824t.get()).booleanValue()) {
                future = graphQLBatchRequest.b(this.f17821q.a(f.a("actor_id", BatchQueryFanOutStyle.ALL), callerContext));
            }
            this.f17811g.a(graphQLBatchRequest);
            ThreadListQueryModel threadListQueryModel = (ThreadListQueryModel) ((GraphQLResult) FutureDetour.a(b, 414682230)).d();
            List emptyList = Collections.emptyList();
            if (future != null) {
                try {
                    e = ((GraphQLResult) FutureDetour.a(future, -473630079)).e();
                } catch (ExecutionException e2) {
                    if (!(e2.getCause() instanceof GraphQLException)) {
                        throw e2;
                    } else if (!(threadListQueryModel == null || threadListQueryModel.a() == null || threadListQueryModel.a().j().isEmpty())) {
                        throw e2;
                    }
                }
                return new Pair(threadListQueryModel, e);
            }
            List list = emptyList;
            return new Pair(threadListQueryModel, e);
        } catch (Throwable e3) {
            this.f17817m.m17809b(e3);
            throw e3;
        }
    }

    public final FetchThreadListResult m17778b(FetchThreadListParams fetchThreadListParams, @Nullable CallerContext callerContext) {
        Pair d = m17761d(fetchThreadListParams, callerContext);
        ThreadListQueryModel threadListQueryModel = (ThreadListQueryModel) d.first;
        Collection collection = (Collection) d.second;
        if (threadListQueryModel.a() == null) {
            this.f17817m.m17807b();
            throw new NullPointerException();
        }
        try {
            NotificationSetting b = NotificationSetting.b((long) threadListQueryModel.a().a());
            FolderCounts folderCounts = new FolderCounts(threadListQueryModel.a().m(), threadListQueryModel.a().n(), 0, -1);
            ImmutableMap a = this.f17807c.a(collection);
            if (this.f17818n.get() == null) {
                this.f17817m.m17798a(callerContext);
            }
            return FetchThreadListResult.newBuilder().m17119a(DataFetchDisposition.b).m17121a(fetchThreadListParams.m17107b()).m17123a(this.f17808d.m17789a(threadListQueryModel.a().j(), a, threadListQueryModel.a().j().size() < fetchThreadListParams.m17109f(), (User) this.f17818n.get())).m17125a(ImmutableList.copyOf(a.values())).m17120a(folderCounts).m17122a(b).m17126a(false).m17118a(SystemClock.b().a()).m17128c(Long.parseLong(threadListQueryModel.a().l())).m17129m();
        } catch (Throwable e) {
            this.f17817m.m17806a(e);
            throw e;
        }
    }

    private GraphQLRequest<MontageThreadListQueryModel> m17765g(FetchThreadListParams fetchThreadListParams, @Nullable CallerContext callerContext) {
        GraphQlQueryString montageThreadListQueryString = new MontageThreadListQueryString();
        montageThreadListQueryString.a("include_thread_info", Boolean.TRUE.toString()).a("thread_count", Integer.valueOf(fetchThreadListParams.m17109f())).a("include_message_info", Boolean.FALSE.toString()).a("fetch_users_separately", Boolean.TRUE.toString()).a("exclude_email_addresses", Boolean.valueOf(m17755a()));
        GraphQLRequest a = GraphQLRequest.a(montageThreadListQueryString);
        a.s = this.f17819o.b();
        a.f = callerContext;
        m17752a(a);
        return a;
    }

    private MontageThreadListQueryModel m17763e(FetchThreadListParams fetchThreadListParams, @Nullable CallerContext callerContext) {
        try {
            this.f17810f.a(MessagesDebugOverlaySettingsTags.f10824a, "fetchMontageThreadList (GQL)");
            return (MontageThreadListQueryModel) ((GraphQLResult) FutureDetour.a(this.f17811g.a(m17765g(fetchThreadListParams, callerContext)), 1860637804)).d();
        } catch (Throwable e) {
            this.f17817m.m17809b(e);
            throw e;
        }
    }

    public final FetchThreadListResult m17779c(FetchThreadListParams fetchThreadListParams, @Nullable CallerContext callerContext) {
        MontageThreadListQueryModel e = m17763e(fetchThreadListParams, callerContext);
        if (e.a() == null) {
            throw new NullPointerException();
        }
        try {
            return FetchThreadListResult.newBuilder().m17119a(DataFetchDisposition.b).m17121a(FolderName.MONTAGE).m17123a(this.f17808d.m17789a(e.a().a(), null, e.a().a().size() < fetchThreadListParams.m17109f(), (User) this.f17818n.get())).m17120a(new FolderCounts(e.a().j(), e.a().k(), 0, -1)).m17126a(false).m17118a(SystemClock.b().a()).m17129m();
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Deprecated
    public final MoreThreadsQueryModel m17768a(FetchMoreThreadsParams fetchMoreThreadsParams, @Nullable CallerContext callerContext) {
        try {
            this.f17810f.a(MessagesDebugOverlaySettingsTags.f10824a, "fetchMoreThreads deprecated (GQL)");
            GraphQlQueryString c = ThreadQueries.c();
            c.a("after_time_ms", String.valueOf(fetchMoreThreadsParams.m17090c())).a("thread_count", Integer.valueOf(fetchMoreThreadsParams.m17091d())).a("include_message_info", Boolean.FALSE.toString()).a("include_full_user_info", Boolean.TRUE.toString()).a("exclude_email_addresses", Boolean.valueOf(m17755a()));
            this.f17821q.a(c);
            m17754a(c, fetchMoreThreadsParams.m17089a());
            GraphQLRequest a = GraphQLRequest.a(c);
            a.a(this.f17819o.b());
            a.a(callerContext);
            m17752a(a);
            return (MoreThreadsQueryModel) ((GraphQLResult) FutureDetour.a(this.f17811g.a(a), 110947215)).d();
        } catch (Throwable e) {
            this.f17817m.m17811d(e);
            throw e;
        }
    }

    private Pair<MoreThreadsQueryModel, Collection<UserInfoModel>> m17760c(FetchMoreThreadsParams fetchMoreThreadsParams, @Nullable CallerContext callerContext) {
        try {
            Object e;
            this.f17810f.a(MessagesDebugOverlaySettingsTags.f10824a, "fetchMoreThreads (GQL)");
            GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("MoreThreads");
            GraphQLRequest d = m17762d(fetchMoreThreadsParams, callerContext);
            ListenableFuture b = graphQLBatchRequest.b(d);
            ListenableFuture b2 = graphQLBatchRequest.b(this.f17821q.a(d.a("actor_id", BatchQueryFanOutStyle.ALL), callerContext));
            this.f17811g.a(graphQLBatchRequest);
            MoreThreadsQueryModel moreThreadsQueryModel = (MoreThreadsQueryModel) ((GraphQLResult) FutureDetour.a(b, -114193621)).d();
            try {
                e = ((GraphQLResult) FutureDetour.a(b2, 769301498)).e();
            } catch (ExecutionException e2) {
                if (!(e2.getCause() instanceof GraphQLException)) {
                    throw e2;
                } else if (moreThreadsQueryModel == null || moreThreadsQueryModel.a() == null || moreThreadsQueryModel.a().a().isEmpty()) {
                    e = Collections.emptyList();
                } else {
                    throw e2;
                }
            }
            return new Pair(moreThreadsQueryModel, e);
        } catch (Throwable e3) {
            this.f17817m.m17811d(e3);
            throw e3;
        }
    }

    public final FetchMoreThreadsResult m17777b(FetchMoreThreadsParams fetchMoreThreadsParams, @Nullable CallerContext callerContext) {
        Pair c = m17760c(fetchMoreThreadsParams, callerContext);
        MoreThreadsQueryModel moreThreadsQueryModel = (MoreThreadsQueryModel) c.first;
        Collection collection = (Collection) c.second;
        try {
            this.f17817m.m17805a("Fetch-more-threads null response", moreThreadsQueryModel.a());
            this.f17817m.m17805a("Page info missing", moreThreadsQueryModel.a().j());
            ImmutableMap a = this.f17807c.a(collection);
            return new FetchMoreThreadsResult(DataFetchDisposition.b, fetchMoreThreadsParams.m17089a(), this.f17808d.m17789a(moreThreadsQueryModel.a().a(), a, moreThreadsQueryModel.a().a().size() < fetchMoreThreadsParams.m17091d(), (User) this.f17818n.get()), ImmutableList.copyOf(a.values()), SystemClock.b().a());
        } catch (Throwable e) {
            this.f17817m.m17810c(e);
            throw e;
        }
    }

    public final FetchThreadResult m17773a(FetchThreadParams fetchThreadParams, @Nullable CallerContext callerContext) {
        this.f17810f.a(MessagesDebugOverlaySettingsTags.f10824a, "fetchThread (GQL). " + fetchThreadParams.m17130a());
        ThreadKey a = fetchThreadParams.m17130a().a();
        this.f17817m.m17805a("Received FetchThreadParams with a legacy thread id: " + fetchThreadParams.m17130a().a, a);
        FetchThreadResult fetchThreadResult = (FetchThreadResult) m17775a(ImmutableSet.of(a), fetchThreadParams.m17133f(), callerContext, false).get(a);
        if (fetchThreadResult == null) {
            if (ThreadKey.b(a)) {
                String valueOf = String.valueOf(a.d);
                Object a2 = this.f17826v.a(UserKey.b(valueOf));
                if (a2 == null) {
                    UserInfoModel a3 = m17748a(valueOf, callerContext);
                    if (a3 != null) {
                        try {
                            a2 = this.f17807c.a(a3);
                        } catch (Throwable e) {
                            this.f17817m.m17812e(e);
                            throw e;
                        }
                    }
                }
                if (a2 != null) {
                    fetchThreadResult = FetchThreadResult.m17150b().m17142a(DataFetchDisposition.b).m17145a(ImmutableList.of(a2, this.f17818n.get())).m17141a(this.f17805a.a()).m17147a();
                }
            } else if (ThreadKey.j(a)) {
                fetchThreadResult = FetchThreadResult.m17150b().m17142a(DataFetchDisposition.b).m17141a(this.f17805a.a()).m17147a();
            }
        }
        if (fetchThreadResult != null) {
            return fetchThreadResult;
        }
        this.f17817m.m17802a(a);
        throw new Exception("Couldn't find thread (over GraphQL): " + a.toString());
    }

    private Map<Long, ThreadInfoModel> m17751a(Set<ThreadKey> set, int i, Boolean bool, @Nullable CallerContext callerContext) {
        try {
            GraphQLRequest a = GraphQLRequest.a(m17767a((Set) set, i, bool));
            a.a(this.f17819o.b());
            a.a(callerContext);
            m17752a(a);
            List<ThreadInfoModel> list = (List) FutureDetour.a(GraphQLQueryExecutor.b(this.f17811g.a(a)), -505998299);
            Map hashMap = new HashMap(list.size());
            for (ThreadInfoModel threadInfoModel : list) {
                ThreadKey a2 = this.f17808d.m17787a(threadInfoModel, (User) this.f17818n.get());
                if (a2 != null) {
                    hashMap.put(Long.valueOf(a2.i()), threadInfoModel);
                }
            }
            return hashMap;
        } catch (Throwable e) {
            this.f17817m.m17815h(e);
            throw e;
        }
    }

    public final ThreadQueryString m17767a(Set<ThreadKey> set, int i, Boolean bool) {
        Builder builder = ImmutableList.builder();
        for (ThreadKey i2 : set) {
            builder.c(String.valueOf(i2.i()));
        }
        return m17766a(builder.b(), i, bool);
    }

    public final ImmutableMap<ThreadKey, FetchThreadResult> m17775a(Set<ThreadKey> set, int i, @Nullable CallerContext callerContext, boolean z) {
        ImmutableMap immutableMap;
        Boolean bool;
        Boolean bool2 = Boolean.TRUE;
        if (z) {
            immutableMap = null;
            bool = bool2;
        } else {
            ImmutableMap a = this.f17814j.m11961a((Set) set);
            if (a != null) {
                immutableMap = a;
                bool = Boolean.FALSE;
            } else {
                immutableMap = a;
                bool = bool2;
            }
        }
        long a2 = SystemClock.b().a();
        Map a3 = m17751a((Set) set, i, bool, callerContext);
        try {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            for (ThreadKey threadKey : set) {
                Object a4;
                ThreadInfoModel threadInfoModel = (ThreadInfoModel) a3.get(Long.valueOf(threadKey.i()));
                if (threadInfoModel != null) {
                    ImmutableList immutableList;
                    Object fetchLocation;
                    Object obj;
                    if (immutableMap != null) {
                        immutableList = (ImmutableList) immutableMap.get(threadKey);
                    } else {
                        immutableList = null;
                    }
                    a4 = this.f17808d.m17792a(threadKey, threadInfoModel, (User) this.f17818n.get(), immutableList);
                    Map hashMap = new HashMap();
                    long a5 = SystemClock.b().a() - a2;
                    if (immutableMap == null || immutableList == null) {
                        fetchLocation = FetchLocation.SERVER.toString();
                        obj = "server_duration";
                    } else {
                        fetchLocation = FetchLocation.LOCAL.toString();
                        obj = "local_duration";
                    }
                    hashMap.put("fetch_location", fetchLocation);
                    hashMap.put(obj, Long.toString(a5));
                    a4.f17185h = hashMap;
                } else if (immutableMap != null) {
                    a4 = FetchThreadResult.m17150b().m17142a(DataFetchDisposition.b).m17145a(FetchUserHandler.m11957a((User) this.f17818n.get(), (ImmutableList) immutableMap.get(threadKey))).m17141a(this.f17805a.a()).m17147a();
                }
                builder.b(threadKey, a4);
            }
            return builder.b();
        } catch (Throwable e) {
            this.f17817m.m17814g(e);
            throw e;
        }
    }

    public final FetchMoreMessagesResult m17771a(FetchMoreMessagesParams fetchMoreMessagesParams, @Nullable CallerContext callerContext) {
        try {
            return m17770a(m17756b(fetchMoreMessagesParams, callerContext), fetchMoreMessagesParams.m17086a());
        } catch (Throwable e) {
            this.f17817m.m17816i(e);
            throw e;
        }
    }

    public final FetchMoreMessagesResult m17770a(MoreMessagesQueryModel moreMessagesQueryModel, ThreadKey threadKey) {
        return new FetchMoreMessagesResult(DataFetchDisposition.b, this.f17809e.m17744a(threadKey, moreMessagesQueryModel.a(), (User) this.f17818n.get()), SystemClock.a.a());
    }

    public final ImmutableMap<String, FetchMessageResult> m17776a(Set<FetchMessageParams> set, @Nullable CallerContext callerContext) {
        try {
            return m17774a(m17759b((Set) set, callerContext), (Set) set);
        } catch (Throwable e) {
            this.f17817m.m17818k(e);
            throw e;
        }
    }

    public final FetchPinnedThreadsResult m17772a(FetchPinnedThreadsParams fetchPinnedThreadsParams, @Nullable CallerContext callerContext) {
        try {
            return this.f17808d.m17791a(m17757b(fetchPinnedThreadsParams, callerContext).a(), (User) this.f17818n.get());
        } catch (Throwable e) {
            this.f17817m.m17820m(e);
            throw e;
        }
    }

    public final ThreadQueryString m17766a(ImmutableList<String> immutableList, int i, Boolean bool) {
        GraphQlQueryString threadQueryString = new ThreadQueryString();
        threadQueryString.a("thread_ids", immutableList).a("include_message_info", Boolean.TRUE.toString()).a("msg_count", Integer.valueOf(i)).a("include_customer_data", (Boolean) this.f17825u.get()).a("exclude_email_addresses", Boolean.valueOf(m17755a()));
        if (!((Boolean) this.f17823s.get()).booleanValue()) {
            threadQueryString.a("include_full_user_info", bool.toString());
        } else if (bool.booleanValue()) {
            threadQueryString.a("include_full_user_info", Boolean.TRUE.toString());
        } else {
            threadQueryString.a("fetch_users_separately", Boolean.TRUE.toString());
        }
        threadQueryString.a("fetch_former_users", Boolean.valueOf(!((Boolean) this.f17822r.get()).booleanValue()).toString());
        m17753a(threadQueryString);
        this.f17821q.a(threadQueryString);
        return threadQueryString;
    }

    private void m17753a(GraphQlQueryString graphQlQueryString) {
        graphQlQueryString.a("full_screen_height", Integer.valueOf(this.f17812h.g())).a("full_screen_width", Integer.valueOf(this.f17812h.f())).a("small_preview_size", Integer.valueOf(this.f17812h.k())).a("medium_preview_size", Integer.valueOf(this.f17812h.j())).a("large_preview_size", Integer.valueOf(this.f17812h.i()));
    }

    public static ImmutableList<MessagesInputThreadAndMessageId> m17750a(Set<FetchMessageParams> set) {
        Builder builder = ImmutableList.builder();
        for (FetchMessageParams fetchMessageParams : set) {
            MessagesInputThreadAndMessageId messagesInputThreadAndMessageId = new MessagesInputThreadAndMessageId();
            messagesInputThreadAndMessageId.a("thread_id", Long.toString(fetchMessageParams.f17064b.i()));
            GraphQlCallInput graphQlCallInput = messagesInputThreadAndMessageId;
            graphQlCallInput.a("message_id", fetchMessageParams.f17063a);
            builder.c(graphQlCallInput);
        }
        return builder.b();
    }

    public final ImmutableMap<String, FetchMessageResult> m17774a(Collection<MessageInfoModel> collection, Set<FetchMessageParams> set) {
        Map hashMap = new HashMap(collection.size());
        for (MessageInfoModel messageInfoModel : collection) {
            if (messageInfoModel != null) {
                hashMap.put(messageInfoModel.w(), messageInfoModel);
            }
        }
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (FetchMessageParams fetchMessageParams : set) {
            MessageInfoModel messageInfoModel2 = (MessageInfoModel) hashMap.get(fetchMessageParams.f17063a);
            if (messageInfoModel2 == null) {
                this.f17815k.a("gql_fetch_msg_fail");
                this.f17816l.a(3211285);
                String str = fetchMessageParams.f17063a;
            } else {
                try {
                    builder.b(fetchMessageParams.f17063a, m17749a(messageInfoModel2, fetchMessageParams.f17064b));
                } catch (Exception e) {
                    this.f17813i.a(SoftError.b("message_fetch", "Failed to convert graphql message model"));
                }
            }
        }
        return builder.b();
    }

    private GraphQLRequest<MoreThreadsQueryModel> m17762d(FetchMoreThreadsParams fetchMoreThreadsParams, @Nullable CallerContext callerContext) {
        GraphQlQueryString c = ThreadQueries.c();
        c.a("after_time_ms", String.valueOf(fetchMoreThreadsParams.f17085c)).a("thread_count", Integer.valueOf(fetchMoreThreadsParams.f17087e)).a("include_message_info", Boolean.FALSE.toString()).a("include_full_user_info", Boolean.TRUE.toString()).a("exclude_email_addresses", Boolean.valueOf(m17755a()));
        this.f17821q.a(c);
        m17754a(c, fetchMoreThreadsParams.f17083a);
        GraphQLRequest a = GraphQLRequest.a(c);
        a.s = this.f17819o.b();
        a.f = callerContext;
        m17752a(a);
        return a;
    }

    private UserInfoModel m17748a(String str, @Nullable CallerContext callerContext) {
        try {
            Collection e = ((GraphQLResult) FutureDetour.a(this.f17811g.a(this.f17821q.a(Lists.a(new String[]{str}), callerContext)), 216949943)).e();
            return e.isEmpty() ? null : (UserInfoModel) e.iterator().next();
        } catch (Throwable e2) {
            this.f17817m.m17813f(e2);
            throw e2;
        }
    }

    private MoreMessagesQueryModel m17756b(FetchMoreMessagesParams fetchMoreMessagesParams, @Nullable CallerContext callerContext) {
        try {
            this.f17810f.a(MessagesDebugOverlaySettingsTags.f10824a, "fetchMoreMessages (GQL). " + fetchMoreMessagesParams.m17086a());
            GraphQlQueryString f = ThreadQueries.f();
            f.a("thread_id", String.valueOf(fetchMoreMessagesParams.m17086a().i())).a("before_time_ms", String.valueOf(fetchMoreMessagesParams.m17087c())).a("msg_count", Integer.valueOf(fetchMoreMessagesParams.m17088d()));
            m17753a(f);
            GraphQLRequest a = GraphQLRequest.a(f);
            a.a(this.f17819o.b());
            a.a(callerContext);
            m17752a(a);
            return (MoreMessagesQueryModel) ((GraphQLResult) FutureDetour.a(this.f17811g.a(a), -1746710512)).d();
        } catch (Throwable e) {
            this.f17817m.m17817j(e);
            throw e;
        }
    }

    private List<MessageInfoModel> m17759b(Set<FetchMessageParams> set, @Nullable CallerContext callerContext) {
        try {
            ImmutableList a = m17750a((Set) set);
            GraphQlQueryString g = ThreadQueries.g();
            g.a("thread_msg_ids", a);
            m17753a(g);
            GraphQLRequest a2 = GraphQLRequest.a(g);
            a2.a(this.f17819o.b());
            a2.a(callerContext);
            m17752a(a2);
            return (List) FutureDetour.a(GraphQLQueryExecutor.b(this.f17811g.a(a2)), -1770818057);
        } catch (Throwable e) {
            this.f17817m.m17819l(e);
            throw e;
        }
    }

    private PinnedThreadsQueryModel m17757b(FetchPinnedThreadsParams fetchPinnedThreadsParams, @Nullable CallerContext callerContext) {
        try {
            long j = fetchPinnedThreadsParams.f17096c / 1000;
            this.f17810f.a(MessagesDebugOverlaySettingsTags.f10824a, "fetchPinnedThreads (GQL) after time: " + j);
            PinnedThreadsQueryString i = ThreadQueries.i();
            i.a("after_time_sec", String.valueOf(j)).a("thread_count", Integer.valueOf(60)).a("include_message_info", Boolean.FALSE.toString()).a("include_full_user_info", Boolean.FALSE.toString()).a("exclude_email_addresses", Boolean.valueOf(m17755a()));
            GraphQLRequest a = GraphQLRequest.a(i);
            a.a(this.f17819o.b());
            a.a(callerContext);
            m17752a(a);
            return (PinnedThreadsQueryModel) ((GraphQLResult) FutureDetour.a(this.f17811g.a(a), -1635274584)).d();
        } catch (Throwable e) {
            this.f17817m.m17821n(e);
            throw e;
        }
    }

    @Nullable
    private FetchMessageResult m17749a(MessageInfoModel messageInfoModel, ThreadKey threadKey) {
        return new FetchMessageResult(DataFreshnessResult.FROM_SERVER, this.f17809e.m17742a(threadKey, messageInfoModel, (User) this.f17818n.get()), SystemClock.a.a());
    }

    private static void m17754a(GraphQlQueryString graphQlQueryString, FolderName folderName) {
        ImmutableList of;
        if (folderName == FolderName.PENDING) {
            of = ImmutableList.of(WithTagsInputTagNames.PENDING);
        } else if (folderName == FolderName.OTHER) {
            of = ImmutableList.of(WithTagsInputTagNames.OTHER);
        } else if (folderName == FolderName.ARCHIVED) {
            of = ImmutableList.of(WithTagsInputTagNames.ARCHIVED);
        } else if (folderName == FolderName.SPAM) {
            of = ImmutableList.of(WithTagsInputTagNames.SPAM);
        } else {
            of = RegularImmutableList.a;
        }
        List list = of;
        if (!list.isEmpty()) {
            graphQlQueryString.a("folder_tag", list);
        }
    }

    private void m17752a(GraphQLRequest graphQLRequest) {
        Object a = this.f17820p.a();
        if (!StringUtil.c(a)) {
            graphQLRequest.g = ImmutableList.of(new BasicHeader("X-MSGR-Region", a));
        }
    }

    private boolean m17755a() {
        return this.f17806b.a(861, false);
    }
}
