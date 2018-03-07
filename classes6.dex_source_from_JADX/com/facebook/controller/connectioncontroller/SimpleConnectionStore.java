package com.facebook.controller.connectioncontroller;

import com.facebook.controller.connectioncontroller.common.AbstractConnectionState;
import com.facebook.controller.connectioncontroller.common.ConnectionChunk;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation.LocationType;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionPage;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.common.ConnectionStore;
import com.facebook.controller.connectioncontroller.common.ConnectionStore.ConnectionStoreListener;
import com.facebook.controller.connectioncontroller.common.ConnectionStoreListenerAnnouncer;
import com.facebook.controller.connectioncontroller.common.EmptyConnectionState;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.Assisted;
import com.facebook.inject.IdBasedProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: otherBubbleColor */
public class SimpleConnectionStore<TEdge> implements ConnectionStore<TEdge> {
    private final List<TEdge> f8574a = new ArrayList();
    private final TagTracker<TEdge> f8575b;
    public final ConnectionStoreListenerAnnouncer<TEdge> f8576c = new ConnectionStoreListenerAnnouncer();
    private final ConsistencySubscriber<TEdge> f8577d;
    private final Executor f8578e;
    private String f8579f;
    private String f8580g;
    private boolean f8581h;
    private boolean f8582i;
    private ConnectionState<TEdge> f8583j = m12374e();

