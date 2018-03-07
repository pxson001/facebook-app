package com.facebook.messaging.users.refresh;

import android.util.Pair;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQLRefParam.BatchQueryFanOutStyle;
import com.facebook.graphql.query.GraphQLRefParam.FallbackStyle;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.database.handlers.DbInsertThreadUsersHandler;
import com.facebook.messaging.database.threads.DbThreadProperties;
import com.facebook.messaging.database.threads.DbThreadsPropertyUtil;
import com.facebook.messaging.graphql.fetch.GQLUserConverter;
import com.facebook.messaging.graphql.fetch.GQLUserRequestHelper;
import com.facebook.messaging.graphql.threads.UserInfoModels.UserInfoModel;
import com.facebook.messaging.users.refresh.graphql.MostRecentConversationUserQueries.UsersAfterTimeQueryString;
import com.facebook.messaging.users.refresh.graphql.MostRecentConversationUserQueriesModels.UsersAfterTimeQueryModel;
import com.facebook.messaging.users.refresh.graphql.MostRecentConversationUserQueriesModels.UsersAfterTimeQueryModel.MessageThreadsModel;
import com.facebook.messaging.users.refresh.graphql.MostRecentConversationUserQueriesModels.UsersAfterTimeQueryModel.MessageThreadsModel.NodesModel;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

@UserScoped
/* compiled from: chat_head_nux */
public class MessagesUserInfoRefresher {
    private static final Object f18323h = new Object();
    private final DbInsertThreadUsersHandler f18324a;
    private final DbThreadsPropertyUtil f18325b;
    private final MessagesBroadcaster f18326c;
    private final GraphQLQueryExecutor f18327d;
    private final GQLUserConverter f18328e;
    private final GQLUserRequestHelper f18329f;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f18330g = UltralightRuntime.b;

    private static MessagesUserInfoRefresher m18279b(InjectorLike injectorLike) {
        MessagesUserInfoRefresher messagesUserInfoRefresher = new MessagesUserInfoRefresher(DbInsertThreadUsersHandler.m10937a(injectorLike), DbThreadsPropertyUtil.m11132a(injectorLike), MessagesBroadcaster.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), GQLUserConverter.a(injectorLike), GQLUserRequestHelper.b(injectorLike));
        messagesUserInfoRefresher.f18330g = IdBasedLazy.a(injectorLike, 7693);
        return messagesUserInfoRefresher;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.users.refresh.MessagesUserInfoRefresher m18278a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f18323h;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m18279b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f18323h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.users.refresh.MessagesUserInfoRefresher) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.users.refresh.MessagesUserInfoRefresher) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f18323h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.users.refresh.MessagesUserInfoRefresher) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.users.refresh.MessagesUserInfoRefresher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.users.refresh.MessagesUserInfoRefresher");
    }

    @Inject
    public MessagesUserInfoRefresher(DbInsertThreadUsersHandler dbInsertThreadUsersHandler, DbThreadsPropertyUtil dbThreadsPropertyUtil, MessagesBroadcaster messagesBroadcaster, GraphQLQueryExecutor graphQLQueryExecutor, GQLUserConverter gQLUserConverter, GQLUserRequestHelper gQLUserRequestHelper) {
        this.f18324a = dbInsertThreadUsersHandler;
        this.f18325b = dbThreadsPropertyUtil;
        this.f18326c = messagesBroadcaster;
        this.f18327d = graphQLQueryExecutor;
        this.f18328e = gQLUserConverter;
        this.f18329f = gQLUserRequestHelper;
    }

    public final void m18280a() {
        Pair a = m18277a(this.f18325b.a(DbThreadProperties.f10473f, -1));
        long longValue = ((Long) a.first).longValue();
        List list = (ImmutableList) a.second;
        if (!list.isEmpty()) {
            this.f18325b.b(DbThreadProperties.f10473f, longValue);
            this.f18324a.m10939a(list);
            CacheInsertThreadsHandler cacheInsertThreadsHandler = (CacheInsertThreadsHandler) this.f18330g.get();
            cacheInsertThreadsHandler.f9460l.a(list);
            cacheInsertThreadsHandler.f9450b.m10142a();
            this.f18326c.a();
        }
    }

    private Pair<Long, ImmutableList<User>> m18277a(long j) {
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("UserRefreshBatch");
        long j2 = 1 + j;
        GraphQlQueryString usersAfterTimeQueryString = new UsersAfterTimeQueryString();
        usersAfterTimeQueryString.a("count", Integer.valueOf(20));
        usersAfterTimeQueryString.a("after_time_ms", Long.valueOf(j2));
        GraphQLRequest a = GraphQLRequest.a(usersAfterTimeQueryString);
        ListenableFuture b = graphQLBatchRequest.b(a);
        ListenableFuture b2 = graphQLBatchRequest.b(this.f18329f.a(a.a("user_id", BatchQueryFanOutStyle.ALL, FallbackStyle.SKIP), null));
        this.f18327d.a(graphQLBatchRequest);
        Collection<UserInfoModel> e = ((GraphQLResult) FutureDetour.a(b2, 411627795)).e();
        Integer.valueOf(e.size());
        Builder builder = new Builder();
        for (UserInfoModel a2 : e) {
            builder.c(this.f18328e.a(a2));
        }
        ImmutableList b3 = builder.b();
        MessageThreadsModel a3 = ((UsersAfterTimeQueryModel) ((GraphQLResult) FutureDetour.a(b, 390573812)).e).m18320a();
        Preconditions.checkNotNull(a3);
        if (a3.m18316a().isEmpty()) {
            Preconditions.checkState(b3.isEmpty());
        } else {
            j = Long.parseLong(((NodesModel) a3.m18316a().get(0)).m18312a());
        }
        return new Pair(Long.valueOf(j), b3);
    }
}
