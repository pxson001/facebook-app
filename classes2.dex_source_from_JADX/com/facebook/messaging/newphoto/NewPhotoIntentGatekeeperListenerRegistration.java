package com.facebook.messaging.newphoto;

import android.content.Context;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.init.INeedInitForGatekeepersListenerRegistration;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.photoreminders.MessagingPhotoRemindersModule.C01691;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: tokenType */
public class NewPhotoIntentGatekeeperListenerRegistration extends INeedInitForGatekeepersListenerRegistration<NewPhotoBroadcastReceiverInitializer> {
    private static final String f2433b = NewPhotoIntentGatekeeperListenerRegistration.class.getSimpleName();
    private static volatile NewPhotoIntentGatekeeperListenerRegistration f2434e;
    private final SecureContextHelper f2435c;
    private final Context f2436d;

    public static com.facebook.messaging.newphoto.NewPhotoIntentGatekeeperListenerRegistration m4633a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2434e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.newphoto.NewPhotoIntentGatekeeperListenerRegistration.class;
        monitor-enter(r1);
        r0 = f2434e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m4634b(r0);	 Catch:{ all -> 0x0035 }
        f2434e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2434e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.newphoto.NewPhotoIntentGatekeeperListenerRegistration.a(com.facebook.inject.InjectorLike):com.facebook.messaging.newphoto.NewPhotoIntentGatekeeperListenerRegistration");
    }

    private static NewPhotoIntentGatekeeperListenerRegistration m4634b(InjectorLike injectorLike) {
        return new NewPhotoIntentGatekeeperListenerRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 2668), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$NewPhotoIntentListenerGK(injectorLike)), (Context) injectorLike.getInstance(Context.class), DefaultSecureContextHelper.m4636a(injectorLike));
    }

    @Inject
    public NewPhotoIntentGatekeeperListenerRegistration(Lazy<NewPhotoBroadcastReceiverInitializer> lazy, Set<NewPhotoIntentListenerGK> set, Context context, SecureContextHelper secureContextHelper) {
        int[] iArr = new int[set.size()];
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            C01691 c01691 = (C01691) it.next();
            int i2 = i + 1;
            iArr[i] = 277;
            i = i2;
        }
        super((Lazy) lazy, iArr);
        this.f2436d = context;
        this.f2435c = secureContextHelper;
        Integer.valueOf(set.size());
    }

    protected final void mo659a(GatekeeperStoreImpl gatekeeperStoreImpl, int i, Object obj) {
        Integer.valueOf(i);
        this.f2435c.mo666c(NewPhotoIntentService.a(this.f2436d), this.f2436d);
    }
}
