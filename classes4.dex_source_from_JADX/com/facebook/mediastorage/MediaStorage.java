package com.facebook.mediastorage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.google.common.io.Files;
import java.io.File;
import java.util.Random;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: facebook */
public class MediaStorage {
    private static final Class<?> f12349a = MediaStorage.class;
    private static volatile MediaStorage f12350d;
    private final MoreFileUtils f12351b;
    private final File f12352c;

    public static com.facebook.mediastorage.MediaStorage m13039a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12350d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.mediastorage.MediaStorage.class;
        monitor-enter(r1);
        r0 = f12350d;	 Catch:{ all -> 0x003a }
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
        r0 = m13043b(r0);	 Catch:{ all -> 0x0035 }
        f12350d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12350d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.mediastorage.MediaStorage.a(com.facebook.inject.InjectorLike):com.facebook.mediastorage.MediaStorage");
    }

    private static MediaStorage m13043b(InjectorLike injectorLike) {
        return new MediaStorage(MoreFileUtils.a(injectorLike), String_MediaStorageDirStringMethodAutoProvider.m13049a(injectorLike));
    }

    @Inject
    public MediaStorage(MoreFileUtils moreFileUtils, String str) {
        this.f12351b = moreFileUtils;
        this.f12352c = MoreFileUtils.a(Environment.getExternalStorageDirectory(), str);
    }

    public static boolean m13042a() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static boolean m13045b() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public final Uri m13047a(byte[] bArr) {
        Uri c = m13048c();
        try {
            Files.m11924a(bArr, new File(c.getPath()));
        } catch (Throwable e) {
            BLog.b(f12349a, "Unable to write to file ", e);
        }
        return c;
    }

    public final Uri m13046a(String str) {
        return m13038a("FB_VID", str);
    }

    public final Uri m13048c() {
        return m13038a("FB_IMG", ".jpg");
    }

    private synchronized Uri m13038a(String str, String str2) {
        File a;
        if (!this.f12352c.exists()) {
            this.f12352c.mkdirs();
        }
        Random random = new Random();
        do {
            a = MoreFileUtils.a(this.f12352c, m13041a(str, (System.currentTimeMillis() * 10000) + ((long) random.nextInt(9999)), str2));
        } while (a.exists());
        new StringBuilder("Next file to use for media: ").append(Uri.fromFile(a).getPath());
        return Uri.fromFile(a);
    }

    private static String m13041a(String str, long j, String str2) {
        return str + "_" + j + str2;
    }

    public static String m13040a(Uri uri, ContentResolver contentResolver) {
        Cursor cursor;
        Throwable th;
        if ("file".equals(uri.getScheme())) {
            return uri.getPath();
        }
        Cursor query;
        try {
            query = contentResolver.query(uri, new String[]{"_data"}, null, null, null);
            try {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                query.moveToFirst();
                String string = query.getString(columnIndexOrThrow);
                if (query == null) {
                    return string;
                }
                query.close();
                return string;
            } catch (Exception e) {
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static String m13044b(Uri uri, ContentResolver contentResolver) {
        Cursor cursor;
        Throwable th;
        if ("file".equals(uri.getScheme())) {
            return uri.getPath();
        }
        Cursor query;
        try {
            query = contentResolver.query(uri, new String[]{"_data"}, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                query.moveToFirst();
                String string = query.getString(columnIndexOrThrow);
                if (query == null) {
                    return string;
                }
                query.close();
                return string;
            } catch (Exception e) {
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }
}
