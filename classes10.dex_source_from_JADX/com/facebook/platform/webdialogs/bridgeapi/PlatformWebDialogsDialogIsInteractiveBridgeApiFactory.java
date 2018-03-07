package com.facebook.platform.webdialogs.bridgeapi;

import com.facebook.platform.webdialogs.PlatformWebDialogsFragment;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: locationPing */
public class PlatformWebDialogsDialogIsInteractiveBridgeApiFactory extends AbstractPlatformWebDialogsBridgeApiFactory {
    private static volatile PlatformWebDialogsDialogIsInteractiveBridgeApiFactory f8541a;

    /* compiled from: locationPing */
    public class Api extends PlatformWebDialogsBridgeApi {
        public Api(JSONObject jSONObject) {
            super(jSONObject);
        }

        public final void mo371a(PlatformWebDialogsFragment platformWebDialogsFragment, PlatformWebDialogsFragment platformWebDialogsFragment2) {
            platformWebDialogsFragment.f8508g.m8432k();
            platformWebDialogsFragment2.m8407a((PlatformWebDialogsBridgeApi) this, null);
        }
    }

    public static com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsDialogIsInteractiveBridgeApiFactory m8451a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f8541a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsDialogIsInteractiveBridgeApiFactory.class;
        monitor-enter(r1);
        r0 = f8541a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m8452c();	 Catch:{ all -> 0x0034 }
        f8541a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f8541a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsDialogIsInteractiveBridgeApiFactory.a(com.facebook.inject.InjectorLike):com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsDialogIsInteractiveBridgeApiFactory");
    }

    private static PlatformWebDialogsDialogIsInteractiveBridgeApiFactory m8452c() {
        return new PlatformWebDialogsDialogIsInteractiveBridgeApiFactory();
    }

    public final PlatformWebDialogsBridgeApi mo372a(JSONObject jSONObject) {
        return new Api(jSONObject);
    }

    public final String mo373a() {
        return "dialogIsInteractive";
    }
}
