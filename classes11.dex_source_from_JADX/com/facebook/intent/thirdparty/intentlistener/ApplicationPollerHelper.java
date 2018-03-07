package com.facebook.intent.thirdparty.intentlistener;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.feed.platformads.ApplicationPoller;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper.FbrpcIntent;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: VideoTabAllVideosOptimizedFetchingFragment */
public class ApplicationPollerHelper {
    private static volatile ApplicationPollerHelper f10388b;
    ApplicationPoller f10389a;

    public static com.facebook.intent.thirdparty.intentlistener.ApplicationPollerHelper m10782a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10388b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.intent.thirdparty.intentlistener.ApplicationPollerHelper.class;
        monitor-enter(r1);
        r0 = f10388b;	 Catch:{ all -> 0x003a }
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
        r0 = m10783b(r0);	 Catch:{ all -> 0x0035 }
        f10388b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10388b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.intent.thirdparty.intentlistener.ApplicationPollerHelper.a(com.facebook.inject.InjectorLike):com.facebook.intent.thirdparty.intentlistener.ApplicationPollerHelper");
    }

    private static ApplicationPollerHelper m10783b(InjectorLike injectorLike) {
        return new ApplicationPollerHelper(ApplicationPoller.a(injectorLike));
    }

    @Inject
    public ApplicationPollerHelper(ApplicationPoller applicationPoller) {
        this.f10389a = applicationPoller;
    }

    public final void m10784a(Intent intent, @Nullable Map<String, Object> map) {
        if (this.f10389a != null) {
            String stringExtra = intent.getStringExtra("application_link_type");
            if (stringExtra != null && stringExtra.equals("app_store")) {
                Object stringExtra2 = intent.getStringExtra("package_name");
                long longExtra = intent.getLongExtra("app_id", 0);
                ArrayNode arrayNode = map == null ? null : (ArrayNode) map.get("tracking");
                Bundle extras = intent.getExtras();
                boolean z = false;
                if (extras != null) {
                    z = extras.getBoolean("show_beeper");
                }
                if (!TextUtils.isEmpty(stringExtra2) && longExtra != 0) {
                    String dataString = intent.getDataString();
                    FbrpcIntent fbrpcIntent = (FbrpcIntent) intent;
                    if (fbrpcIntent != null) {
                        Uri uri = fbrpcIntent.a;
                        if (uri != null) {
                            dataString = uri.toString();
                        }
                    }
                    this.f10389a.a(stringExtra2, longExtra, arrayNode, dataString, z);
                }
            }
        }
    }
}
