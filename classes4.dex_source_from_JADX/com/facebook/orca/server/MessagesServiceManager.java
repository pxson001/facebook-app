package com.facebook.orca.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.init.INeedInit;
import com.facebook.fbservice.service.DefaultBlueService;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: template_parameters */
public class MessagesServiceManager implements INeedInit {
    private static final Class<?> f10080a = MessagesServiceManager.class;
    private static volatile MessagesServiceManager f10081h;
    private final Context f10082b;
    private final AppStateManager f10083c;
    private final Handler f10084d = new Handler(Looper.getMainLooper());
    private BroadcastReceiver f10085e;
    private boolean f10086f;
    public boolean f10087g;

    /* compiled from: template_parameters */
    class C00751 implements Runnable {
        final /* synthetic */ MessagesServiceManager f1237a;

        C00751(MessagesServiceManager messagesServiceManager) {
            this.f1237a = messagesServiceManager;
        }

        public void run() {
            this.f1237a.f10087g = false;
            MessagesServiceManager.m10558a(this.f1237a);
        }
    }

    /* compiled from: template_parameters */
    class C04562 extends BroadcastReceiver {
        final /* synthetic */ MessagesServiceManager f10088a;

        C04562(MessagesServiceManager messagesServiceManager) {
            this.f10088a = messagesServiceManager;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1556904369);
            MessagesServiceManager.m10558a(this.f10088a);
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -2039211318, a);
        }
    }

    public static com.facebook.orca.server.MessagesServiceManager m10557a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10081h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.server.MessagesServiceManager.class;
        monitor-enter(r1);
        r0 = f10081h;	 Catch:{ all -> 0x003a }
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
        r0 = m10559b(r0);	 Catch:{ all -> 0x0035 }
        f10081h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10081h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.server.MessagesServiceManager.a(com.facebook.inject.InjectorLike):com.facebook.orca.server.MessagesServiceManager");
    }

    private static MessagesServiceManager m10559b(InjectorLike injectorLike) {
        return new MessagesServiceManager((Context) injectorLike.getInstance(Context.class), AppStateManager.a(injectorLike));
    }

    @Inject
    public MessagesServiceManager(Context context, AppStateManager appStateManager) {
        this.f10082b = context;
        this.f10083c = appStateManager;
    }

    public static void m10558a(MessagesServiceManager messagesServiceManager) {
        boolean z = messagesServiceManager.f10083c.o() || messagesServiceManager.f10083c.p() < 30000;
        Intent intent;
        if (z) {
            if (!messagesServiceManager.f10086f) {
                intent = new Intent(messagesServiceManager.f10082b, DefaultBlueService.class);
                intent.setAction("Orca.START");
                messagesServiceManager.f10082b.startService(intent);
                messagesServiceManager.f10086f = true;
            }
            if (!messagesServiceManager.f10087g) {
                HandlerDetour.b(messagesServiceManager.f10084d, new C00751(messagesServiceManager), 30000, -2127897303);
                messagesServiceManager.f10087g = true;
            }
        } else if (messagesServiceManager.f10086f) {
            intent = new Intent(messagesServiceManager.f10082b, DefaultBlueService.class);
            intent.setAction("Orca.STOP");
            messagesServiceManager.f10082b.startService(intent);
            messagesServiceManager.f10086f = false;
        }
    }

    public void init() {
        this.f10085e = new C04562(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AppStateManager.a);
        LocalBroadcastManager.a(this.f10082b).a(this.f10085e, intentFilter);
    }
}
