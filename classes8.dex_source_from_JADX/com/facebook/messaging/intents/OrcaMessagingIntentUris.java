package com.facebook.messaging.intents;

import android.content.Intent;
import android.net.Uri;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import javax.inject.Singleton;

@Singleton
/* compiled from: tosCookiesUrl */
public class OrcaMessagingIntentUris implements MessagingIntentUris {
    private static volatile OrcaMessagingIntentUris f1535c;

    public static com.facebook.messaging.intents.OrcaMessagingIntentUris m1697a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f1535c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.intents.OrcaMessagingIntentUris.class;
        monitor-enter(r1);
        r0 = f1535c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m1698b();	 Catch:{ all -> 0x0034 }
        f1535c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1535c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.intents.OrcaMessagingIntentUris.a(com.facebook.inject.InjectorLike):com.facebook.messaging.intents.OrcaMessagingIntentUris");
    }

    private static OrcaMessagingIntentUris m1698b() {
        return new OrcaMessagingIntentUris();
    }

    public final Uri m1699a() {
        return Uri.parse(MessengerLinks.g);
    }

    public final Uri m1701a(ThreadKey threadKey) {
        if (threadKey.a == Type.ONE_TO_ONE) {
            return m1702a(Long.toString(threadKey.d));
        }
        if (threadKey.a == Type.GROUP) {
            return m1700a(threadKey.b);
        }
        if (threadKey.a == Type.SMS) {
            return Uri.parse(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.A, Long.toString(threadKey.b)));
        }
        if (ThreadKey.g(threadKey)) {
            return Uri.parse(MessengerLinks.v);
        }
        return m1699a();
    }

    public final Intent m1703b(ThreadKey threadKey) {
        Intent intent = new Intent(a);
        intent.setData(m1701a(threadKey));
        if (ThreadKey.g(threadKey)) {
            intent.putExtra("thread_key_string", threadKey.toString());
        }
        return intent;
    }

    public final Uri m1702a(String str) {
        return Uri.parse(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.w, str));
    }

    public final Uri m1700a(long j) {
        return Uri.parse(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.y, Long.toString(j)));
    }
}
