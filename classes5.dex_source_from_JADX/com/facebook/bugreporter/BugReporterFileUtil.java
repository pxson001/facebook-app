package com.facebook.bugreporter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import com.facebook.acra.ErrorReporter;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.inject.InjectorLike;
import com.google.common.io.ByteStreams;
import com.google.common.io.Closeables;
import com.google.common.io.Files;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: android.media.metadata.TRACK_NUMBER */
public class BugReporterFileUtil {
    private static final Class<?> f10624a = BugReporterFileUtil.class;
    private static volatile BugReporterFileUtil f10625d;
    public final Context f10626b;
    public final Executor f10627c;

    /* compiled from: android.media.metadata.TRACK_NUMBER */
    public class C10171 implements Runnable {
        final /* synthetic */ Uri f10622a;
        final /* synthetic */ BugReporterFileUtil f10623b;

        public C10171(BugReporterFileUtil bugReporterFileUtil, Uri uri) {
            this.f10623b = bugReporterFileUtil;
            this.f10622a = uri;
        }

        public void run() {
            this.f10623b.m18657b(this.f10622a);
        }
    }

    public static com.facebook.bugreporter.BugReporterFileUtil m18646a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10625d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.bugreporter.BugReporterFileUtil.class;
        monitor-enter(r1);
        r0 = f10625d;	 Catch:{ all -> 0x003a }
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
        r0 = m18653b(r0);	 Catch:{ all -> 0x0035 }
        f10625d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10625d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bugreporter.BugReporterFileUtil.a(com.facebook.inject.InjectorLike):com.facebook.bugreporter.BugReporterFileUtil");
    }

    private static BugReporterFileUtil m18653b(InjectorLike injectorLike) {
        return new BugReporterFileUtil((Context) injectorLike.getInstance(Context.class), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    public static void m18649a(File file, BugReportAttachment bugReportAttachment) {
        Files.a(file, bugReportAttachment.f10429a);
        bugReportAttachment.f10429a.flush();
        bugReportAttachment.f10429a.close();
    }

    public static void m18650a(InputStream inputStream, BugReportAttachment bugReportAttachment) {
        ByteStreams.a(inputStream, bugReportAttachment.f10429a);
    }

    @Inject
    public BugReporterFileUtil(Context context, ExecutorService executorService) {
        this.f10626b = context;
        this.f10627c = executorService;
    }

    public final File m18655a(String str) {
        return m18647a("bugreports", str);
    }

    public final File m18656b(String str) {
        return m18647a("bugreport_attachments", str);
    }

    public static BugReportAttachment m18645a(File file, String str) {
        File file2 = new File(file, str);
        return new BugReportAttachment(Uri.fromFile(file2), new FileOutputStream(file2));
    }

    public final void m18657b(Uri uri) {
        try {
            m18648a(new File(new URI(uri.toString())));
        } catch (Throwable e) {
            BLog.b(f10624a, "Cannot parse Bug Report Directory URI", e);
        }
    }

    protected final BugReport m18654a(BugReport bugReport) {
        BugReport x = BugReport.newBuilder().m18535a(bugReport).m18533a(bugReport.m18523s() + 1).m18542x();
        try {
            m18658b(x);
        } catch (Throwable e) {
            BLog.b(f10624a, e, "Failed to persist serialized bug report.", new Object[0]);
        }
        return x;
    }

    public static void m18648a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.exists()) {
                    file2.delete();
                }
            }
        }
        file.delete();
    }

    public static Uri m18651b(File file, String str) {
        File file2 = new File(file, str);
        Closeable bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        try {
            ErrorReporter.getInstance().writeReportToStream(null, bufferedOutputStream);
            bufferedOutputStream.flush();
            Uri fromFile = Uri.fromFile(file2);
            return fromFile;
        } finally {
            Closeables.a(bufferedOutputStream, false);
        }
    }

    @SuppressLint({"InstanceMethodCanBeStatic", "AndroidTrapInstanceMethodCanBeStatic"})
    public static BugReport m18652b(File file) {
        BufferedInputStream bufferedInputStream;
        Throwable e;
        BugReport bugReport = null;
        try {
            File file2 = new File(file, "SerializedBugReport");
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
            try {
                byte[] bArr = new byte[((int) file2.length())];
                bufferedInputStream.read(bArr, 0, bArr.length);
                bugReport = new BugReport(ByteBuffer.wrap(bArr));
            } catch (FileNotFoundException e2) {
                e = e2;
                BLog.b(f10624a, e, "Failed to retrieve the persisted bug report!", new Object[0]);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable e3) {
                        BLog.b(f10624a, e3, "Failed to release the file reader!", new Object[0]);
                    }
                }
                return bugReport;
            } catch (IOException e4) {
                e3 = e4;
                BLog.b(f10624a, e3, "Failed to retrieve the persisted bug report!", new Object[0]);
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return bugReport;
            }
        } catch (FileNotFoundException e5) {
            e3 = e5;
            bufferedInputStream = null;
            BLog.b(f10624a, e3, "Failed to retrieve the persisted bug report!", new Object[0]);
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return bugReport;
        } catch (IOException e6) {
            e3 = e6;
            bufferedInputStream = null;
            BLog.b(f10624a, e3, "Failed to retrieve the persisted bug report!", new Object[0]);
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return bugReport;
        }
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        return bugReport;
    }

    public final void m18658b(BugReport bugReport) {
        BugReportAttachment bugReportAttachment = null;
        try {
            bugReportAttachment = m18645a(new File(bugReport.m18504a().getPath()), "SerializedBugReport");
            m18650a(new ByteArrayInputStream(FlatBufferBuilder.b(bugReport)), bugReportAttachment);
        } finally {
            if (bugReportAttachment != null) {
                bugReportAttachment.m18526a().close();
            }
        }
    }

    private File m18647a(String str, String str2) {
        Throwable e;
        File file;
        try {
            file = new File(new File(this.f10626b.getCacheDir(), str), str2);
            try {
                if (file.mkdirs()) {
                    return file;
                }
                return null;
            } catch (NullPointerException e2) {
                e = e2;
                BLog.b(f10624a, "Exception caught in createDirectory", e);
                return file;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            file = null;
            e = th;
            BLog.b(f10624a, "Exception caught in createDirectory", e);
            return file;
        }
    }
}
