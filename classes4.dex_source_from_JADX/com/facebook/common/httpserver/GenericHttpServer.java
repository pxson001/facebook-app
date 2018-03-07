package com.facebook.common.httpserver;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.socketlike.java.JavaServerSocketLike;
import com.facebook.common.socketlike.java.JavaSocketLikeFactory;
import com.facebook.debug.log.BLog;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestHandlerRegistry;
import org.apache.http.protocol.HttpService;
import org.apache.http.protocol.ResponseConnControl;
import org.apache.http.protocol.ResponseContent;
import org.apache.http.protocol.ResponseDate;
import org.apache.http.protocol.ResponseServer;

/* compiled from: page_url */
public class GenericHttpServer {
    public final JavaSocketHttpServerConnectionFactory f11558a;
    private final HttpRequestHandlerRegistry f11559b;
    private final ArrayList<RequestListenerThread> f11560c = Lists.a();
    public final BackgroundWorkLogger f11561d;
    public final AbstractFbErrorReporter f11562e;
    private final ExecutorService f11563f;

    /* compiled from: page_url */
    class WorkerThread implements Runnable {
        private final HttpService f5393a;
        private final HttpServerConnection f5394b;
        private final BackgroundWorkLogger f5395c;
        private final AbstractFbErrorReporter f5396d;

        @android.annotation.SuppressLint({"LogMethodNoExceptionInCatch"})
        public void run() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x004e in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r7 = this;
            r4 = 1;
            r6 = 0;
            r0 = r7.f5395c;
            r1 = "GenericHttpServer";
            r2 = "RequestListenerThread";
            r1 = r0.a(r1, r2);
            if (r1 == 0) goto L_0x0011;
        L_0x000e:
            r1.a();
        L_0x0011:
            r0 = new org.apache.http.protocol.BasicHttpContext;	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            r2 = 0;	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            r0.<init>(r2);	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            r2 = java.lang.Thread.interrupted();	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            if (r2 != 0) goto L_0x002c;	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
        L_0x001d:
            r2 = r7.f5394b;	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            r2 = r2.isOpen();	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            if (r2 == 0) goto L_0x002c;	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
        L_0x0025:
            r2 = r7.f5393a;	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            r3 = r7.f5394b;	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            r2.handleRequest(r3, r0);	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
        L_0x002c:
            if (r1 == 0) goto L_0x0031;
        L_0x002e:
            r1.a(r4);
        L_0x0031:
            r0 = r7.f5394b;	 Catch:{ IOException -> 0x00a5 }
            r0.close();	 Catch:{ IOException -> 0x00a5 }
        L_0x0036:
            return;
        L_0x0037:
            r0 = move-exception;
            r2 = "GenericHttpServer";	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            r3 = "Client closed connection: %s";	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            r4 = 1;	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            r4 = new java.lang.Object[r4];	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            r5 = 0;	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            r0 = r0.toString();	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            r4[r5] = r0;	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            com.facebook.debug.log.BLog.a(r2, r3, r4);	 Catch:{ ConnectionClosedException -> 0x0037, IOException -> 0x0056, HttpException -> 0x006b, Exception -> 0x0080, all -> 0x0097 }
            if (r1 == 0) goto L_0x004e;
        L_0x004b:
            r1.a(r6);
        L_0x004e:
            r0 = r7.f5394b;	 Catch:{ IOException -> 0x0054 }
            r0.close();	 Catch:{ IOException -> 0x0054 }
            goto L_0x0036;
        L_0x0054:
            r0 = move-exception;
            goto L_0x0036;
        L_0x0056:
            r0 = move-exception;
            r2 = "GenericHttpServer";	 Catch:{  }
            r3 = "I/O error";	 Catch:{  }
            com.facebook.debug.log.BLog.a(r2, r3, r0);	 Catch:{  }
            if (r1 == 0) goto L_0x0063;
        L_0x0060:
            r1.a(r6);
        L_0x0063:
            r0 = r7.f5394b;	 Catch:{ IOException -> 0x0069 }
            r0.close();	 Catch:{ IOException -> 0x0069 }
            goto L_0x0036;
        L_0x0069:
            r0 = move-exception;
            goto L_0x0036;
        L_0x006b:
            r0 = move-exception;
            r2 = "GenericHttpServer";	 Catch:{  }
            r3 = "Unrecoverable HTTP protocol violation";	 Catch:{  }
            com.facebook.debug.log.BLog.a(r2, r3, r0);	 Catch:{  }
            if (r1 == 0) goto L_0x0078;
        L_0x0075:
            r1.a(r6);
        L_0x0078:
            r0 = r7.f5394b;	 Catch:{ IOException -> 0x007e }
            r0.close();	 Catch:{ IOException -> 0x007e }
            goto L_0x0036;
        L_0x007e:
            r0 = move-exception;
            goto L_0x0036;
        L_0x0080:
            r0 = move-exception;
            r2 = r7.f5396d;	 Catch:{  }
            r3 = "GenericHttpServer";	 Catch:{  }
            r4 = "Unexpected exception when handling request";	 Catch:{  }
            r2.b(r3, r4, r0);	 Catch:{  }
            if (r1 == 0) goto L_0x008f;
        L_0x008c:
            r1.a(r6);
        L_0x008f:
            r0 = r7.f5394b;	 Catch:{ IOException -> 0x0095 }
            r0.close();	 Catch:{ IOException -> 0x0095 }
            goto L_0x0036;
        L_0x0095:
            r0 = move-exception;
            goto L_0x0036;
        L_0x0097:
            r0 = move-exception;
            if (r1 == 0) goto L_0x009d;
        L_0x009a:
            r1.a(r6);
        L_0x009d:
            r1 = r7.f5394b;	 Catch:{ IOException -> 0x00a3 }
            r1.close();	 Catch:{ IOException -> 0x00a3 }
        L_0x00a2:
            throw r0;
        L_0x00a3:
            r1 = move-exception;
            goto L_0x00a2;
        L_0x00a5:
            r0 = move-exception;
            goto L_0x0036;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.httpserver.GenericHttpServer.WorkerThread.run():void");
        }

