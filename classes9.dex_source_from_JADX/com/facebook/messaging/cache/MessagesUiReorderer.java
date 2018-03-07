package com.facebook.messaging.cache;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.User;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: method/friendfinder.mobile */
public class MessagesUiReorderer {
    private static final Class<?> f9514a = MessagesUiReorderer.class;
    private static volatile MessagesUiReorderer f9515d;
    private final Provider<User> f9516b;
    private final Clock f9517c;

    /* compiled from: method/friendfinder.mobile */
    public class MessageByDateComparator implements Comparator<Message> {
        public int compare(Object obj, Object obj2) {
            Message message = (Message) obj2;
            long d = MessageUtil.d((Message) obj);
            long d2 = MessageUtil.d(message);
            if (d > d2) {
                return -1;
            }
            if (d < d2) {
                return 1;
            }
            return 0;
        }
    }

    public static com.facebook.messaging.cache.MessagesUiReorderer m10101a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9515d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.cache.MessagesUiReorderer.class;
        monitor-enter(r1);
        r0 = f9515d;	 Catch:{ all -> 0x003a }
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
        r0 = m10105b(r0);	 Catch:{ all -> 0x0035 }
        f9515d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9515d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.cache.MessagesUiReorderer.a(com.facebook.inject.InjectorLike):com.facebook.messaging.cache.MessagesUiReorderer");
    }

    private static MessagesUiReorderer m10105b(InjectorLike injectorLike) {
        return new MessagesUiReorderer(IdBasedProvider.a(injectorLike, 3595), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MessagesUiReorderer(Provider<User> provider, Clock clock) {
        this.f9516b = provider;
        this.f9517c = clock;
    }

    public final MessagesCollection m10106a(MessagesCollection messagesCollection) {
        TracerDetour.a("MUR.maybeReoderMessages", 14335639);
        try {
            Message message;
            long a = this.f9517c.a();
            ImmutableList b = messagesCollection.b();
            int i = -1;
            boolean z = false;
            for (int i2 = 0; i2 < b.size(); i2++) {
                message = (Message) b.get(i2);
                boolean a2 = m10104a(message);
                if (a - message.c > 1800000 && (i == -1 || !a2 || !r2)) {
                    break;
                }
                z = a2;
                i = i2;
            }
            if (i == -1) {
                return messagesCollection;
            }
            Object obj;
            int i3 = 1;
            Message message2 = (Message) b.get(0);
            while (i3 <= i) {
                message = (Message) b.get(i3);
                if (MessageUtil.d(message2) < MessageUtil.d(message)) {
                    obj = 1;
                    break;
                }
                i3++;
                message2 = message;
            }
            obj = null;
            if (obj == null) {
                TracerDetour.a(-1036621287);
                return messagesCollection;
            }
            Collection a3 = Lists.a(b);
            Collections.sort(a3.subList(0, i + 1), new MessageByDateComparator());
            MessagesCollection messagesCollection2 = new MessagesCollection(messagesCollection.a(), ImmutableList.copyOf(a3), messagesCollection.e());
            m10102a(messagesCollection, messagesCollection2);
            TracerDetour.a(648581193);
            return messagesCollection2;
        } finally {
            TracerDetour.a(1633470407);
        }
    }

    private boolean m10104a(Message message) {
        ParticipantInfo participantInfo = message.e;
        User user = (User) this.f9516b.get();
        return (user == null || participantInfo == null || participantInfo.b == null || !Objects.equal(user.T, participantInfo.b)) ? false : true;
    }

    private void m10102a(MessagesCollection messagesCollection, MessagesCollection messagesCollection2) {
        if (BLog.b(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("  Before Messages:\n");
            m10103a(stringBuilder, messagesCollection, 8);
            stringBuilder.append("  After Messages:\n");
            m10103a(stringBuilder, messagesCollection2, 8);
        }
    }

    private static void m10103a(StringBuilder stringBuilder, MessagesCollection messagesCollection, int i) {
        if (messagesCollection == null || messagesCollection.f()) {
            stringBuilder.append("    none\n");
            return;
        }
        int i2 = 0;
        while (i2 < i && i2 < messagesCollection.g()) {
            stringBuilder.append("   ").append(messagesCollection.b(i2)).append("\n");
            i2++;
        }
    }
}
