package com.facebook.http.common;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.interfaces.RequestPriority;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: drawRenderNode */
public class FbHttpUtils {
    private static volatile FbHttpUtils f4926a;

    /* compiled from: drawRenderNode */
    /* synthetic */ class C04721 {
        static final /* synthetic */ int[] f4925a = new int[RequestPriority.values().length];

        static {
            try {
                f4925a[RequestPriority.UNUSED_REQUEST_PRIORITY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public static com.facebook.http.common.FbHttpUtils m9862a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4926a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.http.common.FbHttpUtils.class;
        monitor-enter(r1);
        r0 = f4926a;	 Catch:{ all -> 0x0039 }
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
        r0 = m9861a();	 Catch:{ all -> 0x0034 }
        f4926a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f4926a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.FbHttpUtils.a(com.facebook.inject.InjectorLike):com.facebook.http.common.FbHttpUtils");
    }

    private static FbHttpUtils m9861a() {
        return new FbHttpUtils();
    }

    public static String m9865a(RequestPriority requestPriority) {
        switch (C04721.f4925a[requestPriority.ordinal()]) {
            case 1:
                return "?";
            default:
                return requestPriority.name().substring(0, 1);
        }
    }

    public static String m9866b(FbHttpRequest fbHttpRequest) {
        CallerContext callerContext = fbHttpRequest.d;
        String str = "Unknown";
        if (callerContext == null) {
            return str;
        }
        str = callerContext.b;
        if (str != null && str.contains(".")) {
            str = str.substring(str.lastIndexOf(46) + 1);
        }
        if (str == null || !str.contains("$")) {
            return str;
        }
        return str.substring(0, str.lastIndexOf(36));
    }

    public static ImmutableList<String> m9863a(ArrayList<FbHttpRequest<?>> arrayList) {
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < arrayList.size(); i++) {
            String str;
            FbHttpRequest fbHttpRequest = (FbHttpRequest) arrayList.get(i);
            CallerContext callerContext = fbHttpRequest.d;
            StringBuilder append = new StringBuilder().append(fbHttpRequest.c).append(";;").append(fbHttpRequest.h().toString()).append(";;");
            if (callerContext == null) {
                str = "null";
            } else {
                str = callerContext.b;
            }
            builder.c(append.append(str).append(";;").append(fbHttpRequest.b.getURI().getHost()).toString());
        }
        return builder.b();
    }

    @Nullable
    public static String m9864a(FbHttpRequest<?> fbHttpRequest) {
        String str = fbHttpRequest.m;
        if (str != null) {
            return str;
        }
        CallerContext callerContext = fbHttpRequest.d;
        if (callerContext != null) {
            return callerContext.d();
        }
        return null;
    }
}
