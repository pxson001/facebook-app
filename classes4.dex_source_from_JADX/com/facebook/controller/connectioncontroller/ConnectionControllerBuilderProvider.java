package com.facebook.controller.connectioncontroller;

import com.facebook.controller.connectioncontroller.common.ConnectionConfiguration;
import com.facebook.controller.connectioncontroller.diskstore.DiskConnectionStoreProvider;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: missing dex load information! */
public class ConnectionControllerBuilderProvider extends AbstractAssistedProvider<ConnectionControllerBuilder> {
    public final <TEdge, TUserInfo> ConnectionControllerBuilder<TEdge, TUserInfo> m7965a(String str, ConnectionConfiguration<TEdge, TUserInfo, ?, ?> connectionConfiguration) {
        return new ConnectionControllerBuilder(str, connectionConfiguration, (ConnectionControllerImplProvider) getOnDemandAssistedProviderForStaticDi(ConnectionControllerImplProvider.class), (DiskConnectionStoreProvider) getOnDemandAssistedProviderForStaticDi(DiskConnectionStoreProvider.class), (SimpleConnectionStoreProvider) getOnDemandAssistedProviderForStaticDi(SimpleConnectionStoreProvider.class));
    }
}
