package com.facebook.languages.switchercommonex;

import com.facebook.common.locale.Locales;
import com.facebook.common.util.LocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switchercommon.ApplicationLocale;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import java.util.Locale;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: timeline */
public class PersistentLocale implements ApplicationLocale {
    private static volatile PersistentLocale f2789c;
    private final FbSharedPreferences f2790a;
    private final Locales f2791b;

    public static com.facebook.languages.switchercommonex.PersistentLocale m4769a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2789c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.languages.switchercommonex.PersistentLocale.class;
        monitor-enter(r1);
        r0 = f2789c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m4771b(r0);	 Catch:{ all -> 0x0035 }
        f2789c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2789c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.languages.switchercommonex.PersistentLocale.a(com.facebook.inject.InjectorLike):com.facebook.languages.switchercommonex.PersistentLocale");
    }

    private static PersistentLocale m4771b(InjectorLike injectorLike) {
        return new PersistentLocale(FbSharedPreferencesImpl.m1826a(injectorLike), Locales.m2604a(injectorLike));
    }

    @Inject
    public PersistentLocale(FbSharedPreferences fbSharedPreferences, Locales locales) {
        this.f2790a = fbSharedPreferences;
        this.f2791b = locales;
    }

    public final Locale mo674a() {
        if (!this.f2790a.mo284a()) {
            return Locales.m2607e();
        }
        String c = m4772c();
        if (m4770a(c)) {
            return Locales.m2607e();
        }
        Locale a = LocaleUtil.m31239a(c);
        return StringUtil.m3589a(a.getCountry()) ? new Locale(a.getLanguage(), Locales.m2607e().getCountry()) : a;
    }

    public final boolean mo675b() {
        return m4770a(m4772c());
    }

    private static boolean m4770a(String str) {
        return str.equals("device");
    }

    private String m4772c() {
        return this.f2790a.mo278a(LanguageSwitcherCommonExPrefKeys.f2785b, "device");
    }
}
