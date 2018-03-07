package com.facebook.messaging.chatheads.intents;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.chatheads.ipc.ChatHeadMessageNotification;
import com.facebook.messaging.chatheads.ipc.ChatHeadsIntent;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: sync_old_photo */
public class ChatHeadsIntentDispatcher {
    private static final ImmutableSet<String> f1447a = ImmutableSet.of(ChatHeadsIntent.f1463d, ChatHeadsIntent.f1461b);
    private static volatile ChatHeadsIntentDispatcher f1448h;
    private final Context f1449b;
    private final Provider<String> f1450c;
    public final DefaultAppChoreographer f1451d;
    public final Product f1452e;
    @Nullable
    private final Class f1453f;
    public boolean f1454g;

    public static com.facebook.messaging.chatheads.intents.ChatHeadsIntentDispatcher m1684a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1448h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.chatheads.intents.ChatHeadsIntentDispatcher.class;
        monitor-enter(r1);
        r0 = f1448h;	 Catch:{ all -> 0x003a }
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
        r0 = m1687b(r0);	 Catch:{ all -> 0x0035 }
        f1448h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1448h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.chatheads.intents.ChatHeadsIntentDispatcher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.chatheads.intents.ChatHeadsIntentDispatcher");
    }

    private static ChatHeadsIntentDispatcher m1687b(InjectorLike injectorLike) {
        return new ChatHeadsIntentDispatcher((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4442), DefaultAppChoreographer.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), (Class) null);
    }

    @Inject
    public ChatHeadsIntentDispatcher(Context context, Provider<String> provider, AppChoreographer appChoreographer, Product product, Class cls) {
        this.f1449b = context;
        this.f1450c = provider;
        this.f1451d = appChoreographer;
        this.f1452e = product;
        this.f1453f = cls;
    }

    public final void m1691a(ChatHeadMessageNotification chatHeadMessageNotification) {
        Intent b = m1686b(ChatHeadsIntent.f1460a);
        b.putExtra(ChatHeadsIntent.f1473n, chatHeadMessageNotification);
        m1685a(b);
    }

    public final void m1692a(ThreadKey threadKey, String str) {
        Intent b = m1686b(ChatHeadsIntent.f1463d);
        b.putExtra(ChatHeadsInternalIntent.c, threadKey);
        b.putExtra(ChatHeadsIntent.f1474o, str);
        m1685a(b);
    }

    public final void m1690a(long j, String str) {
        Intent b = m1686b(ChatHeadsIntent.f1463d);
        b.putExtra(ChatHeadsIntent.f1479t, j);
        b.putExtra(ChatHeadsIntent.f1474o, str);
        m1685a(b);
    }

    public final void m1694a(String str, @Nullable String str2, String str3) {
        Intent b = m1686b(ChatHeadsIntent.f1463d);
        b.putExtra(ChatHeadsIntent.f1474o, str3);
        b.putExtra(ChatHeadsIntent.f1481v, str);
        if (str2 != null) {
            b.putExtra(ChatHeadsIntent.f1482w, str2);
        }
        m1685a(b);
    }

    public final void m1695b(ThreadKey threadKey, String str) {
        Intent b = m1686b(ChatHeadsIntent.f1465f);
        b.putExtra(ChatHeadsIntent.f1477r, threadKey.toString());
        b.putExtra(ChatHeadsIntent.f1474o, str);
        m1685a(b);
    }

    public final void m1696c(ThreadKey threadKey, String str) {
        Intent b = m1686b(ChatHeadsIntent.f1466g);
        b.putExtra(ChatHeadsInternalIntent.c, threadKey);
        b.putExtra(ChatHeadsIntent.f1474o, str);
        m1685a(b);
    }

    public final void m1693a(String str) {
        m1685a(m1686b(ChatHeadsIntent.f1467h).putExtra(ChatHeadsIntent.f1474o, str));
    }

    public final void m1689a() {
        m1685a(m1686b(ChatHeadsInternalIntent.e));
    }

    private Intent m1686b(String str) {
        Intent intent = new Intent(this.f1449b, this.f1453f);
        intent.setAction(str);
        return intent;
    }

    public static void m1688c(ChatHeadsIntentDispatcher chatHeadsIntentDispatcher, Intent intent) {
        chatHeadsIntentDispatcher.f1449b.startService(intent);
    }

    private void m1685a(Intent intent) {
        Object obj;
        if (this.f1452e == Product.MESSENGER) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            intent.putExtra(ChatHeadsIntent.f1472m, (String) this.f1450c.get());
            if (f1447a.contains(intent.getAction())) {
                if (this.f1454g) {
                    m1688c(this, intent);
                } else {
                    this.f1451d.a("ChatHeadsInitializer initAfterUiIdle", new 1(this, intent), Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.BACKGROUND);
                }
                return;
            }
            m1688c(this, intent);
        }
    }
}
