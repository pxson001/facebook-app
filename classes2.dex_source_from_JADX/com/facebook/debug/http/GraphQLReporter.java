package com.facebook.debug.http;

import android.os.Environment;
import com.facebook.androidinternals.android.os.SystemPropertiesInternal;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.debug.http.DebugHttpFlowReporter.ErrorResponseInfo;
import com.facebook.debug.http.DebugHttpFlowReporter.RequestInfo;
import com.facebook.debug.http.DebugHttpFlowReporter.ResponseInfo;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.flatbuffer.FlatBufferBatchResponsesVisualizer;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: not used in GWT */
public class GraphQLReporter implements DebugHttpFlowReporter {
    private static Future<String> f12174a;
    private static String f12175b;
    private static volatile GraphQLReporter f12176i;
    public String f12177c;
    public boolean f12178d;
    public String f12179e;
    private Map<String, GraphQLReport> f12180f = Collections.synchronizedMap(new HashMap());
    private File f12181g;
    private final ExecutorService f12182h;

    public static com.facebook.debug.http.GraphQLReporter m17887a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12176i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.debug.http.GraphQLReporter.class;
        monitor-enter(r1);
        r0 = f12176i;	 Catch:{ all -> 0x003a }
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
        r0 = m17895b(r0);	 Catch:{ all -> 0x0035 }
        f12176i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12176i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.debug.http.GraphQLReporter.a(com.facebook.inject.InjectorLike):com.facebook.debug.http.GraphQLReporter");
    }

    private static GraphQLReporter m17895b(InjectorLike injectorLike) {
        return new GraphQLReporter(C0055x2995691a.m1881a(injectorLike));
    }

    @Inject
    public GraphQLReporter(ExecutorService executorService) {
        this.f12182h = executorService;
        if (mo2291a()) {
            f12174a = ExecutorDetour.a(this.f12182h, new Request("http://our.graph.prod.intern.facebook.com/intern/flatbuffer_schema/10154690582226729"), 1050138810);
        }
    }

    public final void mo2289a(RequestInfo requestInfo) {
        GraphQLReport b = m17894b(requestInfo);
        if (b != null) {
            this.f12180f.put(requestInfo.a, b);
        }
    }

    public final void mo2290a(ResponseInfo responseInfo) {
        GraphQLReport graphQLReport = (GraphQLReport) this.f12180f.remove(responseInfo.c);
        if (graphQLReport != null) {
            try {
                StringBuilder a = m17888a(graphQLReport);
                graphQLReport.c = responseInfo.d;
                m17890a(a, graphQLReport.c - graphQLReport.b);
                graphQLReport.g = String.valueOf(responseInfo.e.getStatusLine().getStatusCode());
                a.append("Response: " + graphQLReport.g + "\n");
                if (responseInfo.f != null) {
                    if (m17897b(graphQLReport.f)) {
                        m17891a(responseInfo.f, a, graphQLReport);
                    } else {
                        graphQLReport.h = new String(responseInfo.f, "UTF-8");
                        String[] split = graphQLReport.h.split("\n");
                        for (int i = 0; i < split.length; i++) {
                            a.append("===Line " + i + "===\n");
                            String trim = split[i].trim();
                            if (!this.f12178d || trim.isEmpty()) {
                                a.append(split[i] + "\n");
                            } else {
                                try {
                                    a.append(new JSONObject(trim).toString(2) + "\n");
                                } catch (JSONException e) {
                                    a.append(trim + "\n");
                                }
                            }
                        }
                    }
                }
                m17896b(a.toString() + "\n");
            } catch (Exception e2) {
            }
        }
    }

    public final void mo2288a(ErrorResponseInfo errorResponseInfo) {
        GraphQLReport graphQLReport = (GraphQLReport) this.f12180f.remove(errorResponseInfo.c);
        if (graphQLReport != null) {
            try {
                StringBuilder a = m17888a(graphQLReport);
                graphQLReport.c = errorResponseInfo.d;
                m17890a(a, graphQLReport.c - graphQLReport.b);
                graphQLReport.i = errorResponseInfo.a;
                a.append("Response: " + graphQLReport.i + "\n");
                m17896b(a.toString() + "\n");
            } catch (Exception e) {
            }
        }
    }

    private GraphQLReport m17894b(RequestInfo requestInfo) {
        GraphQLReport graphQLReport = new GraphQLReport();
        graphQLReport.d = requestInfo.c.getRequestLine().getMethod();
        graphQLReport.e = requestInfo.c.getRequestLine().getUri();
        if (!m17892a(graphQLReport.d, graphQLReport.e)) {
            return null;
        }
        if (requestInfo.d != null) {
            try {
                graphQLReport.f = m17889a(new String(requestInfo.d, "UTF-8"));
            } catch (Exception e) {
            }
        }
        if (graphQLReport.f == null || !m17893a(graphQLReport.f)) {
            return null;
        }
        graphQLReport.a = requestInfo.a;
        graphQLReport.b = requestInfo.b;
        return graphQLReport;
    }

    private static boolean m17892a(String str, String str2) {
        if (str == null || !str.equals("POST") || str2 == null || !str2.matches(".*graph.*\\.facebook\\.com.*")) {
            return false;
        }
        return true;
    }

    private boolean m17893a(Map<String, String> map) {
        String str = (String) map.get("fb_api_req_friendly_name");
        if (str == null || !this.f12177c.contains(str)) {
            return false;
        }
        return true;
    }

    private static Map<String, String> m17889a(String str) {
        String[] split = str.split("&");
        Map<String, String> hashMap = new HashMap();
        for (String split2 : split) {
            String[] split3 = split2.split("=");
            hashMap.put(URLDecoder.decode(split3[0], "UTF-8"), URLDecoder.decode(split3[1], "UTF-8"));
        }
        return hashMap;
    }

    private static boolean m17897b(Map<String, String> map) {
        if ("flatbuffer".equals((String) map.get("response_format"))) {
            return true;
        }
        return false;
    }

    private static StringBuilder m17888a(GraphQLReport graphQLReport) {
        StringBuilder stringBuilder = new StringBuilder(1024);
        stringBuilder.append("Request_" + graphQLReport.a + "\n");
        stringBuilder.append(graphQLReport.d + " " + graphQLReport.e + "\n");
        for (Entry entry : graphQLReport.f.entrySet()) {
            stringBuilder.append("  ");
            stringBuilder.append(((String) entry.getKey()) + " = " + ((String) entry.getValue()));
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }

    private static void m17890a(StringBuilder stringBuilder, long j) {
        stringBuilder.append("Receive Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(new Date()) + "\n");
        stringBuilder.append("Duration: " + j + "ms\n");
    }

    public final boolean mo2291a() {
        this.f12177c = SystemPropertiesInternal.a("fb.graphql.friendlyname");
        this.f12178d = "yes".equals(SystemPropertiesInternal.a("fb.graphql.prettyjson"));
        this.f12179e = SystemPropertiesInternal.a("fb.graphql.dumpname");
        return (this.f12177c.isEmpty() || this.f12177c.equals("null") || this.f12179e.isEmpty() || this.f12179e.equals("null")) ? false : true;
    }

    private synchronized void m17896b(String str) {
        if (m17898c()) {
            Files.b(str, this.f12181g, Charsets.UTF_8);
        }
    }

    private synchronized boolean m17898c() {
        String path = Environment.getExternalStorageDirectory().getPath();
        String str = this.f12179e;
        if (!(path.isEmpty() || str.isEmpty() || (this.f12181g != null && this.f12181g.getName().equals(str)))) {
            this.f12181g = new File(path, str);
        }
        return this.f12181g != null;
    }

    private void m17891a(byte[] bArr, StringBuilder stringBuilder, GraphQLReport graphQLReport) {
        String str;
        RuntimeException e;
        if (f12175b == null) {
            try {
                if (f12174a == null || !f12174a.isDone()) {
                    if (f12174a == null) {
                        f12174a = ExecutorDetour.a(this.f12182h, new Request("http://our.graph.prod.intern.facebook.com/intern/flatbuffer_schema/10154690582226729"), 373638357);
                    }
                    str = "Flatbuffer schema has not finished downloading. \n Here is the raw response body: \n" + new String(bArr, "UTF-8");
                    stringBuilder.append(str);
                    graphQLReport.h = str;
                    return;
                }
                f12175b = (String) FutureDetour.a(f12174a, -986888510);
                f12175b = "{ \n" + f12175b.substring(f12175b.indexOf(10) + 1);
            } catch (InterruptedException e2) {
                str = "Thread interrupted while downloading flatbuffer schema: " + e2.getMessage() + "\n Here is the raw response body: \n" + new String(bArr, "UTF-8");
                stringBuilder.append(str);
                graphQLReport.h = str;
                return;
            } catch (ExecutionException e3) {
                str = "Error while downloading flatbuffer schema: " + e3.getMessage() + "\n Here is the raw response body: \n" + new String(bArr, "UTF-8");
                stringBuilder.append(str);
                graphQLReport.h = str;
                return;
            } catch (StringIndexOutOfBoundsException e4) {
                e = e4;
                str = "Did not successfully download the correct flatbuffer schema: " + e.getMessage() + "\n Here is the raw response body: \n" + new String(bArr, "UTF-8");
                stringBuilder.append(str);
                graphQLReport.h = str;
                return;
            } catch (NullPointerException e5) {
                e = e5;
                str = "Did not successfully download the correct flatbuffer schema: " + e.getMessage() + "\n Here is the raw response body: \n" + new String(bArr, "UTF-8");
                stringBuilder.append(str);
                graphQLReport.h = str;
                return;
            }
        }
        JSONArray a = FlatBufferBatchResponsesVisualizer.a(new DataInputStream(new ByteArrayInputStream(bArr)), f12175b);
        for (int i = 0; i < a.length(); i++) {
            stringBuilder.append("===Line " + i + "===\n");
            JSONObject jSONObject = a.getJSONObject(i);
            if (this.f12178d) {
                stringBuilder.append(jSONObject.toString(2) + "\n");
            } else {
                stringBuilder.append(jSONObject.toString() + "\n");
            }
        }
    }
}
