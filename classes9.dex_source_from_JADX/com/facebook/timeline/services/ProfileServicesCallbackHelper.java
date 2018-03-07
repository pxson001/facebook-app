package com.facebook.timeline.services;

import android.content.Context;
import android.widget.Toast;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.friends.protocol.PokeUserMethod.PokeError;
import com.facebook.http.protocol.ApiErrorResult;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Singleton;

@Singleton
/* compiled from: unavailable_attachment */
public class ProfileServicesCallbackHelper {
    private static volatile ProfileServicesCallbackHelper f1125a;

    public static com.facebook.timeline.services.ProfileServicesCallbackHelper m1196a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1125a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.timeline.services.ProfileServicesCallbackHelper.class;
        monitor-enter(r1);
        r0 = f1125a;	 Catch:{ all -> 0x0039 }
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
        r0 = m1195a();	 Catch:{ all -> 0x0034 }
        f1125a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1125a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.services.ProfileServicesCallbackHelper.a(com.facebook.inject.InjectorLike):com.facebook.timeline.services.ProfileServicesCallbackHelper");
    }

    private static ProfileServicesCallbackHelper m1195a() {
        return new ProfileServicesCallbackHelper();
    }

    public final FutureCallback<Void> m1197a(final Context context, final String str) {
        return new FutureCallback<Void>(this) {
            final /* synthetic */ ProfileServicesCallbackHelper f1124c;

            public void onSuccess(Object obj) {
                Toast.makeText(context, StringLocaleUtil.a(context.getResources().getString(2131234963), new Object[]{str}), 1).show();
            }

            public void onFailure(Throwable th) {
                String string = context.getResources().getString(2131234964);
                try {
                    String string2;
                    if (((ApiErrorResult) ((ServiceException) th).b().g().get("result")).a() == PokeError.API_EC_POKE_OUTSTANDING.getErrorCode()) {
                        string2 = context.getResources().getString(2131234965);
                    } else {
                        string2 = string;
                    }
                    string = string2;
                } catch (ClassCastException e) {
                } catch (NullPointerException e2) {
                }
                Toast.makeText(context, StringLocaleUtil.a(string, new Object[]{str}), 1).show();
            }
        };
    }
}
