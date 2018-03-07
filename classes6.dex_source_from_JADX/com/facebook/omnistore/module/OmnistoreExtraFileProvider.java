package com.facebook.omnistore.module;

import android.net.Uri;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.bugreporter.BugReportExtraFileMapProvider;
import com.facebook.bugreporter.BugReportingXConfig;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.Omnistore;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: terminal */
public class OmnistoreExtraFileProvider implements BugReportExtraFileMapProvider, BugReportFileProvider {
    private static final String SOFT_REPORT_CATEGORY;
    private static final Class<?> TAG;
    private static volatile OmnistoreExtraFileProvider f3209xbf4b9448;
    private final AbstractFbErrorReporter mFbErrorReporter;
    private final OmnistoreSingletonProvider mOmnistoreProvider;
    private final XConfigReader mXConfigReader;

    public static com.facebook.omnistore.module.OmnistoreExtraFileProvider m4248x4992ee48(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3209xbf4b9448;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.omnistore.module.OmnistoreExtraFileProvider.class;
        monitor-enter(r1);
        r0 = f3209xbf4b9448;	 Catch:{ all -> 0x003a }
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
        r0 = m4247x6436b7ee(r0);	 Catch:{ all -> 0x0035 }
        f3209xbf4b9448 = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3209xbf4b9448;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.omnistore.module.OmnistoreExtraFileProvider.getInstance__com_facebook_omnistore_module_OmnistoreExtraFileProvider__INJECTED_BY_TemplateInjector(com.facebook.inject.InjectorLike):com.facebook.omnistore.module.OmnistoreExtraFileProvider");
    }

    private static OmnistoreExtraFileProvider m4247x6436b7ee(InjectorLike injectorLike) {
        return new OmnistoreExtraFileProvider(OmnistoreSingletonProvider.m4252xb8a83167(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), XConfigReader.a(injectorLike));
    }

    static {
        Class cls = OmnistoreExtraFileProvider.class;
        TAG = cls;
        SOFT_REPORT_CATEGORY = cls.getSimpleName();
    }

    @Inject
    public OmnistoreExtraFileProvider(OmnistoreSingletonProvider omnistoreSingletonProvider, AbstractFbErrorReporter abstractFbErrorReporter, XConfigReader xConfigReader) {
        this.mOmnistoreProvider = omnistoreSingletonProvider;
        this.mFbErrorReporter = abstractFbErrorReporter;
        this.mXConfigReader = xConfigReader;
    }

    public boolean shouldSendAsync() {
        return this.mXConfigReader.a(BugReportingXConfig.w, false);
    }

    public Map<String, String> getExtraFileFromWorkerThread(File file) {
        Map hashMap = new HashMap();
        try {
            hashMap.put("omnistore.txt", getOmnistoreDebugInfoFile(file).toString());
        } catch (Throwable e) {
            this.mFbErrorReporter.a(SOFT_REPORT_CATEGORY, e);
        }
        for (String file2 : getReportFiles(file.toString())) {
            File file3 = new File(file2);
            hashMap.put(file3.getName(), Uri.fromFile(file3).toString());
        }
        return hashMap;
    }

    public void prepareDataForWriting() {
    }

    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        List<BugReportFile> a = Lists.a();
        a.add(new BugReportFile("omnistore.txt", getOmnistoreDebugInfoFile(file).toString(), "text/plain"));
        for (String file2 : getReportFiles(file.toString())) {
            File file3 = new File(file2);
            a.add(new BugReportFile(file3.getName(), Uri.fromFile(file3).toString(), "text/plain"));
        }
        return a;
    }

    private Uri getOmnistoreDebugInfoFile(File file) {
        Throwable th;
        File file2 = new File(file, "omnistore.txt");
        OutputStream fileOutputStream = new FileOutputStream(file2);
        Throwable th2 = null;
        try {
            Omnistore instance = this.mOmnistoreProvider.getInstance();
            if (instance != null) {
                PrintWriter printWriter = new PrintWriter(fileOutputStream);
                System.out.println(instance.getDebugInfo());
                printWriter.write(instance.getDebugInfo());
                printWriter.flush();
            }
            Uri fromFile = Uri.fromFile(file2);
            fileOutputStream.close();
            return fromFile;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (th22 != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable th4) {
                AndroidCompat.addSuppressed(th22, th4);
            }
        } else {
            fileOutputStream.close();
        }
        throw th;
    }

    private String[] getReportFiles(String str) {
        Omnistore instance = this.mOmnistoreProvider.getInstance();
        return instance == null ? new String[0] : instance.writeBugReport(str);
    }
}
