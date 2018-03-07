package com.facebook.messaging.newphoto;

import android.content.Context;
import com.facebook.common.init.INeedInit;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.prefs.shared.C0411x84623665;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mResultAction */
public class NewPhotoBroadcastReceiverInitializer implements INeedInit {
    public static final String f8564a = NewPhotoBroadcastReceiverInitializer.class.getSimpleName();
    private static volatile NewPhotoBroadcastReceiverInitializer f8565e;
    private final SecureContextHelper f8566b;
    private final Context f8567c;
    private final OnSharedPreferenceChangeListener f8568d = new C04121(this);

    /* compiled from: mResultAction */
    class C04121 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ NewPhotoBroadcastReceiverInitializer f8570a;

        public final void m8817a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            String str = NewPhotoBroadcastReceiverInitializer.f8564a;
            prefKey.toString();
            NewPhotoBroadcastReceiverInitializer.m8816b(this.f8570a);
        }

        C04121(NewPhotoBroadcastReceiverInitializer newPhotoBroadcastReceiverInitializer) {
            this.f8570a = newPhotoBroadcastReceiverInitializer;
        }
    }

    public static com.facebook.messaging.newphoto.NewPhotoBroadcastReceiverInitializer m8814a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8565e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.newphoto.NewPhotoBroadcastReceiverInitializer.class;
        monitor-enter(r1);
        r0 = f8565e;	 Catch:{ all -> 0x003a }
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
        r0 = m8815b(r0);	 Catch:{ all -> 0x0035 }
        f8565e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8565e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.newphoto.NewPhotoBroadcastReceiverInitializer.a(com.facebook.inject.InjectorLike):com.facebook.messaging.newphoto.NewPhotoBroadcastReceiverInitializer");
    }

    private static NewPhotoBroadcastReceiverInitializer m8815b(InjectorLike injectorLike) {
        return new NewPhotoBroadcastReceiverInitializer((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new C0411x84623665(injectorLike)));
    }

    @Inject
    public NewPhotoBroadcastReceiverInitializer(Context context, FbSharedPreferences fbSharedPreferences, SecureContextHelper secureContextHelper, Set<PrefKey> set) {
        this.f8567c = context;
        this.f8566b = secureContextHelper;
        Integer.valueOf(set.size());
        if (!set.isEmpty()) {
            fbSharedPreferences.a(set, this.f8568d);
        }
    }

    public void init() {
        m8816b(this);
    }

    public static void m8816b(NewPhotoBroadcastReceiverInitializer newPhotoBroadcastReceiverInitializer) {
        newPhotoBroadcastReceiverInitializer.f8566b.c(NewPhotoIntentService.m11602a(newPhotoBroadcastReceiverInitializer.f8567c), newPhotoBroadcastReceiverInitializer.f8567c);
    }
}
