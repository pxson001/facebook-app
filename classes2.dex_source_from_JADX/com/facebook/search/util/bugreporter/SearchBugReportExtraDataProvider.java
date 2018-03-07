package com.facebook.search.util.bugreporter;

import android.net.Uri;
import com.facebook.bugreporter.BugReportExtraFileMapProvider;
import com.facebook.bugreporter.BugReportingXConfig;
import com.facebook.common.diagnostics.TraceLogger;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.io.Closeables;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: interstitials_fetch_updated */
public class SearchBugReportExtraDataProvider implements BugReportExtraFileMapProvider, BugReportFileProvider {
    private static final Class<?> f19641a = SearchBugReportExtraDataProvider.class;
    private static volatile SearchBugReportExtraDataProvider f19642d;
    private final TraceLogger f19643b = new TraceLogger(0, 200);
    private final XConfigReader f19644c;

    public static com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider m27370a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19642d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider.class;
        monitor-enter(r1);
        r0 = f19642d;	 Catch:{ all -> 0x003a }
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
        r0 = m27371b(r0);	 Catch:{ all -> 0x0035 }
        f19642d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19642d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider.a(com.facebook.inject.InjectorLike):com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider");
    }

    private static SearchBugReportExtraDataProvider m27371b(InjectorLike injectorLike) {
        return new SearchBugReportExtraDataProvider(XConfigReader.m2681a(injectorLike));
    }

    @Inject
    public SearchBugReportExtraDataProvider(XConfigReader xConfigReader) {
        this.f19644c = xConfigReader;
    }

    public boolean shouldSendAsync() {
        return this.f19644c.m2686a(BugReportingXConfig.B, false);
    }

    public Map<String, String> getExtraFileFromWorkerThread(File file) {
        try {
            return ImmutableBiMap.m978b("search_events.txt", m27369a(file).toString());
        } catch (Throwable e) {
            BLog.a(f19641a, "Exception saving search events log", e);
            return null;
        }
    }

    public void prepareDataForWriting() {
    }

    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        List<BugReportFile> arrayList = new ArrayList();
        try {
            arrayList.add(new BugReportFile("search_events.txt", m27369a(file).toString(), "text/plain"));
            return arrayList;
        } catch (Throwable e) {
            throw new IOException("Failed to write search events log file", e);
        }
    }

    private Uri m27369a(File file) {
        File file2 = new File(file, "search_events.txt");
        Closeable printWriter = new PrintWriter(new FileOutputStream(file2));
        try {
            printWriter.write(this.f19643b.toString());
            Uri fromFile = Uri.fromFile(file2);
            return fromFile;
        } finally {
            Closeables.m21581a(printWriter, false);
        }
    }

    public final void m27373a(String str, SearchBugReportEvent searchBugReportEvent, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(").append(DateFormat.getDateTimeInstance().format(new Date())).append(") ").append("[" + str + "] ").append(searchBugReportEvent.toString()).append(", ").append(str2);
        this.f19643b.m4284a(stringBuilder.toString());
    }

    public final void m27372a(String str, SearchBugReportEvent searchBugReportEvent) {
        m27373a(str, searchBugReportEvent, "");
    }
}
