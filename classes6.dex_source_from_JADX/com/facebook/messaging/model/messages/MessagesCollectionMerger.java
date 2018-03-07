package com.facebook.messaging.model.messages;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.User;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: upload_records */
public class MessagesCollectionMerger {
    private static final Class<?> f2113a = MessagesCollectionMerger.class;
    private static volatile MessagesCollectionMerger f2114d;
    private final Provider<User> f2115b;
    private final MessageUtil f2116c;

    /* compiled from: upload_records */
    class MessageMap {
        private final MessageUtil f2111a;
        private Map<String, Message> f2112b = Maps.c();

        MessageMap(MessageUtil messageUtil) {
            this.f2111a = messageUtil;
        }

        final void m3439a(Message message) {
            this.f2112b.put(message.f2010a, message);
            if (MessageUtil.O(message)) {
                this.f2112b.put(message.f2023n, message);
            }
        }

        final boolean m3440b(Message message) {
            return m3441c(message) != null;
        }

        final Message m3441c(Message message) {
            Message message2 = (Message) this.f2112b.get(message.f2010a);
            if (message2 == null && MessageUtil.O(message)) {
                return (Message) this.f2112b.get(message.f2023n);
            }
            return message2;
        }

        final void m3442d(Message message) {
            this.f2112b.remove(message.f2010a);
            if (MessageUtil.O(message)) {
                this.f2112b.remove(message.f2023n);
            }
        }
    }

