package com.facebook.controller.connectioncontroller;

import android.os.Handler;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.controller.connectioncontroller.common.ConnectionCacheRetainingPolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionChunk;
import com.facebook.controller.connectioncontroller.common.ConnectionConfiguration;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionFetchOperation;
import com.facebook.controller.connectioncontroller.common.ConnectionInitialFetchPolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionListener;
import com.facebook.controller.connectioncontroller.common.ConnectionListenerAnnouncer;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation.LocationType;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.common.ConnectionStore;
import com.facebook.controller.connectioncontroller.common.ConnectionStore.ConnectionStoreListener;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.controller.connectioncontroller.common.SimpleConnectionConfiguration;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.feed.controller.GroupsConnectionConfiguration;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: messenger_thread_customizations */
public class ConnectionControllerImpl<TEdge, TUserInfo, TRequestModel, TResponseModel> implements ConnectionController<TEdge, TUserInfo> {
    public final Map<ConnectionFetchOperation, FutureAndCallbackHolder<GraphQLResult<TResponseModel>>> f7910a = Collections.synchronizedMap(new HashMap());
    private final ConnectionStoreListener f7911b = new C03841(this);
    public final Handler f7912c;
    private final GraphQLQueryExecutor f7913d;
    private final GraphQLCacheManager f7914e;
    public final DefaultAndroidThreadUtil f7915f;
    public final AbstractFbErrorReporter f7916g;
    public final ConnectionConfiguration<TEdge, TUserInfo, TRequestModel, TResponseModel> f7917h;
    public final ConnectionListenerAnnouncer<TEdge> f7918i;
    public final ConnectionStore<TEdge> f7919j;
    private final MutationControllerManager f7920k;
    public final ConnectionInitialFetchPolicy f7921l;
    private final ConnectionCacheRetainingPolicy f7922m;
    private final boolean f7923n;
    private final String f7924o;
    public final InitialFetchHandler<TUserInfo> f7925p = new InitialFetchHandler();
    private boolean f7926q;

    /* compiled from: messenger_thread_customizations */
    class C03841 implements ConnectionStoreListener<TEdge> {
        final /* synthetic */ ConnectionControllerImpl f7927a;

        C03841(ConnectionControllerImpl connectionControllerImpl) {
            this.f7927a = connectionControllerImpl;
        }

        public final void mo666a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            this.f7927a.f7918i.mo630b(connectionLocation, connectionOrder);
            for (ConnectionFetchOperation connectionFetchOperation : this.f7927a.f7910a.keySet()) {
                if (connectionFetchOperation.a == connectionLocation && connectionFetchOperation.b == connectionOrder) {
                    break;
                }
            }
            ConnectionFetchOperation connectionFetchOperation2 = null;
            this.f7927a.f7910a.remove(connectionFetchOperation2);
        }

        public final void mo665a(int i, int i2, ConnectionState<TEdge> connectionState, boolean z) {
            ConnectionState a = this.f7927a.f7919j.mo651a();
            Integer.valueOf(i2);
            Integer.valueOf(i);
            Integer.valueOf(a.mo626e().size());
            Integer.valueOf(a.mo625d());
            this.f7927a.f7918i.mo633a(i, i2, z);
        }

        public final void mo664a(int i, int i2, ConnectionState<TEdge> connectionState) {
            ConnectionState a = this.f7927a.f7919j.mo651a();
            Integer.valueOf(i2);
            Integer.valueOf(i);
            Integer.valueOf(a.mo626e().size());
            Integer.valueOf(a.mo625d());
            this.f7927a.f7918i.mo632a(i, i2);
        }

        public final void mo668b(int i, int i2, ConnectionState<TEdge> connectionState) {
            ConnectionState a = this.f7927a.f7919j.mo651a();
            Integer.valueOf(i2);
            Integer.valueOf(i);
            Integer.valueOf(a.mo626e().size());
            Integer.valueOf(a.mo625d());
            this.f7927a.f7918i.mo634b(i, i2);
        }

        public final void mo663a() {
            ConnectionState a = this.f7927a.f7919j.mo651a();
            Integer.valueOf(a.mo626e().size());
            Integer.valueOf(a.mo625d());
            this.f7927a.f7918i.mo631a();
        }

