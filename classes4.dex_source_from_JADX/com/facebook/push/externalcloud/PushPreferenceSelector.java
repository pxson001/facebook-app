package com.facebook.push.externalcloud;

import com.facebook.inject.InjectorLike;
import com.facebook.push.fbpushtoken.PushTokenHolder;
import com.facebook.push.fbpushtoken.PushTokenHolderProvider;
import com.facebook.push.registration.ServiceType;
import com.google.common.collect.Maps;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: initial_app_launch_experiment_exposure */
public class PushPreferenceSelector {
    private static final HashMap<ServiceType, PushTokenHolder> f10341a = Maps.c();
    private static volatile PushPreferenceSelector f10342c;
    private final PushTokenHolderProvider f10343b;

    public static com.facebook.push.externalcloud.PushPreferenceSelector m10869a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10342c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.externalcloud.PushPreferenceSelector.class;
        monitor-enter(r1);
        r0 = f10342c;	 Catch:{ all -> 0x003a }
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
        r0 = m10870b(r0);	 Catch:{ all -> 0x0035 }
        f10342c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10342c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.externalcloud.PushPreferenceSelector.a(com.facebook.inject.InjectorLike):com.facebook.push.externalcloud.PushPreferenceSelector");
    }

    private static PushPreferenceSelector m10870b(InjectorLike injectorLike) {
        return new PushPreferenceSelector((PushTokenHolderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PushTokenHolderProvider.class));
    }

    @Inject
    public PushPreferenceSelector(PushTokenHolderProvider pushTokenHolderProvider) {
        this.f10343b = pushTokenHolderProvider;
    }

    public final synchronized PushTokenHolder m10871a(ServiceType serviceType) {
        if (!f10341a.containsKey(serviceType)) {
            f10341a.put(serviceType, this.f10343b.m10872a(serviceType));
        }
        return (PushTokenHolder) f10341a.get(serviceType);
    }
}
