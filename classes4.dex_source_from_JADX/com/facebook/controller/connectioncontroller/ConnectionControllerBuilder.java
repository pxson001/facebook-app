package com.facebook.controller.connectioncontroller;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.controller.connectioncontroller.common.ConnectionCachePolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionCacheRetainingPolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionConfiguration;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionInitialFetchPolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionStore;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.controller.connectioncontroller.diskstore.DiskConnectionStoreProvider;
import com.facebook.inject.Assisted;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: method/user.reportAppDeletionCallback */
public class ConnectionControllerBuilder<TEdge, TUserInfo> {
    private final String f7809a;
    private final ConnectionConfiguration<TEdge, TUserInfo, ?, ?> f7810b;
    private final ConnectionControllerImplProvider f7811c;
    private final DiskConnectionStoreProvider f7812d;
    private final SimpleConnectionStoreProvider f7813e;
    public ConnectionCachePolicy f7814f;
    public ConnectionInitialFetchPolicy f7815g = ConnectionInitialFetchPolicy.USE_CACHE_IF_AVAILABLE;
    public ConnectionCacheRetainingPolicy f7816h;
    public boolean f7817i;
    public MutationControllerManager f7818j;
    public Function<TEdge, String> f7819k;
    public int f7820l;

    @Inject
    public ConnectionControllerBuilder(@Assisted String str, @Assisted ConnectionConfiguration<TEdge, TUserInfo, ?, ?> connectionConfiguration, ConnectionControllerImplProvider connectionControllerImplProvider, DiskConnectionStoreProvider diskConnectionStoreProvider, SimpleConnectionStoreProvider simpleConnectionStoreProvider) {
        this.f7812d = diskConnectionStoreProvider;
        this.f7813e = simpleConnectionStoreProvider;
        this.f7809a = (String) Preconditions.checkNotNull(str);
        this.f7810b = (ConnectionConfiguration) Preconditions.checkNotNull(connectionConfiguration);
        this.f7811c = connectionControllerImplProvider;
    }

    public final ConnectionController<TEdge, TUserInfo> m8069a() {
        return m8068b(true);
    }

    public final ConnectionController<TEdge, TUserInfo> m8070b() {
        return m8068b(false);
    }

    private ConnectionController<TEdge, TUserInfo> m8068b(boolean z) {
        ConnectionStore a;
        String str = null;
        if (this.f7814f == ConnectionCachePolicy.MEMORY_DISK) {
            a = this.f7812d.m8074a(this.f7809a, this.f7816h, this.f7819k, this.f7820l);
        } else if (this.f7819k != null) {
            throw new UnsupportedOperationException("Deduplication isn't supported in the memory story, yet.");
        } else {
            boolean z2;
            SimpleConnectionStoreProvider simpleConnectionStoreProvider = this.f7813e;
            boolean z3 = this.f7817i;
            if (this.f7818j != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            a = new SimpleConnectionStore(z3, z2, (SimpleConnectionStore_ConsistencySubscriberProvider) simpleConnectionStoreProvider.getOnDemandAssistedProviderForStaticDi(SimpleConnectionStore_ConsistencySubscriberProvider.class), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(simpleConnectionStoreProvider));
            str = this.f7809a + "_CC_QUERY";
        }
        ConnectionController a2 = this.f7811c.m8071a(this.f7810b, a, this.f7818j, this.f7815g, this.f7816h, this.f7817i, str);
        if (z) {
            a2.mo635a();
        }
        return a2;
    }
}