        public final void mo667b() {
            ConnectionState a = this.f7927a.f7919j.mo651a();
            Integer.valueOf(a.mo626e().size());
            Integer.valueOf(a.mo625d());
            ConnectionFetchOperation a2 = this.f7927a.f7925p.m8238a();
            if (a2 == null) {
                return;
            }
            if (a.mo625d() == 0 || this.f7927a.f7921l == ConnectionInitialFetchPolicy.CHECK_SERVER_FOR_NEWDATA) {
                ConnectionControllerImpl.m8220b(this.f7927a, a.mo623b(), a2.b, a2.e, a2.f);
            }
        }
    }

    /* compiled from: messenger_thread_customizations */
    class InitialFetchHandler<TUserInfo> {
        private ConnectionFetchOperation f7928a;
        private boolean f7929b = false;

        final synchronized boolean m8239a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, int i, TUserInfo tUserInfo) {
            boolean z = false;
            synchronized (this) {
                if (!this.f7929b) {
                    if (this.f7928a == null) {
                        if (LocationType.INITIAL == connectionLocation.m8261b()) {
                            z = true;
                        }
                        Preconditions.checkArgument(z);
                        this.f7928a = new ConnectionFetchOperation(connectionLocation, connectionOrder, null, null, i, tUserInfo);
                    }
                    z = true;
                }
            }
            return z;
        }

        final synchronized ConnectionFetchOperation<TUserInfo> m8238a() {
            this.f7929b = true;
            return this.f7928a;
        }
    }

    @Inject
    public ConnectionControllerImpl(@Assisted ConnectionConfiguration<TEdge, TUserInfo, TRequestModel, TResponseModel> connectionConfiguration, @Assisted ConnectionStore<TEdge> connectionStore, @Assisted MutationControllerManager mutationControllerManager, @Assisted ConnectionInitialFetchPolicy connectionInitialFetchPolicy, @Assisted ConnectionCacheRetainingPolicy connectionCacheRetainingPolicy, @Assisted boolean z, @Assisted String str, Handler handler, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLCacheManager graphQLCacheManager, AndroidThreadUtil androidThreadUtil, FbErrorReporter fbErrorReporter) {
        if ((connectionConfiguration instanceof GroupsConnectionConfiguration) || (connectionConfiguration instanceof SimpleConnectionConfiguration)) {
            this.f7917h = connectionConfiguration;
            this.f7919j = connectionStore;
            this.f7920k = mutationControllerManager;
            this.f7921l = connectionInitialFetchPolicy;
            this.f7922m = connectionCacheRetainingPolicy;
            this.f7923n = z;
            this.f7924o = str;
            this.f7912c = handler;
            this.f7913d = graphQLQueryExecutor;
            this.f7914e = graphQLCacheManager;
            this.f7915f = androidThreadUtil;
            this.f7916g = fbErrorReporter;
            if (this.f7920k != null) {
                this.f7920k.a(this.f7919j);
            }
            this.f7918i = new ConnectionListenerAnnouncer();
            return;
        }
        throw new IllegalArgumentException("Configuration must be LegacyConnectionConfiguration or SimpleConnectionConfiguration");
    }

    public final void mo635a() {
        if (!this.f7926q) {
            this.f7919j.mo654a(this.f7911b);
            this.f7919j.mo658b();
            this.f7926q = true;
        }
    }

    public final void mo636a(int i, TUserInfo tUserInfo) {
        Preconditions.checkState(this.f7926q);
        this.f7915f.a();
        mo638a(this.f7919j.mo651a().mo623b(), ConnectionOrder.FIRST, i, tUserInfo);
    }

    public final void mo641b(int i, TUserInfo tUserInfo) {
        Preconditions.checkState(this.f7926q);
        this.f7915f.a();
        mo638a(this.f7919j.mo651a().mo624c(), ConnectionOrder.FIRST, i, tUserInfo);
    }

    public final void mo638a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, int i, TUserInfo tUserInfo) {
        Preconditions.checkState(this.f7926q);
        this.f7915f.a();
        m8220b(this, connectionLocation, connectionOrder, i, tUserInfo);
    }

    public static void m8220b(ConnectionControllerImpl connectionControllerImpl, ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, int i, Object obj) {
        if (!connectionControllerImpl.f7925p.m8239a(connectionLocation, connectionOrder, i, obj)) {
            LocationType locationType = connectionLocation.f7943c;
            String str = connectionLocation.f7942b;
            if (connectionLocation.f7943c == LocationType.INITIAL || connectionLocation.f7942b != null) {
                ConnectionFetchOperation a = connectionControllerImpl.m8215a(connectionLocation, connectionOrder, i);
                if (connectionControllerImpl.m8218a(a)) {
                    if (connectionControllerImpl.f7915f.c()) {
                        connectionControllerImpl.f7918i.mo627a(connectionLocation, connectionOrder);
                    } else {
                        HandlerDetour.a(connectionControllerImpl.f7912c, new 3(connectionControllerImpl, connectionLocation, connectionOrder), 1562315638);
                    }
                    GraphQLRequest a2 = connectionControllerImpl.m8216a(connectionControllerImpl.f7917h.mo647a(a, obj));
                    if (connectionControllerImpl.f7922m != null) {
                        GraphQLCachePolicy graphQLCachePolicy = connectionControllerImpl.f7922m.c;
                        if (graphQLCachePolicy != null) {
                            a2.a(graphQLCachePolicy);
                        }
                        long a3 = connectionControllerImpl.f7922m.a();
                        if (a3 > 0) {
                            a2.a(a3);
                        }
                    }
                    if (connectionControllerImpl.f7923n) {
                        a2.b = true;
                    }
                    if (connectionControllerImpl.f7924o != null) {
                        a2.e = ImmutableSet.of(connectionControllerImpl.f7924o);
                    }
                    2 2 = new 2(connectionControllerImpl, connectionLocation, connectionOrder, a);
                    GraphQLQueryFuture a4 = connectionControllerImpl.f7913d.a(a2);
                    connectionControllerImpl.f7910a.put(a, FutureAndCallbackHolder.a(a4, 2));
                    Futures.a(a4, 2, DirectExecutor.INSTANCE);
                    return;
                }
                return;
            }
            BLog.b(ConnectionControllerImpl.class, "Declining to fetch %s with null cursor", new Object[]{connectionLocation.f7943c});
        }
    }

    public final void mo640b() {
        Preconditions.checkState(this.f7926q);
        this.f7915f.a();
        for (Entry entry : this.f7910a.entrySet()) {
            entry.getKey();
            ((FutureAndCallbackHolder) entry.getValue()).a(false);
        }
        this.f7910a.clear();
        this.f7919j.mo659b(this.f7911b);
        this.f7919j.mo660c();
    }

    public final void mo643c() {
        if (this.f7924o != null) {
            this.f7914e.a(ImmutableSet.of(this.f7924o));
        }
        this.f7919j.mo661d();
    }

    public final void mo637a(ConnectionListener<TEdge> connectionListener) {
        this.f7918i.m8246a(connectionListener);
    }

    public final void mo642b(ConnectionListener<TEdge> connectionListener) {
        this.f7918i.m8250b(connectionListener);
    }

    public final ConnectionState<TEdge> mo644d() {
        Preconditions.checkState(this.f7926q);
        return this.f7919j.mo651a();
    }

    public final void mo639a(String str, Predicate<TEdge> predicate) {
        Preconditions.checkState(this.f7926q);
        this.f7919j.mo655a(str, (Predicate) predicate);
    }

    public final MutationControllerManager mo645e() {
        return this.f7920k;
    }

    private ConnectionFetchOperation m8215a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, int i) {
        switch (4.a[connectionLocation.f7943c.ordinal()]) {
            case 1:
                return new ConnectionFetchOperation(connectionLocation, connectionOrder, null, null, i, null);
            case 2:
                return new ConnectionFetchOperation(connectionLocation, connectionOrder, connectionLocation.m8260a(), m8217a(connectionLocation), i, null);
            case 3:
                return new ConnectionFetchOperation(connectionLocation, connectionOrder, m8219b(connectionLocation), connectionLocation.m8260a(), i, null);
            default:
                throw new RuntimeException("Unsupported location type: " + connectionLocation.m8261b());
        }
    }

    private String m8217a(ConnectionLocation connectionLocation) {
        boolean z;
        int i = 0;
        if (connectionLocation.f7943c == LocationType.BEFORE) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkNotNull(connectionLocation.f7942b);
        ImmutableList e = mo644d().mo626e();
        String str = connectionLocation.f7942b;
        while (i < e.size()) {
            if (str.equals(((ConnectionChunk) e.get(i)).a.f7942b)) {
                break;
            }
            i++;
        }
        i = -1;
        if (i == -1) {
            throw new RuntimeException("Location not found: " + str);
        } else if (i == 0) {
            return null;
        } else {
            return ((ConnectionChunk) e.get(i - 1)).b.f7942b;
        }
    }

    private String m8219b(ConnectionLocation connectionLocation) {
        boolean z;
        int i = 0;
        if (connectionLocation.f7943c == LocationType.AFTER) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkNotNull(connectionLocation.f7942b);
        ImmutableList e = mo644d().mo626e();
        String str = connectionLocation.f7942b;
        while (i < e.size()) {
            if (str.equals(((ConnectionChunk) e.get(i)).b.f7942b)) {
                break;
            }
            i++;
        }
        i = -1;
        if (i == -1) {
            throw new RuntimeException("Location not found: " + str);
        } else if (i + 1 >= e.size()) {
            return null;
        } else {
            return ((ConnectionChunk) e.get(i + 1)).a.f7942b;
        }
    }

    private GraphQLRequest<TResponseModel> m8216a(TypedGraphQlQueryString<TRequestModel> typedGraphQlQueryString) {
        if (this.f7917h instanceof GroupsConnectionConfiguration) {
            GroupsConnectionConfiguration groupsConnectionConfiguration = (GroupsConnectionConfiguration) this.f7917h;
            return GraphQLRequest.a(typedGraphQlQueryString, GraphQLFeedHomeStories.class, 2);
        } else if (this.f7917h instanceof SimpleConnectionConfiguration) {
            return GraphQLRequest.a(typedGraphQlQueryString);
        } else {
            throw new IllegalArgumentException("Configuration must be LegacyConnectionConfiguration or SimpleConnectionConfiguration");
        }
    }

    private boolean m8218a(ConnectionFetchOperation connectionFetchOperation) {
        for (ConnectionFetchOperation connectionFetchOperation2 : this.f7910a.keySet()) {
            if (Objects.equal(connectionFetchOperation.c, connectionFetchOperation2.c) && Objects.equal(connectionFetchOperation.d, connectionFetchOperation2.d)) {
                Objects.equal(connectionFetchOperation.b, connectionFetchOperation2.b);
                return false;
            }
        }
        return true;
    }
}
