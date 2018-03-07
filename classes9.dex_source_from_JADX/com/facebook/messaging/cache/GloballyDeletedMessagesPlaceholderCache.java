package com.facebook.messaging.cache;

import android.content.Context;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.annotations.IsGlobalDeletePlaceholderEnabled;
import com.facebook.messaging.cache.MessagesUiReorderer.MessageByDateComparator;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.30;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
@ThreadSafe
/* compiled from: method/messaging.mutethread */
public class GloballyDeletedMessagesPlaceholderCache {
    private static final MessageByDateComparator f9502c = new MessageByDateComparator();
    private static final Object f9503l = new Object();
    @IsGlobalDeletePlaceholderEnabled
    Provider<Boolean> f9504a;
    @ForUiThread
    public ScheduledExecutorService f9505b;
    public final Context f9506d;
    private final MessageUtil f9507e;
    @GuardedBy("mDeletedMessagePlaceholders")
    private final Map<ThreadKey, List<Message>> f9508f = Maps.d();
    private final Set<Message> f9509g = Sets.b();
    public final Map<Message, ScheduledFuture<?>> f9510h = Maps.d();
    public final Set<String> f9511i = Sets.b();
    public 30 f9512j;
    public boolean f9513k;

    private static GloballyDeletedMessagesPlaceholderCache m10094b(InjectorLike injectorLike) {
        return new GloballyDeletedMessagesPlaceholderCache((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4062), MessageUtil.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.cache.GloballyDeletedMessagesPlaceholderCache m10093a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9503l;	 Catch:{ all -> 0x006c }
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
        r1 = m10094b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9503l;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.GloballyDeletedMessagesPlaceholderCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.cache.GloballyDeletedMessagesPlaceholderCache) r0;	 Catch:{  }
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
        r0 = f9503l;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.GloballyDeletedMessagesPlaceholderCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.cache.GloballyDeletedMessagesPlaceholderCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.cache.GloballyDeletedMessagesPlaceholderCache");
    }

    @Inject
    public GloballyDeletedMessagesPlaceholderCache(Context context, Provider<Boolean> provider, MessageUtil messageUtil, ScheduledExecutorService scheduledExecutorService) {
        this.f9506d = context;
        this.f9504a = provider;
        this.f9507e = messageUtil;
        this.f9505b = scheduledExecutorService;
        this.f9513k = false;
    }

    @GuardedBy("mDeletedMessagePlaceholders")
    public final ImmutableList<Message> m10097a(ThreadKey threadKey) {
        ImmutableList<Message> copyOf;
        synchronized (this.f9508f) {
            copyOf = this.f9508f.containsKey(threadKey) ? ImmutableList.copyOf((Collection) this.f9508f.get(threadKey)) : ImmutableList.of();
        }
        return copyOf;
    }

    public final void m10099a(Message message, String str) {
        if (((Boolean) this.f9504a.get()).booleanValue() && !this.f9507e.P(message) && !this.f9511i.contains(message.a)) {
            synchronized (this.f9508f) {
                m10095b(message, str);
            }
        }
    }

    @GuardedBy("mDeletedMessagePlaceholders")
    private void m10095b(Message message, String str) {
        String string = this.f9506d.getString(2131231086, new Object[]{str});
        MessageBuilder a = Message.newBuilder().a(message.a);
        a.f = string;
        MessageBuilder messageBuilder = a;
        messageBuilder.n = message.n;
        messageBuilder = messageBuilder;
        messageBuilder.b = message.b;
        messageBuilder = messageBuilder;
        messageBuilder.e = message.e;
        messageBuilder = messageBuilder;
        messageBuilder.l = MessageType.GLOBALLY_DELETED_MESSAGE_PLACEHOLDER;
        messageBuilder = messageBuilder;
        messageBuilder.c = message.c;
        messageBuilder = messageBuilder;
        messageBuilder.d = message.d;
        Message R = messageBuilder.R();
        List list = (List) this.f9508f.get(message.b);
        if (list == null) {
            list = new LinkedList();
            this.f9508f.put(message.b, list);
        }
        list.add(R);
        if (list.size() > 1) {
            Collections.sort(list, f9502c);
        }
        this.f9509g.add(R);
    }

    public final void m10100b(ThreadKey threadKey) {
        Iterator it = this.f9509g.iterator();
        while (it.hasNext()) {
            final Message message = (Message) it.next();
            if (message.b.equals(threadKey)) {
                this.f9510h.put(message, this.f9505b.schedule(new Runnable(this) {
                    final /* synthetic */ GloballyDeletedMessagesPlaceholderCache f9501b;

                    public void run() {
                        GloballyDeletedMessagesPlaceholderCache.m10096c(this.f9501b, message);
                    }
                }, 4000, TimeUnit.MILLISECONDS));
                it.remove();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m10098a(com.facebook.messaging.model.messages.Message r9) {
        /*
        r8 = this;
        r1 = r8.f9508f;
        monitor-enter(r1);
        r0 = r8.f9508f;	 Catch:{ all -> 0x0042 }
        r2 = r9.b;	 Catch:{ all -> 0x0042 }
        r0 = r0.containsKey(r2);	 Catch:{ all -> 0x0042 }
        if (r0 != 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0042 }
    L_0x000e:
        return;
    L_0x000f:
        r0 = r8.f9508f;	 Catch:{ all -> 0x0042 }
        r2 = r9.b;	 Catch:{ all -> 0x0042 }
        r0 = r0.get(r2);	 Catch:{ all -> 0x0042 }
        r0 = (java.util.List) r0;	 Catch:{ all -> 0x0042 }
        monitor-exit(r1);	 Catch:{ all -> 0x0042 }
        r2 = r0.iterator();
    L_0x001e:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x000e;
    L_0x0024:
        r0 = r2.next();
        r0 = (com.facebook.messaging.model.messages.Message) r0;
        r4 = r0.c;
        r6 = r9.c;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 != 0) goto L_0x001e;
    L_0x0032:
        r1 = r8.f9510h;
        r1 = r1.get(r0);
        r1 = (java.util.concurrent.ScheduledFuture) r1;
        r3 = 1;
        r1.cancel(r3);
        m10096c(r8, r0);
        goto L_0x001e;
    L_0x0042:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.cache.GloballyDeletedMessagesPlaceholderCache.a(com.facebook.messaging.model.messages.Message):void");
    }

    public static void m10096c(GloballyDeletedMessagesPlaceholderCache globallyDeletedMessagesPlaceholderCache, Message message) {
        synchronized (globallyDeletedMessagesPlaceholderCache.f9508f) {
            List list = (List) globallyDeletedMessagesPlaceholderCache.f9508f.get(message.b);
            list.remove(message);
            if (list.isEmpty()) {
                globallyDeletedMessagesPlaceholderCache.f9508f.remove(message.b);
            }
        }
        if (globallyDeletedMessagesPlaceholderCache.f9512j != null) {
            globallyDeletedMessagesPlaceholderCache.f9512j.a();
        } else {
            globallyDeletedMessagesPlaceholderCache.f9513k = true;
        }
        globallyDeletedMessagesPlaceholderCache.f9510h.remove(message);
    }
}
