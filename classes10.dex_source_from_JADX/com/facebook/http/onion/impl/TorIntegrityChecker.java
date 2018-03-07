package com.facebook.http.onion.impl;

import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.InjectorLike;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

@Singleton
/* compiled from: Successful fetch w/o MessagesCollection */
public class TorIntegrityChecker {
    public static final ResponseHandler<TorIntegrityResult> f23375b = new C33691();
    private static volatile TorIntegrityChecker f23376c;
    public final FbHttpRequestProcessor f23377a;

    /* compiled from: Successful fetch w/o MessagesCollection */
    final class C33691 implements ResponseHandler<TorIntegrityResult> {
        C33691() {
        }

        public final Object handleResponse(HttpResponse httpResponse) {
            BufferedReader bufferedReader;
            Throwable th;
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                throw new ClientProtocolException("Invalid response code received");
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
                try {
                    String readLine = bufferedReader.readLine();
                    bufferedReader.close();
                    Object obj = -1;
                    switch (readLine.hashCode()) {
                        case -977423767:
                            if (readLine.equals("public")) {
                                obj = null;
                                break;
                            }
                            break;
                        case 115031:
                            if (readLine.equals("tor")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 105892297:
                            if (readLine.equals("onion")) {
                                obj = 2;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            return TorIntegrityResult.PUBLIC;
                        case 1:
                            return TorIntegrityResult.TOR;
                        case 2:
                            return TorIntegrityResult.ONION;
                        default:
                            throw new ClientProtocolException("Invalid status line received");
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        }
    }

    /* compiled from: Successful fetch w/o MessagesCollection */
    public enum TorIntegrityResult {
        PUBLIC,
        TOR,
        ONION
    }

    public static com.facebook.http.onion.impl.TorIntegrityChecker m24692a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23376c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.onion.impl.TorIntegrityChecker.class;
        monitor-enter(r1);
        r0 = f23376c;	 Catch:{ all -> 0x003a }
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
        r0 = m24693b(r0);	 Catch:{ all -> 0x0035 }
        f23376c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23376c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.onion.impl.TorIntegrityChecker.a(com.facebook.inject.InjectorLike):com.facebook.http.onion.impl.TorIntegrityChecker");
    }

    private static TorIntegrityChecker m24693b(InjectorLike injectorLike) {
        return new TorIntegrityChecker(FbHttpRequestProcessor.a(injectorLike));
    }

    @Inject
    public TorIntegrityChecker(FbHttpRequestProcessor fbHttpRequestProcessor) {
        this.f23377a = fbHttpRequestProcessor;
    }
}
