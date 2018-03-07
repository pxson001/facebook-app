package com.facebook.controller.connectioncontroller.diskstore;

import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.common.time.Clock;
import com.facebook.controller.connectioncontroller.common.ConnectionCacheRetainingPolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation.LocationType;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionPage;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.common.ConnectionStore;
import com.facebook.controller.connectioncontroller.common.ConnectionStore.ConnectionStoreListener;
import com.facebook.controller.connectioncontroller.common.ConnectionStoreListenerAnnouncer;
import com.facebook.controller.connectioncontroller.common.EmptyConnectionState;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManager;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManager.LoaderCallbacks;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManagerProvider;
import com.facebook.graphql.cursor.ModelCursor;
import com.facebook.graphql.cursor.ModelCursorLoader;
import com.facebook.graphql.cursor.ModelCursorLoaderProvider;
import com.facebook.graphql.cursor.SessionIdFormatter;
import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import com.facebook.graphql.cursor.database.PageInfo;
import com.facebook.graphql.cursor.database.SortKeyHelper;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.inject.Assisted;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.RegularImmutableSet;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: metaline_3 */
public class DiskConnectionStore<TEdge> implements ConnectionStore<TEdge> {
    private final LoaderCallbacks f7835a = new C03831(this);
    private final AtomicInteger f7836b = new AtomicInteger(1);
    public final String f7837c;
    public final ConnectionCacheRetainingPolicy f7838d;
    @Nullable
    private final Function<TEdge, String> f7839e;
    public final ConnectionStoreListenerAnnouncer<TEdge> f7840f;
    public final DefaultAndroidThreadUtil f7841g;
    private final Executor f7842h;
    public final Executor f7843i;
    public final DefaultProcessIdleExecutor f7844j;
    public final GraphCursorDatabase f7845k;
    public final ModelCursorLoader f7846l;
    private final LocalModelCursorLoaderManager f7847m;
    public final QuickPerformanceLogger f7848n;
    public final Clock f7849o;
    private final AbstractFbErrorReporter f7850p;
    public final LruCache<Long, TEdge> f7851q;
    public volatile boolean f7852r;
    public ConnectionState<TEdge> f7853s = EmptyConnectionState.f7635a;

    /* compiled from: metaline_3 */
    class C03831 implements LoaderCallbacks {
        final /* synthetic */ DiskConnectionStore f7895a;

        C03831(DiskConnectionStore diskConnectionStore) {
            this.f7895a = diskConnectionStore;
        }

        public final void mo662a(@Nullable ModelCursor modelCursor) {
            this.f7895a.f7841g.a();
            if (modelCursor != null) {
                if (this.f7895a.f7852r) {
                    modelCursor.close();
                } else if (!(this.f7895a.f7853s instanceof CursorConnectionState) || ((CursorConnectionState) this.f7895a.f7853s).f8149a.isClosed()) {
                    modelCursor.close();
                } else {
                    CursorConnectionState cursorConnectionState = new CursorConnectionState(modelCursor, this.f7895a.f7851q, this.f7895a.f7844j);
                    ConnectionState a = DiskConnectionStore.m8090a(this.f7895a, (ConnectionState) cursorConnectionState);
                    DiskConnectionStore.m8091a(this.f7895a, a, cursorConnectionState, modelCursor.getExtras());
                    DiskConnectionStore.m8094b(this.f7895a, a);
                }
            }
        }
    }

    @Inject
    public DiskConnectionStore(@Assisted String str, @Assisted ConnectionCacheRetainingPolicy connectionCacheRetainingPolicy, @Nullable @Assisted Function<TEdge, String> function, @Assisted int i, AndroidThreadUtil androidThreadUtil, Executor executor, Executor executor2, IdleExecutor idleExecutor, GraphCursorDatabase graphCursorDatabase, ModelCursorLoaderProvider modelCursorLoaderProvider, LocalModelCursorLoaderManagerProvider localModelCursorLoaderManagerProvider, QuickPerformanceLogger quickPerformanceLogger, Clock clock, FbErrorReporter fbErrorReporter) {
        this.f7837c = SessionIdFormatter.m8195a(str);
        this.f7838d = connectionCacheRetainingPolicy;
        this.f7839e = function;
        this.f7841g = androidThreadUtil;
        this.f7845k = graphCursorDatabase;
        this.f7846l = modelCursorLoaderProvider.m8191a(this.f7837c);
        this.f7847m = localModelCursorLoaderManagerProvider.m8192a(this.f7837c, this.f7835a);
        this.f7842h = executor;
        this.f7843i = executor2;
        this.f7844j = idleExecutor;
        this.f7848n = quickPerformanceLogger;
        this.f7849o = clock;
        this.f7850p = fbErrorReporter;
        this.f7840f = new ConnectionStoreListenerAnnouncer();
        this.f7851q = i > 0 ? new LruCache(i) : null;
    }

