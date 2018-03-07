package com.facebook.platform.webdialogs.bridgeapi;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.util.PlatformBundleToJSONConverter;
import com.facebook.platform.webdialogs.PlatformWebDialogsFragment;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: locationPingDelete */
public class PlatformWebDialogsCloseBridgeApiFactory extends AbstractPlatformWebDialogsBridgeApiFactory {
    private static volatile PlatformWebDialogsCloseBridgeApiFactory f8539b;
    private PlatformBundleToJSONConverter f8540a;

    /* compiled from: locationPingDelete */
    public class Api extends PlatformWebDialogsBridgeApi {
        private PlatformBundleToJSONConverter f8538a;

        public final void mo371a(PlatformWebDialogsFragment platformWebDialogsFragment, PlatformWebDialogsFragment platformWebDialogsFragment2) {
            JSONObject jSONObject = this.f8536a;
            Preconditions.checkNotNull(jSONObject);
            Bundle a = this.f8538a.a(jSONObject);
            Bundle bundle = a.getBundle("error");
            Object obj = bundle == null ? 1 : null;
            if (obj != null) {
                bundle = a.getBundle("results");
                if (bundle == null) {
                    bundle = new Bundle();
                }
            }
            int i = -1;
            String str = "platform_webview_finished";
            if (obj == null) {
                i = 0;
            }
            PlatformWebDialogsFragment.m8402a(platformWebDialogsFragment, str);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            PlatformWebDialogsFragment.m8400a(platformWebDialogsFragment, i, intent);
            platformWebDialogsFragment2.m8407a((PlatformWebDialogsBridgeApi) this, null);
        }

        public Api(PlatformBundleToJSONConverter platformBundleToJSONConverter, JSONObject jSONObject) {
            super(jSONObject);
            this.f8538a = platformBundleToJSONConverter;
        }
    }

    public static com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsCloseBridgeApiFactory m8445a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8539b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsCloseBridgeApiFactory.class;
        monitor-enter(r1);
        r0 = f8539b;	 Catch:{ all -> 0x003a }
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
        r0 = m8446b(r0);	 Catch:{ all -> 0x0035 }
        f8539b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8539b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsCloseBridgeApiFactory.a(com.facebook.inject.InjectorLike):com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsCloseBridgeApiFactory");
    }

    private static PlatformWebDialogsCloseBridgeApiFactory m8446b(InjectorLike injectorLike) {
        return new PlatformWebDialogsCloseBridgeApiFactory(PlatformBundleToJSONConverter.a(injectorLike));
    }

    @Inject
    public PlatformWebDialogsCloseBridgeApiFactory(PlatformBundleToJSONConverter platformBundleToJSONConverter) {
        this.f8540a = platformBundleToJSONConverter;
    }

    public final PlatformWebDialogsBridgeApi mo372a(JSONObject jSONObject) {
        return new Api(this.f8540a, jSONObject);
    }

    public final String mo373a() {
        return "close";
    }

    public final String mo374b() {
        return StringFormatUtil.formatStrLocaleSafe("function(results,error){bridge('%s',{'results':results,'error':error});}", mo373a());
    }
}
