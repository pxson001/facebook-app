package com.facebook.common.file;

import android.net.Uri;
import android.os.Environment;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Predicate;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Stack;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: thread_key */
public class MoreFileUtils {
    private static volatile MoreFileUtils f3038b;
    private final FileNativeLibrary f3039a;

    public static com.facebook.common.file.MoreFileUtils m5023a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3038b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.file.MoreFileUtils.class;
        monitor-enter(r1);
        r0 = f3038b;	 Catch:{ all -> 0x003a }
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
        r0 = m5032b(r0);	 Catch:{ all -> 0x0035 }
        f3038b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3038b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.file.MoreFileUtils.a(com.facebook.inject.InjectorLike):com.facebook.common.file.MoreFileUtils");
    }

    public static java.io.File m5024a(android.content.Context r6, android.os.ParcelFileDescriptor r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:20:0x0044 in {17, 19, 22, 26, 27, 28, 29, 30, 31, 33} preds:[]
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
        r1 = 0;
        if (r6 == 0) goto L_0x003d;
    L_0x0003:
        if (r7 == 0) goto L_0x003d;
    L_0x0005:
        r0 = android.text.TextUtils.isEmpty(r8);
        if (r0 != 0) goto L_0x003d;
    L_0x000b:
        r0 = new java.io.File;
        r2 = r6.getFilesDir();
        r0.<init>(r2, r8);
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0048 }
        r3 = r7.getFileDescriptor();	 Catch:{ Exception -> 0x0048 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0048 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0048 }
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ Exception -> 0x0048 }
        r3.<init>(r2, r4);	 Catch:{ Exception -> 0x0048 }
        r2 = 1;
        r2 = r6.openFileOutput(r8, r2);	 Catch:{ all -> 0x0043 }
        r4 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x0043 }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ all -> 0x0043 }
        r4.<init>(r2, r5);	 Catch:{ all -> 0x0043 }
        com.google.common.io.ByteStreams.a(r3, r4);	 Catch:{ all -> 0x003e }
        r4.flush();	 Catch:{ all -> 0x003e }
        r4.close();
        r3.close();
    L_0x003c:
        r1 = r0;
    L_0x003d:
        return r1;
    L_0x003e:
        r2 = move-exception;
        r4.close();	 Catch:{ all -> 0x003e }
        throw r2;	 Catch:{ all -> 0x003e }
    L_0x0043:
        r2 = move-exception;
        r3.close();	 Catch:{ all -> 0x0043 }
        throw r2;	 Catch:{ all -> 0x0043 }
    L_0x0048:
        r2 = move-exception;
        r2 = r0.exists();
        if (r2 == 0) goto L_0x0052;
    L_0x004f:
        r0.delete();
    L_0x0052:
        r0 = r1;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.file.MoreFileUtils.a(android.content.Context, android.os.ParcelFileDescriptor, java.lang.String):java.io.File");
    }

    private static MoreFileUtils m5032b(InjectorLike injectorLike) {
        return new MoreFileUtils(FileNativeLibrary.m5038a(injectorLike));
    }

    @Inject
    public MoreFileUtils(FileNativeLibrary fileNativeLibrary) {
        this.f3039a = fileNativeLibrary;
    }

    public static File m5027a(URI uri) {
        return new File(uri);
    }

    public static File m5026a(String str) {
        return new File(str);
    }

    public static File m5025a(File file, String str) {
        return new File(file, str);
    }

    public static InputStream m5028a(File file) {
        return new FileInputStream(file);
    }

    public final void m5035a(InputStream inputStream, File file) {
        try {
            new 1(this, inputStream).a(Files.a(file, new FileWriteMode[0]));
        } finally {
            inputStream.close();
        }
    }

    @VisibleForTesting
    public static void m5029a(CharSequence charSequence, File file) {
        Files.a(file, Charset.defaultCharset(), new FileWriteMode[0]).a(charSequence);
    }

    public static JarFile m5033b(File file) {
        return new JarFile(file);
    }

    public static boolean m5030a(Uri uri) {
        if (uri == null || !"file".equals(uri.getScheme())) {
            return false;
        }
        return uri.toString().startsWith(Uri.withAppendedPath(Uri.fromFile(Environment.getExternalStorageDirectory()), "").toString());
    }

    public final boolean m5036a(File file, final Predicate<String> predicate) {
        boolean z = true;
        File[] listFiles = file.listFiles(new FilenameFilter(this) {
            final /* synthetic */ MoreFileUtils f3066b;

            public boolean accept(File file, String str) {
                return predicate.apply(str);
            }
        });
        if (listFiles != null) {
            int i = 0;
            while (i < listFiles.length) {
                boolean delete = listFiles[i].delete() & z;
                i++;
                z = delete;
            }
        }
        return z;
    }

    public static boolean m5031a(File file, int i, String str, long j) {
        boolean z = false;
        if (file != null && file.exists() && file.isDirectory()) {
            Pattern pattern = null;
            if (str != null && str.length() > 0) {
                pattern = Pattern.compile(str);
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (!(file2 == null || file2.isDirectory())) {
                        CharSequence name = file2.getName();
                        if ((i <= 0 || i == name.length()) && ((r0 == null || r0.matcher(name).find()) && file2.length() >= j && file2.delete())) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    public final long m5037d(File file) {
        if (this.f3039a.ah_()) {
            return this.f3039a.nativeGetFolderSize(file.getAbsolutePath());
        }
        return m5034e(file);
    }

    private static long m5034e(File file) {
        Stack stack = new Stack();
        stack.push(file);
        long j = 0;
        while (!stack.isEmpty()) {
            long j2 = j;
            for (File file2 : ((File) stack.pop()).listFiles()) {
                try {
                    if (file2.getPath().equals(file2.getCanonicalPath())) {
                        if (file2.isDirectory()) {
                            stack.push(file2);
                        } else if (file2.isFile()) {
                            j2 += file2.length();
                        }
                    }
                } catch (IOException e) {
                }
            }
            j = j2;
        }
        return j;
    }
}
