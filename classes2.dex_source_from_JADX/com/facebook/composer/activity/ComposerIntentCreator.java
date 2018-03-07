package com.facebook.composer.activity;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.savedsession.ComposerSavedSession;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.model.TargetType;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: phprof_user */
public class ComposerIntentCreator {
    private static volatile ComposerIntentCreator f9868b;
    private final AbstractFbErrorReporter f9869a;

    public static com.facebook.composer.activity.ComposerIntentCreator m14904a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9868b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.activity.ComposerIntentCreator.class;
        monitor-enter(r1);
        r0 = f9868b;	 Catch:{ all -> 0x003a }
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
        r0 = m14906b(r0);	 Catch:{ all -> 0x0035 }
        f9868b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9868b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.activity.ComposerIntentCreator.a(com.facebook.inject.InjectorLike):com.facebook.composer.activity.ComposerIntentCreator");
    }

    private static ComposerIntentCreator m14906b(InjectorLike injectorLike) {
        return new ComposerIntentCreator(FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public ComposerIntentCreator(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9869a = abstractFbErrorReporter;
    }

    public final Intent m14908a(@Nullable String str, ComposerConfiguration composerConfiguration, Context context) {
        if (str == null) {
            str = SafeUUIDGenerator.m2795a().toString();
        }
        if (composerConfiguration.getInitialTargetData().targetType == TargetType.OTHER) {
            this.f9869a.m2340a("composer_no_target_type", "Composer target data does not have a valid target type specified");
        }
        Intent intent = new Intent(context, ComposerActivity.class);
        if (ContextUtils.m2500a(context, Service.class) != null) {
            intent.addFlags(268435456);
        }
        intent.addFlags(131072);
        intent.putExtra("extra_composer_internal_session_id", str);
        intent.putExtra("extra_composer_configuration", composerConfiguration);
        m14905a(intent, composerConfiguration);
        return intent;
    }

    public final Intent m14907a(ComposerSavedSession composerSavedSession, Context context) {
        Preconditions.checkNotNull(composerSavedSession.configuration, "ComposerSavedSession must always contain a configuration");
        Intent intent = new Intent(context, ComposerActivity.class);
        intent.putExtra("extra_composer_saved_session", composerSavedSession);
        m14905a(intent, composerSavedSession.configuration);
        return intent;
    }

    private static void m14905a(Intent intent, ComposerConfiguration composerConfiguration) {
        if (composerConfiguration.getInitialPageData() != null && composerConfiguration.getInitialPageData().getPostAsPageViewerContext() != null) {
            intent.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", composerConfiguration.getInitialPageData().getPostAsPageViewerContext());
        }
    }
}
