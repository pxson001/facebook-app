package com.facebook.bugreporter;

import android.net.Uri;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Queues;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: sessionless_gk/ */
public class BugReportOperationLogger implements BugReportExtraFileMapProvider, BugReportFileProvider {
    private static volatile BugReportOperationLogger f2481f;
    public final Clock f2482a;
    private final ConcurrentLinkedQueue<EventRecord> f2483b = Queues.b();
    private final AbstractFbErrorReporter f2484c;
    private final XConfigReader f2485d;
    private Provider<Boolean> f2486e;

    public static com.facebook.bugreporter.BugReportOperationLogger m2756a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2481f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.bugreporter.BugReportOperationLogger.class;
        monitor-enter(r1);
        r0 = f2481f;	 Catch:{ all -> 0x003a }
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
        r0 = m2759b(r0);	 Catch:{ all -> 0x0035 }
        f2481f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2481f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bugreporter.BugReportOperationLogger.a(com.facebook.inject.InjectorLike):com.facebook.bugreporter.BugReportOperationLogger");
    }

    private static BugReportOperationLogger m2759b(InjectorLike injectorLike) {
        return new BugReportOperationLogger((Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 3907), XConfigReader.a(injectorLike));
    }

    @Inject
    public BugReportOperationLogger(Clock clock, FbErrorReporter fbErrorReporter, Provider<Boolean> provider, XConfigReader xConfigReader) {
        this.f2482a = clock;
        this.f2484c = fbErrorReporter;
        this.f2486e = provider;
        this.f2485d = xConfigReader;
    }

    public final void m2760a(String str, BugReportCategory bugReportCategory) {
        if (((Boolean) this.f2486e.get()).booleanValue()) {
            this.f2483b.add(new EventRecord(this.f2482a.a(), str, bugReportCategory));
            if (this.f2483b.size() > 50) {
                this.f2483b.remove();
            }
        }
    }

    public boolean shouldSendAsync() {
        return this.f2485d.a(BugReportingXConfig.f1690e, false);
    }

    public Map<String, String> getExtraFileFromWorkerThread(File file) {
        if (!((Boolean) this.f2486e.get()).booleanValue()) {
            return null;
        }
        try {
            Uri a = m2755a(file);
            Map<String, String> hashMap = new HashMap();
            hashMap.put("bugreport_operation_json.txt", a.toString());
            return hashMap;
        } catch (Throwable e) {
            this.f2484c.a("BugReportOperationLogger", e);
            return null;
        }
    }

    public void prepareDataForWriting() {
    }

    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        if (!((Boolean) this.f2486e.get()).booleanValue()) {
            return null;
        }
        List<BugReportFile> arrayList = new ArrayList();
        try {
            arrayList.add(new BugReportFile("bugreport_operation_json.txt", m2755a(file).toString(), "text/plain"));
            return arrayList;
        } catch (Throwable e) {
            throw new IOException("Failed to write recent events file", e);
        }
    }

    private Uri m2755a(File file) {
        Throwable th;
        File file2 = new File(file, "bugreport_operation_json.txt");
        PrintWriter printWriter = new PrintWriter(file2);
        Throwable th2 = null;
        try {
            printWriter.write(m2757a().toString());
            printWriter.close();
            return Uri.fromFile(file2);
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (th22 != null) {
            try {
                printWriter.close();
            } catch (Throwable th4) {
                AndroidCompat.addSuppressed(th22, th4);
            }
        } else {
            printWriter.close();
        }
        throw th;
        throw th;
    }

    private JSONObject m2757a() {
        JSONObject jSONObject = new JSONObject();
        Iterator it = this.f2483b.iterator();
        int i = 1;
        while (it.hasNext()) {
            Object obj;
            EventRecord eventRecord = (EventRecord) it.next();
            if (this.f2482a.a() - eventRecord.a > 900000) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                jSONObject.put(String.valueOf(i), m2758a(eventRecord));
                i++;
            }
        }
        return jSONObject;
    }

    @VisibleForTesting
    private static JSONObject m2758a(EventRecord eventRecord) {
        return new JSONObject().put("recordTime", eventRecord.a).put("category", eventRecord.c.toString()).put("operation", eventRecord.b);
    }
}
