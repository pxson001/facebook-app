package com.facebook.friends.navigator;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.content.event.FbEvent;
import com.facebook.friends.abtest.ExperimentsForFriendsExperimentModule;
import com.facebook.friends.navigator.NavigationEvents.FriendableContactsChangedEvent;
import com.facebook.friends.navigator.NavigationEvents.FriendableContactsFetchedEvent;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: pendingToken */
public class FriendingNavigator {
    private static volatile FriendingNavigator f6742e;
    private final FbSharedPreferences f6743a;
    private final Provider<String> f6744b;
    private final QeAccessor f6745c;
    public final AtomicInteger f6746d = new AtomicInteger(Integer.MAX_VALUE);

    /* compiled from: pendingToken */
    public class FriendableContactsChangedSubscriber extends NavigationEventSubscriber<FriendableContactsChangedEvent> {
        private final FriendingNavigator f6738a;

        public final void m7023b(FbEvent fbEvent) {
            this.f6738a.f6746d.getAndAdd(((FriendableContactsChangedEvent) fbEvent).f6748a);
            FriendingNavigator.m7030b(this.f6738a);
        }

        @Inject
        public FriendableContactsChangedSubscriber(FriendingNavigator friendingNavigator) {
            this.f6738a = friendingNavigator;
        }

        public final Class<FriendableContactsChangedEvent> m7022a() {
            return FriendableContactsChangedEvent.class;
        }
    }

    /* compiled from: pendingToken */
    public class FriendableContactsFetchedSubscriber extends NavigationEventSubscriber<FriendableContactsFetchedEvent> {
        private final FriendingNavigator f6739a;

        public final void m7025b(FbEvent fbEvent) {
            this.f6739a.f6746d.set(((FriendableContactsFetchedEvent) fbEvent).f6749a);
            FriendingNavigator.m7030b(this.f6739a);
        }

        @Inject
        public FriendableContactsFetchedSubscriber(FriendingNavigator friendingNavigator) {
            this.f6739a = friendingNavigator;
        }

        public final Class<FriendableContactsFetchedEvent> m7024a() {
            return FriendableContactsFetchedEvent.class;
        }
    }

    @Singleton
    /* compiled from: pendingToken */
    public class FriendingNavigatorUserDataCleanup implements IHaveUserData {
        private static volatile FriendingNavigatorUserDataCleanup f6740b;
        private final FriendingNavigator f6741a;

        public static com.facebook.friends.navigator.FriendingNavigator.FriendingNavigatorUserDataCleanup m7026a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f6740b;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.friends.navigator.FriendingNavigator.FriendingNavigatorUserDataCleanup.class;
            monitor-enter(r1);
            r0 = f6740b;	 Catch:{ all -> 0x003a }
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
            r0 = m7027b(r0);	 Catch:{ all -> 0x0035 }
            f6740b = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.a(r4);
            r2.c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f6740b;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.friends.navigator.FriendingNavigator.FriendingNavigatorUserDataCleanup.a(com.facebook.inject.InjectorLike):com.facebook.friends.navigator.FriendingNavigator$FriendingNavigatorUserDataCleanup");
        }

        private static FriendingNavigatorUserDataCleanup m7027b(InjectorLike injectorLike) {
            return new FriendingNavigatorUserDataCleanup(FriendingNavigator.m7028a(injectorLike));
        }

        @Inject
        public FriendingNavigatorUserDataCleanup(FriendingNavigator friendingNavigator) {
            this.f6741a = friendingNavigator;
        }

        public void clearUserData() {
            this.f6741a.f6746d.set(Integer.MAX_VALUE);
        }
    }

    public static com.facebook.friends.navigator.FriendingNavigator m7028a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f6742e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friends.navigator.FriendingNavigator.class;
        monitor-enter(r1);
        r0 = f6742e;	 Catch:{ all -> 0x003a }
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
        r0 = m7029b(r0);	 Catch:{ all -> 0x0035 }
        f6742e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6742e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friends.navigator.FriendingNavigator.a(com.facebook.inject.InjectorLike):com.facebook.friends.navigator.FriendingNavigator");
    }

    private static FriendingNavigator m7029b(InjectorLike injectorLike) {
        return new FriendingNavigator((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendingNavigator(FbSharedPreferences fbSharedPreferences, Provider<String> provider, QeAccessor qeAccessor) {
        this.f6743a = fbSharedPreferences;
        this.f6744b = provider;
        this.f6745c = qeAccessor;
        if (this.f6744b.get() != null) {
            this.f6746d.set(this.f6743a.a(GrowthPrefKeys.d((String) this.f6744b.get()), Integer.MAX_VALUE));
        }
    }

    public final boolean m7031a() {
        return this.f6746d.get() > this.f6745c.a(Liveness.Live, ExposureLogging.Off, ExperimentsForFriendsExperimentModule.b, 0);
    }

    public static void m7030b(FriendingNavigator friendingNavigator) {
        if (friendingNavigator.f6744b.get() != null) {
            friendingNavigator.f6743a.edit().a(GrowthPrefKeys.d((String) friendingNavigator.f6744b.get()), friendingNavigator.f6746d.get()).commit();
        }
    }
}
