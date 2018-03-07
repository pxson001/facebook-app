package com.facebook.fql;

import com.facebook.fql.FqlHelper.MultiQuery;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: WWW_PAGES_INSIGHTS_OVERVIEW */
public class FqlMultiQueryMethod implements ApiMethod<MultiQuery, JsonNode> {
    private static volatile FqlMultiQueryMethod f12300b;
    public final String f12301a;

    public static com.facebook.fql.FqlMultiQueryMethod m20385a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12300b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.fql.FqlMultiQueryMethod.class;
        monitor-enter(r1);
        r0 = f12300b;	 Catch:{ all -> 0x0039 }
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
        r0 = m20386b();	 Catch:{ all -> 0x0034 }
        f12300b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12300b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fql.FqlMultiQueryMethod.a(com.facebook.inject.InjectorLike):com.facebook.fql.FqlMultiQueryMethod");
    }

    private static FqlMultiQueryMethod m20386b() {
        return new FqlMultiQueryMethod();
    }

    public final ApiRequest m20387a(Object obj) {
        MultiQuery multiQuery = (MultiQuery) obj;
        List a = Lists.a(2);
        a.add(new BasicNameValuePair("queries", multiQuery.toString()));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest(this.f12301a, "GET", "method/fql.multiquery", a, ApiResponseType.JSON);
    }

    @Inject
    public FqlMultiQueryMethod() {
        this("fqlMultiQueryMethod");
    }

    private FqlMultiQueryMethod(String str) {
        this.f12301a = str;
    }

    public final Object m20388a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        try {
            return apiResponse.c();
        } catch (Throwable e) {
            throw new RuntimeException("Exception when trying to get node", e);
        }
    }
}
