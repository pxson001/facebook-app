package com.facebook.messages.ipc;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.build.SignatureType;
import com.facebook.config.application.SignatureTypeMethodAutoProvider;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: loginApprovalsResendCodeParams */
public class MessagesCrossProcessContract {
    private static volatile MessagesCrossProcessContract f8881g;
    public final Context f8882a;
    public final Provider<String> f8883b;
    public final String f8884c;
    public final String f8885d;
    public final String f8886e;
    public final String f8887f;

    public static com.facebook.messages.ipc.MessagesCrossProcessContract m9243a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8881g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messages.ipc.MessagesCrossProcessContract.class;
        monitor-enter(r1);
        r0 = f8881g;	 Catch:{ all -> 0x003a }
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
        r0 = m9244b(r0);	 Catch:{ all -> 0x0035 }
        f8881g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8881g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messages.ipc.MessagesCrossProcessContract.a(com.facebook.inject.InjectorLike):com.facebook.messages.ipc.MessagesCrossProcessContract");
    }

    private static MessagesCrossProcessContract m9244b(InjectorLike injectorLike) {
        return new MessagesCrossProcessContract((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4442), SignatureTypeMethodAutoProvider.b(injectorLike), FacebookOnlyIntentActionFactory.a(injectorLike));
    }

    @Inject
    public MessagesCrossProcessContract(Context context, Provider<String> provider, SignatureType signatureType, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory) {
        this.f8882a = context;
        this.f8883b = provider;
        this.f8884c = signatureType.getPermission();
        this.f8885d = facebookOnlyIntentActionFactory.a("messages.ACTION_NEW_MESSAGE");
        this.f8886e = facebookOnlyIntentActionFactory.a("messages.ACTION_CLEAR_ALL_MESSAGES");
        this.f8887f = facebookOnlyIntentActionFactory.a("messages.ACTION_CLEAR_MESSAGE");
    }

    public final void m9245a(FrozenNewMessageNotification frozenNewMessageNotification, String str) {
        Intent intent = new Intent(this.f8885d);
        intent.putExtra("message", frozenNewMessageNotification);
        intent.putExtra("userId", str);
        this.f8882a.sendBroadcast(intent, this.f8884c);
    }
}