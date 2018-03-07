package com.facebook.common.errorreporting.persisteduid;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.inject.InjectorLike;
import com.google.common.io.Closeables;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sync_snap_to_success */
public class UserIdFileWriter {
    private static volatile UserIdFileWriter f1407e;
    private final String f1408a = "uid_";
    private final String f1409b = "_temp";
    private final Context f1410c;
    private String f1411d = null;

    public static com.facebook.common.errorreporting.persisteduid.UserIdFileWriter m1649a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1407e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.errorreporting.persisteduid.UserIdFileWriter.class;
        monitor-enter(r1);
        r0 = f1407e;	 Catch:{ all -> 0x003a }
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
        r0 = m1651b(r0);	 Catch:{ all -> 0x0035 }
        f1407e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1407e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.errorreporting.persisteduid.UserIdFileWriter.a(com.facebook.inject.InjectorLike):com.facebook.common.errorreporting.persisteduid.UserIdFileWriter");
    }

    private static UserIdFileWriter m1651b(InjectorLike injectorLike) {
        return new UserIdFileWriter((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public UserIdFileWriter(Context context) {
        this.f1410c = context;
    }

    public final synchronized void m1652a(String str) {
        Closeable fileOutputStream;
        Throwable th;
        if (!(TextUtils.isEmpty(str) || str.equals(this.f1411d))) {
            Closeable closeable = null;
            try {
                m1650a();
                File createTempFile = File.createTempFile("uid_", "_temp", UserIdFileUtils.b(this.f1410c));
                File a = UserIdFileUtils.a(this.f1410c);
                fileOutputStream = new FileOutputStream(createTempFile);
                try {
                    fileOutputStream.write(str.getBytes("UTF-8"));
                    if (createTempFile.renameTo(a)) {
                        this.f1411d = str;
                        try {
                            Closeables.a(fileOutputStream, true);
                        } catch (IOException e) {
                        }
                    } else {
                        throw new IOException("Renaming temporary file failed");
                    }
                } catch (IOException e2) {
                    try {
                        Closeables.a(fileOutputStream, true);
                    } catch (IOException e3) {
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    closeable = fileOutputStream;
                    th = th3;
                    try {
                        Closeables.a(closeable, true);
                    } catch (IOException e4) {
                    }
                    throw th;
                }
            } catch (IOException e5) {
                fileOutputStream = null;
                Closeables.a(fileOutputStream, true);
            } catch (Throwable th4) {
                th = th4;
                Closeables.a(closeable, true);
                throw th;
            }
        }
    }

    private void m1650a() {
        for (File file : UserIdFileUtils.b(this.f1410c).listFiles()) {
            if (file.getName().startsWith("uid_") && file.getName().endsWith("_temp")) {
                file.delete();
            }
        }
    }
}