        public WorkerThread(HttpService httpService, HttpServerConnection httpServerConnection, BackgroundWorkLogger backgroundWorkLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
            this.f5393a = httpService;
            this.f5394b = httpServerConnection;
            this.f5395c = backgroundWorkLogger;
            this.f5396d = abstractFbErrorReporter;
        }
    }

    /* compiled from: page_url */
    class RequestListenerThread extends Thread {
        final /* synthetic */ GenericHttpServer f11576a;
        private final HttpParams f11577b;
        private final HttpService f11578c;
        private final SocketAddress f11579d;
        private final ExecutorService f11580e;
        private JavaServerSocketLike f11581f;

        public void run() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0023 in list [B:10:0x0020]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r7 = this;
            r6 = 1;
            r0 = r7.f11576a;
            r0 = r0.f11561d;
            r1 = "GenericHttpServer";
            r2 = "RequestListenerThread";
            r1 = r0.a(r1, r2);
            if (r1 == 0) goto L_0x0012;
        L_0x000f:
            r1.a();
        L_0x0012:
            r0 = r7.f11581f;	 Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x001e;	 Catch:{ all -> 0x0061 }
        L_0x0016:
            r0 = r7.f11581f;	 Catch:{ all -> 0x0061 }
            r0 = r0.m12075a();	 Catch:{ all -> 0x0061 }
            if (r0 != 0) goto L_0x0024;
        L_0x001e:
            if (r1 == 0) goto L_0x0023;
        L_0x0020:
            r1.a(r6);
        L_0x0023:
            return;
        L_0x0024:
            r0 = interrupted();	 Catch:{  }
            if (r0 != 0) goto L_0x0070;
        L_0x002a:
            r0 = r7.f11581f;	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r0 = r0.m12077c();	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r2 = r7.f11576a;	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r2 = r2.f11558a;	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r3 = r7.f11577b;	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r0 = r2.m12040a(r0, r3);	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r2 = new com.facebook.common.httpserver.GenericHttpServer$WorkerThread;	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r3 = r7.f11578c;	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r4 = r7.f11576a;	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r4 = r4.f11561d;	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r5 = r7.f11576a;	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r5 = r5.f11562e;	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r2.<init>(r3, r0, r4, r5);	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r0 = r7.f11580e;	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            r3 = -1981151342; // 0xffffffff89ea0792 float:-5.634057E-33 double:NaN;	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            com.facebook.tools.dextr.runtime.detour.ExecutorDetour.a(r0, r2, r3);	 Catch:{ SocketException -> 0x0052, InterruptedIOException -> 0x0083, IOException -> 0x0068, Exception -> 0x0076 }
            goto L_0x0024;
        L_0x0052:
            r0 = move-exception;
            r2 = r7.isInterrupted();	 Catch:{  }
            if (r2 != 0) goto L_0x0024;	 Catch:{  }
        L_0x0059:
            r2 = "GenericHttpServer";	 Catch:{  }
            r3 = "I/O error";	 Catch:{  }
            com.facebook.debug.log.BLog.a(r2, r3, r0);	 Catch:{  }
            goto L_0x0024;
        L_0x0061:
            r0 = move-exception;
            if (r1 == 0) goto L_0x0067;
        L_0x0064:
            r1.a(r6);
        L_0x0067:
            throw r0;
        L_0x0068:
            r0 = move-exception;
            r2 = "GenericHttpServer";	 Catch:{  }
            r3 = "I/O error initialising connection thread";	 Catch:{  }
            com.facebook.debug.log.BLog.a(r2, r3, r0);	 Catch:{  }
        L_0x0070:
            if (r1 == 0) goto L_0x0023;
        L_0x0072:
            r1.a(r6);
            goto L_0x0023;
        L_0x0076:
            r0 = move-exception;
            r2 = r7.f11576a;	 Catch:{  }
            r2 = r2.f11562e;	 Catch:{  }
            r3 = "GenericHttpServer";	 Catch:{  }
            r4 = "Unexpected exception";	 Catch:{  }
            r2.b(r3, r4, r0);	 Catch:{  }
            goto L_0x0024;
        L_0x0083:
            r0 = move-exception;
            goto L_0x0070;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.httpserver.GenericHttpServer.RequestListenerThread.run():void");
        }

        public RequestListenerThread(GenericHttpServer genericHttpServer, SocketAddress socketAddress, HttpService httpService, HttpParams httpParams, ExecutorService executorService) {
            this.f11576a = genericHttpServer;
            this.f11579d = socketAddress;
            this.f11577b = httpParams;
            this.f11578c = httpService;
            this.f11580e = executorService;
        }

        public static SocketAddress m12071a(RequestListenerThread requestListenerThread) {
            int i = 3;
            try {
                requestListenerThread.f11581f = requestListenerThread.m12072b();
                while (i > 0) {
                    int i2 = i - 1;
                    try {
                        requestListenerThread.f11581f.m12074a(requestListenerThread.f11579d);
                        return requestListenerThread.f11581f.m12076b();
                    } catch (Throwable e) {
                        BLog.a("GenericHttpServer", "Binding error, sleep 1 second ...", e);
                        if (i2 == 0) {
                            throw e;
                        }
                        Thread.sleep(1000);
                        i = i2;
                    }
                }
            } catch (Throwable e2) {
                BLog.b("GenericHttpServer", "Could not bind to socket.", e2);
            }
            return null;
        }

        private JavaServerSocketLike m12072b() {
            JavaSocketLikeFactory javaSocketLikeFactory = this.f11576a.f11558a.f11564a;
            JavaServerSocketLike javaServerSocketLike = new JavaServerSocketLike();
            javaServerSocketLike.f11586a.setReuseAddress(true);
            return javaServerSocketLike;
        }
    }

    public GenericHttpServer(JavaSocketHttpServerConnectionFactory javaSocketHttpServerConnectionFactory, HttpRequestHandlerRegistry httpRequestHandlerRegistry, BackgroundWorkLogger backgroundWorkLogger, AbstractFbErrorReporter abstractFbErrorReporter, ExecutorService executorService) {
        this.f11558a = javaSocketHttpServerConnectionFactory;
        this.f11559b = httpRequestHandlerRegistry;
        this.f11561d = backgroundWorkLogger;
        this.f11562e = (AbstractFbErrorReporter) Preconditions.checkNotNull(abstractFbErrorReporter);
        this.f11563f = executorService;
    }

    public final List<SocketAddress> m12039a(List<? extends SocketAddress> list) {
        List<SocketAddress> a = Lists.a(list.size());
        for (SocketAddress socketAddress : list) {
            HttpParams parameter = new BasicHttpParams().setIntParameter("http.socket.timeout", 5000).setIntParameter("http.socket.buffer-size", 8192).setBooleanParameter("http.connection.stalecheck", false).setBooleanParameter("http.tcp.nodelay", true).setParameter("http.origin-server", "GenericHttpServer").setParameter("http.protocol.version", "HTTP/1.1");
            HttpProcessor basicHttpProcessor = new BasicHttpProcessor();
            basicHttpProcessor.addInterceptor(new ResponseDate());
            basicHttpProcessor.addInterceptor(new ResponseServer());
            basicHttpProcessor.addInterceptor(new ResponseContent());
            basicHttpProcessor.addInterceptor(new ResponseConnControl());
            HttpService httpService = new HttpService(basicHttpProcessor, new DefaultConnectionReuseStrategy(), new DefaultHttpResponseFactory());
            httpService.setParams(parameter);
            httpService.setHandlerResolver(this.f11559b);
            this.f11560c.add(new RequestListenerThread(this, socketAddress, httpService, parameter, this.f11563f));
        }
        Iterator it = this.f11560c.iterator();
        while (it.hasNext()) {
            RequestListenerThread requestListenerThread = (RequestListenerThread) it.next();
            a.add(RequestListenerThread.m12071a(requestListenerThread));
            requestListenerThread.start();
        }
        return a;
    }
}
