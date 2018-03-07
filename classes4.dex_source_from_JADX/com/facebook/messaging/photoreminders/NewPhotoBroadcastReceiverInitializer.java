package com.facebook.messaging.photoreminders;

import com.facebook.common.init.INeedInit;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.photoreminders.interfaces.PhotoSuggestionManager;
import com.facebook.messaging.photoreminders.omnistore.PhotoRemindersOmnistoreUtil;
import com.facebook.messaging.photoreminders.stub.PhotoSuggestionManagerMethodAutoProvider;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mResultAction */
public class NewPhotoBroadcastReceiverInitializer implements INeedInit {
    public static final String f8571a = NewPhotoBroadcastReceiverInitializer.class.getSimpleName();
    private static volatile NewPhotoBroadcastReceiverInitializer f8572e;
    public final PhotoRemindersGatingUtil f8573b;
    public final PhotoRemindersOmnistoreUtil f8574c;
    private final OnSharedPreferenceChangeListener f8575d = new C04131(this);

    /* compiled from: mResultAction */
    class C04131 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ NewPhotoBroadcastReceiverInitializer f8592a;

        public final void m8844a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            String str = NewPhotoBroadcastReceiverInitializer.f8571a;
            TriState b = fbSharedPreferences.b(MessagingPrefKeys.az);
            if (b != TriState.UNSET) {
                this.f8592a.f8574c.m8842a(b.asBoolean());
                if (b.asBoolean()) {
                    this.f8592a.f8573b.m8822a(true);
                }
            }
        }

        C04131(NewPhotoBroadcastReceiverInitializer newPhotoBroadcastReceiverInitializer) {
            this.f8592a = newPhotoBroadcastReceiverInitializer;
        }
    }

    public static com.facebook.messaging.photoreminders.NewPhotoBroadcastReceiverInitializer m8818a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8572e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.photoreminders.NewPhotoBroadcastReceiverInitializer.class;
        monitor-enter(r1);
        r0 = f8572e;	 Catch:{ all -> 0x003a }
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
        r0 = m8819b(r0);	 Catch:{ all -> 0x0035 }
        f8572e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8572e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.photoreminders.NewPhotoBroadcastReceiverInitializer.a(com.facebook.inject.InjectorLike):com.facebook.messaging.photoreminders.NewPhotoBroadcastReceiverInitializer");
    }

    private static NewPhotoBroadcastReceiverInitializer m8819b(InjectorLike injectorLike) {
        return new NewPhotoBroadcastReceiverInitializer(PhotoSuggestionManagerMethodAutoProvider.m8820a(injectorLike), PhotoRemindersGatingUtil.m8821b(injectorLike), PhotoRemindersOmnistoreUtil.m8840b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public NewPhotoBroadcastReceiverInitializer(PhotoSuggestionManager photoSuggestionManager, PhotoRemindersGatingUtil photoRemindersGatingUtil, PhotoRemindersOmnistoreUtil photoRemindersOmnistoreUtil, FbSharedPreferences fbSharedPreferences) {
        this.f8573b = photoRemindersGatingUtil;
        this.f8574c = photoRemindersOmnistoreUtil;
        if (photoSuggestionManager != null) {
            fbSharedPreferences.a(MessagingPrefKeys.az, this.f8575d);
        }
    }

    public void init() {
        this.f8573b.m8823a();
        if (this.f8573b.m8827e()) {
            this.f8573b.m8822a(true);
        }
    }
}
