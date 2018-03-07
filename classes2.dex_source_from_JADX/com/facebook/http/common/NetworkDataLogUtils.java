package com.facebook.http.common;

import com.facebook.debug.log.BLog;
import javax.annotation.Nullable;
import javax.inject.Singleton;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;

@Singleton
/* compiled from: orientation */
public class NetworkDataLogUtils {
    private static final Class<?> f10750a = NetworkDataLogUtils.class;
    private static volatile NetworkDataLogUtils f10751b;

    public static com.facebook.http.common.NetworkDataLogUtils m15995a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10751b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.http.common.NetworkDataLogUtils.class;
        monitor-enter(r1);
        r0 = f10751b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m15994a();	 Catch:{ all -> 0x0034 }
        f10751b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10751b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.NetworkDataLogUtils.a(com.facebook.inject.InjectorLike):com.facebook.http.common.NetworkDataLogUtils");
    }

    private static NetworkDataLogUtils m15994a() {
        return new NetworkDataLogUtils();
    }

    @Nullable
    public static String m15996a(HttpResponse httpResponse) {
        String str = null;
        HttpEntity entity = httpResponse.getEntity();
        if (!(entity == null || entity.getContentType() == null)) {
            str = entity.getContentType().getValue();
        }
        if (str != null) {
            return str;
        }
        Header firstHeader = httpResponse.getFirstHeader("Content-Type");
        if (firstHeader != null) {
            return firstHeader.getValue();
        }
        return str;
    }

    public static long m15993a(HttpMessage httpMessage) {
        long j = 0;
        HeaderIterator headerIterator = httpMessage.headerIterator();
        while (headerIterator.hasNext()) {
            j += (long) headerIterator.nextHeader().toString().length();
        }
        return j;
    }

    public static long m15997c(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Content-Length");
        if (firstHeader != null) {
            try {
                return Long.parseLong(firstHeader.getValue());
            } catch (Throwable e) {
                BLog.b(f10750a, "Failure parsing Content-Length header", e);
            }
        }
        return -1;
    }
}
