package com.facebook.languages.switchercommonex;

import com.facebook.common.locale.Locales;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switchercommon.ApplicationLocale;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@NotThreadSafe
/* compiled from: hasGoodQuality */
public class LocaleChangeController {
    private static volatile LocaleChangeController f21391d;
    private final Set<LocaleChangeListener> f21392a = Sets.m1313a();
    private final ApplicationLocale f21393b;
    private final Locales f21394c;

    public static com.facebook.languages.switchercommonex.LocaleChangeController m29097a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21391d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.languages.switchercommonex.LocaleChangeController.class;
        monitor-enter(r1);
        r0 = f21391d;	 Catch:{ all -> 0x003a }
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
        r0 = m29099b(r0);	 Catch:{ all -> 0x0035 }
        f21391d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21391d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.languages.switchercommonex.LocaleChangeController.a(com.facebook.inject.InjectorLike):com.facebook.languages.switchercommonex.LocaleChangeController");
    }

    private static LocaleChangeController m29099b(InjectorLike injectorLike) {
        return new LocaleChangeController(PersistentLocale.m4769a(injectorLike), Locales.m2604a(injectorLike));
    }

    @Inject
    public LocaleChangeController(ApplicationLocale applicationLocale, Locales locales) {
        this.f21393b = applicationLocale;
        this.f21394c = locales;
    }

    public final void m29101a(LocaleChangeListener localeChangeListener) {
        this.f21392a.add(localeChangeListener);
    }

    public final void m29100a() {
        if (this.f21393b.mo675b()) {
            m29098a(Locales.m2607e());
        }
    }

    public final ListenableFuture m29102b() {
        return m29098a(this.f21393b.mo674a());
    }

    private ListenableFuture m29098a(Locale locale) {
        Iterable arrayList = new ArrayList(this.f21392a.size());
        for (LocaleChangeListener a : this.f21392a) {
            ListenableFuture a2 = a.mo3162a(locale);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return Futures.m2451a(arrayList);
    }
}
