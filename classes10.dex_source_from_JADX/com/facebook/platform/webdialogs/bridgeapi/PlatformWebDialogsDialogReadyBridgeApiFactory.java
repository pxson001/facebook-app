package com.facebook.platform.webdialogs.bridgeapi;

import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.util.PlatformBundleToJSONConverter;
import com.facebook.platform.webdialogs.PlatformWebDialogsFragment;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: location should not be null */
public class PlatformWebDialogsDialogReadyBridgeApiFactory extends AbstractPlatformWebDialogsBridgeApiFactory {
    private static volatile PlatformWebDialogsDialogReadyBridgeApiFactory f8543b;
    private PlatformBundleToJSONConverter f8544a;

    /* compiled from: location should not be null */
    public class Api extends PlatformWebDialogsBridgeApi {
        private PlatformBundleToJSONConverter f8542a;

        public Api(PlatformBundleToJSONConverter platformBundleToJSONConverter, JSONObject jSONObject) {
            super(jSONObject);
            this.f8542a = platformBundleToJSONConverter;
        }

        public final void mo371a(PlatformWebDialogsFragment platformWebDialogsFragment, PlatformWebDialogsFragment platformWebDialogsFragment2) {
            boolean z = false;
            JSONObject jSONObject = this.f8536a;
            if (jSONObject != null) {
                z = this.f8542a.a(jSONObject).getBoolean("isDialogLoadingUI", false);
            }
            platformWebDialogsFragment.ar = true;
            PlatformWebDialogsFragment.m8402a(platformWebDialogsFragment, "platform_webview_dialog_ready");
            platformWebDialogsFragment.ao.setVisibility(0);
            if (platformWebDialogsFragment.an != null) {
                platformWebDialogsFragment.an.setVisibility(8);
            }
            platformWebDialogsFragment.f8508g.m8421a(platformWebDialogsFragment.f8510i, z);
            platformWebDialogsFragment2.m8407a((PlatformWebDialogsBridgeApi) this, null);
        }
    }

    public static com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsDialogReadyBridgeApiFactory m8456a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8543b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsDialogReadyBridgeApiFactory.class;
        monitor-enter(r1);
        r0 = f8543b;	 Catch:{ all -> 0x003a }
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
        r0 = m8457b(r0);	 Catch:{ all -> 0x0035 }
        f8543b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8543b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsDialogReadyBridgeApiFactory.a(com.facebook.inject.InjectorLike):com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsDialogReadyBridgeApiFactory");
    }

    private static PlatformWebDialogsDialogReadyBridgeApiFactory m8457b(InjectorLike injectorLike) {
        return new PlatformWebDialogsDialogReadyBridgeApiFactory(PlatformBundleToJSONConverter.a(injectorLike));
    }

    @Inject
    public PlatformWebDialogsDialogReadyBridgeApiFactory(PlatformBundleToJSONConverter platformBundleToJSONConverter) {
        this.f8544a = platformBundleToJSONConverter;
    }

    public final PlatformWebDialogsBridgeApi mo372a(JSONObject jSONObject) {
        return new Api(this.f8544a, jSONObject);
    }

    public final String mo373a() {
        return "dialogready";
    }
}
