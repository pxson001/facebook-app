package com.facebook.timeline.refresher.launcher;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.refresher.ProfileRefresherActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: unpinThread */
public class ProfileRefresherLauncher {
    private static volatile ProfileRefresherLauncher f1073c;
    private final SecureContextHelper f1074a;
    private final ProfileRefresherIntentCreator f1075b;

    public static com.facebook.timeline.refresher.launcher.ProfileRefresherLauncher m1065a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1073c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.refresher.launcher.ProfileRefresherLauncher.class;
        monitor-enter(r1);
        r0 = f1073c;	 Catch:{ all -> 0x003a }
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
        r0 = m1066b(r0);	 Catch:{ all -> 0x0035 }
        f1073c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1073c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.refresher.launcher.ProfileRefresherLauncher.a(com.facebook.inject.InjectorLike):com.facebook.timeline.refresher.launcher.ProfileRefresherLauncher");
    }

    private static ProfileRefresherLauncher m1066b(InjectorLike injectorLike) {
        return new ProfileRefresherLauncher((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ProfileRefresherIntentCreator.m1064a(injectorLike));
    }

    @Inject
    public ProfileRefresherLauncher(SecureContextHelper secureContextHelper, ProfileRefresherIntentCreator profileRefresherIntentCreator) {
        this.f1074a = secureContextHelper;
        this.f1075b = profileRefresherIntentCreator;
    }

    public final void m1067a(ProfileRefresherConfiguration profileRefresherConfiguration, Activity activity) {
        SecureContextHelper secureContextHelper = this.f1074a;
        Intent component = new Intent().setComponent(new ComponentName(activity, ProfileRefresherActivity.class));
        component.putExtra("name", profileRefresherConfiguration.f1066a);
        component.putExtra("profile_id", profileRefresherConfiguration.f1067b);
        component.putExtra("profile_pic_uri", profileRefresherConfiguration.f1068c);
        component.putExtra("cover_photo_high_res_uri", profileRefresherConfiguration.f1069d);
        component.putExtra("is_refresher", profileRefresherConfiguration.f1070e);
        FlatBufferModelHelper.a(component, "post_item_privacy", profileRefresherConfiguration.f1071f);
        secureContextHelper.a(component, 22243, activity);
    }
}
