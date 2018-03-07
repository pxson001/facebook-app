package com.facebook.debug.http;

import com.facebook.androidinternals.android.os.SystemPropertiesInternal;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.debug.http.DebugHttpFlowReporter.ErrorResponseInfo;
import com.facebook.debug.http.DebugHttpFlowReporter.RequestInfo;
import com.facebook.debug.http.DebugHttpFlowReporter.ResponseInfo;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.Header;

@Singleton
/* compiled from: not_enough_space */
public class FileReporter implements DebugHttpFlowReporter {
    private static volatile FileReporter f12170d;
    private ObjectMapper f12171a;
    private String f12172b;
    private FileAppender f12173c;

    public static com.facebook.debug.http.FileReporter m17872a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12170d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.debug.http.FileReporter.class;
        monitor-enter(r1);
        r0 = f12170d;	 Catch:{ all -> 0x003a }
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
        r0 = m17877b(r0);	 Catch:{ all -> 0x0035 }
        f12170d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12170d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.debug.http.FileReporter.a(com.facebook.inject.InjectorLike):com.facebook.debug.http.FileReporter");
    }

    private static FileReporter m17877b(InjectorLike injectorLike) {
        return new FileReporter(FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    @Inject
    public FileReporter(ObjectMapper objectMapper) {
        this.f12171a = objectMapper;
    }

    public final boolean mo2291a() {
        return !m17878b().equals("");
    }

    public final void mo2289a(RequestInfo requestInfo) {
        try {
            m17873a(this.f12171a.m6659a(m17875b(requestInfo)));
        } catch (JsonProcessingException e) {
        }
    }

    public final void mo2290a(ResponseInfo responseInfo) {
        try {
            m17873a(this.f12171a.m6659a(m17876b(responseInfo)));
        } catch (JsonProcessingException e) {
        }
    }

    public final void mo2288a(ErrorResponseInfo errorResponseInfo) {
        try {
            m17873a(this.f12171a.m6659a(m17874b(errorResponseInfo)));
        } catch (JsonProcessingException e) {
        }
    }

    private static RequestReport m17875b(RequestInfo requestInfo) {
        RequestReport requestReport = new RequestReport();
        requestReport.mRequestId = requestInfo.a;
        requestReport.mTimeStamp = requestInfo.b;
        requestReport.mMethod = requestInfo.c.getRequestLine().getMethod();
        requestReport.mURI = requestInfo.c.getRequestLine().getUri();
        Map hashMap = new HashMap();
        for (Header header : requestInfo.c.getAllHeaders()) {
            hashMap.put(header.getName(), header.getValue());
        }
        requestReport.mHeaders = hashMap;
        if (requestInfo.d == null) {
            requestReport.mBody = "<unable to extract body>";
        } else if (requestInfo.d.length > 100000) {
            requestReport.mBody = "<body omitted, too big>";
        } else {
            try {
                requestReport.mBody = new String(requestInfo.d, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                requestReport.mBody = e.toString();
            }
        }
        return requestReport;
    }

    private static ResponseReport m17876b(ResponseInfo responseInfo) {
        ResponseReport responseReport = new ResponseReport();
        responseReport.mRequestId = responseInfo.c;
        responseReport.mTimeStamp = responseInfo.d;
        responseReport.mStatusCode = String.valueOf(responseInfo.e.getStatusLine().getStatusCode());
        responseReport.mReasonPhrase = responseInfo.e.getStatusLine().getReasonPhrase();
        Map hashMap = new HashMap();
        for (Header header : responseInfo.e.getAllHeaders()) {
            hashMap.put(header.getName(), header.getValue());
        }
        responseReport.mHeaders = hashMap;
        if (responseInfo.f != null) {
            if (responseInfo.f.length > 100000) {
                responseReport.mBody = "<body omitted, too big>";
            } else {
                try {
                    responseReport.mBody = new String(responseInfo.f, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    responseReport.mBody = e.toString();
                }
            }
        }
        return responseReport;
    }

    private static ErrorResponseReport m17874b(ErrorResponseInfo errorResponseInfo) {
        ErrorResponseReport errorResponseReport = new ErrorResponseReport();
        errorResponseReport.mRequestId = errorResponseInfo.c;
        errorResponseReport.mTimeStamp = errorResponseInfo.d;
        errorResponseReport.mError = errorResponseInfo.a;
        if (errorResponseInfo.e != null) {
            errorResponseReport.mResponse = m17876b((ResponseInfo) errorResponseInfo);
        }
        return errorResponseReport;
    }

    private synchronized void m17873a(String str) {
        if (mo2291a()) {
            if (this.f12173c == null) {
                this.f12173c = new FileAppender(new File(m17878b()));
            }
            this.f12173c.a(str);
        }
    }

    private String m17878b() {
        if (this.f12172b == null) {
            this.f12172b = SystemPropertiesInternal.a("fb.http.dump_to_file");
        }
        return this.f12172b;
    }
}