    public static com.facebook.messaging.model.messages.MessagesCollectionMerger m3444a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f2114d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.model.messages.MessagesCollectionMerger.class;
        monitor-enter(r1);
        r0 = f2114d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3446b(r0);	 Catch:{ all -> 0x0035 }
        f2114d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2114d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.model.messages.MessagesCollectionMerger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.model.messages.MessagesCollectionMerger");
    }

    private static MessagesCollectionMerger m3446b(InjectorLike injectorLike) {
        return new MessagesCollectionMerger(IdBasedProvider.a(injectorLike, 3595), MessageUtil.a(injectorLike));
    }

    @Inject
    public MessagesCollectionMerger(Provider<User> provider, MessageUtil messageUtil) {
        this.f2115b = provider;
        this.f2116c = messageUtil;
    }

    public final MessagesCollection m3449a(MessagesCollection messagesCollection, MessagesCollection messagesCollection2) {
        return m3443a(messagesCollection, messagesCollection2, false);
    }

    public final MessagesCollection m3450b(MessagesCollection messagesCollection, MessagesCollection messagesCollection2) {
        return m3443a(messagesCollection, messagesCollection2, true);
    }

    private MessagesCollection m3443a(MessagesCollection messagesCollection, MessagesCollection messagesCollection2, boolean z) {
        Integer.valueOf(messagesCollection.m3438g());
        Integer.valueOf(messagesCollection2.m3438g());
        if (!Objects.equal(messagesCollection.m3430a(), messagesCollection2.m3430a())) {
            throw new IllegalArgumentException("Message Collections with different thread ids");
        } else if (messagesCollection.m3437f() && messagesCollection2.m3437f()) {
            return messagesCollection;
        } else {
            if (messagesCollection.m3437f()) {
                return messagesCollection2;
            }
            if (messagesCollection2.m3437f()) {
                return messagesCollection;
            }
            if (!m3448d(messagesCollection, messagesCollection2)) {
                return messagesCollection2;
            }
            int i;
            int i2;
            Message message;
            Object obj;
            Message d = messagesCollection.m3435d();
            MessageMap messageMap = new MessageMap(this.f2116c);
            MessageMap messageMap2 = new MessageMap(this.f2116c);
            ImmutableList b = messagesCollection.m3433b();
            int size = b.size();
            for (i = 0; i < size; i++) {
                messageMap.m3439a((Message) b.get(i));
            }
            ImmutableList b2 = messagesCollection2.m3433b();
            int size2 = b2.size();
            for (i2 = 0; i2 < size2; i2++) {
                message = (Message) b2.get(i2);
                messageMap2.m3439a(message);
                if (m3445a(message, d)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                new Object[1][0] = d.f2010a;
            } else if (z) {
                return messagesCollection;
            }
            i = 0;
            int g = messagesCollection.m3438g();
            size = messagesCollection2.m3438g();
            Builder builder = ImmutableList.builder();
            MessageMap messageMap3 = new MessageMap(this.f2116c);
            i2 = 0;
            while (i2 < g && i < size) {
                Message b3 = messagesCollection.m3432b(i2);
                message = messagesCollection2.m3432b(i);
                if (messageMap3.m3440b(b3)) {
                    i2++;
                } else if (messageMap3.m3440b(message)) {
                    i++;
                } else if (m3445a(b3, message)) {
                    new Object[1][0] = b3.f2010a;
                    if (m3447b(message, b3)) {
                        builder.c(message);
                    } else {
                        builder.c(b3);
                    }
                    i++;
                    i2++;
                } else {
                    int i3;
                    if (messageMap2.m3440b(b3)) {
                        Message c = messageMap2.m3441c(b3);
                        if (b3.f2012c > c.f2012c || (!b3.f2024o && c.f2024o)) {
                            new Object[1][0] = b3.f2010a;
                            builder.c(b3);
                            messageMap3.m3439a(b3);
                            messageMap2.m3442d(c);
                            i3 = i2 + 1;
                        } else {
                            new Object[1][0] = b3.f2010a;
                            while (!m3445a(b3, message) && i < size) {
                                message = messagesCollection2.m3432b(i);
                                if (messageMap.m3440b(message) && !m3447b(message, b3)) {
                                    messageMap2.m3442d(message);
                                    new Object[1][0] = message.f2010a;
                                } else if (messageMap3.m3440b(message)) {
                                    messageMap2.m3442d(message);
                                    new Object[1][0] = message.f2010a;
                                } else {
                                    new Object[1][0] = message.f2010a;
                                    builder.c(message);
                                    messageMap3.m3439a(message);
                                }
                                i++;
                            }
                        }
                    } else {
                        new Object[1][0] = b3.f2010a;
                        builder.c(b3);
                        messageMap3.m3439a(b3);
                        i3 = i2 + 1;
                    }
                    i2 = i3;
                }
            }
            while (i < size) {
                message = messagesCollection2.m3432b(i);
                if (messageMap3.m3440b(message)) {
                    new Object[1][0] = message.f2010a;
                } else {
                    new Object[1][0] = message.f2010a;
                    builder.c(message);
                    messageMap3.m3439a(message);
                }
                i++;
            }
            return new MessagesCollection(messagesCollection.m3430a(), builder.b(), messagesCollection2.m3436e(), messagesCollection, messagesCollection2, z, (User) this.f2115b.get());
        }
    }

    private static boolean m3448d(MessagesCollection messagesCollection, MessagesCollection messagesCollection2) {
        UnmodifiableIterator it = messagesCollection.f2109b.iterator();
        UnmodifiableIterator it2 = messagesCollection2.f2109b.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Message message = (Message) it.next();
            Message message2 = (Message) it2.next();
            if (message.f2024o || message2.f2024o || !Objects.equal(message.f2010a, message2.f2010a)) {
                return true;
            }
            if (ThreadKey.m3499d(message.f2011b) && ThreadKey.m3499d(message2.f2011b) && (message.f2016g != message2.f2016g || !Objects.equal(message.f2021l, message2.f2021l))) {
                return true;
            }
            if (MessageUtil.a(message2, message)) {
                return true;
            }
        }
        return it.hasNext();
    }

    private boolean m3445a(Message message, Message message2) {
        if (Objects.equal(message.f2010a, message2.f2010a)) {
            return true;
        }
        if (MessageUtil.O(message) && MessageUtil.O(message2) && Objects.equal(message.f2023n, message2.f2023n)) {
            return true;
        }
        return false;
    }

    private static boolean m3447b(Message message, Message message2) {
        return !message.f2024o && message2.f2024o;
    }

    public final boolean m3451c(MessagesCollection messagesCollection, MessagesCollection messagesCollection2) {
        if (messagesCollection.m3437f() && messagesCollection2.m3437f()) {
            return true;
        }
        if (messagesCollection.m3437f()) {
            return true;
        }
        if (messagesCollection2.m3437f()) {
            return true;
        }
        Message d = messagesCollection.m3435d();
        ImmutableList immutableList = messagesCollection2.f2109b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (m3445a((Message) immutableList.get(i), d)) {
                return true;
            }
        }
        return false;
    }
}
