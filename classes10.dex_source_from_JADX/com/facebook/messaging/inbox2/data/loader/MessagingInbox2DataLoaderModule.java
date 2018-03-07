package com.facebook.messaging.inbox2.data.loader;

import com.facebook.gk.store.GatekeeperStore;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.inbox2.data.common.InboxUnitFetcher;
import com.facebook.messaging.inbox2.data.omnistore.InboxUnitFetcherWithOmnistore;
import com.facebook.messaging.inbox2.data.unitstore.InboxUnitFetcherWithUnitStore;
import javax.inject.Provider;

@InjectorModule
/* compiled from: server_received_msg_id */
public class MessagingInbox2DataLoaderModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    static InboxUnitFetcher m2739a(Provider<InboxUnitFetcherWithOmnistore> provider, Provider<InboxUnitFetcherWithUnitStore> provider2, GatekeeperStore gatekeeperStore) {
        if (gatekeeperStore.a(244, false)) {
            return (InboxUnitFetcher) provider.get();
        }
        return (InboxUnitFetcher) provider2.get();
    }
}
