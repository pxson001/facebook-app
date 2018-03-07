package com.facebook.messaging.sms;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.common.Constants.MmsSmsErrorType;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.base.Strings;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: composer/?%s=<share_link>&%s=<app_id>&%s=<name>&%s=<caption>&%s=<description>&%s=<picture>&%s=null&%s=true&%s=<in_app> */
public class MmsSmsErrorCache {
    private static final PrefKey f17437a = ((PrefKey) SmsPrefKeys.N.a("index"));
    private static volatile MmsSmsErrorCache f17438e;
    private Map<String, MmsSmsErrorType> f17439b;
    private int f17440c;
    private final FbSharedPreferences f17441d;

    public static com.facebook.messaging.sms.MmsSmsErrorCache m17411a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17438e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sms.MmsSmsErrorCache.class;
        monitor-enter(r1);
        r0 = f17438e;	 Catch:{ all -> 0x003a }
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
        r0 = m17413b(r0);	 Catch:{ all -> 0x0035 }
        f17438e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17438e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.MmsSmsErrorCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.MmsSmsErrorCache");
    }

    private static MmsSmsErrorCache m17413b(InjectorLike injectorLike) {
        return new MmsSmsErrorCache((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public MmsSmsErrorCache(FbSharedPreferences fbSharedPreferences) {
        this.f17441d = fbSharedPreferences;
    }

    @Nullable
    public final MmsSmsErrorType m17416a(String str) {
        m17415b();
        if (this.f17439b.containsKey(str)) {
            return (MmsSmsErrorType) this.f17439b.get(str);
        }
        return null;
    }

    public final void m17418a(String str, MmsSmsErrorType mmsSmsErrorType) {
        m17415b();
        if (this.f17439b.size() > 40) {
            this.f17439b = null;
        } else {
            this.f17439b.put(str, mmsSmsErrorType);
        }
        this.f17441d.edit().a(m17414b(this.f17440c), str).a(m17412a(this.f17440c), mmsSmsErrorType.ordinal()).a(f17437a, (this.f17440c + 1) % 20).commit();
        this.f17440c = (this.f17440c + 1) % 20;
    }

    private synchronized void m17415b() {
        synchronized (this) {
            if (this.f17439b == null) {
                this.f17439b = new HashMap(20);
                this.f17440c = this.f17441d.a(f17437a, 0);
                for (int i = 0; i < 20; i++) {
                    String a = this.f17441d.a(m17414b(this.f17440c + i), null);
                    if (!Strings.isNullOrEmpty(a)) {
                        int a2 = this.f17441d.a(m17412a(this.f17440c + i), -1);
                        if (a2 != -1) {
                            this.f17439b.put(a, MmsSmsErrorType.fromOrdinal(a2));
                        }
                    }
                }
            }
        }
    }

    private static PrefKey m17412a(int i) {
        return (PrefKey) ((PrefKey) SmsPrefKeys.N.a(String.valueOf(i % 20) + '/')).a("error_code");
    }

    private static PrefKey m17414b(int i) {
        return (PrefKey) ((PrefKey) SmsPrefKeys.N.a(String.valueOf(i % 20) + '/')).a("msg_id");
    }

    public final String m17417a() {
        m17415b();
        return this.f17439b.toString();
    }
}
