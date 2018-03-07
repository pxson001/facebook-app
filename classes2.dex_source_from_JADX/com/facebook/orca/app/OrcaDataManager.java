package com.facebook.orca.app;

import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.common.init.INeedInit;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.debug.log.BLog;
import com.facebook.gk.internal.GkPrefKeys;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.chatheads.prefs.ChatHeadsPrefKeys;
import com.facebook.messaging.emoji.EmojiPrefKeys;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.stickers.preferences.StickerPrefKeys;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: time_elapsed_since_newsfeed_fragment_active */
public class OrcaDataManager implements INeedInit {
    private static final Class<?> f2906a = OrcaDataManager.class;
    public static final Set<PrefKey> f2907f = ImmutableSet.of(MessagingPrefKeys.f2573k, SharedPrefKeys.f990d.m2011a("app_info/"), MessagingPrefKeys.f2552P, ChatHeadsPrefKeys.f2594f, EmojiPrefKeys.f2914b, StickerPrefKeys.f2922b, GkPrefKeys.f2940b, GkPrefKeys.f2941c, GkPrefKeys.f2942d, GkPrefKeys.f2943e);
    private static volatile OrcaDataManager f2908g;
    private final Lazy<LoggedInUserAuthDataStore> f2909b;
    public final FbSharedPreferences f2910c;
    public final MyAuthComponent f2911d = new MyAuthComponent(this);
    private final Lazy<FbAppType> f2912e;

    /* compiled from: time_elapsed_since_newsfeed_fragment_active */
    public class MyAuthComponent extends AbstractAuthComponent {
        final /* synthetic */ OrcaDataManager f2945a;

        public MyAuthComponent(OrcaDataManager orcaDataManager) {
            this.f2945a = orcaDataManager;
        }

        public final void mo690e() {
            this.f2945a.f2910c.mo282a(OrcaDataManager.f2907f);
        }
    }

    public static com.facebook.orca.app.OrcaDataManager m4902a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2908g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.app.OrcaDataManager.class;
        monitor-enter(r1);
        r0 = f2908g;	 Catch:{ all -> 0x003a }
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
        r0 = m4903b(r0);	 Catch:{ all -> 0x0035 }
        f2908g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2908g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.app.OrcaDataManager.a(com.facebook.inject.InjectorLike):com.facebook.orca.app.OrcaDataManager");
    }

    private static OrcaDataManager m4903b(InjectorLike injectorLike) {
        return new OrcaDataManager(IdBasedSingletonScopeProvider.m1810b(injectorLike, 339), FbSharedPreferencesImpl.m1826a(injectorLike), injectorLike.getLazy(FbAppType.class));
    }

    @Inject
    public OrcaDataManager(Lazy<LoggedInUserAuthDataStore> lazy, FbSharedPreferences fbSharedPreferences, Lazy<FbAppType> lazy2) {
        this.f2909b = lazy;
        this.f2910c = fbSharedPreferences;
        this.f2912e = lazy2;
    }

    public void init() {
        TracerDetour.a("OrcaDataManager.init", 464771598);
        try {
            if (BLog.b(2)) {
                this.f2910c.mo295d();
            }
            if (this.f2910c.mo276a(AuthPrefKeys.f2963r, -1) < 3) {
                Integer.valueOf(3);
                if (((FbAppType) this.f2912e.get()).h() != Product.FB4A && (this.f2909b.get() instanceof LoggedInUserSessionManager)) {
                    ((LoggedInUserSessionManager) this.f2909b.get()).m2528g();
                }
                Editor edit = this.f2910c.edit();
                edit.mo1274a(AuthPrefKeys.f2963r, 3);
                edit.commit();
            }
            if (this.f2910c.mo285a(MessagingPrefKeys.f2550N) && this.f2910c.mo278a(MessagingPrefKeys.f2548L, null) == null) {
                String a = this.f2910c.mo278a(MessagingPrefKeys.f2547K, null);
                if (a != null) {
                    Editor edit2 = this.f2910c.edit();
                    edit2.mo1276a(MessagingPrefKeys.f2548L, a);
                    edit2.mo1271a(MessagingPrefKeys.f2550N);
                    edit2.mo1271a(MessagingPrefKeys.f2547K);
                    edit2.commit();
                }
            }
            TracerDetour.a(-1200393068);
        } catch (Throwable th) {
            TracerDetour.a(-1052634180);
        }
    }
}
