package com.facebook.platform.webdialogs.bridgeapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.PlatformConstants;
import com.facebook.platform.common.action.PlatformAppCall;
import com.facebook.platform.common.activity.PlatformWrapperActivity;
import com.facebook.platform.common.util.PlatformBundleToJSONConverter;
import com.facebook.platform.webdialogs.PlatformWebDialogsFragment;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: localsell_message */
public class PlatformWebDialogsOpenDialogBridgeApiFactory extends AbstractPlatformWebDialogsBridgeApiFactory {
    private static volatile PlatformWebDialogsOpenDialogBridgeApiFactory f8546b;
    private PlatformBundleToJSONConverter f8547a;

    /* compiled from: localsell_message */
    public class Api extends PlatformWebDialogsBridgeApi {
        public PlatformBundleToJSONConverter f8545a;

        public Api(PlatformBundleToJSONConverter platformBundleToJSONConverter, JSONObject jSONObject) {
            super(jSONObject);
            this.f8545a = platformBundleToJSONConverter;
        }

        public final void mo371a(PlatformWebDialogsFragment platformWebDialogsFragment, PlatformWebDialogsFragment platformWebDialogsFragment2) {
            int i = 0;
            Bundle a = this.f8545a.a(this.f8536a);
            PlatformAppCall platformAppCall = platformWebDialogsFragment.f8510i;
            if (!(a == null || platformAppCall == null)) {
                String str;
                if ("share".equalsIgnoreCase(a.getString("method"))) {
                    str = "com.facebook.platform.action.request.FEED_DIALOG";
                } else {
                    str = null;
                }
                String str2 = str;
                a = a.getBundle("methodArgs");
                if (!(Strings.isNullOrEmpty(str2) || a == null)) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", ((Integer) PlatformConstants.a.get(0)).intValue());
                    bundle.putString("com.facebook.platform.protocol.PROTOCOL_ACTION", str2);
                    bundle.putString("com.facebook.platform.extra.APPLICATION_ID", platformAppCall.e);
                    bundle.putBundle("com.facebook.platform.protocol.METHOD_ARGS", a);
                    bundle.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", new Bundle());
                    platformWebDialogsFragment.aq = this;
                    FragmentActivity o = platformWebDialogsFragment.o();
                    Intent intent = new Intent(o, PlatformWrapperActivity.class);
                    intent.putExtras(bundle);
                    intent.putExtra("calling_package_key", platformWebDialogsFragment.f8510i.d);
                    platformWebDialogsFragment.f8506e.a(intent, 100, o);
                    i = 1;
                }
            }
            if (i == 0) {
                platformWebDialogsFragment2.m8407a((PlatformWebDialogsBridgeApi) this, null);
            }
        }
    }

    public static com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsOpenDialogBridgeApiFactory m8461a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8546b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsOpenDialogBridgeApiFactory.class;
        monitor-enter(r1);
        r0 = f8546b;	 Catch:{ all -> 0x003a }
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
        r0 = m8462b(r0);	 Catch:{ all -> 0x0035 }
        f8546b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8546b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsOpenDialogBridgeApiFactory.a(com.facebook.inject.InjectorLike):com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsOpenDialogBridgeApiFactory");
    }

    private static PlatformWebDialogsOpenDialogBridgeApiFactory m8462b(InjectorLike injectorLike) {
        return new PlatformWebDialogsOpenDialogBridgeApiFactory(PlatformBundleToJSONConverter.a(injectorLike));
    }

    @Inject
    public PlatformWebDialogsOpenDialogBridgeApiFactory(PlatformBundleToJSONConverter platformBundleToJSONConverter) {
        this.f8547a = platformBundleToJSONConverter;
    }

    public final PlatformWebDialogsBridgeApi mo372a(JSONObject jSONObject) {
        return new Api(this.f8547a, jSONObject);
    }

    public final String mo373a() {
        return "openDialog";
    }
}