    public final void mo654a(ConnectionStoreListener<TEdge> connectionStoreListener) {
        this.f7840f.m8205a(connectionStoreListener);
    }

    public final void mo659b(ConnectionStoreListener<TEdge> connectionStoreListener) {
        this.f7840f.m8208b(connectionStoreListener);
    }

    public final synchronized ConnectionState<TEdge> mo651a() {
        return this.f7853s;
    }

    public final synchronized void mo653a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, ConnectionPage<TEdge> connectionPage, long j, boolean z) {
        boolean z2;
        ImmutableList of;
        Bundle a;
        this.f7841g.b();
        int andIncrement = this.f7836b.getAndIncrement();
        this.f7848n.e(9568257, andIncrement);
        this.f7848n.b(9568257, andIncrement, this.f7837c);
        LocationType b = connectionLocation.m8261b();
        if (b == LocationType.INITIAL || this.f7852r) {
            z2 = true;
        } else {
            z2 = false;
        }
        String a2 = ConnectionStatePageHelper.a(connectionLocation, j);
        if (connectionPage.f()) {
            of = ImmutableList.of();
        } else {
            boolean z3;
            boolean e;
            if (TextUtils.isEmpty(connectionPage.b()) && TextUtils.isEmpty(connectionPage.c())) {
                this.f7850p.b("ConnectionController", new RuntimeException("Both start and end cursor are empty"));
            }
            if (LocationType.INITIAL == b) {
                z3 = true;
                e = connectionPage.e();
            } else if (ConnectionOrder.FIRST == connectionOrder) {
                z3 = false;
                e = connectionPage.e();
            } else if (ConnectionOrder.LAST == connectionOrder) {
                z3 = connectionPage.d();
                e = false;
            } else {
                throw new IllegalArgumentException("Unsupported Order:" + connectionOrder.name());
            }
            connectionLocation.m8261b();
            connectionLocation.m8260a();
            if (connectionLocation instanceof DiskConnectionLocation) {
                ((DiskConnectionLocation) connectionLocation).d();
            }
            of = ImmutableList.of(new PageInfo(SortKeyHelper.d(a2), SortKeyHelper.e(a2), connectionPage.b(), connectionPage.c(), z3, e, connectionPage.a().size()));
        }
        Builder builder = new Builder();
        if (this.f7839e != null) {
            ImmutableList a3 = connectionPage.a();
            int size = a3.size();
            for (int i = 0; i < size; i++) {
                String str = (String) this.f7839e.apply(a3.get(i));
                if (str != null) {
                    builder.c(ConnectionPageRowMapper.a(str));
                }
            }
        }
        this.f7848n.a(9568257, andIncrement, (short) 23);
        ByteBuffer a4 = ConnectionPageRowMapper.a(connectionPage.a());
        if (a4 != null) {
            a = this.f7845k.m8161a(this.f7837c, a4, new ConnectionPageRowMapper(connectionPage, a2, this.f7839e), of, builder.b(), z2);
        } else {
            a = this.f7845k.m8159a(this.f7837c, new ConnectionPageRowIterator(connectionPage, a2, this.f7839e), of, builder.b(), z2);
        }
        if (this.f7852r) {
            this.f7852r = false;
        }
        this.f7848n.a(9568257, andIncrement, (short) 30);
        CursorConnectionState cursorConnectionState = new CursorConnectionState((ModelCursor) this.f7846l.m8197a(), this.f7851q, this.f7844j);
        m8092a(connectionPage.a(), a.getLongArray("INSERTED_ROW_IDS"));
        this.f7848n.a(9568257, andIncrement, (short) 26);
        int i2 = 0;
        if (connectionLocation.m8261b() == LocationType.AFTER) {
            i2 = this.f7853s.mo625d();
        }
        ExecutorDetour.a(this.f7843i, new 2(this, andIncrement, cursorConnectionState, z2, i2, connectionPage, z, a, connectionLocation, connectionOrder), 1122131967);
    }

    private void m8092a(ImmutableList<TEdge> immutableList, long[] jArr) {
        if (this.f7851q != null) {
            for (int i = 0; i < immutableList.size(); i++) {
                this.f7851q.a(Long.valueOf(jArr[i]), immutableList.get(i));
            }
        }
    }

    public final ImmutableSet<TEdge> mo652a(String str) {
        if (this.f7853s != null || (this.f7853s instanceof CursorConnectionState)) {
            return ((CursorConnectionState) this.f7853s).f8151c.m8423a(str);
        }
        return RegularImmutableSet.a;
    }

    public final boolean mo657a(TEdge tEdge, TEdge tEdge2) {
        throw new UnsupportedOperationException("replaceEdge not implemented yet.");
    }

    public final boolean mo656a(GraphQLPersistableNode graphQLPersistableNode) {
        if (this.f7853s == null && !(this.f7853s instanceof CursorConnectionState)) {
            return false;
        }
        if (graphQLPersistableNode.a() == null) {
            throw new RuntimeException("Could not replace subnode since primaryKey is null");
        }
        ExecutorDetour.a(this.f7842h, new 3(this, graphQLPersistableNode), 1640216046);
        return true;
    }

    public final void mo655a(String str, Predicate<TEdge> predicate) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(predicate);
        ExecutorDetour.a(this.f7842h, new 4(this, str, predicate), 1587901185);
    }

    public final void mo658b() {
        final int andIncrement = this.f7836b.getAndIncrement();
        this.f7848n.e(9568258, andIncrement);
        ExecutorDetour.a(this.f7842h, new Runnable(this) {
            final /* synthetic */ DiskConnectionStore f7935b;

            public void run() {
                CursorConnectionState cursorConnectionState = new CursorConnectionState((ModelCursor) this.f7935b.f7846l.m8197a(), this.f7935b.f7851q, this.f7935b.f7844j);
                DiskConnectionStore diskConnectionStore = this.f7935b;
                Object obj = 1;
                if (diskConnectionStore.f7838d == null || diskConnectionStore.f7838d.b < 0) {
                    obj = null;
                } else if (diskConnectionStore.f7838d.b != 0 && cursorConnectionState.m8419g() + (diskConnectionStore.f7838d.b * 1000) >= diskConnectionStore.f7849o.a()) {
                    obj = null;
                }
                if (obj != null) {
                    ExecutorDetour.a(this.f7935b.f7843i, new 1(this, cursorConnectionState), 525033423);
                    ConnectionState connectionState = EmptyConnectionState.f7635a;
                    this.f7935b.f7852r = true;
                } else {
                    Object obj2 = cursorConnectionState;
                }
                if (connectionState.mo625d() == 0) {
                    this.f7935b.f7848n.b(9568258, andIncrement, (short) 2);
                    this.f7935b.f7840f.mo667b();
                    return;
                }
                ExecutorDetour.a(this.f7935b.f7843i, new 2(this, connectionState), 812903185);
            }
        }, 538814888);
    }

    public static void m8091a(DiskConnectionStore diskConnectionStore, ConnectionState connectionState, CursorConnectionState cursorConnectionState, Bundle bundle) {
        diskConnectionStore.m8093a("Update", bundle.getLongArray("CHANGED_ROW_IDS"), cursorConnectionState.m8418f(), new 8(diskConnectionStore, connectionState));
        long[] longArray = bundle.getLongArray("DELETED_ROW_IDS");
        if (connectionState instanceof CursorConnectionState) {
            diskConnectionStore.m8093a("Delete", longArray, ((CursorConnectionState) connectionState).m8418f(), new 9(diskConnectionStore, connectionState));
        }
    }

    private void m8093a(String str, long[] jArr, ModelCursor modelCursor, Function<Integer, Void> function) {
        int i = 0;
        if (jArr != null && jArr.length > 0) {
            int i2;
            int binarySearch;
            Arrays.sort(jArr);
            Arrays.toString(jArr);
            if (this.f7851q != null) {
                for (long valueOf : jArr) {
                    this.f7851q.b(Long.valueOf(valueOf));
                }
            }
            if (modelCursor.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                i2 = 0;
                do {
                    binarySearch = Arrays.binarySearch(jArr, modelCursor.m8326b());
                    binarySearch = (binarySearch < 0 || binarySearch >= jArr.length) ? 0 : 1;
                    if (binarySearch != 0) {
                        i2++;
                        binarySearch = modelCursor.getPosition();
                        Integer.valueOf(binarySearch);
                        arrayList.add(Integer.valueOf(binarySearch));
                    }
                    if (i2 >= jArr.length) {
                        break;
                    }
                } while (modelCursor.moveToNext());
                if (str.equals("Delete")) {
                    Collections.sort(arrayList, Collections.reverseOrder());
                }
                binarySearch = arrayList.size();
                while (i < binarySearch) {
                    function.apply((Integer) arrayList.get(i));
                    i++;
                }
            }
        }
    }

    public final void mo660c() {
        this.f7841g.a();
        this.f7847m.close();
        m8094b(this, this.f7853s);
        this.f7853s = EmptyConnectionState.f7635a;
        if (this.f7851q != null) {
            this.f7851q.a();
        }
    }

    public final void mo661d() {
        ExecutorDetour.a(this.f7842h, new 10(this), -981624765);
    }

    public static synchronized ConnectionState m8090a(DiskConnectionStore diskConnectionStore, ConnectionState connectionState) {
        ConnectionState connectionState2;
        synchronized (diskConnectionStore) {
            diskConnectionStore.f7841g.a();
            connectionState2 = diskConnectionStore.f7853s;
            diskConnectionStore.f7853s = connectionState;
        }
        return connectionState2;
    }

    public static void m8094b(DiskConnectionStore diskConnectionStore, ConnectionState connectionState) {
        diskConnectionStore.f7841g.a();
        if (connectionState instanceof CursorConnectionState) {
            ((CursorConnectionState) connectionState).close();
        }
    }
}
