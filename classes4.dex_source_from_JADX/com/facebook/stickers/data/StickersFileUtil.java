package com.facebook.stickers.data;

import android.content.Context;
import android.net.Uri;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.model.StickerAssetType;
import java.io.File;
import java.io.FileNotFoundException;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fa_unknown_pl_rate */
public class StickersFileUtil {
    public static final Class<?> f12353a = StickersFileUtil.class;
    private static volatile StickersFileUtil f12354c;
    public final Context f12355b;

    public static com.facebook.stickers.data.StickersFileUtil m13050a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12354c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.data.StickersFileUtil.class;
        monitor-enter(r1);
        r0 = f12354c;	 Catch:{ all -> 0x003a }
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
        r0 = m13053b(r0);	 Catch:{ all -> 0x0035 }
        f12354c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12354c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.data.StickersFileUtil.a(com.facebook.inject.InjectorLike):com.facebook.stickers.data.StickersFileUtil");
    }

    private static StickersFileUtil m13053b(InjectorLike injectorLike) {
        return new StickersFileUtil((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public StickersFileUtil(Context context) {
        this.f12355b = context;
    }

    private File m13051a(String str, String str2) {
        String str3 = null;
        if (this.f12355b.getExternalFilesDir(null) == null) {
            BLog.a(f12353a, "not external file dir");
        } else {
            File file = new File(this.f12355b.getExternalFilesDir(null), "stickers");
            m13052a(file);
            Object obj = file;
        }
        String str4 = str3;
        if (str4 == null) {
            return null;
        }
        File file2 = new File(new File(str4, str), str2);
        m13052a(file2);
        return file2;
    }

    public final File m13054a() {
        if (this.f12355b.getExternalFilesDir(null) == null) {
            BLog.a(f12353a, "not external file dir");
            return null;
        }
        File file = new File(this.f12355b.getExternalFilesDir(null), "stickers");
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        return null;
    }

    public static void m13052a(File file) {
        if (!file.exists() || !file.isDirectory()) {
            if (file.exists()) {
                BLog.a(f12353a, "%s is not a directory. deleting file and creating directory.", new Object[]{file});
                if (file.delete()) {
                    file.mkdirs();
                }
            } else if (file.mkdirs()) {
                return;
            }
            throw new FileNotFoundException("can't create " + file);
        }
    }

    public final File m13055a(String str, String str2, Uri uri, StickerAssetType stickerAssetType, boolean z) {
        File externalFilesDir;
        File file;
        String lastPathSegment = uri.getLastPathSegment();
        String str3 = "";
        if (lastPathSegment != null) {
            int lastIndexOf = lastPathSegment.lastIndexOf(".");
            if (lastIndexOf != -1) {
                lastPathSegment = lastPathSegment.substring(lastIndexOf);
                if (z) {
                    externalFilesDir = this.f12355b.getExternalFilesDir(null);
                    if (externalFilesDir != null) {
                        return null;
                    }
                    file = new File(new File(new File(externalFilesDir, "stickers"), str), str2);
                } else {
                    file = m13051a(str, str2);
                }
                if (file != null) {
                    return null;
                }
                return new File(file, stickerAssetType.getDbName() + lastPathSegment);
            }
        }
        lastPathSegment = str3;
        if (z) {
            externalFilesDir = this.f12355b.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                return null;
            }
            file = new File(new File(new File(externalFilesDir, "stickers"), str), str2);
        } else {
            file = m13051a(str, str2);
        }
        if (file != null) {
            return new File(file, stickerAssetType.getDbName() + lastPathSegment);
        }
        return null;
    }
}
