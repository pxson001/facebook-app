package com.facebook.messaging.inbox2.data.loader;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.inbox2.data.common.InboxUnitFetcher;

/* compiled from: sessionInfo */
public class InboxUnitFetcherMethodAutoProvider extends AbstractProvider<InboxUnitFetcher> {
    public static InboxUnitFetcher m2715b(InjectorLike injectorLike) {
        return MessagingInbox2DataLoaderModule.m2739a(IdBasedProvider.a(injectorLike, 7882), IdBasedProvider.a(injectorLike, 7883), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public Object get() {
        return MessagingInbox2DataLoaderModule.m2739a(IdBasedProvider.a(this, 7882), IdBasedProvider.a(this, 7883), GatekeeperStoreImplMethodAutoProvider.a(this));
    }
}
