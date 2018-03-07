package com.facebook.http.executors.liger.utils;

import android.net.Uri;
import com.facebook.bugreporter.BugReportExtraFileMapProvider;
import com.facebook.bugreporter.BugReportingXConfig;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.EventBase;
import com.facebook.proxygen.utils.CircularEventLog;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import com.google.common.io.Closeables;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: proxy_port */
public class NetworkEventLog implements BugReportExtraFileMapProvider, BugReportFileProvider {
    private static final Class<?> f8712a = NetworkEventLog.class;
    private static CircularEventLog f8713b;
    private static volatile NetworkEventLog f8714d;
    private final XConfigReader f8715c;

    public static com.facebook.http.executors.liger.utils.NetworkEventLog m13532a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8714d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.executors.liger.utils.NetworkEventLog.class;
        monitor-enter(r1);
        r0 = f8714d;	 Catch:{ all -> 0x003a }
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
        r0 = m13535b(r0);	 Catch:{ all -> 0x0035 }
        f8714d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8714d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.executors.liger.utils.NetworkEventLog.a(com.facebook.inject.InjectorLike):com.facebook.http.executors.liger.utils.NetworkEventLog");
    }

    private static NetworkEventLog m13535b(InjectorLike injectorLike) {
        return new NetworkEventLog(XConfigReader.m2681a(injectorLike));
    }

    @Inject
    public NetworkEventLog(XConfigReader xConfigReader) {
        this.f8715c = xConfigReader;
    }

    public static void m13534a(EventBase eventBase) {
        f8713b = new CircularEventLog(eventBase, 100);
    }

    public static void m13533a() {
        f8713b.init();
    }

    public boolean shouldSendAsync() {
        return this.f8715c.m2686a(BugReportingXConfig.i, false);
    }

    public Map<String, String> getExtraFileFromWorkerThread(File file) {
        Builder builder = ImmutableMap.builder();
        if (f8713b != null && f8713b.isInitialized()) {
            try {
                builder.m609b("fb_liger_reporting", m13531a(file).toString());
            } catch (Throwable e) {
                BLog.a(f8712a, "Exception saving liger trace", e);
            }
        }
        return builder.m610b();
    }

    public void prepareDataForWriting() {
    }

    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        List<BugReportFile> a = Lists.m1296a();
        if (f8713b != null && f8713b.mInitialized) {
            a.add(new BugReportFile("fb_liger_reporting", m13531a(file).toString(), "text/plain"));
        }
        return a;
    }

    private static Uri m13531a(File file) {
        boolean z = false;
        boolean file2 = new File(file, "fb_liger_reporting");
        Uri fromFile = Uri.fromFile(file2);
        Closeable fileOutputStream = new FileOutputStream(file2);
        Closeable printWriter;
        try {
            file2 = new OutputStreamWriter(fileOutputStream);
            printWriter = new PrintWriter(file2);
            try {
                String[] logLines = f8713b.getLogLines();
                boolean length = logLines.length;
                file2 = false;
                while (file2 < length) {
                    printWriter.println(logLines[file2]);
                    file2++;
                }
            } finally {
                fromFile = null;
                Closeables.m21581a(printWriter, false);
            }
        } finally {
            fileOutputStream = 
/*
Method generation error in method: com.facebook.http.executors.liger.utils.NetworkEventLog.a(java.io.File):android.net.Uri
jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r3_2 'fileOutputStream' java.io.Closeable) = (r3_0 'fileOutputStream' java.io.Closeable), (r4_0 'printWriter' java.io.Closeable) in method: com.facebook.http.executors.liger.utils.NetworkEventLog.a(java.io.File):android.net.Uri
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 21 more

*/
        }
