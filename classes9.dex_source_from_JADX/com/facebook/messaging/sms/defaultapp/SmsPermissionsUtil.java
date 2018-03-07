package com.facebook.messaging.sms.defaultapp;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.analytics.SmsCallerContext;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.facebook.orca.media.upload.PROCESS_MEDIA_TOTAL_PROGRESS */
public class SmsPermissionsUtil {
    public static final String[] f17613a = new String[]{"android.permission.READ_SMS", "android.permission.READ_CONTACTS"};
    private static volatile SmsPermissionsUtil f17614g;
    private final Context f17615b;
    public final RuntimePermissionsUtil f17616c;
    private final SmsDefaultAppManager f17617d;
    private final FbSharedPreferences f17618e;
    private final SmsIntegrationState f17619f;

    public static com.facebook.messaging.sms.defaultapp.SmsPermissionsUtil m17591a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17614g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sms.defaultapp.SmsPermissionsUtil.class;
        monitor-enter(r1);
        r0 = f17614g;	 Catch:{ all -> 0x003a }
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
        r0 = m17592b(r0);	 Catch:{ all -> 0x0035 }
        f17614g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17614g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.defaultapp.SmsPermissionsUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.defaultapp.SmsPermissionsUtil");
    }

    private static SmsPermissionsUtil m17592b(InjectorLike injectorLike) {
        return new SmsPermissionsUtil((Context) injectorLike.getInstance(Context.class), RuntimePermissionsUtil.b(injectorLike), SmsDefaultAppManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SmsIntegrationState.a(injectorLike));
    }

    @Inject
    public SmsPermissionsUtil(Context context, RuntimePermissionsUtil runtimePermissionsUtil, SmsDefaultAppManager smsDefaultAppManager, FbSharedPreferences fbSharedPreferences, SmsIntegrationState smsIntegrationState) {
        this.f17615b = context.getApplicationContext();
        this.f17616c = runtimePermissionsUtil;
        this.f17617d = smsDefaultAppManager;
        this.f17618e = fbSharedPreferences;
        this.f17619f = smsIntegrationState;
    }

    public final void m17593a() {
        if (this.f17619f.a() && !m17594b()) {
            this.f17617d.a(SmsCallerContext.PERMISSION_CHANGE, this.f17615b, false);
            this.f17618e.edit().a(SmsPrefKeys.b).commit();
        }
    }

    public final boolean m17594b() {
        return this.f17616c.a(f17613a);
    }
}
