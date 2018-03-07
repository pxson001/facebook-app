package com.facebook.messaging.sync.delta;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.cache.CacheFetchThreadsHandler;
import com.facebook.messaging.cache.CacheFetchThreadsHandler_FacebookMessagesMethodAutoProvider;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.FetchMessageParams;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.sync.connection.MessagesSyncLoggedInUserFetcher;
import com.facebook.messaging.sync.connection.MessagesSyncThreadsFetcher;
import com.facebook.messaging.sync.connection.MessagesSyncThreadsFetcher.FetchThreadsAndMessagesResult;
import com.facebook.messaging.sync.delta.handlerbase.AbstractMessagesDeltaHandler;
import com.facebook.messaging.sync.delta.handlerbase.MessagesDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.tempcache.UncommittedThreadModificationsCache;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaEnsuredDataFetcher;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;

@UserScoped
/* compiled from: profile_tile_items */
public class MessagesDeltaEnsuredDataFetcher implements DeltaEnsuredDataFetcher<PrefetchedSyncData, DeltaWrapper> {
    private static final Object f4359i = new Object();
    public final CacheFetchThreadsHandler f4360a;
    public final DbFetchThreadHandler f4361b;
    private final Lazy<MessagesSyncThreadsFetcher> f4362c;
    private final MessagesDeltaHandlerSupplier f4363d;
    private final MessageSyncAnalyticsLogger f4364e;
    private final UncommittedThreadModificationsCache f4365f;
    private final Lazy<MessagesSyncLoggedInUserFetcher> f4366g;
    @Inject
    @com.facebook.ultralight.Lazy
    @FacebookMessages
    public Lazy<CacheInsertThreadsHandler> f4367h = UltralightRuntime.b;

