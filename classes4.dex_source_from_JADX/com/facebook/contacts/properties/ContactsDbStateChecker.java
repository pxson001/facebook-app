package com.facebook.contacts.properties;

import android.os.Build.VERSION;
import com.facebook.common.locale.Locales;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: markSurveyCompletedParamsKey */
public class ContactsDbStateChecker {
    private static final Class<?> f8307a = ContactsDbStateChecker.class;
    private static volatile ContactsDbStateChecker f8308e;
    public final DbContactsPropertyUtil f8309b;
    private final Locales f8310c;
    private final Clock f8311d;

    public static com.facebook.contacts.properties.ContactsDbStateChecker m8582a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8308e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.properties.ContactsDbStateChecker.class;
        monitor-enter(r1);
        r0 = f8308e;	 Catch:{ all -> 0x003a }
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
        r0 = m8583b(r0);	 Catch:{ all -> 0x0035 }
        f8308e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8308e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.properties.ContactsDbStateChecker.a(com.facebook.inject.InjectorLike):com.facebook.contacts.properties.ContactsDbStateChecker");
    }

    private static ContactsDbStateChecker m8583b(InjectorLike injectorLike) {
        return new ContactsDbStateChecker(DbContactsPropertyUtil.m8548b(injectorLike), Locales.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContactsDbStateChecker(DbContactsPropertyUtil dbContactsPropertyUtil, Locales locales, Clock clock) {
        this.f8309b = dbContactsPropertyUtil;
        this.f8310c = locales;
        this.f8311d = clock;
    }

    public final boolean m8584a() {
        long a = this.f8309b.m8550a(DbContactsProperties.f13091b, -1);
        if (a == -1) {
            return true;
        }
        long a2 = this.f8309b.m8550a(DbContactsProperties.f13090a, -1);
        if (a2 == -1 || a > a2) {
            return true;
        }
        if (!StringUtil.a(this.f8310c.g(), this.f8309b.m8552a(DbContactsProperties.f13092c, this.f8310c.g()))) {
            return true;
        }
        a = this.f8311d.a() - a;
        if (a < 0 || a > 1209600000) {
            Long.valueOf(a / 86400000);
            return true;
        }
        Long.valueOf(a / 86400000);
        return false;
    }

    public final void m8585c() {
        this.f8309b.m8556b(DbContactsProperties.f13096g, VERSION.SDK_INT);
    }
}
