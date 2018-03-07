package com.facebook.bugreporter;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: android.resource */
public class BugReportAttachmentUploader {
    private static final Class<?> f10434a = BugReportAttachmentUploader.class;
    private static volatile BugReportAttachmentUploader f10435e;
    private final AbstractSingleMethodRunner f10436b;
    private final BugReportAttachmentUploadMethod f10437c;
    private final AbstractFbErrorReporter f10438d;

    public static com.facebook.bugreporter.BugReportAttachmentUploader m18530a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10435e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.bugreporter.BugReportAttachmentUploader.class;
        monitor-enter(r1);
        r0 = f10435e;	 Catch:{ all -> 0x003a }
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
        r0 = m18531b(r0);	 Catch:{ all -> 0x0035 }
        f10435e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10435e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bugreporter.BugReportAttachmentUploader.a(com.facebook.inject.InjectorLike):com.facebook.bugreporter.BugReportAttachmentUploader");
    }

    private static BugReportAttachmentUploader m18531b(InjectorLike injectorLike) {
        return new BugReportAttachmentUploader((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new BugReportAttachmentUploadMethod(), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public BugReportAttachmentUploader(AbstractSingleMethodRunner abstractSingleMethodRunner, BugReportAttachmentUploadMethod bugReportAttachmentUploadMethod, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f10436b = abstractSingleMethodRunner;
        this.f10437c = bugReportAttachmentUploadMethod;
        this.f10438d = abstractFbErrorReporter;
    }

    public final boolean m18532a(String str, File file, String str2) {
        try {
            return ((Boolean) this.f10436b.a(this.f10437c, new BugReportAttachmentUploadParams(str2, str, file))).booleanValue();
        } catch (Throwable e) {
            BLog.b(f10434a, e, "Unable to upload attachment: %s", new Object[]{str});
            this.f10438d.a(f10434a.getSimpleName(), e);
            return false;
        }
    }
}
