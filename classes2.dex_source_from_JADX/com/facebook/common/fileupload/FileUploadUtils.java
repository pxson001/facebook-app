package com.facebook.common.fileupload;

import android.content.Context;
import android.os.Environment;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.google.common.io.Closeables;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: video_daily_data_usage */
public class FileUploadUtils {
    private static final Class<?> f1224a = FileUploadUtils.class;
    private static volatile FileUploadUtils f1225c;
    private final Context f1226b;

    public static com.facebook.common.fileupload.FileUploadUtils m2358a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1225c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.fileupload.FileUploadUtils.class;
        monitor-enter(r1);
        r0 = f1225c;	 Catch:{ all -> 0x003a }
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
        r0 = m2360b(r0);	 Catch:{ all -> 0x0035 }
        f1225c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1225c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.fileupload.FileUploadUtils.a(com.facebook.inject.InjectorLike):com.facebook.common.fileupload.FileUploadUtils");
    }

    private static FileUploadUtils m2360b(InjectorLike injectorLike) {
        return new FileUploadUtils((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public FileUploadUtils(Context context) {
        this.f1226b = context;
    }

    public final File[] m2364a(String str, Pattern pattern) {
        if (str == null) {
            return new File[0];
        }
        File[] fileArr;
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(new 1(this, pattern));
            Integer.valueOf(listFiles == null ? 0 : listFiles.length);
            fileArr = listFiles;
        } else {
            fileArr = null;
        }
        return fileArr;
    }

    public final String m2362a() {
        return this.f1226b.getFilesDir().getPath();
    }

    public static String m2361b() {
        return Environment.getExternalStorageDirectory().getPath();
    }

    public final String m2365c() {
        String str = null;
        try {
            str = this.f1226b.getExternalFilesDir(null).getPath();
        } catch (Throwable e) {
            BLog.a(f1224a, e, "Error: Failure while trying to access external files storage directroy", new Object[0]);
        }
        return str;
    }

    public final void m2363a(File file, File file2) {
        Closeable fileOutputStream;
        Closeable gZIPOutputStream;
        Throwable th;
        IOException a;
        IOException a2;
        Closeable closeable = null;
        IOException a3;
        try {
            Closeable fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream = null;
                    closeable = fileOutputStream;
                    fileOutputStream = fileInputStream;
                    a = m2359a(fileOutputStream, true);
                    a2 = m2359a(gZIPOutputStream, true);
                    a3 = m2359a(closeable, true);
                    if (a == null) {
                        throw a;
                    } else if (a2 == null) {
                        throw a2;
                    } else if (a3 == null) {
                        throw th;
                    } else {
                        throw a3;
                    }
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        gZIPOutputStream.write(bArr, 0, read);
                    }
                    gZIPOutputStream.flush();
                    IOException a4 = m2359a(fileInputStream, false);
                    a2 = m2359a(gZIPOutputStream, false);
                    a3 = m2359a(fileOutputStream, false);
                    if (a4 != null) {
                        throw a4;
                    } else if (a2 != null) {
                        throw a2;
                    } else if (a3 != null) {
                        throw a3;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = fileOutputStream;
                    fileOutputStream = fileInputStream;
                    a = m2359a(fileOutputStream, true);
                    a2 = m2359a(gZIPOutputStream, true);
                    a3 = m2359a(closeable, true);
                    if (a == null) {
                        throw a;
                    } else if (a2 == null) {
                        throw a2;
                    } else if (a3 == null) {
                        throw a3;
                    } else {
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                gZIPOutputStream = null;
                fileOutputStream = fileInputStream;
                a = m2359a(fileOutputStream, true);
                a2 = m2359a(gZIPOutputStream, true);
                a3 = m2359a(closeable, true);
                if (a == null) {
                    throw a;
                } else if (a2 == null) {
                    throw a2;
                } else if (a3 == null) {
                    throw a3;
                } else {
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            gZIPOutputStream = null;
            fileOutputStream = null;
            a = m2359a(fileOutputStream, true);
            a2 = m2359a(gZIPOutputStream, true);
            a3 = m2359a(closeable, true);
            if (a == null) {
                throw a;
            } else if (a2 == null) {
                throw a2;
            } else if (a3 == null) {
                throw th;
            } else {
                throw a3;
            }
        }
    }

    private static IOException m2359a(Closeable closeable, boolean z) {
        try {
            Closeables.m21581a(closeable, z);
            return null;
        } catch (IOException e) {
            return e;
        }
    }
}
