package com.facebook.http.common.executorimpl.apache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Singleton;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieIdentityComparator;

@Singleton
/* compiled from: display_width */
public class FbCookieStore implements CookieStore {
    private static volatile FbCookieStore f4978c;
    private final ArrayList<Cookie> f4979a = new ArrayList();
    private final Comparator<Cookie> f4980b = new CookieIdentityComparator();

    public static com.facebook.http.common.executorimpl.apache.FbCookieStore m9911a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4978c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.http.common.executorimpl.apache.FbCookieStore.class;
        monitor-enter(r1);
        r0 = f4978c;	 Catch:{ all -> 0x0039 }
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
        r0 = m9910a();	 Catch:{ all -> 0x0034 }
        f4978c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f4978c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.executorimpl.apache.FbCookieStore.a(com.facebook.inject.InjectorLike):com.facebook.http.common.executorimpl.apache.FbCookieStore");
    }

    private static FbCookieStore m9910a() {
        return new FbCookieStore();
    }

    public synchronized void addCookie(Cookie cookie) {
        if (cookie != null) {
            Iterator it = this.f4979a.iterator();
            while (it.hasNext()) {
                if (this.f4980b.compare(cookie, it.next()) == 0) {
                    it.remove();
                    break;
                }
            }
            if (!cookie.isExpired(new Date())) {
                this.f4979a.add(cookie);
            }
        }
    }

    public synchronized List<Cookie> getCookies() {
        return Collections.unmodifiableList(this.f4979a);
    }

    public synchronized boolean clearExpired(Date date) {
        boolean z = false;
        synchronized (this) {
            if (date != null) {
                Iterator it = this.f4979a.iterator();
                boolean z2 = false;
                while (it.hasNext()) {
                    if (((Cookie) it.next()).isExpired(date)) {
                        it.remove();
                        z2 = true;
                    }
                }
                z = z2;
            }
        }
        return z;
    }

    public String toString() {
        return this.f4979a.toString();
    }

    public synchronized void clear() {
        this.f4979a.clear();
    }
}