    /* compiled from: otherBubbleColor */
    /* synthetic */ class C05644 {
        static final /* synthetic */ int[] f8563a = new int[LocationType.values().length];

        static {
            try {
                f8563a[LocationType.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8563a[LocationType.BEFORE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8563a[LocationType.AFTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: otherBubbleColor */
    public class ConsistencySubscriber<TEdge> {
        private final Provider<GraphQLSubscriptionHolder> f8567a;
        private final HashMap<TEdge, GraphQLSubscriptionHolder> f8568b = new HashMap();
        public final ConnectionStore<TEdge> f8569c;

        /* compiled from: otherBubbleColor */
        class C05651 implements ConnectionStoreListener<TEdge> {
            final /* synthetic */ ConsistencySubscriber f8564a;

            C05651(ConsistencySubscriber consistencySubscriber) {
                this.f8564a = consistencySubscriber;
            }

            public final void m12354a(int i, int i2, ConnectionState<TEdge> connectionState, boolean z) {
                for (int i3 = 0; i3 < i2; i3++) {
                    ConsistencySubscriber.m12358a(this.f8564a, this.f8564a.f8569c.a().a(i3 + i));
                }
            }

            public final void m12353a(int i, int i2, ConnectionState<TEdge> connectionState) {
                for (int i3 = 0; i3 < i2; i3++) {
                    ConsistencySubscriber.m12359b(this.f8564a, connectionState.a(i3 + i));
                    ConsistencySubscriber.m12358a(this.f8564a, this.f8564a.f8569c.a().a(i3 + i));
                }
            }

            public final void m12357b(int i, int i2, ConnectionState<TEdge> connectionState) {
                for (int i3 = 0; i3 < i2; i3++) {
                    ConsistencySubscriber.m12359b(this.f8564a, connectionState.a(i3 + i));
                }
            }

            public final void m12352a() {
                this.f8564a.m12360a();
            }

            public final void m12355a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            }

            public final void m12356b() {
            }
        }

        @Inject
        public ConsistencySubscriber(@Assisted ConnectionStore<TEdge> connectionStore, Provider<GraphQLSubscriptionHolder> provider) {
            this.f8569c = connectionStore;
            this.f8567a = provider;
            connectionStore.a(new C05651(this));
        }

        public static synchronized void m12358a(ConsistencySubscriber consistencySubscriber, final Object obj) {
            synchronized (consistencySubscriber) {
                if (obj instanceof GraphQLVisitableModel) {
                    if (consistencySubscriber.f8568b.get(obj) == null) {
                        GraphQLSubscriptionHolder graphQLSubscriptionHolder = (GraphQLSubscriptionHolder) consistencySubscriber.f8567a.get();
                        graphQLSubscriptionHolder.a(new FutureCallback<GraphQLResult<TEdge>>(consistencySubscriber) {
                            final /* synthetic */ ConsistencySubscriber f8566b;

                            public void onSuccess(Object obj) {
                                Object obj2 = ((GraphQLResult) obj).e;
                                if (obj2 != null) {
                                    this.f8566b.f8569c.a(obj, obj2);
                                }
                            }

                            public void onFailure(Throwable th) {
                            }
                        }, "", graphQLSubscriptionHolder.a((GraphQLVisitableModel) obj, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, 0, TagFinder.m12388a((GraphQLVisitableModel) obj)));
                        consistencySubscriber.f8568b.put(obj, graphQLSubscriptionHolder);
                    }
                } else {
                    throw new RuntimeException("Consistency resolution works only with GraphQLVisitableModel");
                }
            }
        }

        public static synchronized void m12359b(ConsistencySubscriber consistencySubscriber, Object obj) {
            synchronized (consistencySubscriber) {
                GraphQLSubscriptionHolder graphQLSubscriptionHolder = (GraphQLSubscriptionHolder) consistencySubscriber.f8568b.remove(obj);
                if (graphQLSubscriptionHolder != null) {
                    graphQLSubscriptionHolder.a();
                }
            }
        }

        final synchronized void m12360a() {
            for (GraphQLSubscriptionHolder a : this.f8568b.values()) {
                a.a();
            }
            this.f8568b.clear();
        }
    }

    /* compiled from: otherBubbleColor */
    class TagTracker<TEdge> {
        @GuardedBy("this")
        private final HashMultimap<String, TEdge> f8571a = HashMultimap.u();
        @GuardedBy("this")
        private final HashMultimap<TEdge, String> f8572b = HashMultimap.u();
        public final ConnectionStore<TEdge> f8573c;

        /* compiled from: otherBubbleColor */
        class C05671 implements ConnectionStoreListener<TEdge> {
            final /* synthetic */ TagTracker f8570a;

            C05671(TagTracker tagTracker) {
                this.f8570a = tagTracker;
            }

            public final void m12363a(int i, int i2, ConnectionState<TEdge> connectionState, boolean z) {
                for (int i3 = 0; i3 < i2; i3++) {
                    this.f8570a.m12369a(this.f8570a.f8573c.a().a(i3 + i));
                }
            }

            public final void m12362a(int i, int i2, ConnectionState<TEdge> connectionState) {
                for (int i3 = 0; i3 < i2; i3++) {
                    this.f8570a.m12371b(connectionState.a(i3 + i));
                    this.f8570a.m12369a(this.f8570a.f8573c.a().a(i3 + i));
                }
            }

            public final void m12366b(int i, int i2, ConnectionState<TEdge> connectionState) {
                for (int i3 = 0; i3 < i2; i3++) {
                    this.f8570a.m12371b(connectionState.a(i3 + i));
                }
            }

            public final void m12361a() {
                TagTracker.m12367a(this.f8570a);
            }

            public final void m12364a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            }

            public final void m12365b() {
            }
        }

        public TagTracker(ConnectionStore<TEdge> connectionStore) {
            this.f8573c = connectionStore;
            connectionStore.a(new C05671(this));
        }

        public static synchronized void m12367a(TagTracker tagTracker) {
            synchronized (tagTracker) {
                tagTracker.f8571a.g();
                tagTracker.f8572b.g();
            }
        }

        final synchronized ImmutableSet<TEdge> m12372a(String str) {
            ImmutableSet<TEdge> of;
            Collection a = this.f8571a.a(str);
            if (a == null) {
                of = ImmutableSet.of();
            } else {
                of = ImmutableSet.copyOf(a);
            }
            return of;
        }

        private synchronized void m12369a(TEdge tEdge) {
            if (tEdge instanceof GraphQLVisitableModel) {
                ImmutableSet a = TagFinder.m12388a((GraphQLVisitableModel) tEdge);
                if (a != null) {
                    this.f8572b.a(tEdge, a);
                    Iterator it = a.iterator();
                    while (it.hasNext()) {
                        this.f8571a.a((String) it.next(), tEdge);
                    }
                }
            }
        }

        private synchronized void m12371b(TEdge tEdge) {
            if (tEdge instanceof GraphQLVisitableModel) {
                Set a = this.f8572b.a(tEdge);
                if (a != null) {
                    Iterator it = a.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        it.remove();
                        this.f8571a.c(str, tEdge);
                    }
                }
            }
        }
    }

    @Inject
    public SimpleConnectionStore(@Assisted boolean z, @Assisted boolean z2, SimpleConnectionStore_ConsistencySubscriberProvider simpleConnectionStore_ConsistencySubscriberProvider, Executor executor) {
        if (z) {
            this.f8577d = new ConsistencySubscriber(this, IdBasedProvider.a(simpleConnectionStore_ConsistencySubscriberProvider, 2169));
        } else {
            this.f8577d = null;
        }
        this.f8578e = executor;
        if (z2) {
            this.f8575b = new TagTracker(this);
        } else {
            this.f8575b = null;
        }
    }

    public final void m12378a(ConnectionStoreListener<TEdge> connectionStoreListener) {
        this.f8576c.a(connectionStoreListener);
    }

    public final void m12383b(ConnectionStoreListener<TEdge> connectionStoreListener) {
        this.f8576c.b(connectionStoreListener);
    }

    public final ConnectionState<TEdge> m12375a() {
        return this.f8583j;
    }

    public final synchronized void m12377a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, ConnectionPage<TEdge> connectionPage, long j, boolean z) {
        LocationType b = connectionLocation.b();
        int i = 0;
        boolean isEmpty = this.f8574a.isEmpty();
        Object obj = null;
        switch (C05644.f8563a[b.ordinal()]) {
            case 1:
                this.f8574a.clear();
                obj = 1;
                this.f8574a.addAll(connectionPage.m12401a());
                this.f8579f = connectionPage.m12402b();
                this.f8580g = connectionPage.m12403c();
                this.f8581h = connectionPage.m12404d();
                this.f8582i = connectionPage.m12405e();
                break;
            case 2:
                Preconditions.checkState(!this.f8574a.isEmpty());
                if (!connectionPage.m12405e()) {
                    this.f8574a.addAll(0, connectionPage.m12401a());
                    if (connectionPage.m12402b() != null) {
                        this.f8579f = connectionPage.m12402b();
                    }
                    this.f8581h = connectionPage.m12404d();
                    break;
                }
                this.f8574a.clear();
                obj = 1;
                this.f8574a.addAll(connectionPage.m12401a());
                this.f8579f = connectionPage.m12402b();
                this.f8580g = connectionPage.m12403c();
                this.f8581h = connectionPage.m12404d();
                this.f8582i = connectionPage.m12405e();
                break;
            case 3:
                Preconditions.checkState(!this.f8574a.isEmpty());
                i = this.f8574a.size();
                this.f8574a.addAll(connectionPage.m12401a());
                this.f8580g = connectionPage.m12403c();
                this.f8582i = connectionPage.m12405e();
                break;
            default:
                throw new RuntimeException("Not supported Location:" + b.name());
        }
        final ConnectionState connectionState = this.f8583j;
        this.f8583j = m12374e();
        isEmpty = (isEmpty || obj == null) ? false : true;
        final ConnectionPage<TEdge> connectionPage2 = connectionPage;
        final boolean z2 = z;
        final ConnectionLocation connectionLocation2 = connectionLocation;
        final ConnectionOrder connectionOrder2 = connectionOrder;
        ExecutorDetour.a(this.f8578e, new Runnable(this) {
            final /* synthetic */ SimpleConnectionStore f8557h;

            public void run() {
                if (isEmpty) {
                    this.f8557h.f8576c.a();
                }
                this.f8557h.f8576c.a(i, connectionPage2.f8599b.size(), connectionState, z2);
                this.f8557h.f8576c.a(connectionLocation2, connectionOrder2);
            }
        }, -407482601);
    }

    public final ImmutableSet<TEdge> m12376a(String str) {
        if (this.f8575b != null) {
            return this.f8575b.m12372a(str);
        }
        throw new RuntimeException("Tag tracking is not turned on");
    }

    public final synchronized boolean m12381a(TEdge tEdge, TEdge tEdge2) {
        boolean z = true;
        synchronized (this) {
            int indexOf = this.f8574a.indexOf(tEdge);
            if (indexOf >= 0) {
                this.f8574a.set(indexOf, tEdge2);
                if (this.f8575b != null) {
                    this.f8575b.m12371b(tEdge);
                    this.f8575b.m12369a((Object) tEdge2);
                }
                ConnectionState connectionState = this.f8583j;
                this.f8583j = m12374e();
                this.f8576c.a(indexOf, 1, connectionState);
            } else {
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean m12380a(GraphQLPersistableNode graphQLPersistableNode) {
        boolean z;
        String a = graphQLPersistableNode.a();
        if (a == null) {
            throw new RuntimeException("Could not replace subnode since primaryKey is null");
        }
        z = false;
        Iterator it = this.f8575b.m12372a(a).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Object a2 = m12373a(next, graphQLPersistableNode);
            if (a2 != next) {
                m12381a(next, a2);
                z = true;
            }
        }
        return z;
    }

    public final void m12379a(String str, Predicate<TEdge> predicate) {
        if (this.f8575b != null) {
            Iterator it = this.f8575b.m12372a(str).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (predicate.apply(next)) {
                    int indexOf = this.f8574a.indexOf(next);
                    if (indexOf >= 0) {
                        this.f8574a.remove(indexOf);
                        this.f8575b.m12371b(next);
                        ConnectionState connectionState = this.f8583j;
                        this.f8583j = m12374e();
                        this.f8576c.b(indexOf, 1, connectionState);
                    }
                }
            }
            return;
        }
        throw new RuntimeException("Not supported without TagTracker enabled");
    }

    private TEdge m12373a(TEdge tEdge, final GraphQLPersistableNode graphQLPersistableNode) {
        if (tEdge instanceof GraphQLVisitableModel) {
            return new RecursiveModelTransformer(GraphQLPersistableNode.class, new TypedModelVisitor<GraphQLPersistableNode>(this) {
                final /* synthetic */ SimpleConnectionStore f8559b;

                @Nullable
                public final Object m12348a(@Nullable Object obj) {
                    GraphQLPersistableNode graphQLPersistableNode = (GraphQLPersistableNode) obj;
                    if (graphQLPersistableNode != null && graphQLPersistableNode.a().equals(graphQLPersistableNode.a()) && graphQLPersistableNode.getClass() == graphQLPersistableNode.getClass()) {
                        return graphQLPersistableNode;
                    }
                    return graphQLPersistableNode;
                }
            }).a(tEdge);
        }
        throw new RuntimeException("Can only replace nodes in GraphQLVisitableModel");
    }

    public final void m12382b() {
        this.f8576c.b();
    }

    public final void m12384c() {
    }

    public final void m12385d() {
    }

    private ConnectionState<TEdge> m12374e() {
        if (this.f8574a.isEmpty()) {
            return EmptyConnectionState.a;
        }
        final ImmutableList copyOf = ImmutableList.copyOf(this.f8574a);
        final ImmutableList of = ImmutableList.of(new ConnectionChunk(new ConnectionLocation(this.f8579f, LocationType.BEFORE, this.f8581h), new ConnectionLocation(this.f8580g, LocationType.AFTER, this.f8582i)));
        return new AbstractConnectionState<TEdge>(this) {
            final /* synthetic */ SimpleConnectionStore f8562c;

            public final int m12350d() {
                return copyOf.size();
            }

            public final TEdge m12349a(int i) {
                return copyOf.get(i);
            }

            public final ImmutableList<ConnectionChunk> m12351e() {
                return of;
            }
        };
    }
}
