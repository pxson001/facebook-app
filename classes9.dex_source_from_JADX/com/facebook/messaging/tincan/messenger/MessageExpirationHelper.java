package com.facebook.messaging.tincan.messenger;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.SystemClock;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.CacheInsertThreadsHandler_TincanMessagesMethodAutoProvider;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.cache.TincanMessages;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.tincan.database.DbWriteTincanHandler;
import com.facebook.messaging.tincan.database.TincanDbMessagesFetcher;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@UserScoped
/* compiled from: clientToken */
public class MessageExpirationHelper {
    private static final Object f18004f = new Object();
    @Inject
    private TincanDbMessagesFetcher f18005a;
    @Inject
    private DbWriteTincanHandler f18006b;
    @TincanMessages
    @Inject
    private CacheInsertThreadsHandler f18007c;
    @Inject
    private MessagesBroadcaster f18008d;
    @ForNonUiThread
    @Inject
    private ListeningScheduledExecutorService f18009e;

    private static MessageExpirationHelper m17996b(InjectorLike injectorLike) {
        MessageExpirationHelper messageExpirationHelper = new MessageExpirationHelper();
        messageExpirationHelper.m17995a(TincanDbMessagesFetcher.a(injectorLike), DbWriteTincanHandler.a(injectorLike), CacheInsertThreadsHandler_TincanMessagesMethodAutoProvider.m9946a(injectorLike), MessagesBroadcaster.a(injectorLike), ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike));
        return messageExpirationHelper;
    }

    private void m17995a(TincanDbMessagesFetcher tincanDbMessagesFetcher, DbWriteTincanHandler dbWriteTincanHandler, CacheInsertThreadsHandler cacheInsertThreadsHandler, MessagesBroadcaster messagesBroadcaster, ListeningScheduledExecutorService listeningScheduledExecutorService) {
        this.f18005a = tincanDbMessagesFetcher;
        this.f18006b = dbWriteTincanHandler;
        this.f18007c = cacheInsertThreadsHandler;
        this.f18008d = messagesBroadcaster;
        this.f18009e = listeningScheduledExecutorService;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.tincan.messenger.MessageExpirationHelper m17993a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f18004f;	 Catch:{ all -> 0x006c }
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
        r1 = m17996b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f18004f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.MessageExpirationHelper) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.tincan.messenger.MessageExpirationHelper) r0;	 Catch:{  }
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
        r0 = f18004f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.MessageExpirationHelper) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.messenger.MessageExpirationHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.messenger.MessageExpirationHelper");
    }

    final synchronized void m17998a(ThreadKey threadKey, long j) {
        ImmutableList a = this.f18005a.a(threadKey, j);
        if (!a.isEmpty()) {
            HashSet hashSet = new HashSet();
            final long a2 = SystemClock.b().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                Message message = (Message) a.get(i);
                Preconditions.checkNotNull(message.K);
                hashSet.add(Integer.valueOf((int) Math.max(0, message.K.longValue() - a2)));
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                final Integer num = (Integer) it.next();
                final ThreadKey threadKey2 = threadKey;
                this.f18009e.a(new Runnable(this) {
                    final /* synthetic */ MessageExpirationHelper f18003d;

                    public void run() {
                        MessageExpirationHelper.m17997b(this.f18003d, threadKey2, a2 + ((long) num.intValue()));
                    }
                }, ((long) num.intValue()) + 1000, TimeUnit.MILLISECONDS);
            }
        }
    }

    public static synchronized void m17997b(MessageExpirationHelper messageExpirationHelper, ThreadKey threadKey, long j) {
        synchronized (messageExpirationHelper) {
            messageExpirationHelper.m17994a(threadKey, messageExpirationHelper.f18005a.a(threadKey, j, String.valueOf(threadKey.d)));
        }
    }

    private synchronized void m17994a(ThreadKey threadKey, ImmutableList<Message> immutableList) {
        if (!immutableList.isEmpty()) {
            Set hashSet = new HashSet();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                hashSet.add(((Message) immutableList.get(i)).a);
            }
            this.f18006b.a(threadKey, hashSet);
            this.f18007c.m9928a(threadKey, hashSet);
            this.f18008d.a(threadKey, hashSet, ImmutableList.of());
            this.f18008d.a(threadKey);
        }
    }
}
