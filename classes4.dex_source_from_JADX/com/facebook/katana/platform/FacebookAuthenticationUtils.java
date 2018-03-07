package com.facebook.katana.platform;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.provider.legacykeyvalue.UserValuesManager;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sync_reason */
public class FacebookAuthenticationUtils {
    private static final Class<?> f1421a;
    private static final String f1422b;
    private static volatile FacebookAuthenticationUtils f1423d;
    private final AbstractFbErrorReporter f1424c;

    public static com.facebook.katana.platform.FacebookAuthenticationUtils m1661a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1423d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.platform.FacebookAuthenticationUtils.class;
        monitor-enter(r1);
        r0 = f1423d;	 Catch:{ all -> 0x003a }
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
        r0 = m1662b(r0);	 Catch:{ all -> 0x0035 }
        f1423d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1423d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.platform.FacebookAuthenticationUtils.a(com.facebook.inject.InjectorLike):com.facebook.katana.platform.FacebookAuthenticationUtils");
    }

    private static FacebookAuthenticationUtils m1662b(InjectorLike injectorLike) {
        return new FacebookAuthenticationUtils((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    static {
        Class cls = FacebookAuthenticationUtils.class;
        f1421a = cls;
        f1422b = cls.getSimpleName();
    }

    @Inject
    public FacebookAuthenticationUtils(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f1424c = abstractFbErrorReporter;
    }

    public final synchronized Account m1664a(Context context, String str) {
        Account account = null;
        synchronized (this) {
            if (!BuildConstants.g()) {
                Account a = FacebookAuthenticationService.m1124a(context, str);
                if (a == null) {
                    a = new Account(str, "com.facebook.auth.login");
                    try {
                        if (AccountManager.get(context).addAccountExplicitly(a, null, null)) {
                            ContentResolver.setIsSyncable(a, "com.android.contacts", 0);
                            account = a;
                        } else {
                            BLog.b(f1421a, "Unable to create account for %s", new Object[]{str});
                        }
                    } catch (Throwable e) {
                        if (BuildConstants.e()) {
                            BLog.b(f1421a, e, "Unable to create account for %s. This may be because you installed both product and beta versions of Facebook application. Before using the beta version, make sure to uninstall other Facebook installations. In addition, make sure to DISABLE the Facebook application on devices  that come with Facebook pre-installed. ", new Object[]{str});
                        } else {
                            this.f1424c.b(f1422b, "SecurityException trying to create an account", e);
                        }
                    }
                } else {
                    account = a;
                }
                UserValuesManager.m11488a(context, str);
            }
        }
        return account;
    }

    public static void m1663b(Context context, String str) {
        if (!BuildConstants.j) {
            AccountManager accountManager = AccountManager.get(context);
            Account[] accountsByType = accountManager.getAccountsByType("com.facebook.auth.login");
            String b = UserValuesManager.m11492b(context);
            int length = accountsByType.length;
            for (int i = 0; i < length; i++) {
                if (!accountsByType[i].name.equals(str)) {
                    if (accountsByType[i].name.equals(b)) {
                        UserValuesManager.m11488a(context, null);
                    }
                    accountManager.removeAccount(accountsByType[i], null, null);
                }
            }
        }
    }
}
