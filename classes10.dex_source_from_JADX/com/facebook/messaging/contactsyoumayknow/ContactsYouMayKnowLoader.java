package com.facebook.messaging.contactsyoumayknow;

import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.AbstractListenableFutureFbLoader;
import com.facebook.common.loader.AbstractListenableFutureFbLoader.LoaderResult;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowFetcher.C03501;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sync_broadcast_thread_passed_over */
public class ContactsYouMayKnowLoader extends AbstractListenableFutureFbLoader<Void, ContactsYouMayKnowData> {
    private final ContactsYouMayKnowFetcher f2118a;
    public final ContactsYouMayKnowCache f2119b;
    public final Clock f2120c;

    /* compiled from: sync_broadcast_thread_passed_over */
    class C03551 implements Function<ContactsYouMayKnowData, ContactsYouMayKnowData> {
        final /* synthetic */ ContactsYouMayKnowLoader f2117a;

        C03551(ContactsYouMayKnowLoader contactsYouMayKnowLoader) {
            this.f2117a = contactsYouMayKnowLoader;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            ContactsYouMayKnowData contactsYouMayKnowData = (ContactsYouMayKnowData) obj;
            if (contactsYouMayKnowData != null) {
                this.f2117a.f2119b.f2091a = contactsYouMayKnowData;
            }
            return contactsYouMayKnowData;
        }
    }

    private static ContactsYouMayKnowLoader m1931b(InjectorLike injectorLike) {
        return new ContactsYouMayKnowLoader((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), new ContactsYouMayKnowFetcher(GraphQLQueryExecutor.a(injectorLike), new ContactsYouMayKnowDataDeserializer((Clock) SystemClockMethodAutoProvider.a(injectorLike)), GraphQLCacheManager.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike)), ContactsYouMayKnowCache.m1906a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContactsYouMayKnowLoader(Executor executor, ContactsYouMayKnowFetcher contactsYouMayKnowFetcher, ContactsYouMayKnowCache contactsYouMayKnowCache, Clock clock) {
        super(executor);
        this.f2118a = contactsYouMayKnowFetcher;
        this.f2119b = contactsYouMayKnowCache;
        this.f2120c = clock;
    }

    protected final LoaderResult m1933b(Object obj) {
        ContactsYouMayKnowData contactsYouMayKnowData = this.f2119b.f2091a;
        if (contactsYouMayKnowData == null) {
            return AbstractListenableFutureFbLoader.a;
        }
        if ((this.f2120c.a() - contactsYouMayKnowData.f2095b > 7200000 ? 1 : null) != null) {
            return LoaderResult.a(contactsYouMayKnowData);
        }
        return LoaderResult.b(contactsYouMayKnowData);
    }

    protected final ListenableFuture m1932a(Object obj, LoaderResult loaderResult) {
        ContactsYouMayKnowFetcher contactsYouMayKnowFetcher = this.f2118a;
        return Futures.a(Futures.a(contactsYouMayKnowFetcher.f2099b.a(ContactsYouMayKnowFetcher.m1915b()), new C03501(contactsYouMayKnowFetcher)), new C03551(this));
    }
}
