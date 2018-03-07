package com.facebook.photos.creativecam.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.creativecam.CreativeCamLaunchConfig;
import com.facebook.ipc.creativecam.CreativeCamLauncher;
import com.facebook.productionprompts.logging.PromptAnalytics;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mqtt/ */
public class CreativeCamLauncherImpl implements CreativeCamLauncher {
    private static volatile CreativeCamLauncherImpl f13272b;
    private final SecureContextHelper f13273a;

    public static com.facebook.photos.creativecam.activity.CreativeCamLauncherImpl m19535a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13272b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.creativecam.activity.CreativeCamLauncherImpl.class;
        monitor-enter(r1);
        r0 = f13272b;	 Catch:{ all -> 0x003a }
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
        r0 = m19537b(r0);	 Catch:{ all -> 0x0035 }
        f13272b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13272b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.creativecam.activity.CreativeCamLauncherImpl.a(com.facebook.inject.InjectorLike):com.facebook.photos.creativecam.activity.CreativeCamLauncherImpl");
    }

    private static CreativeCamLauncherImpl m19537b(InjectorLike injectorLike) {
        return new CreativeCamLauncherImpl(DefaultSecureContextHelper.m4636a(injectorLike));
    }

    @Inject
    public CreativeCamLauncherImpl(SecureContextHelper secureContextHelper) {
        this.f13273a = secureContextHelper;
    }

    public final CreativeEditingCameraFragment mo2609a(CreativeCamLaunchConfig creativeCamLaunchConfig, String str, @Nullable PromptAnalytics promptAnalytics) {
        Intent intent = new Intent();
        m19536a(intent, creativeCamLaunchConfig, str, promptAnalytics);
        return CreativeEditingCameraFragment.b(intent);
    }

    public final void mo2610a(Activity activity, int i, CreativeCamLaunchConfig creativeCamLaunchConfig, String str, @Nullable PromptAnalytics promptAnalytics) {
        Intent intent = new Intent(activity, CreativeEditingCameraActivity.class);
        intent.addFlags(131072);
        m19536a(intent, creativeCamLaunchConfig, str, promptAnalytics);
        this.f13273a.mo660a(intent, i, activity);
    }

    public final void mo2611a(Fragment fragment, int i, CreativeCamLaunchConfig creativeCamLaunchConfig, String str, @Nullable PromptAnalytics promptAnalytics) {
        Intent intent = new Intent(fragment.getContext(), CreativeEditingCameraActivity.class);
        intent.addFlags(131072);
        m19536a(intent, creativeCamLaunchConfig, str, promptAnalytics);
        this.f13273a.mo661a(intent, i, fragment);
    }

    private static void m19536a(Intent intent, CreativeCamLaunchConfig creativeCamLaunchConfig, String str, @Nullable PromptAnalytics promptAnalytics) {
        intent.putExtra("extra_creativecam_launch_configuration", creativeCamLaunchConfig);
        intent.putExtra("extra_creativecam_composer_session_id", str);
        intent.putExtra("extra_creativecam_prompt_entrypoint_analytics", promptAnalytics);
    }
}
