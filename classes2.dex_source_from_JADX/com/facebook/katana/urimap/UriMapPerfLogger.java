package com.facebook.katana.urimap;

import android.content.Context;
import android.net.Uri;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import java.util.HashSet;
import java.util.Stack;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: signal_cdma_dbm */
public class UriMapPerfLogger {
    private static final int f4822a = 3;
    private static volatile UriMapPerfLogger f4823f;
    private final QuickPerformanceLogger f4824b;
    private final HashSet<String> f4825c = new HashSet();
    private final Stack<Integer> f4826d = new Stack();
    private short f4827e;

    public static com.facebook.katana.urimap.UriMapPerfLogger m8654a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4823f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.urimap.UriMapPerfLogger.class;
        monitor-enter(r1);
        r0 = f4823f;	 Catch:{ all -> 0x003a }
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
        r0 = m8656b(r0);	 Catch:{ all -> 0x0035 }
        f4823f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4823f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.urimap.UriMapPerfLogger.a(com.facebook.inject.InjectorLike):com.facebook.katana.urimap.UriMapPerfLogger");
    }

    private static UriMapPerfLogger m8656b(InjectorLike injectorLike) {
        return new UriMapPerfLogger(QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike));
    }

    @Inject
    public UriMapPerfLogger(QuickPerformanceLogger quickPerformanceLogger) {
        this.f4824b = quickPerformanceLogger;
        Integer.valueOf(GeneratedUriMap.f4828a);
    }

    public final void m8659a(Context context, String str) {
        String a = m8655a(str);
        int hashCode = str.hashCode();
        this.f4824b.mo442a(5701633, hashCode, "tag_name", a);
        if (!this.f4826d.isEmpty()) {
            this.f4827e = (short) 51;
        } else if (this.f4825c.isEmpty()) {
            this.f4827e = (short) 10;
            this.f4825c.add(a);
        } else if (this.f4825c.contains(a)) {
            this.f4827e = (short) 2;
        } else {
            this.f4827e = (short) 11;
            this.f4825c.add(a);
        }
        this.f4826d.push(Integer.valueOf(hashCode));
        if (context != null) {
            this.f4824b.mo464b(5701633, hashCode, context.getClass().getSimpleName());
        }
    }

    public final void m8660a(String str, boolean z) {
        if (str != null) {
            if (z) {
                this.f4824b.mo464b(5701633, ((Integer) this.f4826d.peek()).intValue(), Uri.decode(str).replaceAll("\\d+", "#"));
            }
            this.f4824b.mo466b(5701633, ((Integer) this.f4826d.peek()).intValue(), z ? (short) 3 : this.f4827e);
            if (!this.f4826d.isEmpty()) {
                this.f4826d.pop();
            }
        }
    }

    public final void m8657a(int i, String str) {
        int i2 = i;
        this.f4824b.mo439a(i2, 5701633, ((Integer) this.f4826d.peek()).intValue(), "tag_name", m8655a(str));
    }

    public final void m8658a(int i, boolean z) {
        this.f4824b.mo466b(i, ((Integer) this.f4826d.peek()).intValue(), z ? (short) 3 : this.f4827e);
    }

    public final void m8661b(int i, String str) {
        this.f4824b.mo464b(i, ((Integer) this.f4826d.peek()).intValue(), str);
    }

    private static String m8655a(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("://");
        if (indexOf == -1) {
            return str;
        }
        int length = str.length();
        for (indexOf += f4822a; indexOf < length; indexOf++) {
            char charAt = str.charAt(indexOf);
            if (charAt == '/' || charAt == '?' || charAt == '=') {
                return str.substring(0, indexOf);
            }
        }
        return str;
    }
}
