package com.facebook.rtc.bugreporter;

import com.facebook.bugreporter.BugReportExtraFileMapProvider;
import com.facebook.bugreporter.BugReportingXConfig;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.EvictingQueue;
import com.google.common.collect.Lists;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: location_error_type */
public class RtcBugReportLogger implements BugReportExtraFileMapProvider, BugReportFileProvider {
    private static final Class<?> f9156a = RtcBugReportLogger.class;
    private static volatile RtcBugReportLogger f9157e;
    private final XConfigReader f9158b;
    private final EvictingQueue<String> f9159c = EvictingQueue.m9494a(1000);
    private final SimpleDateFormat f9160d = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.US);

    public static com.facebook.rtc.bugreporter.RtcBugReportLogger m9491a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9157e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.bugreporter.RtcBugReportLogger.class;
        monitor-enter(r1);
        r0 = f9157e;	 Catch:{ all -> 0x003a }
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
        r0 = m9492b(r0);	 Catch:{ all -> 0x0035 }
        f9157e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9157e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.bugreporter.RtcBugReportLogger.a(com.facebook.inject.InjectorLike):com.facebook.rtc.bugreporter.RtcBugReportLogger");
    }

    private static RtcBugReportLogger m9492b(InjectorLike injectorLike) {
        return new RtcBugReportLogger(XConfigReader.a(injectorLike));
    }

    @Inject
    public RtcBugReportLogger(XConfigReader xConfigReader) {
        this.f9158b = xConfigReader;
    }

    public final void m9493a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f9160d.format(new Date()));
        stringBuilder.append("> ");
        stringBuilder.append(str);
        this.f9159c.add(stringBuilder.toString());
    }

    public boolean shouldSendAsync() {
        return this.f9158b.a(BugReportingXConfig.f1681A, false);
    }

    public Map<String, String> getExtraFileFromWorkerThread(File file) {
        Map hashMap = new HashMap();
        try {
            if (!(this.f9159c == null || this.f9159c.isEmpty())) {
                hashMap.put("rtc_log.txt", m9490a(file).toString());
            }
        } catch (Throwable e) {
            BLog.a(f9156a, "Exception saving rtc trace", e);
        }
        return hashMap;
    }

    public void prepareDataForWriting() {
    }

    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        List<BugReportFile> a = Lists.a();
        if (!(this.f9159c == null || this.f9159c.isEmpty())) {
            a.add(new BugReportFile("rtc_log.txt", m9490a(file).toString(), "text/plain"));
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.net.Uri m9490a(java.io.File r8) {
        /*
        r7 = this;
        r2 = 0;
        r0 = new java.io.File;
        r1 = "rtc_log.txt";
        r0.<init>(r8, r1);
        r3 = android.net.Uri.fromFile(r0);
        r4 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0048 }
        r4.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0048 }
        r5 = new java.io.PrintWriter;	 Catch:{ Throwable -> 0x003d, all -> 0x005d }
        r0 = new java.io.OutputStreamWriter;	 Catch:{ Throwable -> 0x003d, all -> 0x005d }
        r0.<init>(r4);	 Catch:{ Throwable -> 0x003d, all -> 0x005d }
        r5.<init>(r0);	 Catch:{ Throwable -> 0x003d, all -> 0x005d }
        r0 = r7.f9159c;	 Catch:{ Throwable -> 0x0031, all -> 0x006c }
        r1 = r0.iterator();	 Catch:{ Throwable -> 0x0031, all -> 0x006c }
    L_0x0021:
        r0 = r1.hasNext();	 Catch:{ Throwable -> 0x0031, all -> 0x006c }
        if (r0 == 0) goto L_0x0051;
    L_0x0027:
        r0 = r1.next();	 Catch:{ Throwable -> 0x0031, all -> 0x006c }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x0031, all -> 0x006c }
        r5.println(r0);	 Catch:{ Throwable -> 0x0031, all -> 0x006c }
        goto L_0x0021;
    L_0x0031:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0033 }
    L_0x0033:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x0037:
        if (r1 == 0) goto L_0x005f;
    L_0x0039:
        r5.close();	 Catch:{ Throwable -> 0x0058, all -> 0x005d }
    L_0x003c:
        throw r0;	 Catch:{  }
    L_0x003d:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x003f }
    L_0x003f:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x0042:
        if (r2 == 0) goto L_0x0068;
    L_0x0044:
        r4.close();	 Catch:{ Throwable -> 0x0063 }
    L_0x0047:
        throw r0;	 Catch:{  }
    L_0x0048:
        r0 = move-exception;
        r1 = f9156a;
        r2 = "Cannot create/open trace file";
        com.facebook.debug.log.BLog.b(r1, r2, r0);
    L_0x0050:
        return r3;
    L_0x0051:
        r5.close();	 Catch:{  }
        r4.close();	 Catch:{  }
        goto L_0x0050;
    L_0x0058:
        r5 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r5);	 Catch:{  }
        goto L_0x003c;
    L_0x005d:
        r0 = move-exception;
        goto L_0x0042;
    L_0x005f:
        r5.close();	 Catch:{  }
        goto L_0x003c;
    L_0x0063:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r1);	 Catch:{  }
        goto L_0x0047;
    L_0x0068:
        r4.close();	 Catch:{  }
        goto L_0x0047;
    L_0x006c:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.bugreporter.RtcBugReportLogger.a(java.io.File):android.net.Uri");
    }
}
