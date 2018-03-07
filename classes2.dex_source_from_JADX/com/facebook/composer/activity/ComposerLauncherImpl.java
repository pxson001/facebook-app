package com.facebook.composer.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import com.facebook.composer.analytics.ComposerPerformanceLogger;
import com.facebook.composer.savedsession.ComposerSavedSession;
import com.facebook.composer.savedsession.ComposerSavedSessionStore;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pi */
public class ComposerLauncherImpl implements ComposerLauncher {
    private static volatile ComposerLauncherImpl f9863e;
    private final SecureContextHelper f9864a;
    private final ComposerIntentCreator f9865b;
    private final ComposerPerformanceLogger f9866c;
    private final ComposerSavedSessionStore f9867d;

    public static com.facebook.composer.activity.ComposerLauncherImpl m14892a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9863e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.activity.ComposerLauncherImpl.class;
        monitor-enter(r1);
        r0 = f9863e;	 Catch:{ all -> 0x003a }
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
        r0 = m14893b(r0);	 Catch:{ all -> 0x0035 }
        f9863e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9863e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.activity.ComposerLauncherImpl.a(com.facebook.inject.InjectorLike):com.facebook.composer.activity.ComposerLauncherImpl");
    }

    private static ComposerLauncherImpl m14893b(InjectorLike injectorLike) {
        return new ComposerLauncherImpl(DefaultSecureContextHelper.m4636a(injectorLike), ComposerIntentCreator.m14904a(injectorLike), ComposerPerformanceLogger.m14909a(injectorLike), ComposerSavedSessionStore.m4724a(injectorLike));
    }

    @Inject
    public ComposerLauncherImpl(SecureContextHelper secureContextHelper, ComposerIntentCreator composerIntentCreator, ComposerPerformanceLogger composerPerformanceLogger, ComposerSavedSessionStore composerSavedSessionStore) {
        this.f9864a = secureContextHelper;
        this.f9865b = composerIntentCreator;
        this.f9866c = composerPerformanceLogger;
        this.f9867d = composerSavedSessionStore;
    }

    public final void mo1957a(@Nullable String str, ComposerConfiguration composerConfiguration, Context context) {
        this.f9866c.m14913a(context.getClass().getSimpleName(), "ComposerLauncherImpl");
        this.f9864a.mo662a(this.f9865b.m14908a(str, composerConfiguration, context), context);
    }

    public final void mo1955a(@Nullable String str, ComposerConfiguration composerConfiguration, int i, Activity activity) {
        Preconditions.checkNotNull(activity);
        this.f9866c.m14913a(activity.getLocalClassName(), "ComposerLauncherImpl");
        this.f9864a.mo660a(this.f9865b.m14908a(str, composerConfiguration, activity), i, activity);
    }

    public final void mo1956a(@Nullable String str, ComposerConfiguration composerConfiguration, int i, Fragment fragment) {
        this.f9866c.m14913a(fragment.getClass().getSimpleName(), "ComposerLauncherImpl");
        this.f9864a.mo661a(this.f9865b.m14908a(str, composerConfiguration, fragment.getContext()), i, fragment);
    }

    public final void mo1953a(int i, Activity activity) {
        Optional a = this.f9867d.m4727a();
        if (a.isPresent()) {
            this.f9866c.m14913a(activity.getLocalClassName(), "ComposerLauncherImpl");
            this.f9864a.mo660a(this.f9865b.m14907a((ComposerSavedSession) a.get(), (Context) activity), i, activity);
        }
    }

    public final void mo1954a(int i, Fragment fragment) {
        Optional a = this.f9867d.m4727a();
        if (a.isPresent()) {
            this.f9866c.m14913a(fragment.getClass().getSimpleName(), "ComposerLauncherImpl");
            this.f9864a.mo661a(this.f9865b.m14907a((ComposerSavedSession) a.get(), fragment.getContext()), i, fragment);
        }
    }
}
