package com.facebook.common.i18n;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: request_method */
public class BasicDateTimeFormat {
    private static final boolean f7293m;
    private static volatile BasicDateTimeFormat f7294n;
    public final Lazy<Locale> f7295a;
    private volatile DateFormat f7296b;
    private volatile DateFormat f7297c;
    private volatile SimpleDateFormat f7298d;
    private volatile SimpleDateFormat f7299e;
    private volatile SimpleDateFormat f7300f;
    private volatile SimpleDateFormat f7301g;
    private volatile SimpleDateFormat f7302h;
    private volatile SimpleDateFormat f7303i;
    public volatile SimpleDateFormat f7304j;
    public volatile SimpleDateFormat f7305k;
    public volatile SimpleDateFormat f7306l;

    public static com.facebook.common.i18n.BasicDateTimeFormat m11815a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7294n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.i18n.BasicDateTimeFormat.class;
        monitor-enter(r1);
        r0 = f7294n;	 Catch:{ all -> 0x003a }
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
        r0 = m11817b(r0);	 Catch:{ all -> 0x0035 }
        f7294n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7294n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.i18n.BasicDateTimeFormat.a(com.facebook.inject.InjectorLike):com.facebook.common.i18n.BasicDateTimeFormat");
    }

    private static BasicDateTimeFormat m11817b(InjectorLike injectorLike) {
        return new BasicDateTimeFormat(IdBasedLazy.m1808a(injectorLike, 4483));
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 18 && !(VERSION.SDK_INT == 18 && Build.MANUFACTURER.toUpperCase(Locale.getDefault()).equals("SAMSUNG") && Build.MODEL.toUpperCase(Locale.getDefault()).startsWith("SM-N900"))) {
            z = true;
        }
        f7293m = z;
    }

    @Inject
    public BasicDateTimeFormat(Lazy<Locale> lazy) {
        this.f7295a = lazy;
    }

    public final DateFormat m11818a() {
        if (this.f7296b == null) {
            this.f7296b = DateFormat.getTimeInstance(3, (Locale) this.f7295a.get());
        }
        return this.f7296b;
    }

    public final DateFormat m11819b() {
        if (this.f7297c == null) {
            this.f7297c = DateFormat.getDateInstance(2, (Locale) this.f7295a.get());
        }
        return this.f7297c;
    }

    public final SimpleDateFormat m11820c() {
        if (this.f7298d == null) {
            this.f7298d = new SimpleDateFormat("EEEE", (Locale) this.f7295a.get());
        }
        return this.f7298d;
    }

    public final SimpleDateFormat m11821d() {
        if (this.f7299e == null) {
            this.f7299e = new SimpleDateFormat("EE", (Locale) this.f7295a.get());
        }
        return this.f7299e;
    }

    public final SimpleDateFormat m11822e() {
        if (this.f7302h == null) {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) m11819b().clone();
            m11816a(simpleDateFormat, "EEEE, MMMM d", (Locale) this.f7295a.get());
            this.f7302h = simpleDateFormat;
        }
        return this.f7302h;
    }

    public final SimpleDateFormat m11823f() {
        if (this.f7303i == null) {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) m11819b().clone();
            m11816a(simpleDateFormat, "EEEE, MMMM d, yyyy", (Locale) this.f7295a.get());
            this.f7303i = simpleDateFormat;
        }
        return this.f7303i;
    }

    public final SimpleDateFormat m11824g() {
        if (this.f7300f == null) {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) m11819b().clone();
            m11816a(simpleDateFormat, "MMMd", (Locale) this.f7295a.get());
            this.f7300f = simpleDateFormat;
        }
        return this.f7300f;
    }

    public final SimpleDateFormat m11825h() {
        if (this.f7301g == null) {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) m11819b().clone();
            m11816a(simpleDateFormat, "MMMd, yyyy", (Locale) this.f7295a.get());
            this.f7301g = simpleDateFormat;
        }
        return this.f7301g;
    }

    @TargetApi(18)
    public static void m11816a(SimpleDateFormat simpleDateFormat, String str, Locale locale) {
        if (f7293m) {
            simpleDateFormat.applyPattern(android.text.format.DateFormat.getBestDateTimePattern(locale, str));
        }
    }
}