    private static MessagesDeltaEnsuredDataFetcher m3972b(InjectorLike injectorLike) {
        MessagesDeltaEnsuredDataFetcher messagesDeltaEnsuredDataFetcher = new MessagesDeltaEnsuredDataFetcher(CacheFetchThreadsHandler_FacebookMessagesMethodAutoProvider.a(injectorLike), DbFetchThreadHandler.a(injectorLike), IdBasedLazy.a(injectorLike, 8496), MessagesDeltaHandlerSupplier.m3974a(injectorLike), MessageSyncAnalyticsLogger.b(injectorLike), UncommittedThreadModificationsCache.m4224a(injectorLike), IdBasedLazy.a(injectorLike, 8494));
        messagesDeltaEnsuredDataFetcher.f4367h = IdBasedLazy.a(injectorLike, 7693);
        return messagesDeltaEnsuredDataFetcher;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.MessagesDeltaEnsuredDataFetcher m3969a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4359i;	 Catch:{ all -> 0x006c }
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
        r1 = m3972b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4359i;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.MessagesDeltaEnsuredDataFetcher) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.MessagesDeltaEnsuredDataFetcher) r0;	 Catch:{  }
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
        r0 = f4359i;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.MessagesDeltaEnsuredDataFetcher) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.MessagesDeltaEnsuredDataFetcher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.MessagesDeltaEnsuredDataFetcher");
    }

    @Inject
    public MessagesDeltaEnsuredDataFetcher(CacheFetchThreadsHandler cacheFetchThreadsHandler, DbFetchThreadHandler dbFetchThreadHandler, Lazy<MessagesSyncThreadsFetcher> lazy, MessagesDeltaHandlerSupplier messagesDeltaHandlerSupplier, MessageSyncAnalyticsLogger messageSyncAnalyticsLogger, UncommittedThreadModificationsCache uncommittedThreadModificationsCache, Lazy<MessagesSyncLoggedInUserFetcher> lazy2) {
        this.f4360a = cacheFetchThreadsHandler;
        this.f4361b = dbFetchThreadHandler;
        this.f4362c = lazy;
        this.f4363d = messagesDeltaHandlerSupplier;
        this.f4364e = messageSyncAnalyticsLogger;
        this.f4365f = uncommittedThreadModificationsCache;
        this.f4366g = lazy2;
    }

    public final Object m3973a(List list) {
        ImmutableSet immutableSet;
        ImmutableList immutableList;
        Map c = Maps.c();
        Set c2 = Sets.c();
        LinkedHashSet c3 = Sets.c();
        Object obj = null;
        Set set = c3;
        for (DeltaWithSequenceId deltaWithSequenceId : list) {
            AbstractMessagesDeltaHandler a = this.f4363d.m3976a((DeltaWrapper) deltaWithSequenceId.a);
            if (a.mo129d((DeltaWrapper) deltaWithSequenceId.a)) {
                obj = 1;
            }
            if (a.mo130e((DeltaWrapper) deltaWithSequenceId.a)) {
                c3 = m3970a(a, (DeltaWrapper) deltaWithSequenceId.a);
                c2.addAll(a.mo126a((DeltaWrapper) deltaWithSequenceId.a));
                set = c3;
            } else if (a.mo127b((DeltaWrapper) deltaWithSequenceId.a)) {
                m3971a(a.mo126a((DeltaWrapper) deltaWithSequenceId.a), c, c2);
            }
        }
        RegularImmutableSet regularImmutableSet = RegularImmutableSet.a;
        ImmutableList immutableList2 = RegularImmutableList.a;
        if (c2.isEmpty() && set.isEmpty()) {
            immutableSet = regularImmutableSet;
            immutableList = immutableList2;
        } else {
            FetchThreadsAndMessagesResult a2 = ((MessagesSyncThreadsFetcher) this.f4362c.get()).m3943a(c2, set, ((DeltaWithSequenceId) list.get(list.size() - 1)).b);
            c.putAll(a2.f4327a);
            immutableList = a2.f4327a.keySet().asList();
            immutableSet = a2.f4328b;
            if (!c2.isEmpty()) {
                MessageSyncAnalyticsLogger messageSyncAnalyticsLogger = this.f4364e;
                int size = list.size();
                int size2 = c2.size();
                int size3 = immutableList.size();
                int size4 = immutableSet.size();
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("sync_thread_prefetch");
                honeyClientEvent.a("num_deltas_in_batch", size);
                honeyClientEvent.a("num_threads_tried_to_fetch", size2);
                honeyClientEvent.a("num_threads_fetched", size3);
                honeyClientEvent.a("num_non_existent_threads", size4);
                messageSyncAnalyticsLogger.a.a(honeyClientEvent, IrisQueueTypes.MESSAGES_QUEUE_TYPE);
            }
            Iterator it = c2.iterator();
            while (it.hasNext()) {
                this.f4365f.m4230a((ThreadKey) it.next());
            }
        }
        if (obj != null) {
            ((MessagesSyncLoggedInUserFetcher) this.f4366g.get()).m3919a();
        }
        return new PrefetchedSyncData(ImmutableMap.copyOf(c), immutableList, immutableSet);
    }

    private static LinkedHashSet<FetchMessageParams> m3970a(MessagesDeltaHandler messagesDeltaHandler, DeltaWrapper deltaWrapper) {
        LinkedHashSet<FetchMessageParams> c = Sets.c();
        Iterator it = messagesDeltaHandler.mo128c(deltaWrapper).entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            c.add(new FetchMessageParams((String) entry.getValue(), (ThreadKey) entry.getKey()));
        }
        return c;
    }

    private void m3971a(ImmutableSet<ThreadKey> immutableSet, Map<ThreadKey, ThreadSummary> map, Set<ThreadKey> set) {
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            ThreadKey threadKey = (ThreadKey) it.next();
            if (!(map.containsKey(threadKey) || set.contains(threadKey))) {
                ThreadCriteria a = ThreadCriteria.a(threadKey);
                ThreadSummary a2 = this.f4360a.a(a);
                if (a2 == null) {
                    FetchThreadResult a3 = this.f4361b.a(a, 20);
                    if (a3.b.l && Objects.equal(FolderName.INBOX, a3.c.A)) {
                        ((CacheInsertThreadsHandler) this.f4367h.get()).a(20, a3);
                        a2 = a3.c;
                    } else {
                        a2 = null;
                    }
                }
                ThreadSummary threadSummary = a2;
                if (threadSummary != null) {
                    map.put(threadKey, threadSummary);
                } else {
                    set.add(threadKey);
                }
            }
        }
    }
}
